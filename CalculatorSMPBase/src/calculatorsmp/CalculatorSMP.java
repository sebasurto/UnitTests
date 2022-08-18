/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatorsmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author Djurado
 */
public class CalculatorSMP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

       /* String question = Operations.MakeFormula();
        System.out.println(question);
        String ret = Operations.Solve(question);
        System.out.println(ret);*/
        String str ="12*5/4+7";
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
        System.out.println("Numeros: "+numstack.size());
        System.out.println("Operadores: "+opstack.size());
    }
    
}
