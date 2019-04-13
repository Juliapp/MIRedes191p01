package servidor0001.servidorFacade;

import java.util.ArrayList;
import cliente1.controllers.ControladorFactory;
import cliente1.controllers.ControladorCorrida;
import cliente1.controllers.ControladorDeDados;
import cliente1.model.Carro;
import cliente1.model.Equipe;
import cliente1.model.Piloto;

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
    
    public void cadastrarCarro(String tag, String cor, Equipe e){
        Carro c = cf.factoryC(tag, cor, e);
        controladorDados.addCarros(c);
        e.addCarro(c);
    }
    
    public Carro getCarro(String tag){
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
