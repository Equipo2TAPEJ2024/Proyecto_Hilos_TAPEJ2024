package vista;

import javax.swing.*;
import java.awt.*;

public class vistaMenuPrincipal extends JFrame{
    public JPanel panelGeneral;
    public JPanel panelCentro;
    public JLabel lblTitulo;
    public JButton btnJugar;
    public JButton button1;
    public JButton btnsalir;

    public vistaMenuPrincipal(){
        // Inicializar el panel general y el panel centro
        panelGeneral = new JPanel();
        panelGeneral = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon icon = new ImageIcon("Proyecto_Hilos_TAPEJ2024/src/main/java/assets/menu.png");
                Image img = icon.getImage();
                g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
            }
        };

        // Configurar el panel general
        setContentPane(panelGeneral);
        panelGeneral.setLayout(new OverlayLayout(panelGeneral));

        // Establecer la transparencia del panel centro
        panelCentro.setOpaque(false);

        // Agregar el panel centro al panel general
        panelGeneral.add(panelCentro);

        // Configurar la ventana
        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bullet Hell");
        setResizable(false);

        setVisible(true);
    }
}
