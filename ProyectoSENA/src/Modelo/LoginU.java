package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginU {

    Conexion con = new Conexion();

    public boolean auth(String pUser, String pClave) {
        String sql = "SELECT usuario, clave FROM reg_empleados WHERE usuario=? and clave=?";
        try (Connection conex = con.getConnection();
                PreparedStatement ps = conex.prepareStatement(sql)) {

            ps.setString(1, pUser);
            ps.setString(2, pClave);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int rolUsu(String pUser, String pClave) {
        String sql = "SELECT rol FROM reg_empleados WHERE usuario=? AND clave=?";
        try (Connection conex = con.getConnection();
                PreparedStatement ps = conex.prepareStatement(sql)) {

            ps.setString(1, pUser);
            ps.setString(2, pClave);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("rol");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}




