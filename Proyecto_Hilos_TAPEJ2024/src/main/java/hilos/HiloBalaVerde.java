package hilos;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class HiloBalaVerde extends Thread {

    private int x, y, incX;
    private final int ANCHO_BALA = 120;
    private final int ALTO_BALA = 15;
    private BufferedImage verdeimagen;
    private int ventanaAncho;
    private int ventanaAlto;

    public HiloBalaVerde( int ventanaAncho, int ventanaAlto, int direccion) {
        this.ventanaAncho = ventanaAncho;
        this.ventanaAlto = ventanaAlto;

        y = (int) (Math.random() * (ventanaAlto - ALTO_BALA));


        try {
            if (direccion == 0) { // Desde la izquierda
                x = -ANCHO_BALA;
                incX = 2; // Velocidad
                verdeimagen = ImageIO.read(new File("Proyecto_Hilos_TAPEJ2024/src/main/java/assets/balaverde.png"));
            } else { // Desde la derecha
                x = ventanaAncho;
                incX = -2; // Velocidad
                verdeimagen = ImageIO.read(new File("Proyecto_Hilos_TAPEJ2024/src/main/java/assets/balaverde.png"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (x >= -ANCHO_BALA && x <= ventanaAncho) { // Mientras la bala esté dentro de la ventana
            mover();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void mover() {
        // mover la bala en la dirección determinada
        x += incX;
    }

    public void dibujar(Graphics g) {
        g.drawImage(verdeimagen, x, y, ANCHO_BALA, ALTO_BALA, null);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public int getAnchoBala() {
        return ANCHO_BALA;
    }


    public int getAltoBala() {
        return ALTO_BALA;
    }
}