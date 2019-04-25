package clienteCad.controllers;

import java.util.List;
import clienteCad.model.Carro;
import clienteCad.model.Equipe;
import clienteCad.model.Jogador;
import clienteCad.model.Piloto;

public class ControladorFactory {

    public Carro factoryC(String tag, String cor, Equipe e){
        return new Carro(tag, cor, e);
    }    
    
    public Equipe factoryE(String nome){
        return new Equipe(nome);
    }
    
    public Piloto factoryP(String nome, String foto){
        return new Piloto(nome, foto);
    }
    
    public Jogador factoryPar(Carro c, Piloto p) {
        return new Jogador(c, p);
    }
    
    
    
}
