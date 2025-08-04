package com.mycompany.mavenproject7;

public class Alumno {
    String nombre;
    int edad;
    Fecha fechaNac;

    public Alumno() {
    }
    
    public Alumno(String nombre, int edad, Fecha fechaNac) {
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNac = fechaNac;
    }
    
    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public int getEdad() {
        return edad;
    }

    public boolean setEdad(int e) {
        if (e>5 && e<90){
            this.edad = e;
            return true;
        }else 
            return false;
    }

    public Fecha getFechaNac() {
        return fechaNac;
    }

    //get set
    public void setFechaNac(Fecha fnac) {
        this.fechaNac = fnac;
    }
    
    
    @Override
    public String toString() {
        
        return "Alumno{"+"nombre="+nombre+", edad="+edad 
                +", fechaNac="+fechaNac.getDia()+"/"+fechaNac.getMes()+"/"+fechaNac.getAnno() +'}';
    }
}