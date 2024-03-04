package Modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Administrador
 */
public class Emple_Accion extends Aud_Empleado {

    private int id_aud_accion;
    private String nombre;

    public Emple_Accion() {
    }

    public Emple_Accion(int id_aud_accion, String nombre,
            int id_aud_emple, int us, Date fecha, Date hora,
            int id_emple, int rol, String nom_emple, String ape_emple,
            String ced_emple, String tel_emple, String usuario, String clave,
            int id_cab, int id_cli, int id_mesero, int fact_detalle_id_det_fact,
            float descuento, float iva, float total, String num_fact, String id_tipoP,
            String id_cajero, Time hora_fact, java.sql.Date fecha_fact) {
        super(id_aud_emple, us, fecha, hora, id_emple, rol, nom_emple, ape_emple,
                ced_emple, tel_emple, usuario, clave, id_cab, id_cli, id_mesero,
                fact_detalle_id_det_fact, descuento, iva, total, num_fact, id_tipoP,
                id_cajero, hora_fact, fecha_fact);
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
