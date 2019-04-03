package servidor0001;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor0001 {
    private ServerSocket serverSocket;

    public static void main(String[] args){
        
        try {
            Servidor0001 server = new Servidor0001();
            server.criarServerSocket(12345);
            Socket socket = server.esperaConexao();
            server.tratarConexao(socket);
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor0001.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private void criarServerSocket(int porta) throws IOException{
        serverSocket = new ServerSocket(porta);
    }
    
    private Socket esperaConexao() throws IOException{
        //Faz o socket esperar uma conexão
        Socket socket = serverSocket.accept();
        return socket;
    }
    
    private void tratarConexao(Socket socket) throws IOException{
        //Ponto entre o cliente e o servidor
        try{
            
             ObjectInputStream input = new  ObjectInputStream( socket.getInputStream() );
             ObjectOutputStream output = new ObjectOutputStream( socket.getOutputStream() );
             
             // pode usar o input.readObject pra pegar um obj do cliente
             
             String msg = input.readUTF();
             System.out.println("Mensagem Recebida");
             output.writeUTF(msg);
             
             input.close();
             output.close();
        }catch(IOException e) {
            
        }finally{
            //idependente de erro ele fecha o socket
            fechaSocket(socket);
        }
        
    }
    
    private void fechaSocket(Socket s) throws IOException{
        s.close();
    }
}
    

