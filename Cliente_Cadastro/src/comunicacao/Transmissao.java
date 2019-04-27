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

/**
 *
 * @author Teeu Guima
 */
public class Transmissao {

    public Socket solicitaSocket() throws IOException {
        return new Socket("localhost", 5555);
    }

    public void enviaMensagem(Mensagem obj) throws IOException, ClassNotFoundException {
        Socket socket = solicitaSocket();
        Object objeto = (Object) obj;

        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

        os.writeObject(objeto);
        os.flush();

        System.out.println(is.readUTF());
        os.close();
        is.close();
        socket.close();

    }

    public Object solicitaMensagem(Mensagem msg) throws IOException, ClassNotFoundException {
        Object objeto = (Object) msg;
        Socket socket = solicitaSocket();
        ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream is = new ObjectInputStream(socket.getInputStream());

        os.writeObject(objeto);
        os.flush();
        
        os.close();
        is.close();
        socket.close();

        return is.readObject();
    }

}
