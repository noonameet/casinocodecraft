package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author Laderson Leon
 */
public class MesaDAO {

    Conexion con = new Conexion();
    Connection conex = con.getConnection();
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    private void registrar_mesa(Mesa mesa) {
        try {
            // Tu lógica para insertar el cliente en la base de datos
            String sql = "INSERT INTO reg_mesa VALUES(?, ?, ?, ?)";
            try (PreparedStatement st = conex.prepareStatement(sql)) {
                st.setInt(1, mesa.getId_mesa());
                st.setInt(2, mesa.getCant_sillas());
                st.setString(3, mesa.getTipo());
                st.setString(4, mesa.getEstado());
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
    
    private void disponible(int id_mesa) {
        try {
            String sql = "update reg_mesa set estado='Disponible' where id_mesa= 1";
            PreparedStatement st = conex.prepareStatement(sql);
            pst.setInt(1, id_mesa);
            ResultSet rs = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private void ocupado(int id_mesa) {
        try {
            String sql = "update reg_mesa set estado='Ocupado' where id_mesa= 1";
            PreparedStatement st = conex.prepareStatement(sql);
            pst.setInt(1, id_mesa);
            ResultSet rs = st.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Mesa> Buscar_mesas() {
        ArrayList<Mesa> M = new ArrayList<>();
        String sql = "SELECT * FROM reg_mesa";
        try {
            pst = conex.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                Mesa mesas = new Mesa(rs.getInt("id_mesa"), rs.getInt("cant_sillas"), rs.getString("tipo"), rs.getString("estado"));
                M.add(mesas);
            }
        } catch (SQLException e) {
        }
        return M;
    }
    
    public int devolverId() {
        return ultimoId();
    }
    
    public int registrarMesa(int a){
        return a;
    }
    public int Disponible(int id_mesa){
        return id_mesa;
    }
    public int Ocupado(int id_mesa){
        return id_mesa;
    }
}
