
package com.mycompany.mavenproject5_veterinario;

import java.util.Calendar;

public class Fecha implements java.io.Serializable{
    private int dia,mes,anno;
    private boolean bisiesto;

    public Fecha() {
        Calendar cal=Calendar.getInstance();
        setDia(cal.get(Calendar.DAY_OF_MONTH));
        setMes(cal.get(Calendar.MONTH)+1);
        setAnno(cal.get(Calendar.YEAR));
    }

    public Fecha(int dia, int mes, int anno) {
        setDia(dia);
        setMes(mes);
        setAnno(anno);
        setBisiesto(anno);
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
    
    public boolean isBisiesto() {
        return bisiesto;
    }
    
    public boolean setBisiesto(int a){
        if ((a %4==0)&&((a %100!=0)||(a %400==0)))
            return true;
        else
            return false;
    }
    
    @Override
    public String toString() {
        String b=new String();
        if(isBisiesto())b="año bisiesto";
        else b="año no bisiesto";
        
        return "Fecha{"+"dia="+getDia()+", mes="+getMes()+", anno="+getAnno()+", "+b+'}';
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
        return this.anno == other.anno;
    }
    
}