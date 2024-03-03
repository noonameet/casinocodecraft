package View;

import Controller.Controllerprod;
import Model.ProductoDAO;

public class Main {
    public static void main(String[] args) {
        ProductoDAO modelo = new ProductoDAO();

        frm_productos vista = new frm_productos();

        // Creas una instancia del controlador, pasándole el modelo y la vista
        Controllerprod controlador = new Controllerprod(modelo, vista);

        vista.setVisible(true);
    }
}

