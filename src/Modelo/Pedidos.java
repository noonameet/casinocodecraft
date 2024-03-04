package Modelo;

import java.time.*;
import java.util.Date;

/**
 *
 * @author Laderson Leon
 */
public abstract class Pedidos extends Reg_Empleados{

    private int id, num_mesa, mesero;
    private String producto, cantidad, estado;
    private Date fecha;

    public Pedidos() {
    }

    public Pedidos(int id, int num_mesa, int mesero, String producto, String cantidad, String estado, Date fecha) {
        this.id = id;
        this.num_mesa = num_mesa;
        this.mesero = mesero;
        this.producto = producto;
        this.cantidad = cantidad;
        this.estado = estado;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum_mesa() {
        return num_mesa;
    }

    public void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
    }

    public int getMesero() {
        return mesero;
    }

    public void setMesero(int mesero) {
        this.mesero = mesero;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
