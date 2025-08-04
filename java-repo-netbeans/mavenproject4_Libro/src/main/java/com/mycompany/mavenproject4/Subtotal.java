package com.mycompany.mavenproject4;

public class Subtotal {
    String titulo;
    double total;

    public Subtotal() {
    }

    public Subtotal(String titulo, double total) {
        this.titulo = titulo;
        this.total = total;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Subtotal{" +
                "titulo=" +
                this.titulo +
                ", total=" +
                this.total + '}';
    }
    

}
