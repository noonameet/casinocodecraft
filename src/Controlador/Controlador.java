package Controlador;

import Modelo.*;
import Vista.Vista;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Laderson Leon
 */
public class Controlador implements ActionListener {

    Reg_Cliente cliente = new Reg_Cliente();
    Categorias categoria = new Categorias();
    Reg_Empleados empleados = new Reg_Empleados();
    Tipo_pago tipoP = new Tipo_pago();
    Mesa mesa = new Mesa();
    Gen_Factura factura = new Gen_Factura();
    IngredientesDAO ingrediente = new IngredientesDAO();
    Ingredientes invent = new Ingredientes();
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
    private String ingredienteSeleccionado;
    private static final int ROL_MESERO = 3;
    private static final int ROL_CAJERO = 2;

    public Controlador(Vista v) {
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
        this.v.btnAsociarProducto.addActionListener(this);
        this.v.btnrefresh.addActionListener(this);
        this.cargarCategorias();
        this.cargarinvactual();
        this.mostrarRoles();
        this.mostrarTiposPago();
        this.mostrarRolesMeseros();
        this.mostrarProductosAsociados();
        this.v.ivcategoria.addActionListener(this);
        this.mostrarRoles(ROL_MESERO, v.comboMesero);
        this.mostrarRoles(ROL_CAJERO, v.comboCajero);

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

            Categorias categorias = new Categorias(id_categoria, "");
            Producto producto = new Producto(id_producto, nombre, precio, cantidad, categorias);

            modeloPro.Registrar(producto);
            JOptionPane.showMessageDialog(v, "Registro exitoso");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(v, "Por favor, ingrese datos válidos");
        }
    }

    /*private void generarFactura(){
        try {
            int id_cliente = Integer.parseInt(v.txtCliente.getText());
            int tipoP = v.comboTipoP.getSelectedIndex();
            int id_mesero = v.comboMesero.getSelectedIndex();
            int id_cajero = v.comboCajero.getSelectedIndex();
            int num_fact = 1;
            double descuento = Double.parseDouble(v.txtDesc.getText());
            double IVA = 0.19;
            double total =  
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(v, "Por favor, ingrese datos válidos");
        }
    }*/
 /*private void registrarMesa(){
        int id = modeloMesa.devolverId() + 1;
        int cantSillas = Integer.parseInt(v.txtCantidadSillas.getText());
        String tipo = v.txtComboTipos.getSelectedIndex()+1;
        String estado = v.txtComboEstado.getSelectedIndex()+1;
        
        mesa.setId(id); mesa.setCant_sillas(cantSillas);
        mesa.setTipo(tipo); mesa.setEstado(estado);
        
        modeloMesa.
        
    }*/
    private void cargarCategorias() {
        ArrayList<Categorias> categorias = modeloCat.ObtenerCategorias();
        v.combocategorias.removeAllItems();
        v.ivcategoria.removeAllItems();
        v.combocategorias.addItem("Seleccionar");
        v.ivcategoria.addItem("Seleccionar");
        for (Categorias categoria : categorias) {
            v.combocategorias.addItem(categoria.getNombre());
            v.ivcategoria.addItem(categoria.getNombre());
        }
    }

    private void cargarinvactual() {
        ArrayList<Ingredientes> invent = ingrediente.obtenerIngredientesDisponibles();
        v.ivingrediente.removeAllItems();
        v.ivingrediente.addItem("Seleccionar");
        for (Ingredientes ingrediente : invent) {
            v.ivingrediente.addItem(ingrediente.getNombre());
        }
    }

    private void cargarProductosPorCategoria(String categoriaNombre) {
        ArrayList<Producto> productos = modeloPro.obtenerProductosPorCategoria(categoriaNombre);
        v.ivproducto.removeAllItems();
        v.ivproducto.addItem("Seleccionar");
        for (Producto producto : productos) {
            v.ivproducto.addItem(producto.getNombre());
        }
    }

    private Ingredientes obtenerIdIngredientePorNombre(String nombreIngrediente) {
        Ingredientes Ingredientesencontrado = null;
        ArrayList<Ingredientes> ingredientes = ingrediente.obtenerIngredientesDisponibles();

        for (Ingredientes ingrediente : ingredientes) {
            if (ingrediente.getNombre().equals(nombreIngrediente)) {
                Ingredientesencontrado = ingrediente;
                break;
            }
        }

        if (Ingredientesencontrado == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el ID del ingrediente.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return Ingredientesencontrado;
    }

    private Producto obtenerProductoPorNombre(String nombreProducto) {
        Producto productoEncontrado = null;
        ArrayList<Producto> productos = modeloPro.obtenerTodosLosProductos(); // Método para obtener todos los productos disponibles

        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombreProducto)) {
                productoEncontrado = producto;
                break;
            }
        }

        if (productoEncontrado == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el producto.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return productoEncontrado;
    }

    private void guardarRelacionProductoIngrediente() {
        String nombreProducto = (String) v.ivproducto.getSelectedItem();
        Producto productoSeleccionado = obtenerProductoPorNombre(nombreProducto);

        int idProducto = productoSeleccionado.getId_producto();

        String nombreIngrediente = (String) v.ivingrediente.getSelectedItem();
        Ingredientes Ingredientesencontrado = obtenerIdIngredientePorNombre(nombreIngrediente);

        int idIngrediente = Ingredientesencontrado.getId();

        ingrediente.asociarProductoIngrediente(idProducto, idIngrediente);
    }

    private void mostrarRoles() {
        ArrayList<Emple_rol> listaR = modeloRol.obtenerRolesP();
        v.comboRoles.addItem("Seleccionar");
        for (int i = 0; i < listaR.size(); i++) {
            v.comboRoles.addItem(listaR.get(i).getNom_rol());
        }
    }

    private void mostrarRolesMeseros() {
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

    private void mostrarRoles(int rol, JComboBox combo) {
        ArrayList<Reg_Empleados> listaR = modeloEmple.obtenerEmpleados();
        combo.removeAllItems();
        combo.addItem("Seleccionar");
        for (int i = 0; i < listaR.size(); i++) {
            Reg_Empleados empleado = listaR.get(i);
            if (empleado.getRol() == rol) {
                combo.addItem(empleado.getNom_emple());
            }
        }
    }

    private void mostrarTiposPago() {
        ArrayList<Tipo_pago> listaT = modeloTipoP.obtenerTiposPP();
        v.comboTipoP.addItem("Seleccionar");
        for (int i = 0; i < listaT.size(); i++) {
            v.comboTipoP.addItem(listaT.get(i).getNom_tipoP());
        }
    }

    private void limpiar(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText(null);
        }
        campos[0].requestFocus();
    }

    private void mostrarProductosAsociados() {
        DefaultTableModel model = modeloPro.obtenerProductosAsociados();
        v.jTblasociados.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == v.btnrefresh){
            mostrarProductosAsociados();
        }
        if (e.getSource() == v.btnAsociarProducto) {
            guardarRelacionProductoIngrediente();
        }

        if (e.getSource() == v.ivcategoria) {
            String categoriaSeleccionada = (String) v.ivcategoria.getSelectedItem();
            if (!categoriaSeleccionada.equals("Seleccionar")) {
                cargarProductosPorCategoria(categoriaSeleccionada);
            }
        } else if (e.getSource() == v.btnRegistrarCliente) {
            if (camposVacios(v.txt, v.txt2, v.txt3, v.txt4, v.txt5)) {
                JOptionPane.showMessageDialog(v, "Por favor, llena todos los campos");
            } else {
                registrarCliente();
                limpiar(v.txt, v.txt2, v.txt3, v.txt4, v.txt5);
            }
        } else if (e.getSource() == v.btnregister) {
            if (camposVacios(v.txtcodigo, v.txtnombre, v.txtprecio, v.txtcantidad)) {
                JOptionPane.showMessageDialog(v, "Por favor, llena todos los campos");
            } else {
                registrarProducto();
                limpiar(v.txtcodigo, v.txtnombre, v.txtprecio, v.txtcantidad);
            }
        } else if (e.getSource() == v.btnRegistrarEmpleado) {
            if (camposVacios(v.jtxtNombreEmpleado, v.jtxtApellidoEmpleado, v.jtxtCedulaEmpleado, v.jtxtTelefonoEmpleado, v.jtxtUsuario, v.jtxtContraseña)) {
                JOptionPane.showMessageDialog(v, "Por favor, llena todos los campos");
            } else {
                registrarEmpleado();
                limpiar(v.jtxtNombreEmpleado, v.jtxtApellidoEmpleado, v.jtxtCedulaEmpleado, v.jtxtTelefonoEmpleado, v.jtxtUsuario, v.jtxtContraseña);
            }
        } else if (e.getSource() == v.btnGenerarFactura) {
            // generarFactura(); // Esta parte está comentada, asegúrate de implementarla correctamente
            limpiar();
        }
    }

    private boolean camposVacios(JTextField... campos) {
        for (JTextField campo : campos) {
            if (campo.getText().isEmpty()) {
                return true;
            }
        }
        return false;
    }

}
