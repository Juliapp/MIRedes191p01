package servidor.controladores;

import java.util.ArrayList;
import java.util.Iterator;
import servidor.execoes.PilotoNaoExisteException;
import servidor.model.Carro;
import servidor.model.Equipe;
import servidor.model.Jogador;
import servidor.model.Piloto;

/**
 *
 * @author juli
 */
public class ControladorDeDados {
    private ArrayList<Piloto> pilotos;
    private ArrayList<Equipe> equipes;
    private ArrayList<Carro> carros;
    private ArrayList<Jogador> jogadores;

    /**
     *
     */
    public ControladorDeDados() {
        pilotos = new ArrayList<>();
        equipes = new ArrayList<>();
        carros  = new ArrayList<>();    
        jogadores = new ArrayList<>();
    }    
    
    /**
     *
     * @param p
     * @return
     */
    public boolean addPiloto(Piloto p) {
        if (this.pilotos.isEmpty()) {
            this.pilotos.add(p);
        } else if (!hasPiloto(p.getNome())) {
            pilotos.add(p);
        } else {
            return false;
        }      
        return true;
    }

    /**
     *
     * @param n
     * @return
     */
    public boolean hasPiloto(String n) {
        Piloto p;
        Iterator<Piloto> it = itPiloto();
        while (it.hasNext()) {
            p = it.next();
            if(p.equals(n)){ return true; }
        }
        return false; //jogar exceção piloto não existe
    }

    /**
     *
     * @return
     */
    public Iterator<Piloto> itPiloto() {
        return pilotos.iterator();
    }

    /**
     *
     * @param nome
     * @return
     */
    public Piloto getPiloto(String nome) {
        if(hasPiloto(nome)){
            return pilotos.get(getIndexPiloto(nome));
        }
        return null; //jogar exceção piloto não existe
    }
    
    /**
     *
     * @param nome
     * @return
     */
    public int getIndexPiloto(String nome){
        Piloto p;
        Iterator<Piloto> it = itPiloto();
        int i = 0;
        while (it.hasNext()){
            p = it.next();
            if(p.equals(nome)){ return i; }
            i++;
        }
        return 0;
    }
    
    /**
     *
     * @param nome
     * @return
     */
    public boolean deletePiloto(String nome) {
        if(hasPiloto(nome)){
            pilotos.remove(getIndexPiloto(nome));
            return true;
        }
        return false;
    }
    
