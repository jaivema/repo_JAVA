/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemploswitch;

/**
 *
 * @author udemy
 */
public class EjemploSwitch {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int a = 2;
        
        switch( a )
        {
            case 1:
                System.out.println("Este es el caso 1");
            break;
            case 2:
                System.out.println("Este es el caso 2");
            break;
            case 3:
                System.out.println("Este es el caso 3");
            break;
            default:
                System.out.println("No hay coincidencia");
            break;
        }
    }
    
}
