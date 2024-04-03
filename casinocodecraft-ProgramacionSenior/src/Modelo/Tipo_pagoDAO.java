/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrador
 */
public class Tipo_pagoDAO {
    Conexion con = new Conexion();
    
    private ArrayList<Tipo_pago> obtenerTiposP() {
        ArrayList<Tipo_pago> listaTP = new ArrayList<>();

        String sql = "SELECT id_tipoP, nombre FROM tipo_pago";

        try (Connection conex = con.getConnection();
             PreparedStatement ps = conex.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while(rs.next()){
                Tipo_pago tp = new Tipo_pago();
                tp.setId_tipoP((rs.getInt("id_tipoP")));
                tp.setNom_tipoP((rs.getString("nombre")));
                listaTP.add(tp);
            }
            System.out.println("Tipos de pagos listados");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaTP;
    }
    
    public ArrayList<Tipo_pago> obtenerTiposPP() {
        return obtenerTiposP();
    }
}
