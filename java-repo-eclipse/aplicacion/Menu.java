package javaapplication14;
import java.util.ArrayList;
import java.util.Scanner;
public class Menu {
    char salir;
    Scanner sc;
    Coche c;
    public ArrayList<Coche> Concesionario;
    
    public Menu(){    
        Concesionario=new ArrayList<Coche>();
        do{
            this.salir='n';
            Menu_general();               
        } while (this.salir!='s');        
    }    
    public void Menu_general(){
                this.sc= new Scanner(System.in);
		char opcion;
		this.salir = 'n';		
		do
		{                        
                        System.out.println("          MENU PRINCIPAL DE MI APICACIÓN            ");
                        System.out.println("         1.- Introducir datos de un coche           ");
                        System.out.println("         2.- Visualizar datos de un coche           ");
                        System.out.println("         3.- Añadir coche al concesionario          ");
                        System.out.println("         4.- Ver todos los coches del concesionario ");
                        System.out.println("         5.- Buscar un coche por la matricula       ");
                        System.out.println("         6.- Buscar un coche por la marca           ");
                        System.out.println("         7.- Buscar un coche por el modelo          ");
                        System.out.println("         8.- Buscar un coche por el kilometraje     ");
                        System.out.println("         0.- Salir");        
                        System.out.println("                                                    ");
                        System.out.println("                   Selecciona opción:   ");                            
                        
			opcion = this.sc.next().toLowerCase().charAt(0);
                        c=null;
			switch(opcion)
			{
                            case '1':
                                c=this.introducir_datos_coche();   
                                anadir_coche_concesionario(c);
				break;
                            case '2':
				this.ver_datos_coche();
				break;
                            case '3':
                                c=null;
				this.anadir_coche_concesionario(c);
				break;
                            case '4':
                                this.listar_coches_concesionario();
				break;
                            case '5':
                                this.buscar_coche_matricula();
				break;
                            case '6':
                                this.buscar_coche_marca();
				break;
                            case '7':
                                this.buscar_coche_modelo();
				break;  
                            case '8':
                                this.buscar_coche_km();
				break;                       
                            case '0':
				salir='s';
				break;
                            default:
				System.out.println("No se ha introducido una opcion correcta.");
                                System.out.println("Introduce un numero del 1 al 5 para seleccionar una opcion y 0 para Salir del Programa");
				break;
			}
			if (opcion!='0'){
                            System.out.println("Pulse tecla para continuar......");
                            this.sc.nextLine();//Limpiamos buffer de entrada
                        }			
		}while (this.salir != 's');
		this.sc.close();
	} 
    public Coche introducir_datos_coche(){
        String matricula;
        String marca;
        String modelo;
        int Km;
        Coche aux1;  //Variable auxiliar que contendrá la referencia a cada coche nuevo.                
            System.out.println(" Mi Coche ");
            System.out.println("Introduce la Matrícula del coche:  ");
            matricula = sc.next();          
            System.out.println("Introduce la Marca del coche: ");
            marca = sc.next();
            System.out.println("Introduce la Modelo del coche: ");
            modelo = sc.next();
            System.out.println("Introduce el Número de Kilómetros del coche: ");
            Km = sc.nextInt();
            aux1 =new Coche(matricula,marca,modelo,Km);
            aux1.Visualizar();
            System.out.println(" Con toString  "+aux1.toString());
            return aux1;
    }
    public void ver_datos_coche(){
        this.c.Visualizar();
        System.out.println(this.c.toString());
    }
    public void anadir_coche_concesionario(Coche caux){
        if (caux==null){
            caux=this.introducir_datos_coche();  
        }       
        this.Concesionario.add(caux);
    }
    
    public void listar_coches_concesionario(){
        for(int i = 0; i<this.Concesionario.size(); i++){
            //System.out.println(Concesionario.get(i).toString());
            this.c=Concesionario.get(i);
            if(this.c!=null) this.c.Visualizar();
        }    
    }
    public void buscar_coche_matricula(){
        boolean encontrado = false;
        String matricula=new String();        
        Coche c=new Coche();        
        System.out.println("Introduce la matricula del coche que quieres buscar: ");
        matricula=sc.next();
        for (int x = 0; x < Concesionario.size(); x++) {
                c = Concesionario.get(x);
                if (c.getMatricula().toLowerCase().equals(matricula.toLowerCase())) {
                    encontrado = true;
                    break; // Terminar ciclo, pues ya lo encontramos
                }
        }
        if (encontrado){
            System.out.println("Se ha encontrado un coche que coincide con la matricula solicitada \n"+c.toString());            
        }
    
    }
    public void buscar_coche_marca(){
        boolean encontrado = false;
        int contador=0;
        String marca=new String();        
        Coche c=new Coche();        
        System.out.println("Introduce la maraca del coche que quieres buscar: ");
        marca=sc.next();
        for (int x = 0; x < Concesionario.size(); x++) {
                c = Concesionario.get(x);
                if (c.getMarca().toLowerCase().equals(marca.toLowerCase())) {
                    contador++;
                    System.out.println("Ccoche "+contador+" "+c.toString()); 
                    encontrado=true;
                }
        }
        if (encontrado){
            System.out.println("Se han encontrado "+contador+ " coches que coincide con la marca solicitada \n"+marca);            
        }    
    }
    public void buscar_coche_modelo(){
        boolean encontrado = false;
        int contador=0;
        String modelo=new String();        
        Coche c=new Coche();        
        System.out.println("Introduce la maraca del coche que quieres buscar: ");
        modelo=sc.next();
        for (int x = 0; x < Concesionario.size(); x++) {
                c = Concesionario.get(x);
                if (c.getMarca().toLowerCase().equals(modelo.toLowerCase())) {
                    contador++;
                    System.out.println("Ccoche "+contador+" "+c.toString()); 
                    encontrado=true;
                }
        }
        if (encontrado){
            System.out.println("Se han encontrado "+contador+ " coches que coincide con el modelo solicitada \n"+modelo);            
        }    
    }
    public void buscar_coche_km(){
        boolean encontradoar = false,encontradoab=false;
        int contadorarriba=0, contadorabajo=0;
        int kilom=0;
        Coche c=new Coche(); 
        ArrayList<Coche> larr,laba;
        larr=new ArrayList<Coche>();
        laba=new ArrayList<Coche>();
        System.out.println("Introduce el kilometraje del coche para realizar la busqueda: ");
        kilom=sc.nextInt();
        for (int x = 0; x < Concesionario.size(); x++) {
                c = Concesionario.get(x);
                if (c.getKm()>=kilom) {
                    contadorarriba++;
                    larr.add(c);
                    //System.out.println("Ccoche "+contadorarriba+" "+c.toString()); 
                    encontradoar=true;
                }
                if(c.getKm()<kilom){
                    contadorabajo++;
                    laba.add(c);
                    encontradoab=true;
                }
        }
        if (encontradoar){
            System.out.println("Se han encontrado los siguientes coches con un kilometraje igual o superior al introducido");
            c=null;
            for (int i=0; i<larr.size();i++){
                c=larr.get(i);
                System.out.println("Coche "+i+" "+c.toString());
            }           
        } 
        if (encontradoab){
            System.out.println("Se han encontrado los siguientes coches con un kilometraje inferior al introducido");
            c=null;
            for (int i=0; i<laba.size();i++){
                c=laba.get(i);
                System.out.println("Coche "+i+" "+c.toString());
            }           
        }         
    }    
}
