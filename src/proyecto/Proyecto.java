package proyecto;
import Controlador.Controlador;
import Modelo.Reg_Cliente;
import Vista.Vista;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Proyecto {

    public static void main(String[] args) {
        Reg_Cliente cliente = new Reg_Cliente();
        Vista vs = new Vista();
        
        Controlador ct = new Controlador(vs);
        vs.setResizable(false); 
        vs.setVisible(true);
    }
}