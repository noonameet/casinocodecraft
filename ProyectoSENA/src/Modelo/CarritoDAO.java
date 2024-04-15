package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarritoDAO {

    Conexion con = new Conexion();

    private int registrarCarrito(Carrito car) {
        String sql = "INSERT INTO carritoProductos(id_pedido, producto, precio, cantidad, total) VALUES (?, ?, ?, ?, ?)";
        try (Connection conex = con.getConnection(); PreparedStatement ps = conex.prepareStatement(sql)) {
            ps.setInt(1, car.getId_pedido());
            ps.setString(2, car.getProd());
            ps.setDouble(3, car.getPrecio());
            ps.setInt(4, car.getCantidad());
            ps.setInt(5, car.getTotal());
            ps.executeUpdate();
            System.out.println(ps);
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int registrarCarritoP(Carrito car) {
        return registrarCarrito(car);
    }

    private List<Carrito> seleccionarCarritoPorFactura(int id_factura) {
        String sql = "SELECT * FROM carritoProductos WHERE id_factura = ?";
        List<Carrito> carritos = new ArrayList<>();
        try (Connection conex = con.getConnection(); PreparedStatement ps = conex.prepareStatement(sql)) {
            ps.setInt(1, id_factura);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Carrito car = new Carrito();
                car.setId_pedido(rs.getInt("id_pedido"));
                car.setProd(rs.getString("producto"));
                car.setPrecio(rs.getDouble("precio"));
                car.setCantidad(rs.getInt("cantidad"));
                car.setTotal(rs.getInt("total"));
                carritos.add(car);
            }
            System.out.println(ps);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carritos;
    }

    public List<Carrito> obtenerCarritoPorFactura(int id_factura) {
        return seleccionarCarritoPorFactura(id_factura);
    }

}
