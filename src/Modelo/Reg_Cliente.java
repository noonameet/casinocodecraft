package Modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Time;

/**
 *
 * @author Laderson Leon
 */
public class Reg_Cliente extends Gen_Factura{

    private int id_clie;
    private String nom_cli, ape_cli, ced_cli, direccion, telef;

    public Reg_Cliente() {
    }

    public Reg_Cliente(int id_cli, String nom_cli, String ape_cli, String ced_cli, 
            String direccion, String telef, int id_cab, int id_clie, int id_mesero, 
            int fact_detalle_id_det_fact, float descuento, float iva, float total, 
            String num_fact, String id_tipoP, String id_cajero, Time hora_fact, Date fecha_fact) {
        super(id_cab, id_cli, id_mesero, fact_detalle_id_det_fact, descuento, iva, 
                total, num_fact, id_tipoP, id_cajero, hora_fact, fecha_fact);
        this.id_clie = id_clie;
        this.nom_cli = nom_cli;
        this.ape_cli = ape_cli;
        this.ced_cli = ced_cli;
        this.direccion = direccion;
        this.telef = telef;
    }

    

    public int getId_clie() {
        return id_clie;
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

    public void setId_clie(int id_clie) {
        this.id_clie = id_clie;
    }

    public void setNom_cli(String nom_cli) {
        this.nom_cli = nom_cli;
    }

    public void setApe_cli(String ape_cli) {
        this.ape_cli = ape_cli;
    }

    public void setCed_cli(String ced_cli) {
        this.ced_cli = ced_cli;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelef(String telef) {
        this.telef = telef;
    }
}
