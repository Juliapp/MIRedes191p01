package servidor0001.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Equipe {
    private String nome;  
    private ArrayList<Carro> carros;;

    public Equipe(String nome) {
        this.nome = nome;
        carros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(ArrayList<Carro> carros) {
        this.carros = carros;
    }
    
    public void addCarro(Carro c){
        carros.add(c);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (Objects.equals(this.nome, obj)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Equipe{" + "nome=" + nome + '}';
    }
    
}
