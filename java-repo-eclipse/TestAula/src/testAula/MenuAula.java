package testAula;

import java.util.*;
public class MenuAula {
	char opcion;
    boolean salir;
    Scanner sc;
    Fecha fecha;
    Alumno alumno, alumnoMem;
    ArrayList<Alumno> aula=new ArrayList();
    
    public MenuAula(){
        do{
            salir=false;
            menu_aula();
        }while(!salir);
    }
    public void menu_aula() {
        sc=new Scanner(System.in);
        salir=false;
        fecha=new Fecha();
        alumno=new Alumno();
        alumnoMem=new Alumno();
        aula=new ArrayList();
        do {
            System.out.println("\n MENU PRINCIPAL ");
            System.out.println(" 1. - Introducir fecha.       ");
            System.out.println(" 2. - Introducir alumno.      ");
            System.out.println(" 3. - Visualizar datos alumno.");
            System.out.println(" 4. - Nuevo alumno Aula.      ");
            System.out.println(" 5. - Vista aula.             ");
            System.out.println(" x. - Salir.                  ");
            System.out.println("                              ");
            System.out.println("> Selecciona opción: ");
            
            opcion = sc.next().toLowerCase().charAt(0);
            switch(opcion) {
                case'1':System.out.println(intr_fecha());
                    break;
                case'2':intr_alumno();
                    break;
                case'3':visualizar_datos_alumno();
                    break;
                case'4':nuevo_aula();
                    break;
                case'5':vista_aula();
                    break;
                case'x':salir=true;
                    break;
                default:
                    System.out.println("Se ha introducido una opcion incorrecta.");
                    break;
            }
        }while(!salir);
        sc.close();
    }
    public void visualizar_datos_alumno(){
        if (alumnoMem.getNombre()==null)
            System.out.println("No hay datos que visualizar");
        else System.out.println(alumnoMem);
    }
/// NUEVO ALUMNO AULA //////////////////////////////////////////////////////////
    public void nuevo_aula(){
        intr_alumno();
        aula.add(alumno);
    }
/// VISTA AULA /////////////////////////////////////////////////////////////////
    public void vista_aula(){
        if (aula.isEmpty()) {
            System.out.println("Todavía no hay datos de alta !!");
        }else{
            for (int i=0; i<aula.size();i++) {
                System.out.println(i+".-> "+aula.get(i));
            }
        }
    }
/// INTRODUCIR ALUMNO //////////////////////////////////////////////////////////
    public void intr_alumno(){
        String n;
        int e;
        Fecha fn;
        n=introduce_nombre();
        e=introduce_edad();
        System.out.println("Introduce la fecha de nacimiento del alumno ");
        fn=intr_fecha();

        if (opcion=='2'){
            alumnoMem.setNombre(n);alumnoMem.setEdad(e);alumnoMem.setFnac(fn);
        }
        if(opcion=='4'){
            alumno.setNombre(n);alumno.setEdad(e);alumno.setFnac(fn);
        }
    }
    public String introduce_nombre(){
        String n;
        System.out.println("Introduce el nombre del alumno: ");
        n = sc.next();
        return n;
    }
    public int introduce_edad(){
        int e;
        do{
            System.out.println("Introduce la edad del alumno: ");
            e = sc.nextInt();                
        }while (!comprobar_Edad(e));
        return e;
    }
/// validaciones alumno ////////////////////////////////////////////////////////
    public boolean comprobar_Edad(int e){
        if (e>6 && e<90) return true;
        else{
            System.out.println("Edad entre 6 y 90 años");
            return false;
        }       
    }
    
/// INTRODUCIR FECHA ///////////////////////////////////////////////////////////
    public Fecha intr_fecha(){
        int a, m, d;
        a=intr_anio();
        m=intr_mes();
        d=intr_dia(m,a);
        fecha.setAnio(a);
        fecha.setMes(m);
        fecha.setDia(d);
        
        return fecha;
    }
    public int intr_anio(){
        int a;
        do{
            System.out.println("Introduce el año: ");
            a = sc.nextInt();
        }while(!(comprobar_Anno(a)));
        return a;
    }
    public int intr_mes(){
        int m;
        do{
            System.out.println("Introduce el mes: ");
            m = sc.nextInt();
        }while(!(comprobar_Mes(m)));
        return m;
    }
    public int intr_dia(int m, int a){
        int d;
        do{
            System.out.println("Introduce el dia: ");
            d = sc.nextInt();
        }while(!(comprobar_Dia(d,m,a)));
        return d;
    }
/// validaciones fecha /////////////////////////////////////////////////////////
    public boolean comprobar_Anno(int a){
        Calendar cal=Calendar.getInstance();
        int i=cal.get(Calendar.YEAR);
        if (a <= i && a >= 1900){
            return true;
        }else{
            System.out.println("Error. Introducir un año entre 1900 y "+i);
            return false;
        }
    }
    public boolean comprobar_Mes(int m){
        if(m<1 || m>12){
            System.out.println("Mes "+m+" no existe.");
            return false;
        }else{
            return true;
        }
    }
    public boolean comprobar_Dia(int d,int m,int a){
        boolean bisiesto = false;
        if ((a % 4 == 0) && ((a% 100 != 0) || (a % 400 == 0)))
            bisiesto = true;
        else bisiesto = false;
        
        if(d<1 || d>31) {
            System.out.println("Dia "+d+" no existe.");
        }else {
            switch(m){
                case 2:
                    if (bisiesto){
                        if(d>29) {
                            System.out.println("Febrero no puede tener mas de 29 dias.");
                            return false;
                        }else {
                            return true;
                        }
                    }else{
                        if(d>28){
                            System.out.println("Febrero no puede tener más de 28 dias.");
                            return false;
                        }else {
                            return true;
                        }
                    }
                case 4: case 6: case 9: case 11:
                    if (d>30) {
                        System.out.println("Abril, Junio, Septiembre y Noviembre no puede tener mas de 30 dias");
                        return false;
                    }else {
                        return true;
                    }
                case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                    if (d>31) {
                        System.out.println("Enero, Marzo, Mayo, Julio, Agosto, Octubre y Diciembre no puede tener mas de 31 dias");
                        return false;
                    }else {
                        return true;
                    }
            }
        }
        return false;
    }
}
