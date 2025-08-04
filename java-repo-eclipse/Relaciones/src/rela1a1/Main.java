package rela1a1;

public class Main {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		
		Galleta g1 = new Galleta("Chocolate",1);
		
		System.out.println("Galleta g1: "+g1.getSabor());
		
		Envoltorio e1 = new Envoltorio("Azul","Chocolate",1);
		e1.setColor("Azul");
		
		System.out.println("Envoltorio de color: "+ e1.getColor());
	}

}