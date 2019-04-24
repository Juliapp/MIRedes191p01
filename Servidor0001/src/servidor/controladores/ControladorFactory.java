package servidor.controladores;

import java.util.List;
import servidor.model.Carro;
import servidor.model.Equipe;
import servidor.model.Jogador;
import servidor.model.Piloto;

/**
 *
 * @author juli
 */
public class ControladorFactory {

    /**
     *
     */
    public ControladorFactory() {} 
    
    /**
     *
     * @param tag
     * @param cor
     * @param e
     * @return
     */
    public Carro factoryC(String tag, String cor, Equipe e){
        return new Carro(tag, cor, e);
    }    
    
    /**
     *
     * @param nome
     * @return
     */
    public Equipe factoryE(String nome){
        return new Equipe(nome);
    }
    
    /**
     *
     * @param nome
     * @param foto
     * @return
     */
    public Piloto factoryP(String nome, String foto){
        return new Piloto(nome, foto);
    }
    
    /**
     *
     * @param c
     * @param p
     * @return
     */
    public Jogador factoryJog(Carro c, Piloto p) {
        return new Jogador(c, p);
    }
    
    
    
}
