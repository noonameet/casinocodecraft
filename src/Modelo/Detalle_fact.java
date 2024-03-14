package Modelo;
/**
 *
 * @author Laderson Leon
 */
public class Detalle_fact {
    private int id_det_fact, num_fact, cantidad;
    private String producto;
    private Double precio, total;

    public Detalle_fact() {
    }

    public Detalle_fact(int num_fact, int cantidad, String producto, Double precio, Double total) {
        this.num_fact = num_fact;
        this.cantidad = cantidad;
        this.producto = producto;
        this.precio = precio;
        this.total = total;
    }

    public int getId_det_fact() {
        return id_det_fact;
    }

    public void setId_det_fact(int id_det_fact) {
        this.id_det_fact = id_det_fact;
    }

    public int getNum_fact() {
        return num_fact;
    }

    public void setNum_fact(int num_fact) {
        this.num_fact = num_fact;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
    
    
}
