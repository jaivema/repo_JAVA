package com.mycompany.mavenproject5_veterinario;

public class Mascota implements java.io.Serializable{
    private String nombre, tutor;
    Fecha primeraVisita;

    public Mascota() {
    }

    public Mascota(String nombre, String tutor, Fecha primeraVisita) {
        setNombre(nombre);
        setTutor(tutor);
        setPrimeraVisita(primeraVisita);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTutor() {
        return tutor;
    }

    public void setTutor(String tutor) {
        this.tutor = tutor;
    }

    public Fecha getPrimeraVisita() {
        return primeraVisita;
    }

    public void setPrimeraVisita(Fecha primeraVisita) {
        this.primeraVisita = primeraVisita;
    }

    @Override
    public String toString() {
        return "Mascota{" + "nombre=" + getNombre() + ", tutor=" + getTutor() + ", primeraVisita=" + getPrimeraVisita() + '}';
    }
    
    
}
