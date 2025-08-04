package com.mycompany.mavenproject8_videoclub;

/**
 *
 * @author Jaime Verdejo Martí
 */
import com.mycompany.mavenproject8_videoclub.menu.MenuVideoclub;
import java.io.*;

public class MainVideoclub implements Serializable {

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        MenuVideoclub m = new MenuVideoclub();
        System.out.println("\n ...FIN PROGRAMA...\n");
    }
}