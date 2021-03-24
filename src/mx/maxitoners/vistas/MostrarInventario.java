package mx.maxitoners.vistas;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import mx.maxitoners.datos.Conexion;
import mx.maxitoners.negocio.Producto;

public class MostrarInventario extends javax.swing.JFrame {
    
    ArrayList<Producto> listaProductos;
    Conexion con;
    
    public MostrarInventario() {
        initComponents();
        setVisible(true);
        
        con = new Conexion();
        listaProductos = con.cargarTodos();
        rellenarTabla();
    }
    
    public void rellenarTabla(){
        DefaultTableModel dfl = (DefaultTableModel) tbl_productos.getModel();
        dfl.setRowCount(0);
        for (Producto p : listaProductos) {
            dfl.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                p.getCantidad(),
                p.getCategoria().getNombre()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnAgregarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_productos = new javax.swing.JTable();
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

        tbl_productos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Precio unitario", "Disponibles", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_productos.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbl_productos);
        if (tbl_productos.getColumnModel().getColumnCount() > 0) {
            tbl_productos.getColumnModel().getColumn(0).setResizable(false);
            tbl_productos.getColumnModel().getColumn(1).setResizable(false);
            tbl_productos.getColumnModel().getColumn(2).setResizable(false);
            tbl_productos.getColumnModel().getColumn(3).setResizable(false);
            tbl_productos.getColumnModel().getColumn(4).setResizable(false);
        }

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
    private javax.swing.JTable tbl_productos;
    // End of variables declaration//GEN-END:variables
}
