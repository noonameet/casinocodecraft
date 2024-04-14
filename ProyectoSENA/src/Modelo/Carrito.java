package Modelo;

public class Carrito {
    int id_carrito, id_pedido, cantidad, total;
    String prod;
    
    public Carrito(){
        
    }

    public Carrito(int id_pedido, String prod, int cantidad, int total) {
        this.id_pedido = id_pedido;
        this.cantidad = cantidad;
        this.total = total;
        this.prod = prod;
    }

    public int getId_carrito() {
        return id_carrito;
    }

    public void setId_carrito(int id_carrito) {
        this.id_carrito = id_carrito;
    }

    public int getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getProd() {
        return prod;
    }

    public void setProd(String prod) {
        this.prod = prod;
    }
    
    
}
