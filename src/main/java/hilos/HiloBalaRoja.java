package hilos;

import java.awt.*;

public class HiloBalaRoja extends Thread {

    private int x, y, incX, incY;
    private final int RADIO_BALA = 10;
    private Graphics g;

    public HiloBalaRoja(Graphics g, int px, int py) {
        this.g = g;
        x = px;
        y = py;
        incX = 5;
        incY = 3;
    }

    public void run() {
        while (true) {
            mover();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) { }
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
        // logica del movimiento de la bala
        x += incX;
        y += incY;

        // la bala rebota si sale de la ventana
        if (x - RADIO_BALA <= -50 || x + RADIO_BALA >= 900) {
            incX *= -1;
        }
        if (y - RADIO_BALA <= -50 || y + RADIO_BALA >= 1000) {
            incY *= -1;
        }
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(x - RADIO_BALA, y - RADIO_BALA, 2 * RADIO_BALA, 2 * RADIO_BALA);
    }


}