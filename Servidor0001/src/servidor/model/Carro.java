package servidor.model;

import static com.sun.org.apache.bcel.internal.Repository.instanceOf;
import static com.sun.org.apache.bcel.internal.Repository.instanceOf;
import static com.sun.org.apache.bcel.internal.Repository.instanceOf;
import static com.sun.org.apache.bcel.internal.Repository.instanceOf;
import java.util.Objects;

public class Carro {
    private static int id = 1;
    private String tag;
    private String cor;
    private Equipe equipe; 

    public Carro(String tag, String cor, Equipe equipe) {
        this.id++; //pode servir pra alguma coisa
        this.tag = tag;
        this.cor = cor;
        this.equipe = equipe;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Carro.id = id;
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
        
        if(obj instanceof String){
           String aux  = (String) obj;
            return this.tag.equals(aux);  
        }
 
        if(obj instanceof Carro){
           Carro aux  = (Carro) obj;
           return this.tag.equals(aux.getTag());  
        }
        
        return false;
    }

}
