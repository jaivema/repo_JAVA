package metodoAbstracto;

public abstract class Vehiculo {
	private String marca;

	protected Vehiculo(String marca) {
		super();
		this.marca = marca;
	}
	
	//Metodo abstracto que los hijos deben implementar
	//excepto si tambien son abstractos
	public abstract void acelerar();
	//sobrecarga estatica de acelerar
	public abstract void acelerar(String marca);

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
}
