package metodoAbstracto;

public class Principal {

	public static void main(String[] args) {
		// TODO Esbozo de método generado automáticamente
		Moto   m = new Moto("Montesa");
		Coche  c = new Coche("Renault");
		Camion k = new Camion("Scania");
		
		//System.out.println(m.getMarca());
		
  		m.acelerar();
  		c.acelerar();
  		k.acelerar();
		
		acelerarVehiculo(m);	//metodo local a principal
		acelerarVehiculo(c);	//metodo local a principal
		acelerarVehiculo(k);	//metodo local a principal
	}
	
	//aqui el programador no necesita conocer la jerarquia de clases
	public static void acelerarVehiculo(Vehiculo v) {
		
		v.acelerar(v.getMarca());
	}		
}

