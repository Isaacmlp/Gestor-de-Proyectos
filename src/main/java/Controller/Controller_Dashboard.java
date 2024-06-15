package Controller;

import View.Dashboard;
import View.Guardar;
import View.Visualizar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller_Dashboard implements ActionListener {
    Dashboard dashboard;

    public Controller_Dashboard (Dashboard dashboard) {
        this.dashboard = dashboard;
        this.dashboard.GetBtnVizualizar().addActionListener(this);
        this.dashboard.GetBtnGuardar().addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == dashboard.GetBtnGuardar()) {
            Guardar guardar = new Guardar();
            Controller_Guardar controllerGuardar = new Controller_Guardar(guardar);
        } else if (e.getSource() == dashboard.GetBtnVizualizar()) {
            Visualizar visualizar = new Visualizar();
            Controller_Visualizar controllerVisualizar = new Controller_Visualizar(visualizar);
        }
    }
}
