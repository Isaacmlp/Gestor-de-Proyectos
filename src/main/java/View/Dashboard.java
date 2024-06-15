package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Dashboard extends JFrame {

    private JLabel Titulo;
    private JLabel Subtitulo;
    private JButton BtnGuardar;
    private JButton BtnVizualizar;
    private JLabel Background;
    private JPanel panel;
    private BackgroudImage backgroudImage = new BackgroudImage();

    public Dashboard () {
        this.setContentPane(backgroudImage);
        Contenido();
        Iniciar();
    }

    public static class BackgroudImage extends JPanel {
        private Image Img;

        @Override
        public void paint(Graphics g) {
            Img = new ImageIcon("C:\\Users\\Isaac León\\IdeaProjects\\Proyecto\\src\\main\\Img\\Mision1.jpg").getImage();
            g.drawImage(Img,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }

    private void Contenido () {
        setLayout(null);

        /*
        Titulo = new JLabel("");
        Titulo.setFont(new Font("Arial", Font.PLAIN, 25));
        Titulo.setBounds(90,50,450,25);

        Subtitulo = new JLabel("");
        Subtitulo.setFont(new Font("Arial", Font.PLAIN, 25));
        Subtitulo.setBounds(125,95,300,25);
        */

        BtnGuardar = new JButton("Guardar Proyecto",ReescalarImagen("C:\\Users\\Isaac León\\IdeaProjects\\Proyecto\\src\\main\\Img\\guardar-el-archivo.png",25,25));
        BtnGuardar.setBounds(130,125,200,50);
        BtnGuardar.setFocusable(false);

        BtnVizualizar = new JButton("Vizualizar Proyecto",ReescalarImagen("C:\\Users\\Isaac León\\IdeaProjects\\Proyecto\\src\\main\\Img\\documento.png",25,25));
        BtnVizualizar.setBounds(130,190,200,50);
        BtnVizualizar.setFocusable(false);

        //add(Titulo);
        //add(Subtitulo);
        add(BtnGuardar);
        add(BtnVizualizar);
    }

    private void Iniciar () {
        setTitle("Dashboard");
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        requestFocus();
        setVisible(true);
    }

    public JLabel GetTitulo() {
        return Titulo;
    }

    public JLabel GetSubTitulo() {
        return Subtitulo;
    }

    public JButton GetBtnGuardar() {
        return  BtnGuardar;
    }

    public JButton GetBtnVizualizar() {
        return  BtnVizualizar;
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
}
