/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejemplobombilla;

/**
 *
 * @author udemy
 */
public class Bombilla {
    
    private boolean estado = false;

    public Bombilla() {
        estado = false;
    }

    public Bombilla( boolean estado ) {
        this.estado = estado;
    }
    
    public void encender() {
        estado = true;
    }

    public void apagar() {
        this.estado = false;
    }
    
    public void consultarEstado() {
        if( estado == true )
            System.out.println("Encendida");
        else
            System.out.println("Apagada");
    }
}
