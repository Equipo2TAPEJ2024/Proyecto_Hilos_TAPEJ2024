package vista;

import modelo.Contador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaBullethellJuego extends JFrame {

    private JLabel puntuacionLabel;
    private JLabel imagenLabel;
    private ImageIcon imagen;
    private int imagenX, imagenY;
    private static final int VELOCIDAD = 5;

    public VistaBullethellJuego() {
        super("Bullet Hell - Juego");


        puntuacionLabel = new JLabel("Puntuación: 0");
        puntuacionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        puntuacionLabel.setVerticalAlignment(SwingConstants.TOP);
        puntuacionLabel.setBounds(10, 10, 150, 20);
        getContentPane().add(puntuacionLabel, BorderLayout.CENTER);

        // Cargar la imagen
        imagen = new ImageIcon("assets/ufo.png");
        imagenLabel = new JLabel(imagen);

        // Posición inicial de la imagen
        imagenX = 400;
        imagenY = 450;
        imagenLabel.setBounds(imagenX, imagenY, imagen.getIconWidth(), imagen.getIconHeight());
        imagenLabel.setIcon(imagen);
        add(imagenLabel);

        Timer timer = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Contador.contador++;
                puntuacionLabel.setText("Puntuación: " + Contador.contador);

                // Mover la imagen
                moverImagen();
            }
        });
        timer.start();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 900);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void moverImagen() {
        // Movimiento de la imagen
        imagenX += VELOCIDAD;
        imagenY += VELOCIDAD;

        // Redibujar la imagen en la nueva posición
        imagenLabel.setBounds(imagenX, imagenY, imagen.getIconWidth(), imagen.getIconHeight());
    }

}