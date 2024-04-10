package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Laderson Leon
 */
public class Reg_EmpleadosDAO {
    
    Conexion con = new Conexion();
    Connection conex = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private void registrarEmpleado(Reg_Empleados emple) throws SQLException {
        try {
            conex = con.getConnection();
            String sql = "INSERT INTO reg_empleados(nom_empleados, ape_empleados, "
                    + "ced_empleados, tel_empleados, usuario, clave, rol) VALUES(?, ?, ?, ?, ?, ?, ?)";
            ps = conex.prepareStatement(sql);
            
            ps.setString(1, emple.getNom_emple());
            ps.setString(2, emple.getApe_emple());
            ps.setString(3, emple.getCed_emple());
            ps.setString(4, emple.getTel_emple());
            ps.setString(5, emple.getUsuario());
            ps.setString(6, emple.getClave());
            ps.setInt(7, emple.getRol());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conex.close();
            ps.close();
        }
    }
    
    private boolean verificarEmpleado(Reg_Empleados emple) throws SQLException {
        try {
            conex = con.getConnection();
            String sql = "SELECT * FROM reg_empleados WHERE id_empleados = ?";
            ps = conex.prepareStatement(sql);
            ps.setString(1, emple.getCed_emple());
            try (ResultSet rs = ps.executeQuery()) {
                System.out.println(ps.executeQuery());
                System.out.println(rs.next());
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            conex.close();
            ps.close();
        }
    }
    
    public int registrarEmpleados(Reg_Empleados emple) throws SQLException {
        if (verificarEmpleado(emple)) {
            System.out.println("Empleado ya registrado, favor intentar de nuevo!");
            return 1;
        } else {
            registrarEmpleado(emple);
            return 0;
        }
    }
}
