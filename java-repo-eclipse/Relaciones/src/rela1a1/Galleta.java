package rela1a1;

public class Galleta {
	private String sabor;
	private double precio;
	
	public Galleta(String sabor, double precio) {
		super();
		this.sabor = sabor;
		this.precio = precio;
	}

	public String getSabor() {
		return sabor;
	}

	public void setSabor(String sabor) {
		this.sabor = sabor;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
