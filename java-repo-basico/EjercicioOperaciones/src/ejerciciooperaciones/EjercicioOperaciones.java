/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciooperaciones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author udemy
 */
public class EjercicioOperaciones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {

        int a, b;
        double x, y;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Escribe un número entero: ");
        a = Integer.parseInt(br.readLine());
        System.out.print("Escribe un número entero: ");
        b = Integer.parseInt(br.readLine());
        System.out.print("Escribe un número real: ");
        x = Double.parseDouble(br.readLine());
        System.out.print("Escribe un número real: ");
        y = Double.parseDouble(br.readLine());

        System.out.println("ENTEROS");
        System.out.println("a+b = "+(a+b));
        System.out.println("a-b = "+(a-b));
        System.out.println("b-a = "+(b-a));
        System.out.println("a*b = "+(a*b));
        System.out.println("a/b = "+(a/b));
        System.out.println("b/a = "+(b/a));
        System.out.println("a%b = "+(a%b));
        System.out.println("b%a = "+(b%a));

        System.out.println("REALES");
        System.out.println("x+y = "+(x+y));
        System.out.println("x-y = "+(x-y));
        System.out.println("y-x = "+(y-x));
        System.out.println("x*y = "+(x*y));
        System.out.println("x/y = "+(x/y));
        System.out.println("y/x = "+(y/x));
        System.out.println("x%y = "+(x%y));
        System.out.println("y%x = "+(y%x));

        System.out.println("ENTERO Y REAL");
        System.out.println("a+y = "+(a+y));
        System.out.println("a-y = "+(a-y));
        System.out.println("y-a = "+(y-a));
        System.out.println("a*y = "+(a*y));
        System.out.println("a/y = "+(a/y));
        System.out.println("y/a = "+(y/a));
        System.out.println("a%y = "+(a%y));
        System.out.println("y%a = "+(y%a));
        
    }
    
}
