package fecha;

import java.util.Calendar;
import java.util.Scanner;

public class Fecha {
    int dia,mes,anno;           //acceso privado
    boolean bisiesto;
    
    //declaracion de constructores de la clase
    public Fecha(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.anno = a;
        this.bisiesto=false;
        this.bisiesto=this.bisiesto();
    }
    //sobrecarga OVERLOAD
    public Fecha() {
    	Calendar cal=Calendar.getInstance();
        this.dia=cal.get(Calendar.DAY_OF_MONTH);
        this.mes=cal.get(Calendar.MONTH)+1;
        this.anno=cal.get(Calendar.YEAR);
    }

    //getters and setters
    public int getDia() {
        return dia;
    }
    
    public void setDia(int d) {
        if(d<1 || d>31) System.out.println("Dia "+d+" no existe");
        else {
            switch(this.mes){
                case 2:
                    if (this.bisiesto){
                        if(d>29) System.out.println("Febrero no puede tener mas de 29 dias");
                        else this.dia=d;
                    }else{
                        if(d>28)System.out.println("Febrero no puede tener más de 28 dias");
                        else this.dia=d;
                    }
                break;
                case 4: case 6: case 9: case 11:
                    if (d>30) System.out.println("Abril, Junio, Septiembre y Noviembre no puede tener mas de 30 dias");
                    else this.dia=d;
                break;
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    if (d>31) System.out.println("Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre no puede tener mas de 31 dias");
                    else this.dia=d;
                break;
            }
        }
    }
    
    public int getMes() {
        return mes;
    }
    
    public void setMes(int m) {
        if(m<1 || m>12) System.out.println("Mes "+m+" no existe");
        else this.mes = m;
    }
    
    public int getAnno() {
        return anno;
    }
    
    public void setAnno(int a) {
        this.anno = a;
        this.bisiesto=this.bisiesto();
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
    
    public String getFecha(){
        String s =new String();
        s = dia+" de "+getNombreMes()+" de "+anno;
        return  s; 
    }
    
    public boolean bisiesto(){
        if ((this.anno % 4 == 0) 
                && ((this.anno % 100 != 0) 
                || (this.anno % 400 == 0)))
            return true;
        else
            return false;
    }    
    
    public void visualizarDatos(){
        String b=null;
        
        if(bisiesto)b = "año bisiesto";
        else b="año no bisiesto";
        
        System.out.println("Fecha: "+"dia: "+dia+", mes: "+mes+", año: "+anno+", "+b);
    }
}
    
//    public void grabarFecha(Fecha f){
//        int d,m,a;
//        
//        String lectura=null;
//        
//        System.out.println("Introduce el dia: ");
//        lectura = entrada.nextLine();
//        d = Integer.parseInt(lectura);
//        
//        System.out.println("Introduce el mes: ");
//        lectura = entrada.nextLine();
//        m = Integer.parseInt(lectura);
//        
//        System.out.println("Introduce el año: ");
//        lectura = entrada.nextLine();
//        a = Integer.parseInt(lectura);            
//        
//        f.setAnno(a);f.setMes(m);f.setDia(d);    
//    }