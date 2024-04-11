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

    private void registrar_cli(Reg_Cliente cliente)  {
        String sql = "INSERT INTO reg_cliente(nom_cliente, ape_cliente, "
                    + "ced_cliente, direccion, telefono) VALUES(?, ?, ?, ?, ?)";
        try(Connection conex = con.getConnection(); PreparedStatement ps = 
                conex.prepareStatement(sql)) {
            ps.setString(1, cliente.getNom_cli());
            ps.setString(2, cliente.getApe_cli());
            ps.setString(3, cliente.getCed_cli());
            ps.setString(4, cliente.getDireccion());
            ps.setString(5, cliente.getTelef());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean verificarCliente(Reg_Cliente cliente) {
        String sql = "SELECT * FROM reg_cliente WHERE id_cliente = ?";
        try(Connection conex = con.getConnection(); PreparedStatement ps = 
                conex.prepareStatement(sql)) {
            ps.setString(1, cliente.getCed_cli());
            
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
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
