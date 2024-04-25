package org.example;

import Vista.VistaBullethell;

public class Main {
    public static void main(String[] args) {
        VistaBullethell aplicacion = new VistaBullethell();

        // sentencia para repintar la ventana cada 15 milisegundos y hacer que tenga un movimiento fluido
        while (true) {
            aplicacion.repaint();
            while (true) {
                aplicacion.repaint();
                try {
                    Thread.sleep(15);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}