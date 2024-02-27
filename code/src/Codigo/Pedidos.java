package Codigo;
import java.time.*;
/**
 *
 * @author Laderson Leon
 */
public class Pedidos {
    private int id, num_mesa, mesero;
    private String producto, cantidad, estado;
    private LocalTime fecha;
    
    public Pedidos() {
    }

    public Pedidos(int id, int num_mesa, int mesero, String producto, String cantidad, String estado, LocalTime fecha){
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

    private void setId(int id) {
        this.id = id;
    }

    public int getNum_mesa() {
        return num_mesa;
    }

    private void setNum_mesa(int num_mesa) {
        this.num_mesa = num_mesa;
    }

    public int getMesero() {
        return mesero;
    }

    private void setMesero(int mesero) {
        this.mesero = mesero;
    }

    public String getProducto() {
        return producto;
    }

    private void setProducto(String producto) {
        this.producto = producto;
    }

    public String getCantidad() {
        return cantidad;
    }

    private void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    private void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalTime getFecha() {
        return fecha;
    }

    private void setFecha(LocalTime fecha) {
        this.fecha = fecha;
    }

    
}
