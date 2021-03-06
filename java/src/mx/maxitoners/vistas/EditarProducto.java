package mx.maxitoners.vistas;

import java.awt.Color;
import javax.swing.JOptionPane;
import mx.maxitoners.datos.Conexion;
import mx.maxitoners.negocio.Categoria;
import mx.maxitoners.negocio.Producto;

public class EditarProducto extends javax.swing.JFrame {

    MostrarInventario main;
    Producto p;

    public EditarProducto(MostrarInventario main, Producto p) {
        this.main = main;
        this.p = p;
        initComponents();
        setLocationRelativeTo(main);
        tfNombreProductoA.setText(p.getNombre());
        tfCantidadProductoA.setText(String.valueOf(p.getCantidad()));
        tfPrecioProductoA.setText(String.valueOf(p.getPrecio()));
        for (Categoria cat : Categoria.values()) {
            cmboxCategoriaA.addItem(cat.getNombre());
        }
        cmboxCategoriaA.setSelectedIndex(p.getCategoria().getId() - 1);
        txtEstado.setForeground(Color.WHITE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button1 = new java.awt.Button();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        tfNombreProductoA = new javax.swing.JTextField();
        tfCantidadProductoA = new javax.swing.JTextField();
        tfPrecioProductoA = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cmboxCategoriaA = new javax.swing.JComboBox<>();
        txtEstado = new javax.swing.JLabel();

        button1.setLabel("button1");

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maxitoners");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Editar producto", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 24))); // NOI18N

        jLabel1.setText("Nombre del producto:");

        jLabel2.setText("Cantidad del producto:");

        jLabel3.setText("Precio del producto:");

        jLabel4.setText("Categoria del producto:");

        btnAgregar.setBackground(new java.awt.Color(4, 173, 238));
        btnAgregar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnAgregar.setText("Editar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(4, 173, 238));
        btnCancelar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        cmboxCategoriaA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmboxCategoriaAActionPerformed(evt);
            }
        });

        txtEstado.setForeground(new java.awt.Color(255, 0, 51));
        txtEstado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtEstado.setText("CARGANDO...");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 354, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmboxCategoriaA, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(108, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                        .addGap(101, 101, 101)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfPrecioProductoA, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                                .addComponent(tfCantidadProductoA, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(tfNombreProductoA, javax.swing.GroupLayout.Alignment.LEADING)))))
                .addGap(45, 45, 45))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNombreProductoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCantidadProductoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfPrecioProductoA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cmboxCategoriaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEstado)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = tfNombreProductoA.getText().trim();
        if (nombre.length() == 0) {
            JOptionPane.showMessageDialog(this, "Debes ingresar un nombre", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int cantidad = 0;
        try {
            cantidad = Integer.parseInt(tfCantidadProductoA.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debes ingresar un numero para cantidad valido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double precio = 0;
        try {
            precio = Double.parseDouble(tfPrecioProductoA.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Debes ingresar un numero para precio valido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int categoria = cmboxCategoriaA.getSelectedIndex() + 1;
        
        Producto ptemp = new Producto();
        ptemp.setId(p.getId());
        ptemp.setNombre(nombre);
        ptemp.setCantidad(cantidad);
        ptemp.setPrecio(precio);
        ptemp.setCategoria(Categoria.getCategoria(categoria));

        btnAgregar.setEnabled(false);
        btnCancelar.setEnabled(false);
        
        txtEstado.setForeground(Color.RED);

        Conexion.editarProducto(this, ptemp);
    }//GEN-LAST:event_btnAgregarActionPerformed

    public void cerrar(boolean reload) {
        main.setVisible(true);
        if (reload) main.obtenerProductos();
        this.setVisible(false);
        this.dispose();
    }

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cerrar(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmboxCategoriaAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmboxCategoriaAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmboxCategoriaAActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAgregar;
    public javax.swing.JButton btnCancelar;
    private java.awt.Button button1;
    private javax.swing.JComboBox<String> cmboxCategoriaA;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tfCantidadProductoA;
    private javax.swing.JTextField tfNombreProductoA;
    private javax.swing.JTextField tfPrecioProductoA;
    public javax.swing.JLabel txtEstado;
    // End of variables declaration//GEN-END:variables
}
