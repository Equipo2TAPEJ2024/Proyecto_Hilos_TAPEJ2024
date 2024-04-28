package hilos;

import java.awt.*;

public class HiloBalaAzul extends Thread {
    private int x, y, incX, incY;
    private final int RADIO_BALA = 40;
    private Graphics g;

    public HiloBalaAzul(Graphics g, int px, int py) {
        this.g = g;
        x = px;
        y = py;
        incX = 2; // Velocidad más lenta que las balas rojas
        incY = 1; // Velocidad más lenta que las balas rojas
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
        g.setColor(Color.BLUE);
        g.fillOval(x - RADIO_BALA, y - RADIO_BALA, 2 * RADIO_BALA, 2 * RADIO_BALA);
    }

}