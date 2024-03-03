package Model;

import Conexion.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class CategoriasDAO {

    ConexionBD con = new ConexionBD();

    public ArrayList<Categorias> ObtenerCategorias() {
        ArrayList<Categorias> listacat = new ArrayList<>();

        String consulta = "select * from prod_categoria";

        try (Connection cn = con.getConnection();
             PreparedStatement pst = cn.prepareStatement(consulta);
             ResultSet rs = pst.executeQuery()) {

            while(rs.next()){
                Categorias cat = new Categorias();
                cat.setId(rs.getInt("id_cat_pord"));
                cat.setNombre(rs.getString("cat_prod_nom"));
                listacat.add(cat);
                System.out.println("Categoria encontrada");
            }

            System.out.println("Categoria listada");
        } catch (Exception e) {
            System.out.println("Error de busqueda" + e);
        }

        return listacat;
    }
}

