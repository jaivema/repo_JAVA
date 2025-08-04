package com.mycompany.mavenproject5_veterinario;

import java.io.IOException;
import java.io.Serializable;
import java.util.*;

public class MenuVeterinario implements Serializable{
    char salir, opcion;
    Scanner sc;
    Fecha fini;
    Mascota mascota;
    Fichero file;
    ArrayList<Mascota> veterinario;
    
    public MenuVeterinario() throws ClassNotFoundException, IOException{
        do{
            salir='n';
            menuPrincipal();
        }while (salir!='s');
    }
    
/// MENU PRINCIPAL /////////////////////////////////////////////////////////////    
    public void menuPrincipal()throws ClassNotFoundException, IOException{
        sc=new Scanner(System.in);
        veterinario=new ArrayList<>();
        
        this.salir='n';
        do{
            System.out.println(" MENU CLINICA VETERINARIA  ");
            System.out.println(" 1. Alta.");
            System.out.println(" 2. Baja.");
            System.out.println(" 3. Buscar.");
            System.out.println(" 4. Modificar.");
            System.out.println(" 5. Visualizar.");
            System.out.println(" 6. Cargar datos desde fichero.");
            System.out.println(" 7. Guardar datos a un fichero.");
            System.out.println(" 0. Salir.");
            System.out.println("                           ");
            System.out.println("> Selecciona opción: ");
            opcion=sc.next().toLowerCase().charAt(0);
            switch(opcion){
                case'1':
                    altaMascota();
                    System.out.println(mascota);
                    break;
                case'2':bajaMascota();
                    break;
                case'3':buscarMascotas();
                    break;
                case'4':modMascota();
                    break;
                case'5':visualizarMascotas();
                    break;
                case'6':
                    file=new Fichero();
                    file.leer_fichero(veterinario);
                    break;
                case'7':
                    file=new Fichero();
                    file.guardar_fichero(veterinario);
                    break;
                case'0':salir='s';
                    break;
                default:
                    System.out.println("Se ha introducido una opción incorrecta.");
                    break;
            }
        }while(salir!='s');
        sc.close();
    }
    
/// BUSCAR MASCOTAS ////////////////////////////////////////////////////////////
    public void buscarMascotas(){
        salir='n';
        do{
            System.out.println(" MENU DE BUSQUEDA          ");
            System.out.println(" 1. Nombre.");
            System.out.println(" 2. Tutor.");
            System.out.println(" 3. Fecha.");
            System.out.println(" 5. Visualizar.");
            System.out.println(" 0. Salir.");
            System.out.println("                           ");
            System.out.println("> Selecciona opción: ");
            opcion=sc.next().toLowerCase().charAt(0);
            switch(opcion){
                case'1':buscarNombre();
                    break;
                case'2':buscarTutor();
                    break;
                case'3':buscarFecha();
                    break;
                case'5':visualizarMascotas();
                    break;
                case'0':salir='s';
                    break;
                default:
                    System.out.println("Se ha introducido una opción incorrecta.");
                    break;
            }
        }while(salir!='s');
        salir='n';
    }
    
    public void buscarFecha(){
        boolean encontrado=false;
        int dia=0, mes=0, anno=0;
        int contador=0;
        Mascota maux=new Mascota();
        System.out.println("> dd: ");dia=sc.nextInt();
        System.out.println("> mm: ");mes=sc.nextInt();
        System.out.println("> aaaa: ");anno=sc.nextInt();
        Fecha faux=new Fecha(dia,mes,anno);
        
        for (int i=0;i<veterinario.size();i++){
            maux=veterinario.get(i);
            if (maux.getPrimeraVisita().equals(faux)) {
                encontrado = true;
                contador++;                
                System.out.println(i+".-> "+veterinario.get(i));
            }
        }
        if (!encontrado) System.out.println("No se ha encontrado: "+faux+" \n");
    }
    
    public void buscarTutor(){
        boolean encontrado=false;
        String bTutor;
        System.out.println("> Tutor: ");
        bTutor = sc.next();
        
        for (int i=0;i<veterinario.size();i++){
            Mascota maux=new Mascota();
            maux=veterinario.get(i);
            if (maux.getTutor().toLowerCase().equals(bTutor.toLowerCase())) {
                encontrado = true;
                System.out.println(i+".-> "+veterinario.get(i));
                break;
            }
        }
        if (!encontrado){
            System.out.println("No se ha encontrado: "+bTutor+" \n");
        }
    }
    
    public void buscarNombre(){
        boolean encontrado=false;
        String bNombre;
        System.out.println("> Nombre: ");
        bNombre = sc.next();
        
        for (int i=0;i<veterinario.size();i++){
            Mascota maux=new Mascota();
            maux=veterinario.get(i);
            if (maux.getNombre().toLowerCase().equals(bNombre.toLowerCase())) {
                encontrado = true;
                System.out.println(i+".-> "+veterinario.get(i));
                break;
            }
        }
        if (!encontrado){
            System.out.println("No se ha encontrado: "+bNombre+" \n");
        }
    }
    
/// MODIFICAR DATOS ////////////////////////////////////////////////////////////
    public void modMascota(){
        this.salir='n';
        do{
            System.out.println(" MODIFICAR DATOS           ");
            System.out.println(" 1. Nombre.");
            System.out.println(" 2. Tutor.");
            System.out.println(" 0. Salir.");
            System.out.println("                           ");
            System.out.println("> Selecciona opción: ");
            opcion=sc.next().toLowerCase().charAt(0);
            switch(opcion) {
                case'1':
                    break;
                case'2':
                    break;
                default:
                    System.out.println("Se ha introducido una opcion incorrecta.");
                    break;
            }
        }while(salir!='s');
        this.salir='n';
    }
    
/// DAR DE BAJA ////////////////////////////////////////////////////////////////    
    public void bajaMascota(){
        int b;
        visualizarMascotas();
        System.out.println("> Dar de baja: ");
        b = sc.nextInt();
        veterinario.remove(b);
    }
    
/// VISUALIZAR /////////////////////////////////////////////////////////////////    
    public void visualizarMascotas(){
        if (veterinario.isEmpty()) {
            System.out.println("Todavía no tienes mascotas dadas de alta !!");
        }else{
            for (int i=0; i<veterinario.size();i++) {
                System.out.println(i+".-> "+veterinario.get(i));
            }
        }
    }
    
/// DAR DE ALTA ////////////////////////////////////////////////////////////////    
    public void altaMascota(){
        mascota=new Mascota();
        fini=new Fecha();
        String n, t;
        System.out.println("> Nombre de la mascota: ");
        n = sc.next();
        System.out.println("> Nombre del dueño: ");
        t = sc.next();
        
        mascota.setNombre(n);
        mascota.setTutor(t);
        mascota.setPrimeraVisita(fini);
        
        veterinario.add(mascota);
    }
}
