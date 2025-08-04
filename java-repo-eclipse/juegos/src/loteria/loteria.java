package loteria;

public class loteria {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int Array[]=new int[6];
		int posicion=0;
		boolean final2=false;
		boolean duplicado=false;
		int aleatorio=(int)(Math.random()*49);

		do{
			duplicado=false;
			aleatorio=(int)(Math.random()*49);

			for(int i=0;i<6;i++) {
				if (Array[i]==aleatorio) {
					duplicado=true;
				}
			}
			if (duplicado==false) {
				Array[posicion]=aleatorio;
				posicion++;
			}
			if (posicion==6) {
				final2=true;
			}
		}
		while (final2==false);
		
		System.out.print(" | ");
		for(int i=0;i<6;i++) {
			System.out.print(Array[i] + " | ");
		}	
	}
}