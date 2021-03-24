package mx.maxitoners.vistas;

public class MostrarInventario extends javax.swing.JFrame {

    public MostrarInventario() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAgregarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnResaltarExistencia = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Mostrar inventario");

        btnAgregarProducto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAgregarProducto.setText("Agregar producto");

        btnEditarProducto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEditarProducto.setText("Editar producto");

        btnEliminarProducto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEliminarProducto.setText("Eliminar producto");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio unitario", "Disponibles"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnResaltarExistencia.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        btnResaltarExistencia.setText("Resaltar sin existencia");
        btnResaltarExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResaltarExistenciaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAgregarProducto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                                .addComponent(btnEditarProducto)))
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarProducto)
                        .addGap(19, 19, 19))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnResaltarExistencia)
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProducto)
                    .addComponent(btnEditarProducto)
                    .addComponent(btnEliminarProducto))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(btnResaltarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResaltarExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResaltarExistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnResaltarExistenciaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnResaltarExistencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
