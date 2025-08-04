package com.mycompany.mavenproject8_videoclub.menu;

/**
 *
 * @author Jaime Verdejo Martí
 */
import com.mycompany.mavenproject8_videoclub.ficheros.FicheroPrestamos;
import com.mycompany.mavenproject8_videoclub.ficheros.FicheroDVD;
import com.mycompany.mavenproject8_videoclub.ficheros.FicheroSocios;
import com.mycompany.mavenproject8_videoclub.objetos.Prestamos;
import com.mycompany.mavenproject8_videoclub.objetos.DVD;
import com.mycompany.mavenproject8_videoclub.objetos.Socio;
import java.io.*;
import java.util.*;

public class MenuVideoclub implements Serializable {
    private char opcion;
    private boolean salir;
    private Scanner sc;
    Socio socio;
    DVD dvd;
    Prestamos prestamo;
    ArrayList<Socio> alsocios = new ArrayList();
    ArrayList<DVD> aldvds = new ArrayList();
    ArrayList<Prestamos> alprestamos = new ArrayList();
    FicheroSocios fSocios = new FicheroSocios();
    FicheroDVD fDvds = new FicheroDVD();
    FicheroPrestamos fPrestamos = new FicheroPrestamos();

    public MenuVideoclub() throws ClassNotFoundException, IOException {
        do {
            this.salir = false;
            menu_General();
        } while (this.salir = false);
    }

    public void menu_General() throws ClassNotFoundException, IOException {
        this.sc = new Scanner(System.in);
        char opcion = ' ';
        this.salir = false;
    /// cargo las listas de socios dvds y préstamos.
        alsocios = fSocios.carga_socios();
        aldvds = fDvds.carga_dvds();
        alprestamos = fPrestamos.carga_prestamos();
    ///     
        System.out.println("\n> Sistema cargado.");
        do {
            System.out.println("\n  MENU PRINCIPAL Videoclub ");
            System.out.println("    1. - Socios.");
            System.out.println("    2. - DVDs.");
            System.out.println("    3. - Préstamos.");
            System.out.println("    0. - Salir de la aplicación.");
            System.out.println("                            ");
            System.out.println("> Selecciona opción: ");

            opcion = this.sc.next().toLowerCase().charAt(0);
            switch (opcion) {
                case '1':
                    MenuSocios mSocios = new MenuSocios(sc, alsocios);
                    break;
                case '2':
                    MenuDVD mDVD = new MenuDVD(sc, aldvds);
                    break;
                case '3':
                    MenuPrestamos mPrestamos = new MenuPrestamos(sc, alsocios, aldvds, alprestamos);
                    break;
                case '0':
                    salvarDatos();
                    this.salir = true;
                    break;
                default:
                    System.out.println("> Se ha introducido una opcion incorrecta.");
                    break;
            }
        } while (!this.salir);
        sc.close();
        System.out.println("\n> Sistema finalizado.");
    }

    public void salvarDatos() throws ClassNotFoundException, IOException {
    // GUARDO SOCIOS
        if (alsocios.isEmpty()) System.out.println("> Sin socios que guardar.");
        else fSocios.salva_socios(alsocios);        
    // GUARDO DVDS    
        if (aldvds.isEmpty()) System.out.println("> Sin DVDs que guardar.");
         else fDvds.salva_dvds(aldvds);
    // GUARDO PRESTAMOS    
        if (alprestamos.isEmpty()) System.out.println("> Sin préstamos que guardar.");
        else fPrestamos.salva_prestamos(alprestamos);
    }
}