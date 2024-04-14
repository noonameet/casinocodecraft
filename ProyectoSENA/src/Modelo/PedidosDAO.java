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

    private int registrarPedido(Pedidos ped) {
        String sql = "INSERT INTO tmp_pedidos(id_pedidos, mesa, mesero, estado, hora) "
                + "VALUES(?, ?, ?, ?, ?)";
        try(Connection conex = con.getConnection(); PreparedStatement ps = 
                conex.prepareStatement(sql)) {
            ps.setInt(1, ped.getId());
            ps.setInt(2, ped.getNum_mesa());
            ps.setInt(3, ped.getMesero());
            ps.setString(4, ped.getEstado());
            ps.setString(5,  ped.getHora());
            ps.executeUpdate();
            System.out.println(ps+"otro");
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
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
    
    public int registrarPedidoP(Pedidos ped){
        return registrarPedido(ped);
    }
}
