/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemploexcepciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author udemy
 */
public class EjemploExcepciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String s = br.readLine();
            int a = 5/0;
            
        } catch (IOException ex) {
            Logger.getLogger(EjemploExcepciones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArithmeticException ex2) {
            System.out.println("¡¡No se puede hacer una división entre 0!!");
        }
    }
    
}
