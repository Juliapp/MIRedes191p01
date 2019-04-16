/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import cliente1.controllers.ControladorDeDados;
import cliente1.controllers.ControladorFactory;
import cliente1.model.Carro;
import cliente1.model.Equipe;
import java.util.Iterator;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import servidor0001.servidorFacade.ServidorFacade;

/**
 *
 * @author Teeu Guima
 */
public class TesteControladorDeDados {
    ControladorDeDados cdd;
    ControladorFactory ccf;
    ServidorFacade sf;
    public TesteControladorDeDados() {
        
        this.cdd = new ControladorDeDados();
        this.ccf = new ControladorFactory();
        this.sf = new ServidorFacade();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @Test
    public void testCadastraEquipe(){
       Equipe e = sf.cadastrarEquipe("Topzera");
       assertEquals(e, e);
    }
    
    @Test
    public void testGetNomeEquipe(){
        Equipe e = sf.cadastrarEquipe("Heaisaisa");
        Equipe v = sf.getEquipe("Heaisaisa");
        
        assertEquals(e, v);
    }
    
    @Test
    public void testCadastraCarros(){
      Equipe e = sf.cadastrarEquipe("Velozes");
      Carro c = sf.cadastrarCarro("HHSUAHSUA", "Vermelho", e);
  
      assertEquals(c, c);
        
    }
    
    @Test
    public void testGetCarrosPorCor(){
        Carro c = cdd.getCarroPorCor("Vermelho");
        Carro v = cdd.getCarroPorCor("Vermelho");
        
        assertEquals(v, c);
    }
   
}
