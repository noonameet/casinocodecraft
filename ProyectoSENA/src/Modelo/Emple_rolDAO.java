package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Emple_rolDAO {
    
    Conexion con = new Conexion();
    
    private ArrayList<Emple_rol> obtenerRoles() {
        ArrayList<Emple_rol> listaR = new ArrayList<>();
        String sql = "SELECT id_rol, nom_rol FROM emple_rol";
        
        try (Connection conex = con.getConnection();
             PreparedStatement ps = conex.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while(rs.next()){
                Emple_rol em = new Emple_rol();
                em.setId_rol(rs.getInt("id_rol"));
                em.setNom_rol(rs.getString("nom_rol"));
                listaR.add(em);
                System.out.println("Roles encontrados");
            }
            
            System.out.println("Roles listados");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaR;
    }
    
    public ArrayList<Emple_rol> obtenerRolesP() {
        return obtenerRoles();
    }
}
