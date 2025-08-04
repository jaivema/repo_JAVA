package com.mycompany.mavenproject8_videoclub.objetos;

/**
 *
 * @author Jaime Verdejo Martí
 */
public class Prestamos implements java.io.Serializable {
    private int codSocio;
    private int codDVD;
    private Fecha fecha;

    public Prestamos() {
    }

    public int getCodSocio() {
        return codSocio;
    }

    public void setCodSocio(int codSocio) {
        this.codSocio = codSocio;
    }

    public int getCodDVD() {
        return codDVD;
    }

    public void setCodDVD(int codDVD) {
        this.codDVD = codDVD;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;

    }

    @Override
    public String toString() {
        return "Prestamos{" + "codSocio=" + codSocio + ", codDVD=" + codDVD
                + ", fecha de alta=" + fecha.getDia() + "/" + fecha.getMes() + "/" + fecha.getAnio() + '}';
    }

}
