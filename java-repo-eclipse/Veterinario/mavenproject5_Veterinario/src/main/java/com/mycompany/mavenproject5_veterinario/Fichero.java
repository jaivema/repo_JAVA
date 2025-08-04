package com.mycompany.mavenproject5_veterinario;

import java.io.*;
import javax.swing.JFileChooser;
import java.util.ArrayList;

public class Fichero implements Serializable{

    public Fichero() {
    }
    
    public void guardar_fichero(ArrayList<Mascota> veterinario)throws ClassNotFoundException, IOException{
        JFileChooser guardarFichero=new JFileChooser();
        String directorioActual = new File("").getAbsolutePath();
        guardarFichero.setCurrentDirectory(new File(directorioActual));
        guardarFichero.setDialogTitle("Seleccione fichero");
        guardarFichero.showOpenDialog(null);
        File abreTex=guardarFichero.getSelectedFile(); 
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(abreTex.getName()));

            if (veterinario.size()<=0) {
               System.out.println("La clínica no contiene mascotas todavía. Añade una mascota a la clínica antes de guardar");
               return;
            } else{
                for (int i = 0; i < veterinario.size(); i++){
                    Mascota aux=veterinario.get(i);
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
    
    public ArrayList<Mascota> leer_fichero(ArrayList<Mascota> veterinario) throws ClassNotFoundException, IOException{
        int contador=0;       
        veterinario.clear();
        Mascota laux=null;
        JFileChooser leerFichero=new JFileChooser();
        String directorioActual = new File("").getAbsolutePath();
        leerFichero.setCurrentDirectory(new File(directorioActual));
        leerFichero.setDialogTitle("Seleccione fichero de texto");
        leerFichero.showOpenDialog(null);
        File abreTex=leerFichero.getSelectedFile(); 
        ObjectInputStream ois= new ObjectInputStream(new FileInputStream(abreTex.getName()));
        try {
            laux=(Mascota)ois.readObject();
            while (true){
                if (laux instanceof Mascota){
                    laux=(Mascota)laux;
                    veterinario.add((Mascota)laux);
                    System.out.println(veterinario.get(contador));
                    contador++;
                }
                laux=(Mascota)ois.readObject();
            }
        } catch (EOFException e){
            System.out.println("> FIN FICHERO.");
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            ois.close();
        }
        return veterinario;
    }
}