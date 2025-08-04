package com.mycompany.mavenproject2;

public class Coche {
    String matricula;
    String marca;
    String modelo;
    int Km;

    public Coche() {
    }

    public Coche(String matricula, String marca, String modelo, int Km) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.Km = Km;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getKm() {
        return Km;
    }

    public void setKm(int Km) {
        this.Km = Km;
    }

    @Override
    public String toString() {
        return "Coche{" + "matricula=" + matricula + ", marca=" + marca + ", modelo=" + modelo + ", Km=" + Km + '}';
    }

}