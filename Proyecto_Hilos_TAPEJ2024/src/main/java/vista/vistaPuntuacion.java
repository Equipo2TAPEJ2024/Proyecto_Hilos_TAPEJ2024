package vista;

import javax.swing.*;

public class vistaPuntuacion extends JFrame{
    public JPanel panelGeneral;
    public JPanel panelCentro;
    public JLabel lblJuegoTerminado;
    public JLabel lbTituloPuntuacion;
    public JLabel lblTituloMejorPuntuacion;

    //Este lbl solo estara visible si se batio la mayor puntuacion
    public JLabel lblRecord;

    //Este es el lbl que se modificara al registrar la puntuacion obtenida
    public JLabel lblPuntuacion;

    //Y este para la mejor puntuacion hasta el momento
    public JLabel lblMejorPuntuacion;

    public vistaPuntuacion(){

        setTitle("Juego Terminado");
        setContentPane(panelGeneral);
        setResizable(false);
        setSize(500,330);
        setLocationRelativeTo(null);
        //esto se modificara al superar la mejor puntuacion
        lblRecord.setVisible(false);
    }
}
