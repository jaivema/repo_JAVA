package metodoAbstracto;

public class Coche extends Vehiculo {

	public Coche(String marca) {
		super(marca);
		// TODO Esbozo de constructor generado automáticamente
	}
	public void acelerar() {
		System.out.println("El coche acelera");
	}
	public void acelerar(String marca) {
		System.out.println("El coche "+marca+"  acelera");
	}
}
