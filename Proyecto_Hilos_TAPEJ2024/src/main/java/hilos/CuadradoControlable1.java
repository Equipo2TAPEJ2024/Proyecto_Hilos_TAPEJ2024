package hilos;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class CuadradoControlable1 {
    private BufferedImage imagencuadrado;
    private int x, y, tamaño;
    private static final int VELOCIDAD = 8;
    private boolean arribaPresionado, abajoPresionado, izquierdaPresionado, derechaPresionado;

    //metodo para verificar si la bala colisiona
    public CuadradoControlable1(int x, int y, int tamaño) {
        this.x = x;
        this.y = y;
        this.tamaño = tamaño;
        try {
            imagencuadrado = ImageIO.read(new File("Proyecto_Hilos_TAPEJ2024/src/main/java/assets/ufo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // logica de movimiento considerqando las combinaciones de teclas
    public void mover(int ventanaAncho, int ventanaAlto) {
        if (arribaPresionado && izquierdaPresionado && y > 0 && x > 0) {
            x -= VELOCIDAD;
            y -= VELOCIDAD;
        } else if (arribaPresionado && derechaPresionado && y > 0 && x < ventanaAncho - tamaño) {
            x += VELOCIDAD;
            y -= VELOCIDAD;
        } else if (abajoPresionado && izquierdaPresionado && y < ventanaAlto - tamaño && x > 0) {
            x -= VELOCIDAD;
            y += VELOCIDAD;
        } else if (abajoPresionado && derechaPresionado && y < ventanaAlto - tamaño && x < ventanaAncho - tamaño) {
            x += VELOCIDAD;
            y += VELOCIDAD;
        } else if (arribaPresionado && y > 0) {
            y -= VELOCIDAD;
        } else if (abajoPresionado && y < ventanaAlto - tamaño) {
            y += VELOCIDAD;
        } else if (izquierdaPresionado && x > 0) {
            x -= VELOCIDAD;
        } else if (derechaPresionado && x < ventanaAncho - tamaño) {
            x += VELOCIDAD;
        }
    }

    // especificar a qué movimiento corresponde cada tecla
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
        if (imagencuadrado != null) { // implementacion de BufferedImage
            BufferedImage buffer = new BufferedImage(tamaño, tamaño, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = buffer.createGraphics();
            g2d.drawImage(imagencuadrado, 0, 0, tamaño, tamaño, null);
            g2d.dispose();

            // Dibujar la imagen en la ventana
            g.drawImage(buffer, x, y, null);
        }
    }

    //logica para la colision de las balas
    public boolean hayColision(ArrayList<HiloBalaRoja> balasRojas, ArrayList<HiloBalaAzul> balasAzules, ArrayList<HiloBalaVerde> balasVerdes) {
        Rectangle cuadradoRect = new Rectangle(x, y, tamaño, tamaño);
        for (HiloBalaRoja balaRoja : balasRojas) {
            Rectangle balaRect = new Rectangle(balaRoja.getX() - balaRoja.getRadio(), balaRoja.getY() - balaRoja.getRadio(),
                    2 * balaRoja.getRadio(), 2 * balaRoja.getRadio());
            if (cuadradoRect.intersects(balaRect)) {
                return true;
            }
        }

        for (HiloBalaAzul balaAzul : balasAzules) {
            Rectangle balaRect = new Rectangle(balaAzul.getX() - balaAzul.getRadio(), balaAzul.getY() - balaAzul.getRadio(),
                    2 * balaAzul.getRadio(), 2 * balaAzul.getRadio());
            if (cuadradoRect.intersects(balaRect)) {
                return true;
            }
        }
        for (HiloBalaVerde balaVerde : balasVerdes) {
            Rectangle balaRect = new Rectangle(balaVerde.getX(), balaVerde.getY(), balaVerde.getAnchoBala(), balaVerde.getAltoBala());
            if (cuadradoRect.intersects(balaRect)) {
                return true;
            }
        }

        return false;
    }

}