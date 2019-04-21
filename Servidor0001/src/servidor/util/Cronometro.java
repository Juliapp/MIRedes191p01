package servidor.util;

import java.util.logging.Level;
import java.util.logging.Logger;
import servidor.model.Time;

public class Cronometro extends Thread{
    private Time cronometro;
    private boolean rodando;

    public Cronometro() {
        cronometro = new Time();
        rodando = false;
    }

    public Time getCronometro() {
        return cronometro;
    }

    public boolean isRodando() {
        return rodando;
    }
    
    
    @Override
    public void run(){
        while(rodando){
            try {
                Thread.sleep(1);
                conta();
            } catch (InterruptedException ex) {
                Logger.getLogger(Cronometro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    
    public void comecar(){
        rodando = true;
        this.run();
    }
    
    public void parar(){
        rodando = false;
    }
    
    public Time getCurrentTime(){
        return cronometro.getCurrentTime();
    }
    
    
    public void conta(){
        if(cronometro.getMilisegundos() < 999){
            cronometro.incrementaMilisegundos();
        }else if(cronometro.getSegundos() < 59){ 
            cronometro.incrementaSegundos();
            cronometro.setMilisegundos(0);
        }else if(cronometro.getMinutos() < 59){ 
            cronometro.incrementaMinutos();
            cronometro.setSegundos(0);
            cronometro.setMilisegundos(0);
        }else{ 
            cronometro.incrementaHoras();
            cronometro.setMinutos(0);
            cronometro.setSegundos(0);
            cronometro.setMilisegundos(0);
        }
        
    }
    
    
}
