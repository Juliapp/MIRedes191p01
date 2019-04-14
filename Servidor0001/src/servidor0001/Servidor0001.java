package servidor0001;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import servidor0001.servidorFacade.ServidorFacade;

public class Servidor0001 {
    private ServerSocket serverSocket;
    //private ServidorFacade f;
        
    
    public static void main(String[] args){
        
        ServidorFacade f = new ServidorFacade();
        System.out.println("Cadastrando");
        String equipe1 = "RedBull";
        String equipe2 = "Tesla";
        String equipe3 = "Monster";
        String equipe4 = "Mustang";
        System.out.println(f.cadastrarEquipe(equipe1));
        System.out.println(f.cadastrarEquipe(equipe1));
        System.out.println(f.cadastrarEquipe(equipe2));        
        System.out.println(f.cadastrarEquipe(equipe3));        
        System.out.println(f.cadastrarEquipe(equipe4));        
        /*
        
        try {
            
            Servidor0001 server = new Servidor0001();
            server.criarServerSocket(12345);
                
            while(true){
                //Esse loop faz a coneão não se "quebrar" em apenas uma conexão
                Socket socket = server.esperandoConexao();
                server.tratarConexao(socket);
            }
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(Servidor0001.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        */
        
    }
    
    private void criarServerSocket(int porta) throws IOException{
        //cria um socket
        serverSocket = new ServerSocket(porta);
    }
    
    
    
    private Socket esperandoConexao() throws IOException{     
        //Faz o socket esperar uma conexão, só da o retorno quando a conexão não é estabelecida
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
             System.out.println("Mensagem Recebida: " + msg);
             output.writeUTF(msg);
             
             input.close();
             output.close();
             
        }catch(IOException e) {
            
        }finally{
            //idependente de erro ele fecha o socket
            fecharSocket(socket);
        }
        
    }
    
    private void fecharSocket(Socket s) throws IOException{
        s.close();
    }
    
    
    
}
    

