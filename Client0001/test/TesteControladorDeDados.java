/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cliente1.controllers.ControladorDeDados;
import cliente1.controllers.ControladorFactory;
import cliente1.model.Carro;
import cliente1.model.Equipe;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teeu Guima
 */
public class TesteControladorDeDados {
    ControladorDeDados cdd;
    ControladorFactory ccf;
    public TesteControladorDeDados() {
        
        this.cdd = new ControladorDeDados();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void cadastraCarros(){
       Equipe e = cdd.addEquipe("Velozes");
       Carro c = cdd.addCarros("AHUSHAUSHUA", "Vermelho", e);
       
       assertEquals(c, c);
        
    }
}
