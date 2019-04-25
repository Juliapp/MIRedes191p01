/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.execoes.PilotoNaoExisteException;
import servidor.model.Jogador;
import servidor.model.Mensagem;
import servidor.util.Command;

/**
 *
 * @author Teeu Guima
 */
public class ControllerDeTratamento extends Thread {

    private ServidorFacade sf;

    final ObjectOutputStream os;
    final ObjectInputStream is;
    final Socket recebido;

    public ControllerDeTratamento(Socket s, ObjectOutputStream os, ObjectInputStream is) {
        this.recebido = s;
        this.os = os;
        this.is = is;
        this.sf = new ServidorFacade();
    }

    public void trataMensagem() {

    }

    @Override
    public void run() {
      
        while (true) {
            try {
                String[] dados = (String[]) is.readObject();

                sf.cadastrarCarro(dados[0], dados[1], dados[2]);
                os.writeUTF("Carro Cadastrado");

            } catch (IOException ex) {
                Logger.getLogger(ControllerDeTratamento.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ControllerDeTratamento.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }
}
