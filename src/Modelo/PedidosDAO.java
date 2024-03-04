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
    Connection conex = con.getConnection();
    Pedidos ped = new Pedidos() {};

    private void RegistrarPedido(int id_m, int id_e) {
        String sql = "INSERT INTO tmp_pedidos(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, ped.getId());
            ps.setInt(2, id_m);
            ps.setInt(3, id_e);
            ps.setString(4, ped.getProducto());
            ps.setString(5, ped.getCantidad());
            ps.setString(6, ped.getEstado());
            ps.setTime(7, (Time) ped.getFecha());
            ps.execute();
        } catch (SQLException e) {
            System.out.println(e.toString());
        } finally {
            try {
                conex.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    private boolean verificarEstado(int id) {
        String sql = "SELECT estado FROM tmp_pedidos WHERE id_pedidos=?";
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

    private int actualizarEstado(int id, Pedidos p) {
        int r = 1;
        String sql = "UPDATE tmp_pedidos SET estado=? where id_pedidos =" + id;
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setString(1, p.getEstado());
            ps.executeUpdate();
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return r;
    }

    private void eliminarPedido(int id) {
        String sql = "DELETE FROM tmp_pedidos WHERE id_pedidos=?";
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                System.out.println("Pedido eliminado correctamente!");
            } else {
                System.out.println("ERROR!");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    //TERMINAR ESTO
    private void modificarPedido(int id, Pedidos p) {
        String sql = "UPDATE tmp_pedidos SET mesa=?, mesero=?, producto=?, cantidad=?, hora=? WHERE id_pedidos=?";
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, p.getNum_mesa());
            ps.setInt(2, p.getMesero());
            ps.setString(3, p.getProducto());
            ps.setString(4, p.getCantidad());
            ps.setTime(5, (Time) p.getFecha());
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    private List listarPedidos() {
        String sql = "SELECT * FROM tmp_pedidos";
        List<Pedidos> lista = new ArrayList<>();

        try {
            PreparedStatement ps = conex.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Pedidos p = new Pedidos() {};
                p.setId(rs.getInt(1));
                p.setNum_mesa(rs.getInt(2));
                p.setMesero(rs.getInt(3));
                p.setProducto(rs.getString(4));
                p.setCantidad(rs.getString(5));
                p.setEstado(rs.getString(6));
                p.setFecha(rs.getDate(7));
                lista.add(p);
            }
        } catch (SQLException e) {
            System.out.println("No se pudo establecer conexión");
        }
        return lista;
    }
}
