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
    Connection conex = con.getConnection();
    
    private void generarFactura(Gen_Factura factura) {
        try {
            // Tu lógica para insertar el cliente en la base de datos
            String sql = "INSERT INTO fact_cabe(id_clie, id_tipo_pago, id_mesero, id_cajero, num_fact, descuento, iva, total, hora_fact, fecha_fact) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement st = conex.prepareStatement(sql)) {
                st.setInt(1, factura.getId_cli());
                st.setInt(2, factura.getId_tipoP());
                st.setInt(3, factura.getId_mesero());
                st.setInt(4, factura.getId_cajero());
                st.setString(5, factura.getNum_fact());
                st.setDouble(6, factura.getDescuento());
                st.setDouble(7, factura.getIva());
                st.setDouble(8, factura.getTotal());
                st.setTime(9, factura.getHora_fact());
                st.setDate(10, factura.getFecha_fact());
                st.executeUpdate();
                System.out.println("Registrado!");
            }
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
