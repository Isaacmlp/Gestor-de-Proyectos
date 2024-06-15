package Controller;

import View.Guardar;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Controller_Guardar implements WindowListener {
    Guardar guardar;


    public Controller_Guardar (Guardar guardar) {
        this.guardar = guardar;
        this.guardar.addWindowListener(this);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
