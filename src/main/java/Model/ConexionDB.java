package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private String Database = "java";
    private String Direccion = "jdbc:mysql://localhost:3306/" + Database;
    private String usuario = "root";
    private String clave = "Sacler123#";
    private String Driver = "com.mysql.cj.jdbc.Driver";

    protected Connection ConnectionDB() {
        Connection Conexion = null;
        try {
            Class.forName(Driver);
            Conexion = DriverManager.getConnection(Direccion,usuario,clave);
            return Conexion;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return Conexion;

    }



}
