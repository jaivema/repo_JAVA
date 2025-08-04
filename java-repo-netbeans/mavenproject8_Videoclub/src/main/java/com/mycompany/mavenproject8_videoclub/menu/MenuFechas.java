package com.mycompany.mavenproject8_videoclub.menu;

import com.mycompany.mavenproject8_videoclub.objetos.Fecha;
import java.util.Scanner;

/**
 *
 * @author Jaime Verdejo Martí
 */
public class MenuFechas {
    Scanner sc;
    Fecha fecha;
    char opcion=' ';
    
    public MenuFechas(Scanner s){
    }
    
    public Fecha crear_fechas(Scanner s) {
        sc = new Scanner(System.in);
        Fecha fecha = new Fecha();
        System.out.println("\n      FECHA DE ALTA ");
        System.out.println("        1. - Fecha de hoy.");
        System.out.println("        2. - Fecha usuario.");
        System.out.println("                                   ");
        System.out.println("> Selecciona opción: ");

        opcion = this.sc.next().toLowerCase().charAt(0);
        switch (opcion) {
            case '1': fecha = new Fecha();
                break;
            case '2': fecha = this.intrFecha();
                break;
            default:
                System.out.println("Se ha introducido una opcion incorrecta.");
                break;
        }
        return fecha;
    }

    public Fecha intrFecha() {
        int d, m, a;
        Fecha faux = new Fecha();
        do {
            System.out.println("Introduce el año: ");
            a = sc.nextInt();
        } while (!faux.setAnio(a));
        do {
            System.out.println("Introduce el mes: ");
            m = sc.nextInt();
        } while (!faux.setMes(m));
        do {
            System.out.println("Introduce el dia: ");
            d = sc.nextInt();
        } while (!faux.setDia(d, m, a));

        return faux;
    }
    public Fecha intrFecha(Scanner s) {
        sc = new Scanner(System.in);
        int d, m, a;
        Fecha faux = new Fecha();
        do {
            System.out.println("Introduce el año: ");
            a = sc.nextInt();
        } while (!faux.setAnio(a));
        do {
            System.out.println("Introduce el mes: ");
            m = sc.nextInt();
        } while (!faux.setMes(m));
        do {
            System.out.println("Introduce el dia: ");
            d = sc.nextInt();
        } while (!faux.setDia(d, m, a));

        return faux;
    }
}
