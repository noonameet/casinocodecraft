package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:sqlite:C:\\SQLite\\productosewu";
    private Connection connection = null;

    public ConexionBD() {
        try {
            connection = DriverManager.getConnection(URL);
            System.out.println("Conectado");
            
        } catch (SQLException e) {
            System.out.println("Error en Conexion: ");
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
