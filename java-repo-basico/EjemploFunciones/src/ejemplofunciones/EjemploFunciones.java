/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplofunciones;

/**
 *
 * @author udemy
 */
public class EjemploFunciones {

    static int multiplicaPorTres( int p ) {
            int r = p * 3;
            return r;
    }

    public static void main(String[] args) {
            int a = 5;
            int b = multiplicaPorTres(a);
            
            System.out.println(b);
    }    
    
}
