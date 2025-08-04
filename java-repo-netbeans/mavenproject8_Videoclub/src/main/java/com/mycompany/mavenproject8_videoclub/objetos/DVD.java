package com.mycompany.mavenproject8_videoclub.objetos;
/**
 *
 * @author Jaime Verdejo Martí
 */
public class DVD implements java.io.Serializable{
    private int codigo;
    private String titulo;
    private int numVol;

    public DVD() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumVol() {
        return numVol;
    }

    public void setNumVol(int numVol) {
        this.numVol = numVol;
    }

    @Override
    public String toString() {
        return "DVD{" + "codigo=" + codigo + ", titulo=" + titulo + ", numVol=" + numVol + '}';
    }
    
    
}
