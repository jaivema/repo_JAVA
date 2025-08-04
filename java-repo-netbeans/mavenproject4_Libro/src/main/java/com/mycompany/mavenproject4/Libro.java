package com.mycompany.mavenproject4;

public class Libro implements java.io.Serializable {
    String titulo, autor;
    double precio;
    int stock;
    
    public Libro() {
    }

    public Libro(String titulo, String autor, double precio, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.stock = stock;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Libro{"+
                "titulo="+this.titulo+
                ", autor="+this.autor+
                ", precio="+this.precio+
                ", stock="+this.stock+
                '}';
    }    
}
