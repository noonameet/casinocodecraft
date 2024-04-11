package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Laderson Leon
 */
public class Gen_FacturaDAO {
    
    Conexion con = new Conexion();
    
    private void generarFactura(Gen_Factura factura) {
        String sql = "INSERT INTO fact_cabe(id_clie, id_tipo_pago, id_mesero, "
                + "id_cajero, num_fact, descuento, iva, total, hora_fact, fecha_fact) "
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(Connection conex = con.getConnection(); PreparedStatement ps = 
                conex.prepareStatement(sql)) {
            ps.setInt(1, factura.getId_cli());
            ps.setInt(2, factura.getId_tipoP());
            ps.setInt(3, factura.getId_mesero());
            ps.setInt(4, factura.getId_cajero());
            ps.setString(5, factura.getNum_fact());
            ps.setDouble(6, factura.getDescuento());
            ps.setDouble(7, factura.getIva());
            ps.setDouble(8, factura.getTotal());
            ps.setTime(9, factura.getHora_fact());
            ps.setDate(10, factura.getFecha_fact());
            ps.executeUpdate();
            System.out.println("Registrado!");
        } catch (SQLException e) {
            e.printStackTrace();
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
