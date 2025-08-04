/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciolibroinfantil;

/**
 *
 * @author udemy
 */
public class LibroInfantil extends Libro {
    
    private int edadRecomendada = 18;
    
    public boolean esRecomendable( int edad ) {
    
        if( edad >= getEdadRecomendada() )
            return true;
        else
            return false;
    }

    /**
     * @return the edadRecomendada
     */
    public int getEdadRecomendada() {
        return edadRecomendada;
    }

    /**
     * @param edadRecomendada the edadRecomendada to set
     */
    public void setEdadRecomendada(int edadRecomendada) {
        this.edadRecomendada = edadRecomendada;
    }
    
}
