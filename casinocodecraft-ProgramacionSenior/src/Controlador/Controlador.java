package Controlador;

import Modelo.*;
import Vista.Log_in;
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
    Inven_ingrediente_DAO modeloinv = new Inven_ingrediente_DAO();

    Vista v = new Vista();

    private MouseListener l;
    private String ingredienteSeleccionado;
    private static final int ROL_MESERO = 3;
    private static final int ROL_CAJERO = 2;

    public Controlador(Vista v, Log_in log) {
        this.v = v;
        this.log = log;
        //this.log.ingresar.addActionListener(this);
        this.v.btnRegistrarCliente.addActionListener(this);
        this.v.btnRegistrarEmpleado.addActionListener(this);
        this.v.btconsultarinventario.addActionListener(this);
        //this.v.btnRegistrarMesa.addActionListener(this);
        //this.v.btnRegistrarProducto.addActionListener(this);
        //this.v.btnAgregarPedido.addActionListener(this);
        //this.v.btnEliminarPedido.addActionListener(this);
        //this.v.btnModificarPedido.addActionListener(this);
        //this.v.btnListarPedido.addActionListener(this);
        this.v.btnGenerarFactura.addActionListener(this);
        //this.v.btnAsociarProducto.addActionListener(this);
        //this.v.btnrefresh.addActionListener(this);
        //this.v.btnregister.addActionListener(this);
        //this.cargarCategorias();
        //this.cargarinvactual();
        this.mostrarRoles();
        //this.mostrarTiposPago();
        //this.mostrarRolesMeseros();
        //this.mostrarProductosAsociados();
        //this.v.ivcategoria.addActionListener(this);
        //this.mostrarRoles(ROL_MESERO, v.comboMesero);
        //this.mostrarRoles(ROL_CAJERO, v.comboCajero);
        
        this.mostrarRoles();
        this.mostrarTiposPago();
        this.mostrarRolesMeseros();
        this.mostrarRoles(ROL_MESERO, v.comboMeseros);
        this.mostrarRoles(ROL_CAJERO, v.comboCajeros);
        
        
        mostrarProductos(modeloinv.obtenerTodosLosProductos());
        mostrarMesas(modeloMesa.Buscar_mesas());
        v.opc1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ocultar menus
                v.AGREGARPRODUCTO.setVisible(false);
                v.INGRESARPEDIDOS.setVisible(false);
                v.GENERARFACTURA.setVisible(false);
                v.ELEGIRMESA.setVisible(false);
                v.REGISTRARCLIENTE.setVisible(false);
                v.CONSULTARINVENTARIO.setVisible(false);
                v.INICIO.setVisible(true);
                v.CREARUSUARIO.setVisible(false);

                //color al seleccionar X boton
                v.opc1.setBackground(Color.CYAN);
                v.opc2.setBackground(new Color(0,0,0));
                v.opc3.setBackground(new Color(0,0,0));
                v.opc4.setBackground(new Color(0,0,0));
                v.opc5.setBackground(new Color(0,0,0));
                v.opc6.setBackground(new Color(0,0,0));
                v.opc7.setBackground(new Color(0,0,0));
                v.opc8.setBackground(new Color(0,0,0));
            }
        });
        v.opc2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ocultar menus
                v.AGREGARPRODUCTO.setVisible(false);
                v.INGRESARPEDIDOS.setVisible(false);
                v.GENERARFACTURA.setVisible(false);
                v.ELEGIRMESA.setVisible(true);
                v.REGISTRARCLIENTE.setVisible(false);
                v.CONSULTARINVENTARIO.setVisible(false);
                v.INICIO.setVisible(false);
                v.CREARUSUARIO.setVisible(false);

                //color al seleccionar X boton
                v.opc1.setBackground(new Color(0,0,0));
                v.opc2.setBackground(Color.CYAN);
                v.opc3.setBackground(new Color(0,0,0));
                v.opc4.setBackground(new Color(0,0,0));
                v.opc5.setBackground(new Color(0,0,0));
                v.opc6.setBackground(new Color(0,0,0));
                v.opc7.setBackground(new Color(0,0,0));
                v.opc8.setBackground(new Color(0,0,0));
            }
        });
        v.opc3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ocultar menus
                v.AGREGARPRODUCTO.setVisible(false);
                v.INGRESARPEDIDOS.setVisible(true);
                v.GENERARFACTURA.setVisible(false);
                v.ELEGIRMESA.setVisible(false);
                v.REGISTRARCLIENTE.setVisible(false);
                v.CONSULTARINVENTARIO.setVisible(false);
                v.INICIO.setVisible(false);
                v.CREARUSUARIO.setVisible(false);

                //color al seleccionar X boton
                v.opc1.setBackground(new Color(0,0,0));
                v.opc2.setBackground(new Color(0,0,0));
                v.opc3.setBackground(Color.CYAN);
                v.opc4.setBackground(new Color(0,0,0));
                v.opc5.setBackground(new Color(0,0,0));
                v.opc6.setBackground(new Color(0,0,0));
                v.opc7.setBackground(new Color(0,0,0));
                v.opc8.setBackground(new Color(0,0,0));
            }
        });
        v.opc4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ocultar menus
                v.AGREGARPRODUCTO.setVisible(false);
                v.INGRESARPEDIDOS.setVisible(false);
                v.GENERARFACTURA.setVisible(false);
                v.ELEGIRMESA.setVisible(false);
                v.REGISTRARCLIENTE.setVisible(true);
                v.CONSULTARINVENTARIO.setVisible(false);
                v.INICIO.setVisible(false);
                v.CREARUSUARIO.setVisible(false);

                //color al seleccionar X boton
                v.opc1.setBackground(new Color(0,0,0));
                v.opc2.setBackground(new Color(0,0,0));
                v.opc3.setBackground(new Color(0,0,0));
                v.opc4.setBackground(Color.CYAN);
                v.opc5.setBackground(new Color(0,0,0));
                v.opc6.setBackground(new Color(0,0,0));
                v.opc7.setBackground(new Color(0,0,0));
                v.opc8.setBackground(new Color(0,0,0));
            }
        });
        v.opc5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ocultar menus
                v.AGREGARPRODUCTO.setVisible(false);
                v.INGRESARPEDIDOS.setVisible(false);
                v.GENERARFACTURA.setVisible(true);
                v.ELEGIRMESA.setVisible(false);
                v.REGISTRARCLIENTE.setVisible(false);
                v.CONSULTARINVENTARIO.setVisible(false);
                v.INICIO.setVisible(false);
                v.CREARUSUARIO.setVisible(false);

                //color al seleccionar X boton
                v.opc1.setBackground(new Color(0,0,0));
                v.opc2.setBackground(new Color(0,0,0));
                v.opc3.setBackground(new Color(0,0,0));
                v.opc4.setBackground(new Color(0,0,0));
                v.opc5.setBackground(Color.CYAN);
                v.opc6.setBackground(new Color(0,0,0));
                v.opc7.setBackground(new Color(0,0,0));
                v.opc8.setBackground(new Color(0,0,0));
            }
        });
        v.opc6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ocultar menus
                v.AGREGARPRODUCTO.setVisible(true);
                v.INGRESARPEDIDOS.setVisible(false);
                v.GENERARFACTURA.setVisible(false);
                v.ELEGIRMESA.setVisible(false);
                v.REGISTRARCLIENTE.setVisible(false);
                v.CONSULTARINVENTARIO.setVisible(false);
                v.INICIO.setVisible(false);
                v.CREARUSUARIO.setVisible(false);

                //color al seleccionar X boton
                v.opc1.setBackground(new Color(0,0,0));
                v.opc2.setBackground(new Color(0,0,0));
                v.opc3.setBackground(new Color(0,0,0));
                v.opc4.setBackground(new Color(0,0,0));
                v.opc5.setBackground(new Color(0,0,0));
                v.opc6.setBackground(Color.CYAN);
                v.opc7.setBackground(new Color(0,0,0));
                v.opc8.setBackground(new Color(0,0,0));
            }
        });
        v.opc7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ocultar menus
                v.AGREGARPRODUCTO.setVisible(false);
                v.INGRESARPEDIDOS.setVisible(false);
                v.GENERARFACTURA.setVisible(false);
                v.ELEGIRMESA.setVisible(false);
                v.REGISTRARCLIENTE.setVisible(false);
                v.CONSULTARINVENTARIO.setVisible(true);
                v.INICIO.setVisible(false);
                v.CREARUSUARIO.setVisible(false);

                //color al seleccionar X boton
                v.opc1.setBackground(new Color(0,0,0));
                v.opc2.setBackground(new Color(0,0,0));
                v.opc3.setBackground(new Color(0,0,0));
                v.opc4.setBackground(new Color(0,0,0));
                v.opc5.setBackground(new Color(0,0,0));
                v.opc6.setBackground(new Color(0,0,0));
                v.opc7.setBackground(Color.CYAN);
                v.opc8.setBackground(new Color(0,0,0));
            }
        });
        v.opc8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //ocultar menus
                v.AGREGARPRODUCTO.setVisible(false);
                v.INGRESARPEDIDOS.setVisible(false);
                v.GENERARFACTURA.setVisible(false);
                v.ELEGIRMESA.setVisible(false);
                v.REGISTRARCLIENTE.setVisible(false);
                v.CONSULTARINVENTARIO.setVisible(false);
                v.INICIO.setVisible(false);
                v.CREARUSUARIO.setVisible(true);

                //color al seleccionar X boton
                v.opc1.setBackground(new Color(0,0,0));
                v.opc2.setBackground(new Color(0,0,0));
                v.opc3.setBackground(new Color(0,0,0));
                v.opc4.setBackground(new Color(0,0,0));
                v.opc5.setBackground(new Color(0,0,0));
                v.opc6.setBackground(new Color(0,0,0));
                v.opc7.setBackground(new Color(0,0,0));
                v.opc8.setBackground(Color.CYAN);
            }
        });
        v.opc9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                v.setVisible(false);
                log.setVisible(true);   
            }
        });
        log.iniciodesesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                autenticarUsuarios();
                limpiar(log.Usuario,log.Pass);
            }
        });
    }

    private void autenticarUsuarios() {

        String usuario = log.Usuario.getText();
        String clave = new String(log.Pass.getPassword());
        if (modeloEmple.autenticarUsuarios(usuario, clave, 1)) {
            JOptionPane.showMessageDialog(null, "Bienvenido/a al sistema " + usuario);
            v.jLabel23.setText("Bienvenidos Usuario Adminitrador "+usuario);
            v.jLabel4.setText("Bienvenidos Usuario Adminitrador "+usuario);
            v.jLabel8.setText("Bienvenidos Usuario Adminitrador "+usuario);
            v.jLabel34.setText("Bienvenidos Usuario Adminitrador "+usuario);
            v.jLabel37.setText("Bienvenidos Usuario Adminitrador "+usuario);
            v.jLabel48.setText("Bienvenidos Usuario Adminitrador "+usuario);
            v.jLabel50.setText("Bienvenidos Usuario Adminitrador "+usuario);
            v.jLabel52.setText("Bienvenidos Usuario Adminitrador "+usuario);
            log.setVisible(false);
            v.setVisible(true);
            v.opc6.setVisible(true);
            v.opc7.setVisible(true);
            v.opc8.setVisible(true);
        } else if (modeloEmple.autenticarUsuarios(usuario, clave, 2)) {
            JOptionPane.showMessageDialog(null, "Bienvenido/a al sistema " + usuario);
            //V.bienvenida.setText("Bienvenidos Usuario Adminitrador "+usuario);
            v.jLabel23.setText("Bienvenidos Usuario Cajero "+usuario);
            v.jLabel4.setText("Bienvenidos Usuario Cajero "+usuario);
            v.jLabel8.setText("Bienvenidos Usuario Cajero "+usuario);
            v.jLabel34.setText("Bienvenidos Usuario Cajero "+usuario);
            v.jLabel37.setText("Bienvenidos Usuario Cajero "+usuario);
            v.jLabel48.setText("Bienvenidos Usuario Cajero "+usuario);
            v.jLabel50.setText("Bienvenidos Usuario Cajero "+usuario);
            v.jLabel52.setText("Bienvenidos Usuario Cajero "+usuario);
            log.setVisible(false);
            v.setVisible(true);
            v.opc6.setVisible(false);
            v.opc7.setVisible(false);
            v.opc8.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(null, "Error, intente de nuevo");
            log.Usuario.requestFocus();
        }
    }

    private void registrarCliente() {

        String nombre = v.txtNombreC.getText();
        String apellido = v.txtApellidoC.getText();
        String cedula = v.txtCedulaC.getText();
        String direccion = v.txtDireccionC.getText();
        String telefono = v.txtTelefonoC.getText();

        Reg_Cliente newClie = new Reg_Cliente(nombre, apellido, cedula, direccion, telefono);

        modeloCli.registrarCliente(newClie);
    }

    private void registrarEmpleado() {
        String nombre = v.txtNombreEmpleadoE.getText();
        String apellido = v.txtApellidoEmpleadoE.getText();
        String cedula = v.txtCedulaEmpleadoE.getText();
        String telefono = v.txtTelefonoEmpleadoE.getText();
        String usuario = v.txtUsuarioE.getText();
        String contraseña = v.txtContraseñaE.getText();
        int rol = v.comboRoles.getSelectedIndex();

        Reg_Empleados newEmple = new Reg_Empleados(nombre, apellido, cedula, telefono, usuario, contraseña, rol);

        modeloEmple.registrarEmpleados(newEmple);
    }
    private void generarFactura(){
        try {
            
            String tpS = (String) v.comboTipoP.getSelectedItem();
            String rEmpleado = (String) v.comboCajeros.getSelectedItem();
            String rEmpleado2 = (String) v.comboMeseros.getSelectedItem();
            Reg_Empleados emple;
            
            int id_cliente = Integer.parseInt(v.txtCliente.getText());
            Tipo_pago tpE = obtenerID(tpS);
            int tipoP = tpE.getId_tipoP();
            
            emple = obtenerIDEmpleados(rEmpleado2);
            int id_mesero = emple.getId_emple();
            emple = obtenerIDEmpleados(rEmpleado);
            int id_cajero = emple.getId_emple();
            String num_fact = "1";
            double descuento = Double.parseDouble(v.txtDesc.getText());
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
    private void mostrarRolesMeseros() {
        ArrayList<Reg_Empleados> listaR = modeloEmple.obtenerEmpleados();
        v.comboMeseros.removeAllItems();
        v.comboMeseros.addItem("Seleccionar");
        for (int i = 0; i < listaR.size(); i++) {
            Reg_Empleados rol = listaR.get(i);
            if (rol.getRol() == 3) {
                v.comboMeseros.addItem(rol.getNom_emple());
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
        v.comboTipoP.removeAllItems();
        v.comboTipoP.addItem("Seleccionar");
        for (int i = 0; i < listaT.size(); i++) {
            v.comboTipoP.addItem(listaT.get(i).getNom_tipoP());
        }
    }
    
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
    }

    private void generarFactura(){
        try {
            
            String tpS = (String) v.comboTipoP.getSelectedItem();
            String rEmpleado = (String) v.comboCajero.getSelectedItem();
            String rEmpleado2 = (String) v.comboMesero.getSelectedItem();
            Reg_Empleados emple;
            
            int id_cliente = Integer.parseInt(v.txtCliente.getText());
            Tipo_pago tpE = obtenerID(tpS);
            int tipoP = tpE.getId_tipoP();
            
            emple = obtenerIDEmpleados(rEmpleado2);
            int id_mesero = emple.getId_emple();
            emple = obtenerIDEmpleados(rEmpleado);
            int id_cajero = emple.getId_emple();
            String num_fact = "1";
            double descuento = Double.parseDouble(v.txtDesc.getText());
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
    
    /*private void registrarMesa(){
        int id = modeloMesa.devolverId() + 1;
        int cantSillas = Integer.parseInt(v.txtCantidadSillas.getText());
        String tipo = v.txtComboTipos.getSelectedIndex()+1;
        String estado = v.txtComboEstado.getSelectedIndex()+1;
        
        mesa.setId(id); mesa.setCant_sillas(cantSillas);
        mesa.setTipo(tipo); mesa.setEstado(estado);
        
        modeloMesa.
        
    }
    private void cargarCategorias() {
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
    }
    
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
    }*/
    private void mostrarRoles() {
        ArrayList<Emple_rol> listaR = modeloRol.obtenerRolesP();
        v.comboRoles.addItem("Seleccionar");
        for (int i = 0; i < listaR.size(); i++) {
            v.comboRoles.addItem(listaR.get(i).getNom_rol());
        }
    }

    /*private void mostrarRolesMeseros() {
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
        v.comboTipoP.removeAllItems();
        v.comboTipoP.addItem("Seleccionar");
        for (int i = 0; i < listaT.size(); i++) {
            v.comboTipoP.addItem(listaT.get(i).getNom_tipoP());
        }
    }*/
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
    private void consultarInventario() {
        try {
            String inicio = v.jtffechainicio.getText();
            String fin = v.jtffechafinal.getText();
            String nombre = v.jtfingredienteaconsulta.getText();
            if (nombre != null && nombre.isEmpty()) {
                nombre = null; // Si el nombre está vacío, lo establecemos a null
            }
            ArrayList<Inven_ingrediente> productos = modeloinv.buscarProductos(inicio, fin, nombre);
            mostrarProductos(productos);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
        }
    }

    private void mostrarProductos(ArrayList<Inven_ingrediente> productos) {
        DefaultTableModel tm = (DefaultTableModel) v.jtblsalidainvetario.getModel();
        tm.setRowCount(0); // Limpia la tabla
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        for (Inven_ingrediente producto : productos) {
            String fechaFormateada = format.format(producto.getFecha());
            tm.addRow(new Object[]{producto.getId(), producto.getNombre(), producto.getCantidad(), fechaFormateada});
        }
    }
    
        private void mostrarMesas(ArrayList<Mesa> productos) {
        DefaultTableModel tm = (DefaultTableModel) v.jtblmesa.getModel();
        tm.setRowCount(0); // Limpia la tabla
        for (Mesa producto : productos) {
            tm.addRow(new Object[]{producto.getId_mesa(), producto.getCant_sillas(), producto.getEstado(), producto.getTipo()});
        }
    }
    private void ocupado(){
        modeloMesa.Ocupado(1);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if (e.getSource() == log.ingresar) {
            autenticarUsuarios();
        }*/
        if (e.getSource() == v.btconsultarinventario) {
            consultarInventario();
            limpiar(v.jtfingredienteaconsulta);
        }
        if (e.getSource() == v.Btnmesaocupada) {
            ocupado();
        }
        if (e.getSource() == v.Btnmesadisponible) {
            modeloMesa.Disponible(1);
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
        }*/ else if (e.getSource() == v.btnRegistrarCliente) {
            if (camposVacios(v.txtNombreC, v.txtApellidoC, v.txtCedulaC, v.txtTelefonoC, v.txtDireccionC)) {
                JOptionPane.showMessageDialog(v, "Por favor, llena todos los campos");
            } else {
                registrarEmpleado();
                JOptionPane.showMessageDialog(null, "cliente registrado con exito");
                limpiar(v.txtNombreC, v.txtApellidoC, v.txtCedulaC, v.txtTelefonoC, v.txtDireccionC);
            }
        }/* else if (e.getSource() == v.btnregister) {
            if (camposVacios(v.txtcodigo, v.txtnombre, v.txtprecio, v.txtcantidad)) {
                JOptionPane.showMessageDialog(v, "Por favor, llena todos los campos");
            } else {
                registrarProducto();
                limpiar(v.txtcodigo, v.txtnombre, v.txtprecio, v.txtcantidad);
            }
        }*/ else if (e.getSource() == v.btnRegistrarEmpleado) {
            if (camposVacios(v.txtNombreEmpleadoE, v.txtApellidoEmpleadoE, v.txtCedulaEmpleadoE, v.txtTelefonoEmpleadoE, v.txtUsuarioE, v.txtContraseñaE)) {
                JOptionPane.showMessageDialog(v, "Por favor, llena todos los campos");
            } else {
                registrarCliente();
                JOptionPane.showMessageDialog(null, "Empleado registrado con exito");
                limpiar(v.txtNombreEmpleadoE, v.txtApellidoEmpleadoE, v.txtCedulaEmpleadoE, v.txtTelefonoEmpleadoE, v.txtUsuarioE, v.txtContraseñaE);
            }
        }/* else if (e.getSource() == v.btnGenerarFactura) {
            generarFactura(); // Esta parte está comentada, asegúrate de implementarla correctamente
        }*/
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
