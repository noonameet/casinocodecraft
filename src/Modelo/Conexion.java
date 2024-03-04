package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Laderson Leon
 */
public class Conexion {

    Connection con;

    public Conexion() {
    }

    public Conexion(Connection con) {
        this.con = con;
    }

    public Connection getConnection() {
        try {
            String myBD = "jdbc:sqlite:C:\\Users\\Administrador\\ok";
            con = DriverManager.getConnection(myBD);
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}
