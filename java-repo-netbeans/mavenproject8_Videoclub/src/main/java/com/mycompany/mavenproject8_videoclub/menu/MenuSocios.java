package com.mycompany.mavenproject8_videoclub.menu;

/**
 *
 * @author Jaime Verdejo Martí
 */
import com.mycompany.mavenproject8_videoclub.ficheros.FicheroSocios;
import com.mycompany.mavenproject8_videoclub.objetos.Fecha;
import com.mycompany.mavenproject8_videoclub.objetos.Socio;
import java.util.*;
import java.io.*;

public class MenuSocios implements Serializable {
    char opcion;
    boolean salir;
    Scanner sc;
    Fecha fecha;
    Socio socio;
    MenuFechas mFechas;
    ArrayList<Socio> alsocios = new ArrayList();
    
    public MenuSocios(Scanner s, ArrayList al) throws ClassNotFoundException, IOException {
        sc = new Scanner(System.in);
        do {
            this.salir = false;
            menu_Socios(s, al);
        } while (this.salir = false);
    }
    public MenuSocios(int c, ArrayList<Socio> alsocios){
        
    }
    
    public void menu_Socios(Scanner s, ArrayList al) throws ClassNotFoundException, IOException {
        this.alsocios = al;
        mFechas = new MenuFechas(sc);
        this.salir = false;
        opcion = ' ';
        do {
            System.out.println("\n      MENU SOCIOS Videoclub ");
            System.out.println("        1. - Nuevo socio.");
            System.out.println("        2. - Buscar socio.");
            System.out.println("        3. - Modificar socio.");
            System.out.println("        4. - Ver lista socios.");
            System.out.println("        5. - Baja socio.");
            System.out.println("        6. - Guardar en archivo.");
            System.out.println("        7. - Leer de archivo.");
            System.out.println("        0. - Volver.");
            System.out.println("                            ");
            System.out.println("> Selecciona opción: ");

            opcion = this.sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case '1': nuevoSocio();
                    break;
                case '2': buscarSocio();
                    break;
                case '3': modDatosSocio();
                    break;
                case '4': verSocios();
                    break;
                case '5': bajaSocio();
                    break;
                case '6': guardarSocios();
                    break;
                case '7': leerSocios();
                    break;
                case '0': this.salir = true;
                    break;
                default:
                    System.out.println("Se ha introducido una opcion incorrecta.");
                    break;
            }
        } while (!this.salir);
        this.salir = false;
    }

/// NUEVOS DATOS ///////////////////////////////////////////////////////////////
    public void nuevoSocio() {
        Socio nSocio = new Socio();
        Fecha fecAlta;
        sc.nextLine();
        nSocio.setNombre(intrNombre());
        fecAlta = mFechas.crear_fechas(sc);
        nSocio.setFecAlta(fecAlta);
        int c = alsocios.size() + 1;
        nSocio.setCodigo(c);
        alsocios.add(nSocio);
    }

    public String intrNombre() {
        System.out.println("> Nombre completo de socio: ");
        String n = sc.nextLine();
        return n;
    }

    public int intrCodigo() {
        System.out.println("> Código: ");
        int c = sc.nextInt();
        return c;
    }

/// ELIMINAR DATOS /////////////////////////////////////////////////////////////
    public void bajaSocio() {
        System.out.println("Introduce el ìndice a borrar: ");
        int c = sc.nextInt();
        if (c >= alsocios.size()) {
            System.out.println("Código " + c + " no existe !!");
        } else {
            socio = alsocios.remove(c);
            System.out.println("Se ha eliminado " + socio + ".");
        }
    }

/// VER LISTADO ////////////////////////////////////////////////////////////////
    public void verSocios() {
        if (alsocios.isEmpty()) {
            System.out.println("Todavía no hay datos de alta !!");
        } else {
            for (int i = 0; i < alsocios.size(); i++) {
                System.out.println(i + ".-> " + alsocios.get(i));
            }
        }
    }

