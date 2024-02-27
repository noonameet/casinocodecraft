package Codigo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Laderson Leon
 */
public class Reg_ClienteDAO {
    private static final String URL = "jdbc:sqlite:C:\\Users\\Administrador\\test";
    
    private void registrar_cli(Reg_Cliente cliente){
        try (Connection con = DriverManager.getConnection(URL)) {
            // Tu lógica para insertar el cliente en la base de datos
            String sql = "INSERT INTO reg_cli VALUES(?, ?, ?, ?, ?, ?)";
            try (PreparedStatement st = 
                    con.prepareStatement(sql)) {
                st.setInt(1, cliente.getId_cli());
                st.setString(2, cliente.getNom_cli());
                st.setString(3, cliente.getApe_cli());
                st.setString(4, cliente.getCed_cli());
                st.setString(5, cliente.getDireccion());
                st.setString(6, cliente.getTelef());
                int rows = st.executeUpdate();
                if(rows > 0){
                    System.out.println("Cliente registrado en la base de datos: " 
                            + cliente.getNom_cli() + " " + cliente.getApe_cli());
                }else{
                    System.out.println("No se pudo insertar el cliente "
                            + "en la base de datos.");
                }
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    private static void imprimirDatos() {
        String consultaSQL = "SELECT * FROM reg_cli";

        try(Connection con = DriverManager.getConnection(URL);
             PreparedStatement st = 
                     con.prepareStatement(consultaSQL);
            ResultSet resultSet = st.executeQuery()){

            System.out.println("Datos en la base de datos:");

            // Recorrer los resultados y mostrarlos en la consola
            while (resultSet.next()){
                int id = resultSet.getInt("id_cliente");
                String nombre = resultSet.getString("nom_cli");
                String apellido = resultSet.getString("ape_cli");
                String cedula = resultSet.getString("ced");
                String direccion = resultSet.getString("direccion");
                String telefono = resultSet.getString("tel");

                System.out.println("ID: " + id + ", Nombre: " + 
                        nombre + ", Apellido: " + apellido
                        + ", Cédula: " + cedula + ", Dirección: " + 
                        direccion + ", Teléfono: " + telefono);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    
    private boolean verificarCliente(Reg_Cliente cliente){
        String sql = "SELECT * FROM reg_cli WHERE id_cliente = ?";
        
        try(Connection con = DriverManager.getConnection(URL);
                PreparedStatement st = con.prepareStatement(sql)){
            st.setString(1, cliente.getCed_cli());
            
            try(ResultSet rs = st.executeQuery()){
                System.out.println(st.executeQuery());
                System.out.println(rs.next());
                return rs.next();
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
    
    public void registrarCliente(Reg_Cliente cliente){
        if(verificarCliente(cliente)){
            System.out.println("Cliente ya registrado, favor intentar de nuevo!");
        }else{
            registrar_cli(cliente);
        }
    }
}
