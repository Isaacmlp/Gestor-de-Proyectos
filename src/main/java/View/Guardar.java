package View;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;

public class Guardar extends JFrame {
    private Dashboard dashboard;
    private Dashboard.BackgroudImage backgroudImage;
    private JCalendar calendar;
    private JDateChooser dateChooser;

    public Guardar (Dashboard dashboard) {
        this.dashboard = dashboard;
        backgroudImage = new Dashboard.BackgroudImage();
        Iniciar();
        Contenido();
    }


    private void Iniciar () {
        setTitle("Guardar");
        setSize(600,700);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        requestFocus();
        setContentPane(backgroudImage);
        setVisible(true);
    }

    private void Contenido() {
        calendar = new JCalendar();
        dateChooser = new JDateChooser();


        add(calendar);
        add(dateChooser);
    }
}
