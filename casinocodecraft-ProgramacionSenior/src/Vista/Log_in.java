
package Vista;


import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;


public class Log_in extends javax.swing.JFrame {

  //INICIAR SESION BY xDEFT
    
    public Log_in() {
        initComponents();
        setLocationRelativeTo(null); //Centra la vantana en la pantalla
        Shape forma = new RoundRectangle2D.Double(0, 0, getBounds().width, getBounds().height, 20, 20);
        
       
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        Pass = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        panelRedondo2 = new Modelo.PanelRedondo();
        iniciodesesion = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(73, 181, 172));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_log/ssstik.io_1712291558701.gif"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 380, 580));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabel3.setText("INICIA SESION EN TU CUENTA");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, 53));

        jLabel4.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel4.setText("USUARIO");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        jLabel5.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        jLabel5.setText("CONTRASEÑA");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        Usuario.setFont(new java.awt.Font("Gotham Thin", 0, 18)); // NOI18N
        Usuario.setBorder(null);
        Usuario.setCaretColor(new java.awt.Color(73, 181, 172));
        jPanel2.add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 270, 40));

        jSeparator1.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator1.setForeground(new java.awt.Color(73, 181, 172));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 310, 10));

        Pass.setFont(Pass.getFont().deriveFont(Pass.getFont().getSize()+7f));
        Pass.setBorder(null);
        Pass.setCaretColor(new java.awt.Color(73, 181, 172));
        jPanel2.add(Pass, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 380, 270, 36));

        jSeparator2.setBackground(new java.awt.Color(73, 181, 172));
        jSeparator2.setForeground(new java.awt.Color(73, 181, 172));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 310, 10));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_log/icons8-male-user-25.png"))); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 48, 36));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes_log/icons8_Lock_25px.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 48, 42));

        jLabel9.setFont(new java.awt.Font("Gotham Thin", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(73, 181, 172));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("x");
        jLabel9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel9MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 40, 50));

        panelRedondo2.setBackground(new java.awt.Color(73, 181, 172));
        panelRedondo2.setRoundBottomLeft(50);
        panelRedondo2.setRoundBottomRight(50);
        panelRedondo2.setRoundTopLeft(50);
        panelRedondo2.setRoundTopRight(50);

        iniciodesesion.setFont(new java.awt.Font("Segoe UI Emoji", 0, 24)); // NOI18N
        iniciodesesion.setForeground(new java.awt.Color(255, 255, 255));
        iniciodesesion.setText("INGRESAR");

        javax.swing.GroupLayout panelRedondo2Layout = new javax.swing.GroupLayout(panelRedondo2);
        panelRedondo2.setLayout(panelRedondo2Layout);
        panelRedondo2Layout.setHorizontalGroup(
            panelRedondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRedondo2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(iniciodesesion)
                .addContainerGap(38, Short.MAX_VALUE))
        );
        panelRedondo2Layout.setVerticalGroup(
            panelRedondo2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelRedondo2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(iniciodesesion)
                .addContainerGap())
        );

        jPanel2.add(panelRedondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 470, 180, 50));

        jLabel8.setFont(new java.awt.Font("Gotham Thin", 0, 40)); // NOI18N
        jLabel8.setText("¡BIENVENIDO!");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 280, 53));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 420, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel9MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel9MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Log_in.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log_in().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPasswordField Pass;
    public javax.swing.JTextField Usuario;
    public javax.swing.JLabel iniciodesesion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public Modelo.PanelRedondo panelRedondo2;
    // End of variables declaration//GEN-END:variables
}
