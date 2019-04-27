package clienteCad.model;

import java.io.Serializable;

public class PreConfigCorrida implements Serializable {
    public int quantidadeVoltas;
    String[] jogadores;
    
    public PreConfigCorrida(int voltas, String[] jogadores){
        this.quantidadeVoltas = voltas;
        this.jogadores = jogadores;
    }

    public int getQuantidadeVoltas() {
        return quantidadeVoltas;
    }

    public void setQuantidadeVoltas(int quantidadeVoltas) {
        this.quantidadeVoltas = quantidadeVoltas;
    }

    public String[] getJogadores() {
        return jogadores;
    }

    public void setJogadores(String[] jogadores) {
        this.jogadores = jogadores;
    }
    
    
    
}
