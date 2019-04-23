package servidor.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import servidor.execoes.TagInvalidaException;
import servidor.model.Carro;
import servidor.util.Cronometro;
import servidor.model.Jogador;
import servidor.model.TagColetada;
import servidor.model.Time;

public class ControladorCorrida {
    private ArrayList<Jogador> jogadores;
    private String id;
    private int quantidadeDeVoltas;
    private Date tempoTotal;
    private Jogador jogadorDavoltaMaisRapida; 
    private Cronometro cronometro;
    
    
    public ControladorCorrida(ArrayList<Jogador> jogadores, int quantidadeDeVoltas) {
        this.jogadores = jogadores;
        this.tempoTotal = tempoTotal;
        this.quantidadeDeVoltas = quantidadeDeVoltas;
    }

    
    public void comecarCorrida(){
        //rodar o cronometro
        /******************
         *
         LEMBRAR DE COLOCAR UM CONTADORZINHO PRA FAZER A CONTAGEM REGRESSIVA PRA A PARTIDA COMEÇAR
         COLOCAR MÚSIQUINHA DE START TAMBÉM É UMA OPÇÃO MUITO BEM-VINDA 
         * 
         *************************/
        cronometro.start();
    }    
    
    private Jogador getJogadorPorTag(String tag){
        Carro c;
        Jogador p;
        
        Iterator<Jogador> it = jogadores.iterator();
        while (it.hasNext()) {
            p = it.next();
            c = p.getCarro();
            if(c.equals(tag)) { return p; }
        }
        return null;    
    }
    

    public void pushTag(TagColetada tag) throws TagInvalidaException {
        Jogador jogador = getJogadorPorTag(tag.getTag());
        
        if(jogador != null){
            Time voltaComputada = cronometro.getCurrentTime();
            
            /************FAZENDO A VERIFICAÇÃO PRA VALIDAR A VOLTA********************/
            
            if(validarVolta(jogador,voltaComputada)){
                jogador.setUltimaVoltaComputada(voltaComputada);
                verificaMenorVoltaDoJogador(jogador,voltaComputada);
                verificaMenorVoltaDaCorrida(jogador);
                jogador.completouVolta();
                ordenaCorrida(jogador);            
            }else{ //A volta não é válida
            }
            
        }else{throw new TagInvalidaException("A tag não está cadastrada no sistema ou na corrida atual");}
            
        
    }
    
    public boolean validarVolta(Jogador p, Time voltaComputada){
        double ultimo = p.getUltimaVoltaComputada().transformarEmMilisegundos();
        double agora = voltaComputada.transformarEmMilisegundos();
        
        return ultimo < agora + 6000;
        
    }
    
    public void verificaMenorVoltaDoJogador(Jogador p, Time voltaComputada){
        double ultimo = p.getVoltaMaisRapida().transformarEmMilisegundos();
        double agora = voltaComputada.transformarEmMilisegundos();
        
        if(ultimo == 0 || ultimo > agora){
            p.setVoltaMaisRapida(voltaComputada);
        }

    }
    
    public void verificaMenorVoltaDaCorrida(Jogador jogadorAtual){
        double ultimo = jogadorDavoltaMaisRapida.getVoltaMaisRapida().transformarEmMilisegundos();
        double agora = jogadorAtual.getVoltaMaisRapida().transformarEmMilisegundos();
        
        if(ultimo == 0 || ultimo < agora){
            jogadorDavoltaMaisRapida = jogadorAtual;
        }

    }

    public ArrayList<Jogador> getJogadores() {
        return jogadores;
    }

    public Jogador getJogadorDavoltaMaisRapida() {
        return jogadorDavoltaMaisRapida;
    }

    public Cronometro getCronometro() {
        return cronometro;
    }
    
    public void pitStop(Jogador jogador){
        jogador.pitStop();
    }
    
    
    
    
    public void ordenaCorrida(Jogador jogador){
        jogadores.remove(jogador);
        
        Jogador j;
        int posicao = 0;
        
        Iterator<Jogador> it = jogadores.iterator();
        while (it.hasNext()) {
            j = it.next();
            if(jogador.getVolta() >= j.getVolta()) { posicao++; }
            else{ break; }
        }
        
        jogadores.add(posicao, jogador);
    }
    
    
}
