package modelo;

public class Contador {
    public static int contador = 0;

    public static int getContador() {
        return contador;
    }

    public static void incrementarContador() {
        contador++;
    }
}