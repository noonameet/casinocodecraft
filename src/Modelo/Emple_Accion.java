package Modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Emple_Accion {

    private int id_aud_accion;
    private String nombre;

    public Emple_Accion() {
    }

    public Emple_Accion(int id_aud_accion, String nombre) {
        this.id_aud_accion = id_aud_accion;
        this.nombre = nombre;
    }
    
    

    public int getId_aud_accion() {
        return id_aud_accion;
    }

    public void setId_aud_accion(int id_aud_accion) {
        this.id_aud_accion = id_aud_accion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
