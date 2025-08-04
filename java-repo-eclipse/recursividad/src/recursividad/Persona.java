package recursividad;

import java.util.ArrayList;
import java.util.Objects;

public class Persona {
	private String nombre;
	private ArrayList<Persona> amigos = new ArrayList<Persona>();
	
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
	
	public ArrayList<Persona> getAmigos(){
		return amigos;
	}

	public void addAmigo(Persona persona) {
		amigos.add(persona);
	}
	
	public void eliminarAmigo(Persona persona) {
		amigos.remove(persona);
	}
	
	public int indexOf(Object o) {
		return amigos.indexOf(o);
	}

	
	public Persona get(int index) {
		return amigos.get(index);
	}

	public int size() {
		return amigos.size();
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
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
		return Objects.equals(nombre, other.nombre);
	}
	
	
}
