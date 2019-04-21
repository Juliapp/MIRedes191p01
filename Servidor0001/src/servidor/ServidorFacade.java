package servidor;

import java.util.ArrayList;
import java.util.Date;
import servidor.controladores.ControladorFactory;
import servidor.controladores.ControladorCorrida;
import servidor.controladores.ControladorDeDados;
import servidor.execoes.PilotoNaoExisteException;
import servidor.execoes.TagInvalidaException;
import servidor.model.Carro;
import servidor.model.Equipe;
import servidor.model.Jogador;
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
    
    
     
    public boolean cadastrarPiloto(String nome, String foto) throws PilotoNaoExisteException{
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

    
    
    
    
    public boolean CadastrarJogador(String tag, String piloto){
        return Dados.addJogador(cf.factoryJog(getCarro(tag), getPiloto(piloto)));
    }

    public Jogador getJogador(String tag, String piloto){
        return Dados.getJogadores(cf.factoryJog(getCarro(tag), getPiloto(piloto)));
    }
    
    public boolean DeleteJogador(String tag, String piloto){
        return Dados.deleteJogador(cf.factoryJog(getCarro(tag), getPiloto(piloto)));
    }
    
    public ArrayList<Jogador> getJogadores(){
        return Dados.getJogadores();
    }
    
    public Jogador getJogadorPorNomeDoPiloto(String piloto){
        return Dados.getJogadortPorNome(piloto);
    }
    
    
    //Segunda parte do Facade dedicado a partida

    public ControladorCorrida getCorridaAtual() {
        return corridaAtual;
    }
   
    
    public ArrayList<Jogador> selecionarJogadores(String[] args){
        ArrayList<Jogador> jogadoresDaCorrida = new ArrayList<>();

        for (String a : args) {
            jogadoresDaCorrida.add(getJogadorPorNomeDoPiloto(a));
        }
        
        return jogadoresDaCorrida;
        
    }
    

    public ControladorCorrida novaCorrida(String[] args, Date tempo){
        ControladorCorrida c = new ControladorCorrida( selecionarJogadores(args), tempo);
        corridaAtual = c;
        contrCorrida.add(c);
        return  c;
    }
    
    public void comecarCorrida(){
        corridaAtual.comecarCorrida();
    }
    
    public void coletorDeTags(TagColetada tag) throws TagInvalidaException{
        corridaAtual.pushTag(tag);
    }
    
}
