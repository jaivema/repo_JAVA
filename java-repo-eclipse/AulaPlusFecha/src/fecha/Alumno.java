package fecha;

public class Alumno {
    String nombre;
    int edad;
    Fecha fechaNac;

    public Alumno(String nombre, int edad, Fecha fechaNac) {
        this.nombre = nombre;
        this.edad = edad;
        this.fechaNac = fechaNac;
    }
    
    public Alumno() {
        this.nombre="Me aburro";
        this.edad=99;
        this.fechaNac=new Fecha(1,1,1900);
    }
    
    public String getNombre(){
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

    public Fecha getFechaNac() {
        return fechaNac;
    }

    //get set
    public void setFechaNac(Fecha fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void obtenAlumno() {
        System.out.println("Nombre: "+getNombre()
                +" Edad: "+getEdad()
                +" Fecha de nacimiento: "+getFechaNac());
    }
}

