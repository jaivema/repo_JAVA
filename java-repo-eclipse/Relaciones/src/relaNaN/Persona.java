package relaNaN;

import java.util.ArrayList;
import java.util.Objects;

public class Persona {
	private String nombre;
	private ArrayList<Casa> casas;
	
	public Persona(String nombre) {
		super();
		this.nombre = nombre;
		this.casas = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean contains(Object o) {
		return casas.contains(o);
	}

	public boolean add(Casa e) {
		return casas.add(e);
	}

	@Override
	public int hashCode() {
		return Objects.hash(casas, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(casas, other.casas) && Objects.equals(nombre, other.nombre);
	}
	
	
	
}
