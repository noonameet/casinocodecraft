package Modelo;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author Laderson Leon
 */
public class Aud_Cierre_Caja extends Reg_Empleados {

    private int id_cierre_caja, user;
    private float saldo_inicio, entrada, caja, valor_actual;
    private Date hora_cierre, fecha_cierre;

    public Aud_Cierre_Caja() {
    }

    public Aud_Cierre_Caja(int id_cierre_caja, int user, float saldo_inicio,
            float entrada, float caja, float valor_actual, Date hora_cierre,
            Date fecha_cierre, int id_emple, int rol, String nom_emple, String ape_emple,
            String ced_emple, String tel_emple, String usuario, String clave,
            int id_cab, int id_cli, int id_mesero, int fact_detalle_id_det_fact,
            float descuento, float iva, float total, String num_fact, String id_tipoP,
            String id_cajero, Time hora_fact, java.sql.Date fecha_fact) {
        super(id_emple, rol, nom_emple, ced_emple, tel_emple,
                usuario, clave, id_cab, id_cli, id_mesero, fact_detalle_id_det_fact,
                descuento, iva, total, num_fact, id_tipoP, id_cajero, hora_fact, fecha_fact);
        this.id_cierre_caja = id_cierre_caja;
        this.user = user;
        this.saldo_inicio = saldo_inicio;
        this.entrada = entrada;
        this.caja = caja;
        this.valor_actual = valor_actual;
        this.hora_cierre = hora_cierre;
        this.fecha_cierre = fecha_cierre;
    }

    public int getId_cierre_caja() {
        return id_cierre_caja;
    }

    public void setId_cierre_caja(int id_cierre_caja) {
        this.id_cierre_caja = id_cierre_caja;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public float getSaldo_inicio() {
        return saldo_inicio;
    }

    public void setSaldo_inicio(float saldo_inicio) {
        this.saldo_inicio = saldo_inicio;
    }

    public float getEntrada() {
        return entrada;
    }

    public void setEntrada(float entrada) {
        this.entrada = entrada;
    }

    public float getCaja() {
        return caja;
    }

    public void setCaja(float caja) {
        this.caja = caja;
    }

    public float getValor_actual() {
        return valor_actual;
    }

    public void setValor_actual(float valor_actual) {
        this.valor_actual = valor_actual;
    }

    public Date getHora_cierre() {
        return hora_cierre;
    }

    public void setHora_cierre(Date hora_cierre) {
        this.hora_cierre = hora_cierre;
    }

    public Date getFecha_cierre() {
        return fecha_cierre;
    }

    public void setFecha_cierre(Date fecha_cierre) {
        this.fecha_cierre = fecha_cierre;
    }

}
