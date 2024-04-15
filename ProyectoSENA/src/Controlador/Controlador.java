package Controlador;

import Modelo.Gen_Factura;
import Vista.*;
import Modelo.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Time;
import java.util.Random;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;

public class Controlador implements ActionListener {

    public Vista v = new Vista();
    public Login l = new Login();
    private boolean isJPanelActive = false;

    LoginU logU = new LoginU();
    Reg_ClienteDAO DAOC = new Reg_ClienteDAO();
    Reg_EmpleadosDAO DAOE = new Reg_EmpleadosDAO();
    Emple_rolDAO DAOR = new Emple_rolDAO();
    MesaDAO DAOM = new MesaDAO();
    Tipo_pagoDAO DAOTP = new Tipo_pagoDAO();
    Gen_FacturaDAO DAOGF = new Gen_FacturaDAO();
    InventarioDAO modeloInv = new InventarioDAO();
    IngredientesDAO ingrediente = new IngredientesDAO();
    Reg_ClienteDAO modeloCli = new Reg_ClienteDAO();
    Emple_rolDAO modeloRol = new Emple_rolDAO();
    MesaDAO modeloMesa = new MesaDAO();
    Reg_EmpleadosDAO modeloEmple = new Reg_EmpleadosDAO();
    ProductoDAO modeloPro = new ProductoDAO();
    CategoriasDAO modeloCat = new CategoriasDAO();
    PedidosDAO DAOP = new PedidosDAO();
    CarritoDAO DAOCa = new CarritoDAO();
    clsExportarExcel excel = new clsExportarExcel();

    public Controlador(Vista v) {
        this.v = v;
        this.l.btnIngresar.addActionListener(this);
        this.v.btnRegistrarCliente.addActionListener(this);
        this.v.btnRegistrarEmpleado.addActionListener(this);
        this.v.btnRegistrarMesa.addActionListener(this);
        this.v.btnexportarexcel.addActionListener(this);
        this.v.btconsultarinventario.addActionListener(this);
        this.v.btnAsociarProducto.addActionListener(this);
        this.v.btnEliminarCarrito.addActionListener(this);
        this.v.btnAgregarCarrito.addActionListener(this);
        this.v.btnregisterproducto.addActionListener(this);
        this.v.btnAgregarPedido.addActionListener(this);
        this.v.btnGenerarFactura.addActionListener(this);
        this.cargarCategorias();
        this.cargarinvactual();
        this.cargarMeseros();
        this.cargarMesas();
        this.cargarCajeros();
        this.cargarTipoP();
        this.cargarPedidos();
        this.mostrarProductosAsociados();
        this.v.ivcategoria.addActionListener(this);
        this.rolesE();
        this.actualizarTablaProductos();
        mostrarProductos(modeloInv.obtenerTodosLosProductos());
        this.v.Principal.addChangeListener((ChangeEvent e) -> {
            JTabbedPane tabbedPane = (JTabbedPane) e.getSource();
            int selectedIndex = tabbedPane.getSelectedIndex();
            if (selectedIndex == 8) {
                setJPanelState(true);
            } else {
                setJPanelState(false);
            }
        });
        this.v.comboPedidos.addItemListener((ItemEvent e) -> {
            if (e.getStateChange() == ItemEvent.SELECTED && isJPanelActive) {
                actualizarTotal();
            }
        });
    }

