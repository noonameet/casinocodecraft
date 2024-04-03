package Modelo;

public class Ingredientes {

    private int id;
    private String nombre;

    public Ingredientes() {
    }

    
    public Ingredientes(String nombre) {
        this.nombre = nombre;
    }

    public Ingredientes(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "nombre=" + nombre;
    }
    
    
}
