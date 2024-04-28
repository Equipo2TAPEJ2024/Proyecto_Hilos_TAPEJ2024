package Vista;

import Modelo.Contador;

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
        setLayout(null); // Usamos null layout para posicionar los componentes manualmente

        // Crear el contador de puntuación
        puntuacionLabel = new JLabel("Puntuación: 0");
        puntuacionLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        puntuacionLabel.setVerticalAlignment(SwingConstants.TOP);
        puntuacionLabel.setBounds(10, 10, 150, 20); // Establecemos las coordenadas y el tamaño del label
        getContentPane().add(puntuacionLabel, BorderLayout.CENTER);

        // Cargar la imagen
        imagen = new ImageIcon("assets/ufo.png"); // Reemplaza "ruta/a/tu/imagen.png" con la ruta de tu imagen
        imagenLabel = new JLabel(imagen);

        // Posición inicial de la imagen
        imagenX = 400;
        imagenY = 450;
        imagenLabel.setBounds(imagenX, imagenY, imagen.getIconWidth(), imagen.getIconHeight());
        imagenLabel.setIcon(imagen);
        add(imagenLabel);

        // Iniciar un temporizador para actualizar la puntuación y mover la imagen
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
        setSize(800, 900); // Ajustamos el tamaño del JFrame para que quepa la imagen
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