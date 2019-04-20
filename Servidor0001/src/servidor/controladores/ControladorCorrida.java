package servidor.controladores;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import servidor.model.Carro;
import servidor.util.Cronometro;
import servidor.model.Participante;
import servidor.model.TagColetada;
import servidor.model.Time;

public class ControladorCorrida {
    private ArrayList<Participante> participantes;
    private String id;
    private Date tempoTotal;
    private Participante voltaMaisRapida; 
    private Cronometro cronometro;
    
    
    public ControladorCorrida(ArrayList<Participante> participantes, Date tempoTotal) {
        this.participantes = participantes;
        this.tempoTotal = tempoTotal;
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
    
    private Participante getParticipantePorTag(String tag){
        Carro c;
        Participante p;
        
        Iterator<Participante> it = participantes.iterator();
        while (it.hasNext()) {
            p = it.next();
            c = p.getCarro();
            if(c.equals(tag)) { return p; }
        }
        return null;    
    }
    

    public void pushTag(TagColetada tag) {
        Participante jogador = getParticipantePorTag(tag.getTag());
        
        if(jogador != null){
            Time voltaComputada = cronometro.getCurrentTime();
            
            /************FAZENDO A VERIFICAÇÃO PRA VALIDAR A VOLTA********************/
            
            if(validarVolta(jogador,voltaComputada)){
                jogador.setUltimaVoltaComputada(voltaComputada);
                verificaMenorVolta(jogador,voltaComputada);
                jogador.completouVolta();
                ordenaCorrida(jogador);
            
            }else{ //A volta não é válida
            }
            
        }else{//exceção de tagNaoCadastradaNaCorridaAtual 
        }
            
        
    }
    
    public boolean validarVolta(Participante p, Time voltaComputada){
        double ultimo = p.getUltimaVoltaComputada().transformarEmSegundos();
        double agora = voltaComputada.transformarEmSegundos();
        
        return ultimo > agora + 6;
        
    }
    
    public void verificaMenorVolta(Participante p, Time voltaComputada){
        double ultimo = p.getVoltaMaisRapida().transformarEmSegundos();
        double agora = voltaComputada.transformarEmSegundos();
        
        if(ultimo == 0 || ultimo < agora){
            p.setVoltaMaisRapida(voltaComputada);
        }

    }
    
    
    
    public void ordenaCorrida(Participante jogador){
        participantes.remove(jogador);
        
        Participante p;
        int posicao = 0;
        boolean chegou = false;
        
        Iterator<Participante> it = participantes.iterator();
        while (it.hasNext() && chegou == false) {
            p = it.next();
            if(jogador.getVolta() >= p.getVolta()) { posicao++; }
            else{ chegou = true; }
        }
        
        participantes.add(posicao, jogador);
    }
    
    
}
