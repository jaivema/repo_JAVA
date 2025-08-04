/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejerciciogrupoalumno;

/**
 *
 * @author udemy
 */
public class Grupo {

    private Alumno[] alumnos = null;

    public Grupo() {
        alumnos = new Alumno[5];
        
        for (int i = 0; i < 5; i++) {
            alumnos[i] = new Alumno();
        }
    }
    
}
