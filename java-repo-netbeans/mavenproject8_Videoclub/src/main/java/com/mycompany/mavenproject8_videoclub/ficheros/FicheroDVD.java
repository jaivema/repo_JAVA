package com.mycompany.mavenproject8_videoclub.ficheros;

import com.mycompany.mavenproject8_videoclub.objetos.DVD;
import com.mycompany.mavenproject8_videoclub.menu.MenuDVD;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.ArrayList;

/**
 *
 * @author Jaime Verdejo Martí
 */
public class FicheroDVD implements Serializable {

    public FicheroDVD() {
    }

    public void guardar_fichero(ArrayList<DVD> aldvds) {
        JFileChooser guardarFichero = new JFileChooser();
        String directorioActual = new File("").getAbsolutePath();
        guardarFichero.setCurrentDirectory(new File(directorioActual));
        guardarFichero.setDialogTitle("Seleccione fichero dvds");
        System.out.println("\n> Ventana de selección abierta.");
        int returnVal = guardarFichero.showOpenDialog(null);
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("> CANCELADO POR EL USUARIO");
        } else {
            File abreTex = guardarFichero.getSelectedFile();
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(abreTex.getName()));
                for (int i = 0; i < aldvds.size(); i++) {
                    DVD daux = aldvds.get(i);
                    oos.writeObject(daux);
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

    public ArrayList<DVD> leer_fichero(ArrayList<DVD> aldvds) throws ClassNotFoundException, IOException {
        JFileChooser leerFichero = new JFileChooser();
        String directorioActual = new File("").getAbsolutePath();
        leerFichero.setCurrentDirectory(new File(directorioActual));
        leerFichero.setDialogTitle("Seleccione fichero de texto 'dvds'");
        System.out.println("\n> Ventana de selección abierta.");
        int returnVal = leerFichero.showOpenDialog(null);
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("> CANCELADO POR EL USUARIO");
        } else {
            File abreTex = leerFichero.getSelectedFile();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(abreTex.getName()));
            try {
                DVD daux = (DVD) ois.readObject();
                while (true) {
                    for (int i=0;daux instanceof DVD;i++){
                        //daux = (DVD) daux;
                        int c=daux.getCodigo();
                        MenuDVD mDvd = new MenuDVD(c, aldvds);
                        if(!mDvd.buscar_codigo(c, aldvds)){
                            aldvds.add((DVD) daux);
                            //System.out.println(aldvds.get(i));
                        }else System.out.println("> Socio no introducido "+daux);
                        daux = (DVD) ois.readObject();
                    }
                }
            } catch (EOFException e) {
                System.out.println("> FIN FICHERO.");
            } catch (Exception e) {
                System.out.println("> Algo ha salido mal.");
                e.printStackTrace();
            } finally {
                ois.close();
            }
        }
        return aldvds;
    }
    /// FICHERO DE SALVA ///////////////////////////////////////////////////////
    public void salva_dvds(ArrayList<DVD> aldvds)throws ClassCastException, IOException{
        try {
            FileOutputStream fos = new FileOutputStream("dvds.master");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (int i = 0; i < aldvds.size(); i++) {
                DVD dvd = aldvds.get(i);
                oos.writeObject(dvd);
            }
            System.out.println("> Lista de dvds salvada.");
            oos.close();
        } catch (Exception e) {
            System.out.println("> Algo ha salido mal.");
            e.printStackTrace();
        }
    }
    /// FICHERO DE CARGA ///////////////////////////////////////////////////////
    public ArrayList<DVD> carga_dvds() throws ClassCastException, IOException{
        ArrayList<DVD> aldaux = new ArrayList();
        ArrayList<DVD> aldvds = new ArrayList();
        int contador = 0;
        try {
            FileInputStream fos = new FileInputStream("dvds.master");
            ObjectInputStream ois = new ObjectInputStream(fos);
            DVD dvd = (DVD) ois.readObject();
            while (true) {
                for (int i=0;dvd instanceof DVD;i++){
                    dvd = (DVD) dvd;
                    aldaux.add((DVD) dvd);
                    //System.out.println(aldaux.get(i));
                    contador++;
                    dvd = (DVD) ois.readObject();
                }
            }
        } catch (EOFException e) {
            //System.out.println("> FIN FICHERO.");
        } catch (Exception e) {
            System.out.println("> Algo ha salido mal.");
            e.printStackTrace();
        } finally {
            aldvds = aldaux;
        }
        System.out.println("> Lista de dvds inicializada: " + contador);
        for (int i = 0; i < aldvds.size(); i++) {
            System.out.println(i + ".-> " + aldvds.get(i));
        }
        return aldvds;
    }
}
