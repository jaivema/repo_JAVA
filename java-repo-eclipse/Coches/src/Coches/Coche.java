package Coches;
import java.util.Scanner;


public class Coche {

	String Marca, Model, Color;
	int Motor,Cilindrada, Portes;
	
	Scanner Entradas = new Scanner(System.in);
	
	//Constructor
	public Coche(String marca, String model, String color, int motor, int portes) {
		super();
		Marca = marca;
		Model = model;
		Color = color;
		Motor = motor;
		Cilindrada = motor;
		Portes = portes;
	}
	
	//metodos Getters & Setters
	
	public String getMarca() {
		return Marca;
	}
	public void setCilindrada(int cilindrada) {
		Cilindrada = cilindrada;
	}
	public void setMarca(String marca) {
		Marca = marca;
	}
	public String getModel() {
		return Model;
	}
	public void setModel(String model) {
		Model = model;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public int getMotor() {
		return Motor;
	}
	public int getCilindrada() {
		return Cilindrada;
	}
	public void setMotor(int motor) {
		Motor = motor;
	}
	public int getPortes() {
		return Portes;
	}
	public void setPortes(int portes) {
		Portes = portes;
	}
	
	
	
	
	//Funciones para incrementar el valor del motor
	public int Increm(int numero) {
		numero = numero + 50;
		return numero;
	}	
	public void IplusMotor(Coche a) {
		int aumento = a.getMotor();
		aumento = aumento + 50;
		a.setMotor(aumento);
	}
	//Funciones para aumentar la cilindrada
	public void IplusCilin(Coche a) {
		int aumento = a.getCilindrada();
		aumento = aumento + 50;
		a.setCilindrada(aumento);
	}
	//utilizando el metodo this
	public void Incremthis() {
		this.Motor = this.Motor  + 50;
	}
	public void IncremthisC() {
		this.Cilindrada = this.Cilindrada  + 50;
	}
	
	
	
	
	
	
	//FUNCION DE COMPARACION
	public boolean compObj(Coche objeto1, Coche objeto2){
		boolean rMarca  	= objeto1.getMarca()==objeto2.getMarca();
		boolean rModel  	= objeto1.getModel()==objeto2.getModel();
		boolean rColor  	= (objeto1.getColor()==objeto2.getColor())||(objeto1.getColor()!=objeto2.getColor());
		boolean rMotor  	= objeto1.getMotor()==objeto2.getMotor();
		boolean rCilindrada = objeto1.getCilindrada()==objeto2.getCilindrada();
		boolean rPortes 	= objeto1.getPortes()==objeto2.getPortes();
		
		boolean resultado = (rMarca && rModel && rColor && (rMotor||rCilindrada) && rPortes);
		return resultado;
	}
	
	
	

	
	
	//FUNCION DE CONDICIONAL "IF"
	public String QueColorEs() {
        String resultado;
        
        System.out.println(this.getColor());

        //condicional anidado
        if (this.getColor()=="Blanco"||this.getColor()=="blanco"||this.getColor()=="BLANCO") {
                resultado = "S1 es de color blanco";
        	}else if (this.getColor()=="Negro"||this.getColor()=="negro"||this.getColor()=="NEGRO") {
        			resultado = "S2 es de color negro";
		        }else {
		        	resultado = "S3.ERROR no es ni negro ni blanco";
		        }
        return resultado;
	}
	//FUNCION DE CONDICIONAL SWITCH CASE
	public String SwitchPuertas() {
        String resultado;
        
        System.out.println(this.getPortes());

        //condicional switch
        switch (this.getPortes()) {
        	case 3:
        		resultado="Tiene 3 puertas";
        		break;
        	case 5:
        		resultado="Tiene 5 puertas";
        		break;
        	default:
        		resultado="ERROR. Puertas sin especificar";
        		break;
        
        }
        return resultado;
	}
	
	
	
	//desarrollo de un nuevo coche introducido por el usuario
	public Coche nuevocoche(Coche nuevo) {
		String Emarca, Emodelo,Ecolor, ESmotor, ESpuertas;
		int Emotor, Epuertas;
		//Coche X;
		//String EScilindro; 
		//double Ecilindro;
		
		Scanner Entradas = new Scanner(System.in);
		
		System.out.println("Marca: ");
		Emarca = Entradas.nextLine();
		System.out.println("Modelo: ");
		Emodelo = Entradas.nextLine();
		System.out.println("Color: ");
		Ecolor = Entradas.nextLine();
		System.out.println("Motor: ");
		ESmotor = Entradas.nextLine();
		Emotor = Integer.parseInt(ESmotor);
		//System.out.println("Cilindrada: ");
		//EScilindro = Entradas.nextLine();
		//Ecilindro = Double.parseDouble(EScilindro);
		System.out.println("Puertas: ");
		ESpuertas = Entradas.nextLine();
		Epuertas = Integer.parseInt(ESpuertas);
		
		Entradas.close();
		
		nuevo.setMarca(Emarca);
		nuevo.setModel(Emodelo);
		nuevo.setColor(Ecolor);
		nuevo.setMotor(Emotor);
		nuevo.setCilindrada(Emotor);
		nuevo.setPortes(Epuertas);
		
		nuevo = new Coche(Emarca,Emodelo,Ecolor,Emotor,Epuertas);
		
		System.out.println("Nuevo coche creado: "+Emarca+" "+Emodelo);
		
		return nuevo;
	}
	
	public Coche nuevocoche2() {
		String Emarca, Emodelo,Ecolor, ESmotor, ESpuertas;
		int Emotor, Epuertas;
		Coche nuevo;
		//String EScilindro; 
		//double Ecilindro;
		
		System.out.println("Marca: ");
		Emarca = Entradas.nextLine();
		System.out.println("Modelo: ");
		Emodelo = Entradas.nextLine();
		System.out.println("Color: ");
		Ecolor = Entradas.nextLine();
		System.out.println("Motor: ");
		ESmotor = Entradas.nextLine();
		Emotor = Integer.parseInt(ESmotor);
		//System.out.println("Cilindrada: ");
		//EScilindro = Entradas.nextLine();
		//Ecilindro = Double.parseDouble(EScilindro);
		System.out.println("Puertas: ");
		ESpuertas = Entradas.nextLine();
		Epuertas = Integer.parseInt(ESpuertas);
		
		nuevo = new Coche(Emarca,Emodelo,Ecolor,Emotor,Epuertas);
				
		System.out.println("Nuevo coche creado: "+Emarca+" "+Emodelo);
		
		return nuevo;
	}
	
	public void PreguntaCoches() {
		
		System.out.println("Cuantos coches: ");
		
		String NScoches = Entradas.nextLine();
		int NIcoches = Integer.parseInt(NScoches);
		
		for (int contador=1; contador<=NIcoches; contador++) {
			Coche nuevo=this.nuevocoche2();
			System.out.println("generado " + contador + " coches");
		}
	}
	
	public void cerrarscanner() {
		Entradas.close();
	}

}
