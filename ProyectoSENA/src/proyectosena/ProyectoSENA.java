package proyectosena;
import Vista.*;
import Controlador.*;
import java.sql.SQLException;

public class ProyectoSENA {

    public static void main(String[] args) throws SQLException {
        Vista vs = new Vista();
        Login log = new Login();
        
        Controlador ct = new Controlador(vs);
        
        ct.l.setVisible(true);
    }
    
}
