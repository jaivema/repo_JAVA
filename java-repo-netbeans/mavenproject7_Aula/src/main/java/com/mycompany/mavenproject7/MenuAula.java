package com.mycompany.mavenproject7;

import java.util.*;

public class MenuAula {
    char opcion;
    char salir;
    Scanner sc;
    Fecha f1;
    Alumno a1;
    ArrayList<Alumno> aula=new ArrayList();
    
    public MenuAula() {
        do{
            this.salir='n';
            menu_General();
        }while (this.salir!='s');
    }
    
    public void menu_General() {
        this.sc = new Scanner(System.in);
        aula=new ArrayList();
        char opcion=' ';
        this.salir='n';
        do {
            System.out.println("***** MENU PRINCIPAL *******");
            System.out.println("   1. - Introducir fechas.");
            System.out.println("   2. - Introducir datos alumno.");
            System.out.println("   3. - Ver datos alumno.");
            System.out.println("   4. - Añadir alumno al aula.");
            System.out.println("   5. - Vista del aula.");
            System.out.println("   0. - Salir.              ");
            System.out.println("                            ");
            System.out.println("> Selecciona opción: ");
            
            opcion = this.sc.next().toLowerCase().charAt(0);
            switch(opcion) {
                case '1':   crear_fechas();
                    break;
                case '2':   nuevo_Alumno();
                    break;
                case '3':   ver_datos_alumno();
                    break;
                case '4':   anadir_alumno_aula();        
                    break;
                case '5':   ver_aula();
                    break;
                case '0':   salir='s';
                    break;
                default:
                    System.out.println("Se ha introducido una opcion incorrecta.");
                    break;
            }
        }while(this.salir!='s');
        sc.close();
    }
    public void ver_aula(){
        if (aula.isEmpty()) {
            System.out.println("Todavía no hay datos de alta !!");
        }else{
            for (int i=0; i<aula.size();i++) {
                System.out.println(i+".-> "+aula.get(i));
            }
        }
    }
    public void anadir_alumno_aula(){
        if(a1==null){ 
            nuevo_Alumno();
        }else{
            System.out.println("Nuevo alumno dado de alta en el aula");
            System.out.println(a1);
        }
        aula.add(a1);
        a1=null;
    }
    public void ver_datos_alumno(){
        if(a1==null)System.out.println("No hay datos. Presiona (2)");
        else System.out.println(a1);
    }
    public void crear_fechas(){
        this.salir='n';
        do{
            System.out.println("***** CREAR FECHAS ***********");
            System.out.println("   1. - Crear fecha actual.        ");
            System.out.println("   2. - Crear fecha usuario.       ");
            System.out.println("   0. - Volver.                    ");
            System.out.println("                                   ");
            System.out.println("> Selecciona opción: ");

            opcion = this.sc.next().toLowerCase().charAt(0);
            switch(opcion) {
                case '1':   f1 = new Fecha();       //crea fecha actual
                    break;
                case '2':   crear_fecha_usuario();  //usuario
                    break;
                case '0':   this.salir='s';         //salir
                    break;
                default:
                    System.out.println("Se ha introducido una opcion incorrecta.");
                    break;
            }
            if ((this.f1!=null)){
                System.out.println(this.f1);
            }
        }while(this.salir!='s');
        this.salir='n';
    }
    
    public void crear_fecha_usuario(){
        int d,m,a;
        f1 = new Fecha();
        this.f1=this.introducir_fecha();
    }
    
    public Fecha introducir_fecha(){
        int d,m,a;
        Fecha f = new Fecha();
        do{
            System.out.println("Introduce el año: ");
            a = sc.nextInt();
        }while(!f.setAnno(a));
        do{
            System.out.println("Introduce el mes: ");
            m = sc.nextInt();
        }while(!f.setMes(m));
        do{
            System.out.println("Introduce el dia: ");
            d = sc.nextInt();
        }while(!f.setDia(d,m,a));

        return f;
    }
    
    public void nuevo_Alumno(){
        String n;
        int e;
        Fecha fecNac;       // crear fecha nueva
        a1 = new Alumno();  //nuevo alumno a1
        this.sc.nextLine(); //Limpar buffer de entrada
        
        System.out.println("Introduce el nombre: ");
        n = this.sc.nextLine();
        a1.setNombre(n);
        
        do{
            System.out.println("Introduce la edad: ");
            e = this.sc.nextInt();
        }while(!a1.setEdad(e));
        
        System.out.println("Introduce la fecha de nacimiento");
        fecNac = this.introducir_fecha();
        a1.setFechaNac(fecNac);
    }
}