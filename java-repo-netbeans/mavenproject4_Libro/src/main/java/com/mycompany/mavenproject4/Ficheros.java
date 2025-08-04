package com.mycompany.mavenproject4;

import java.io.*;
import javax.swing.JFileChooser;
import java.util.ArrayList;

public class Ficheros implements Serializable{

    public Ficheros() {
    }
    
    public void guardar_fichero(ArrayList<Libro> libreria){
        JFileChooser guardarFichero=new JFileChooser();
        String directorioActual = new File("").getAbsolutePath();
        guardarFichero.setCurrentDirectory(new File(directorioActual));
        guardarFichero.setDialogTitle("Seleccione fichero");
        guardarFichero.showOpenDialog(null);
        File abreTex=guardarFichero.getSelectedFile(); 
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(abreTex.getName()));

            if (libreria.size()<=0) {
               System.out.println("La librería no contiene libros todavía. Añade un libro a la librería antes de guardar");
               return;
            } else{
                for (int i = 0; i < libreria.size(); i++){
                    Libro aux=libreria.get(i);
                    oos.writeObject(aux);
                }
            }
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String directorio=abreTex.getPath();
        System.out.println(directorio);
        System.out.println("> LISTA GUARDADA.");
    }
    
    public ArrayList<Libro> leer_fichero(ArrayList<Libro> libreria) throws ClassNotFoundException, IOException{
        int contador=0;       
        libreria.clear();
        Libro laux=null;
        JFileChooser leerFichero=new JFileChooser();
        String directorioActual = new File("").getAbsolutePath();
        leerFichero.setCurrentDirectory(new File(directorioActual));
        leerFichero.setDialogTitle("Seleccione fichero de texto");
        leerFichero.showOpenDialog(null);
        File abreTex=leerFichero.getSelectedFile(); 
        ObjectInputStream ois= new ObjectInputStream(new FileInputStream(abreTex.getName()));
        try {
            laux=(Libro)ois.readObject();
            while (true){
                if (laux instanceof Libro){
                    laux=(Libro)laux;
                    libreria.add((Libro)laux);
                    System.out.println(libreria.get(contador));
                    contador++;
                }
                laux=(Libro)ois.readObject();
            }
        } catch (EOFException e){
            System.out.println("> FIN FICHERO.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ois.close();
        }
        return libreria;
    }
}
