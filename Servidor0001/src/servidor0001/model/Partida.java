package servidor0001.model;

import java.util.ArrayList;
import java.util.Date;

public class Partida {
    private String id;
    private Date tempoTotal;
    private ArrayList<Participante> participantesDaCorrida;
    private Participante voltaMaisRapida;   

    public Partida() {
        participantesDaCorrida = new ArrayList<>();
    }
    
    public void addParticipante(Participante p){
        participantesDaCorrida.add(p);
    }
    
    public void MudaVoltaMaisRapida(Participante p){
        voltaMaisRapida = p;
    }
    
    
}
