package View;

import javax.swing.*;

public class Guardar extends JFrame {

    public Guardar () {
        Iniciar();
    }

    private void Iniciar () {
        setTitle("Guardar");
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        requestFocus();
        setVisible(true);
    }
}
