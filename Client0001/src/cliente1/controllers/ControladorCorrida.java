package cliente1.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import cliente1.model.Carro;
import cliente1.model.Equipe;
import cliente1.model.Participante;
import cliente1.model.Piloto;

public class ControladorCorrida {
    ControladorDeDados cdd;
    private ArrayList<Participante> participantes;
    public ControladorCorrida() {
        this.cdd = new ControladorDeDados();
        this.participantes = new ArrayList();
    }
    
    public void adicionaParticipantes(Piloto p, Carro c){
        Participante part = new Participante(c, p);
        
        this.participantes.add(part);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
}
