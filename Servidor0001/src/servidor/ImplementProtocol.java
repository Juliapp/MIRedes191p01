/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import servidor.model.Mensagem;
import servidor.util.Command;

/**
 *
 * @author Teeu Guima
 */
public class ImplementProtocol implements Runnable {

    private Socket conexao;
    private Mensagem msg;

    public ImplementProtocol(Socket socket) throws IOException, ClassNotFoundException {
        this.conexao = socket;
        this.msg = deserializarObjeto();
    }

    private Mensagem deserializarObjeto() throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream is = new ObjectInputStream(this.conexao.getInputStream());
            ByteArrayOutputStream bytes = new ByteArrayOutputStream();

            ObjectOutputStream os = new ObjectOutputStream(bytes);
            try {
                os.writeObject(((ObjectInputStream) is).readObject());

                bytes.toByteArray();
                return this.deserializarMensagem(bytes.toByteArray());
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private Mensagem deserializarMensagem(byte[] data) throws ClassNotFoundException {
        ByteArrayInputStream mensagem = new ByteArrayInputStream(data);

        try {
            ObjectInputStream reader = new ObjectInputStream(mensagem);
            return (Mensagem) reader.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }
    
    @Override
    public void run() {
        if(this.msg instanceof Mensagem){
            Mensagem msgm = (Mensagem) this.msg;
            if(msgm.getCommand().CadParticipante == Command.CadParticipante){
                
            }
        }


    }
}
