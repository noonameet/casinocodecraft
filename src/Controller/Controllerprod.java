package Controller;

import Model.Categorias;
import Model.Producto;
import Model.ProductoDAO;
import View.frm_productos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

public class Controllerprod implements ActionListener {

    private final ProductoDAO modelo;
    private final frm_productos vista;

    public Controllerprod(ProductoDAO modelo, frm_productos vista) {
        this.modelo = modelo;
        this.vista = vista;
        frm_productos.btnregister.addActionListener(this);
    }

    private void registrarDesdeFormulario() {
        try {
            int id_producto = Integer.parseInt(frm_productos.txtcodigo.getText());
            String nombre = frm_productos.txtnombre.getText();
            int precio = Integer.parseInt(frm_productos.txtprecio.getText());
            int id_categoria = frm_productos.combocategorias.getSelectedIndex();
            int cantidad = Integer.parseInt(frm_productos.txtcantidad.getText());

            Categorias categorias = new Categorias(id_categoria,"");
            Producto producto = new Producto(id_producto, nombre, precio, cantidad, categorias);

            modelo.Registrar(producto);
            JOptionPane.showMessageDialog(vista, "Registro exitoso");

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Por favor, ingrese datos válidos");
        }
    }

    private void limpiar() {
        frm_productos.txtcodigo.setText("");
        frm_productos.txtnombre.setText("");
        frm_productos.txtprecio.setText("");
        frm_productos.combocategorias.setSelectedIndex(0);
        frm_productos.txtcantidad.setText("");
        frm_productos.txtnombre.requestFocus();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == frm_productos.btnregister) {
            registrarDesdeFormulario();
            limpiar();
        }
    }
}
