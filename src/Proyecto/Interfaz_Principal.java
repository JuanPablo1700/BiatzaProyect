package Proyecto;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arlet
 */
public class Interfaz_Principal extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Interfaz_Principal() {
        initComponents();
        setLocationRelativeTo(null);
    }
    public String Nombre_Usuario,Apellido_Usuario,Telefono,U,C,Correo,Direccion,Cargo,Fecha,Status;
    private Ventana_Usuario_ModificarUsuario VUM = new Ventana_Usuario_ModificarUsuario();
    private Ventana_Usuario_Principal VUP = new Ventana_Usuario_Principal();
    private void bloc_Cajero(){
        btnUsuarios.setVisible(false);
        btnProductos.setVisible(false);
        btnInventario.setVisible(false);
    }
    
    private void MandaInfoVUM(){
        VUM.Nombre_Usuario=Nombre_Usuario;
        VUM.Apellido_Usuario=Apellido_Usuario;
        VUM.Telefono=Telefono;
        VUM.U=U;
        VUM.C=C;
        VUM.Correo=Correo;
        VUM.Direccion=Direccion;
        VUM.Cargo=Cargo;
        VUM.Fecha=Fecha;
        VUM.Status=Status;
    }
    private void MandaInfoVUP(){
        VUP.Nombre_Usuario=Nombre_Usuario;
        VUP.Apellido_Usuario=Apellido_Usuario;
        VUP.Telefono=Telefono;
        VUP.U=U;
        VUP.C=C;
        VUP.Correo=Correo;
        VUP.Direccion=Direccion;
        VUP.Cargo=Cargo;
        VUP.Fecha=Fecha;
        VUP.Status=Status;
        this.dispose();
        VUP.setVisible(true);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menu = new javax.swing.JPanel();
        btnPedidos = new javax.swing.JLabel();
        btnClientes = new javax.swing.JLabel();
        btnRetiro = new javax.swing.JLabel();
        btnReporte = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JLabel();
        btnProductos = new javax.swing.JLabel();
        btnInventario = new javax.swing.JLabel();
        pnlNaranja = new javax.swing.JPanel();
        labelNombre = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        menu.setBackground(new java.awt.Color(61, 64, 91));
        menu.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(244, 241, 222)));
        menu.setForeground(new java.awt.Color(244, 241, 222));
        menu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        menu.setMaximumSize(new java.awt.Dimension(1270, 583));
        menu.setMinimumSize(new java.awt.Dimension(1270, 583));
        menu.setPreferredSize(new java.awt.Dimension(1270, 583));
        menu.setLayout(new java.awt.GridLayout(3, 3, 5, 5));

        btnPedidos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnPedidos.setForeground(new java.awt.Color(244, 241, 222));
        btnPedidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnPedidos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Pedidos.png"))); // NOI18N
        btnPedidos.setText("Pedidos");
        btnPedidos.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(244, 241, 222)));
        btnPedidos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnPedidosMouseReleased(evt);
            }
        });
        menu.add(btnPedidos);

        btnClientes.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnClientes.setForeground(new java.awt.Color(244, 241, 222));
        btnClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/cliente.png"))); // NOI18N
        btnClientes.setText("Clientes");
        btnClientes.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(244, 241, 222)));
        btnClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnClientesMouseReleased(evt);
            }
        });
        menu.add(btnClientes);

        btnRetiro.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnRetiro.setForeground(new java.awt.Color(244, 241, 222));
        btnRetiro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnRetiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/retiro.png"))); // NOI18N
        btnRetiro.setText("Retiro de efectivo");
        btnRetiro.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(244, 241, 222)));
        btnRetiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRetiro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnRetiroMouseReleased(evt);
            }
        });
        menu.add(btnRetiro);

        btnReporte.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnReporte.setForeground(new java.awt.Color(244, 241, 222));
        btnReporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/reporte.png"))); // NOI18N
        btnReporte.setText("Reporte de ventas");
        btnReporte.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(244, 241, 222)));
        btnReporte.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReporte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnReporteMouseReleased(evt);
            }
        });
        menu.add(btnReporte);

        btnUsuarios.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnUsuarios.setForeground(new java.awt.Color(244, 241, 222));
        btnUsuarios.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/usuarios.png"))); // NOI18N
        btnUsuarios.setText("Usuarios");
        btnUsuarios.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(244, 241, 222)));
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseReleased(evt);
            }
        });
        menu.add(btnUsuarios);

        btnProductos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(244, 241, 222));
        btnProductos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/productos.png"))); // NOI18N
        btnProductos.setText("Productos");
        btnProductos.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(244, 241, 222)));
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnProductosMouseReleased(evt);
            }
        });
        menu.add(btnProductos);

        btnInventario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnInventario.setForeground(new java.awt.Color(244, 241, 222));
        btnInventario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnInventario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/inventario.png"))); // NOI18N
        btnInventario.setText("Inventario");
        btnInventario.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(244, 241, 222)));
        btnInventario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnInventarioMouseReleased(evt);
            }
        });
        menu.add(btnInventario);

        getContentPane().add(menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 1270, 510));

        pnlNaranja.setBackground(new java.awt.Color(224, 122, 95));
        pnlNaranja.setMaximumSize(new java.awt.Dimension(1270, 66));
        pnlNaranja.setMinimumSize(new java.awt.Dimension(1270, 66));
        pnlNaranja.setPreferredSize(new java.awt.Dimension(1270, 66));
        pnlNaranja.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelNombre.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        labelNombre.setText("Administrador: Nombre_Usuario");
        labelNombre.setMaximumSize(new java.awt.Dimension(1270, 66));
        labelNombre.setMinimumSize(new java.awt.Dimension(1270, 66));
        pnlNaranja.add(labelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 23, -1, -1));

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
        pnlNaranja.add(btnCerrarSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 15, -1, -1));

        getContentPane().add(pnlNaranja, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnUsuariosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseReleased
        try {
            MandaInfoVUP();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_btnUsuariosMouseReleased

    private void btnReporteMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReporteMouseReleased
        this.dispose();
        GenerarReporteVenta GRP = new GenerarReporteVenta();
        GRP.setVisible(true);
    }//GEN-LAST:event_btnReporteMouseReleased

    private void btnPedidosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPedidosMouseReleased
        this.dispose();
        Ventana_Pedido_Principal VPP = new Ventana_Pedido_Principal();
        VPP.setVisible(true);
        
        
    }//GEN-LAST:event_btnPedidosMouseReleased

    private void btnProductosMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseReleased
        this.dispose();
        Ventana_Producto_Principal VPP = new Ventana_Producto_Principal();
        VPP.setVisible(true);
    }//GEN-LAST:event_btnProductosMouseReleased

    private void btnClientesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnClientesMouseReleased
        this.dispose();
        Ventana_Cliente_Principal VPP = new Ventana_Cliente_Principal();
        VPP.setVisible(true);
    }//GEN-LAST:event_btnClientesMouseReleased

    private void btnInventarioMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInventarioMouseReleased
        this.dispose();
        Ventana_Inventario_Principal VIP = new Ventana_Inventario_Principal();
        VIP.setVisible(true);
    }//GEN-LAST:event_btnInventarioMouseReleased

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            labelNombre.setText(Cargo+": "+Nombre_Usuario+" "+Apellido_Usuario);
        if (Cargo.equals("Cajero")) {
            bloc_Cajero();
        }
        if (Status.equals("0")){
            JOptionPane.showMessageDialog(null, "Es necesario que cambies tu usuario y/o contraseña.");
            MandaInfoVUM();
            this.dispose();
            VUM.setVisible(true);
            
        }
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void btnRetiroMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRetiroMouseReleased
        this.dispose();
        new Ventana_RetiroEfectivo().setVisible(true);
    }//GEN-LAST:event_btnRetiroMouseReleased

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
                new Interfaz_Principal().setVisible(true);
            }
        });
    }
    private final ConeccionBD CBD = new ConeccionBD(); 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JLabel btnClientes;
    private javax.swing.JLabel btnInventario;
    private javax.swing.JLabel btnPedidos;
    private javax.swing.JLabel btnProductos;
    private javax.swing.JLabel btnReporte;
    private javax.swing.JLabel btnRetiro;
    private javax.swing.JLabel btnUsuarios;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JPanel menu;
    private javax.swing.JPanel pnlNaranja;
    // End of variables declaration//GEN-END:variables
}
