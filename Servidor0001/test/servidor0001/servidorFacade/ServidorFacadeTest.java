/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor0001.servidorFacade;

import servidor.servidorFacade.ServidorFacade;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import servidor.execoes.PilotoNaoExisteException;
import servidor.model.Carro;
import servidor.model.Equipe;
import servidor.model.Piloto;

/**
 *
 * @author juli
 */
public class ServidorFacadeTest {
    
    ServidorFacade f;
    
    public ServidorFacadeTest() {
        f = new ServidorFacade();
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of cadastrarEquipe method, of class ServidorFacade.
     */
    @Test
    public void testCadastrarEquipe() {
        System.out.println("cadastrarEquipe");
        String nome = "RedBull";
        ServidorFacade instance = new ServidorFacade();
        instance.cadastrarEquipe(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEquipe method, of class ServidorFacade.
     */
    @Test
    public void testGetEquipe() {
        System.out.println("getEquipe");
        String nome = "";
        ServidorFacade instance = new ServidorFacade();
        Equipe expResult = null;
        Equipe result = instance.getEquipe(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteEquipe method, of class ServidorFacade.
     */
    @Test
    public void testDeleteEquipe() {
        System.out.println("deleteEquipe");
        String nome = "";
        ServidorFacade instance = new ServidorFacade();
        boolean expResult = false;
        boolean result = instance.deleteEquipe(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastrarCarro method, of class ServidorFacade.
     */
    @Test
    public void testCadastrarCarro() {
        System.out.println("cadastrarCarro");
        String tag = "";
        String cor = "";
        String e = null;
        ServidorFacade instance = new ServidorFacade();
        instance.cadastrarCarro(tag, cor, e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarro method, of class ServidorFacade.
     */
    @Test
    public void testGetCarro() {
        System.out.println("getCarro");
        String tag = "";
        ServidorFacade instance = new ServidorFacade();
        Carro expResult = null;
        Carro result = instance.getCarro(tag);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteCarro method, of class ServidorFacade.
     */
    @Test
    public void testDeleteCarro() {
        System.out.println("deleteCarro");
        String tag = "";
        ServidorFacade instance = new ServidorFacade();
        boolean expResult = false;
        boolean result = instance.deleteCarro(tag);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastrarPilogo method, of class ServidorFacade.
     */
    @Test
    public void testCadastrarPilogo() throws PilotoNaoExisteException {
        System.out.println("cadastrarPilogo");
        String nome = "";
        String foto = "";
        ServidorFacade instance = new ServidorFacade();
        instance.cadastrarPilogo(nome, foto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPiloto method, of class ServidorFacade.
     */
    @Test
    public void testGetPiloto() {
        System.out.println("getPiloto");
        String nome = "";
        ServidorFacade instance = new ServidorFacade();
        Equipe expResult = null;
        Piloto result = instance.getPiloto(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePiloto method, of class ServidorFacade.
     */
    @Test
    public void testDeletePiloto() {
        System.out.println("deletePiloto");
        String nome = "";
        ServidorFacade instance = new ServidorFacade();
        boolean expResult = false;
        boolean result = instance.deletePiloto(nome);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPilotos method, of class ServidorFacade.
     */
    @Test
    public void testGetPilotos() {
        System.out.println("getPilotos");
        ServidorFacade instance = new ServidorFacade();
        ArrayList<Piloto> expResult = null;
        ArrayList<Piloto> result = instance.getPilotos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEquipes method, of class ServidorFacade.
     */
    @Test
    public void testGetEquipes() {
        System.out.println("getEquipes");
        ServidorFacade instance = new ServidorFacade();
        ArrayList<Equipe> expResult = null;
        ArrayList<Equipe> result = instance.getEquipes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCarros method, of class ServidorFacade.
     */
    @Test
    public void testGetCarros() {
        System.out.println("getCarros");
        ServidorFacade instance = new ServidorFacade();
        ArrayList<Carro> expResult = null;
        ArrayList<Carro> result = instance.getCarros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
