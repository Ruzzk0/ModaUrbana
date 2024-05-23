
package frm;

import PersistenciaDAO.ProductoDAO;
import com.mycompany.dominiodto.ProductoDTO;
import org.bson.types.ObjectId;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.Map;


/**
 *
 * @author Ruzzky
 */
public class frmInventario extends javax.swing.JFrame {
    private DefaultTableModel modelo;
    private ProductoDAO productoDAO;
    private List<ProductoDTO> productos;
    private int filaSeleccionada = -1;
    private DefaultTableModel modeloTabla;


    public frmInventario() {
        initComponents();
        productoDAO = new ProductoDAO();
        modeloTabla = new DefaultTableModel(new Object[]{"ID", "Nombre", "Categoria", "Talla", "Cantidad", "Precio"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Hacer que todas las celdas sean editables
                return true;
            }
        };
        tabla.setModel(modeloTabla);
        actualizarTablaInventario();

tabla.getModel().addTableModelListener(new TableModelListener() {
    @Override
    public void tableChanged(TableModelEvent e) {
        if (e.getType() == TableModelEvent.UPDATE) {
            int fila = e.getFirstRow();
            int columna = e.getColumn();
            Object valorNuevo = tabla.getValueAt(fila, columna);

            // Obtener el ID del producto
            String idProducto = (String) tabla.getValueAt(fila, 0);

            // Actualizar el valor en la base de datos según la columna modificada
            switch (columna) {
                case 1: // Nombre
                    productoDAO.actualizarNombre(idProducto, (String) valorNuevo);
                    break;
                case 4: // Cantidad
                    productoDAO.actualizarCantidad(idProducto, (int) valorNuevo);
                    break;
                case 5: // Precio
                    productoDAO.actualizarPrecio(idProducto, (double) valorNuevo);
                    break;
            }
            // Actualizar la tabla después de la actualización en la base de datos
            actualizarTablaInventario();
        }
    }
});

    }

    public void actualizarTablaInventario() {
        modeloTabla.setRowCount(0); // Limpiar las filas existentes
        List<ProductoDTO> productos = productoDAO.obtenerTodos();
        for (ProductoDTO producto : productos) {
            ObjectId id = producto.getId();
            String nombre = producto.getNombre();
            String categoria = producto.getCategoria().getNombre();
            for (Map.Entry<String, Integer> entry : producto.getTallasCantidades().entrySet()) {
                String talla = entry.getKey();
                int cantidad = entry.getValue();
                double precio = producto.getPrecio();
                modeloTabla.addRow(new Object[]{id.toString(), nombre, categoria, talla, cantidad, precio});
            }
        }
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        tablaRopa = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnBuscar = new javax.swing.JButton();
        txtTipoRopa = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEditar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setBackground(new java.awt.Color(51, 0, 0));
        jLabel1.setFont(new java.awt.Font("Algerian", 0, 48)); // NOI18N
        jLabel1.setText("MODA URBANA");

        btnRegresar.setBackground(new java.awt.Color(204, 204, 255));
        btnRegresar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegresar.setText("REGRESAR");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Categoria", "Talla", "Cantidad", "Precio"
            }
        ));
        tablaRopa.setViewportView(tabla);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria", "Mujeres", "Hombres", "Infantil" }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Talla", "S", "M", "L", "XL" }));

        btnBuscar.setText("🔎    Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("Tipo de ropa:");

        btnEditar.setBackground(new java.awt.Color(204, 204, 255));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnEditar.setText("EDITAR");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(204, 204, 255));
        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAgregar.setText("AGREGAR ROPA");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(301, 301, 301)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(txtTipoRopa, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169)
                        .addComponent(btnBuscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(tablaRopa, javax.swing.GroupLayout.PREFERRED_SIZE, 715, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(45, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(143, 143, 143)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(83, 83, 83))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar)
                    .addComponent(txtTipoRopa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tablaRopa, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(183, 183, 183))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        frmInicio frminicio = new frmInicio();
        frminicio.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
    int filaSeleccionada = tabla.getSelectedRow(); // Obtener la fila seleccionada
    int columnaSeleccionada = tabla.getSelectedColumn(); // Obtener la columna seleccionada

    if (filaSeleccionada != -1 && columnaSeleccionada != -1) {
        Object valorNuevo = tabla.getValueAt(filaSeleccionada, columnaSeleccionada);
        String id = (String) tabla.getValueAt(filaSeleccionada, 0); // Obtener el ID del producto

        // Actualizar el valor en la base de datos según la columna modificada
        switch (columnaSeleccionada) {
            case 1: // Nombre
                productoDAO.actualizarNombre(id, (String) valorNuevo);
                break;
            case 4: // Cantidad
                productoDAO.actualizarCantidad(id, (int) valorNuevo);
                break;
            case 5: // Precio
                productoDAO.actualizarPrecio(id, (double) valorNuevo);
                break;
        }

        // Actualizar la tabla después de la actualización en la base de datos
        actualizarTablaInventario();

        JOptionPane.showMessageDialog(this, "Producto actualizado correctamente");
    } else {
        JOptionPane.showMessageDialog(this, "Debe seleccionar una celda primero");
    }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
          frmAgregarRopa agregar = new frmAgregarRopa();
        agregar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
          String categoriaSeleccionada = jComboBox1.getSelectedItem().toString();
        String tallaSeleccionada = jComboBox2.getSelectedItem().toString();
        String tipoRopa = txtTipoRopa.getText().trim().toLowerCase();

        ProductoDAO productoDAO = new ProductoDAO();
        List<ProductoDTO> productos = productoDAO.obtenerTodos();

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        modelo.setRowCount(0);

        for (ProductoDTO producto : productos) {
            boolean coincideCategoria = categoriaSeleccionada.equals("Categoria") || producto.getCategoria().getNombre().equalsIgnoreCase(categoriaSeleccionada);
            boolean coincideTalla = tallaSeleccionada.equals("Talla") || producto.getTallasCantidades().containsKey(tallaSeleccionada);
            boolean coincideTipoRopa = tipoRopa.isEmpty() || producto.getNombre().toLowerCase().contains(tipoRopa);

            if (coincideCategoria && coincideTalla && coincideTipoRopa) {
                ObjectId id = producto.getId();
                String nombre = producto.getNombre();
                String categoria = producto.getCategoria().getNombre();
                for (Map.Entry<String, Integer> entry : producto.getTallasCantidades().entrySet()) {
                    String talla = entry.getKey();
                    int cantidad = entry.getValue();
                    double precio = producto.getPrecio();
                    if (tallaSeleccionada.equals("Talla") || talla.equals(tallaSeleccionada)) {
                        modelo.addRow(new Object[]{id.toString(), nombre, categoria, talla, cantidad, precio});
                    }}}}
    }//GEN-LAST:event_btnBuscarActionPerformed

   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmInventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JTable tabla;
    private javax.swing.JScrollPane tablaRopa;
    private javax.swing.JTextField txtTipoRopa;
    // End of variables declaration//GEN-END:variables
}
