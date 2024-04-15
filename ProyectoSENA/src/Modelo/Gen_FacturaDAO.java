package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Laderson Leon
 */
public class Gen_FacturaDAO {
    
    Conexion con = new Conexion();
    
    private void generarFactura(Gen_Factura factura) {
        String sql = "INSERT INTO fact_cabe(id_cab_fact, id_clie, id_tipo_pago, id_mesero, "
                + "id_cajero, num_fact, descuento, iva, total, hora_fact, fecha_fact) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conex = con.getConnection(); PreparedStatement ps = 
                conex.prepareStatement(sql)) {
            ps.setInt(1, factura.getId_cabe());
            ps.setInt(2, factura.getId_cliente());
            ps.setString(3, factura.getTipoP());
            ps.setInt(4, factura.getMesero());
            ps.setInt(5, factura.getIdCaj());
            ps.setInt(6, factura.getNum_fac());
            ps.setDouble(7, factura.getDescuento());
            ps.setDouble(8, factura.getIVA());
            ps.setDouble(9, factura.getTotal());
            ps.setString(10, factura.getHoraFormateada());
            ps.setString(11, factura.getFecha());
            ps.executeUpdate();
            System.out.println("Registrado!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    private ArrayList<Gen_Factura> generarFacturaTXT() {
        ArrayList<Gen_Factura> listame = new ArrayList<>();
        
        String sql = "SELECT * FROM fact_cabe";
        
        try(Connection conex = con.getConnection(); PreparedStatement ps = 
                conex.prepareStatement(sql)){
            try(ResultSet rs = ps.executeQuery()){
                Gen_Factura fac = new Gen_Factura();
                fac.setId_cabe(rs.getInt("id_cab_fact"));
                fac.setId_cliente(rs.getInt("id_clie"));
                fac.setTipoP(rs.getString("id_tipo_pago"));
                fac.setMesero(rs.getInt("id_mesero"));
                fac.setIdCaj(rs.getInt("id_cajero"));
                fac.setNum_fac(rs.getInt("num_fact"));
                fac.setDescuento(rs.getDouble("descuento"));
                fac.setIVA(rs.getDouble("iva"));
                fac.setTotal(rs.getDouble("total"));
                fac.setHoraFormateada(rs.getString("hora_fact"));
                fac.setFecha(rs.getString("fecha_fact"));
                listame.add(fac);
                System.out.println(fac.toString());

            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return listame;
    }
    
    public ArrayList<Gen_Factura> getFacturaTXT() {
        try {
            return generarFacturaTXT();
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    public boolean getGenerarFact(Gen_Factura factura){
        try{
            generarFactura(factura);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
