package servidor;

import java.util.ArrayList;
import java.util.Date;
import servidor.controladores.ControladorFactory;
import servidor.controladores.ControladorCorrida;
import servidor.controladores.ControladorDeDados;
import servidor.controladores.CorridaNaoIniciadaException;
import servidor.execoes.PilotoNaoExisteException;
import servidor.execoes.TagInvalidaException;
import servidor.execoes.VoltaInvalidaException;
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

    /** Méodo construtor se inicializa instanciando cada um os controladores.
     *Essa classe é o que vai acessar todos os controladores e vai ser a classe disponível 
     * para quem quiser acessar o programa. As operações só serão feitas a partir desta classe, 
     * e nenhum controlador vai ser acessado senão por ela.
     */
    public ServidorFacade() {
        Dados = new ControladorDeDados();
        cf = new ControladorFactory();
        contrCorrida = new ArrayList<>();
        corridaAtual = null;
    }
    
    
    /****** Primeira parte do Facade dedicada as funções de cadastro no jogo ******/


    /**
     *Chama o método para cadastrar uma Equipe dentro do Controlador de dados
     * @param nome nome da Equipe que você quer cadastrar 
     * @return Verdadeiro caso o cadastro foi realizado com sucesso 
     */
    
    public boolean cadastrarEquipe(String nome){
        return Dados.addEquipe(cf.factoryE(nome));
    }    
    
    /**
     *Pega do Controlador de Dados um objeto Equipe a partir do nome
     * @param nome nome da equipe que queira pegar
     * @return objeto equipe e nulo caso não tenha encontrado
     */
    public Equipe getEquipe(String nome){
        return Dados.getEquipe(nome);
    }       
    
    /**
     *Deleta do Controlador de Dados um objeto Equipe a partir do nome
     * @param nome nome da equipe que queira remover
     * @return caso o método tenha removido a equipe com sucesso
     */
    public boolean deleteEquipe(String nome){
        return Dados.deleteEquipe(nome);
    }    
    
    /**
     *Esse método printa todas as equipes cadastradas no Controlador de dados no console
     */
    public void listarEquipes() {
        Dados.listarEquipes();
    }
    
    /**
     *Pega o ArrayList de equipes que foram cadastrados no Controlador de dados
     * @return ArrayList de equipes cadastradas
     */
    public ArrayList<Equipe> getListaDeEquipes() {
        return Dados.getEquipes();
    }
    
    /**
     *Chama o método para cadastrar um Carro dentro do Controlador de dados
     * @param tag TAG do carro que está sendo cadastrado
     * @param cor cor do carro que está sendo cadastrado
     * @param equipe equipe que o carro pertence em String, pois ela vai ser encontrada com o método de getEquipe
     * @return Verdadeiro se o cadastro foi efetuado com sucesso
     */
    public boolean cadastrarCarro(String tag, String cor, String equipe){
        Equipe e = getEquipe(equipe);
        Carro c = cf.factoryC(tag, cor, e);
        e.addCarro(c);
        return Dados.addCarro(c);
    }
    
    /**Pega do Controlador de Dados um objeto Carro a partir de sua TAG.
     *
     * @param tag TAG do carro que deseja coletar
     * @return objeto carro pertencente a tag 
     */
    public Carro getCarro(String tag){
        return Dados.getCarro(tag);
    }
    
    /**
     *Deleta um carro do controlador de dados a partir de sua tag
     * @param tag TAG do carro a ser removido
     *
     * @return caso o método tenha removido o carro com sucesso
     */
    public boolean deleteCarro(String tag){
        return Dados.deleteCarro(tag);
    }        
    
    /**
     *Esse método printa todos os carros cadastrados no Controlador de dados no console
     */
    public void listarCarros() {
        Dados.listarCarros();
    }   
    
    /**
     *Pega o ArrayList de Carros que foram cadastrados no Controlador de dados
     * @return ArrayList de carros
     */
    public ArrayList<Carro> getListaDeCarros() {
        return Dados.getCarros();
    }
    
    /**
     *Chama o método para cadastrar um Piloto dentro do Controlador de dados
     * @param nome nome do piloto a ser cadastrado
     * @param foto foto do piloto a ser cadastrado
     * @return Verdadeiro se o cadastro foi efetuado com sucesso
     * @throws PilotoNaoExisteException
     */
    public boolean cadastrarPiloto(String nome, String foto) throws PilotoNaoExisteException{
        return Dados.addPiloto(cf.factoryP(nome, foto));
    }    
    
    /**Pega do Controlador de Dados um objeto Piloto a partir do seu nome
     *
     * @param nome
     * @return
     */
    public Piloto getPiloto(String nome){
        return Dados.getPiloto(nome);
    }     
    
    /**
     *Deleta um carro do controlador de dados a partir de seu nome
     * @param nome nome do piloto a ser removido do controlador de dados
     * @return caso o método tenha removido o piloto com sucesso
     */
    public boolean deletePiloto(String nome){
        return Dados.deletePiloto(nome);
    }     
    
    /**
     *Esse método printa todos os pilotos cadastrados no Controlador de dados no console
     */
    public void listarPilotos() {
        Dados.listarPilotos();
    }    
   
    /**
     *Pega o ArrayList de pilotos que foram cadastrados no Controlador de dados
     * @return ArrayList com todos os pilotos cadastrados
     */
    public ArrayList<Piloto> getListaDePilotos() {
        return Dados.getPilotos();
    }

    /**
     *Chama o método para cadastrar um Jogador dentro do Controlador de dados
     * A classe jogador é a junção da classe Piloto, Equipe e Carro com os atributos
     * e métodos que um jogador tem durante a partida.
     * @param tag TAG do carro (deve estar pré cadastrada no sistema)
     * @param piloto nome do piloto (deve estar pré cadastrado no sistema
     * @return Verdadeiro se o cadastro foi efetuado com sucesso
     */
    public boolean CadastrarJogador(String tag, String piloto){
        return Dados.addJogador(cf.factoryJog(getCarro(tag), getPiloto(piloto)));
    }

    /**Pega do Controlador de Dados um objeto Jogador a partir do nome  da TAG do carro
     *
     * @param tag tag do carro 
     * @param piloto nome do piloto
     * @return O objeto jogador 
     */
    public Jogador getJogador(String tag, String piloto){
        return Dados.getJogadores(cf.factoryJog(getCarro(tag), getPiloto(piloto)));
    }
    
    /**
     *Deleta do Controlador de Dados um objeto Jogador a partir do nome do piloto e a TAG do carro
     * @param tag TAG do carro a ser deletado
     * @param piloto nome do piloto
     * @return caso o método tenha removido o jogador com sucesso
     */
    public boolean DeleteJogador(String tag, String piloto){
        return Dados.deleteJogador(cf.factoryJog(getCarro(tag), getPiloto(piloto)));
    }
    
    /**
     *Deleta do Controlador de Dados um objeto Jogador a partir do nome do piloto 
     * @param piloto nome do piloto
     * @return caso o método tenha removido o jogador com sucesso
     */
    public boolean DeleteJogadorPorPiloto(String piloto){
        return Dados.deleteJogador(getJogadorPorNomeDoPiloto(piloto));
    }    
    
    /**
     *Pega o ArrayList de jogadores que foram cadastrados no Controlador de dados
     * @return ArrayList com todos jogadores cadastrados
     */
    public ArrayList<Jogador> getListaDeJogadores(){
        return Dados.getJogadores();
    }
    
    /**
     * Retorna um jogador cadastrado a partir do nome do piloto
     * @param piloto nome do piloto
     * @return o objeto jogador requerido caso não nulo
     */
    public Jogador getJogadorPorNomeDoPiloto(String piloto){
        return Dados.getJogadortPorNome(piloto);
    }
    
    
    
    
    
    /****** Segunda parte do Facade dedicada as funções da partida ******/
    
    
    

    /**
     * Pega a corrida que está sendo processada no momento
     * @return O controlador dessa corrida
     */

    public ControladorCorrida getCorridaAtual() {
        return corridaAtual;
    }
   
    /**
     * A partir de um array de nomes de jogadores pré cadastrados no sistem que querem participar da corrida ele joga 
     * os Objetos Jogador num array para que seja lançado na corrida atual
     * @param args nome dos jogadores
     * @return ArrayList de jogadores
     */
    public ArrayList<Jogador> selecionarJogadores(String[] args){
        ArrayList<Jogador> jogadoresDaCorrida = new ArrayList<>();

        for (String a : args) {
            Jogador jogador = getJogadorPorNomeDoPiloto(a);
            if(jogador != null){
                jogadoresDaCorrida.add(jogador);
            }
        }
        
        return jogadoresDaCorrida;
        
    }
    
    /**
     *Instancia uma nova corrida a partir de seu controlador
     * @param args nome dos jogadores que querem participar da corrida
     * @param quantidadeDeVoltas quantidades de voltas que vai ter na corrida
     * @return Caso a corrida foi instanciada com sucesso
     */
    public boolean novaCorrida(String[] args, int quantidadeDeVoltas){
        ControladorCorrida c = new ControladorCorrida( selecionarJogadores(args), quantidadeDeVoltas);
        corridaAtual = c;
        contrCorrida.add(c);
        return  c != null;
    }
    
    /**
     *Da o comando para que o cronometro comece a rodar e os métodos do controlador de corrida estejam aptos a serem utilizados 
     */
    public void comecarCorrida(){
        corridaAtual.comecarCorrida();
    }
    
    /**
     *Recolhe as tags que são pegadas pelo sensor e jogam diretamente no controlador da corrida
     * @param tag Tag coletada do sensor
     * @throws TagInvalidaException Se a TAG não estiver cadastrada no Sistema ou na partida atual
     */
    public void coletorDeTags(TagColetada tag) throws TagInvalidaException, CorridaNaoIniciadaException, VoltaInvalidaException{
        corridaAtual.pushTag(tag);
    }
    
}
