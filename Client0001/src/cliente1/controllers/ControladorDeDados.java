package cliente1.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import cliente1.model.Carro;
import cliente1.model.Equipe;
import cliente1.model.Piloto;

public class ControladorDeDados {
    private ArrayList<Piloto> pilotos;
    private ArrayList<Equipe> equipes;
    private ArrayList<Carro> carros;
    //hash map de partidas
    
    
    public void addPiloto(Piloto p){
        if(!hasPiloto(p.getNome())) { 
            pilotos.add(p); 
        }
    }
    
    public boolean hasPiloto(String nome){
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
    
    
    
    
    
    public void addEquipe(Equipe e){
        if(!hasEquipe(e.getNome())) { 
            equipes.add(e); 
        }
    }
    
    public boolean hasEquipe(String nome){
        return equipes.contains(nome); //Exceção não contem piloto
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
    
    
    
    
    
    
    public void addCarros(Carro c){
        if(!hasCarro(c.getTag())) { 
            carros.add(c); 
        }
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
            c = (Carro) itCarro().next();
            if(c.getTag().equals(tag)) { return c; }
        }      
        return null; //jogar exceção piloto não existe
    }
    
    public Carro getCarroPorCor(String cor){
        Carro c;
        while(itCarro().hasNext()){
            c = (Carro) itCarro().next();
            if(c.getCor().equals(cor)){
                return c;
            }
        }
        return null;
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
