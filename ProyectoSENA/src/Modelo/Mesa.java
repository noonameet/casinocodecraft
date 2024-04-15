package Modelo;

import java.util.Date;

/**
 *
 * @author Laderson Leon
 */
public class Mesa{

    private int id_mesa, cant_sillas;
    private String estado, tipo;

    public Mesa() {
    }


    @Override
    public String toString() {
        return tipo + " " +cant_sillas;
    }
    
    public int ID(){
        return id_mesa;
    }
    
    public Mesa(int cant_sillas, String estado, String tipo) {
        this.cant_sillas = cant_sillas;
        this.estado = estado;
        this.tipo = tipo;
    }

    public int getId_mesa() {
        return id_mesa;
    }

    public void setId_mesa(int id_mesa) {
        this.id_mesa = id_mesa;
    }

    public int getCant_sillas() {
        return cant_sillas;
    }

    public void setCant_sillas(int cant_sillas) {
        this.cant_sillas = cant_sillas;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
