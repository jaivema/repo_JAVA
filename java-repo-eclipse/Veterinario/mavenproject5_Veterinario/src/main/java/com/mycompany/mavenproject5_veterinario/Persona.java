package com.mycompany.mavenproject5_veterinario;

public class Persona {
    private String nombre;
    private String apellidos;
    private String dni;
    private int sexo;
    Fecha fNac;
    private String nMascota;

    public Persona() {
    }

    public Persona(String nombre, String apellidos, String dni, int sexo, Fecha fNac, String nMascota) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.sexo = sexo;
        this.fNac = fNac;
        this.nMascota = nMascota;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

    public Fecha getfNac() {
        return fNac;
    }

    public void setfNac(Fecha fNac) {
        this.fNac = fNac;
    }

    public String getnMascota() {
        return nMascota;
    }

    public void setnMascota(String nMascota) {
        this.nMascota = nMascota;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", sexo=" + sexo + ", fNac=" + fNac + ", nMascota=" + nMascota + '}';
    }
    

}
