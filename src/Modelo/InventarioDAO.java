package Modelo;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InventarioDAO {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public InventarioDAO() {
        Conexion con = new Conexion();
        Connection conex = con.getConnection();
    }

    public ArrayList<Inventario> buscarProductos(String inicio, String fin, String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return buscarPorFecha(inicio, fin);
        } else {
            return buscarPorFechaYNombre(inicio, fin, nombre);
        }
    }

    public ArrayList<Inventario> buscarPorFechaYNombre(String inicio, String fin, String nombre) {
        ArrayList<Inventario> productos = new ArrayList<>();
        String sql = "SELECT * FROM iv_prod_ent WHERE date(fecha) BETWEEN ? AND ? AND nombre LIKE ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, inicio);
            pst.setString(2, fin);
            pst.setString(3, "%" + nombre + "%");
            rs = pst.executeQuery();
            while (rs.next()) {
                String fechaString = rs.getString("fecha");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = format.parse(fechaString);
                Inventario producto = new Inventario(rs.getInt("id_prod_ent"), rs.getString("nombre"), rs.getInt("cantent"), fecha);
                productos.add(producto);
            }
        } catch (SQLException | ParseException e) {
        }
        return productos;
    }

    private ArrayList<Inventario> buscarPorFecha(String inicio, String fin) {
        ArrayList<Inventario> productos = new ArrayList<>();
        String sql = "SELECT * FROM iv_prod_ent WHERE date(fecha) BETWEEN ? AND ?";
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, inicio);
            pst.setString(2, fin);
            rs = pst.executeQuery();
            while (rs.next()) {
                String fechaString = rs.getString("fecha");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = format.parse(fechaString);
                Inventario producto = new Inventario(rs.getInt("id_prod_ent"), rs.getString("nombre"), rs.getInt("cantent"), fecha);
                productos.add(producto);
            }
        } catch (SQLException | ParseException e) {
            // Manejar excepciones
        }
        return productos;
    }

    public ArrayList<Inventario> obtenerTodosLosProductos() {
        ArrayList<Inventario> productos = new ArrayList<>();
        String sql = "SELECT * FROM iv_prod_ent";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String fechaString = rs.getString("fecha");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = format.parse(fechaString);
                Inventario producto = new Inventario(rs.getInt("id_prod_ent"), rs.getString("nombre"), rs.getInt("cantent"), fecha);
                productos.add(producto);
            }
        } catch (SQLException | ParseException e) {
        }
        return productos;
    }

}
