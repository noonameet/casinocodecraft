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
    Connection conex = con.getConnection();
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    private void registrarEmpleado(Reg_Empleados emple) {
        try {
            // Tu lógica para insertar el cliente en la base de datos
            String sql = "INSERT INTO reg_empleados(nom_empleados, ape_empleados, "
                    + "ced_empleados, tel_empleados, usuario, clave, rol) VALUES(?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement st = conex.prepareStatement(sql)) {
                st.setString(1, emple.getNom_emple());
                st.setString(2, emple.getApe_emple());
                st.setString(3, emple.getCed_emple());
                st.setString(4, emple.getTel_emple());
                st.setString(5, emple.getUsuario());
                st.setString(6, emple.getClave());
                st.setInt(7, emple.getRol());
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
    
    private ArrayList<Reg_Empleados> obtenerRolesEmpleados() {
        ArrayList<Reg_Empleados> listaE = new ArrayList<>();

        String sql = "SELECT e.id_rol, r.nom_empleados " +
                     "FROM emple_rol e " +
                     "INNER JOIN reg_empleados r ON e.id_rol = r.rol";

        try (Connection conex = con.getConnection();
             PreparedStatement ps = conex.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Reg_Empleados empleado = new Reg_Empleados();
                empleado.setRol(rs.getInt("id_rol")); // Cambié "rol" a "id_rol"
                empleado.setNom_emple(rs.getString("nom_empleados"));
                listaE.add(empleado);
                System.out.println("Empleado encontrado");
            }

            System.out.println("Empleados listados");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaE;
    }
    
    private ArrayList<Reg_Empleados> obtenerIDEmpleados(){
        ArrayList<Reg_Empleados> listaE = new ArrayList<>();
        String sql = "SELECT id_empleados, nom_empleados FROM reg_empleados";

        try (Connection conex = con.getConnection();
             PreparedStatement ps = conex.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Reg_Empleados empleado = new Reg_Empleados();
                empleado.setId_emple(rs.getInt("id_empleados"));
                empleado.setNom_emple(rs.getString("nom_empleados"));
                listaE.add(empleado);
                System.out.println("Empleado encontrado");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaE;
        
    }
    
    public ArrayList<Reg_Empleados> getEmpleados(){
        try{
            return obtenerIDEmpleados();
        }catch(Exception e){
            e.printStackTrace();
            return new ArrayList <>();
        }
    }
    
    public ArrayList<Reg_Empleados> obtenerEmpleados() {
        return obtenerRolesEmpleados();
    }
    
    public boolean autenticarUsuarios(String pUser, String pClave, int prol) {

        try {
            String sql = "SELECT usuario, clave, rol FROM reg_empleados WHERE usuario=? and clave=? and rol=?";
            ps = conex.prepareStatement(sql);
            ps.setString(1, pUser);
            ps.setString(2, pClave);
            ps.setInt(3, prol);

            rs = ps.executeQuery();
            while (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, " " + e.toString());
        }
        return false;
    }
    
    public int obtenerRol(String nombreUsuario) {
        int rol = 0;

        try {
            String sql = "SELECT rol FROM reg_empleados WHERE usuario=?";
            ps = conex.prepareStatement(sql);
            ps.setString(1, nombreUsuario);

            rs = ps.executeQuery();
            if (rs.next()) {
                rol = rs.getInt("rol");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rol;
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
