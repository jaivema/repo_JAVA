/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciofibonacci;

/**
 *
 * @author udemy
 */
public class EjercicioFibonacci {

    static int fib( int n ) {

        if( n < 2 )
            return n;
        else
            return fib(n-1)+fib(n-2);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        for (int i = 0; i < 30; i++) {
            System.out.println("El fib("+i+") es: "+fib(i));
        }
    
    }
    
}
