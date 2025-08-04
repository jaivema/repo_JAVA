package relaNaN;

import java.util.ArrayList;

public class Casa {
	private String direccion;
	private ArrayList<Persona> personas;
	
	public Casa(String direccion) {
		super();
		this.direccion = direccion;
		this.personas = new ArrayList<>();
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	//Metodos delegados de ArrayList autogenerados
	public boolean contains(Object o) {
		return personas.contains(o);
	}
	
	public boolean add(Persona e) {
		return personas.add(e);
	}
	
	public int totalPersonas() {
		return personas.size();
	}
	
}
