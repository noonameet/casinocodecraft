package Modelo;

import java.sql.*;

public class ProductoDAO {

    Conexion con = new Conexion();

    public void Registrar(Producto pro) {
        String sql = "INSERT INTO productos(id_producto, nombre, cantidad, precio, id_cat_prod) VALUES(?, ?, ?, ?, ?)";

        try (Connection conex = con.getConnection(); PreparedStatement pr = conex.prepareStatement(sql)) {

            pr.setInt(1, pro.getId_producto());
            pr.setString(2, pro.getNombre());
            pr.setInt(3, pro.getCantidad());
            pr.setDouble(4, pro.getPrecio());
            pr.setInt(5, pro.getCategoria().getId());
            pr.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
