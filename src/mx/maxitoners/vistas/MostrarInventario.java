package mx.maxitoners.vistas;

import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import mx.maxitoners.datos.Conexion;
import mx.maxitoners.negocio.Producto;

public class MostrarInventario extends javax.swing.JFrame {

    private ArrayList<Producto> listaProductos = new ArrayList<>();
    private ArrayList<Integer> agotadosRows = new ArrayList<Integer>();
    private boolean isResaltarEnabled = false;

    private int selectedRow = -1;

    public MostrarInventario() {
        initComponents();
        setVisible(true);
        ImageIcon maxitoners = new ImageIcon(getClass().getResource("/Imagenes/Maxitoners.png"));
        ImageIcon imagen = new ImageIcon(maxitoners.getImage().getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_DEFAULT));
        lblLogo.setIcon(imagen);

        btnRecargar.setEnabled(false);
        obtenerProductos();
    }

    public void obtenerProductos() {
        txtEstado.setForeground(Color.RED);
        selectedRow = -1;
        getListaProductos().clear();
        tbl_productos.repaint();
        
        Conexion.verProductos(this);
    }

    public void rellenarTabla() {
        agotadosRows.clear();
        DefaultTableModel dfl = (DefaultTableModel) tbl_productos.getModel();
        dfl.setRowCount(0);
        int row = 0;

        int registros = 0;
        int disponibles = 0;
        double totalDinero = 0;

        for (Producto p : listaProductos) {
            registros++;
            disponibles += p.getCantidad();
            totalDinero += p.getPrecio();

            dfl.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                "$" + p.getPrecio(),
                p.getCantidad(),
                p.getCategoria().getNombre()
            });
            if (p.getCantidad() <= 0) {
                agotadosRows.add(row);
            }
            row += 1;
        }

        txtEstadisticas.setText(String.format("<html>Productos registrados: %s<br>Cantidad de productos disponibles: %s<br>Dinero en productos disponibles: $%s MXN</html>", registros, disponibles, totalDinero));
        txtEstado.setForeground(Color.WHITE);
        btnRecargar.setEnabled(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnEliminarProducto1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        lbl_estado = new javax.swing.JLabel();
        btnResaltarExistencia = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_productos = new javax.swing.JTable();
        btnEliminarProducto = new javax.swing.JButton();
        btnEditarProducto = new javax.swing.JButton();
        btnAgregarProducto = new javax.swing.JButton();
        txtEstadisticas = new javax.swing.JLabel();
        txtEstado = new javax.swing.JLabel();
        btnRecargar = new javax.swing.JButton();

        btnEliminarProducto1.setBackground(new java.awt.Color(238, 3, 98));
        btnEliminarProducto1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEliminarProducto1.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminarProducto1.setText("Eliminar producto");
        btnEliminarProducto1.setEnabled(false);
        btnEliminarProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProducto1ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Maxitoners");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        lbl_estado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_estado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lbl_estado.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnResaltarExistencia.setBackground(new java.awt.Color(4, 173, 238));
        btnResaltarExistencia.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnResaltarExistencia.setText("Resaltar sin existencia");
        btnResaltarExistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResaltarExistenciaActionPerformed(evt);
            }
        });

        tbl_productos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(4, 173, 238)));
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
        tbl_productos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
                final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if(selectedRow != -1 && row == selectedRow){
                    c.setBackground(new Color(130,207,255));
                    return c;
                }

                if(!isResaltarEnabled){
                    c.setBackground(Color.WHITE);
                    return c;
                }

                if(((int)tbl_productos.getValueAt(row, 3)) <= 0){
                    c.setBackground(Color.PINK);
                } else {
                    c.setBackground(Color.WHITE);
                }

                return c;
            }
        });
        tbl_productos.getTableHeader().setReorderingAllowed(false);
        tbl_productos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_productosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_productos);
        if (tbl_productos.getColumnModel().getColumnCount() > 0) {
            tbl_productos.getColumnModel().getColumn(1).setResizable(false);
            tbl_productos.getColumnModel().getColumn(2).setResizable(false);
            tbl_productos.getColumnModel().getColumn(3).setResizable(false);
            tbl_productos.getColumnModel().getColumn(4).setResizable(false);
        }

        btnEliminarProducto.setBackground(new java.awt.Color(238, 3, 98));
        btnEliminarProducto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEliminarProducto.setForeground(new java.awt.Color(0, 0, 0));
        btnEliminarProducto.setText("Eliminar producto");
        btnEliminarProducto.setEnabled(false);
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

        btnEditarProducto.setBackground(new java.awt.Color(4, 173, 238));
        btnEditarProducto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnEditarProducto.setForeground(new java.awt.Color(0, 0, 0));
        btnEditarProducto.setText("Editar producto");
        btnEditarProducto.setEnabled(false);
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        btnAgregarProducto.setBackground(new java.awt.Color(4, 173, 238));
        btnAgregarProducto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnAgregarProducto.setText("Agregar producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        txtEstadisticas.setForeground(new java.awt.Color(0, 0, 0));
        txtEstadisticas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtEstadisticas.setText("<html>\nProductos registrados: 0<br>\nCantidad de productos disponibles: 0<br>\nDinero en productos disponibles: $0 MXN\n</html>");
        txtEstadisticas.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        txtEstado.setForeground(new java.awt.Color(255, 0, 51));
        txtEstado.setText("CARGANDO...");

        btnRecargar.setBackground(new java.awt.Color(255, 201, 34));
        btnRecargar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnRecargar.setForeground(new java.awt.Color(0, 0, 0));
        btnRecargar.setText("Recargar lista");
        btnRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(95, 95, 95)
                                .addComponent(btnRecargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnResaltarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarProducto)
                        .addGap(18, 18, 18)
                        .addComponent(btnEditarProducto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                        .addComponent(btnEliminarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEstado))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarProducto)
                    .addComponent(btnEditarProducto)
                    .addComponent(btnEliminarProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstadisticas, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(lbl_estado, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnResaltarExistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnResaltarExistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResaltarExistenciaActionPerformed
        isResaltarEnabled = !isResaltarEnabled;
        if (isResaltarEnabled) {
            lbl_estado.setText("Resaltando productos sin existencias");
        } else {
            lbl_estado.setText("");
        }
        tbl_productos.repaint();
    }//GEN-LAST:event_btnResaltarExistenciaActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        AgregarProducto ap = new AgregarProducto(this);
        ap.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        if (tbl_productos.getSelectedRow() != -1) {

            btnEditarProducto.setEnabled(false);
            btnEliminarProducto.setEnabled(false);

            int id = Integer.valueOf((int) tbl_productos.getValueAt(tbl_productos.getSelectedRow(), 0));
            for (Producto p : listaProductos) {
                if (p.getId() == id) {
                    EditarProducto ep = new EditarProducto(this, p);
                    ep.setVisible(true);
                    this.setVisible(false);
                }
            }

            selectedRow = -1;

        }
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void tbl_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productosMouseClicked
        if (tbl_productos.getSelectedRow() != -1) {

            selectedRow = tbl_productos.getSelectedRow();
            tbl_productos.repaint();

            btnEditarProducto.setEnabled(true);
            btnEliminarProducto.setEnabled(true);
        }
    }//GEN-LAST:event_tbl_productosMouseClicked

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        if (tbl_productos.getSelectedRow() != -1) {
            int id = Integer.valueOf((int) tbl_productos.getValueAt(tbl_productos.getSelectedRow(), 0));
            for (Producto p : listaProductos) {
                if (p.getId() == id) {
                    Conexion.borrarProducto(this, p);
                    btnEditarProducto.setEnabled(false);
                    btnEliminarProducto.setEnabled(false);

                    break;
                }
            }
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnEliminarProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProducto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarProducto1ActionPerformed

    private void btnRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecargarActionPerformed
        btnRecargar.setEnabled(false);
        obtenerProductos();
    }//GEN-LAST:event_btnRecargarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnEliminarProducto1;
    private javax.swing.JButton btnRecargar;
    private javax.swing.JButton btnResaltarExistencia;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lbl_estado;
    private javax.swing.JTable tbl_productos;
    private javax.swing.JLabel txtEstadisticas;
    private javax.swing.JLabel txtEstado;
    // End of variables declaration//GEN-END:variables

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }
}
