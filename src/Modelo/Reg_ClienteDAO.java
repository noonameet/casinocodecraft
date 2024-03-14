package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Laderson Leon
 */
public class Reg_ClienteDAO {

    Conexion con = new Conexion();
    Connection conex = con.getConnection();

    private void registrar_cli(Reg_Cliente cliente) {
        try {
            // Tu lógica para insertar el cliente en la base de datos
            String sql = "INSERT INTO reg_cliente(nom_cliente, ape_cliente, ced_cliente, direccion, telefono) VALUES(?, ?, ?, ?, ?)";
            try (PreparedStatement st = conex.prepareStatement(sql)) {
                st.setString(1, cliente.getNom_cli());
                st.setString(2, cliente.getApe_cli());
                st.setString(3, cliente.getCed_cli());
                st.setString(4, cliente.getDireccion());
                st.setString(5, cliente.getTelef());
                int rows = st.executeUpdate();
                if (rows > 0) {
                    System.out.println("Cliente registrado en la base de datos: "
                            + cliente.getNom_cli() + " y " + cliente.getApe_cli());
                } else {
                    System.out.println("No se pudo insertar el cliente "
                            + "en la base de datos.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void imprimirDatos() {
        try {
            String sql = "SELECT * FROM reg_cliente";
            try (PreparedStatement st = conex.prepareStatement(sql)) {
                ResultSet rs = st.executeQuery();
                System.out.println("Datos en la base de datos:");

                // Recorrer los resultados y mostrarlos en la consola
                while (rs.next()) {
                    int id = rs.getInt("id_cliente");
                    String nombre = rs.getString("nom_cli");
                    String apellido = rs.getString("ape_cli");
                    String cedula = rs.getString("ced");
                    String direccion = rs.getString("direccion");
                    String telefono = rs.getString("tel");

                    System.out.println("ID: " + id + ", Nombre: "
                            + nombre + ", Apellido: " + apellido
                            + ", Cédula: " + cedula + ", Dirección: "
                            + direccion + ", Teléfono: " + telefono);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private boolean verificarCliente(Reg_Cliente cliente) {
        try {
            String sql = "SELECT * FROM reg_cliente WHERE id_cliente = ?";
            PreparedStatement st = conex.prepareStatement(sql);
            st.setString(1, cliente.getCed_cli());
            try (ResultSet rs = st.executeQuery()) {
                System.out.println(st.executeQuery());
                System.out.println(rs.next());
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private int ultimoId() {
        int id = 0;
        try {
            String sql = "SELECT MAX(id_cliente) FROM reg_cliente";
            PreparedStatement st = conex.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public int devolverId() {
        return ultimoId();
    }

    public int registrarCliente(Reg_Cliente cliente) {
        if (verificarCliente(cliente)) {
            System.out.println("Cliente ya registrado, favor intentar de nuevo!");
            return 1;
        } else {
            registrar_cli(cliente);
            return 0;
        }
    }
}
