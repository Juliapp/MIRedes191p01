/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import comunicacao.ServidorFacade;
import model.Carro;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Teeu Guima
 */
public class TesteServidorFacade {

    private ServidorFacade sf;

    public TesteServidorFacade() {

        this.sf = ServidorFacade.getInstance();
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @Before
    public void setUp() {
    }
/*
    @Test
    public void testCadastroCarro() {
        boolean status = sf.cadastrarCarro("EPC0292123", "Vermelho", "Velozes");
        
        assertEquals(true, status);
    }
    */
    @Test
    public void testGetCarroPorID(){
        boolean status = sf.cadastrarCarro("EPC0292123", "Vermelho", "Velozes");
        boolean status1 = sf.cadastrarCarro("EPC0492123", "Vermelho", "Velozes");
        
        Carro idCar = sf.getCarroPorId(1);
        Carro idCar1 = sf.getCarroPorId(2);
        
        assertEquals(idCar, idCar);
        assertEquals(true, status1);
        
    }
}
