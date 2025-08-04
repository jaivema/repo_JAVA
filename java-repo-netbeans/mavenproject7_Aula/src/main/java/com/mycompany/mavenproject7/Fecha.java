package com.mycompany.mavenproject7;

import java.util.Calendar;

public class Fecha {
    int dia,mes,anno;           //acceso privado
    boolean bisiesto;
    //declaracion de constructores de la clase
    public Fecha() {
    	Calendar cal=Calendar.getInstance();
        this.dia=cal.get(Calendar.DAY_OF_MONTH);
        this.mes=cal.get(Calendar.MONTH)+1;
        this.anno=cal.get(Calendar.YEAR);
    }
    //sobrecarga OVERLOAD
    public Fecha(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.anno = a;
        this.bisiesto=false;
        this.bisiesto=this.bisiesto();
    }
    //getters and setters
    public int getDia() {
        return dia;
    }
    public boolean setDia(int d,int m,int a) {
        boolean bisiesto = false;
        if ((a % 4 == 0) 
                && ((a% 100 != 0) 
                || (a % 400 == 0)))
            bisiesto = true;
        else bisiesto = false;
        
        if(d<1 || d>31) {
            System.out.println("Dia "+d+" no existe.");
        }else {
            switch(m){
                case 2:
                    if (bisiesto){
                        if(d>29) {
                            System.out.println("Febrero no puede tener mas de 29 dias.");
                            return false;
                        }else {
                            this.dia = d;
                            return true;
                        }
                    }else{
                        if(d>28){
                            System.out.println("Febrero no puede tener más de 28 dias.");
                            return false;
                        }else {
                            this.dia = d;
                            return true;
                        }
                    }
                case 4: case 6: case 9: case 11:
                    if (d>30) {
                        System.out.println("Abril, Junio, Septiembre y Noviembre no puede tener mas de 30 dias");
                        return false;
                    }else {
                        this.dia = d;
                        return true;
                    }
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    if (d>31) {
                        System.out.println("Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre no puede tener mas de 31 dias");
                        return false;
                    }else {
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
        if(m<1 || m>12){
            System.out.println("Mes "+m+" no existe.");
            return false;
        }else{
            this.mes = m;
            return true;
        }
    }
    public int getAnno() {
        return anno;
    }
    public boolean setAnno(int a) {
        Calendar cal=Calendar.getInstance();
        int i=cal.get(Calendar.YEAR);
        if (a <= i && a >= 1900){
            this.anno = a;
            this.bisiesto=this.bisiesto();
            return true;
        }else{
            System.out.println("Error. Introducir un año entre 1900 y "+i);
            return false;
        }
    }    
    public boolean bisiesto(){
        if ((this.anno % 4 == 0) 
                && ((this.anno % 100 != 0) 
                || (this.anno % 400 == 0)))
            return true;
        else
            return false;
    }
    public String getNombreMes() {
        String m=new String();
        //nombre del mes a partir del numero
        switch (this.mes) {
            case 1: m="Enero";break;
            case 2: m="Febrero";break;
            case 3: m="Marzo";break;
            case 4: m="Abril";break;
            case 5: m="Mayo";break;
            case 6: m="Junio";break;
            case 7: m="Julio";break;
            case 8: m="Agosto";break;
            case 9: m="Septiembre";break;
            case 10: m="Octubre";break;
            case 11: m="Noviembre";break;
            case 12: m="Diciembre";break;
        }
        return m;
    }
    
    @Override
    public String toString() {
        String b=null;
        if(bisiesto)b = "bisiesto";
        else b="no bisiesto";
        return "Fecha{"+"dia="+dia+", mes="+this.getNombreMes()+", anno="+anno+" "+b+'}';
    }
}