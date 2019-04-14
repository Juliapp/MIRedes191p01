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
    
    
    
    public boolean addPiloto(Piloto p) throws PilotoNaoExisteException{
        if(!hasPiloto(p.getNome())) { 
            return pilotos.add(p); 
        }
        return false;
    }
    
    public boolean hasPiloto(String nome) throws PilotoNaoExisteException {
        return pilotos.contains(nome); //Exceção não contem piloto
        
    }
    
    public Iterator<Piloto> itPiloto(){
        return pilotos.iterator();
    }
    
    public Piloto getPiloto(String n){
        Piloto p;
        while(itPiloto().hasNext()){
            p = itPiloto().next();
            if(p.equals(n)) { return p; }
        }      
        return null; //jogar exceção piloto não existe
    }
    
    public boolean deletePiloto(String nome){
        return pilotos.remove(nome);
    }
    
    public ArrayList<Piloto> getPilotos() {
        return pilotos;
    }
    
    
    
    
    public boolean addEquipe(Equipe e){
        if(!hasEquipe(e.getNome())) { 
            return equipes.add(e); 
        }
        return false;
    }
    
    public boolean hasEquipe(String nome) { 
        while(itEquipe().hasNext()){
            Equipe e = itEquipe().next();
            System.out.println(e.getNome());
        }
        
        return equipes.contains(nome);
    }
    
    public Iterator<Equipe> itEquipe(){
        return equipes.iterator();
    }
    
    public Equipe getEquipe(String n){
        Equipe e;
        while(itEquipe().hasNext()){
            e = itEquipe().next();
            if(e.equals(n)) { return e; }
        }      
        return null; //jogar exceção piloto não existe
    }
    
    public boolean deleteEquipe(String nome){
       return equipes.remove(nome);
    }
    
    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }
    
    
    
    public boolean addCarros(Carro c){
        if(!hasCarro(c.getTag())) { 
            return carros.add(c); 
        }
        return false;
    }
    
    public boolean hasCarro(String tag){
        return pilotos.contains(tag); //Exceção não contem piloto
    }
    
    public Iterator<Carro> itCarro(){
        return carros.iterator();
    }
    
    public Carro getCarro(String tag){
        Carro c;
        while(itCarro().hasNext()){
            c = itCarro().next();
            if(c.equals(tag)) { return c; }
        }      
        return null; //jogar exceção piloto não existe
    }   
    
    public boolean deleteCarro(String tag){
        return carros.remove(tag);
    }
    

    public ArrayList<Carro> getCarros() {
        return carros;
    }
    
    
    
    
    
}
