package View;

import javax.swing.*;
import java.awt.*;

public class Login extends JFrame {
    public JPanel panel = new JPanel();
    public JLabel lbl = new JLabel("Usuario:");
    public JLabel lbl2 = new JLabel("Clave:");
    public JLabel lbl3 = new JLabel("Iniciar Sesion");
    public JTextField txt = new JTextField();
    public JPasswordField txt2 = new JPasswordField();
    public JButton btn = new JButton("Limpiar");
    public JButton btn2 = new JButton("Enviar");
    public BackgroudImageLogin backgroudImageLogin = new BackgroudImageLogin();

    public Login() {

        Contenido();
    }

    public static class BackgroudImageLogin extends JPanel {
        private Image Img;

        @Override
        public void paint(Graphics g) {
            Img = new ImageIcon("C:\\Users\\Isaac León\\IdeaProjects\\Proyecto\\src\\main\\Img\\fondo_login.png").getImage();
            g.drawImage(Img,0,0,getWidth(),getHeight(),this);
            setOpaque(false);
            super.paint(g);
        }
    }

    void Contenido () {
        panel = new JPanel();
        setLayout(null);

        lbl = new JLabel("Usuario:");
        lbl2 = new JLabel("Clave:");
        lbl3 = new JLabel("Iniciar Sesion");
        txt = new JTextField();
        txt2 = new JPasswordField();
        btn = new JButton("Limpiar");
        btn2 = new JButton("Enviar");

        btn.setFocusable(false);
        btn2.setFocusable(false);


        lbl3.setBounds(100,10,100,50);
        lbl.setBounds(50,50,100,50);
        lbl2.setBounds(50,100,100,50);

        txt.setBounds(150,65,100,25);
        txt2.setBounds(150,115,100,25);

        btn.setBounds(50,180,90,25);
        btn2.setBounds(150,180,90,25);

        add(lbl);
        add(lbl2);
        add(lbl3);
        add(txt);
        add(txt2);
        add(btn);
        add(btn2);


    }

    public void LimpiarCampos() {
        txt.setText("");
        txt2.setText("");
    }

    public void Alert (String texto) {
        JOptionPane.showMessageDialog(null,texto,"INFORMATION_MESSAGE",JOptionPane.INFORMATION_MESSAGE);
    }

    public JButton getbtnenviar () {
        return btn2;
    }

    public JButton getBtnLimpiar() {
        return btn;
    }


}
