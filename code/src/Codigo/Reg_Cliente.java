package Codigo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
/**
 *
 * @author Laderson Leon
 */
public class Reg_Cliente {
    private int id_cli;
    private String nom_cli, ape_cli, ced_cli, direccion, telef;

    public Reg_Cliente() {
    }

    public Reg_Cliente(int id_cli, String nom_cli, String ape_cli, 
            String ced_cli, String direccion, String telef) {
        this.id_cli = id_cli;
        this.nom_cli = nom_cli;
        this.ape_cli = ape_cli;
        this.ced_cli = ced_cli;
        this.direccion = direccion;
        this.telef = telef;
    }
    
    public int getId_cli() {
        return id_cli;
    }

    public String getNom_cli() {
        return nom_cli;
    }

    public String getApe_cli() {
        return ape_cli;
    }

    public String getCed_cli() {
        return ced_cli;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelef() {
        return telef;
    }

    private void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    private void setNom_cli(String nom_cli) {
        this.nom_cli = nom_cli;
    }

    private void setApe_cli(String ape_cli) {
        this.ape_cli = ape_cli;
    }

    private void setCed_cli(String ced_cli) {
        this.ced_cli = ced_cli;
    }

    private void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    private void setTelef(String telef) {
        this.telef = telef;
    }
}
