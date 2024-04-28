package Vista;

import hilos.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.Timer;

public class VistaBullethell extends Frame {

    private Timer timerBalaRoja;
    private Timer timerBalaAzul;
    private CuadradoControlable1 cuadrado;
    private ArrayList<HiloBalaRoja> balasRojas;
    private ArrayList<HiloBalaAzul> balasAzules;

    public VistaBullethell() {
        super("Bullet Hell");
        setSize(800, 900);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        // este es el cuadrado que se puede mover
        cuadrado = new CuadradoControlable1(400, 450, 50);

        // lista de balas
        balasRojas = new ArrayList<>();
        balasAzules = new ArrayList<>();

        // temporizador que genera balas cada 2 segundos
        timerBalaRoja = new Timer(5000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarBalaAleatoria();
            }
        });
        timerBalaRoja.start();

        timerBalaAzul = new Timer(15000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarBalaAzulAleatoria();
            }
        });
        timerBalaAzul.start();


        // estos son los eventos para el movimiento del cuadrado
        addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                cuadrado.keyPressed(e.getKeyCode());
                //repaint();
            }

            public void keyReleased(KeyEvent e) {
                cuadrado.keyReleased(e.getKeyCode());
                //repaint();
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

        int lado = (int) (Math.random() * 4);
        int x = 0, y = 0;
        switch (lado) {
            case 0: // Arriba
                x = (int) (Math.random() * getWidth());
                y = 10;
                break;
            case 1: // Derecha
                x = getWidth();
                y = (int) (Math.random() * getHeight());
                break;
            case 2: // Abajo
                x = (int) (Math.random() * getWidth());
                y = getHeight();
                break;
            case 3: // Izquierda
                x = 10;
                y = (int) (Math.random() * getHeight());
                break;
        }

        HiloBalaRoja balaR = new HiloBalaRoja(getGraphics(), x, y);
        balasRojas.add(balaR);
        balaR.start();
    }

    private void generarBalaAzulAleatoria() {
        int lado = (int) (Math.random() * 4);
        int x = 0, y = 0;
        switch (lado) {
            case 0: // Arriba
                x = (int) (Math.random() * getWidth());
                y = 10;
                break;
            case 1: // Derecha
                x = getWidth();
                y = (int) (Math.random() * getHeight());
                break;
            case 2: // Abajo
                x = (int) (Math.random() * getWidth());
                y = getHeight();
                break;
            case 3: // Izquierda
                x = 10;
                y = (int) (Math.random() * getHeight());
                break;
        }
        HiloBalaAzul balaAzul = new HiloBalaAzul(getGraphics(), x, y);
        balasAzules.add(balaAzul);
        balaAzul.start();
    }




    // paint Graphics para dibujar el cuadrado y las balas
    public void paint(Graphics g) {
        super.paint(g);

        cuadrado.dibujar(g);
        cuadrado.mover();

        for (HiloBalaRoja bala : balasRojas) {
            bala.dibujar(g);
        }

        for (HiloBalaAzul balaAzul : balasAzules) {
            balaAzul.dibujar(g);
        }

        if (cuadrado.hayColision(balasRojas,balasAzules)) {
            System.exit(0); // cierra el programa si las balas te tocan
        }

    }

}