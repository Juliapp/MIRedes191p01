package client0001;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client0001 {

    public static void main(String[] args) {
        try {
            
            //cria conexão entre o cliente e o servidor
            Socket socket = new Socket("localhost", 12345);
            
            //criação dos streams de entrada e de saída
            
            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            
            
        String msg = "hello";
        output.writeUTF(msg);

        msg = input.readUTF();
        System.out.println("Resposta: " + msg);

        //>>>>>>> Método pra usar depois do writeUTF
        output.flush();
        // Ele força a ler qualquer mensagem por completo            
            
            input.close();
            output.close();
            socket.close();
            
        } catch (IOException ex) {
            Logger.getLogger(Client0001.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    /*
    Ex: 
    String msg = 'hello'
    output.writeUTF(msg);
    
    msg = input.readUTF();
    System.out.println("Resposta: " + msg);
    
    //>>>>>>> Método pra usar depois do writeUTF
    output.flush();
    // Ele força a ler qualquer mensagem por completo
    
    
    */
}
