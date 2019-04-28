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
import execoes.PilotoNaoExisteException;
import model.Jogador;
import model.PreConfigCorrida;

/**
 *
 * @author Teeu Guima
 */
public class ControllerDeTratamento extends Thread {

    private ServidorFacade servidorFacade;

    private final ObjectOutputStream os;
    private final ObjectInputStream is;
    private final Socket recebido;

    public ControllerDeTratamento(Socket s, ObjectOutputStream os, ObjectInputStream is) {
        this.recebido = s;
        this.os = os;
        this.is = is;
        this.servidorFacade = ServidorFacade.getInstance();
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
                            
                            //nessa parte ele tem que pegar do coletor
                            
                            if (servidorFacade.cadastrarCarro(dadosCarro[0], dadosCarro[1], dadosCarro[2])) {
                                this.os.writeUTF("Carro Cadastrado");
                                this.os.flush();
                            }
                            break;

                        case IterarCarros:
                            Object arrayCarros = (Object) servidorFacade.getListaDeCarros();
                            if (arrayCarros != null) {
                                this.os.writeObject(arrayCarros);
                                this.os.flush();
                            }
                            break;
                        case CadPiloto:
                            String dadosPiloto =  (String) msg.getObject();
                            if (servidorFacade.cadastrarPiloto(dadosPiloto, null)) {
                                this.os.writeUTF("Piloto Cadastrado");
                                this.os.flush();
                            }
                            break;
                        case CadJogador:
                            String[] dadosJogador = (String[]) msg.getObject();
                            int id = Integer.parseInt(dadosJogador[0]);
                            if(servidorFacade.CadastrarJogador(id, dadosJogador[1])){
                                this.os.writeUTF("Jogador Cadastrado");
                                this.os.flush();
                            }
                            break;
                        case ComecarCorrida:
                            servidorFacade.comecarCorrida();
                            
                            break;
                        case IterarJogadores:
                            Object arrayJogadores = (Object) servidorFacade.getListaDeJogadores();
                            if(arrayJogadores != null){
                                this.os.writeObject(arrayJogadores);
                                this.os.close();
                            }else{
                                String erroinfo = "Erro no array";
                                this.os.writeObject(erroinfo);
                                this.os.close();
                            }
                            
                            break;
                        case PreConfiguracaoCorrida:
                            if(msg.getObject() instanceof PreConfigCorrida){
                                PreConfigCorrida preCor = (PreConfigCorrida) msg.getObject();
                                servidorFacade.novaCorrida(preCor.getIdDosJogadores(), preCor.getQuantidadeVoltas());
                            }
                            break;
                    }

                    break;
                case ClienteExib:
                    break;
                case Sensor:
                    
                    //sf.coletorDeTags(tag, tempoColetado);
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
