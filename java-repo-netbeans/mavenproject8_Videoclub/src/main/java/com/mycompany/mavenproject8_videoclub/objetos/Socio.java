package com.mycompany.mavenproject8_videoclub.objetos;


public class Socio implements java.io.Serializable {
    private int codigo;
    private String nombre;
    private Fecha fecAlta;

    public Socio() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Fecha getFecAlta() {
        return fecAlta;
    }

    public void setFecAlta(Fecha fecAlta) {
        this.fecAlta = fecAlta;
    }

    @Override
    public String toString() {
        return "Socio{" + "codigo=" + codigo + ", nombre=" + nombre
                 +", fecha de alta="+fecAlta.getDia()+"/"+fecAlta.getMes()+"/"+fecAlta.getAnio() +'}';
    }
    
}
