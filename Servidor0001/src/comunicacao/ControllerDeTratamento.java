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

                // Ask user what he wants 
                Mensagem msg = (Mensagem) is.readObject();
                if (msg.getCommand().CadCarro == Command.CadCarro) {
                    this.os.writeUTF("Carro Cadastrado");
                    this.os.flush();

                }

            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            break;
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
