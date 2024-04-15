package Modelo;

/**
 *
 * @author Administrador
 */
public class Tipo_pago {
    private int id_tipoP;
    private String nom_tipoP;

    public Tipo_pago() {
    }

    public Tipo_pago(int id_tipoP, String nom_tipoP) {
        this.id_tipoP = id_tipoP;
        this.nom_tipoP = nom_tipoP;
    }

    public int getId_tipoP() {
        return id_tipoP;
    }

    public void setId_tipoP(int id_tipoP) {
        this.id_tipoP = id_tipoP;
    }

    public String getNom_tipoP() {
        return nom_tipoP;
    }

    public void setNom_tipoP(String nom_tipoP) {
        this.nom_tipoP = nom_tipoP;
    }
    
    @Override
    public String toString(){
        return nom_tipoP;
    }
}
