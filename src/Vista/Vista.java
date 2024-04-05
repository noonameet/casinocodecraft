package Vista;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Vista extends javax.swing.JFrame {
    private Ventanas v = new Ventanas();

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
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Base.setBackground(new java.awt.Color(0, 0, 0));
        Base.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(164, 196, 181));

        Bienvenida.setBackground(new java.awt.Color(255, 255, 51));
        Bienvenida.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        Bienvenida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Bienvenida.setText("Bienvenida");

        IconoUsuario.setBackground(new java.awt.Color(255, 255, 255));
        IconoUsuario.setForeground(new java.awt.Color(255, 255, 255));
        IconoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png"))); // NOI18N

        NombreUsuario.setText("Rol");

        Conectado.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        Conectado.setForeground(new java.awt.Color(0, 255, 51));
        Conectado.setText("Online");

        ElegirMesa.setBackground(new java.awt.Color(164, 196, 181));
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

        GenerarFactura.setBackground(new java.awt.Color(164, 196, 181));
        GenerarFactura.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        GenerarFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/factura.png"))); // NOI18N
        GenerarFactura.setText("Generar Factura");
        GenerarFactura.setOpaque(true);

        Pedido.setBackground(new java.awt.Color(164, 196, 181));
        Pedido.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 16)); // NOI18N
        Pedido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/Pedido.png"))); // NOI18N
        Pedido.setText("Pedidos");
        Pedido.setOpaque(true);

        RegistrarCliente.setBackground(new java.awt.Color(164, 196, 181));
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
                    .addComponent(Pedido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addComponent(IconoUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Conectado)
                            .addComponent(NombreUsuario))
                        .addContainerGap())
                    .addComponent(ElegirMesa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
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
                .addGap(78, 78, 78)
                .addComponent(ElegirMesa)
                .addGap(28, 28, 28)
                .addComponent(Pedido)
                .addGap(30, 30, 30)
                .addComponent(RegistrarCliente)
                .addGap(27, 27, 27)
                .addComponent(GenerarFactura)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        Base.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 510));

        javax.swing.GroupLayout CabeceraLayout = new javax.swing.GroupLayout(Cabecera);
        Cabecera.setLayout(CabeceraLayout);
        CabeceraLayout.setHorizontalGroup(
            CabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 690, Short.MAX_VALUE)
        );
        CabeceraLayout.setVerticalGroup(
            CabeceraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        Base.add(Cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 690, 40));

        Contenido.setBackground(new java.awt.Color(204, 0, 0));

        Escritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout EscritorioLayout = new javax.swing.GroupLayout(Escritorio);
        Escritorio.setLayout(EscritorioLayout);
        EscritorioLayout.setHorizontalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        EscritorioLayout.setVerticalGroup(
            EscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

        Base.add(Contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 40, 690, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Base, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void gestionarEventosMouse(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent evt) {
                label.setBackground(new Color(143, 196, 181));
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                label.setBackground(new Color(164, 196, 181));
            }
        });
    }
    
    private void ElegirMesaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElegirMesaMouseClicked
        
    }//GEN-LAST:event_ElegirMesaMouseClicked

    private void ElegirMesaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElegirMesaMouseEntered

    }//GEN-LAST:event_ElegirMesaMouseEntered

    private void ElegirMesaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ElegirMesaMouseExited

    }//GEN-LAST:event_ElegirMesaMouseExited




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Base;
    public javax.swing.JLabel Bienvenida;
    private javax.swing.JPanel Cabecera;
    private javax.swing.JLabel Conectado;
    private javax.swing.JPanel Contenido;
    public javax.swing.JLabel ElegirMesa;
    public javax.swing.JDesktopPane Escritorio;
    public javax.swing.JLabel GenerarFactura;
    private javax.swing.JLabel IconoUsuario;
    private javax.swing.JPanel Menu;
    public javax.swing.JLabel NombreUsuario;
    public javax.swing.JLabel Pedido;
    public javax.swing.JLabel RegistrarCliente;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
