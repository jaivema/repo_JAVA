/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicioacertarnumero;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author udemy
 */
public class EjercicioAcertarNumero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Random r = new Random();
        int numero = r.nextInt(100);
        //System.out.println(numero);
        
        String respuesta="";
        int n;
        do {
            System.out.print("Escribe un número: ");
            n = Integer.parseInt(br.readLine());

            if( n == numero )
                System.out.println("Acierto");
            else
            {
                if( n > numero )
                    System.out.println("Es menor");
                else
                    System.out.println("Es mayor");

                System.out.print("¿Quieres continuar? (s|n): ");
                respuesta = br.readLine();
            }
        } while( respuesta.equals("s") && n != numero );
    }
    
}
