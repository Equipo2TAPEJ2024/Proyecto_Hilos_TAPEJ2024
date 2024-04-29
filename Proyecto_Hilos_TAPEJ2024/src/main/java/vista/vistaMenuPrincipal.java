package vista;

import javax.swing.*;
import java.awt.event.ActionListener;

public class vistaMenuPrincipal extends JFrame{
    public JPanel panelGeneral;
    public JPanel panelCentro;
    public JLabel lblTitulo;
    public JButton btnJugar;
    public JButton button1;
    public JButton button2;

    public vistaMenuPrincipal(){

        setContentPane(panelGeneral);

        setSize(800,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Bullet Hell");
        setResizable(false);
        setVisible(true);

    }


}
