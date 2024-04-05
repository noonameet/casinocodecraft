package Controlador;

import Modelo.*;
import Vista.Log_in;
import Vista.Ventanas;
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
import java.sql.Time;
import java.sql.Date;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;

/**
 *
 * @author Laderson Leon
 */
public class Controlador implements ActionListener {
    
    Ventanas vn = new Ventanas();
    Reg_Cliente cliente = new Reg_Cliente();
    Categorias categoria = new Categorias();
    Reg_Empleados empleados = new Reg_Empleados();
    Tipo_pago tipoP = new Tipo_pago();
    Mesa mesa = new Mesa();
    Gen_Factura factura = new Gen_Factura();
    Ingredientes invent = new Ingredientes();
    Log_in log = new Log_in();
    
    IngredientesDAO ingrediente = new IngredientesDAO();
    Reg_ClienteDAO modeloCli = new Reg_ClienteDAO();
    Emple_rolDAO modeloRol = new Emple_rolDAO();
    MesaDAO modeloMesa = new MesaDAO();
    Reg_EmpleadosDAO modeloEmple = new Reg_EmpleadosDAO();
    Tipo_pagoDAO modeloTipoP = new Tipo_pagoDAO();
    ProductoDAO modeloPro = new ProductoDAO();
    CategoriasDAO modeloCat = new CategoriasDAO();
    Gen_FacturaDAO modeloFac = new Gen_FacturaDAO();
    InventarioDAO modeloInv = new InventarioDAO();

    Vista v = new Vista();

    private MouseListener l;
    private String ingredienteSeleccionado;
    private static final int ROL_MESERO = 3;
    private static final int ROL_CAJERO = 2;

