package Modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Jairo
 */
public class Conexion {

    Connection con;

    public Conexion() {
    }

    public Conexion(Connection con) {
        this.con = con;
    }
    
    public Connection getConnection(){
        try{
            String myBD = "jdbc:sqlite:D:\\sqlite-tools-win-x64-3450000\\LoginP";
            con = DriverManager.getConnection(myBD);
            return con;
        }catch(SQLException e){
            System.out.println("No se pudo conectar a la base de datos");
        }
        return null;
    }
}
