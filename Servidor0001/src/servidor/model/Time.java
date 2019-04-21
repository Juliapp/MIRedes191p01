package servidor.model;

import java.io.Serializable;

public class Time implements Serializable{
    private double horas;
    private double minutos;
    private double segundos;
    private double milisegundos;

    public Time() {
        horas = 0;
        minutos = 0;
        segundos = 0;
        milisegundos = 0;
    }

    public Time(double horas, double minutos, double segundos, double milesimos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
        this.milisegundos = milesimos;
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

    public double getMilisegundos() {
        return milisegundos;
    }

    public void setMilisegundos(double milisegundos) {
        this.milisegundos = milisegundos;
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
    
    public void incrementaMilisegundos(){
        milisegundos++;
    }
    
    public Time getCurrentTime() {
        return new Time(this.getHoras(), this.getMinutos(), this.getSegundos(), this.getMilisegundos());
    }    
    
    public double transformarEmMilisegundos(){
        return (3600000 * this.horas) + (60000 * this.minutos) + (1000 * this.segundos) + (this.milisegundos);
    }
    
    
    public int compareTo(Time time) {
        double contAtual = this.transformarEmMilisegundos();
        double contOutro = time.transformarEmMilisegundos();
        
        if(contAtual ==  contOutro){
            return 0;
        }else if(contAtual >  contOutro){
            return 1;
        }else{
            return -1;
        }
    }
}
