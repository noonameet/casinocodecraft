package Vista;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Vista extends javax.swing.JFrame {


    public Vista() {
        initComponents();
        gestionarEventosMouse(ElegirMesa);
        gestionarEventosMouse(Pedido);
        gestionarEventosMouse(RegistrarCliente);
        gestionarEventosMouse(GenerarFactura);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VentanaMesas = new javax.swing.JInternalFrame();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        comboTiposM = new javax.swing.JComboBox<>();
        btnOcuparMesa = new javax.swing.JButton();
        MesaCod = new javax.swing.JTextField();
        TituloMesa = new javax.swing.JLabel();
        Base = new javax.swing.JPanel();
        Menu = new javax.swing.JPanel();
        Bienvenida = new javax.swing.JLabel();
        IconoUsuario = new javax.swing.JLabel();
        NombreUsuario = new javax.swing.JLabel();
        Conectado = new javax.swing.JLabel();
        ElegirMesa = new javax.swing.JLabel();
        GenerarFactura = new javax.swing.JLabel();
        Pedido = new javax.swing.JLabel();
        RegistrarCliente = new javax.swing.JLabel();
        Cabecera = new javax.swing.JPanel();
        Contenido = new javax.swing.JPanel();
        Escritorio = new javax.swing.JDesktopPane();
        VentanaRegistrarC = new javax.swing.JInternalFrame();
        jInternalFrame2 = new javax.swing.JInternalFrame();
        jInternalFrame3 = new javax.swing.JInternalFrame();
        jInternalFrame4 = new javax.swing.JInternalFrame();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        VentanaMesas.setVisible(true);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnOcuparMesa.setText("Ocupar");

        TituloMesa.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TituloMesa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        TituloMesa.setText("Elegir Mesa");

        javax.swing.GroupLayout VentanaMesasLayout = new javax.swing.GroupLayout(VentanaMesas.getContentPane());
        VentanaMesas.getContentPane().setLayout(VentanaMesasLayout);
        VentanaMesasLayout.setHorizontalGroup(
            VentanaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaMesasLayout.createSequentialGroup()
                .addGroup(VentanaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VentanaMesasLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(VentanaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnOcuparMesa)
                            .addGroup(VentanaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(MesaCod, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(comboTiposM, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE))
                    .addGroup(VentanaMesasLayout.createSequentialGroup()
                        .addComponent(TituloMesa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        VentanaMesasLayout.setVerticalGroup(
            VentanaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(VentanaMesasLayout.createSequentialGroup()
                .addGroup(VentanaMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(VentanaMesasLayout.createSequentialGroup()
                        .addComponent(TituloMesa, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(comboTiposM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(MesaCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnOcuparMesa))
                    .addGroup(VentanaMesasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Base.setBackground(new java.awt.Color(0, 0, 0));
        Base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(0, 0, 204));

        Bienvenida.setBackground(new java.awt.Color(255, 255, 51));
        Bienvenida.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        Bienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bienvenida.setText("jLabel1");

        IconoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        IconoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        IconoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N

        NombreUsuario.setText("jLabel1");

        Conectado.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Conectado.setForeground(new java.awt.Color(0, 255, 51));
        Conectado.setText("Online");

        ElegirMesa.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        ElegirMesa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Mesa.png"))); // NOI18N
        ElegirMesa.setText("Mesas");
        ElegirMesa.setOpaque(true);
        ElegirMesa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ElegirMesaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ElegirMesaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ElegirMesaMouseExited(evt);
            }
        });

        GenerarFactura.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        GenerarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura.png"))); // NOI18N
        GenerarFactura.setText("Generar Factura");
        GenerarFactura.setOpaque(true);

        Pedido.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        Pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pedido.png"))); // NOI18N
        Pedido.setText("Pedidos");
        Pedido.setOpaque(true);

        RegistrarCliente.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        RegistrarCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Registrar.png"))); // NOI18N
        RegistrarCliente.setText("Registrar Cliente");
        RegistrarCliente.setOpaque(true);

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Bienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GenerarFactura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RegistrarCliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(ElegirMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(IconoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Conectado)
                            .addComponent(NombreUsuario))
                        .addContainerGap())))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addComponent(Bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(NombreUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Conectado))
                    .addComponent(IconoUsuario))
                .addGap(67, 67, 67)
                .addComponent(ElegirMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Pedido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RegistrarCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GenerarFactura)
                .addContainerGap(169, Short.MAX_VALUE))
        );

        Base.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 510));

        javax.swing.GroupLayout CabeceraLayout = new javax.swing.GroupLayout(Cabecera);
        Cabecera.setLayout(CabeceraLayout);
        CabeceraLayout.setHorizontalGroup(
            CabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        CabeceraLayout.setVerticalGroup(
            CabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        Base.add(Cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 570, 40));

        Contenido.setBackground(new java.awt.Color(204, 0, 0));

        VentanaRegistrarC.setVisible(true);

        javax.swing.GroupLayout VentanaRegistrarCLayout = new javax.swing.GroupLayout(VentanaRegistrarC.getContentPane());
        VentanaRegistrarC.getContentPane().setLayout(VentanaRegistrarCLayout);
        VentanaRegistrarCLayout.setHorizontalGroup(
            VentanaRegistrarCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 541, Short.MAX_VALUE)
        );
        VentanaRegistrarCLayout.setVerticalGroup(
            VentanaRegistrarCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 402, Short.MAX_VALUE)
        );

        jInternalFrame2.setVisible(true);

        javax.swing.GroupLayout jInternalFrame2Layout = new javax.swing.GroupLayout(jInternalFrame2.getContentPane());
        jInternalFrame2.getContentPane().setLayout(jInternalFrame2Layout);
        jInternalFrame2Layout.setHorizontalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );
        jInternalFrame2Layout.setVerticalGroup(
            jInternalFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jInternalFrame3.setVisible(true);

        javax.swing.GroupLayout jInternalFrame3Layout = new javax.swing.GroupLayout(jInternalFrame3.getContentPane());
        jInternalFrame3.getContentPane().setLayout(jInternalFrame3Layout);
        jInternalFrame3Layout.setHorizontalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );
        jInternalFrame3Layout.setVerticalGroup(
            jInternalFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 16, Short.MAX_VALUE)
        );

        jInternalFrame4.setVisible(true);

        javax.swing.GroupLayout jInternalFrame4Layout = new javax.swing.GroupLayout(jInternalFrame4.getContentPane());
        jInternalFrame4.getContentPane().setLayout(jInternalFrame4Layout);
        jInternalFrame4Layout.setHorizontalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
        );
        jInternalFrame4Layout.setVerticalGroup(
            jInternalFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        Escritorio.setLayer(VentanaRegistrarC, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(jInternalFrame2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(jInternalFrame3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        Escritorio.setLayer(jInternalFrame4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EscritorioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VentanaRegistrarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jInternalFrame2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jInternalFrame3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jInternalFrame4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EscritorioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VentanaRegistrarC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jInternalFrame3)
                        .addComponent(jInternalFrame2)
                        .addComponent(jInternalFrame4)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Escritorio)
        );

        Base.add(Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 570, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(107, 107, 107)
                    .addComponent(VentanaMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(107, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(VentanaMesas)
                    .addGap(38, 38, 38)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void gestionarEventosMouse(JLabel label) {
    label.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent evt) {
            label.setBackground(Color.red);
        }

        @Override
        public void mouseExited(MouseEvent evt) {
            label.setBackground(Color.green);
        }
    });
}
    
    private void ElegirMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElegirMesaMouseClicked

    }//GEN-LAST:event_ElegirMesaMouseClicked

    private void ElegirMesaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElegirMesaMouseEntered

    }//GEN-LAST:event_ElegirMesaMouseEntered

    private void ElegirMesaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElegirMesaMouseExited

    }//GEN-LAST:event_ElegirMesaMouseExited


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Base;
    private javax.swing.JLabel Bienvenida;
    private javax.swing.JPanel Cabecera;
    private javax.swing.JLabel Conectado;
    private javax.swing.JPanel Contenido;
    private javax.swing.JLabel ElegirMesa;
    private javax.swing.JDesktopPane Escritorio;
    private javax.swing.JLabel GenerarFactura;
    private javax.swing.JLabel IconoUsuario;
    private javax.swing.JPanel Menu;
    private javax.swing.JTextField MesaCod;
    private javax.swing.JLabel NombreUsuario;
    private javax.swing.JLabel Pedido;
    private javax.swing.JLabel RegistrarCliente;
    private javax.swing.JLabel TituloMesa;
    private javax.swing.JInternalFrame VentanaMesas;
    private javax.swing.JInternalFrame VentanaRegistrarC;
    private javax.swing.JButton btnOcuparMesa;
    private javax.swing.JComboBox<String> comboTiposM;
    private javax.swing.JInternalFrame jInternalFrame2;
    private javax.swing.JInternalFrame jInternalFrame3;
    private javax.swing.JInternalFrame jInternalFrame4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
