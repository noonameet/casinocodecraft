package Model;

public class Categoria {
  
    private int id_cat_prod;
    private String cat_prod_nom;


    public Categoria(int id_cat_prod, String cat_prod_nom) {
        this.id_cat_prod = id_cat_prod;
        this.cat_prod_nom = cat_prod_nom;
    }


    public int getId_cat_prod() {
        return id_cat_prod;
    }

    public void setId_cat_prod(int id_cat_prod) {
        this.id_cat_prod = id_cat_prod;
    }

    public String getCat_prod_nom() {
        return cat_prod_nom;
    }

    public void setCat_prod_nom(String cat_prod_nom) {
        this.cat_prod_nom = cat_prod_nom;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "id_cat_prod=" + id_cat_prod +
                ", cat_prod_nom='" + cat_prod_nom + '\'' +
                '}';
    }
}
