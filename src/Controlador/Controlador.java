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
    Reg_Empleados empleados = new Reg_Empleados() {};
    Mesa mesa = new Mesa();
    
    Reg_ClienteDAO modeloCli = new Reg_ClienteDAO();
    MesaDAO modeloMesa = new MesaDAO();
    Reg_EmpleadosDAO modeloEmple = new Reg_EmpleadosDAO();
    ProductoDAO modeloPro = new ProductoDAO();
    CategoriasDAO modeloCat = new CategoriasDAO();
    

    Vista v = new Vista();            
    
    private MouseListener l;

    public Controlador(Vista v){
        this.v = v;
        this.v.btnRegistrarCliente.addActionListener(this);
        this.v.btnRegistrarEmpleado.addActionListener(this);
        this.v.btnRegistrarMesa.addActionListener(this);
        this.v.btnRegistrarProducto.addActionListener(this);
        this.v.btnAgregarPedido.addActionListener(this);
        this.v.btnEliminarPedido.addActionListener(this);
        this.v.btnModificarPedido.addActionListener(this);
        this.v.btnListarPedido.addActionListener(this);
        this.v.btnGenerarFactura.addActionListener(this);
    }

    public void registrarCliente() {
        
        int id = modeloCli.devolverId() + 1;
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
        
        int f = modeloCli.registrarCliente(cliente);
        if(f == 1){
            System.out.println("Registro exitoso");
        }else{
            System.out.println("NO se ha registrado correctamente");
        }
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
    
    public void mostrarCategorias() {
        ArrayList<Categorias> lista = modeloCat.ObtenerCategorias();
        v.combocategorias.addItem("Seleccionar");
        for (int i = 0; i < lista.size(); i++) {
            v.combocategorias.addItem(lista.get(i).getNombre());
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
    
    private void agregarPedido(Mesa m, Empleado me){
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == v.btnRegistrar){
            registrarCliente();
            limpiar();
        }else if (e.getSource() == v.btnregister) {
            registrarProducto();
            limpiar();
        }
    }
    
}
