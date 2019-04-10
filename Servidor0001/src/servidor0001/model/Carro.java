package servidor0001.model;

public class Carro {
    private double tag;
    private String cor;
    private Equipe equipe; 

    public Carro(double id, String cor, Equipe equipe) {
        this.tag = id;
        this.cor = cor;
        this.equipe = equipe;
    }

    public double getTag() {
        return tag;
    }

    public void setTag(double tag) {
        this.tag = tag;
    }

    
    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (Double.doubleToLongBits(this.tag) != Double.doubleToLongBits(other.tag)) {
            return false;
        }
        return true;
    }


    
    
    
    
}
