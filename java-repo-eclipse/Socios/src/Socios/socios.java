package Socios;
import java.util.Scanner;

public class socios {

	Scanner entradas = new Scanner(System.in);
	
	String nombre, apellidos, calle, ciudad, provincia, pais;
	String numero, codigopostal;
	String matriz[][];
	String cadena;
	
	int numerodesocios;
	public socios(int numerodesocios) {
		super();
		this.numerodesocios = numerodesocios;
	}
	
	
	
	
	public void modificar() {
		
		String lectura;
		//String matriz2[][]=matriz;
		
		System.out.println("LISTA DE SOCIOS");
		
		for (int i=1;i<=numerodesocios;i++) {
			System.out.println("Socio numero " +(i)+ ":" +matriz[i-1][0]);	
		}
		
		System.out.print("Introduce el numero de socio a modificar: ");
		lectura = entradas.nextLine();
		int numerodesocio = Integer.parseInt(lectura);
		
		System.out.print("Nombre: ");
		nombre = entradas.nextLine();
		matriz[numerodesocio-1][0]=nombre;
		
		System.out.print("Apellidos: ");
		apellidos = entradas.nextLine();
		matriz[numerodesocio-1][1]=apellidos;
		
		System.out.print("Calle: ");
		calle = entradas.nextLine();
		matriz[numerodesocio-1][2]=calle;
		
		System.out.print("Numero: ");
		numero = entradas.nextLine();
		matriz[numerodesocio-1][3]=numero;
		
		System.out.print("Ciudad: ");
		ciudad = entradas.nextLine();
		matriz[numerodesocio-1][4]=ciudad;
		
		System.out.print("Provincia: ");
		provincia = entradas.nextLine();
		matriz[numerodesocio-1][5]=provincia;
		
		System.out.print("Pais: ");
		pais = entradas.nextLine();
		matriz[numerodesocio-1][6]=pais;
		
		System.out.print("Codigo Postal: ");
		codigopostal = entradas.nextLine();
		matriz[numerodesocio-1][7]=codigopostal;
	}
	
	
	
	
	
	
	public void altasocios() {
		
		String lectura;
		matriz=new String[numerodesocios][8];
		
		System.out.print("Numero de socios: ");
		lectura = entradas.nextLine();
		numerodesocios = Integer.parseInt(lectura);
		
		try {
			for (int z=1;z<=numerodesocios;z++) {
				System.out.println("Socio numero "+z);
				
				System.out.print("Nombre: ");
				nombre = entradas.nextLine();
				matriz[z-1][0]=nombre;
	
				System.out.print("Apellidos: ");
				apellidos = entradas.nextLine();
				matriz[z-1][1]=apellidos;
				
				System.out.print("Calle: ");
				calle = entradas.nextLine();
				matriz[z-1][2]=calle;
				
				System.out.print("Numero: ");
				numero = entradas.nextLine();
				matriz[z-1][3]=numero;
				
				System.out.print("Ciudad: ");
				ciudad = entradas.nextLine();
				matriz[z-1][4]=ciudad;
				
				System.out.print("Provincia: ");
				provincia = entradas.nextLine();
				matriz[z-1][5]=provincia;
				
				System.out.print("Pais: ");
				pais = entradas.nextLine();
				matriz[z-1][6]=pais;
				
				System.out.print("Codigo Postal: ");
				codigopostal = entradas.nextLine();
				matriz[z-1][7]=codigopostal;
			}
			
		}catch(Exception e) {
			System.out.println("Error al crear la matriz: " + e.getMessage());
		}
		
	}
	
	public void mostrarMatriz() {
		try{
			for (int x=1; x<=numerodesocios; x++){
				cadena = "";
				
				for (int y=0; y<=7; y++){
					cadena = cadena +"  "+ matriz[x-1][y] + " ";
				}
				System.out.println(cadena);
			}		
  		}catch(Exception e) {
  			System.out.println("Error al leer la matriz: " + e.getMessage());
  		}
	}
	
	public void mostrarFicha() {
		for (int x=1; x<=numerodesocios; x++){
			System.out.println("******************************");
			System.out.println("Socio numero: " + x);
			System.out.println("******************************");
			System.out.println("* Nombre:        " + matriz[x-1][0]);
			System.out.println("* Apellidos:     " + matriz[x-1][1]);
			System.out.println("* Calle:         " + matriz[x-1][2]);
			System.out.println("* Numero:        " + matriz[x-1][3]);
			System.out.println("* Ciudad:        " + matriz[x-1][4]);
			System.out.println("* Provincia:     " + matriz[x-1][5]);
			System.out.println("* País:          " + matriz[x-1][6]);
			System.out.println("* Código postal: " + matriz[x-1][7]);
		}
	}
	
	public void mostrarSwitch() {
		
		for (int x=1; x<=numerodesocios; x++){
			System.out.println("******************************");
			System.out.println("Socio numero: " + x);
			System.out.println("------------------------------");
			
			for (int z=0; z<=7; z++) {
				switch(z){
					case 0:
						System.out.println("* Nombre:        " + matriz[x-1][z]);
						break;
					case 1:
						System.out.println("* Apellidos:     " + matriz[x-1][z]);
						break;
					case 2:
						System.out.println("* Calle:         " + matriz[x-1][z]);
						break;
					case 3:
						System.out.println("* Numero:        " + matriz[x-1][z]);
						break;
					case 4:
						System.out.println("* Ciudad:        " + matriz[x-1][z]);
						break;
					case 5:
						System.out.println("* Provincia:     " + matriz[x-1][z]);
						break;
					case 6:
						System.out.println("* País:          " + matriz[x-1][z]);
						break;
					case 7:
						System.out.println("* Código postal: " + matriz[x-1][z]);
						break;
					default:
						System.out.println("Error al mostrar ficha");
						break;
				}
			}
		}  		
	}
	public void cerrarScan() {
		entradas.close();
	}
}
