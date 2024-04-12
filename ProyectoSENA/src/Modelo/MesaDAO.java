package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class MesaDAO {

    Conexion con = new Conexion();

    private void registrar_mesa(Mesa mesa) {
        String sql = "INSERT INTO reg_mesa(cant_sillas, tipo, estado) VALUES(?, ?, ?)";

        try (Connection conex = con.getConnection(); PreparedStatement ps = conex.prepareStatement(sql)) {

            ps.setInt(1, mesa.getCant_sillas());
            ps.setString(2, mesa.getTipo());
            ps.setString(3, mesa.getEstado());
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void registrarMesa(Mesa mesa) {
        registrar_mesa(mesa);
    }

    private ArrayList<Mesa> ObtenerMesas() {
        ArrayList<Mesa> listamesas = new ArrayList<>();

        String sql = "SELECT id_mesa, tipo, cant_sillas FROM reg_mesa WHERE estado = 'Desocupada'";

        try (Connection cn = con.getConnection(); PreparedStatement pst = cn.prepareStatement(sql); ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Mesa mesas = new Mesa();
                mesas.setId_mesa(rs.getInt("id_mesa"));
                mesas.setTipo(rs.getString("tipo"));
                mesas.setCant_sillas(rs.getInt("cant_sillas"));
                listamesas.add(mesas);
                System.out.println("Mesa encontrada");
            }

            System.out.println("Mesas listadas");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listamesas;
    }

    public ArrayList<Mesa> getObtenerMesas() {
        try {
            return ObtenerMesas();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private DefaultTableModel obtenerProductosAsociados() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Producto");
        model.addColumn("Categoria");
        model.addColumn("Precio");

        try (Connection conn = con.getConnection()) {
            String sql = "SELECT p.nombre AS Producto, c.cat_prod_nom AS Categoria, "
                    + "p.precio AS Precio FROM productos "
                    + "p JOIN prod_categoria c ON p.id_cat_prod = c.id_cat_prod;";

            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    String nombreProducto = rs.getString("nombre_producto");
                    String nombreIngrediente = rs.getString("nombre_ingrediente");
                    String nombreCategoria = rs.getString("nombre_categoria");
                    model.addRow(new Object[]{nombreProducto, nombreIngrediente, nombreCategoria});
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejo de excepciones
        }

        return model;
    }

    public DefaultTableModel getProductosAsociados() {
        try {
            return obtenerProductosAsociados();
        } catch (Exception e) {
            e.printStackTrace();
            return new DefaultTableModel();
        }
    }

}
