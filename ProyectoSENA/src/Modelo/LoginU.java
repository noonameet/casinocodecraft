package Modelo;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author ladje
 */
public class LoginU {
    Conexion con = new Conexion();
    Connection conex = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public boolean auth(String pUser, String pClave) throws SQLException {

        try {
            conex = con.getConnection();
            String sql = "SELECT usuario, clave FROM reg_empleados WHERE usuario=? and clave=?";
            ps = conex.prepareStatement(sql);
            ps.setString(1, pUser);
            ps.setString(2, pClave);

            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conex.close();
            ps.close();
            rs.close();
        }
        return false;
    }
    
    public int rolUsu(String pUser, String pClave) throws SQLException {
        try{
            conex = con.getConnection();
            String sql = "SELECT rol FROM reg_empleados WHERE usuario=? AND clave=?";
            ps = conex.prepareStatement(sql);
            ps.setString(1, pUser);
            ps.setString(2, pClave);
            rs = ps.executeQuery();
     
            if (rs.next()) {
                return rs.getInt("rol");
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }finally{
            conex.close();
            ps.close();
            rs.close();
        }
        return 0;
    }
}
