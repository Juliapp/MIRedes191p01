/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacao;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.execoes.PilotoNaoExisteException;
import servidor.model.Jogador;

/**
 *
 * @author Teeu Guima
 */
public class ControllerDeTratamento extends Thread {

    private ServidorFacade sf;

    private final ObjectOutputStream os;
    private final ObjectInputStream is;
    private final Socket recebido;

    public ControllerDeTratamento(Socket s, ObjectOutputStream os, ObjectInputStream is) {
        this.recebido = s;
        this.os = os;
        this.is = is;
        this.sf = ServidorFacade.getInstance();
    }

    public void trataMensagem() {

    }

    @Override
    public void run() {

        try {

            // Ask user what he wants 
            Mensagem msg = (Mensagem) is.readObject();

            switch (msg.getSolicitante()) {
                case ClienteCad:
                    switch (msg.getCommand()) {
                        case CadCarro:
                            String[] dadosCarro = (String[]) msg.getObject();

                            if (sf.cadastrarCarro(dadosCarro[0], dadosCarro[1], dadosCarro[2])) {
                                this.os.writeUTF("Carro Cadastrado");
                                this.os.flush();
                            }
                            break;

                        case IterarCarros:
                            Object arrayCarros = (Object) sf.getListaDeCarros();
                            if (arrayCarros != null) {
                                this.os.writeObject(arrayCarros);
                                this.os.flush();
                            }
                            break;
                        case CadPiloto:
                            String[] dadosPiloto = (String[]) msg.getObject();
                            if (sf.cadastrarPiloto(dadosPiloto[0], null)) {
                                this.os.writeUTF("Piloto Cadastrado");
                                this.os.flush();
                            }
                            break;
                        case CadJogador:
                            String[] dadosJogador = (String[]) msg.getObject();
                            if(sf.CadastrarJogador(dadosJogador[0], dadosJogador[1])){
                                this.os.writeUTF("Jogador Cadastrado");
                                this.os.flush();
                            }
                            break;
                        
                        
                    }

                    break;
                case ClienteExib:
                    break;
                case Sensor:
                    break;
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } catch (PilotoNaoExisteException ex) {
            Logger.getLogger(ControllerDeTratamento.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            // closing resources 
            this.is.close();
            this.os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
