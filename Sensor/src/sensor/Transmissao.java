/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Teeu Guima
 */
public class Transmissao {
    
    private Object dadoRecebido;
    public Socket solicitaSocket() throws IOException {
        return new Socket("localhost", 5555);
    }

    public void enviaMensagem(Mensagem obj) throws IOException, ClassNotFoundException {
        try (Socket socket = solicitaSocket()) {
            Object objeto = (Object) obj;
            
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            
            os.writeObject(objeto);
            os.flush();
            
            
            os.reset();
            os.close();
            is.close();
        }
       

    }
    
    public void recebeMensagem(){
        try(Socket socket = solicitaSocket()) {
            ObjectOutputStream os = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream is = new ObjectInputStream(socket.getInputStream());
            
            this.dadoRecebido = is.readObject();
            
            os.close();
            is.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean dadoRecebido(){
        return (boolean) this.dadoRecebido;
    }

    
    
    

}
