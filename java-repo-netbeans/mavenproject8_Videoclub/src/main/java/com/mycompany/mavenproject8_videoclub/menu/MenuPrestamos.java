package com.mycompany.mavenproject8_videoclub.menu;

/**
 *
 * @author Jaime Verdejo Martí
 */
import com.mycompany.mavenproject8_videoclub.ficheros.FicheroPrestamos;
import com.mycompany.mavenproject8_videoclub.objetos.Prestamos;
import com.mycompany.mavenproject8_videoclub.objetos.Fecha;
import com.mycompany.mavenproject8_videoclub.objetos.DVD;
import com.mycompany.mavenproject8_videoclub.objetos.Socio;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

class MenuPrestamos implements Serializable {

    char opcion;
    boolean salir;
    Scanner sc;
    DVD dvd, daux;
    Socio socio, saux;
    Prestamos prestamo, paux;
    MenuFechas mFechas;
    ArrayList<DVD> dvds = new ArrayList();
    ArrayList<Socio> socios = new ArrayList();
    ArrayList<Prestamos> prestamos = new ArrayList();
    FicheroPrestamos fPrestamos = new FicheroPrestamos();

    public MenuPrestamos(Scanner s, ArrayList al1, ArrayList al2, ArrayList al3) throws ClassNotFoundException, IOException {
        sc = new Scanner(System.in);
        do {
            this.salir = false;
            menu_Prestamos(s, al1, al2, al3);
        } while (this.salir = false);
    }

    public void menu_Prestamos(Scanner s, ArrayList al1, ArrayList al2, ArrayList al3) throws ClassNotFoundException, IOException {
        this.socios = al1;
        this.dvds = al2;
        this.prestamos = al3;
        MenuFechas mFechas = new MenuFechas(sc);
        this.salir = false;
        do {
            System.out.println("\n      MENU PRESTAMOS Videoclub ");
            System.out.println("        1. - Nuevo préstamo.");
            System.out.println("        2. - Buscar préstamo.");
            System.out.println("        3. - Modificar préstamo.");
            System.out.println("        4. - Ver lista préstamos.");
            System.out.println("        5. - Baja de préstamo.");
            System.out.println("        6. - Guardar en archivo.");
            //System.out.println("        7. - Leer de archivo.");
            System.out.println("        0. - Volver.");
            System.out.println("                            ");
            System.out.println("> Selecciona opción: ");

            opcion = this.sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case '1': nuevoPrestamo();
                    break;
                case '2': buscarPrestamo();
                    break;
                case '3': modDatosPrestamo();
                    break;
                case '4': verPrestamos();
                    break;
                case '5': bajaPrestamos();
                    break;
                case '6': guardarPrestamos();
                    break;
                case '7': leerPrestamos();
                    break;
                case '0':this.salir = true;
                    break;
                default:
                    System.out.println("Se ha introducido una opcion incorrecta.");
                    break;
            }
        } while (!this.salir);
        this.salir = false;
    }
/// FICHERO ////////////////////////////////////////////////////////////////////

    public void leerPrestamos() throws ClassNotFoundException, IOException {
        ArrayList<Prestamos> alprestamos = new ArrayList();
        fPrestamos = new FicheroPrestamos();
        alprestamos = fPrestamos.leer_fichero(prestamos);
        if (!alprestamos.isEmpty()) {
            System.out.println("Lista de prestamos actualizado: ");
            for (int i = 0; i < alprestamos.size(); i++) {
                System.out.println(i + ".-> " + alprestamos.get(i));
            }
        }
    }

    public void guardarPrestamos() throws ClassNotFoundException, IOException {
        if (prestamos.isEmpty()) {
            System.out.println("> No existen prestamos todavía.");
        } else {
            fPrestamos = new FicheroPrestamos();
            fPrestamos.guardar_fichero(prestamos);
        }
    }
/// NUEVOS DATOS ///////////////////////////////////////////////////////////////

    public void nuevoPrestamo() {
        Prestamos nPrestamo = new Prestamos();
        int intr1 = 0, intr2 = 0;
        intr1 = intrCodSocio();
        if (intr1 != 0) {
            nPrestamo.setCodSocio(intr1);
            intr2 = intrCodDVD();
            if (intr2 != 0) {
                nPrestamo.setCodDVD(intr2);
            }
        }
        if (intr1 != 0 && intr2 != 0) {
            mFechas = new MenuFechas(sc);
            nPrestamo.setFecha(mFechas.crear_fechas(sc));
            prestamos.add(nPrestamo);
            System.out.println(nPrestamo);
        } else {
            System.out.println("> Nuevo prestamo cancelado.");
        }
    }

    public int intrCodSocio() {
        int csreturn;
        System.out.println("> Codigo de socio: ");
        int cs = sc.nextInt();
        if (buscar_codigoSocio(cs)) {
            csreturn = cs;
        } else {
            csreturn = 0;
        }
        return csreturn;
    }

    public int intrCodDVD() {
        int cdreturn;
        System.out.println("> Código de dvd: ");
        int cd = sc.nextInt();
        if (buscar_codigoDVD(cd)) {
            cdreturn = cd;
        } else {
            cdreturn = 0;
        }
        return cdreturn;
    }

    public boolean buscar_codigoSocio(int c) {
        boolean encontrado = false;
        saux = new Socio();
        for (int i = 0; i < socios.size(); i++) {
            saux = socios.get(i);
            if (saux.getCodigo() == c) {
                encontrado = true;
            }
        }
        if (encontrado) return true;
        else return false;
    }

    public boolean buscar_codigoDVD(int c) {
        boolean encontrado = false;
        daux = new DVD();
        for (int i = 0; i < dvds.size(); i++) {
            daux = dvds.get(i);
            if (daux.getCodigo() == c) {
                encontrado = true;
            }
        }
        if (encontrado) return true;
        else return false;
    }

