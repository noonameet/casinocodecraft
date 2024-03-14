package proyecto;
import Controlador.Controlador;
import Modelo.Reg_Cliente;
import Vista.Vista;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Laderson Leon
 */
public class Proyecto {

    public static void main(String[] args) {
        // TODO code application logic here
        Reg_Cliente cliente = new Reg_Cliente();
        Vista vs = new Vista();
        Controlador ct = new Controlador(vs);
        
        ct.mostrarCategorias();
        ct.mostrarRoles();
        vs.setVisible(true);
    }
}
