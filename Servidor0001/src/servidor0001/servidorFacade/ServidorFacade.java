package servidor0001.servidorFacade;

import java.util.ArrayList;
import servidor0001.controladores.ControladorFactory;
import servidor0001.controladores.ControladorCorrida;
import servidor0001.controladores.ControladorDeDados;
import servidor0001.execoes.PilotoNaoExisteException;
import servidor0001.model.Carro;
import servidor0001.model.Equipe;
import servidor0001.model.Piloto;

public class ServidorFacade {
    ControladorCorrida controladorCorrida;
    ControladorDeDados Dados;
    ControladorFactory cf;

    public ServidorFacade() {
        Dados = new ControladorDeDados();
    
    }
    
    
    
    
    // Primeira parte do Facade dedicada as funções de cadastro no jogo 
    
    public boolean cadastrarEquipe(String nome){
        return Dados.addEquipe(new Equipe(nome));
    }    
    
    public Equipe getEquipe(String nome){
        return Dados.getEquipe(nome);
    }       
    
    public boolean deleteEquipe(String nome){
        return Dados.deleteEquipe(nome);
    }    
    
    
    public boolean cadastrarCarro(String tag, String cor, String equipe){
        Equipe e = getEquipe(equipe);
        Carro c = cf.factoryC(tag, cor, e);
        e.addCarro(c);
        return Dados.addCarros(c);
    }
    
    public Carro getCarro(String tag){
        return Dados.getCarro(tag);
    }
    
    public boolean deleteCarro(String tag){
        return Dados.deleteCarro(tag);
    }        
    
    
     
    public boolean cadastrarPilogo(String nome, String foto) throws PilotoNaoExisteException{
        return Dados.addPiloto(cf.factoryP(nome, foto));
    }    
    
    public Equipe getPiloto(String nome){
        return Dados.getEquipe(nome);
    }     
    
    public boolean deletePiloto(String nome){
        return Dados.deletePiloto(nome);
    }        
    
    ////Pegando as listas
    
    public ArrayList<Piloto> getPilotos() {
        return Dados.getPilotos();
    }

    public ArrayList<Equipe> getEquipes() {
        return Dados.getEquipes();
    }

    public ArrayList<Carro> getCarros() {
        return Dados.getCarros();
    }
    
    //ainda falta decidir como vai icar as partidas
    
    //Segunda parte do Facade dedicado ao recebimento de dados do sensor
    
    //Terceira parte do Facade dedicado a partida
    
    
    
}
