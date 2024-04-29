package org.example;


import vista.*;
import javax.swing.Timer;

public class Main {
    public static void main(String[] args) {
        vistaMenuPrincipal menuPrincipal = new vistaMenuPrincipal();

        menuPrincipal.btnJugar.addActionListener(e -> {
            menuPrincipal.setVisible(false);

            VistaBullethell aplicacion = new VistaBullethell();
            aplicacion.setVisible(true);

            // un Timer que repinta la ventana cada 15 milisegundos (como me gusta complicarme las cosas)
            Timer timer = new Timer(15, event -> aplicacion.repaint());
            timer.start();
        });

        menuPrincipal.setVisible(true);
    }

}