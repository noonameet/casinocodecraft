package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

public class LoginDao {

    Conexion con = new Conexion();
    Connection cn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public boolean insertarUsuarios(login l) {

        String sql = "INSERT INTO usuarios (nombre,apellido,cedula,telefono,usuario,contraseña,rol,id) VALUES (?,?,?,?,?,?,?,?)";

        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, l.getNombre());
            ps.setString(2, l.getApellido());
            ps.setInt(3, l.getCedula());
            ps.setInt(4, l.getTelefono());
            ps.setString(5, l.getUsuario());
            ps.setString(6, l.getContraseña());
            ps.setString(7, l.getRol());
            ps.setInt(8, l.getId());
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de conexión: " + e);
        }
        return false;
    }

    public boolean autenticarUsuarios(String pUser, String pClave) {

        String sql = "SELECT usuario, contraseña FROM usuarios WHERE usuario=? and contraseña=?";

        try {
            cn = con.getConnection();
            ps = cn.prepareStatement(sql);
            ps.setString(1, pUser);
            ps.setString(2, pClave);

            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " " + e.toString());
        }
        return false;
    }

}
