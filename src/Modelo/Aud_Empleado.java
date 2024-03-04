package Modelo;

import java.sql.Time;
import java.util.Date;
import java.time.*;

/**
 *
 * @author Laderson Leon
 */
public abstract class Aud_Empleado extends Reg_Empleados {

    private int id_aud_emple, us;
    private Date fecha;
    private Date hora;

    public Aud_Empleado() {
    }

    public Aud_Empleado(int id_aud_emple, int us, Date fecha, Date hora,
            int id_emple, int rol, String nom_emple, String ape_emple,
            String ced_emple, String tel_emple, String usuario, String clave,
            int id_cab, int id_cli, int id_mesero, int fact_detalle_id_det_fact,
            float descuento, float iva, float total, String num_fact, String id_tipoP,
            String id_cajero, Time hora_fact, java.sql.Date fecha_fact) {
        super(id_emple, rol, nom_emple, ape_emple, ced_emple, tel_emple,
                usuario, clave, id_cab, id_cli, id_mesero, fact_detalle_id_det_fact,
                descuento, iva, total, num_fact, id_tipoP, id_cajero, hora_fact, fecha_fact);
        this.id_aud_emple = id_aud_emple;
        this.us = us;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId_aud_emple() {
        return id_aud_emple;
    }

    public void setId_aud_emple(int id_aud_emple) {
        this.id_aud_emple = id_aud_emple;
    }

    public int getUs() {
        return us;
    }

    public void setUs(int us) {
        this.us = us;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

}
