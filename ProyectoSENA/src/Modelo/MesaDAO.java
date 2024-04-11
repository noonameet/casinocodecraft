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

    private void registrar_mesa(Mesa mesa) {
        String sql = "INSERT INTO reg_mesa(cant_sillas, tipo, estado) VALUES(?, ?, ?)";

        try (Connection conex = con.getConnection();
                PreparedStatement ps = conex.prepareStatement(sql)) {

            ps.setInt(1, mesa.getCant_sillas());
            ps.setString(2, mesa.getTipo());
            ps.setString(3, mesa.getEstado());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registrarMesa(Mesa mesa) {
        registrar_mesa(mesa);
    }
}