    private void setJPanelState(boolean state) {
        this.isJPanelActive = state;
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

    private void generarFactura() {
        try {
            Random random = new Random();
            Time time = new Time(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String horaFormateada = sdf.format(time);

            Tipo_pago tpS = (Tipo_pago) v.comboTipoP.getSelectedItem();
            String tipoP = tpS.getNom_tipoP();

            Reg_Empleados cajero = (Reg_Empleados) v.comboCajero.getSelectedItem();
            int idCaj = cajero.getId_emple();

            Pedidos pd = (Pedidos) v.comboPedidos.getSelectedItem();
            int mesero = pd.getMesero();
            int codigopedido = pd.getId();
            int id_cabe = random.nextInt(59999);
            int id_cliente = Integer.parseInt(v.txtCedC.getText());
            int num_fac = random.nextInt(999999999);
            double descuento = Double.parseDouble(v.txtDesc.getText());
            double IVA = 0.19;
            double aux = descuento * Double.parseDouble(v.totalpagofactura.getText());
            double total = Double.parseDouble(v.totalpagofactura.getText()) - aux;
            Date currentDate = new Date(System.currentTimeMillis());
            SimpleDateFormat amd = new SimpleDateFormat("dd/MM/yy");
            String fecha = amd.format(currentDate);

            Gen_Factura factura = new Gen_Factura(id_cabe, id_cliente, mesero, tipoP, idCaj, descuento, IVA, total, num_fac, horaFormateada, fecha);
            DAOGF.getGenerarFact(factura);
            DAOP.getActualizarIdFactura(codigopedido, id_cabe);
            DAOP.getActualizarpedido(codigopedido);

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void generarFactTXT() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Factura_genrado.txt"))) {
            ArrayList<Gen_Factura> facDet = DAOGF.getFacturaTXT();
            for (Gen_Factura factura : facDet) {
                writer.println("====================");
                writer.println("      FACTURA      ");
                writer.println("====================");
                writer.println();
                writer.println("Fecha: " + factura.getFecha());
                writer.println("Hora: " + factura.getHoraFormateada());
                writer.println("Número de Factura: " + factura.getNum_fac());
                writer.println("Cédula Cliente: " + factura.getId_cliente());
                writer.println("ID Cajero: " + factura.getIdCaj());
                writer.println("ID Mesero: " + factura.getMesero());
                writer.println("Tipo Pago: " + factura.getTipoP());
                writer.println();
                writer.println("------------------------------------------------------");
                writer.println();
                writer.println("Producto             Precio unitario     Cantidad      Total");
                writer.println("----------------------------------------------------------------");

                List<Carrito> prod = DAOCa.obtenerCarritoPorFactura(factura.getId_cabe());

                for (Carrito car : prod) {
                    writer.printf("%-30s%10s%15d%15s%n", car.getProd(), String.format("$%,d", (int) car.getPrecio()), car.getCantidad(), String.format("$%,d", (int) car.getTotal()));
                }

                writer.println("------------------------------------------------------");
                writer.println();
                writer.println("Descuento: " + String.format("%.2f%%", factura.getDescuento() * 100));
                writer.println("Impuesto (%): " + factura.getIVA());
                writer.println("Total a pagar: " + String.format("$%,d", (int) factura.getTotal()));
                writer.println();
                writer.println("====================");
                writer.println("   Gracias por su compra   ");
                writer.println("====================");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    private void agregarPedido() {
        try {
            Time time = new Time(System.currentTimeMillis());
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String horaFormateada = sdf.format(time);
            Mesa SeleccID = (Mesa) v.comboMesa.getSelectedItem();
            int idMesa = SeleccID.getId_mesa();
            Reg_Empleados SeleccIDMesero = (Reg_Empleados) v.comboMesero.getSelectedItem();
            int idMesero = SeleccIDMesero.getId_emple();
            int id_p = Integer.parseInt(v.pedidoID.getText());
            int filas = v.tablaPedidos.getRowCount();
            System.out.println(filas);
            String estado = "Pendiente";
            for (int i = 0; i < filas; i++) {

                String producto = String.valueOf(v.tablaPedidos.getValueAt(i, 2));
                Object objCant = v.tablaPedidos.getValueAt(i, 4);
                String strCant = String.valueOf(objCant);
                int cant = Integer.parseInt(strCant);
                Object objPrecio = v.tablaPedidos.getValueAt(i, 3);
                String strPrecio = String.valueOf(objPrecio);
                double precio = Double.parseDouble(strPrecio);

                double total = precio * cant;

                Carrito car = new Carrito(id_p, producto, precio, cant, (int) total);
                System.out.println(car);
                DAOCa.registrarCarritoP(car);

            }

            Pedidos ped = new Pedidos(id_p, idMesa, idMesero, estado, horaFormateada);
            DAOP.registrarPedidoP(ped);

            DAOM.ocuparMesaP(idMesa);

            this.cargarMesas();

        } catch (NumberFormatException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(v, "Por favor, ingrese datos válidos");
        }
    }

    private void limpiarPedidos() {
        v.comboMesa.setSelectedIndex(0);
        v.comboMesero.setSelectedIndex(0);
        v.pedidoID.setText("");
        v.txtCantP.setText("");
        v.total.setText("0");

        v.comboMesa.setEnabled(true);
        v.comboMesero.setEnabled(true);
        v.pedidoID.setEnabled(true);
        DefaultTableModel modeloTabla = (DefaultTableModel) v.tablaPedidos.getModel();

        while (modeloTabla.getRowCount() > 0) {
            modeloTabla.removeRow(0);
        }
    }

    private boolean verificarCampos() {
        if (v.pedidoID.getText().isEmpty()) {
            v.pedidoID.requestFocus();
            return false;
        } else if (v.comboMesa.getSelectedIndex() == 0) {
            v.comboMesa.setPopupVisible(true);
            return false;
        } else if (v.comboMesero.getSelectedIndex() == 0) {
            v.comboMesero.setPopupVisible(true);
            return false;
        } else if (v.txtCantP.getText().isEmpty()) {
            v.txtCantP.requestFocus();
            return false;
        }
        return true;
    }

    private void IngresarCarrito() {
        if (verificarCampos()) {
            v.comboMesa.setEnabled(false);
            v.comboMesero.setEnabled(false);
            v.pedidoID.setEnabled(false);

            // Elimina el signo de peso y los separadores de miles antes de convertir a entero
            String textoSinFormato = v.total.getText().replace("$", "").replace(".", "");
            int suma = Integer.parseInt(textoSinFormato);

            String mesero = v.comboMesero.getSelectedItem().toString();
            String mesa = v.comboMesa.getSelectedItem().toString();
            int cant = Integer.parseInt(v.txtCantP.getText());
            int ind = v.tablaP.getSelectedRow();
            String producto = String.valueOf(v.tablaP.getValueAt(ind, 0));
            double precio = Double.parseDouble(String.valueOf(v.tablaP.getValueAt(ind, 2)));
            double totalM = precio * cant;
            int totalAP = suma + (int) totalM;

            // Formatea el total con puntos de mil y el signo de peso
            String valor = String.format("$%,d", totalAP).replace(",", ".");

            v.total.setText(valor); // Establece el texto con el signo de peso y puntos de mil

            DefaultTableModel tabla = (DefaultTableModel) v.tablaPedidos.getModel();
            Object[] fila = {mesa, mesero, producto, precio, cant};
            tabla.addRow(fila);

            v.txtCantP.setText("");
        } else {
            System.out.println("Favor llenar los campos");
        }
    }

    private void eliminarFilaSeleccionada() {
        int indiceSeleccionado = v.tablaPedidos.getSelectedRow();

        if (indiceSeleccionado != -1) {
            DefaultTableModel modeloTabla = (DefaultTableModel) v.tablaPedidos.getModel();

            int cantidad = Integer.parseInt(v.tablaPedidos.getValueAt(indiceSeleccionado, 4).toString());
            double precio = Double.parseDouble(v.tablaPedidos.getValueAt(indiceSeleccionado, 3).toString());

            String textoSinFormatoTotal = v.total.getText().replace("$", "").replace(".", "");
            int totalActual = Integer.parseInt(textoSinFormatoTotal) - (int) (precio * cantidad); // Convertir a int

            String nuevoTotal = String.format("$%,d", totalActual).replace(",", "."); // Usar %d para números enteros
            v.total.setText(nuevoTotal);

            modeloTabla.removeRow(indiceSeleccionado);
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void actualizarTablaProductos() {
        // Obtener el modelo de la tabla
        DefaultTableModel tm = (DefaultTableModel) v.tablaP.getModel();
        tm.setRowCount(0);

        // Obtener los productos y agregarlos a la tabla
        DefaultTableModel modelProductos = modeloPro.getProductos();
        for (int i = 0; i < modelProductos.getRowCount(); i++) {
            Object[] row = new Object[modelProductos.getColumnCount()];
            for (int j = 0; j < row.length; j++) {
                row[j] = modelProductos.getValueAt(i, j);
            }
            tm.addRow(row);
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

    private void cargarMeseros() {
        ArrayList<Reg_Empleados> meseros = modeloEmple.getObtenerEmpleados(3);
        cargarItems(meseros, v.comboMesero);
    }

    private void cargarCajeros() {
        ArrayList<Reg_Empleados> cajeros = modeloEmple.getObtenerEmpleados(2);
        cargarItems(cajeros, v.comboCajero);
    }

    private void cargarTipoP() {
        ArrayList<Tipo_pago> pago = DAOTP.obtenerTiposPP();
        cargarItems(pago, v.comboTipoP);
    }

    private void cargarPedidos() {
        ArrayList<Pedidos> pedidos = DAOP.getObtenerPedidos();
        cargarItems(pedidos, v.comboPedidos);
    }

    private void cargarMesas() {
        ArrayList<Mesa> mesas = modeloMesa.getObtenerMesas();
        cargarItems(mesas, v.comboMesa);
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

    private void rolesE() {
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

    private void actualizarTotal() {
        Pedidos pedidoSeleccionado = (Pedidos) v.comboPedidos.getSelectedItem();
        int idPedido = pedidoSeleccionado.getId();
        double total = DAOP.getTotalPedido(idPedido);
        v.totalpagofactura.setText(String.valueOf(total));
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

        if (e.getSource() == v.btnGenerarFactura) {
            generarFactura();
            generarFactTXT();
        }

        if (e.getSource() == v.btnEliminarCarrito) {
            eliminarFilaSeleccionada();
        }

        if (e.getSource() == v.btnexportarexcel) {
            try {
                excel.exportarExcel(v.jtblsalidainvetario);
            } catch (IOException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == v.btnRegistrarEmpleado) {
            registrarE();
        }

        if (e.getSource() == v.btnRegistrarMesa) {
            registrarM();
            this.cargarMesas();
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

        if (e.getSource() == v.btnAgregarCarrito) {
            IngresarCarrito();
        }

        if (e.getSource() == v.btnAgregarPedido) {
            agregarPedido();
            limpiarPedidos();
            this.cargarPedidos();
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