/// MODIFICAR DATOS ////////////////////////////////////////////////////////
    public void modDatosSocio() {
        this.salir = false;
        do {
            System.out.println("\n      MODIFICAR DATOS SOCIO Videoclub ");
            System.out.println("        1. Modificar nombre.");
            System.out.println("        2. Modificar fecha.");
            System.out.println("        0. Volver.");
            System.out.println("                                   ");
            System.out.println("> Selecciona opción: ");

            opcion = sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case '1': modNombre();
                    break;
                case '2': modFecha();
                    break;
                case '0': this.salir = true;
                    break;
                default:
                    System.out.println("Se ha introducido una opcion incorrecta.");
                    break;
            }
        } while (!this.salir);
        salir = false;
    }

    public void modNombre() {
        sc.nextLine();
        String n=intrNombre();
        for (int i = 0; i < alsocios.size(); i++) {
            socio = alsocios.get(i);
            if (socio.getNombre().toLowerCase().equals(n.toLowerCase())) {
                System.out.println("socio encontrado: " + n + ".");
                System.out.println(i + ".-> " + alsocios.get(i));
                System.out.println("Nuevo nombre: ");
                n = sc.nextLine();
                socio.setNombre(n);
                alsocios.set(i, socio);
            }
        }

    }

    public void modFecha() {
        fecha = mFechas.intrFecha(sc);
        for (int i = 0; i < alsocios.size(); i++) {
            socio = alsocios.get(i);
            if (socio.getFecAlta().equals(fecha)) {
                System.out.println(i + ".-> " + alsocios.get(i));
                fecha=mFechas.intrFecha(sc);
                socio.setFecAlta(fecha);
                alsocios.set(i, socio);
            }
        }
    }

/// BUSCAR DATOS //////////////////////////////////////////////////////////////
    public void buscarSocio() {
        this.salir = false;
        do {
            System.out.println("\n      BUSCAR SOCIOS Videoclub ");
            System.out.println("        1. Buscar por nombre.");
            System.out.println("        2. Buscar por codigo de socio.");
            System.out.println("        3. Buscar por fecha de alta.");
            System.out.println("        0. Volver.");
            System.out.println(" Selecciona una opción: ");
            opcion = sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case '1': buscar_nombre();
                    break;
                case '2': buscar_codigo();
                    break;
                case '3': buscar_fecAlta();
                    break;
                case '0': this.salir = true;
                    break;
                default:
                    System.out.println("Se ha introducido una opcion incorrecta.");
                    break;
            }
        } while (!this.salir);
        salir = false;
    }

    public void buscar_fecAlta() {
        Fecha fecha = mFechas.intrFecha(sc);
        boolean encontrado = false;
        for (int i = 0; i < alsocios.size(); i++) {
            socio = alsocios.get(i);
            if (socio.getFecAlta().equals(fecha)) {
                System.out.println(i + ".-> " + alsocios.get(i));
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("> No se ha encontrado \n");
    }

    public void buscar_nombre() {
        boolean encontrado = false;
        sc.nextLine();
        String n = intrNombre();
        for (int i = 0; i < alsocios.size(); i++) {
            socio = alsocios.get(i);
            if (socio.getNombre().toLowerCase().equals(n.toLowerCase())) {
                System.out.println(i + ".-> " + alsocios.get(i));
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("> No se ha encontrado \n");
    }

    public void buscar_codigo() {
        boolean encontrado = false;
        int c = intrCodigo();
        for (int i = 0; i < alsocios.size(); i++) {
            socio = alsocios.get(i);
            if (socio.getCodigo() == c) {
                System.out.println(i + ".-> " + alsocios.get(i));
                encontrado = true;
            }
        }
        if (!encontrado) System.out.println("> No se ha encontrado \n");
    }
    public boolean buscar_codigo(int c, ArrayList<Socio> alsocios) {
        boolean duplicado = false;
        for (int i = 0; i < alsocios.size(); i++) {
            socio = alsocios.get(i);
            if (socio.getCodigo() == c) {
                System.out.println(i + ".-> " + alsocios.get(i));
                duplicado = true;
            }
        }
        return duplicado;
    }
    /// FICHERO ////////////////////////////////////////////////////////////////
    public void leerSocios () throws ClassNotFoundException, IOException {
        FicheroSocios fSocios = new FicheroSocios();
        alsocios = fSocios.leer_fichero(alsocios);
        if (!alsocios.isEmpty()) {
            System.out.println("Lista de socios actualizado: ");
            for (int i = 0; i < alsocios.size(); i++) {
                System.out.println(i + ".-> " + alsocios.get(i));
            }
        }
    }

    public void guardarSocios() throws ClassNotFoundException, IOException {
        FicheroSocios fSocios = new FicheroSocios();       
        if (alsocios.isEmpty()) {
            System.out.println("> No existen socios todavía. Introduce socios antes de guardar");
        } else {
            fSocios.guardar_fichero(alsocios);
        }
    }
}
