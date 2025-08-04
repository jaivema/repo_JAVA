/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplowhiledowhile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author udemy
 */
public class EjemploWhileDowhile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("¿Quieres que repita? (s|n): ");
        String respuesta = br.readLine();
        
        while( respuesta.equals("s") )
        {
            System.out.println("Repitiendo!!");

            System.out.print("¿Quieres que repita? (s|n): ");
            respuesta = br.readLine();
        }
    
        int vuelta = 0;
        
        do
        {
            vuelta++;
            System.out.println("Vuelta número: "+vuelta);
            
            System.out.print("¿Quieres que repita? (s|n): ");
            respuesta = br.readLine();

        } while( respuesta.equals("s") );
    }
    
}
