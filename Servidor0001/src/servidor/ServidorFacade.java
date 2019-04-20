package servidor;

import java.util.ArrayList;
import java.util.Date;
import servidor.controladores.ControladorFactory;
import servidor.controladores.ControladorCorrida;
import servidor.controladores.ControladorDeDados;
import servidor.execoes.PilotoNaoExisteException;
import servidor.model.Carro;
import servidor.model.Equipe;
import servidor.model.Participante;
import servidor.model.Piloto;
import servidor.model.TagColetada;

public class ServidorFacade {
    ArrayList<ControladorCorrida> contrCorrida;
    ControladorDeDados Dados;
    ControladorFactory cf;
    ControladorCorrida corridaAtual;

    public ServidorFacade() {
        Dados = new ControladorDeDados();
        cf = new ControladorFactory();
        contrCorrida = new ArrayList<>();
    }
    
    // Primeira parte do Facade dedicada as funções de cadastro no jogo 
    
    public boolean cadastrarEquipe(String nome){
        return Dados.addEquipe(cf.factoryE(nome));
    }    
    
    public Equipe getEquipe(String nome){
        return Dados.getEquipe(nome);
    }       
    
    public boolean deleteEquipe(String nome){
        return Dados.deleteEquipe(nome);
    }    
    
    public void listarEquipes() {
        Dados.listarEquipes();
    }
    
    public ArrayList<Equipe> getEquipes() {
        return Dados.getEquipes();
    }
    
    
    
    public boolean cadastrarCarro(String tag, String cor, String equipe){
        Equipe e = getEquipe(equipe);
        Carro c = cf.factoryC(tag, cor, e);
        e.addCarro(c);
        return Dados.addCarro(c);
    }
    
    public Carro getCarro(String tag){
        return Dados.getCarro(tag);
    }
    
    public boolean deleteCarro(String tag){
        return Dados.deleteCarro(tag);
    }        
    
    public void listarCarros() {
        Dados.listarCarros();
    }   
    
    public ArrayList<Carro> getCarros() {
        return Dados.getCarros();
    }
    
    
     
    public boolean cadastrarPilogo(String nome, String foto) throws PilotoNaoExisteException{
        return Dados.addPiloto(cf.factoryP(nome, foto));
    }    
    
    public Piloto getPiloto(String nome){
        return Dados.getPiloto(nome);
    }     
    
    public boolean deletePiloto(String nome){
        return Dados.deletePiloto(nome);
    }     
    
    public void listarPilotos() {
        Dados.listarPilotos();
    }    
   
    public ArrayList<Piloto> getPilotos() {
        return Dados.getPilotos();
    }

    
    
    
    
    public boolean CadastrarParticipante(String tag, String piloto){
        return Dados.addParticipante(cf.factoryPar(getCarro(tag), getPiloto(piloto)));
    }

    public Participante getParticipante(String tag, String piloto){
        return Dados.getParticipantes(cf.factoryPar(getCarro(tag), getPiloto(piloto)));
    }
    
    public boolean DeleteParticipante(String tag, String piloto){
        return Dados.deleteParticipante(cf.factoryPar(getCarro(tag), getPiloto(piloto)));
    }
    
    public ArrayList<Participante> getParticipantes(){
        return Dados.getParticipantes();
    }
    
    public Participante getPartPorPiloto(String piloto){
        return Dados.getPartPorPiloto(piloto);
    }
    
    //ainda falta decidir como vai icar as partidas
    
    //Segunda parte do Facade dedicado ao recebimento de dados do sensor
    
    //Terceira parte do Facade dedicado a partida

    public ControladorCorrida getCorridaAtual() {
        return corridaAtual;
    }
   
    
    public ArrayList<Participante> selecionarParticipantes(String[] args){
        ArrayList<Participante> participantesDaCorrida = new ArrayList<>();

        for (String a : args) {
            participantesDaCorrida.add(getPartPorPiloto(a));
        }
        
        return participantesDaCorrida;
        
    }
    

    public ControladorCorrida novaCorrida(String[] args, Date tempo){
        ControladorCorrida c = new ControladorCorrida( selecionarParticipantes(args), tempo);
        corridaAtual = c;
        contrCorrida.add(c);
        return  c;
    }
    
    
    public void coletorDeTags(TagColetada tag){
        corridaAtual.pushTag(tag);
    }
    
}
