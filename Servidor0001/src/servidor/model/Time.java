package servidor.model;

import java.io.Serializable;

public class Time implements Serializable{
    private double horas;
    private double minutos;
    private double segundos;

    public Time() {
        horas = 0;
        minutos = 0;
        segundos = 0;
    }

    public Time(double horas, double minutos, double segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public double getMinutos() {
        return minutos;
    }

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

    public double getSegundos() {
        return segundos;
    }

    public void setSegundos(double segundos) {
        this.segundos = segundos;
    }


    
    public void incrementaHoras() {
        horas++;
    }
        
    public void incrementaMinutos() {
        minutos++;
    }

    public void incrementaSegundos() {
        minutos++;
    }    
    
    public Time getCurrentTime() {
        return new Time(this.getHoras(), this.getMinutos(), this.getSegundos());
    }    
    
    public double transformarEmSegundos(){
        return (3600 * this.horas) + (60 * this.minutos) + (this.segundos);
    }
    
    
    public int compareTo(Time time) {
        double contAtual = this.transformarEmSegundos();
        double contOutro = time.transformarEmSegundos();
        
        if(contAtual ==  contOutro){
            return 0;
        }else if(contAtual >  contOutro){
            return 1;
        }else{
            return -1;
        }
    }
}
