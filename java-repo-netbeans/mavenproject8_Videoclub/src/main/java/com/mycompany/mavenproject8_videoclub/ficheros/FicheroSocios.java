package com.mycompany.mavenproject8_videoclub.ficheros;

import com.mycompany.mavenproject8_videoclub.objetos.Socio;
import com.mycompany.mavenproject8_videoclub.menu.MenuSocios;
import java.io.*;
import javax.swing.JFileChooser;
import java.util.ArrayList;

/**
 *
 * @author Jaime Verdejo Martí
 */
public class FicheroSocios implements Serializable {

    public FicheroSocios() {

    }

    public void guardar_fichero(ArrayList<Socio> alsocios) {
        JFileChooser guardarFichero = new JFileChooser();
        String directorioActual = new File("").getAbsolutePath();
        System.out.println(directorioActual);
        guardarFichero.setCurrentDirectory(new File(directorioActual));
        guardarFichero.setDialogTitle("Seleccione fichero socios");
        System.out.println("\n> Ventana de selección abierta.");
        int returnVal = guardarFichero.showOpenDialog(null);
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("> CANCELADO POR EL USUARIO");
        } else {
            File abreTex = guardarFichero.getSelectedFile();
            try {
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(abreTex.getName()));
                for (int i = 0; i < alsocios.size(); i++) {
                    Socio saux = alsocios.get(i);
                    oos.writeObject(saux);
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

    public ArrayList<Socio> leer_fichero(ArrayList<Socio> alsocios) throws ClassNotFoundException, IOException {
        JFileChooser leerFichero = new JFileChooser();
        String directorioActual = new File("").getAbsolutePath();
        leerFichero.setCurrentDirectory(new File(directorioActual));
        leerFichero.setDialogTitle("Seleccione fichero de texto 'socios'");
        System.out.println("\n> Ventana de selección abierta.");
        int returnVal = leerFichero.showOpenDialog(null);
        if (returnVal == JFileChooser.CANCEL_OPTION) {
            System.out.println("> CANCELADO POR EL USUARIO");
        } else {
            File abreTex = leerFichero.getSelectedFile();
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(abreTex.getName()));
            try {
                Socio saux = (Socio) ois.readObject();
                while (true) {
                    for (int i=0;saux instanceof Socio;i++){
                        //saux = (Socio) saux;
                        int c=saux.getCodigo();
                        MenuSocios mSocios = new MenuSocios(c, alsocios);
                        if(!mSocios.buscar_codigo(c, alsocios)){
                            alsocios.add((Socio) saux);
                            //System.out.println(alsocios.get(i));
                        }else System.out.println("> Socio no introducido "+saux);
                        saux = (Socio) ois.readObject();
                    }
                }
            } catch (EOFException e) {
                System.out.println("> FIN FICHERO.");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ois.close();
            }
        }
        return alsocios;
    }
    
    /// FICHERO DE CARGA ///////////////////////////////////////////////////////
    public ArrayList<Socio> carga_socios()throws ClassCastException, IOException{
        ArrayList<Socio> alsocios = new ArrayList();
        ArrayList<Socio> alsaux = new ArrayList();
        int contador = 0;
        try {
            FileInputStream fos = new FileInputStream("socios.master");
            ObjectInputStream ois = new ObjectInputStream(fos);
            Socio socio = (Socio) ois.readObject();
            while (true) {
                for (int i=0;socio instanceof Socio;i++){
                    socio = (Socio) socio;
                    alsaux.add((Socio) socio);
                    //System.out.println(alsaux.get(contador));
                    contador++;
                    socio = (Socio) ois.readObject();
                }
            }
        } catch (EOFException e) {
            //System.out.println("> FIN FICHERO.");
        } catch (Exception e) {
            System.out.println("> Algo ha salido mal.");
            e.printStackTrace();
        } finally {
            alsocios = alsaux;
        }
        System.out.println("> Lista de socios inicializada: " + contador);
        for (int i = 0; i < alsocios.size(); i++) {
            System.out.println(i + ".-> " + alsocios.get(i));
        }
        return alsocios;
    }
    /// FICHERO DE SALVA //////////////////////////////////////////////////////
    public void salva_socios(ArrayList<Socio> alsocios)throws ClassCastException, IOException{
        try {
            FileOutputStream fos = new FileOutputStream("socios.master");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            for (int i = 0; i < alsocios.size(); i++) {
                Socio socio = alsocios.get(i);
                oos.writeObject(socio);
            }
            System.out.println("> Lista de socios salvada.");
            oos.close();
        } catch (Exception e) {
            System.out.println("> Algo ha salido mal.");
            e.printStackTrace();
        }
    }
}