    /**
     *
     */
    public void listarPilotos() {
        Piloto p;
        Iterator<Piloto> it = itPiloto();
        while (it.hasNext()) {
            p = it.next();
            System.out.println(p.getNome());
        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Piloto> getPilotos() {
        return pilotos;
    }    
    
    /**
     *
     * @param e
     * @return
     */
    public boolean addEquipe(Equipe e) {
        if (this.equipes.isEmpty()) {
            this.equipes.add(e);
        } else if (!hasEquipe(e.getNome())) {
            equipes.add(e);
        } else {
            return false;
        }
        return true;
    }

    /**
     *
     * @param n
     * @return
     */
    public boolean hasEquipe(String n) {
        Equipe e;
        Iterator<Equipe> it = itEquipe();
        while (it.hasNext()) {
            e = it.next();
            if (e.equals(n)) { return true; }
        }   
        return false;
    }

    /**
     *
     * @return
     */
    public Iterator<Equipe> itEquipe() {
        return equipes.iterator();
    }

    /**
     *
     * @param nome
     * @return
     */
    public Equipe getEquipe(String nome) {
        if(hasEquipe(nome)){
            return equipes.get(getIndexEquipe(nome));
        }
        return null;
    }
    
    /**
     *
     * @param nome
     * @return
     */
    public int getIndexEquipe(String nome){
        Equipe e;
        Iterator<Equipe> it = itEquipe();
        int i = 0;
        while (it.hasNext()){
            e = it.next();
            if(e.equals(nome)){ return i; }
            i++;
        }
        return 0;
    }
    
    /**
     *
     */
    public void listarEquipes() {
        Equipe e;
        Iterator<Equipe> it = itEquipe();
        while (it.hasNext()) {
            e = it.next();
            System.out.println(e.getNome());
        }        
    }
    
    /**
     *
     * @param nome
     * @return
     */
    public boolean deleteEquipe(String nome) {
        if(hasEquipe(nome)){
            equipes.remove(getIndexEquipe(nome));
            return true;
        }
        return false;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Equipe> getEquipes() {
        return equipes;
    }
    
    /**
     *
     * @param c
     * @return
     */
    public boolean addCarro(Carro c) {
        if (this.carros.isEmpty()) {
            this.carros.add(c);
        } else if (!hasCarro(c.getTag())) {
            carros.add(c);
        } else {
            return false;
        }
        return true;
    }

    /**
     *
     * @param tag
     * @return
     */
    public boolean hasCarro(String tag) {
        Carro c;
        Iterator<Carro> it = itCarro();
        while (it.hasNext()) {
            c = it.next();
            if(c.equals(tag)) { return true; }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public Iterator<Carro> itCarro() {
        return carros.iterator();
    }

    /**
     *
     * @param tag
     * @return
     */
    public Carro getCarro(String tag) {
        if(hasCarro(tag)){
           return carros.remove(getIndexCarro(tag));
        }
        return null;
    }
    
    /**
     *
     * @param tag
     * @return
     */
    public int getIndexCarro(String tag){
        Carro c;
        Iterator<Carro> it = itCarro();
        int i = 0;
        while (it.hasNext()){
            c = it.next();
            if(c.equals(tag)){ return i; }
            i++;
        }
        return 0; 
    }

    /**
     *
     * @param cor
     * @return
     */
    public Carro getCarroPorCor(String cor) {
        Carro c;
        while (itCarro().hasNext()) {
            c = (Carro) itCarro().next();
            if (c.getCor().equals(cor)) {
                return c;
            }
        }
        return null;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Carro getCarroPorId(int id){
        Carro c;
        while (itCarro().hasNext()) {
            c = (Carro) itCarro().next();
            if (c.getId() == id) {
                return c;
            }
        }
        return null;     
    }
    
    /**
     *
     * @param tag
     * @return
     */
    public boolean deleteCarro(String tag) {
        if(hasCarro(tag)){
           carros.remove(getIndexCarro(tag));
           return true;
        }
        return false;
    }
    
    /**
     *
     */
    public void listarCarros() {
        Carro c;
        Iterator<Carro> it = itCarro();
        while (it.hasNext()) {
            c = it.next();
            System.out.println(c.getTag());
        }
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Carro> getCarros() {
        return carros;
    }
    
    /**
     *
     * @param jogador
     * @return
     */
    public boolean addJogador(Jogador jogador) {
        return jogadores.add(jogador);
    }

    /**
     *
     * @param jogador
     * @return
     */
    public boolean hasJogador(Jogador jogador) {
        Jogador p;
        Iterator<Jogador> it = itJogadores();
        while(it.hasNext()){
            p = it.next();
            if(p.equals(jogador)){ return true; }
        }
        return false;
    }

    /**
     *
     * @return
     */
    public Iterator<Jogador> itJogadores() {
        return this.jogadores.iterator();
    }

    /**
     *
     * @param part
     * @return
     */
    public Jogador getJogadores(Jogador part) {
        if(hasJogador(part)){
            return jogadores.get(getIndexJogador(part));
        }
        return null;
    }
    
    /**
     *
     * @param part
     * @return
     */
    public int getIndexJogador(Jogador part){
        Jogador p;
        Iterator<Jogador> it = itJogadores();
        int i = 0;
        while(it.hasNext()){
            p = it.next();
            if(p.equals(part)){ return i; }
            i++;
        }
        return 0;
    }
    
    /**
     *
     * @param piloto
     * @return
     */
    public Jogador getJogadortPorNome(String piloto){
        if(hasPiloto(piloto)){
            
          Iterator<Jogador> it = itJogadores();
          Jogador p;
          
            while(it.hasNext()){
                p = it.next();
                if(p.getPiloto().equals(piloto)){ return p; }
            }          
        }
        return null;
    }
    
    /**
     *
     * @param part
     * @return
     */
    public boolean deleteJogador(Jogador part){
        if(hasJogador(part)){
            jogadores.remove(getIndexJogador(part));
            return true;
        }
        return false;
    }
    
    /**
     *
     * @return
     */
    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }
    
    


}
    
