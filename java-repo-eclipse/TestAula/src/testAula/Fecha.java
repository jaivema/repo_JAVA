package testAula;

public class Fecha {
    private int dia;
    private int mes;
    private int anio;

/// constructores
    public Fecha(){    
    }
    public Fecha(int dia, int mes, int anio){
        this.setDia(dia);
        this.setMes(mes);
        this.setAnio(anio);
    }
    
/// métodos
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Fecha{" + "dia=" + this.getDia() + ", mes=" + this.getMes() + ", anio=" + this.getAnio() + '}';
    }
    
}

