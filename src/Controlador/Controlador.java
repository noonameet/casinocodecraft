package Controlador;
import Modelo.Reg_ClienteDAO;
import Modelo.Reg_Cliente;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
/**
 *
 * @author Laderson Leon
 */
public class Controlador implements ActionListener{
    Reg_ClienteDAO modelo = new Reg_ClienteDAO();
    Reg_Cliente cliente = new Reg_Cliente();
    Vista v = new Vista();            
    
    private MouseListener l;

    public Controlador(Vista v){
        this.v = v;
        this.v.btnRegistrar.addActionListener(this);
    }

    public void registrarCliente() {
        
        int id = modelo.devolverId() + 1;
        String nombre = v.txt.getText();
        String apellido = v.txt2.getText();
        String cedula = v.txt3.getText();
        String direccion = v.txt4.getText();
        String telefono = v.txt5.getText();
        
        cliente.setId_clie(id);
        cliente.setNom_cli(nombre);
        cliente.setApe_cli(apellido);
        cliente.setCed_cli(cedula);
        cliente.setDireccion(direccion);
        cliente.setTelef(telefono);
        
        int f = modelo.registrarCliente(cliente);
        if(f == 1){
            System.out.println("Registro exitoso");
        }else{
            System.out.println("NO se ha registrado correctamente");
        }
    }
    
    public void limpiar(){
        v.txt.setText(null);
        v.txt2.setText(null);
        v.txt3.setText(null);
        v.txt4.setText(null);
        v.txt5.setText(null);
        v.txt.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == v.btnRegistrar){
            registrarCliente();
            limpiar();
        }
    }
    
}
