package Modelo;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ProductoDAO {

    Conexion con = new Conexion();

    private DefaultTableModel obtenerProductosAsociados() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre Producto");
        model.addColumn("Nombre Ingrediente");
        model.addColumn("Nombre Categoria");

        try (Connection conn = con.getConnection()) {
            String sql = "SELECT p.nombre AS nombre_producto, i.nombre AS nombre_ingrediente, "
                    + "c.cat_prod_nom AS nombre_categoria "
                    + "FROM productos p "
                    + "JOIN Producto_Ingrediente pi ON p.id_producto = pi.id_producto "
                    + "JOIN iv_prod_ent i ON pi.id_ingrediente = i.id_prod_ent "
                    + "JOIN prod_categoria c ON p.id_cat_prod = c.id_cat_prod";

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

    private ArrayList<Producto> obtenerTodosLosProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        String query = "SELECT id_producto, nombre FROM productos";
        try (Connection conex = con.getConnection(); PreparedStatement ps = conex.prepareStatement(query); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int id_producto = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                Producto producto = new Producto(id_producto, nombre);
                productos.add(producto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public ArrayList<Producto> getTodosLosProductos() {
        try {
            return obtenerTodosLosProductos();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private void Registrar(Producto pro) {
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

    public boolean registrarProducto(Producto pro) {
        try {
            Registrar(pro);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private ArrayList<Producto> obtenerProductosPorCategoria(String categoriaNombre) {
        ArrayList<Producto> productos = new ArrayList<>();
        try {
            Connection con = this.con.getConnection();
            String query = "SELECT * FROM productos WHERE id_cat_prod = "
                    + "(SELECT id_cat_prod FROM prod_categoria WHERE cat_prod_nom = ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, categoriaNombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_producto = rs.getInt("id_producto");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                int cantidad = rs.getInt("cantidad");
                int id_cat_prod = rs.getInt("id_cat_prod");

                Categorias categoria = new Categorias(id_cat_prod, categoriaNombre);
                Producto producto = new Producto(id_producto, nombre, precio, cantidad, categoria);
                productos.add(producto);
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productos;
    }

    public ArrayList<Producto> getProductosPorCategoria(String categoriaNombre) {
        try {
            return obtenerProductosPorCategoria(categoriaNombre);
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private DefaultTableModel obtenerProductos() {
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
                    String Producto = rs.getString("Producto");
                    String Categoria = rs.getString("Categoria");
                    String Precio = rs.getString("Precio");
                    model.addRow(new Object[]{Producto, Categoria, Precio});
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Manejo de excepciones
        }

        return model;
    }

    public DefaultTableModel getProductos() {
        try {
            return obtenerProductos();
        } catch (Exception e) {
            e.printStackTrace();
            return new DefaultTableModel();
        }
    }
}
