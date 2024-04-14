package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarritoDAO {
    Conexion con = new Conexion();
    
    private int registrarCarrito(Carrito car){
        String sql = "INSERT INTO carritoProductos(id_pedido, producto, cantidad, total) VALUES (?, ?, ?, ?)";
        try(Connection conex = con.getConnection(); PreparedStatement ps = conex.prepareStatement(sql)){
            ps.setInt(1, car.getId_pedido());
            ps.setString(2, car.getProd());
            ps.setInt(3, car.getCantidad());
            ps.setInt(4, car.getTotal());
            ps.executeUpdate();
            System.out.println(ps);
            return 1;
        }catch(SQLException e){
            e.printStackTrace();
            return 0;
        }
    }
    
    public int registrarCarritoP(Carrito car){
        return registrarCarrito(car);
    }
    
}
