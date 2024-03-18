package Modelo;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class IngredientesDAO {

    Conexion con = new Conexion();

    private ArrayList<Ingredientes> obtenerIngredientesDisponibles() {
        ArrayList<Ingredientes> ingredientes = new ArrayList<>();

        String sql = "SELECT id_prod_ent, nombre FROM iv_prod_ent";

        try (Connection cn = con.getConnection(); PreparedStatement pst = cn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int idingrediente = rs.getInt("id_prod_ent");
                String nombreIngrediente = rs.getString("nombre");
                Ingredientes ingrediente = new Ingredientes(idingrediente, nombreIngrediente);
                ingredientes.add(ingrediente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ingredientes;
    }

    public ArrayList<Ingredientes> getIngredientesDisponibles() {
        try {
            return obtenerIngredientesDisponibles();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void asociarProductoIngrediente(int idProducto, int idIngrediente) {
        String sql = "INSERT INTO Producto_Ingrediente (id_producto, id_ingrediente) VALUES (?, ?)";

        try (Connection cn = con.getConnection(); PreparedStatement pst = cn.prepareStatement(sql)) {

            pst.setInt(1, idProducto);
            pst.setInt(2, idIngrediente);

            int filasAfectadas = pst.executeUpdate();

            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Producto e ingrediente asociados correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo asociar el producto e ingrediente.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al asociar el producto e ingrediente.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public boolean asociarProductoConIngrediente(int idProducto, int idIngrediente) {
        try {
            asociarProductoIngrediente(idProducto, idIngrediente);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
