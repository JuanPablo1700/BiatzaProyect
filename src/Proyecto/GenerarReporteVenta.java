package Proyecto;

import java.awt.Color;


public class GenerarReporteVenta extends javax.swing.JFrame {

    /**
     * Creates new form RetiroEfectivo
     */
    public GenerarReporteVenta() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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
            java.util.logging.Logger.getLogger(Interfaz_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GenerarReporteVenta().setVisible(true);
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlClaro = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReporteVentas = new javax.swing.JTable();
        rbtnFiltro = new javax.swing.JRadioButton();
        lblDia1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lblDia2 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        lblNomUsuario = new javax.swing.JLabel();
        cmbUsuario = new javax.swing.JComboBox<>();
        btnImprimir = new javax.swing.JButton();
        btnConsultar = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        pnlNaranja = new javax.swing.JPanel();
        lblNombreUsuario = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1270, 583));
        setMinimumSize(new java.awt.Dimension(1270, 583));
        setUndecorated(true);
        setSize(new java.awt.Dimension(1270, 583));
        getContentPane().setLayout(null);

        pnlClaro.setBackground(new java.awt.Color(244, 241, 222));
        pnlClaro.setMaximumSize(new java.awt.Dimension(1270, 583));
        pnlClaro.setMinimumSize(new java.awt.Dimension(1270, 583));
        pnlClaro.setPreferredSize(new java.awt.Dimension(1270, 583));
        pnlClaro.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Generar reporte de ventas");
        pnlClaro.add(jLabel7);
        jLabel7.setBounds(-1, 90, 1270, 58);

        tblReporteVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num_Venta", "Fecha", "Descripción", "Cliente", "Monto total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblReporteVentas);
        if (tblReporteVentas.getColumnModel().getColumnCount() > 0) {
            tblReporteVentas.getColumnModel().getColumn(0).setResizable(false);
            tblReporteVentas.getColumnModel().getColumn(1).setResizable(false);
            tblReporteVentas.getColumnModel().getColumn(2).setResizable(false);
            tblReporteVentas.getColumnModel().getColumn(3).setResizable(false);
            tblReporteVentas.getColumnModel().getColumn(4).setResizable(false);
        }

        pnlClaro.add(jScrollPane1);
        jScrollPane1.setBounds(230, 250, 780, 210);

        rbtnFiltro.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbtnFiltro.setText("Filtrar por fecha");
        rbtnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnFiltroActionPerformed(evt);
            }
        });
        pnlClaro.add(rbtnFiltro);
        rbtnFiltro.setBounds(230, 160, 149, 31);

        lblDia1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDia1.setText("Filtrar del día:");
        pnlClaro.add(lblDia1);
        lblDia1.setBounds(430, 160, 110, 30);
        pnlClaro.add(jDateChooser1);
        jDateChooser1.setBounds(540, 160, 160, 30);

        lblDia2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblDia2.setText("Al dia:");
        pnlClaro.add(lblDia2);
        lblDia2.setBounds(770, 160, 60, 30);
        pnlClaro.add(jDateChooser2);
        jDateChooser2.setBounds(840, 160, 160, 30);

        lblNomUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNomUsuario.setText("Nombre Usuario:");
        pnlClaro.add(lblNomUsuario);
        lblNomUsuario.setBounds(230, 210, 140, 30);

        cmbUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar" }));
        pnlClaro.add(cmbUsuario);
        cmbUsuario.setBounds(370, 210, 220, 30);

        btnImprimir.setBackground(new java.awt.Color(204, 204, 204));
        btnImprimir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnImprimir.setText("Imprimir");
        btnImprimir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });
        pnlClaro.add(btnImprimir);
        btnImprimir.setBounds(540, 470, 170, 70);

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setActionCommand("Registrar");
        btnConsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        pnlClaro.add(btnConsultar);
        btnConsultar.setBounds(230, 470, 170, 70);

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setActionCommand("Registrar");
        btnRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        pnlClaro.add(btnRegresar);
        btnRegresar.setBounds(840, 470, 170, 70);

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(102, 102, 102));
        txtNombre.setText("Telefono del cliente.");
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        pnlClaro.add(txtNombre);
        txtNombre.setBounds(810, 210, 202, 28);

        pnlNaranja.setBackground(new java.awt.Color(224, 122, 95));
        pnlNaranja.setMaximumSize(new java.awt.Dimension(1270, 66));
        pnlNaranja.setMinimumSize(new java.awt.Dimension(1270, 66));
        pnlNaranja.setPreferredSize(new java.awt.Dimension(1270, 66));
        pnlNaranja.setLayout(null);

        lblNombreUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreUsuario.setText("Administrador: Nombre_Usuario");
        pnlNaranja.add(lblNombreUsuario);
        lblNombreUsuario.setBounds(10, 23, 291, 22);

        btnCerrarSesion.setBackground(new java.awt.Color(224, 122, 95));
        btnCerrarSesion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setMaximumSize(new java.awt.Dimension(160, 40));
        btnCerrarSesion.setMinimumSize(new java.awt.Dimension(160, 40));
        btnCerrarSesion.setPreferredSize(new java.awt.Dimension(160, 40));
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        pnlNaranja.add(btnCerrarSesion);
        btnCerrarSesion.setBounds(1080, 15, 160, 40);

        pnlClaro.add(pnlNaranja);
        pnlNaranja.setBounds(0, 0, 1270, 66);

        getContentPane().add(pnlClaro);
        pnlClaro.setBounds(0, 0, 1270, 583);
    }// </editor-fold>//GEN-END:initComponents

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);

    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void rbtnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnFiltroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbtnFiltroActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        Interfaz_Principal IP = new Interfaz_Principal();
        IP.setVisible(true);
        
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        if(txtNombre.getText().equals("Telefono del cliente.")){
            txtNombre.setText("");
            txtNombre.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if(txtNombre.getText().equals("")){
            txtNombre.setText("Telefono del cliente.");
            txtNombre.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JComboBox<String> cmbUsuario;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDia1;
    private javax.swing.JLabel lblDia2;
    private javax.swing.JLabel lblNomUsuario;
    private javax.swing.JLabel lblNombreUsuario;
    private javax.swing.JPanel pnlClaro;
    private javax.swing.JPanel pnlNaranja;
    private javax.swing.JRadioButton rbtnFiltro;
    private javax.swing.JTable tblReporteVentas;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}