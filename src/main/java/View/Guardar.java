package View;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Guardar extends JFrame {
    private Dashboard dashboard;
    private Dashboard.BackgroudImage backgroudImage;
    private JCalendar calendar;
    private JDateChooser dateChooser;
    private JLabel lbl;
    private JLabel lbl2;
    private JLabel lbl3;
    private JLabel lbl4;
    private JComboBox<String> Carreras;
    private JButton Submit;
    private JTextField Campo;
    private JButton BuscarProyecto;
    private JFileChooser fileChooser;

    public final String[] Rutas = {"src/main/Carreras/Informatica/","src/main/Carreras/Agroalimentaria/",
    "src/main/Carreras/Carreras/Educación sin mención/","src/main/Carreras/Educación Inicial/",
            "src/main/Carreras/Educación sin mención/"};

    public Guardar (Dashboard dashboard) {
        this.dashboard = dashboard;
        backgroudImage = new Dashboard.BackgroudImage();
        this.setContentPane(backgroudImage);
        fileChooser = new JFileChooser();
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

    private void Contenido() {
        setLayout(null);

        dateChooser = new JDateChooser();
        Carreras = new JComboBox<>();

        Submit = new JButton("Guardar Proyecto",ReescalarImagen("src/main/Img/guardar.png",25,25));
        BuscarProyecto = new JButton("Buscar Proyecto",ReescalarImagen("src/main/Img/archivo-de-busqueda.png",25,25));

        lbl = new JLabel("Nombre del Proyecto:");
        lbl2 = new JLabel("Seleccione la Carrera:");
        lbl3 = new JLabel("Seleccione la Ruta del Proyecto:");
        lbl4 = new JLabel("Fecha del proyecto:");

        Campo = new JTextField();

        Carreras.addItem(" ");
        Carreras.addItem("Informática");
        Carreras.addItem("Agroalimentaria");
        Carreras.addItem("Educación Inicial");
        Carreras.addItem("Educación Física");
        Carreras.addItem("Educación sin mención");

        lbl.setBounds(50,200,130,25);
        lbl2.setBounds(220,200,130,25);
        lbl3.setBounds(400,200,195,25);
        lbl4.setBounds(640,200,150,25);

        Campo.setBounds(50,250,130,25);
        Carreras.setBounds(220,250,130,25);

        BuscarProyecto.setBounds(405,240,190,35);
        Submit.setBounds(270,320,220,35);

        dateChooser.setBounds(640,250,130,25);

        add(dateChooser);
        add(Carreras);
        add(Submit);
        add(lbl);
        add(lbl2);
        add(lbl3);
        add(lbl4);
        add(Campo);
        add(BuscarProyecto);
        add(Submit);

    }

    public JButton getSubmit() {
        return Submit;
    }

    public JButton getBuscarProyecto () {
        return BuscarProyecto;
    }

    public JFileChooser getFileChooser () {
      return fileChooser;
    }

    public JTextField getCampo () {
        return Campo;
    }

    public JComboBox<String> getCarreras () {
        return Carreras;
    }

    public JDateChooser getDateChooser () {
        return dateChooser;
    }

    public String getRutas(int indice) {
        return Rutas[indice];
    }

    private ImageIcon ReescalarImagen(String Ruta, int newWidth, int newHeight){
        try {
            File file = new File(Ruta);
            BufferedImage originalImage = ImageIO.read(file);

            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            return new ImageIcon(scaledImage);

            // Ahora puedes usar el ImageIcon en tu GUI
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon();
    }

    public void Alert (String texto) {
        JOptionPane.showMessageDialog(null,texto,"INFORMATION_MESSAGE",JOptionPane.INFORMATION_MESSAGE);
    }
}
