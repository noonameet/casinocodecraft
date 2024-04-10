package Modelo;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InventarioDAO {

    private Conexion con = new Conexion();

    public InventarioDAO() {
    }

    public ArrayList<Inventario> buscarProductos(String inicio, String fin, String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return buscarPorFecha(inicio, fin);
        } else {
            return buscarPorFechaYNombre(inicio, fin, nombre);
        }
    }

    private ArrayList<Inventario> buscarPorFechaYNombre(String inicio, String fin, String nombre) {
        ArrayList<Inventario> productos = new ArrayList<>();
        String sql = "SELECT * FROM iv_prod_ent WHERE date(fecha) BETWEEN ? AND ? AND nombre LIKE ?";
        try (Connection conn = con.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, inicio);
            pst.setString(2, fin);
            pst.setString(3, "%" + nombre + "%");

            try (ResultSet rs = pst.executeQuery()) {
                productos = procesarResultSet(rs);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return productos;
    }

    private ArrayList<Inventario> buscarPorFecha(String inicio, String fin) {
        ArrayList<Inventario> productos = new ArrayList<>();
        String sql = "SELECT * FROM iv_prod_ent WHERE date(fecha) BETWEEN ? AND ?";
        try (Connection conn = con.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql)) {

            pst.setString(1, inicio);
            pst.setString(2, fin);

            try (ResultSet rs = pst.executeQuery()) {
                productos = procesarResultSet(rs);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return productos;
    }

    public ArrayList<Inventario> obtenerTodosLosProductos() {
        ArrayList<Inventario> productos = new ArrayList<>();
        String sql = "SELECT * FROM iv_prod_ent";
        try (Connection conn = con.getConnection();
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery()) {

            productos = procesarResultSet(rs);
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return productos;
    }

    private ArrayList<Inventario> procesarResultSet(ResultSet rs) throws SQLException, ParseException {
        ArrayList<Inventario> productos = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        while (rs.next()) {
            String fechaString = rs.getString("fecha");
            Date fecha = format.parse(fechaString);
            Inventario producto = new Inventario(rs.getInt("id_prod_ent"), rs.getString("nombre"), rs.getInt("cantent"), fecha);
            productos.add(producto);
        }
        return productos;
    }
}
