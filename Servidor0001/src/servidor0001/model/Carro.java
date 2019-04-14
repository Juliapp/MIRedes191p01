package servidor0001.model;

import java.util.Objects;

public class Carro {
    private String tag;
    private String cor;
    private Equipe equipe; 

    public Carro(String tag, String cor, Equipe equipe) {
        this.tag = tag;
        this.cor = cor;
        this.equipe = equipe;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
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
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (Objects.equals(this.tag, tag)) {
            return true;
        }
        return false;
    }




    
    
    
    
}
