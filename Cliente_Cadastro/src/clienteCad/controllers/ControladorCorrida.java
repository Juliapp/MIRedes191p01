package clienteCad.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import clienteCad.model.Carro;
import clienteCad.model.Equipe;
import clienteCad.model.Participante;
import clienteCad.model.Piloto;

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
