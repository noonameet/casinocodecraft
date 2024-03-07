package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Laderson Leon
 */
public class Reg_EmpleadosDAO {
    
    Conexion con = new Conexion();
    Connection conex = con.getConnection();
    
    private void registrarEmpleado(Reg_Empleados emple) {
        try {
            // Tu lógica para insertar el cliente en la base de datos
            String sql = "INSERT INTO reg_empleados VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement st = conex.prepareStatement(sql)) {
                st.setInt(1, emple.getId_cli());
                st.setString(2, emple.getNom_emple());
                st.setString(3, emple.getApe_emple());
                st.setString(4, emple.getCed_emple());
                st.setString(5, emple.getTel_emple());
                st.setString(6, emple.getUsuario());
                st.setString(7, emple.getClave());
                st.setInt(8, emple.getRol());
                int rows = st.executeUpdate();
                if (rows > 0) {
                    System.out.println("Empleado registrado en la base de datos: "
                            + emple.getNom_emple() + " " + emple.getCed_emple());
                } else {
                    System.out.println("No se pudo insertar el cliente "
                            + "en la base de datos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private boolean verificarEmpleado(Reg_Empleados emple) {
        try {
            String sql = "SELECT * FROM reg_empleados WHERE id_empleados = ?";
            PreparedStatement st = conex.prepareStatement(sql);
            st.setString(1, emple.getCed_emple());
            try (ResultSet rs = st.executeQuery()) {
                System.out.println(st.executeQuery());
                System.out.println(rs.next());
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    private int ultimoId() {
        int id = 0;
        try {
            String sql = "SELECT MAX(id_empleados) FROM reg_empleados";
            PreparedStatement st = conex.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public int devolverId() {
        return ultimoId();
    }
    
    public int registrarEmpleados(Reg_Empleados emple) {
        if (verificarEmpleado(emple)) {
            System.out.println("Empleado ya registrado, favor intentar de nuevo!");
            return 1;
        } else {
            registrarEmpleado(emple);
            return 0;
        }
    }
}
