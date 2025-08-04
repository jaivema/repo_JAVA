package relaNaN;

public class Principal {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		Casa c = new Casa("Vigo");
		
		Persona p1 = new Persona("Pepe");
		Persona p2 = new Persona("Alicia");
		
		c.add(p1);
		c.add(p2);
		
		System.out.println(c.contains(new Persona("Pepe")));
		System.out.println(c.contains(new Persona("Alicia")));
		System.out.println(c.contains(new Persona("Manolo")));
		System.out.println(c.totalPersonas());
		
		p1.add(c);
		
		System.out.println(p1.contains(c));
		System.out.println(p1.contains(new Casa("Vigo")));
	}

}
