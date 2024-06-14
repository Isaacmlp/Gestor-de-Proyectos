package Model;


import java.sql.*;

public class Modelo {
    ConexionDB coneDB;
    Connection Conexion;
    String Consulta;
    private String url = "jdbc:mysql://localhost:3306/java";
    private String usuario = "root";
    private String contraseña = "Sacler123#";

    public Modelo() {
        this.coneDB = new ConexionDB();
    }

    public boolean BuscarDatos(String User, String Clave) {
        Consulta = "SELECT COUNT(*) FROM usuarios WHERE Usuario = ? and Clave = ?";

        try (Connection connection = DriverManager.getConnection(url, usuario, contraseña);
             PreparedStatement statement = connection.prepareStatement(Consulta)) {
            statement.setString(1,User);
            statement.setString(2,Clave);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int cantidadUsuarios = resultSet.getInt(1);
                    if (cantidadUsuarios > 0) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}

