package vista;

import hilos.*;
import modelo.Contador;
import modelo.CuadradoControlable1;
import modelo.Puntuaciones;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;

public class VistaBullethell extends Frame {
    private BufferedImage fondo;
    private Timer timerBalaRoja;
    private Timer timerBalaAzul;
    private Timer timerBalaVerde;
    private CuadradoControlable1 cuadrado;
    private ArrayList<HiloBalaRoja> balasRojas;
    private ArrayList<HiloBalaAzul> balasAzules;
    private ArrayList<HiloBalaVerde> balasVerdes;

    public VistaBullethell() {
        super("Bullet Hell");
        setSize(800, 900);
        setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setResizable(false);


        // Cargar la imagen para el fondo
        try {
            fondo = ImageIO.read(new File("Proyecto_Hilos_TAPEJ2024/src/main/java/assets/espacio.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }


        // este es el cuadrado que se puede mover
        cuadrado = new CuadradoControlable1(400, 450, 50);

        // lista de balas
        balasRojas = new ArrayList<>();
        balasAzules = new ArrayList<>();
        balasVerdes = new ArrayList<>();

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

        timerBalaVerde = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generarBalaVerdeAleatoria();
            }
        });
        timerBalaVerde.start();


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

        HiloBalaRoja balaR = new HiloBalaRoja(x, y);
        balasRojas.add(balaR);
        balaR.start();
        Contador.incrementarContador(100);
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
        HiloBalaAzul balaAzul = new HiloBalaAzul( x, y);
        balasAzules.add(balaAzul);
        balaAzul.start();
        Contador.incrementarContador(500);
    }

    private void generarBalaVerdeAleatoria() {
        int direccion = (int) (Math.random() * 2); // 0 para izquierda, 1 para derecha
        HiloBalaVerde balaVerde = new HiloBalaVerde( getWidth(), getHeight(), direccion);
        balasVerdes.add(balaVerde);
        balaVerde.start();
        Contador.incrementarContador(50);
    }




    // paint Graphics para dibujar el cuadrado y las balas
    public void paint(Graphics g) {
        super.paint(g);

        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }

        cuadrado.dibujar(g);
        cuadrado.mover(getWidth(), getHeight());

        for (HiloBalaRoja balaRoja : balasRojas) {
            balaRoja.dibujar(g);
        }

        for (HiloBalaAzul balaAzul : balasAzules) {
            balaAzul.dibujar(g);
        }

        for (HiloBalaVerde balaVerde : balasVerdes) {
            balaVerde.dibujar(g);
        }

        if (cuadrado.hayColision(balasRojas,balasAzules,balasVerdes)) {
            Puntuaciones.actualizarMejorPuntuacion(Contador.getContador());
            congelarJuego();
        }

    }


    @Override
    public void update(Graphics g) {
        // implementacion de doble buffer (fuente:https://youtu.be/17y2hZWJN0U?si=JEBB9FcMUDNYLP9_ [dios mio que dolor de cabeza])
        BufferedImage buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = buffer.createGraphics();
        paint(g2d);
        g2d.dispose();
        g.drawImage(buffer, 0, 0, this);
    }

    private void congelarJuego() {
        timerBalaRoja.stop();
        timerBalaAzul.stop();
        timerBalaVerde.stop();
        setVisible(false);
        Contador.detenerContador();

    }

}