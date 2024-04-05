package proyecto;
import Controlador.Controlador;
import Modelo.Reg_Cliente;
import Vista.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Proyecto {

    public static void main(String[] args) {
        Reg_Cliente cliente = new Reg_Cliente();
        Vista vs = new Vista();
        Log_in log = new Log_in();
        Ventanas vn = new Ventanas();
        
        Controlador ct = new Controlador(vs, log, vn);
        log.setResizable(false); 
        //log.setVisible(true);
        log.setVisible(true);
    }
}