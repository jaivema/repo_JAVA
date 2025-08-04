/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemploconversiones;

/**
 *
 * @author udemy
 */
public class EjemploConversiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int a = 5;
        int b = 7;
        
        double c = 0.5;

        c = a;  // Implícita
        
        a = (int)c;   // Explícita o "casting"
        
        String s = "7";
        
        b = Integer.parseInt(s);
        c = Double.parseDouble(s);
    }
    
}
