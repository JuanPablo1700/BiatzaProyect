/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diana
 */
public class Ventana_Usuario_Principal extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Usuario_Principal
     */
    public Ventana_Usuario_Principal() {
        initComponents();
    }
    
    public String Nombre_Usuario="",Apellido_Usuario="",Telefono="",U="",C="",Correo="",Direccion="",Cargo="",Fecha="",Status="";
    
    public String Actual_Nombre_Usuario,Actual_Apellido_Usuario,Actual_Cargo;
    
    private ConeccionBD CBD = new ConeccionBD();
    Connection conectar = CBD.conectar();
    
    private void CargarUsuarios(){
        DefaultTableModel mod=(DefaultTableModel) tblUsuarios.getModel();
        tblUsuarios.setModel(mod);
        String sql=""; 
        sql = "select Nombre,Apellido,TELEFONO,Nom_Usuario,Contraseña,Correo,Direccion,Cargo,Fecha_Registro,Status from usuarios";
        String[] Datos = new String[10];
        try {
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                Datos[0]=rs.getString(1);
                Datos[1]=rs.getString(2);
                Datos[2]=rs.getString(3);
                Datos[3]=rs.getString(4);
                Datos[4]=rs.getString(5);
                Datos[5]=rs.getString(6);
                Datos[6]=rs.getString(7);
                Datos[7]=rs.getString(8);
                Datos[8]=rs.getString(9);
                Datos[9]=rs.getString(10);
                
                mod.addRow(Datos);
            }
        conectar.close();    
        } catch (Exception e) {
        }
        
            
        
    }
    
    public void UsuarioSeleccionado(int Fila){
        Nombre_Usuario = tblUsuarios.getValueAt(Fila, 0).toString();
        Apellido_Usuario= tblUsuarios.getValueAt(Fila, 1).toString();
        Telefono= tblUsuarios.getValueAt(Fila, 2).toString();
        U= tblUsuarios.getValueAt(Fila, 3).toString();
        C= tblUsuarios.getValueAt(Fila, 4).toString();
        Correo= tblUsuarios.getValueAt(Fila, 5).toString();
        Direccion= tblUsuarios.getValueAt(Fila, 6).toString();
        Cargo= tblUsuarios.getValueAt(Fila, 7).toString();
        Fecha= tblUsuarios.getValueAt(Fila, 8).toString();
        Status= tblUsuarios.getValueAt(Fila, 9).toString();
        
    }
    private void MandaInfoVUM(){
        Ventana_Usuario_ModificarUsuario VUM = new Ventana_Usuario_ModificarUsuario();
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
        
        VUM.Actual_Nombre_Usuario=Actual_Nombre_Usuario;
        VUM.Actual_Apellido_Usuario=Actual_Apellido_Usuario;
        VUM.Actual_Cargo=Actual_Cargo;
        //System.out.println(Nombre_Usuario+" "+Apellido_Usuario+" "+Telefono+" "+U+" "+C+" "+Correo+" "+Direccion+" "+Cargo+" "+Fecha+" "+Status);
            
        this.dispose();
        VUM.setVisible(true);
    }
    
    private void MandaInfoVUR(){
        Ventana_Usuario_RegistrarUsuario VUR = new Ventana_Usuario_RegistrarUsuario();
        VUR.Actual_Nombre_Usuario=Actual_Nombre_Usuario;
        VUR.Actual_Apellido_Usuario=Actual_Apellido_Usuario;
        VUR.Actual_Cargo=Actual_Cargo;
        
        this.dispose();        
        VUR.setVisible(true);
    }
    
    private void MandaInfoVUE(){
        Ventana_Usuario_EliminarUsuario VUE = new Ventana_Usuario_EliminarUsuario();
        VUE.Nombre_Usuario=Nombre_Usuario;
        VUE.Apellido_Usuario=Apellido_Usuario;
        VUE.Telefono=Telefono;
        VUE.U=U;
        VUE.C=C;
        VUE.Correo=Correo;
        VUE.Direccion=Direccion;
        VUE.Cargo=Cargo;
        VUE.Fecha=Fecha;
        VUE.Status=Status;
        
        VUE.Actual_Nombre_Usuario=Actual_Nombre_Usuario;
        VUE.Actual_Apellido_Usuario=Actual_Apellido_Usuario;
        VUE.Actual_Cargo=Actual_Cargo;
        
        this.dispose();        
        VUE.setVisible(true);
    }
    
    private void MandaInfoIP(){
        Interfaz_Principal IP = new Interfaz_Principal();
            IP.Actual_Nombre_Usuario=Actual_Nombre_Usuario;
            IP.Actual_Apellido_Usuario=Actual_Apellido_Usuario;
            IP.Actual_Cargo=Actual_Cargo;
            this.dispose();
            IP.setVisible(true);
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
        lblTitulo = new javax.swing.JLabel();
        pnlCabezera = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnModificarUsuario = new javax.swing.JButton();
        btnRegistrarUsuario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1270, 583));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        pnlFondo.setBackground(new java.awt.Color(244, 241, 222));
        pnlFondo.setMaximumSize(new java.awt.Dimension(1270, 583));
        pnlFondo.setMinimumSize(new java.awt.Dimension(1270, 583));
        pnlFondo.setPreferredSize(new java.awt.Dimension(1270, 583));
        pnlFondo.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Usuarios");
        pnlFondo.add(lblTitulo);
        lblTitulo.setBounds(0, 120, 1270, 58);

        pnlCabezera.setBackground(new java.awt.Color(224, 122, 95));
        pnlCabezera.setMaximumSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setMinimumSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setPreferredSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setLayout(null);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setText("Administrador: Nombre_Usuario");
        pnlCabezera.add(lblUsuario);
        lblUsuario.setBounds(10, 20, 650, 30);

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

        pnlFondo.add(pnlCabezera);
        pnlCabezera.setBounds(0, 0, 1270, 60);

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setActionCommand("Registrar");
        btnRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnRegresar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRegresar);
        btnRegresar.setBounds(850, 470, 170, 70);

        btnEliminarUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarUsuario.setText("Eliminar usuario");
        btnEliminarUsuario.setActionCommand("Registrar");
        btnEliminarUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnEliminarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });
        pnlFondo.add(btnEliminarUsuario);
        btnEliminarUsuario.setBounds(660, 470, 170, 70);

        btnModificarUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificarUsuario.setText("Modificar usuario");
        btnModificarUsuario.setActionCommand("Registrar");
        btnModificarUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnModificarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarUsuarioActionPerformed(evt);
            }
        });
        pnlFondo.add(btnModificarUsuario);
        btnModificarUsuario.setBounds(460, 470, 170, 70);

        btnRegistrarUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegistrarUsuario.setText("Registrar usuario");
        btnRegistrarUsuario.setActionCommand("Registrar");
        btnRegistrarUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnRegistrarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUsuarioActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRegistrarUsuario);
        btnRegistrarUsuario.setBounds(260, 470, 170, 70);

        tblUsuarios.setBackground(new java.awt.Color(244, 241, 222));
        tblUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Telefono", "Usuario", "Contraseña", "Correo", "Direccion", "Cargo", "Fecha", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);
        if (tblUsuarios.getColumnModel().getColumnCount() > 0) {
            tblUsuarios.getColumnModel().getColumn(0).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(1).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(2).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(3).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(4).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(5).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(6).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(7).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(8).setResizable(false);
            tblUsuarios.getColumnModel().getColumn(9).setResizable(false);
        }

        pnlFondo.add(jScrollPane1);
        jScrollPane1.setBounds(260, 200, 760, 250);

        getContentPane().add(pnlFondo);
        pnlFondo.setBounds(0, 0, 1270, 590);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUsuarioActionPerformed
        try {
            MandaInfoVUR();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnRegistrarUsuarioActionPerformed

    private void btnModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarUsuarioActionPerformed
        try {
            MandaInfoVUM();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnModificarUsuarioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        try {
            MandaInfoVUE();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        try {
            MandaInfoIP();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            CargarUsuarios();
            lblUsuario.setText(Actual_Cargo+": "+Actual_Nombre_Usuario+" "+Actual_Apellido_Usuario);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        try {
            int Fila = tblUsuarios.getSelectedRow();
            UsuarioSeleccionado(Fila);
        } catch (Exception e) {
        }
        
        
        
    }//GEN-LAST:event_tblUsuariosMouseClicked

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
            java.util.logging.Logger.getLogger(Ventana_Usuario_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Usuario_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Usuario_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Usuario_Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Usuario_Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnEliminarUsuario;
    private javax.swing.JButton btnModificarUsuario;
    private javax.swing.JButton btnRegistrarUsuario;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
