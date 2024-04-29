package modelo;

public class Contador {
    private static int contador = 0;
    private static boolean detener = false;

    public static int getContador() {
        return contador;
    }

    public static void incrementarContador() {
        if (!detener) {
            contador++;
        }
    }

    public static void incrementarContador(int cantidad) {
        contador += cantidad;
    }

    public static void detenerContador() {
        detener = true;
    }
}