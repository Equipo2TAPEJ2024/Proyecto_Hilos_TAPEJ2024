package Vista;

import hilos.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.Timer;

public class VistaBullethell extends Frame {

    private Timer timer;
    private CuadradoControlable1 cuadrado;
    private ArrayList<HiloBalaRoja> balas;

    public VistaBullethell(){
        super("Bullet Hell");
        setSize(800,900);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        // este es el cuadrado que se puede mover
        cuadrado = new CuadradoControlable1(400, 450, 50);

        // lista de balas
        balas = new ArrayList<>();

        // temporizador que genera balas cada 2 segundos
        timer = new Timer(5000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarBalaAleatoria();
            }
        });
        timer.start();

        // estos son los eventos para el movimiento del cuadrado
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                cuadrado.keyPressed(e.getKeyCode());
                repaint();
            }
            public void keyReleased(KeyEvent e) {
                cuadrado.keyReleased(e.getKeyCode());
                repaint();
            }
        });

        requestFocus();

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    // logica de posicionamiento de las balas
    private void generarBalaAleatoria() {

        int lado = (int)(Math.random() * 4);
        int x = 0, y = 0;
        switch (lado) {
            case 0: // Arriba
                x = (int)(Math.random() * getWidth());
                y = 10;
                break;
            case 1: // Derecha
                x = getWidth() ;
                y = (int)(Math.random() * getHeight());
                break;
            case 2: // Abajo
                x = (int)(Math.random() * getWidth());
                y = getHeight() ;
                break;
            case 3: // Izquierda
                x = 10;
                y = (int)(Math.random() * getHeight());
                break;
        }

        HiloBalaRoja bala = new HiloBalaRoja(getGraphics(), x, y);
        balas.add(bala);
        bala.start();
    }

    // paint Graphics para dibujar el cuadrado y las balas
    public void paint(Graphics g) {
        super.paint(g);

        cuadrado.dibujar(g);
        cuadrado.mover();

        for (HiloBalaRoja bala : balas) {
            bala.dibujar(g);
        }
    }


}