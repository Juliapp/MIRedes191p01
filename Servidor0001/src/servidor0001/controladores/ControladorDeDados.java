package servidor0001.controladores;

import java.util.ArrayList;
import java.util.Iterator;
import servidor0001.execoes.PilotoNaoExisteException;
import servidor0001.model.Carro;
import servidor0001.model.Equipe;
import servidor0001.model.Participante;
import servidor0001.model.Piloto;


public class ControladorDeDados {
    private ArrayList<Piloto> pilotos;
    private ArrayList<Equipe> equipes;
    private ArrayList<Carro> carros;
    private ArrayList<Participante> participantes;
    //hash map de partidas

    public ControladorDeDados() {
        pilotos = new ArrayList<>();
        equipes = new ArrayList<>();
        carros  = new ArrayList<>();    
        participantes = new ArrayList<>();
    }    
    

    public boolean addPiloto(Piloto p) {
        if (this.pilotos.isEmpty()) {
            this.pilotos.add(p);
        } else if (!hasPiloto(p.getNome())) {
            pilotos.add(p);
        } else {
            return false;
        }      
        return true;
    }

    public boolean hasPiloto(String n) {
        Piloto p;
        Iterator<Piloto> it = itPiloto();
        while (it.hasNext()) {
            p = it.next();
            if(p.equals(n)){ return true; }
        }
        return false; //jogar exceção piloto não existe
    }

    public Iterator<Piloto> itPiloto() {
        return pilotos.iterator();
    }

    public Piloto getPiloto(String nome) {
        if(hasPiloto(nome)){
            return pilotos.get(getIndexPiloto(nome));
        }
        return null; //jogar exceção piloto não existe
    }
    
    public int getIndexPiloto(String nome){
        Piloto p;
        Iterator<Piloto> it = itPiloto();
        int i = 0;
        while (it.hasNext()){
            p = it.next();
            if(p.equals(nome)){ return i; }
            i++;
        }
        return 0;
    }
    
    public boolean deletePiloto(String nome) {
        if(hasPiloto(nome)){
            pilotos.remove(getIndexPiloto(nome));
            return true;
        }
        return false;
    }
    
    public void listarPilotos() {
        Piloto p;
        Iterator<Piloto> it = itPiloto();
        while (it.hasNext()) {
            p = it.next();
            System.out.println(p.getNome());
        }
    }
    

    
    
    public boolean addEquipe(Equipe e) {
        if (this.equipes.isEmpty()) {
            this.equipes.add(e);
        } else if (!hasEquipe(e.getNome())) {
            equipes.add(e);
        } else {
            return false;
        }
        return true;
    }

    public boolean hasEquipe(String n) {
        Equipe e;
        Iterator<Equipe> it = itEquipe();
        while (it.hasNext()) {
            e = it.next();
            if (e.equals(n)) { return true; }
        }   
        return false;
    }

    public Iterator<Equipe> itEquipe() {
        return equipes.iterator();
    }

    public Equipe getEquipe(String nome) {
        if(hasEquipe(nome)){
            return equipes.get(getIndexEquipe(nome));
        }
        return null;
    }
    
    public int getIndexEquipe(String nome){
        Equipe e;
        Iterator<Equipe> it = itEquipe();
        int i = 0;
        while (it.hasNext()){
            e = it.next();
            if(e.equals(nome)){ return i; }
            i++;
        }
        return 0;
    }
    
    public void listarEquipes() {
        Equipe e;
        Iterator<Equipe> it = itEquipe();
        while (it.hasNext()) {
            e = it.next();
            System.out.println(e.getNome());
        }        
    }
    
    public boolean deleteEquipe(String nome) {
        if(hasEquipe(nome)){
            equipes.remove(getIndexEquipe(nome));
            return true;
        }
        return false;
    }
    
    
    

    public boolean addCarro(Carro c) {
        if (this.carros.isEmpty()) {
            this.carros.add(c);
        } else if (!hasCarro(c.getTag())) {
            carros.add(c);
        } else {
            return false;
        }
        return true;
    }

    public boolean hasCarro(String tag) {
        Carro c;
        Iterator<Carro> it = itCarro();
        while (it.hasNext()) {
            c = it.next();
            if(c.equals(tag)) { return true; }
        }
        return false;
    }

    public Iterator<Carro> itCarro() {
        return carros.iterator();
    }

    public Carro getCarro(String tag) {
        if(hasCarro(tag)){
           return carros.remove(getIndexCarro(tag));
        }
        return null;
    }
    
    public int getIndexCarro(String tag){
        Carro c;
        Iterator<Carro> it = itCarro();
        int i = 0;
        while (it.hasNext()){
            c = it.next();
            if(c.equals(tag)){ return i; }
            i++;
        }
        return 0; 
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
    
    public boolean deleteCarro(String tag) {
        if(hasCarro(tag)){
           carros.remove(getIndexCarro(tag));
           return true;
        }
        return false;
    }
    
    public void listarCarros() {
        Carro c;
        Iterator<Carro> it = itCarro();
        while (it.hasNext()) {
            c = it.next();
            System.out.println(c.getTag());
        }
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
    
