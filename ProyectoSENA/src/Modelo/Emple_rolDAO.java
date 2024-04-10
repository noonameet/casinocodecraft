package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Emple_rolDAO {
    
    Conexion con = new Conexion();
    Connection conex = con.getConnection();
    ResultSet rs = null;
    PreparedStatement ps = null;
    
    private ArrayList<Emple_rol> obtenerRoles() throws SQLException {
        ArrayList<Emple_rol> listaR = new ArrayList<>();
        try {
            String sql = "SELECT id_rol, nom_rol FROM emple_rol";
            
            ps = conex.prepareStatement(sql);
            rs = ps.executeQuery();

            while(rs.next()){
                Emple_rol em = new Emple_rol();
                em.setId_rol((rs.getInt("id_rol")));
                em.setNom_rol((rs.getString("nom_rol")));
                listaR.add(em);
                System.out.println("Roles encontrados");
            }

            System.out.println("Roles listados");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conex.close();
            ps.close();
            rs.close();
        }
        return listaR;
    }
    
    public ArrayList<Emple_rol> obtenerRolesP() throws SQLException {
        return obtenerRoles();
    }
}
