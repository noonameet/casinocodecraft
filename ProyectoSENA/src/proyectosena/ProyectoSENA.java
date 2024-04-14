package proyectosena;
import Vista.*;
import Controlador.*;

public class ProyectoSENA {

    public static void main(String[] args) {
        Vista vs = new Vista();
        
        Controlador ct = new Controlador(vs);
        
        ct.l.setVisible(true);
    }
}
