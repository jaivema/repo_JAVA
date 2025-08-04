package Coches;
//import java.util.Scanner; //libreria para introducir el numero de coches

public class PrincipalCoches {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Este el proyecto coches generado el 13 de Julio del 2022\n");
		
		//Declaración de 2 objetos clase coche:
		Coche coche  = new Coche("","","",0,0);
		Coche coche1 = new Coche("Opel","Vectra","BLANCO",1600,2);
		Coche coche2 = new Coche("Seat","Cupra","Rojo",1900,3);
		Coche coche3 = new Coche("Seat","Cupra","negro",1900,3);
		Coche coche4 = new Coche("Citroen","DS4","Verde",1600,5);
		
		
		
		System.out.println("test aumenta MOTOR coche1 con motor de serie " + coche1.getMotor() + "c.c." 
				+ "aumentado en 50 -> " + coche1.Increm(coche1.getMotor()) + "c.c.");
		System.out.println("test aumenta MOTOR coche2 con motor de serie " + coche2.getMotor() + "c.c." 
				+ "aumentado en 50 -> " + coche2.Increm(coche2.getMotor()) + "c.c.");
		
		
		
		
		//Comparacion de objetos Coche
		System.out.println("\nCoche1 es igual a Coche2?: " 
				+ coche.compObj(coche1, coche2));
		System.out.println("Coche2 es igual a Coche3?: " 
				+ coche.compObj(coche2, coche3));
		
		
		
		
		//otra funcion para incrementar el motor.
		coche1.Incremthis();
		System.out.println("Motor coche1: " + coche1.getMotor());
		
		//System.out.println("\nAumento el motor y la cilindrada para casuistica OR con la funcion Iplus()\n");
		//coche.IplusMotor(coche2);
		//coche.IplusCilin(coche3);
		
		System.out.println("Motorcoche2: " + coche2.getMotor() +  " Motorcoche3: " + coche3.getMotor()
		+ "\nCilindrada coche2: " + coche2.getCilindrada() + " Cilindrada coche3: " + coche3.getCilindrada()
		+ "\nColor coche2: " + coche2.getColor() + " Color coche3: " + coche3.getColor());
		
		System.out.println("\nCoche2 es igual a Coche3?: " 
				+ coche.compObj(coche2, coche3)+"\n");
		
		
		
		
		//Condicionales IF
		System.out.println("coche1 " + coche1.QueColorEs());
		System.out.println("coche2 " + coche2.QueColorEs());
		System.out.println("coche3 " + coche3.QueColorEs());
		System.out.println("coche4 " + coche4.QueColorEs());
		System.out.println("\n");
		
		//Condicional SWITCH
		System.out.println("coche1 " + coche1.SwitchPuertas());
		System.out.println("coche3 " + coche3.SwitchPuertas());
		System.out.println("coche4 " + coche4.SwitchPuertas());
		System.out.println("\n");
		
		
		
		
		//Entrada de coche nuevo por el usuario
		
		//coche.nuevocoche(coche);	//paso el objeto inicializado a la función nuevocoche. 
		
		//System.out.println("Nuevo coche agregado: "+coche.getMarca()+" "+coche.getModel()+" "+coche.getColor()
		//										+" "+coche.getMotor()+" "+coche.getCilindrada()+" "+coche.getPortes());
		
		
		
		//Entrada de numero de coches introducido por el usuario
		coche.PreguntaCoches();
		coche.cerrarscanner();
		
		
	}

}
