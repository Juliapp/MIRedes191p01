package cliente1.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import cliente1.model.Carro;
import cliente1.model.Equipe;
import cliente1.model.Participante;
import cliente1.model.Piloto;

public class ControladorDeDados {

    private ArrayList<Piloto> pilotos;
    private ArrayList<Equipe> equipes;
    private ArrayList<Carro> carros;
    private ArrayList<Participante> participantes;
    //hash map de partidas

    public ControladorDeDados() {
        this.pilotos = new ArrayList<>();
        this.equipes = new ArrayList<>();
        this.carros = new ArrayList<>();
        this.participantes = new ArrayList<>();
    }
    
    

    public Piloto addPiloto(String nome, String foto) {
        Piloto p = new Piloto(nome, null);
        if (this.pilotos.isEmpty()) {
            this.pilotos.add(p);
            return p;
        } else if (!hasPiloto(p)) {
            pilotos.add(p);
            return p;
        } else {
            return null;
        }
    }

    public boolean hasPiloto(Piloto p) {
        return pilotos.contains(p); //Exceção não contem piloto
    }

    public Iterator<Piloto> itPiloto() {
        return pilotos.iterator();
    }

    public Piloto getPiloto(String n) {
        Piloto p;
        while (itPiloto().hasNext()) {
            p = itPiloto().next();
            if (p.equals(n)) {
                return p;
            }
        }
        return null; //jogar exceção piloto não existe
    }

    public Equipe addEquipe(String nome) {
        Equipe e = new Equipe(nome);
        if (this.equipes.isEmpty()) {
            this.equipes.add(e);
            return e;
        } else if (!hasEquipe(e)) {
            equipes.add(e);
            return e;
        } else {
            return null;
        }
    }

    public boolean hasEquipe(Equipe e) {
        return equipes.contains(e); //Exceção não contem piloto
    }

    public Iterator<Equipe> itEquipe() {
        return equipes.iterator();
    }

    public Equipe getEquipe(String n) {
        Equipe e;
        while (itEquipe().hasNext()) {
            e = itEquipe().next();
            if (e.equals(n)) {
                return e;
            }
        }
        return null; //jogar exceção piloto não existe
    }

    public Carro addCarros(String tag, String cor, Equipe e) {
        Carro c = new Carro(tag, cor, e);
        if (this.carros.isEmpty()) {
            this.carros.add(c);
            return c;
        } else if (!hasCarro(c)) {
            carros.add(c);
            return c;
        } else {
            return null;
        }

    }

    public boolean hasCarro(Carro c) {
        //Exceção não contem piloto
        return this.carros.contains(c);

    }

    public Iterator<Carro> itCarro() {
        return carros.iterator();
    }

    public Carro getCarro(String tag) {
        Carro c;
        while (itCarro().hasNext()) {
            c = (Carro) itCarro().next();
            if (c.getTag().equals(tag)) {
                return c;
            }
        }
        return null; //jogar exceção piloto não existe
    }

    public Carro getCarroPorCor(String cor) {
        Carro c;
        while (itCarro().hasNext()) {
            c = (Carro) itCarro().next();
            if (c.getCor().equals(cor)) {
                return c;
            }
        }
        return null;
    }

    public void addParticipantes(Carro c, Piloto p) {
        Participante part = new Participante(c, p);
        if (!hasParticipantes(part)) {
            this.participantes.add(part);
        }
    }

    public boolean hasParticipantes(Participante part) {
        return this.participantes.contains(part);
    }

    public Iterator itParticipantes() {
        return this.participantes.iterator();
    }

    public Participante getParticipantes(String nome) {
        while (itPiloto().hasNext()) {
            Piloto p = (Piloto) itPiloto().next();
            if (p.getNome().equals(nome)) {
                while (itParticipantes().hasNext()) {
                    Participante part = (Participante) itParticipantes().next();
                    if (part.getPiloto().equals(p)) {
                        return part;
                    }

                }
                return null;
            }

        }
        return null;
    }

    public ArrayList<Participante> getParticipantes() {
        return participantes;
    }

    public ArrayList<Piloto> getPilotos() {
        return pilotos;
    }

    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }

    public ArrayList<Carro> getCarros() {
        return carros;
    }

}
