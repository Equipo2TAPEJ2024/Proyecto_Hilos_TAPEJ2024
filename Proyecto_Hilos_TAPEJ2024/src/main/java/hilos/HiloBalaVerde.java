package hilos;

import java.awt.*;

public class HiloBalaVerde extends Thread {

    private int x, y, incX;
    private final int ANCHO_BALA = 120;
    private final int ALTO_BALA = 15;
    private Graphics g;
    private int ventanaAncho;
    private int ventanaAlto;

    public HiloBalaVerde(Graphics g, int ventanaAncho, int ventanaAlto, int direccion) {
        this.g = g;
        this.ventanaAncho = ventanaAncho;
        this.ventanaAlto = ventanaAlto;

        y = (int) (Math.random() * (ventanaAlto - ALTO_BALA));


        if (direccion == 0) { // Desde la izquierda
            x = -ANCHO_BALA;
            incX = 2; // Velocidad
        } else { // Desde la derecha
            x = ventanaAncho;
            incX = -2; // Velocidad
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
        g.setColor(Color.GREEN);
        g.fillRect(x, y, ANCHO_BALA, ALTO_BALA);
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