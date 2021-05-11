/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.Color;

/**
 *
 * @author diana
 */
public class Ventana_Producto_Modificar extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Usuario_RegistrarUsuario
     */
    public Ventana_Producto_Modificar() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        pnlCabezera = new javax.swing.JPanel();
        btnCerrarSesion = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        pnlInformacion = new javax.swing.JPanel();
        txtPrecioProducto = new javax.swing.JTextField();
        txtNomProducto = new javax.swing.JTextField();
        cmbCargo = new javax.swing.JComboBox<>();
        cmbCargo1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_desc = new javax.swing.JTextArea();
        btnBuscar1 = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1270, 583));
        setUndecorated(true);
        setResizable(false);

        pnlFondo.setBackground(new java.awt.Color(244, 241, 222));
        pnlFondo.setMaximumSize(new java.awt.Dimension(1270, 583));
        pnlFondo.setMinimumSize(new java.awt.Dimension(1270, 583));
        pnlFondo.setPreferredSize(new java.awt.Dimension(1270, 583));
        pnlFondo.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Modificar producto");
        pnlFondo.add(jLabel7);
        jLabel7.setBounds(0, 120, 1270, 58);

        pnlCabezera.setBackground(new java.awt.Color(224, 122, 95));
        pnlCabezera.setMaximumSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setMinimumSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setPreferredSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setLayout(null);

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        pnlCabezera.add(btnCerrarSesion);
        btnCerrarSesion.setBounds(1087, 15, 160, 40);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setText("Administrador: Nombre_Usuario");
        pnlCabezera.add(lblUsuario);
        lblUsuario.setBounds(10, 20, 310, 30);

        pnlFondo.add(pnlCabezera);
        pnlCabezera.setBounds(0, 0, 1270, 66);

        pnlInformacion.setBackground(new java.awt.Color(244, 241, 222));
        pnlInformacion.setLayout(null);

        txtPrecioProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPrecioProducto.setForeground(new java.awt.Color(102, 102, 102));
        txtPrecioProducto.setText("Precio");
        txtPrecioProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioProductoFocusLost(evt);
            }
        });
        txtPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioProductoActionPerformed(evt);
            }
        });
        pnlInformacion.add(txtPrecioProducto);
        txtPrecioProducto.setBounds(230, 70, 202, 28);

        txtNomProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNomProducto.setForeground(new java.awt.Color(102, 102, 102));
        txtNomProducto.setText("Nombre del producto");
        txtNomProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomProductoFocusLost(evt);
            }
        });
        txtNomProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomProductoActionPerformed(evt);
            }
        });
        pnlInformacion.add(txtNomProducto);
        txtNomProducto.setBounds(230, 10, 202, 28);

        cmbCargo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tamaño", "Chico", "Mediano", "Grande" }));
        pnlInformacion.add(cmbCargo);
        cmbCargo.setBounds(0, 70, 200, 30);

        cmbCargo1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbCargo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de producto", "Pizza", "Refresco", "Otro" }));
        pnlInformacion.add(cmbCargo1);
        cmbCargo1.setBounds(0, 10, 200, 30);

        jScrollPane1.setForeground(new java.awt.Color(102, 102, 102));

        ta_desc.setColumns(20);
        ta_desc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ta_desc.setForeground(new java.awt.Color(102, 102, 102));
        ta_desc.setRows(5);
        ta_desc.setText("Descripcion del Producto");
        ta_desc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ta_descFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ta_descFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(ta_desc);

        pnlInformacion.add(jScrollPane1);
        jScrollPane1.setBounds(0, 130, 430, 100);

        btnBuscar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar1.setText("Consultar");
        btnBuscar1.setActionCommand("Registrar");
        btnBuscar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, new java.awt.Color(0, 0, 0), java.awt.Color.black, java.awt.Color.black));
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });
        pnlInformacion.add(btnBuscar1);
        btnBuscar1.setBounds(440, 10, 130, 30);

        pnlFondo.add(pnlInformacion);
        pnlInformacion.setBounds(70, 180, 570, 240);

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistrar.setText("Modificar producto");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        pnlFondo.add(btnRegistrar);
        btnRegistrar.setBounds(410, 460, 170, 70);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnCancelar);
        btnCancelar.setBounds(670, 460, 170, 70);

        tblPedidos.setBackground(new java.awt.Color(244, 241, 222));
        tblPedidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idProducto", "NombreProducto", "Tipo", "Tamaño", "Precio", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedidos.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblPedidos);
        if (tblPedidos.getColumnModel().getColumnCount() > 0) {
            tblPedidos.getColumnModel().getColumn(0).setResizable(false);
            tblPedidos.getColumnModel().getColumn(1).setResizable(false);
            tblPedidos.getColumnModel().getColumn(2).setResizable(false);
            tblPedidos.getColumnModel().getColumn(3).setResizable(false);
            tblPedidos.getColumnModel().getColumn(4).setResizable(false);
            tblPedidos.getColumnModel().getColumn(5).setResizable(false);
        }

        pnlFondo.add(jScrollPane2);
        jScrollPane2.setBounds(680, 190, 550, 230);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);
       
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        Ventana_Producto_Principal VPP = new Ventana_Producto_Principal();
        VPP.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNomProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomProductoFocusGained
        if(txtNomProducto.getText().equals("Nombre del producto")){
            txtNomProducto.setText("");
            txtNomProducto.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNomProductoFocusGained

    private void txtNomProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomProductoActionPerformed

    private void txtNomProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomProductoFocusLost
        if(txtNomProducto.getText().equals("")){
            txtNomProducto.setText("Nombre del producto");
            txtNomProducto.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNomProductoFocusLost

    private void txtPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioProductoActionPerformed

    private void txtPrecioProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioProductoFocusGained
        if(txtPrecioProducto.getText().equals("Precio")){
            txtPrecioProducto.setText("");
            txtPrecioProducto.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtPrecioProductoFocusGained

    private void txtPrecioProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioProductoFocusLost
        if(txtPrecioProducto.getText().equals("")){
            txtPrecioProducto.setText("Precio");
            txtPrecioProducto.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtPrecioProductoFocusLost

    private void ta_descFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ta_descFocusGained
        if(ta_desc.getText().equals("Descripcion del Producto")){
            ta_desc.setText("");
            ta_desc.setForeground(Color.black);
        }
    }//GEN-LAST:event_ta_descFocusGained

    private void ta_descFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ta_descFocusLost
        if(ta_desc.getText().equals("")){
            ta_desc.setText("Descripcion del Producto");
            ta_desc.setForeground(Color.black);
        }
    }//GEN-LAST:event_ta_descFocusLost

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscar1ActionPerformed

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Ventana_Producto_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Producto_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Producto_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Producto_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Producto_Modificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JComboBox<String> cmbCargo1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JTextArea ta_desc;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtNomProducto;
    private javax.swing.JTextField txtPrecioProducto;
    // End of variables declaration//GEN-END:variables
}
