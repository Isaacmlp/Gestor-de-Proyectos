package Model;

import View.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    Login login;
    Connection Conexion;

    public ConexionDB () {
        this.login = new Login();
    }

    public Connection getConnection() {
        Conexion = null;
        String Database = "java";
        String Direccion = "jdbc:mysql://localhost:3306/" + Database;
        String usuario = "root";
        String clave = "Sacler123#";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Conexion = DriverManager.getConnection(Direccion,usuario,clave);
        } catch (ClassNotFoundException | SQLException e) {

            login.Alert(String.valueOf(e));
        }
        return null;

    }



}
