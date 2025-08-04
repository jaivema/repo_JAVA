package recursividad;

public class Principal {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		Persona pepe = new Persona ("pepe");
		Persona maria = new Persona ("maria");
		Persona alex = new Persona ("alex");
		
		
		pepe.addAmigo(maria);
		pepe.addAmigo(alex);
		
		for (Persona x:pepe.getAmigos()) {
			System.out.println(x.getNombre());			
		}
		
		System.out.println(pepe.indexOf(alex));
		
		System.out.println(pepe.get(0).getNombre());
		
		System.out.println("Pepe tiene "+pepe.size()+" amigos.");
	}
}
