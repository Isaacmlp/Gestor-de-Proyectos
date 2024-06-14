package Controller;

import Model.Modelo;
import View.Login;
import View.Dashboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller_Login implements ActionListener {
    Login login;
    Modelo modelo;
    String User;
    String Password;


    public Controller_Login(Login login) {
        this.login = login;
        modelo = new Modelo();
        login.btn.addActionListener(this);
        login.btn2.addActionListener(this);
    }

    public void start_login(){
        login.setTitle("Login");
        login.setSize(300,300);
        login.setResizable(false);
        login.setLocationRelativeTo(null);
        login.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        login.setVisible(true);
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login.getbtnenviar()) { //Boton para confirmar
            if(modelo.BuscarDatos(login.txt.getText(),login.txt2.getText())) {
               login.Alert("Inicio de sesion exitoso");
               login.dispose();
               Dashboard dashboard = new Dashboard();
            } else {
                login.Alert("Usuario o Clave invalida");
                login.LimpiarCampos();

            }
        } else if (e.getSource() == login.getBtnLimpiar()) {
            login.LimpiarCampos();
        }
    }
}

