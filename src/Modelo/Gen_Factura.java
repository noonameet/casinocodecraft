package Modelo;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author Laderson Leon
 */
public class Gen_Factura {

    private int id_cab, id_cli, id_mesero;
    private float descuento, iva, total;
    private String num_fact, id_tipoP, id_cajero;
    private Time hora_fact;
    private Date fecha_fact;

    public Gen_Factura() {
    }

    public Gen_Factura(int id_cab, int id_cli, int id_mesero, float descuento, float iva, float total, String num_fact, String id_tipoP, String id_cajero, Time hora_fact, Date fecha_fact) {
        this.id_cab = id_cab;
        this.id_cli = id_cli;
        this.id_mesero = id_mesero;
        this.descuento = descuento;
        this.iva = iva;
        this.total = total;
        this.num_fact = num_fact;
        this.id_tipoP = id_tipoP;
        this.id_cajero = id_cajero;
        this.hora_fact = hora_fact;
        this.fecha_fact = fecha_fact;
    }
    
    public int getId_cab() {
        return id_cab;
    }

    private void setId_cab(int id_cab) {
        this.id_cab = id_cab;
    }

    public int getId_cli() {
        return id_cli;
    }

    private void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public int getId_mesero() {
        return id_mesero;
    }

    private void setId_mesero(int id_mesero) {
        this.id_mesero = id_mesero;
    }

    public float getDescuento() {
        return descuento;
    }

    private void setDescuento(float descuento) {
        this.descuento = descuento;
    }

    public float getIva() {
        return iva;
    }

    private void setIva(float iva) {
        this.iva = iva;
    }

    public float getTotal() {
        return total;
    }

    private void setTotal(float total) {
        this.total = total;
    }

    public String getNum_fact() {
        return num_fact;
    }

    private void setNum_fact(String num_fact) {
        this.num_fact = num_fact;
    }

    public String getId_tipoP() {
        return id_tipoP;
    }

    private void setId_tipoP(String id_tipoP) {
        this.id_tipoP = id_tipoP;
    }

    public String getId_cajero() {
        return id_cajero;
    }

    private void setId_cajero(String id_cajero) {
        this.id_cajero = id_cajero;
    }

    public Time getHora_fact() {
        return hora_fact;
    }

    private void setHora_fact(Time hora_fact) {
        this.hora_fact = hora_fact;
    }

    public Date getFecha_fact() {
        return fecha_fact;
    }

    private void setFecha_fact(Date fecha_fact) {
        this.fecha_fact = fecha_fact;
    }
}
