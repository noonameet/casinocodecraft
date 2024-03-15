package View;

public class ingredientes extends javax.swing.JFrame {

    public ingredientes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbxcategorias = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbxproductos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtainvxproducto = new javax.swing.JTextArea();
        btnagregar = new javax.swing.JButton();
        btndevolver = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtainventario = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Seleccionar categoria:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, -1, -1));

        cbxcategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxcategoriasActionPerformed(evt);
            }
        });
        jPanel1.add(cbxcategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 160, -1));

        jLabel2.setText("Seleccionar producto:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        jPanel1.add(cbxproductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 160, -1));

        txtainvxproducto.setColumns(20);
        txtainvxproducto.setRows(5);
        jScrollPane1.setViewportView(txtainvxproducto);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 170, 140));

        btnagregar.setText(">>");
        jPanel1.add(btnagregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 250, 60, -1));

        btndevolver.setText("<<");
        jPanel1.add(btndevolver, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 60, -1));

        txtainventario.setColumns(20);
        txtainventario.setRows(5);
        jScrollPane2.setViewportView(txtainventario);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 170, 140));

        jLabel3.setText("Ingredientes del producto:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

        jLabel4.setText("Invertario actual:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 420, 180));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnbuscar.setText("Consultar");
        jPanel3.add(btnbuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 460, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 418, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxcategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxcategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxcategoriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnagregar;
    public javax.swing.JButton btnbuscar;
    public javax.swing.JButton btndevolver;
    public javax.swing.JComboBox<String> cbxcategorias;
    public javax.swing.JComboBox<String> cbxproductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTextArea txtainventario;
    public javax.swing.JTextArea txtainvxproducto;
    // End of variables declaration//GEN-END:variables
}
