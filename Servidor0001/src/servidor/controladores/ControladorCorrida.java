package servidor.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import servidor.model.Carro;
import servidor.model.Participante;
import servidor.util.ColetorRFID;

public class ControladorCorrida {
    private ArrayList<Participante> participantes;
    private String id;
    private Date tempoTotal;
    private Participante voltaMaisRapida; 
    
    
    
    public ControladorCorrida(ArrayList<Participante> participantes, Date tempoTotal) {
        this.participantes = participantes;
        this.tempoTotal = tempoTotal;
    }
     


    private boolean hasCarro(String tag){
        Carro c;
        Iterator<Participante> it = participantes.iterator();
        while (it.hasNext()) {
            c = it.next().getCarro();
            if(c.equals(tag)) { return true; }
        }
        return false;
    }
    

    
    public void comecarCorrida(){
        
    }
    
    public void ordenaCorrida(){
        
    }
    
    
    
    
    
}
