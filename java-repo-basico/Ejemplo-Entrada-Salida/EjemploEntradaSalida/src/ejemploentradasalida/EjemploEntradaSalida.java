/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemploentradasalida;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author udemy
 */
public class EjemploEntradaSalida {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        
        System.out.println("La variable s vale: "+s);
    }
    
}
