/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemploprecedencia;

/**
 *
 * @author udemy
 */
public class EjemploPrecedencia {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int a = 5;
        int b = 2;
        int c = 3;
        
        int r = a+b*c;
        System.out.println("r vale: "+r);

        r = (a+b)*c;
        System.out.println("r vale: "+r);
    
    }
    
}