/// ELIMINAR DATOS /////////////////////////////////////////////////////////////
    public void bajaPrestamos() {
        verPrestamos();
        System.out.println("Introduce el índice a borrar: ");
        int p = sc.nextInt();
        if (p >= prestamos.size()) {
            System.out.println("Índice " + p + " no existe !!");
        } else {
            paux = prestamos.remove(p);
            System.out.println("Se ha eliminado " + paux + ".");
        }
    }

/// VER LISTADO ////////////////////////////////////////////////////////////////
    public void verPrestamos() {
        if (prestamos.isEmpty()) {
            System.out.println("Todavía no hay datos de alta !!");
        } else {
            for (int i = 0; i < prestamos.size(); i++) {
                System.out.println(i + ".-> " + prestamos.get(i));
            }
        }
    }

/// MODIFICAR DATOS ////////////////////////////////////////////////////////
    public void modDatosPrestamo() {
        this.salir = false;
        do {
            System.out.println("\n      MODIFICAR DATOS DVD Videoclub ");
            System.out.println("        1. Modificar código de socio.");
            System.out.println("        2. Modificar código de DVD.");
            System.out.println("        3. Modificar fecha.");
            System.out.println("        4. Visualizar datos.");
            System.out.println("        0. Volver.");
            System.out.println("                                   ");
            System.out.println("> Selecciona opción: ");

            opcion = sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case '1': modCodSocio();
                    break;
                case '2': modCodDVD();
                    break;
                case '3': modFecha();
                    break;
                case '4': System.out.println(prestamo);
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

    public void modCodSocio() {
        System.out.println("Código de socio del préstamo.");
        int c = sc.nextInt();
        for (int i = 0; i < prestamos.size(); i++) {
            prestamo = prestamos.get(i);
            if (prestamo.getCodSocio() == c) {
                System.out.println(i + ".-> " + prestamos.get(i));
                System.out.println("Nuevo cógido socio: ");
                int nuevo = sc.nextInt();
                prestamo.setCodSocio(nuevo);
                prestamos.set(i, prestamo);
            }
        }
    }

    public void modCodDVD() {
        System.out.println("Código de DVD del préstamo.");
        int c = sc.nextInt();
        for (int i = 0; i < prestamos.size(); i++) {
            prestamo = prestamos.get(i);
            if (prestamo.getCodSocio() == c) {
                System.out.println(i + ".-> " + prestamos.get(i));
                System.out.println("Nuevo cógido DVD: ");
                int nuevo = sc.nextInt();
                prestamo.setCodDVD(nuevo);
                prestamos.set(i, prestamo);
            }
        }
    }

    public void modFecha() {
        verPrestamos();
        System.out.println("Índice del préstamo.");
        int c = sc.nextInt();
        System.out.println(c + ".-> " + prestamos.get(c));
        prestamo = prestamos.get(c);
        System.out.println("> Nueva fecha. ");
        mFechas = new MenuFechas(sc);
        Fecha nfecha = mFechas.intrFecha(sc);
        prestamo.setFecha(nfecha);
        prestamos.set(c, prestamo);        
    }

/// BUSCAR DATOS //////////////////////////////////////////////////////////////
    public void buscarPrestamo() {
        this.salir = false;
        do {
            System.out.println("\n      BUSCAR Préstamo Videoclub ");
            System.out.println("        1. Buscar por codigo socio.");
            System.out.println("        2. Buscar por codigo DVD.");
            System.out.println("        3. Buscar por fecha.");
            System.out.println("        0. Volver.");
            System.out.println(" Selecciona una opción: ");
            opcion = sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case '1': buscar_CodSocio();
                    break;
                case '2': buscar_CodDVD();
                    break;
                case '3': buscar_Fecha();
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

    public void buscar_CodSocio() {
        boolean encontrado = false;
        int cs = intrCodSocio();
        for (int i = 0; i < prestamos.size(); i++) {
            paux = prestamos.get(i);
            if (paux.getCodSocio() == cs) {
                System.out.println(i + ".-> " + prestamos.get(i));
                encontrado = true; 
            }
        }
        if (!encontrado) System.out.println("No se ha encontrado. \n");
    }

    public void buscar_CodDVD() {
        boolean encontrado = false;
        int d = intrCodDVD();
        for (int i = 0; i < prestamos.size(); i++) {
            paux = prestamos.get(i);
            if (paux.getCodDVD() == d) {
                System.out.println(i + ".-> " + prestamos.get(i));
            encontrado = true;
            } 
        }
        if (!encontrado) System.out.println("No se ha encontrado. \n");
    }

    public void buscar_Fecha() {
        boolean encontrado = false;
        mFechas = new MenuFechas(sc);
        Fecha faux = mFechas.intrFecha(sc);
        for (int i = 0; i < prestamos.size(); i++) {
            paux = prestamos.get(i);
            if (paux.getFecha().equals(faux)) {
                System.out.println(i + ".-> " + prestamos.get(i));
                encontrado = true;
            } 
        }
        if (!encontrado) System.out.println("No se ha encontrado. " + faux);
    }
}
