package View;

import javax.swing.*;

public class Visualizar extends JFrame {
    Dashboard dashboard;

    public  Visualizar (Dashboard dashboard) {
        this.dashboard = dashboard;
        Iniciar();
    }

    private void Iniciar () {
        setTitle("Visualizar");
        setSize(500,500);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        requestFocus();
        setVisible(true);
    }
}
