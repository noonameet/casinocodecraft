package Modelo;

import java.sql.Time;
import java.sql.Date;

/**
 *
 * @author Laderson Leon
 */
public class Gen_Factura {

    private int id_cab, id_cli, id_mesero, id_cajero, num_fact;
    private double descuento, iva, total;
    private String id_tipoP, hora_fact, fecha_fact;

    public Gen_Factura() {
    }

    public Gen_Factura(int id_cli, int id_mesero, String id_tipoP, int id_cajero, double descuento, double iva, double total, int num_fact, String hora_fact, String fecha_fact) {
        this.id_cli = id_cli;
        this.id_mesero = id_mesero;
        this.id_tipoP = id_tipoP;
        this.id_cajero = id_cajero;
        this.descuento = descuento;
        this.iva = iva;
        this.total = total;
        this.num_fact = num_fact;
        this.hora_fact = hora_fact;
        this.fecha_fact = fecha_fact;
    }

    public int getId_cab() {
        return id_cab;
    }

    public void setId_cab(int id_cab) {
        this.id_cab = id_cab;
    }

    public int getId_cli() {
        return id_cli;
    }

    public void setId_cli(int id_cli) {
        this.id_cli = id_cli;
    }

    public int getId_mesero() {
        return id_mesero;
    }

    public void setId_mesero(int id_mesero) {
        this.id_mesero = id_mesero;
    }

    public String getId_tipoP() {
        return id_tipoP;
    }

    public void setId_tipoP(String id_tipoP) {
        this.id_tipoP = id_tipoP;
    }

    public int getId_cajero() {
        return id_cajero;
    }

    public void setId_cajero(int id_cajero) {
        this.id_cajero = id_cajero;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getNum_fact() {
        return num_fact;
    }

    public void setNum_fact(int num_fact) {
        this.num_fact = num_fact;
    }

    public String getHora_fact() {
        return hora_fact;
    }

    public void setHora_fact(String hora_fact) {
        this.hora_fact = hora_fact;
    }

    public String getFecha_fact() {
        return fecha_fact;
    }

    public void setFecha_fact(String fecha_fact) {
        this.fecha_fact = fecha_fact;
    }
}
    