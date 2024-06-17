package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class Visualizar extends JFrame {
    private Dashboard dashboard;
    private Dashboard.BackgroudImage backgroudImage;
    private JComboBox<String> Carreras;
    private JButton BtnBuscar;
    private JTable TablaProyectos;
    private DefaultTableModel ModeloTablaProyectos;
    private final String[] TitleTable = {"ID","Nombre del Proyecto","Carrera","Ruta Interna del Proyecto","Fecha del Proyecto"};
    private JScrollPane scrollPane;
    private JButton BtnAbrirProyecto;

    public  Visualizar (Dashboard dashboard) {
        this.dashboard = dashboard;
        backgroudImage = new Dashboard.BackgroudImage();
        this.setContentPane(backgroudImage);
        Contenido();
        Iniciar();
    }

    private void Iniciar () {
            setTitle("Guardar");
            setSize(800,700);
            setResizable(false);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            requestFocus();
            setVisible(true);
    }

    public void Contenido () {
        setLayout(null);

        Carreras = new JComboBox<>();
        BtnBuscar = new JButton("Buscar");
        ModeloTablaProyectos = new DefaultTableModel();
        TablaProyectos = new JTable(ModeloTablaProyectos) {
            public boolean isCellEditable ( int row, int col)
            {
                return false;
            }
        };
        scrollPane = new JScrollPane(TablaProyectos);
        BtnAbrirProyecto = new JButton("Abrir Proyecto");

        for (String titles: TitleTable) {
            ModeloTablaProyectos.addColumn(titles);
        }

        TablaProyectos.setModel(ModeloTablaProyectos);

        Carreras.addItem(" ");
        Carreras.addItem("Informática");
        Carreras.addItem("Agroalimentaria");
        Carreras.addItem("Educación Inicial");
        Carreras.addItem("Educación Física");
        Carreras.addItem("Educación sin mención");

        Carreras.setBounds(50,200,130,25);
        BtnBuscar.setBounds(200,200,130,25);
        TablaProyectos.setPreferredScrollableViewportSize(new Dimension(2500,300));
        scrollPane.setBounds(50,250,700,280);
        BtnAbrirProyecto.setBounds(600,600,130,40);

        add(Carreras);
        add(BtnBuscar);
        add(scrollPane);
        add(BtnAbrirProyecto);
    }

    public  JButton getBtnAbrirProyecto () {
        return BtnAbrirProyecto;
    }

    public DefaultTableModel getModeloTablaProyectos () {
        return ModeloTablaProyectos;
    }

    public JTable getTablaProyectos () {
        return TablaProyectos;
    }

    public JComboBox<String> getCarreras () {
        return Carreras;
    }

    public JButton getBtnBuscar () {
        return BtnBuscar;
    }

    public void Alert (String texto) {
        JOptionPane.showMessageDialog(null,texto,"INFORMATION_MESSAGE",JOptionPane.INFORMATION_MESSAGE);
    }

    public void AlertError (String texto){
        JOptionPane.showMessageDialog(null, texto,"Error",JOptionPane.ERROR_MESSAGE);

    }
}
