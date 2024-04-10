package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controlador implements ActionListener{
    
    public Vista v = new Vista();
    public Login l = new Login();
    
    LoginU logU = new LoginU();
    Reg_ClienteDAO DAOC = new Reg_ClienteDAO();
    Reg_EmpleadosDAO DAOE = new Reg_EmpleadosDAO();
    Emple_rolDAO DAOR = new Emple_rolDAO();
    MesaDAO DAOM = new MesaDAO();
    
    
    public Controlador(Vista v) throws SQLException{
        this.v = v;
        this.l.btnIngresar.addActionListener(this);
        this.v.btnRegistrarCliente.addActionListener(this);
        this.v.btnRegistrarEmpleado.addActionListener(this);
        this.v.btnRegistrarMesa.addActionListener(this);
        this.rolesE();
    }
    
    private boolean auth() throws SQLException{
        String usuario = l.txtUsuario.getText();
        String pass = l.txtContraseña.getText();
        boolean aux = false;
        
        aux = logU.auth(usuario, pass);
        
        return aux;
    }
    
    private int rolAuth() throws SQLException {
        String usuario = l.txtUsuario.getText();
        String pass = l.txtContraseña.getText();
        int aux = 0;
        
        aux = logU.rolUsu(usuario, pass);
        
        return aux;
    }
    
    private void registrarC() throws SQLException{
        String nomC = v.txtNombreC.getText();
        String apeC = v.txtApellidoC.getText();
        String cedC = v.txtCedulaC.getText();
        String dirC = v.txtDireccionC.getText();
        String telC = v.txtTelefonoC.getText();
        
        Reg_Cliente cliente = new Reg_Cliente(nomC, apeC, cedC, dirC, telC);
        System.out.println(cliente);
        DAOC.registrarCliente(cliente);
    }
    
    private void registrarE() throws SQLException{
        String nomE = v.txtNombreE.getText();
        String apeE = v.txtApellidoE.getText();
        String cedE = v.txtCedulaE.getText();
        String telE = v.txtTelefonoE.getText();
        String usuE = v.txtUsuarioE.getText();
        String passE = v.txtClaveE.getText();
        int rol = v.comboRoles.getSelectedIndex();
        
        Reg_Empleados empleado = new Reg_Empleados(nomE, apeE, cedE, telE, usuE, passE, rol);
        System.out.println(empleado);
        DAOE.registrarEmpleados(empleado);
    }
    
    private void registrarM() throws SQLException {
        int cantS = Integer.parseInt(v.txtCantS.getText());
        String tipoM = (String) v.comboTiposM.getSelectedItem();
        
        Mesa mesa = new Mesa(cantS, "Desocupada", tipoM);
        System.out.println(mesa);
        DAOM.registrarMesa(mesa);
    }
    
    private void rolesE() throws SQLException{
        ArrayList<Emple_rol> listaR = DAOR.obtenerRolesP();
        v.comboRoles.addItem("Seleccionar");
        for (int i = 0; i < listaR.size(); i++) {
            v.comboRoles.addItem(listaR.get(i).getNom_rol());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == l.btnIngresar){
            try {
                System.out.println(auth());
                if(auth()){
                    if(rolAuth() == 1){
                        l.setVisible(false);
                        v.setVisible(true); 
                    }else if(rolAuth() == 2){
                        l.setVisible(false);
                        v.setVisible(true);
                        v.Principal.remove(v.RegistrarMesa);
                        v.Principal.remove(v.RegistrarEmpleado);
                    }
                }else{
                    System.out.println("Usuario o Contraseña incorrecto");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if(e.getSource() == v.btnRegistrarCliente){
            try {
                registrarC();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        
        if(e.getSource() == v.btnRegistrarEmpleado){
            try{
                registrarE();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        
        if(e.getSource() == v.btnRegistrarMesa)  {
            try{
                registrarM();
            }catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    
}
