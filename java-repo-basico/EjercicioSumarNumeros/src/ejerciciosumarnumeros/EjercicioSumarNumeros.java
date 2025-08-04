/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciosumarnumeros;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author udemy
 */
public class EjercicioSumarNumeros {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("¿Quieres sumar números? (s|n): ");
        String respuesta = br.readLine();

        int total=0;
        
        while(respuesta.equals("s"))
        {
            // Pedir números
            System.out.print("Introduce un número: ");
            int numero = Integer.parseInt(br.readLine());
            
            total = total + numero;

            System.out.print("¿Quieres seguir sumando números? (s|n): ");
            respuesta = br.readLine();
        }

        System.out.println("Resultado: "+total);
    }
    
}
