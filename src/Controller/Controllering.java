package Controller;

import Conexion.ConexionBD;
import Model.Categoria;
import Model.Producto;
import View.ingredientes;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class Controllering {

    private ingredientes view;
    private List<Producto> productos;

    public Controllering(ingredientes view) {
        this.view = view;
        cargarCategorias();
        view.cbxcategorias.addActionListener(e -> cargarProductosPorCategoria());
        productos = new ArrayList<>(); // Inicializar la lista de productos
    }

    private void cargarCategorias() {
        try (Connection connection = ConexionBD.getConnection()) {
            String query = "SELECT id_cat_prod, cat_prod_nom FROM prod_categoria";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            view.cbxcategorias.addItem("Seleccionar");

            while (resultSet.next()) {
                int id = resultSet.getInt("id_cat_prod");
                String nombre = resultSet.getString("cat_prod_nom");
                Categoria categoria = new Categoria(id, nombre);
                view.cbxcategorias.addItem(categoria.getCat_prod_nom());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarProductosPorCategoria() {
        Object selectedItem = view.cbxcategorias.getSelectedItem();

        if (!(selectedItem instanceof Categoria)) {
        } else {
            Categoria categoriaSeleccionada = (Categoria) selectedItem;
            view.cbxproductos.removeAllItems(); // Limpiar los elementos existentes

            try (Connection connection = ConexionBD.getConnection()) {
                String query = "SELECT * FROM productos WHERE id_cat_pro = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, categoriaSeleccionada.getId_cat_prod());
                ResultSet resultSet = statement.executeQuery();

                productos.clear();

                while (resultSet.next()) {
                    int id = resultSet.getInt("id_producto");
                    String nombre = resultSet.getString("nombre");
                    double precio = resultSet.getDouble("precio");
                    Producto producto = new Producto(id, nombre, precio, categoriaSeleccionada);
                    productos.add(producto);
                    view.cbxproductos.addItem(nombre); 
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
