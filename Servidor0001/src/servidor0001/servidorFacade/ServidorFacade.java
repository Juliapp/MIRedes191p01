package servidor0001.servidorFacade;

import java.util.ArrayList;
import servidor0001.controladores.ControladorFactory;
import servidor0001.controladores.ControladorCorrida;
import servidor0001.controladores.ControladorDeDados;
import servidor0001.model.Carro;
import servidor0001.model.Equipe;
import servidor0001.model.Piloto;

public class ServidorFacade {
    ControladorCorrida controladorCorrida;
    ControladorDeDados controladorDados;
    ControladorFactory cf;
    
    
    // Primeira parte do Facade dedicada as funções de cadastro no jogo 
    
    public void cadastrarEquipe(String nome){
        controladorDados.addEquipe(cf.factoryE(nome));
    }    
    
    public Equipe getEquipe(String nome){
        return controladorDados.getEquipe(nome);
    }       
    
    public void cadastrarCarro(double tag, String cor, Equipe e){
        Carro c = cf.factoryC(tag, cor, e);
        controladorDados.addCarros(c);
        e.addCarro(c);
    }
    
    public Carro getCarro(double tag){
        return controladorDados.getCarro(tag);
    }
     
    public void cadastrarPilogo(String nome, String foto){
        controladorDados.addPiloto(cf.factoryP(nome, foto));
    }    
    
    public Equipe getPiloto(String nome){
        return controladorDados.getEquipe(nome);
    }     
    
    
    ////Pegando as listas
    
    public ArrayList<Piloto> getPilotos() {
        return controladorDados.getPilotos();
    }

    public ArrayList<Equipe> getEquipes() {
        return controladorDados.getEquipes();
    }

    public ArrayList<Carro> getCarros() {
        return controladorDados.getCarros();
    }
    
    //ainda falta decidir como vai icar as partidas
    
    //Segunda parte do Facade dedicado ao recebimento de dados do sensor
    
    //Terceira parte do Facade dedicado a partida
    
    
    
}
