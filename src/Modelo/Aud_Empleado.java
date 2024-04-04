package Modelo;

import java.sql.Time;
import java.util.Date;
import java.time.*;

/**
 *
 * @author Laderson Leon
 */
public class Aud_Empleado{

    private int id_aud_emple, us;
    private Date fecha;
    private Date hora;

    public Aud_Empleado() {
    }

    public Aud_Empleado(int id_aud_emple, int us, Date fecha, Date hora) {
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
