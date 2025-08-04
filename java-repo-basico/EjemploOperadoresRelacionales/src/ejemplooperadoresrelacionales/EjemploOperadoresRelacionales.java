/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplooperadoresrelacionales;

/**
 *
 * @author udemy
 */
public class EjemploOperadoresRelacionales {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int a = 6;
        int b = 2;
        
        if( a > 3 && !( b < 1 ) )
        {
            System.out.println("Verdadero");
        }
        else
        {
            System.out.println("Falso");
        }
    }
    
}
