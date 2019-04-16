package servidor.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ColetorRFID extends Thread{
    private Socket rfidSocket;

    public ColetorRFID(Socket rfidSocket) {
        this.rfidSocket = rfidSocket;
    }
    
    
    
    @Override
    public void run(){
        
        while(true){
         
            try ( ObjectInputStream input = new  ObjectInputStream( rfidSocket.getInputStream() ); ) {
                
             Object msg = input.readUTF();                
                

                
            } catch (IOException ex) {
                Logger.getLogger(ColetorRFID.class.getName()).log(Level.SEVERE, null, ex);
            }



        }
        
        
        
    }
    
    
    
}
