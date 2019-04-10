package servidor0001.model;

import java.util.Date;
import java.util.List;

public class Participante {
    private Carro carro;
    private Piloto piloto;
    private Date voltaMaisRapida;
    private Date tempoDeCorrida;
    private int voltas;
    private int pitStops;
    private int colocacao;  

    public Participante(Carro carro, Piloto piloto) {
        this.carro = carro;
        this.piloto = piloto;
        pitStops = 0;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Piloto getPiloto() {
        return piloto;
    }

    public void setPiloto(Piloto piloto) {
        this.piloto = piloto;
    }

    public Date getVoltaMaisRapida() {
        return voltaMaisRapida;
    }

    public void setVoltaMaisRapida(Date voltaMaisRapida) {
        this.voltaMaisRapida = voltaMaisRapida;
    }

    public Date getTempoDeCorrida() {
        return tempoDeCorrida;
    }

    public void setTempoDeCorrida(Date tempoDeCorrida) {
        this.tempoDeCorrida = tempoDeCorrida;
    }

    public int getVolta() {
        return voltas;
    }

    public int getPitStops() {
        return pitStops;
    }

    public void setPitStops(int pitStops) {
        this.pitStops = pitStops;
    }

    public int getColocacao() {
        return colocacao;
    }

    public void setColocacao(int colocacao) {
        this.colocacao = colocacao;
    }
    
    
    public void pitStop(){
        pitStops++;
    }
    
    public void completouVolta(){
        voltas++;
    }
    
    
    
}
