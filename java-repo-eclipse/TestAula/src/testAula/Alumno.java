package testAula;

public class Alumno {
    private String nombre;
    private int edad;
    private Fecha fnac;

    public Alumno() {
    }
    
    public Alumno(String nombre, int edad, Fecha fecha){
        this.setNombre(nombre);
        this.setEdad(edad);
        this.setFnac(fnac);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Fecha getFnac() {
        return fnac;
    }

    public void setFnac(Fecha fnac) {
        this.fnac = fnac;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + this.getNombre() + ", edad=" + this.getEdad() + ", fnac=" + this.getFnac() + '}';
    }
    
}
