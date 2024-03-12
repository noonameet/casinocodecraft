package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controlador implements ActionListener {
    LoginDao dao = new LoginDao();
    login usu = new login();
    Log_in log = new Log_in();
    Vista_A a = new Vista_A();
    Vista c = new Vista();

    public Controlador(Log_in log) {
        this.log = log;
        this.log.ingresar.addActionListener(this);
    }

    public Controlador(Log_in log, Vista_A a) {
        this.log = log;
        this.a = a;

        this.log.ingresar.addActionListener(this);
    }

    public Controlador(Log_in log, Vista c) {
        this.log = log;
        this.c = c;
        this.log.ingresar.addActionListener(this);

    }

    public void autenticarUsuarios() {

        String usuario = log.Usuario.getText();
        String clave = new String(log.Pass.getPassword());

        if(dao.autenticarUsuarios(usuario,clave)){
            JOptionPane.showMessageDialog(null, "Bienvenidos al sistema");
            log.setVisible(false);
            c.setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(null, "Error, intente de nuevo");
            log.Usuario.requestFocus();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log.ingresar) {
            autenticarUsuarios();
        }
    }
}
