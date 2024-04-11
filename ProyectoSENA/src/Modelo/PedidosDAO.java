package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Laderson Leon
 */
public class PedidosDAO {

    Conexion con = new Conexion();
    Pedidos ped = new Pedidos() {};
    Mesa mesa = new Mesa();
    Reg_Empleados emp = new Reg_Empleados();

    private void registrarPedido(Pedidos ped) {
        String sql = "INSERT INTO tmp_pedidos(?, ?, ?, ?, ?, ?)";
        try(Connection conex = con.getConnection(); PreparedStatement ps = 
                conex.prepareStatement(sql)) {
            ps.setInt(1, mesa.getId_mesa());
            ps.setInt(2, emp.getId_emple());
            ps.setString(3, ped.getProducto());
            ps.setString(4, ped.getCantidad());
            ps.setString(5, ped.getEstado());
            ps.setTime(6, (Time) ped.getFecha());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean verificarEstado(Pedidos ped) {
        String sql = "SELECT estado FROM tmp_pedidos WHERE id_pedidos=?";
        boolean estado = false;
        try(Connection conex = con.getConnection(); PreparedStatement ps = 
                conex.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            ps.setInt(1, ped.getId());
            if (rs.next()) {
                estado = rs.getBoolean("estado");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return estado;
    }
    

    private void eliminarPedido(int id) {
        String sql = "DELETE FROM tmp_pedidos WHERE id_pedidos=?";
        try(Connection conex = con.getConnection(); PreparedStatement ps = 
                conex.prepareStatement(sql); ResultSet rs = ps.executeQuery();) {
            ps.setInt(1, id);
            if (rs.next()) {
                System.out.println("Pedido eliminado correctamente!");
            } else {
                System.out.println("ERROR!");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }
}
