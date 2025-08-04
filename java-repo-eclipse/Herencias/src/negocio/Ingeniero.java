package negocio;


public class Ingeniero extends Persona {
	
	public Ingeniero(String nombre) {
		super(nombre);
	}
	
	public void andar() {
		System.out.println(getNombre()+" camina a 3 Km/h y es Ingeniera");
	}

}
