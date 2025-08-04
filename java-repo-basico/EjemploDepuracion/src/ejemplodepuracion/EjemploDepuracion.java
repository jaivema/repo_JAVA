package ejemplodepuracion;

public class EjemploDepuracion {

    static int calcular( int n ) {
        return n*n;
    }
    
    public static void main(String[] args) {

        int a;
        int b = 2;
        
        a = b+7;

        b = calcular(4);

        System.out.println(a);
        System.out.println(b);
    }
    
}
