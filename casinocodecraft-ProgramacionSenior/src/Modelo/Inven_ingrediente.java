package Modelo;

import java.util.Date;

public class Inven_ingrediente {
    private int id;
    private String nombre;
    private int cantidad;
    private Date fecha;

    public Inven_ingrediente(int id, String nombre, int cantidad, Date fecha) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
