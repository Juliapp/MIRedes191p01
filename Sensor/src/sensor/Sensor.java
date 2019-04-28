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
import java.util.ArrayList;

/**
 *
 * @author Teeu Guima
 */
public class Sensor {

    private final int tempo = 10000;
    private String[] tags = {"EPC00000", "EPC00001", "EPC00002", "EPC00003"};
    private int count=0;
    private Transmissao transm;
    
    public Sensor(){
        this.transm = new Transmissao();
    }
    
    public void lançaTags() throws IOException, ClassNotFoundException{
        while(true){
            while(this.count <= this.tempo){
                count++;
            }
            if(count == this.tempo){
                Mensagem msg = new Mensagem(Command.EnviarTags, tags, Solicitante.Sensor);
                transm.enviaMensagem(msg);
                this.count=0;
            }
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Sensor sensor = new Sensor();
        try {
             sensor.lançaTags();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
       
        
        
    }

}
