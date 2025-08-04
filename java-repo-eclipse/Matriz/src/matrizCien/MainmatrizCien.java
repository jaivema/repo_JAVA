package matrizCien;

public class MainmatrizCien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int myMatriz[][] = new int[10][10];
		String cadena="";
		
		
/////// TRY AND CATCH para control de errores
		try {
            ///Aqui el codigo a revisar
/////////relleno la matriz calculando x por y
			for (int x=1; x<=10; x++){
				for (int y=1; y<=10; y++){
					
					myMatriz[x-1][y-1] = (x * y);
				}
			}
		} 
		catch(Exception e) {
			System.out.println("Error al leer la matriz: " + e.getMessage());
		}

		
		
////////display de la matriz en una tabla de coordenadas de 10 por 10
		for (int x=1; x<=10; x++){
			for (int y=1; y<=10; y++){
				
				if (myMatriz[x-1][y-1]<10) {
					cadena = cadena +"  "+ myMatriz[x-1][y-1] + " ";
				}else {
				cadena = cadena +"  "+ myMatriz[x-1][y-1];
				}
			}
			System.out.println(cadena);
			cadena = "";
		}
		
		
////Codigo de David Monllau		
//			int matriz[][] = new int[10][10];
//	        
//	        for(int i=1; i<=10;i++)        {
//	                for(int j=1; j<=10;j++) {
//	                        matriz[i-1][j-1]=i*j;
//	                }
//	        }
//	        
//	        for(int i=1; i<=10;i++)        {
//	                for(int j=1; j<=10;j++) {
//	                        if(matriz[i-1][j-1]<10) {
//	                        System.out.print(matriz[i-1][j-1]+"  ");
//	                        }
//	                        else {
//	                                System.out.print(matriz[i-1][j-1]+" ");        
//	                        }
//	                        
//	                }
//	                System.out.print("\n");
//	        }
			
			
	}
}
