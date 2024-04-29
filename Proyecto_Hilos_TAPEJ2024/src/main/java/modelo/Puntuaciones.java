package modelo;
import java.io.*;

public class Puntuaciones {
    private static int mejorPuntuacion = 0;
    private static final String ARCHIVO_PUNTUACION = "mejor_puntuacion.txt";

    static {
        cargarMejorPuntuacion();
    }

    public static int getMejorPuntuacion() {
        return mejorPuntuacion;
    }

    public static void actualizarMejorPuntuacion(int nuevaPuntuacion) {
        if (nuevaPuntuacion > mejorPuntuacion) {
            mejorPuntuacion = nuevaPuntuacion;
            guardarMejorPuntuacion();
        }
    }

    private static void cargarMejorPuntuacion() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(ARCHIVO_PUNTUACION));
            mejorPuntuacion = Integer.parseInt(reader.readLine());
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void guardarMejorPuntuacion() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO_PUNTUACION));
            writer.write(String.valueOf(mejorPuntuacion));
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

