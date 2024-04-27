package Modelo;

public class Contador {
    private int contador;

    public Contador() {
        this.contador = 0;
    }

    public int getContador() {
        return contador;
    }

    public void incrementarContador() {
        contador++;
    }
}