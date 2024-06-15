package Model;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Modelo_Guardar {
    private ConexionDB conexionDB = new ConexionDB();
    private Connection Conexion;
    private String Consulta;

    public Modelo_Guardar () {

    }

    public String ObtenerRutaProyecto (JFileChooser fileChooser) {
        fileChooser.showOpenDialog(fileChooser);
        return fileChooser.getSelectedFile().getAbsolutePath();
    }

    public String ObtenerNombreArchivo (JFileChooser fileChooser) {
        return fileChooser.getSelectedFile().getName();
    }

    public boolean MoverArchivo(String RutaActual,String RutaDestino) throws IOException {
       try {
           Files.move(Paths.get(RutaActual), Paths.get(RutaDestino));
           return true;
       } catch (IOException e) {
           return false;
       }
    }

    public boolean GuardarProyecto(String Nombreproyecto, String Carrera, String Ruta, String fecha ) {
        try {
            Conexion = conexionDB.ConnectionDB();
            Consulta = "INSERT INTO proyectos(Nombre_Proyecto, Carrera, RutaProyecto, FechaProyecto) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = Conexion.prepareStatement(Consulta);
            preparedStatement.setString(1,Nombreproyecto);
            preparedStatement.setString(2,Carrera);
            preparedStatement.setString(3,Ruta);
            preparedStatement.setString(4,fecha);
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public String Formartearfecha(Date fecha) {
        SimpleDateFormat formato = new SimpleDateFormat("yy-MM-dd");
        return formato.format(fecha);
    }

}
