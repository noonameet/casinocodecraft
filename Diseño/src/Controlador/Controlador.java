package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Controlador implements ActionListener {
    LoginDao dao = new LoginDao();
    login usu = new login();
    Log_in log = new Log_in();
    Experiment V = new Experiment();
   

    public Controlador(Log_in log) {
        this.log = log;
        this.log.ingresar.addActionListener(this);
    }

    public Controlador(Log_in log, Experiment V) {
        this.log = log;
        this.V = V;

        this.log.ingresar.addActionListener(this);
    }

    public void autenticarUsuarios() {

        String usuario = log.Usuario.getText();
        String clave = new String(log.Pass.getPassword());
        if(dao.autenticarUsuarios(usuario,clave,"admi")){
            JOptionPane.showMessageDialog(null, "Bienvenidos al sistema");
            V.OPC1.setVisible(false);
            V.OPC2.setVisible(false);
            V.OPC3.setVisible(false);
            V.OPC4.setVisible(false);
            V.OPC6.setVisible(false);
            //V.bienvenida.setText("Bienvenidos Usuario Adminitrador "+usuario);
            log.setVisible(false);
            V.setVisible(true);
            }else 
                if(dao.autenticarUsuarios(usuario,clave,"cajero")){
                    JOptionPane.showMessageDialog(null, "Bienvenidos al sistema");
                    V.OPC7.setVisible(false);
                    log.setVisible(false);
                    V.setVisible(true);                
        }else{
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
