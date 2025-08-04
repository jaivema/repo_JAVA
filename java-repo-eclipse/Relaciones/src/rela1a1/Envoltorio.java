package rela1a1;

public class Envoltorio {
	private String color;
	private Galleta galleta;
	
	public Envoltorio(String color, String sabor, double precio) {
		super();
		this.color = color;
		this.galleta = new Galleta(sabor, precio);
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}

}
