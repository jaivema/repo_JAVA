package com.mycompany.mavenproject8_videoclub.objetos;

/**
 *
 * @author Jaime Verdejo Martí
 */
import java.util.*;

public class Fecha implements java.io.Serializable {

    private int dia, mes, anio;
    private boolean bisiesto;

    public Fecha() {
        Calendar cal = Calendar.getInstance();
        this.dia = cal.get(Calendar.DAY_OF_MONTH);
        this.mes = cal.get(Calendar.MONTH) + 1;
        this.anio = cal.get(Calendar.YEAR);
    }

    public Fecha(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.anio = a;
        this.bisiesto = false;
        this.bisiesto = this.bisiesto();
    }

    public int getDia() {
        return dia;
    }

    public boolean setDia(int d, int m, int a) {
        boolean bisiesto = false;
        this.bisiesto();

        if (d < 1 || d > 31) {
            System.out.println("Dia " + d + " no existe.");
        } else {
            switch (m) {
                case 2:
                    if (bisiesto) {
                        if (d > 29) {
                            System.out.println("Febrero no puede tener mas de 29 dias.");
                            return false;
                        } else {
                            this.dia = d;
                            return true;
                        }
                    } else {
                        if (d > 28) {
                            System.out.println("Febrero no puede tener más de 28 dias.");
                            return false;
                        } else {
                            this.dia = d;
                            return true;
                        }
                    }
                case 4:
                case 6:
                case 9:
                case 11:
                    if (d > 30) {
                        System.out.println("Abril, Junio, Septiembre y Noviembre no puede tener mas de 30 dias");
                        return false;
                    } else {
                        this.dia = d;
                        return true;
                    }
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    if (d > 31) {
                        System.out.println("Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre no puede tener mas de 31 dias");
                        return false;
                    } else {
                        this.dia = d;
                        return true;
                    }
            }
        }
        return false;
    }

    public int getMes() {
        return mes;
    }

    public boolean setMes(int m) {
        if (m < 1 || m > 12) {
            System.out.println("Mes " + m + " no existe.");
            return false;
        } else {
            this.mes = m;
            return true;
        }
    }

    public int getAnio() {
        return anio;
    }

    public boolean setAnio(int a) {
        Calendar cal = Calendar.getInstance();
        int i = cal.get(Calendar.YEAR);
        if (a <= i && a >= 1900) {
            this.anio = a;
            this.bisiesto = this.bisiesto();
            return true;
        } else {
            System.out.println("Error. Introducir un año entre 1900 y " + i);
            return false;
        }
    }

    public boolean isBisiesto() {
        return bisiesto;
    }

    public void setBisiesto(boolean bisiesto) {
        this.bisiesto = bisiesto;
    }

    public boolean bisiesto() {
        if ((this.anio % 4 == 0)
                && ((this.anio % 100 != 0)
                || (this.anio % 400 == 0))) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        String b = null;
        if (bisiesto) {
            b = "bisiesto";
        } else {
            b = "no bisiesto";
        }
        return "Fecha{" + "dia=" + dia + ", mes=" + mes + ", anio=" + anio + " " + b + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.dia;
        hash = 61 * hash + this.mes;
        hash = 61 * hash + this.anio;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Fecha other = (Fecha) obj;
        if (this.dia != other.dia) {
            return false;
        }
        if (this.mes != other.mes) {
            return false;
        }
        return this.anio == other.anio;
    }
}
