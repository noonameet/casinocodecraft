package Controlador;
import Modelo.*;
import Vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import java.util.ArrayList;
/**
 *
 * @author Laderson Leon
 */
public class Controlador implements ActionListener{
    Reg_Cliente cliente = new Reg_Cliente(); 
    Categorias categoria = new Categorias();
    Reg_Empleados empleados = new Reg_Empleados();
    Tipo_pago tipoP = new Tipo_pago();
    Mesa mesa = new Mesa();
    Gen_Factura factura = new Gen_Factura();
    
    Reg_ClienteDAO modeloCli = new Reg_ClienteDAO();
    Emple_rolDAO modeloRol = new Emple_rolDAO();
    MesaDAO modeloMesa = new MesaDAO();
    Reg_EmpleadosDAO modeloEmple = new Reg_EmpleadosDAO();
    Tipo_pagoDAO modeloTipoP = new Tipo_pagoDAO();
    ProductoDAO modeloPro = new ProductoDAO();
    CategoriasDAO modeloCat = new CategoriasDAO();
    Gen_FacturaDAO modeloFac = new Gen_FacturaDAO();
    

    Vista v = new Vista();            
    
    private MouseListener l;

    public Controlador(Vista v){
        this.v = v;
        this.v.btnRegistrarCliente.addActionListener(this);
        this.v.btnRegistrarEmpleado.addActionListener(this);
        //this.v.btnRegistrarMesa.addActionListener(this);
        //this.v.btnRegistrarProducto.addActionListener(this);
        //this.v.btnAgregarPedido.addActionListener(this);
        //this.v.btnEliminarPedido.addActionListener(this);
        //this.v.btnModificarPedido.addActionListener(this);
        //this.v.btnListarPedido.addActionListener(this);
        this.v.btnGenerarFactura.addActionListener(this);
        this.mostrarCategorias();
        this.mostrarRoles();
        this.mostrarTiposPago();
        this.mostrarRolesMeseros();
        this.mostrarRolesCajeros();
    }

    private void registrarCliente() {
        
        String nombre = v.txt.getText();
        String apellido = v.txt2.getText();
        String cedula = v.txt3.getText();
        String direccion = v.txt4.getText();
        String telefono = v.txt5.getText();
        
        Reg_Cliente newClie = new Reg_Cliente(nombre, apellido, cedula, direccion, telefono);
        
        modeloCli.registrarCliente(newClie);
    }
    
    private void registrarEmpleado() {
        String nombre = v.jtxtNombreEmpleado.getText();
        String apellido = v.jtxtApellidoEmpleado.getText();
        String cedula = v.jtxtCedulaEmpleado.getText();
        String telefono = v.jtxtTelefonoEmpleado.getText();
        String usuario = v.jtxtUsuario.getText();
        String contraseña = v.jtxtContraseña.getText();
        int rol = v.comboRoles.getSelectedIndex();
        
        Reg_Empleados newEmple = new Reg_Empleados(nombre, apellido, cedula, telefono, usuario, contraseña, rol);
        
        modeloEmple.registrarEmpleados(newEmple);
    }
    
    private void registrarProducto() {
        try {
            int id_producto = Integer.parseInt(v.txtcodigo.getText());
            String nombre = v.txtnombre.getText();
            double precio = Integer.parseInt(v.txtprecio.getText());
            int id_categoria = v.combocategorias.getSelectedIndex();
            int cantidad = Integer.parseInt(v.txtcantidad.getText());

            Categorias categorias = new Categorias(id_categoria,"");
            Producto producto = new Producto(id_producto, nombre, precio, cantidad, categorias);

            modeloPro.Registrar(producto);
            JOptionPane.showMessageDialog(v, "Registro exitoso");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(v, "Por favor, ingrese datos válidos");
        }
    }
    
    private void generarFactura(){
        
    }
    
    /*private void registrarMesa(){
        int id = modeloMesa.devolverId() + 1;
        int cantSillas = Integer.parseInt(v.txtCantidadSillas.getText());
        String tipo = v.txtComboTipos.getSelectedIndex()+1;
        String estado = v.txtComboEstado.getSelectedIndex()+1;
        
        mesa.setId(id); mesa.setCant_sillas(cantSillas);
        mesa.setTipo(tipo); mesa.setEstado(estado);
        
        modeloMesa.
        
    }*/
    
    private void mostrarRoles(){
        ArrayList<Emple_rol> listaR = modeloRol.obtenerRolesP();
        v.comboRoles.addItem("Seleccionar");
        for (int i = 0; i < listaR.size(); i++) {
            v.comboRoles.addItem(listaR.get(i).getNom_rol());
        }
    }
    
    private void mostrarRolesMeseros(){
        ArrayList<Reg_Empleados> listaR = modeloEmple.obtenerEmpleados();
        v.comboMesero.removeAllItems();
        v.comboMesero.addItem("Seleccionar");
        for (int i = 0; i < listaR.size(); i++) {
            Reg_Empleados rol = listaR.get(i);
            if (rol.getRol() == 3) { 
                v.comboMesero.addItem(rol.getNom_emple());
            }
        }
    }
    
    private void mostrarRolesCajeros(){
        ArrayList<Reg_Empleados> listaR = modeloEmple.obtenerEmpleados();
        v.comboCajero.removeAllItems();
        v.comboCajero.addItem("Seleccionar");
        for (int i = 0; i < listaR.size(); i++) {
            Reg_Empleados rol = listaR.get(i);
            if (rol.getRol() == 2) { 
                v.comboCajero.addItem(rol.getNom_emple());
            }
        }
    }
    
    private void mostrarCategorias() {
        ArrayList<Categorias> listaC = modeloCat.ObtenerCategorias();
        v.combocategorias.addItem("Seleccionar");
        for (int i = 0; i < listaC.size(); i++) {
            v.combocategorias.addItem(listaC.get(i).getNombre());
        }
    }
    
    private void mostrarTiposPago(){
        ArrayList<Tipo_pago> listaT = modeloTipoP.obtenerTiposPP();
        v.comboTipoP.addItem("Seleccionar");
        for (int i = 0; i < listaT.size(); i++) {
            v.comboTipoP.addItem(listaT.get(i).getNom_tipoP());
        }
    }
    
    private void limpiar(){
        v.txt.setText(null);
        v.txt2.setText(null);
        v.txt3.setText(null);
        v.txt4.setText(null);
        v.txt5.setText(null);
        v.txt.requestFocus();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == v.btnRegistrarCliente){
            registrarCliente();
            limpiar();
        }else if (e.getSource() == v.btnregister) {
            registrarProducto();
            limpiar();
        }else if(e.getSource() == v.btnRegistrarEmpleado){
            registrarEmpleado();
            limpiar();
        }else if(e.getSource() == v.btnGenerarFactura){
            generarFactura();
            limpiar();
        }
    }
    
}
