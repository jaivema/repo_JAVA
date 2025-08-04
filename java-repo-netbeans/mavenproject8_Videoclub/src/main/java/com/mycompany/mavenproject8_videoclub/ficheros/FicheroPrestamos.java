package com.mycompany.mavenproject8_videoclub.ficheros;

import com.mycompany.mavenproject8_videoclub.objetos.Prestamos;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.ArrayList;

/**
 *
 * @author Jaime Verdejo Martí
 */
public class FicheroPrestamos implements Serializable {

    public FicheroPrestamos() {
    }

    public void guardar_fichero(ArrayList<Prestamos> alprestamos) {
        JFileChooser guardarFichero = new JFileChooser();
        String directorioActual = new File("").getAbsolutePath();
        guardarFichero.setCurrentDirectory(new File(directorioActual));
        guardarFichero.setDialogTitle("Seleccione fichero prestamos");
        System.out.println("\n> Ventana de selección abierta.");
        int returnVal = guardarFichero.showOpenDialog(null);
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("> CANCELADO POR EL USUARIO");
        } else {
            File abreTex = guardarFichero.getSelectedFile();
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(abreTex.getName()));
                for (int i = 0; i < alprestamos.size(); i++) {
                    Prestamos paux = alprestamos.get(i);
                    oos.writeObject(paux);
                }
                oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String directorio = abreTex.getPath();
            System.out.println(directorio);
            System.out.println("> LISTA GUARDADA.");
        }
    }

    public ArrayList<Prestamos> leer_fichero(ArrayList<Prestamos> alprestamos) throws ClassNotFoundException, IOException {
        JFileChooser leerFichero = new JFileChooser();
        String directorioActual = new File("").getAbsolutePath();
        leerFichero.setCurrentDirectory(new File(directorioActual));
        leerFichero.setDialogTitle("Seleccione fichero de texto 'prestamos'");
        System.out.println("\n> Ventana de selección abierta.");
        int returnVal = leerFichero.showOpenDialog(null);
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("> CANCELADO POR EL USUARIO");
        } else {
            File abreTex = leerFichero.getSelectedFile();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(abreTex.getName()));
            try {
                Prestamos paux = (Prestamos) ois.readObject();
                while (true) {
                    for (int i=0;paux instanceof Prestamos;i++){
                        //paux = (Prestamos) paux;
                        alprestamos.add((Prestamos) paux);
                        paux = (Prestamos) ois.readObject();
                    }
                }
            } catch (EOFException e) {
                System.out.println("> FIN FICHERO.");
            } catch (Exception e) {
                System.out.println("> Algo ha salido mal");
                e.printStackTrace();
            } finally {
                ois.close();
            }
        }
        return alprestamos;
    }
    public ArrayList<Prestamos> carga_prestamos() throws ClassCastException, IOException{
        ArrayList<Prestamos> alprestamos = new ArrayList();
        ArrayList<Prestamos> alpaux = new ArrayList();
        int contador = 0;
        try {
            FileInputStream fos = new FileInputStream("prestamos.master");
            ObjectInputStream ois = new ObjectInputStream(fos);
            Prestamos prestamo = (Prestamos) ois.readObject();
            while (true) {
                for (int i=0;prestamo instanceof Prestamos;i++){
                    prestamo = (Prestamos) prestamo;
                    alpaux.add((Prestamos) prestamo);
                    //System.out.println(alpaux.get(contador));
                    contador++;
                    prestamo = (Prestamos) ois.readObject();
                }
            }
        } catch (EOFException e) {
            //System.out.println("> FIN FICHERO.");
        } catch (Exception e) {
            System.out.println("> Algo ha salido mal.");
            e.printStackTrace();
        } finally {
            alprestamos = alpaux;
        }
        System.out.println("> Lista de prestamos inicializada: " + contador);
        for (int i = 0; i < alprestamos.size(); i++) {
            System.out.println(i + ".-> " + alprestamos.get(i));
        }
        return alprestamos;
    }
    public void salva_prestamos(ArrayList<Prestamos> alprestamos)throws ClassCastException, IOException{
        try {
            FileOutputStream fos = new FileOutputStream("prestamos.master");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < alprestamos.size(); i++) {
                Prestamos prestamo = alprestamos.get(i);
                oos.writeObject(prestamo);
            }
            System.out.println("> Lista de préstamos salvada.");
            oos.close();
        } catch (Exception e) {
            System.out.println("> Algo ha salido mal.");
            e.printStackTrace();
        }
    }
}