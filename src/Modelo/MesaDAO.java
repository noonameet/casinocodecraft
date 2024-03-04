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
}
