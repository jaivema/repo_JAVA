/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciofactorial;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author udemy
 */
public class EjercicioFactorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Escribe un número: ");
        int n = Integer.parseInt(br.readLine());

        while( n < 0 )
        {
            System.out.println("ERROR: El número no es positivo.");
            
            System.out.print("Escribe un número: ");
            n = Integer.parseInt(br.readLine());
        }
        
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            //factorial = factorial * i;
            factorial *= i;
        }
        
        System.out.println("Factorial de "+n+": "+factorial);
    }
    
}
