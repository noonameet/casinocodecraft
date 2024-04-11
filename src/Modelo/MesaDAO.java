package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Laderson Leon
 */
public class MesaDAO {

    Conexion con = new Conexion();
    Connection conex = con.getConnection();

    private void registrar_mesa(Mesa mesa) {
        try {
            String sql = "INSERT INTO reg_mesa(cant_sillas, tipo, estado) VALUES(?, ?, ?)";
            try (PreparedStatement st = conex.prepareStatement(sql)) {
                st.setInt(1, mesa.getCant_sillas());
                st.setString(2, mesa.getTipo());
                st.setString(3, mesa.getEstado());
                int rows = st.executeUpdate();
                if (rows > 0) {
                    System.out.println("Mesa registrado en la base de datos: "
                            + mesa.getId_mesa() + " " + mesa.getTipo());
                } else {
                    System.out.println("No se pudo insertar la mesa "
                            + "en la base de datos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private boolean verificarEstadoMesa(int id){
        String sql = "SELECT estado FROM reg_mesa WHERE id_mesa=?";
        boolean estado = false;
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estado = rs.getBoolean("estado");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return estado;
    }
    
    private void cambiarEstadoMesa(){
        
    }

    private int ultimoId() {
        int id = 0;
        try {
            String sql = "SELECT MAX(id_mesa) FROM reg_mesa";
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
    
    public void registrarMesa(Mesa mesa){
        registrar_mesa(mesa);
    }
}
