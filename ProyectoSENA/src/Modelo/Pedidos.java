package Modelo;

import java.time.*;
import java.sql.Time;

/**
 *
 * @author Laderson Leon
 */
public class Pedidos{

    private int id, num_mesa, mesero;
    private String estado;
    private String hora;

    public Pedidos() {
    }

    public Pedidos(int id, int num_mesa, int mesero, String estado, String hora) {
        this.num_mesa = num_mesa;
        this.mesero = mesero;
        this.estado = estado;
        this.hora = hora;
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

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    

}
