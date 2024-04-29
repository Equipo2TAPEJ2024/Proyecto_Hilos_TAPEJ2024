package vista;

import modelo.Contador;
import modelo.Puntuaciones;

import javax.swing.*;
import java.awt.*;

public class vistaPuntuacion extends JFrame{
    public JPanel panelGeneral;
    public JPanel panelCentro;
    public JLabel lblJuegoStadisticas;
    public JLabel lbTituloPuntuacion;
    public JLabel lblTituloMejorPuntuacion;
    public JLabel lblRecord;
    public JLabel lblPuntuacion;
    public JLabel lblMejorPuntuacion;

    public vistaPuntuacion(){
        setTitle("Juego Terminado");
        setContentPane(panelGeneral);
        setResizable(false);
        setSize(500,330);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        lblJuegoStadisticas.setForeground(Color.black);
        lblRecord.setVisible(false);

        // Inicializar lblPuntuacion con el valor actual del contador
        lblPuntuacion.setText(Integer.toString(Contador.getContador()));
        lblMejorPuntuacion.setText(String.valueOf(Puntuaciones.getMejorPuntuacion()));
    }

    // Método para actualizar el valor del JLabel lblPuntuacion
    public void actualizarPuntuacion() {
        lblPuntuacion.setText(Integer.toString(Contador.getContador()));
        lblMejorPuntuacion.setText(String.valueOf(Puntuaciones.getMejorPuntuacion()));
    }

}