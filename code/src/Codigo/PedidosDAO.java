package Codigo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Laderson Leon
 */
public class PedidosDAO {
    Conexion con = new Conexion();
    Connection conex = con.getConnection();
    Pedidos ped = new Pedidos();
    List<> Lista = new ArrayList();
    
    private void RegistrarPedido(){
        String sql = "INSERT INTO pedidos(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, ped.getId());
            ps.setInt(2, ped.getNum_mesa());
            ps.setInt(3, ped.getMesero());
            ps.setString(4, ped.getProducto());
            ps.setString(5, ped.getCantidad());
            ps.setString(6, ped.getEstado());
            //ps.setTime(7, time);
            ps.execute();
        }catch(SQLException e){
            System.out.println(e.toString());
        }finally{
            try{
                conex.close();
            }catch(SQLException e){
                System.out.println(e.toString());
            }
        }
    }
    
    private boolean verificarEstado(int id){
        String sql = "SELECT estado FROM pedidos WHERE id_pedido=?";
        boolean estado = false;
        try{
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                estado = rs.getBoolean("estado");
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
        return estado;
    }
    
    private void eliminarPedido(int id){
        String sql = "DELETE FROM pedidos where id_pedido=?";
        try{
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Pedido eliminado correctamente!");
            }else{
                System.out.println("ERROR!");
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    private void modificarPedido(int id){
        String sql = "UPDATE FROM pedidos where id_pedido=?";
        try{
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("Pedido eliminado correctamente!");
            }else{
                System.out.println("ERROR!");
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
    }
    
    private List verPedidoDetalle(int id){
        String sql = "SELECT * FROM pedidos WHERE id_pedido=?";
        try{
            PreparedStatement ps = conex.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){               
                ps.setInt(1, ped.getId());
                ps.setInt(2, ped.getNum_mesa());
                ps.setInt(3, ped.getMesero());
                ps.setString(4, ped.getProducto());
                ps.setString(5, ped.getCantidad());
                ps.setString(6, ped.getEstado());
                Lista.add(ps);
            }
        }catch(SQLException e){
            System.out.println(e.toString());
        }
       return Lista;
    }
    
    
    
    
   
}
