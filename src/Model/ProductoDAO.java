package Model;

import java.sql.*;
import Conexion.ConexionBD;

public class ProductoDAO {

    ConexionBD con = new ConexionBD();

    public void Registrar(Producto pro) {
        String sql = "INSERT INTO productos(id_producto, nombre, cantidad, precio, id_cat_prod) VALUES(?, ?, ?, ?, ?)";

        try (Connection conn = con.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, pro.getId_producto());
            pstmt.setString(2, pro.getNombre());
            pstmt.setInt(3, pro.getCantidad());
            pstmt.setInt(4, pro.getPrecio()); // el error
            pstmt.setInt(5, pro.getCategoria().getId()); // aqui tambien
            pstmt.executeUpdate();

        } catch (Exception ex) {
            System.out.println("Boom");
        }
    }
}
