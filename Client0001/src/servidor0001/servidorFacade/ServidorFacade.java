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

    public ServidorFacade() {
        this.controladorCorrida = new ControladorCorrida();
        this.controladorDados = new ControladorDeDados();
        this.cf = new ControladorFactory();
    }

    // Primeira parte do Facade dedicada as funções de cadastro no jogo 
    public Equipe cadastrarEquipe(String nome) {
        Equipe e = cf.factoryE(nome);
        controladorDados.addEquipe(e);
        return e;
    }

    public Equipe getEquipe(String nome) {
        return controladorDados.getEquipe(nome);
    }

    public Carro cadastrarCarro(String tag, String cor, Equipe e) {
        Carro c = cf.factoryC(tag, cor, e);
        controladorDados.addCarros(c);
        e.addCarro(c);
        return c;
    }

    public Carro getCarro(String tag) {
        return controladorDados.getCarro(tag);
    }
  

    public Piloto cadastrarPiloto(String nome, String foto) {
        Piloto p = cf.factoryP(nome, foto);
        controladorDados.addPiloto(p);
        return p;
    }

    public Equipe getPiloto(String nome) {
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
