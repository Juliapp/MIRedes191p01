package servidor0001.controladores;

import java.util.List;
import servidor0001.model.Carro;
import servidor0001.model.Equipe;
import servidor0001.model.Participante;
import servidor0001.model.Piloto;

public class ControladorFactory {

    public ControladorFactory() {} 
    
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
