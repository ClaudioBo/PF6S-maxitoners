package mx.maxitoners.vistas;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import mx.maxitoners.datos.Conexion;
import mx.maxitoners.negocio.Producto;

public class MostrarInventario extends javax.swing.JFrame {

    private ArrayList<Producto> listaProductos;
    private Conexion con;
    private boolean isResaltarEnabled = true;

    private ArrayList<Integer> agotadosRows = new ArrayList<Integer>();

    public MostrarInventario() {
        initComponents();
        setVisible(true);

        con = new Conexion();
        rellenarTabla();
    }

    public void rellenarTabla() {
        listaProductos = con.cargarTodos();
        agotadosRows.clear();
        DefaultTableModel dfl = (DefaultTableModel) tbl_productos.getModel();
        dfl.setRowCount(0);
        int row = 0;
        for (Producto p : listaProductos) {
            dfl.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                p.getCantidad(),
                p.getCategoria().getNombre()
            });
            if (p.getCantidad() <= 0) {
                agotadosRows.add(row);
            }
            row += 1;
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
		
		tbl_productos.setDefaultRenderer(Object.class, new DefaultTableCellRenderer(){
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
			{
				final Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
				if(isResaltarEnabled){
					if(agotadosRows.contains(row)){
						c.setBackground(Color.RED);
						return c;
					}
				}
				c.setBackground(Color.WHITE);
				return c;
			}
		});

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setText("Mostrar inventario");

        btnAgregarProducto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnAgregarProducto.setText("Agregar producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        btnEditarProducto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEditarProducto.setText("Editar producto");
        btnEditarProducto.setEnabled(false);
        btnEditarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProductoActionPerformed(evt);
            }
        });

        btnEliminarProducto.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnEliminarProducto.setText("Eliminar producto");
        btnEliminarProducto.setEnabled(false);
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });

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
        isResaltarEnabled = !isResaltarEnabled;
        tbl_productos.repaint();
    }//GEN-LAST:event_btnResaltarExistenciaActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        AgregarProducto ap = new AgregarProducto(this);
        ap.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnEditarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProductoActionPerformed
        if (tbl_productos.getSelectedRow() != -1) {
            DefaultTableModel model = (DefaultTableModel) tbl_productos.getModel();
            int id = Integer.valueOf((int) tbl_productos.getValueAt(tbl_productos.getSelectedRow(), 0));
            for (Producto p : listaProductos) {
                if (p.getId() == id) {
                    EditarProducto ep = new EditarProducto(this, p);
                    ep.setVisible(true);
                    this.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_btnEditarProductoActionPerformed

    private void tbl_productosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_productosMouseClicked
        if (tbl_productos.getSelectedRow() != -1) {
            btnEditarProducto.setEnabled(true);
            btnEliminarProducto.setEnabled(true);
        }
    }//GEN-LAST:event_tbl_productosMouseClicked

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        if (tbl_productos.getSelectedRow() != -1) {
            DefaultTableModel model = (DefaultTableModel) tbl_productos.getModel();
            int id = Integer.valueOf((int) tbl_productos.getValueAt(tbl_productos.getSelectedRow(), 0));
            for (Producto p : listaProductos) {
                if (p.getId() == id) {
                    getConexion().borrarProducto(p);
                    JOptionPane.showMessageDialog(this, "Producto eliminado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                    rellenarTabla();
                    btnEditarProducto.setEnabled(false);
                    btnEliminarProducto.setEnabled(false);
                    break;
                }
            }
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEditarProducto;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnResaltarExistencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_productos;
    // End of variables declaration//GEN-END:variables

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public Conexion getConexion() {
        return con;
    }

}
