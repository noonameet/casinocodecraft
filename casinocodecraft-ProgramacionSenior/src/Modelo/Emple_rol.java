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
public class Emple_rol{

    private int id_rol;
    private String nom_rol;

    public Emple_rol() {
    }

    public Emple_rol(int id_rol, String nom_rol) {
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
