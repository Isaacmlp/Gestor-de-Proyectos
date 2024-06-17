package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Modelo_Visualizar {
    private ConexionDB conexionDB = new ConexionDB();
    private Connection Conexion;
    private String Consulta;

    public ResultSet GetCarreras(String Carrera) {
        ResultSet Result = null;

        try {
            Connection Conexion = conexionDB.ConnectionDB();
            Consulta = "SELECT * FROM proyectos WHERE Carrera = ?";
            PreparedStatement preparedStatement = Conexion.prepareStatement(Consulta);
            preparedStatement.setString(1,Carrera);
            Result = preparedStatement.executeQuery();
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return Result;
    }
}
