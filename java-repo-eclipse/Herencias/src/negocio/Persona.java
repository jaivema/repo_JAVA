package negocio;

public class Persona {
	private String nombre;
	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	void imprimeTexto() {
		System.out.print(getNombre() + " camina a");
	}
	
	public void andar() {
		imprimeTexto();
		System.out.println(" 5 Km/h");
	}

}
