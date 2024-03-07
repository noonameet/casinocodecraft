/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Administrador
 */
public class Emple_rol extends Reg_Empleados {

    private int id_rol;
    private String nom_rol;

    public Emple_rol() {
    }

    public Emple_rol(int id_rol, String nom_rol, int id_emple, int rol,
            String nom_emple, String ape_emple, String ced_emple, String tel_emple, String usuario, String clave, int id_cab,
            int id_cli, int id_mesero, int fact_detalle_id_det_fact,
            float descuento, float iva, float total, String num_fact,
            String id_tipoP, String id_cajero, Time hora_fact, Date fecha_fact) {
        super(id_emple, rol, nom_emple, ape_emple, ced_emple, tel_emple,
                usuario, clave, id_cab, id_cli, id_mesero, fact_detalle_id_det_fact,
                descuento, iva, total, num_fact, id_tipoP, id_cajero, hora_fact, fecha_fact);
        this.id_rol = id_rol;
        this.nom_rol = nom_rol;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getNom_rol() {
        return nom_rol;
    }

    public void setNom_rol(String nom_rol) {
        this.nom_rol = nom_rol;
    }
}
