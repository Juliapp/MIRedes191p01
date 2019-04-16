package servidor.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    public int getVoltas() {
        return voltas;
    }

    public void setVoltas(int voltas) {
        this.voltas = voltas;
    }


    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof Participante){
           Participante aux  = (Participante) obj;
           return this.carro.equals(aux.getCarro()) && this.piloto.equals(aux.getPiloto());  
        }
        return false;
        
    }
    
    
}
