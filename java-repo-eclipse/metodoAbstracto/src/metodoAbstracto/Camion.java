package metodoAbstracto;

public class Camion extends Vehiculo {

	public Camion(String marca) {
		super(marca);
		// TODO Esbozo de constructor generado autom�ticamente
	}
	
	public void acelerar() {
		System.out.println("El camion acelera");
	}
	public void acelerar(String marca) {
		System.out.println("El camion "+marca+" acelera");
	}
}
