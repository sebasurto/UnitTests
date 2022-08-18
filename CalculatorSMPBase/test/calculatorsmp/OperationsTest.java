/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package calculatorsmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author VICTOR
 */
public class OperationsTest {
    
    public OperationsTest() {
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
     * Test of MakeFormula method, of class Operations.
     */
    @Test
    public void testMakeFormula() {
        System.out.println("MakeFormula");
        String expResult = "";
        String result = Operations.MakeFormula();
        //assertEquals(expResult, result);
       // assertTrue(true);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
        String str = Operations.MakeFormula();
        String[] arreglo = str.split("");
        Stack<String> numstack = new Stack();
        Stack<String> opstack = new Stack();
        ArrayList<String> numeros = new ArrayList(Arrays.asList("0","1","2","3","4","5","6","7","8","9"));
        for(int i = 0; i<arreglo.length;i++){
            String substr = arreglo[i];
            if(numstack.isEmpty()){
                numstack.push(substr);
            }else if(numeros.contains(substr) && numeros.contains(arreglo[i-1])){
                substr = numstack.pop() + substr;
                numstack.push(substr);
            }else if(numeros.contains(substr)){
                numstack.push(substr);
            }else{
                opstack.push(substr);
            }
        }
        assertTrue(numstack.size()>=2 && numstack.size()<=4);
        assertTrue(opstack.size()>=1 && opstack.size()<=3);
        assertTrue(numstack.size()-opstack.size() == 1);


    }

    /**
     * Test of Solve method, of class Operations.
     */
    @Test
    public void testSolve() {
        System.out.println("Solve");
        String formula0 = "12+43*18";
        String formula1 = "12/8";
        String formula2 = "12/7";
        String expResult0 = "12+43*18=786";
        String expResult1 = "12/8=1.5";
        String expResult2 = "12/7=1";
        String result = Operations.Solve(formula1); 
        String result0 = Operations.Solve(formula0);
        String result2 = Operations.Solve(formula2); 
        //assertEquals(expResult1, result); // resultado que espera es el entero menor
        //assertEquals(expResult0, result); // considerando el orden o peso de los operadores
        assertEquals(expResult2,result2); // la funcion Solve siempre va a arrojar el entero menor, apesar de que resultado como decimal sea mayor a 0.5
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
