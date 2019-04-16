package cliente1.controllers;

import java.util.List;
import cliente1.model.Carro;
import cliente1.model.Equipe;
import cliente1.model.Participante;
import cliente1.model.Piloto;

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
    
    public Participante factoryPar(Carro c, Piloto p) {
        return new Participante(c, p);
    }
    
    
    
}
