package metodoAbstracto;

public class Moto extends Vehiculo {

	public Moto(String marca) {
		super(marca);
		// TODO Esbozo de constructor generado autom�ticamente
	}
	public void acelerar() {
		System.out.println("La moto acelera");
	}
	public void acelerar(String marca) {
		System.out.println("La moto "+marca+" acelera");
	}
}
