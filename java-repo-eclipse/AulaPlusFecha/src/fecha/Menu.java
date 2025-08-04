package fecha;

import java.util.Scanner;

public class Menu {
    char opcion;
    Scanner entrada;

    public Menu() {
        this.opcion = ' ';
        char op = ' ';
        entrada = new Scanner(System.in);
        
        do{
            opcion = Menu_general();
            
            switch(opcion) {
                case '1':
                    opcion = Menu_Fechas();
                    break;
                case '2':
                    opcion = Menu_Alumnos();
                    break;
                case '0':
                    System.out.println("****** PROGRAMA FINALIZADO ******");
                    entrada.close();
                    return;
            }
        }while(op!='0');
    }

    public char Menu_general() {
        char o = ' ';
        do {
            System.out.println("***** MENU PRINCIPAL *******");
            System.out.println("   1. - Gestionar fechas.   ");
            System.out.println("   2. - Gestionar alumnos.  ");
            System.out.println("   0. - Salir.              ");
            System.out.println("                            ");
            System.out.println("   Selecciona opción: ");
            o = entrada.nextLine().charAt(0);
        }while ((o< '0') || (o>'2'));
        return o;
    }

    public char Menu_Fechas() {
        char o = ' ';
        do {
            System.out.println("****** MENU FECHAS ********");
            System.out.println("         1. - Modificar fecha.    ");
            System.out.println("         2. - Mnoseque fecha.     ");
            System.out.println("         0. - Salir.              ");
            System.out.println("                            ");
            System.out.println("   Selecciona opción: ");
            o = entrada.nextLine().charAt(0);
        }while ((o< '0') || (o>'2'));
        return o;
    }

    public char Menu_Alumnos() {
        char o = ' ';
        do {
            System.out.println("****** MENU ALUMNOS********");
            System.out.println("         1. - Nuevo almuno.       ");
            System.out.println("         2. - Modificar alumno.   ");
            System.out.println("         0. - Salir.              ");
            System.out.println("                            ");
            System.out.println("   Selecciona opción: ");
            o = entrada.nextLine().charAt(0);
        }while ((o< '0') || (o> '2'));
        return o;
    }
}