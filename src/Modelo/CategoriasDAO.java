package Modelo;

import java.sql.*;
import java.util.ArrayList;

public class CategoriasDAO {

    Conexion con = new Conexion();

    public ArrayList<Categorias> ObtenerCategorias() {
        ArrayList<Categorias> listacat = new ArrayList<>();

        String sql = "SELECT id_cat_prod, cat_prod_nom FROM prod_categoria";

        try (Connection cn = con.getConnection();
             PreparedStatement pst = cn.prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {

            while(rs.next()){
                Categorias cat = new Categorias();
                cat.setId(rs.getInt("id_cat_prod"));
                cat.setNombre(rs.getString("cat_prod_nom"));
                listacat.add(cat);
                System.out.println("Categoria encontrada");
            }

            System.out.println("Categoria listada");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listacat;
    }
}

