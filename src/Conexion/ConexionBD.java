package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    // La URL de la base de datos
    private static final String URL = "jdbc:sqlite:C:\\Users\\Administrador\\Documents\\NetBeansProjects\\casinocraft\\src\\Conexion\\SQLite\\casinocraft";
    private static Connection connection;

    // Método privado para evitar instancias no deseadas
    private ConexionBD() {}

    // Método estático para obtener la conexión a la base de datos
    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Intenta establecer la conexión si no existe
                connection = DriverManager.getConnection(URL);
            } catch (SQLException e) {
                // Maneja las excepciones de conexión aquí
                e.printStackTrace();
            }
        }
        return connection;
    }

    // Método para cerrar la conexión
    public static void cerrarConexion() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                // Maneja las excepciones de cierre aquí
                e.printStackTrace();
            }
        }
    }
}
