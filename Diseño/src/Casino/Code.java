/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Casino;

import Vista.*;
import Controlador.*;

/**
 *
 * @author Jairo
 */
public class Code {
    public static void main(String[] args) {
        Log_in log = new Log_in();
        Experiment V = new Experiment();
        Controlador C = new Controlador(log,V);
        log.setVisible(true);
    }
}
