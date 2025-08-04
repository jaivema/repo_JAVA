/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplofactorial;

/**
 *
 * @author udemy
 */
public class EjemploFactorial {

    static int factorial(int n) {
        if( n == 0 )
            return 1;
        else
            return n*factorial(n-1);
    }
    
    public static void main(String[] args) {

        System.out.println( factorial(5) );
    }
    
}
