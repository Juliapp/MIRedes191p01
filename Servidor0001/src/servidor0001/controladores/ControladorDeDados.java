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
    
    
    
    public void addPiloto(Piloto p) throws PilotoNaoExisteException{
        if(!hasPiloto(p.getNome())) { 
            pilotos.add(p); 
        }
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
    
    
    
    
    public void addEquipe(Equipe e){
        if(!hasEquipe(e.getNome())) { 
            equipes.add(e); 
        }

                
    }
    
    public boolean hasEquipe(String nome) {       
        return getEquipe(nome) != null ? true : false;
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
    
    
    
    public void addCarros(Carro c){
        if(!hasCarro(c.getTag())) { 
            carros.add(c); 
        }
    }
    
    public boolean hasCarro(double tag){
        return pilotos.contains(tag); //Exceção não contem piloto
    }
    
    public Iterator<Carro> itCarro(){
        return carros.iterator();
    }
    
    public Carro getCarro(double tag){
        Carro c;
        while(itCarro().hasNext()){
            c = itCarro().next();
            if(c.equals(tag)) { return c; }
        }      
        return null; //jogar exceção piloto não existe
    }   
    
    public boolean deleteCarro(double tag){
        return carros.remove(tag);
    }
    

    public ArrayList<Carro> getCarros() {
        return carros;
    }
    
    
    
    
    
}
