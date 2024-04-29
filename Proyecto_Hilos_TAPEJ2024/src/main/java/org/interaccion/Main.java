package org.interaccion;


import modelo.Contador;
import vista.*;
import javax.swing.Timer;

public class Main {
    public static void main(String[] args) {
        vistaMenuPrincipal menuPrincipal = new vistaMenuPrincipal();
        vistaPuntuacion puntuacionFrame = new vistaPuntuacion();


        menuPrincipal.btnJugar.addActionListener(e -> {
            menuPrincipal.setVisible(false);

            VistaBullethell aplicacion = new VistaBullethell();


            int xPuntuacion = aplicacion.getX() + aplicacion.getWidth();
            int yPuntuacion = aplicacion.getY();
            puntuacionFrame.setLocation(xPuntuacion, yPuntuacion);
            puntuacionFrame.setVisible(true);

            aplicacion.setVisible(true);

            // un Timer que repinta la ventana cada 15 milisegundos (como me gusta complicarme las cosas)
            Timer timer = new Timer(15, event -> {
                aplicacion.repaint();
                Contador.incrementarContador();
                puntuacionFrame.actualizarPuntuacion();
            });
            timer.start();
        });

        menuPrincipal.setVisible(true);


        menuPrincipal.btnsalir.addActionListener(e -> {
            System.exit(0);
        });
    }

}