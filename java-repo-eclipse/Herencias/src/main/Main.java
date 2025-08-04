package main;

import negocio.Deportista;
import negocio.Ingeniero;
import negocio.Persona;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Uso de override y herencia
		System.out.println("\nHerencia y Override:");
		Deportista d1 = new Deportista("Pepe","Futbolista");

		System.out.print(d1.getNombre()+" es ");
		System.out.println(d1.getDeporte());
		
		Persona p1 = new Persona("Manolo");
		Persona p11 = new Persona("Manolo");
		p1.andar();
		
		Deportista d2 = new Deportista("Maria","Atleta");
		d2.andar();
		
		//Uso de Polimorfismo
		System.out.println("\nPolimorfismo:");
		Persona test1 = new Deportista("Juanito", "Boxeador");
		test1.andar();

		Persona p2 = new Deportista("Manuel", "Tenista");
		Persona p3 = new Ingeniero("Lua");
		Ingeniero p4 = new Ingeniero("Elisa");
		Deportista d3 = new Deportista("Luis", "Escalador");
		
		iniciarCaminoPersona(p2);
		iniciarCaminoPersona(p3);
		iniciarCaminoPersona(p4);
		iniciarCaminoPersona(d3);
		
		//Uso de Casting
		System.out.println("\nCasting:");
		Persona p10 = new Deportista("Ana","Treckista");
		//Deportista d4 = p10 //no lo permite
		//System.out.println(p10.getDeporte()); //--> ERROR. A pesar que p10 almacena un deportista
		
		Deportista d4 = (Deportista) p10;
		System.out.println("Nombre: "+d4.getNombre()+" | "+"Deporte: "+d4.getDeporte());
		
		iniciarCaminoPersona(d4);
		iniciarCaminoPersona(p10);
		
		//Ejemplo de igualdad con objetos
		System.out.println("\nIgualdad entre objetos:");
		System.out.println(p1.hashCode());
		System.out.println(p11.hashCode());
		System.out.println("p1==p11: "+p1.equals(p11));
	}
	
	public static void iniciarCaminoPersona(Persona d) {
		d.andar();
	}
}