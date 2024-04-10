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
    Connection conex = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    private void registrar_mesa(Mesa mesa) throws SQLException {
        try {
            conex = con.getConnection();
            String sql = "INSERT INTO reg_mesa(cant_sillas, tipo, estado) VALUES(?, ?, ?)";
            ps = conex.prepareStatement(sql);

            ps.setInt(1, mesa.getCant_sillas());
            ps.setString(2, mesa.getTipo());
            ps.setString(3, mesa.getEstado());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conex.close();
            ps.close();
        }
    }
    
    public void registrarMesa(Mesa mesa) throws SQLException{
        registrar_mesa(mesa);
    }
}
