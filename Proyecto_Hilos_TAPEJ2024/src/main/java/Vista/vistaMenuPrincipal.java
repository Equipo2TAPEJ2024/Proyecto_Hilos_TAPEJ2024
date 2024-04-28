package Vista;

import javax.swing.*;

public class vistaMenuPrincipal extends JFrame{
    public JPanel panelGeneral;
    public JPanel panelCentro;
    public JLabel lblTitulo;
    public JButton btnJugar;
    public JButton button1;
    public JButton button2;

    public vistaMenuPrincipal(){

        setContentPane(panelGeneral);
        setLocationRelativeTo(null);
        //setSize();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setTitle("");

    }
}
