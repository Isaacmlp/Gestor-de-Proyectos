package Controller;

import Model.Modelo_Login;
import View.Login;
import View.Dashboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller_Login implements ActionListener , KeyListener {
    Login login;
    Modelo_Login modeloLogin;
    String User;
    String Password;


    public Controller_Login(Login login) {
        this.login = login;
        modeloLogin = new Modelo_Login();
        login.btn.addActionListener(this);
        login.btn2.addActionListener(this);
        login.addKeyListener(this);
        login.setFocusable(false);
    }

    public void start_login(){
        login.setTitle("Login");
        login.setSize(300,300);
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.requestFocus();
        login.setVisible(true);
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Modelo_Login getModelo() {
        return modeloLogin;
    }

    public void setModelo(Modelo_Login modeloLogin) {
        this.modeloLogin = modeloLogin;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.getbtnenviar()) { //Boton para confirmar
            if(modeloLogin.BuscarDatos(login.txt.getText(),login.txt2.getText())) {
               login.Alert("Inicio de sesion exitoso");
               login.dispose();
               Dashboard dashboard = new Dashboard();
               Controller_Dashboard controllerDashboard = new Controller_Dashboard(dashboard);
            } else {
                login.Alert("Usuario o Clave invalida");
                login.LimpiarCampos();

            }
        } else if (e.getSource() == login.getBtnLimpiar()) {
            login.LimpiarCampos();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if(modeloLogin.BuscarDatos(login.txt.getText(),login.txt2.getText())) {
                login.Alert("Inicio de sesion exitoso");
                login.dispose();
                new Dashboard();
            } else {
                login.Alert("Usuario o Clave invalida");
                login.LimpiarCampos();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

