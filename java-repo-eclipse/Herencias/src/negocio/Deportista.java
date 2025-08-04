package negocio;

public class Deportista extends Persona{
	
	private String deporte;
	
	// los constructores NO se heredan!!
	public Deportista(String nombre, String deporte) {
		super(nombre);
		this.deporte = deporte;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
	}
	
	public void andar() {
		super.imprimeTexto();
		System.out.println(" 15 Km/h "+"y es "+getDeporte());
	}
	
	//restringido
	void deportes() {
		System.out.println("Deporte."+getDeporte());
	}
}