/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

/**
 *
 * @author diana
 */
public class Ventana_Inventario_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Usuario_Principal
     */
    public Ventana_Inventario_Principal() {
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

        btnEliminarUsuario = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlCabezera = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnEliminarInventario = new javax.swing.JButton();
        btnAgregarInventario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1270, 583));
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(null);

        btnEliminarUsuario.setBackground(new java.awt.Color(244, 241, 222));
        btnEliminarUsuario.setMaximumSize(new java.awt.Dimension(1270, 583));
        btnEliminarUsuario.setMinimumSize(new java.awt.Dimension(1270, 583));
        btnEliminarUsuario.setPreferredSize(new java.awt.Dimension(1270, 583));
        btnEliminarUsuario.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Inventario");
        btnEliminarUsuario.add(lblTitulo);
        lblTitulo.setBounds(0, 120, 1270, 58);

        pnlCabezera.setBackground(new java.awt.Color(224, 122, 95));
        pnlCabezera.setMaximumSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setMinimumSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setPreferredSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setLayout(null);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setText("Administrador: Nombre_Usuario");
        pnlCabezera.add(lblUsuario);
        lblUsuario.setBounds(10, 20, 320, 30);

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
        pnlCabezera.add(btnCerrarSesion);
        btnCerrarSesion.setBounds(1080, 15, 160, 40);

        btnEliminarUsuario.add(pnlCabezera);
        pnlCabezera.setBounds(0, 0, 1270, 60);

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setActionCommand("Registrar");
        btnRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        btnEliminarUsuario.add(btnRegresar);
        btnRegresar.setBounds(850, 480, 170, 70);

        btnEliminarInventario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarInventario.setText("Eliminar Inventario");
        btnEliminarInventario.setActionCommand("Registrar");
        btnEliminarInventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnEliminarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarInventarioActionPerformed(evt);
            }
        });
        btnEliminarUsuario.add(btnEliminarInventario);
        btnEliminarInventario.setBounds(560, 480, 170, 70);

        btnAgregarInventario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregarInventario.setText("Agregar Inventario");
        btnAgregarInventario.setActionCommand("Registrar");
        btnAgregarInventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnAgregarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarInventarioActionPerformed(evt);
            }
        });
        btnEliminarUsuario.add(btnAgregarInventario);
        btnAgregarInventario.setBounds(260, 480, 170, 70);

        tblInventario.setBackground(new java.awt.Color(244, 241, 222));
        tblInventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Cantidad", "Costo", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInventario.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblInventario);
        if (tblInventario.getColumnModel().getColumnCount() > 0) {
            tblInventario.getColumnModel().getColumn(0).setResizable(false);
            tblInventario.getColumnModel().getColumn(1).setResizable(false);
            tblInventario.getColumnModel().getColumn(2).setResizable(false);
            tblInventario.getColumnModel().getColumn(3).setResizable(false);
        }

        btnEliminarUsuario.add(jScrollPane1);
        jScrollPane1.setBounds(260, 210, 760, 250);

        getContentPane().add(btnEliminarUsuario);
        btnEliminarUsuario.setBounds(0, 0, 1270, 590);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarInventarioActionPerformed
        this.dispose();
        Ventana_Inventario_Agregar VIA = new Ventana_Inventario_Agregar();
        VIA.setVisible(true);
    }//GEN-LAST:event_btnAgregarInventarioActionPerformed

    private void btnEliminarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarInventarioActionPerformed
        this.dispose();
        Ventana_Inventario_Eliminar VURU = new Ventana_Inventario_Eliminar();
        VURU.setVisible(true);
    }//GEN-LAST:event_btnEliminarInventarioActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        this.dispose();
        Interfaz_Principal IA = new Interfaz_Principal();
        IA.setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana_Inventario_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inventario_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inventario_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inventario_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Inventario_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarInventario;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminarInventario;
    private javax.swing.JPanel btnEliminarUsuario;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JTable tblInventario;
    // End of variables declaration//GEN-END:variables
}