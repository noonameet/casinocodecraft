package Modelo;

import java.sql.Date;
import java.sql.Time;
/**
 *
 * @author Laderson Leon
 */
public class Reg_Empleados {

    private int rol;
    private String nom_emple, ape_emple, ced_emple, tel_emple, usuario, clave;

    public Reg_Empleados() {
    }

    public Reg_Empleados(String nom_emple, String ape_emple, String ced_emple, String tel_emple, String usuario, String clave, int rol) {
        this.rol = rol;
        this.nom_emple = nom_emple;
        this.ape_emple = ape_emple;
        this.ced_emple = ced_emple;
        this.tel_emple = tel_emple;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getApe_emple() {
        return ape_emple;
    }

    public void setApe_emple(String ape_emple) {
        this.ape_emple = ape_emple;
    }

    /*public int getId_emple() {
        return id_emple;
    }*/

    /*public void setId_emple(int id_emple) {
        this.id_emple = id_emple;
    }*/

    public int getRol() {
        return rol;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public String getNom_emple() {
        return nom_emple;
    }

    public void setNom_emple(String nom_emple) {
        this.nom_emple = nom_emple;
    }

    public String getCed_emple() {
        return ced_emple;
    }

    public void setCed_emple(String ced_emple) {
        this.ced_emple = ced_emple;
    }

    public String getTel_emple() {
        return tel_emple;
    }

    public void setTel_emple(String tel_emple) {
        this.tel_emple = tel_emple;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

}
