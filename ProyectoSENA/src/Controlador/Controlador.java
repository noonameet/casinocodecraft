package Controlador;

import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    public Vista v = new Vista();
    public Login l = new Login();

    LoginU logU = new LoginU();
    Reg_ClienteDAO DAOC = new Reg_ClienteDAO();
    Reg_EmpleadosDAO DAOE = new Reg_EmpleadosDAO();
    Emple_rolDAO DAOR = new Emple_rolDAO();
    MesaDAO DAOM = new MesaDAO();
    InventarioDAO modeloInv = new InventarioDAO();
    IngredientesDAO ingrediente = new IngredientesDAO();
    Reg_ClienteDAO modeloCli = new Reg_ClienteDAO();
    Emple_rolDAO modeloRol = new Emple_rolDAO();
    MesaDAO modeloMesa = new MesaDAO();
    Reg_EmpleadosDAO modeloEmple = new Reg_EmpleadosDAO();
    ProductoDAO modeloPro = new ProductoDAO();
    CategoriasDAO modeloCat = new CategoriasDAO();

    public Controlador(Vista v) throws SQLException {
        this.v = v;
        this.l.btnIngresar.addActionListener(this);
        this.v.btnRegistrarCliente.addActionListener(this);
        this.v.btnRegistrarEmpleado.addActionListener(this);
        this.v.btnRegistrarMesa.addActionListener(this);
        this.v.btconsultarinventario.addActionListener(this);
        this.v.btnAsociarProducto.addActionListener(this);
        this.v.btnregisterproducto.addActionListener(this);
        this.cargarCategorias();
        this.cargarinvactual();
        this.mostrarProductosAsociados();
        this.v.ivcategoria.addActionListener(this);
        this.rolesE();
        mostrarProductos(modeloInv.obtenerTodosLosProductos());
    }

    private boolean auth() {
        String usuario = l.txtUsuario.getText();
        String pass = l.txtContraseña.getText();
        boolean aux = false;

        aux = logU.auth(usuario, pass);

        return aux;
    }

    private int rolAuth() {
        String usuario = l.txtUsuario.getText();
        String pass = l.txtContraseña.getText();
        int aux = 0;

        aux = logU.rolUsu(usuario, pass);

        return aux;
    }

    private void registrarC() {
        String nomC = v.txtNombreC.getText();
        String apeC = v.txtApellidoC.getText();
        String cedC = v.txtCedulaC.getText();
        String dirC = v.txtDireccionC.getText();
        String telC = v.txtTelefonoC.getText();

        Reg_Cliente cliente = new Reg_Cliente(nomC, apeC, cedC, dirC, telC);
        System.out.println(cliente);
        DAOC.registrarCliente(cliente);
    }

    private void registrarE() {
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

    private void registrarM() {
        int cantS = Integer.parseInt(v.txtCantS.getText());
        String tipoM = (String) v.comboTiposM.getSelectedItem();

        Mesa mesa = new Mesa(cantS, "Desocupada", tipoM);
        System.out.println(mesa);
        DAOM.registrarMesa(mesa);
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

            modeloPro.registrarProducto(producto);
            JOptionPane.showMessageDialog(v, "Registro exitoso");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(v, "Por favor, ingrese datos válidos");
        }
    }

    private void mostrarProductos(ArrayList<Inventario> productos) {
        DefaultTableModel tm = (DefaultTableModel) v.jtblsalidainvetario.getModel();
        tm.setRowCount(0); // Limpia la tabla
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (Inventario producto : productos) {
            String fechaFormateada = format.format(producto.getFecha());
            tm.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getCantidad(), fechaFormateada});
        }
    }

    private void cargarItems(ArrayList items, JComboBox combo) {
        combo.removeAllItems();
        combo.addItem("Seleccionar");
        for (Object item : items) {
            combo.addItem(item);
        }
    }

    private void cargarCategorias() {
        ArrayList<Categorias> categorias = modeloCat.getObtenerCategorias();
        cargarItems(categorias, v.combocategorias);
        cargarItems(categorias, v.ivcategoria);
    }

    private void cargarinvactual() {
        ArrayList<Ingredientes> invent = ingrediente.getIngredientesDisponibles();
        v.ivingrediente.removeAllItems();
        v.ivingrediente.addItem("Seleccionar");
        for (Ingredientes ingrediente : invent) {
            v.ivingrediente.addItem(ingrediente.getNombre());
        }
    }

    private void cargarProductosPorCategoria(String categoriaNombre) {
        ArrayList<Producto> productos = modeloPro.getProductosPorCategoria(categoriaNombre);
        v.ivproducto.removeAllItems();
        v.ivproducto.addItem("Seleccionar");
        for (Producto producto : productos) {
            v.ivproducto.addItem(producto.getNombre());
        }
    }

    private Ingredientes obtenerIdIngredientePorNombre(String nombreIngrediente) {
        Ingredientes Ingredientesencontrado = null;
        ArrayList<Ingredientes> ingredientes = ingrediente.getIngredientesDisponibles();

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
        ArrayList<Producto> productos = modeloPro.getTodosLosProductos(); // Método para obtener todos los productos disponibles

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

        ingrediente.asociarProductoConIngrediente(idProducto, idIngrediente);
    }

    private void mostrarProductosAsociados() {
        DefaultTableModel model = modeloPro.getProductosAsociados();
        v.jTblasociados.setModel(model);
    }

    private <T> void mostrarElementos(ArrayList lista, JComboBox combo, T textoPredeterminado) {
        combo.removeAllItems();
        combo.addItem(textoPredeterminado);
        lista.forEach(combo::addItem);
        combo.repaint();
    }

    private void rolesE() throws SQLException {
        ArrayList<Emple_rol> listaR = DAOR.obtenerRolesP();
        mostrarElementos(listaR, v.comboRoles, "Seleccionar");
    }

    private void consultarInventario() {
        try {
            String inicio = v.jtffechainicio.getText();
            String fin = v.jtffechafinal.getText();
            String nombre = v.jtfingredienteaconsulta.getText();
            if (nombre != null && nombre.isEmpty()) {
                nombre = null; // Si el nombre está vacío, lo establecemos a null
            }
            ArrayList<Inventario> productos = modeloInv.buscarProductos(inicio, fin, nombre);
            mostrarProductos(productos);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void limpiar(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText(null);
        }
        campos[0].requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == l.btnIngresar) {
            System.out.println(auth());
            if (auth()) {
                if (rolAuth() == 1) {
                    l.setVisible(false);
                    v.setVisible(true);
                } else if (rolAuth() == 2) {
                    l.setVisible(false);
                    v.setVisible(true);
                    v.Principal.remove(v.RegistrarMesa);
                    v.Principal.remove(v.RegistrarEmpleado);
                }
            } else {
                System.out.println("Usuario o Contraseña incorrecto");
            }
        }

        if (e.getSource() == v.btnRegistrarCliente) {
            registrarC();
        }

        if (e.getSource() == v.btnRegistrarEmpleado) {
            registrarE();
        }

        if (e.getSource() == v.btnRegistrarMesa) {
            registrarM();
        }

        if (e.getSource() == v.btconsultarinventario) {
            consultarInventario();
        }

        if (e.getSource() == v.btnAsociarProducto) {
            guardarRelacionProductoIngrediente();
        }

        if (e.getSource() == v.ivcategoria) {
            Object itemSeleccionado = v.ivcategoria.getSelectedItem();
            if (itemSeleccionado instanceof Modelo.Categorias) {
                Modelo.Categorias categoria = (Modelo.Categorias) itemSeleccionado;
                String nombreCategoria = categoria.getNombre(); // Suponiendo que hay un método getNombre() que devuelve un String.
                if (!nombreCategoria.equals("Seleccionar")) {
                    cargarProductosPorCategoria(nombreCategoria);
                }
            }
        }

        if (e.getSource() == v.btnregisterproducto) {
            if (camposVacios(v.txtcodigo, v.txtnombre, v.txtprecio, v.txtcantidad)) {
                JOptionPane.showMessageDialog(v, "Por favor, llena todos los campos");
            } else {
                registrarProducto();
                limpiar(v.txtcodigo, v.txtnombre, v.txtprecio, v.txtcantidad);
            }

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
