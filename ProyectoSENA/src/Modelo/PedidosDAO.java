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
    Pedidos ped = new Pedidos() {
    };
    Mesa mesa = new Mesa();
    Reg_Empleados emp = new Reg_Empleados();

    private int registrarPedido(Pedidos ped) {
        String sql = "INSERT INTO tmp_pedidos(id_pedidos, mesa, mesero, estado, hora) "
                + "VALUES(?, ?, ?, ?, ?)";
        try (Connection conex = con.getConnection(); PreparedStatement ps
                = conex.prepareStatement(sql)) {
            ps.setInt(1, ped.getId());
            ps.setInt(2, ped.getNum_mesa());
            ps.setInt(3, ped.getMesero());
            ps.setString(4, ped.getEstado());
            ps.setString(5, ped.getHora());
            ps.executeUpdate();
            System.out.println(ps + "otro");
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    private boolean verificarEstado(Pedidos ped) {
        String sql = "SELECT estado FROM tmp_pedidos WHERE id_pedidos=?";
        boolean estado = false;
        try (Connection conex = con.getConnection(); PreparedStatement ps
                = conex.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {
            ps.setInt(1, ped.getId());
            if (rs.next()) {
                estado = rs.getBoolean("estado");
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return estado;
    }

    private ArrayList<Pedidos> obtenerPedido() {
        ArrayList<Pedidos> listame = new ArrayList<>();

        String sql = "SELECT id_pedidos, mesero FROM tmp_pedidos WHERE estado = 'Pendiente'";

        try (Connection cn = con.getConnection(); PreparedStatement ps = cn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pedidos pe = new Pedidos();
                pe.setId(rs.getInt("id_pedidos"));
                pe.setMesero(rs.getInt("mesero"));
                listame.add(pe);
                System.out.println(listame);
                System.out.println("Meseros encontrados");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listame;
    }

    public ArrayList<Pedidos> getObtenerPedidos() {
        try {
            return obtenerPedido();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public int registrarPedidoP(Pedidos ped) {
        return registrarPedido(ped);
    }

    private double obtenerTotalPedido(int idPedido) {
        double total = 0.0;
        String sql = "SELECT SUM(total) FROM carritoProductos WHERE id_pedido = ?";
        try (Connection cn = con.getConnection(); PreparedStatement ps = cn.prepareStatement(sql);) {
            ps.setInt(1, idPedido);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    total = rs.getDouble(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            total = -1;
        }
        return total;
    }

    public double getTotalPedido(int idPedido) {
        return obtenerTotalPedido(idPedido);
    }

    private void actualizarIdFactura(int idPedido, int idFactura) {
        String sql = "UPDATE carritoProductos SET id_factura = ? WHERE id_pedido = ?";
        try (Connection cn = con.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idFactura);
            ps.setInt(2, idPedido);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void getActualizarIdFactura(int idPedido, int idFactura) {
        actualizarIdFactura(idPedido, idFactura);
    }

    private void updatestadodepedido(int idPedido) {
        String sql = "UPDATE tmp_pedidos SET estado = 'Preparado' WHERE id_pedidos = ?";
        try (Connection cn = con.getConnection(); PreparedStatement ps = cn.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void getActualizarpedido(int codigoPedido) {
        updatestadodepedido(codigoPedido);
    }

}
