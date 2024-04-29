package hilos;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class HiloBalaAzul extends Thread {
    private int x, y, incX, incY;
    private final int RADIO_BALA = 40;
    private BufferedImage azulimagen;

    public HiloBalaAzul( int px, int py) {
        x = px;
        y = py;
        incX = 2; // Velocidad más lenta que las balas rojas
        incY = 1; // Velocidad más lenta que las balas rojas

        try {
            azulimagen = ImageIO.read(new File("Proyecto_Hilos_TAPEJ2024/src/main/java/assets/balazul.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            mover();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRadio() {
        return RADIO_BALA;
    }

    private void mover() {
        // Lógica del movimiento de la bala azul
        x += incX;
        y += incY;

        // La bala rebota si sale de la ventana
        if (x - RADIO_BALA <= -50 || x + RADIO_BALA >= 900) {
            incX *= -1;
        }
        if (y - RADIO_BALA <= -50 || y + RADIO_BALA >= 1000) {
            incY *= -1;
        }
    }

    public void dibujar(Graphics g) {
        g.drawImage(azulimagen, x - RADIO_BALA, y - RADIO_BALA, 2 * RADIO_BALA, 2 * RADIO_BALA, null);
    }

}