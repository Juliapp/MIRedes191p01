package cliente1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Partida implements Serializable {
    private String id;
    private Date tempoTotal;
    private ArrayList<Participante> participantes;
    private Participante voltaMaisRapida;   

    public Partida() {
        participantes = new ArrayList<>();
    }
    
    public void addParticipante(Participante p){
        participantes.add(p);
    }
    
    public void MudaVoltaMaisRapida(Participante p){
        voltaMaisRapida = p;
    }
    
    
}
