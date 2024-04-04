package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Laderson Leon
 */
public class Reg_ClienteDAO {

    Conexion con = new Conexion();

    private void registrar_cli(Reg_Cliente cliente) {
        try (Connection conex = con.getConnection()) {
            String sql = "INSERT INTO reg_cliente(nom_cliente, ape_cliente, ced_cliente, direccion, telefono) VALUES(?, ?, ?, ?, ?)";
            PreparedStatement st = conex.prepareStatement(sql);
            st.setString(1, cliente.getNom_cli());
            st.setString(2, cliente.getApe_cli());
            st.setString(3, cliente.getCed_cli());
            st.setString(4, cliente.getDireccion());
            st.setString(5, cliente.getTelef());
            st.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void imprimirDatos() {
        try (Connection conex = con.getConnection()) {
            String sql = "SELECT * FROM reg_cliente";
            PreparedStatement st = conex.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            System.out.println("Datos en la base de datos:");
            while (rs.next()) {
                // Procesar resultados
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean verificarCliente(Reg_Cliente cliente) {
        try (Connection conex = con.getConnection()) {
            String sql = "SELECT * FROM reg_cliente WHERE id_cliente = ?";
            PreparedStatement st = conex.prepareStatement(sql);
            st.setString(1, cliente.getCed_cli());
            try (ResultSet rs = st.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private int ultimoId() {
        int id = 0;
        try (Connection conex = con.getConnection()) {
            String sql = "SELECT MAX(id_cliente) FROM reg_cliente";
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

    public int registrarCliente(Reg_Cliente cliente) {
        if (verificarCliente(cliente)) {
            System.out.println("Cliente ya registrado, favor intentar de nuevo!");
            return 1;
        } else {
            registrar_cli(cliente);
            return 0;
        }
    }
}
