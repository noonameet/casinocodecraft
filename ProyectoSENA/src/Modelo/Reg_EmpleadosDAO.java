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

    private void registrarEmpleado(Reg_Empleados emple) {
        String sql = "INSERT INTO reg_empleados(nom_empleados, ape_empleados, "
                + "ced_empleados, tel_empleados, usuario, clave, rol) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try (Connection conex = con.getConnection(); PreparedStatement ps
                = conex.prepareStatement(sql)) {

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
        }
    }

    private boolean verificarEmpleado(Reg_Empleados emple) {
        String sql = "SELECT * FROM reg_empleados WHERE id_empleados = ?";
        try (Connection conex = con.getConnection(); PreparedStatement ps
                = conex.prepareStatement(sql)) {

            ps.setString(1, emple.getCed_emple());
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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

    private ArrayList<Reg_Empleados> obtenerEmpleados(int rol) {
        ArrayList<Reg_Empleados> listame = new ArrayList<>();

        String sql = "SELECT id_empleados, nom_empleados FROM reg_empleados WHERE rol = ?";

        try (Connection cn = con.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, rol);
            
            try(ResultSet rs = ps.executeQuery()){
                while (rs.next()) {
                    Reg_Empleados me = new Reg_Empleados();
                    me.setId_emple(rs.getInt("id_empleados"));
                    me.setNom_emple(rs.getString("nom_empleados"));
                    listame.add(me);
                    System.out.println(listame);
                    System.out.println("Meseros encontrados");
                }
            }catch (SQLException e){
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listame;
    }

    public ArrayList<Reg_Empleados> getObtenerEmpleados(int rol) {
        try {
            return obtenerEmpleados(rol);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

}