    public Controlador(Vista v, Log_in log, Ventanas vn) {
        this.v = v;
        this.log = log;
        this.vn = vn;
        this.log.ingresar.addActionListener(this);
        this.vn.btnRegistrarCliente.addActionListener(this);
        this.vn.btnRegistrarEmpleado.addActionListener(this);
        v.ElegirMesa.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                elegirMesaMouseClicked();
            }
        });
        v.Pedido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                segundoBoton();
            }
        });
        v.RegistrarCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                tercerBoton();
            }
        });
        v.GenerarFactura.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cuartoBoton();
            }
        });
        this.vn.btnCrearMesa.addActionListener(this);
        this.vn.btconsultarinventario.addActionListener(this);
        mostrarProductos(modelo.obtenerTodosLosProductos());
        //this.v.btnRegistrarProducto.addActionListener(this);
        //this.v.btnAgregarPedido.addActionListener(this);
        //this.v.btnEliminarPedido.addActionListener(this);
        //this.v.btnModificarPedido.addActionListener(this);
        //this.v.btnListarPedido.addActionListener(this);
        this.vn.btnGenerarFactura.addActionListener(this);
        //this.v.btnAsociarProducto.addActionListener(this);
        //this.v.btnrefresh.addActionListener(this);
        //this.v.btnregister.addActionListener(this);
        //this.cargarCategorias();
        //this.cargarinvactual();
        this.mostrarRoles();
        this.mostrarTiposPago();
        this.mostrarRolesMeseros();
        //this.mostrarProductosAsociados();
        //this.v.ivcategoria.addActionListener(this);
        this.mostrarRoles(ROL_MESERO, vn.comboMeseros);
        this.mostrarRoles(ROL_CAJERO, vn.comboCajeros);

    }
    
    private void autenticarUsuarios() {

        String usuario = log.Usuario.getText();
        String clave = new String(log.Pass.getPassword());
        if(modeloEmple.autenticarUsuarios(usuario,clave,1)){
            v.Bienvenida.setText("Bienvenido/a, "+usuario);
            v.NombreUsuario.setText("Administrador");
            log.setVisible(false);
            v.setResizable(false);
            v.setVisible(true);
            v.ElegirMesa.setText("Crear Mesa");
            ImageIcon icon = new ImageIcon("C:\\Users\\ladje\\OneDrive\\Documents\\GitHub\\casinocodecraft\\casinocodecraft-ProgramacionSenior\\src\\imagenes\\mesaR.png");
            v.ElegirMesa.setIcon(icon);
            ImageIcon iconR = new ImageIcon("C:\\Users\\ladje\\OneDrive\\Documents\\GitHub\\casinocodecraft\\casinocodecraft-ProgramacionSenior\\src\\imagenes\\registro.png");
            v.Pedido.setIcon(iconR);
            ImageIcon iconF = new ImageIcon("C:\\Users\\ladje\\OneDrive\\Documents\\GitHub\\casinocodecraft\\casinocodecraft-ProgramacionSenior\\src\\imagenes\\agregar-producto.png");
            v.Pedido.setIcon(iconF);
            ImageIcon iconP = new ImageIcon("C:\\Users\\ladje\\OneDrive\\Documents\\GitHub\\casinocodecraft\\casinocodecraft-ProgramacionSenior\\src\\imagenes\\inventario.png");
            v.Pedido.setIcon(iconP);
            v.Pedido.setText("Registrar Empleado");
            v.RegistrarCliente.setText("Agregar Producto");
            v.GenerarFactura.setText("Mostrar Inventario");
        }else if(modeloEmple.autenticarUsuarios(usuario,clave,2)){
            v.Bienvenida.setText("Bienvenido/a, "+usuario);
            v.NombreUsuario.setText("Cajero");
            log.setVisible(false);
            v.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null, "Error, intente de nuevo");
            log.Usuario.requestFocus();
        }
    }

    private void registrarCliente() {

        String nombre = vn.txtNombreC.getText();
        String apellido = vn.txtApellidoC.getText();
        String cedula = vn.txtCedulaC.getText();
        String direccion = vn.txtDireccionC.getText();
        String telefono = vn.txtTelefonoC.getText();

        Reg_Cliente newClie = new Reg_Cliente(nombre, apellido, cedula, direccion, telefono);

        modeloCli.registrarCliente(newClie);
    }

    private void registrarEmpleado() {
        String nombre = vn.txtNombreE.getText();
        String apellido = vn.txtApellidoE.getText();
        String cedula = vn.txtCedulaE.getText();
        String telefono = vn.txtTelefonoE.getText();
        String usuario = vn.txtUsuarioE.getText();
        String contraseña = vn.txtContraseñaE.getText();
        int rol = vn.comboRoles.getSelectedIndex();

        Reg_Empleados newEmple = new Reg_Empleados(nombre, apellido, cedula, telefono, usuario, contraseña, rol);

        modeloEmple.registrarEmpleados(newEmple);
    }

    /*private void registrarProducto() {
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
    }*/

    private void generarFactura(){
        try {
            
            String tpS = (String) vn.comboTipoP.getSelectedItem();
            String rEmpleado = (String) vn.comboCajeros.getSelectedItem();
            String rEmpleado2 = (String) vn.comboMeseros.getSelectedItem();
            Reg_Empleados emple;
            
            int id_cliente = Integer.parseInt(vn.txtCliente.getText());
            Tipo_pago tpE = obtenerID(tpS);
            int tipoP = tpE.getId_tipoP();
            
            emple = obtenerIDEmpleados(rEmpleado2);
            int id_mesero = emple.getId_emple();
            emple = obtenerIDEmpleados(rEmpleado);
            int id_cajero = emple.getId_emple();
            String num_fact = "1";
            double descuento = Double.parseDouble(vn.txtDesc.getText());
            double IVA = 0.19;
            double total = 2000;
            Time time = new Time(System.currentTimeMillis());
            System.out.println(time);
            Date currentDate = new Date(System.currentTimeMillis());
            System.out.println(currentDate);
            
            Gen_Factura factura = new Gen_Factura(id_cliente, id_mesero, tipoP, id_cajero, descuento, IVA, total, num_fact, time, currentDate);
            modeloFac.getGenerarFact(factura);
            
        }catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(v, "Por favor, ingrese datos válidos");
        }
    }
    
    private void registrarMesa(){
        
        int cantSillas = Integer.parseInt(vn.txtCantidadS.getText());
        String tipo = (String) vn.comboTipos.getSelectedItem();
        String estado = "Libre";
        
        Mesa mesa = new Mesa(cantSillas, estado, tipo);
        modeloMesa.registrarMesa(mesa);
    }
    
    /*private void cargarCategorias() {
        ArrayList<Categorias> categorias = modeloCat.getObtenerCategorias();
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
    }*/
    
    private Reg_Empleados obtenerIDEmpleados(String nombreEmpleado) {
        Reg_Empleados tipoEmple = null;
        ArrayList<Reg_Empleados> ArrayEmpleados = modeloEmple.getEmpleados();
        for (Reg_Empleados rEm : ArrayEmpleados) {
            if (rEm.getNom_emple().equals(nombreEmpleado)) {
                tipoEmple = rEm;
                break;
            }
        }
        if (tipoEmple == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el ID del tipo de pago.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tipoEmple;
    }
    
    private Tipo_pago obtenerID(String nombreTipoP) {
        Tipo_pago tipoPE = null;
        ArrayList<Tipo_pago> tp = modeloTipoP.obtenerTiposPP();
        for (Tipo_pago tpa : tp) {
            if (tpa.getNom_tipoP().equals(nombreTipoP)) {
                tipoPE = tpa;
                break;
            }
        }
        if (tipoPE == null) {
            JOptionPane.showMessageDialog(null, "No se encontró el ID del tipo de pago.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        return tipoPE;
    }

    /*private Ingredientes obtenerIdIngredientePorNombre(String nombreIngrediente) {
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
    }*/
    
    private void consultarInventario() {
        try {
            String inicio = vista.jtffechainicio.getText();
            String fin = vista.jtffechafinal.getText();
            String nombre = vista.jtfingredienteaconsulta.getText();
            if (nombre != null && nombre.isEmpty()) {
                nombre = null; // Si el nombre está vacío, lo establecemos a null
            }
            ArrayList<Inventario> productos = modeloInv.buscarProductos(inicio, fin, nombre);
            mostrarProductos(productos);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }
    
    private void mostrarProductos(ArrayList<Inventario> productos) {
        DefaultTableModel tm = (DefaultTableModel) vista.jtblsalidainvetario.getModel();
        tm.setRowCount(0); // Limpia la tabla
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (Inventario producto : productos) {
            String fechaFormateada = format.format(producto.getFecha());
            tm.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getCantidad(), fechaFormateada});
        }
    }
    
    private void mostrarRoles() {
        ArrayList<Emple_rol> listaR = modeloRol.obtenerRolesP();
        vn.comboRoles.addItem("Seleccionar");
        for (int i = 0; i < listaR.size(); i++) {
            vn.comboRoles.addItem(listaR.get(i).getNom_rol());
        }
    }

    private void mostrarRolesMeseros() {
        ArrayList<Reg_Empleados> listaR = modeloEmple.obtenerEmpleados();
        vn.comboMeseros.removeAllItems();
        vn.comboMeseros.addItem("Seleccionar");
        for (int i = 0; i < listaR.size(); i++) {
            Reg_Empleados rol = listaR.get(i);
            if (rol.getRol() == 3) {
                vn.comboMeseros.addItem(rol.getNom_emple());
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
        vn.comboTipoP.removeAllItems();
        vn.comboTipoP.addItem("Seleccionar");
        for (int i = 0; i < listaT.size(); i++) {
            vn.comboTipoP.addItem(listaT.get(i).getNom_tipoP());
        }
    }
    
    private void elegirMesaMouseClicked() {
        String usuario = log.Usuario.getText();
        
        int rol = modeloEmple.obtenerRol(usuario);
        if(rol == 1){
            vn.VentanaCrearM.setSize(278, 355);
            vn.VentanaCrearM.setLocation(50, 50);

            v.Escritorio.add(vn.VentanaCrearM);
            vn.VentanaRegistroE.setVisible(false);
            vn.VentanaMostrarI.setVisible(false);
            vn.VentanaAgregarP.setVisible(false);
            vn.VentanaCrearM.setVisible(true);
        }else if(rol == 2){
            vn.VentanaMesas.setSize(559, 420);
            vn.VentanaMesas.setLocation(50, 50);

            v.Escritorio.add(vn.VentanaMesas);
            vn.VentanaPedidos.setVisible(false);
            vn.VentanaRegistrarC.setVisible(false);
            vn.VentanaGenerarF.setVisible(false);
            vn.VentanaMesas.setVisible(true);
        }
    }
    
    private void segundoBoton() {
        String usuario = log.Usuario.getText();
        
        int rol = modeloEmple.obtenerRol(usuario);
        if(rol == 1){
            vn.VentanaRegistroE.setSize(559, 420);
            vn.VentanaRegistroE.setLocation(50, 50);

            v.Escritorio.add(vn.VentanaRegistroE);
            
            vn.VentanaMostrarI.setVisible(false);
            vn.VentanaAgregarP.setVisible(false);
            vn.VentanaCrearM.setVisible(false);
            vn.VentanaRegistroE.setVisible(true);
        }else if(rol == 2){
            vn.VentanaPedidos.setSize(559, 420);
            vn.VentanaPedidos.setLocation(50, 50);

            v.Escritorio.add(vn.VentanaPedidos);
            
            vn.VentanaRegistrarC.setVisible(false);
            vn.VentanaGenerarF.setVisible(false);
            vn.VentanaMesas.setVisible(false);
            vn.VentanaPedidos.setVisible(true);
        }
        
    }
    
    private void tercerBoton() {
        String usuario = log.Usuario.getText();
        
        int rol = modeloEmple.obtenerRol(usuario);
        if(rol == 1){
            vn.VentanaAgregarP.setSize(559, 420);
            vn.VentanaAgregarP.setLocation(50, 50);

            v.Escritorio.add(vn.VentanaAgregarP);
            
            vn.VentanaMostrarI.setVisible(false);
            vn.VentanaAgregarP.setVisible(true);
            vn.VentanaCrearM.setVisible(false);
            vn.VentanaRegistroE.setVisible(false);
        }else if(rol == 2){
            vn.VentanaRegistrarC.setSize(559, 420);
            vn.VentanaRegistrarC.setLocation(50, 50);

            v.Escritorio.add(vn.VentanaRegistrarC);
            vn.VentanaRegistrarC.setVisible(true);
            vn.VentanaGenerarF.setVisible(false);
            vn.VentanaMesas.setVisible(false);
            vn.VentanaPedidos.setVisible(false);
        }
    }
    
    private void cuartoBoton() {
        String usuario = log.Usuario.getText();
        
        int rol = modeloEmple.obtenerRol(usuario);
        if(rol == 1){
            vn.VentanaMostrarI.setSize(559, 420);
            vn.VentanaMostrarI.setLocation(50, 50);

            v.Escritorio.add(vn.VentanaMostrarI);
            
            vn.VentanaMostrarI.setVisible(true);
            vn.VentanaAgregarP.setVisible(false);
            vn.VentanaCrearM.setVisible(false);
            vn.VentanaRegistroE.setVisible(false);
        }else if(rol == 2){
            vn.VentanaGenerarF.setSize(559, 420);
            vn.VentanaGenerarF.setLocation(50, 50);

            v.Escritorio.add(vn.VentanaGenerarF);
            
            vn.VentanaRegistrarC.setVisible(false);
            vn.VentanaGenerarF.setVisible(true);
            vn.VentanaPedidos.setVisible(false);
            vn.VentanaMesas.setVisible(false);
        }
        
    }

    private void limpiar(JTextField... campos) {
        for (JTextField campo : campos) {
            campo.setText(null);
        }
        campos[0].requestFocus();
    }

    /*private void mostrarProductosAsociados() {
        DefaultTableModel model = modeloPro.getProductosAsociados();
        v.jTblasociados.setModel(model);
    }*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == log.ingresar) {
            autenticarUsuarios();
        }else if(e.getSource() == vn.btnCrearMesa){
            registrarMesa();
        }
        /*if (e.getSource() == v.btnrefresh){
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
        }*/ else if (e.getSource() == vn.btnRegistrarCliente) {
            registrarCliente();
        }/* else if (e.getSource() == v.btnregister) {
            if (camposVacios(v.txtcodigo, v.txtnombre, v.txtprecio, v.txtcantidad)) {
                JOptionPane.showMessageDialog(v, "Por favor, llena todos los campos");
            } else {
                registrarProducto();
                limpiar(v.txtcodigo, v.txtnombre, v.txtprecio, v.txtcantidad);
            }
        }*/ else if (e.getSource() == vn.btnRegistrarEmpleado) {
            if (camposVacios(vn.txtNombreE, vn.txtTelefonoE, vn.txtCedulaE, vn.txtTelefonoE, vn.txtUsuarioE, vn.txtContraseñaE)) {
                JOptionPane.showMessageDialog(v, "Por favor, llena todos los campos");
            } else {
                registrarEmpleado();
                limpiar(vn.txtNombreE, vn.txtTelefonoE, vn.txtCedulaE, vn.txtTelefonoE, vn.txtUsuarioE, vn.txtContraseñaE);
            }
        }else if(e.getSource() == v.ElegirMesa){
            elegirMesaMouseClicked();
        }else if(e.getSource() == v.Pedido){
            segundoBoton();
        }else if(e.getSource() == v.RegistrarCliente){
            tercerBoton();
        }else if(e.getSource() == v.GenerarFactura){
            cuartoBoton();
        } else if (e.getSource() == vn.btnGenerarFactura) {
            generarFactura();
        }else if(e.getSource() == vista.btconsultarinventario) {
            consultarInventario();
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
