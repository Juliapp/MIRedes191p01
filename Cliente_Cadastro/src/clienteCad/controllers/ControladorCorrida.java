package clienteCad.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import clienteCad.model.Carro;
import clienteCad.model.Equipe;
import clienteCad.model.Jogador;
import clienteCad.model.Piloto;

public class ControladorCorrida {

    ControladorDeDados cdd;
    private ArrayList<Jogador> participantes;

    public ControladorCorrida() {
        this.cdd = new ControladorDeDados();
        this.participantes = new ArrayList();
    }

    public boolean adicionaParticipantes(Piloto p, Carro c) {
        Jogador part = new Jogador(c, p);
        if (this.participantes.isEmpty()) {
            this.participantes.add(part);
        } else if (!hasParticipante(part)) {
            this.participantes.add(part);
        }
        return false;

    }

    public ArrayList<Jogador> getParticipantes() {
        return this.participantes;
    }

    public boolean hasParticipante(Jogador part) {
        return this.participantes.contains(part);
    }

}
