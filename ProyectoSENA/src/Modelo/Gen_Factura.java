package Modelo;

public class Gen_Factura {

    private int id_cabe;
    private int id_cliente;
    private int mesero;
    private String tipoP;
    private int idCaj;
    private double descuento;
    private double IVA;
    private double total;
    private int num_fac;
    private String horaFormateada;
    private String fecha;

    public Gen_Factura(int id_cabe, int id_cliente, int mesero, String tipoP, int idCaj, double descuento, double IVA, double total, int num_fac, String horaFormateada, String fecha) {
        this.id_cabe = id_cabe;
        this.id_cliente = id_cliente;
        this.mesero = mesero;
        this.tipoP = tipoP;
        this.idCaj = idCaj;
        this.descuento = descuento;
        this.IVA = IVA;
        this.total = total;
        this.num_fac = num_fac;
        this.horaFormateada = horaFormateada;
        this.fecha = fecha;
    }

    public Gen_Factura() {
    }

    public int getId_cabe() {
        return id_cabe;
    }

    public void setId_cabe(int id_cabe) {
        this.id_cabe = id_cabe;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getMesero() {
        return mesero;
    }

    public void setMesero(int mesero) {
        this.mesero = mesero;
    }

    public String getTipoP() {
        return tipoP;
    }

    public void setTipoP(String tipoP) {
        this.tipoP = tipoP;
    }

    public int getIdCaj() {
        return idCaj;
    }

    public void setIdCaj(int idCaj) {
        this.idCaj = idCaj;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getNum_fac() {
        return num_fac;
    }

    public void setNum_fac(int num_fac) {
        this.num_fac = num_fac;
    }

    public String getHoraFormateada() {
        return horaFormateada;
    }

    public void setHoraFormateada(String horaFormateada) {
        this.horaFormateada = horaFormateada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Gen_Factura{" + "id_cabe=" + id_cabe + ", id_cliente=" + id_cliente + ", mesero=" + mesero + ", tipoP=" + tipoP + ", idCaj=" + idCaj + ", descuento=" + descuento + ", IVA=" + IVA + ", total=" + total + ", num_fac=" + num_fac + ", horaFormateada=" + horaFormateada + ", fecha=" + fecha + '}';
    }
    
    

    
}
