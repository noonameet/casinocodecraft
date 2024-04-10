package Modelo;

public class Producto {

    protected int id_producto;
    protected String nombre;
    protected int cantidad;
    protected double precio;
    protected Categorias categoria;

    public Producto() {
    }

    public Producto(int id_producto, String nombre) {
        this.id_producto = id_producto;
        this.nombre = nombre;
    }
    

    public Producto(int id_producto, String nombre, double precio, int cantidad, Modelo.Categorias categoria) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias categoria) {
        this.categoria = categoria;
    }

}
