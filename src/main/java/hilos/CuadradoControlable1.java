package hilos;

import java.awt.*;
import java.awt.event.KeyEvent;
import hilos.*;

public class CuadradoControlable1 {

    private int x, y, tamaño;
    private static final int VELOCIDAD = 8;
    private boolean arribaPresionado, abajoPresionado, izquierdaPresionado, derechaPresionado;

    //metodo para verificar si la bala colisiona


    public CuadradoControlable1(int x, int y, int tamaño) {
        this.x = x;
        this.y = y;
        this.tamaño = tamaño;
    }

    // logica de movimiento considerqando las combinaciones de teclas
    public void mover() {
        if (arribaPresionado && izquierdaPresionado) {
            x -= VELOCIDAD;
            y -= VELOCIDAD;
        } else if (arribaPresionado && derechaPresionado) {
            x += VELOCIDAD;
            y -= VELOCIDAD;
        } else if (abajoPresionado && izquierdaPresionado) {
            x -= VELOCIDAD;
            y += VELOCIDAD;
        } else if (abajoPresionado && derechaPresionado) {
            x += VELOCIDAD;
            y += VELOCIDAD;
        } else if (arribaPresionado) {
            y -= VELOCIDAD;
        } else if (abajoPresionado) {
            y += VELOCIDAD;
        } else if (izquierdaPresionado) {
            x -= VELOCIDAD;
        } else if (derechaPresionado) {
            x += VELOCIDAD;
        }
    }

    // especificar a que movimiento corresponde cada tecla
    public void keyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                arribaPresionado = true;
                break;
            case KeyEvent.VK_DOWN:
                abajoPresionado = true;
                break;
            case KeyEvent.VK_LEFT:
                izquierdaPresionado = true;
                break;
            case KeyEvent.VK_RIGHT:
                derechaPresionado = true;
                break;
        }
    }

    // dejar de mover si se suelta tecla
    public void keyReleased(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_UP:
                arribaPresionado = false;
                break;
            case KeyEvent.VK_DOWN:
                abajoPresionado = false;
                break;
            case KeyEvent.VK_LEFT:
                izquierdaPresionado = false;
                break;
            case KeyEvent.VK_RIGHT:
                derechaPresionado = false;
                break;
        }
    }

    public void dibujar(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(x, y, tamaño, tamaño);
    }
    
}