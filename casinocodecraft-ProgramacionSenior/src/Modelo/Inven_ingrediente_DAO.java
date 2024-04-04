package Modelo;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Inven_ingrediente_DAO {

    private Connection conn = null;
    private PreparedStatement pst = null;
    private ResultSet rs = null;

    public Inven_ingrediente_DAO() {
        Conexion conexion = new Conexion();
        conn = conexion.getConnection();
    }

    public ArrayList<Inven_ingrediente> buscarProductos(String inicio, String fin, String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return buscarPorFecha(inicio, fin);
        } else {
            return buscarPorFechaYNombre(inicio, fin, nombre);
        }
    }

    public ArrayList<Inven_ingrediente> buscarPorFechaYNombre(String inicio, String fin, String nombre) {
        ArrayList<Inven_ingrediente> productos = new ArrayList<>();
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
                Inven_ingrediente producto = new Inven_ingrediente(rs.getInt("id_prod_ent"), rs.getString("nombre"), rs.getInt("cantent"), fecha);
                productos.add(producto);
            }
        } catch (SQLException | ParseException e) {
        }
        return productos;
    }

    private ArrayList<Inven_ingrediente> buscarPorFecha(String inicio, String fin) {
        ArrayList<Inven_ingrediente> productos = new ArrayList<>();
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
                Inven_ingrediente producto = new Inven_ingrediente(rs.getInt("id_prod_ent"), rs.getString("nombre"), rs.getInt("cantent"), fecha);
                productos.add(producto);
            }
        } catch (SQLException | ParseException e) {
            // Manejar excepciones
        }
        return productos;
    }

    public ArrayList<Inven_ingrediente> obtenerTodosLosProductos() {
        ArrayList<Inven_ingrediente> productos = new ArrayList<>();
        String sql = "SELECT * FROM iv_prod_ent";
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String fechaString = rs.getString("fecha");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha = format.parse(fechaString);
                Inven_ingrediente producto = new Inven_ingrediente(rs.getInt("id_prod_ent"), rs.getString("nombre"), rs.getInt("cantent"), fecha);
                productos.add(producto);
            }
        } catch (SQLException | ParseException e) {
        }
        return productos;
    }

}
