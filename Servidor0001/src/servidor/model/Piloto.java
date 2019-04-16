package servidor.model;

import java.util.Objects;

public class Piloto {
    private String nome;
    private String foto;
    private Equipe equipe;

    public Piloto(String nome, String foto) {
        this.nome = nome;
        this.foto = foto;
    }
    
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public boolean equals(Object obj) {
        
        if(obj instanceof String){
           String aux  = (String) obj;
           return this.nome.equals(aux);  
        }
 
        if(obj instanceof Piloto){
           Piloto aux  = (Piloto) obj;
            return this.nome.equals(aux.getNome());  
        }
        
        return false;
    }
    
}
