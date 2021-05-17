/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diana
 */
public class Ventana_Usuario_EliminarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Usuario_RegistrarUsuario
     */
    public Ventana_Usuario_EliminarUsuario() {
        initComponents();
        
    }

    public String Actual_Nombre_Usuario,Actual_Apellido_Usuario,Actual_Cargo;
    private ConeccionBD CBD = new ConeccionBD();
    public String Nombre_Usuario,Apellido_Usuario,Telefono,U,C,Correo,Direccion,Cargo,Fecha,Status;
    private int id_Usuario;
    
    private void SacaID(){
            String sql = "select * from usuarios where Nom_Usuario='"+U+"' and Contraseña='"+C+"'";
            try {
                Connection conectar = CBD.conectar();
                Statement st = conectar.createStatement();
                ResultSet rs = st.executeQuery(sql);
                try {
                    while (rs.next()){
                        id_Usuario = rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana_Acceso.class.getName()).log(Level.SEVERE, null, ex);
                }
              conectar.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error.");
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
    
    private void MandaInfoVUP(){
        Ventana_Usuario_Principal VUP = new Ventana_Usuario_Principal();
        VUP.Actual_Nombre_Usuario = Actual_Nombre_Usuario;
        VUP.Actual_Apellido_Usuario = Actual_Apellido_Usuario;
        VUP.Actual_Cargo = Actual_Cargo;
        this.dispose();
        VUP.setVisible(true);
    }
    
    private void EliminarUsuario(){
        String nombre;
        nombre=txtNombre.getText();
        SacaID();
        try {
                Connection conectar = CBD.conectar();
                String sql = "delete from usuarios where ID_Usuario = ?";
                
                PreparedStatement pst = conectar.prepareStatement(sql);
                pst.setInt(1, id_Usuario);
                
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Eliminación exitosa.");
               
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error al eliminar.");
         }
    }
    
    public void limpiarTabla(){
        try {
            //System.out.println("Limpiando tabla");
            DefaultTableModel mod=(DefaultTableModel) tblUsuarios.getModel();
            int a=tblUsuarios.getRowCount()-1;
            for (int i = a; i >= 0; i--) {
                mod.removeRow(mod.getRowCount()-1);
            }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
    private void ConsultaUsuario(){
        limpiarTabla();
        String nombre = txtNombre.getText()+"%";
        String sql = "select * from usuarios where Nombre like '"+nombre+"'";
                
        String[] Datos = new String[10];
        DefaultTableModel mod=(DefaultTableModel) tblUsuarios.getModel();
        try {
            Connection conectar = CBD.conectar();
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                Datos[0]=rs.getString(2);
                Datos[1]=rs.getString(3);
                Datos[2]=rs.getString(4);
                Datos[3]=rs.getString(5);
                Datos[4]=rs.getString(6);
                Datos[5]=rs.getString(7);
                Datos[6]=rs.getString(8);
                Datos[7]=rs.getString(9);
                Datos[8]=rs.getString(10);
                Datos[9]=rs.getString(11);
                
                mod.addRow(Datos);
            }
        conectar.close();    
        } catch (Exception e) {
        }
    }
    
    private void CargarUsuarios(){
        limpiarTabla();
        DefaultTableModel mod=(DefaultTableModel) tblUsuarios.getModel();
        tblUsuarios.setModel(mod);
        String sql=""; 
        sql = "select * from usuarios";
        String[] Datos = new String[10];
        try {
            Connection conectar = CBD.conectar();
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                Datos[0]=rs.getString(2);
                Datos[1]=rs.getString(3);
                Datos[2]=rs.getString(4);
                Datos[3]=rs.getString(5);
                Datos[4]=rs.getString(6);
                Datos[5]=rs.getString(7);
                Datos[6]=rs.getString(8);
                Datos[7]=rs.getString(9);
                Datos[8]=rs.getString(10);
                Datos[9]=rs.getString(11);
                
                mod.addRow(Datos);
            }
        conectar.close();    
        } catch (Exception e) {
        }
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
        pnlInformacion = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        btnEliminarPedido = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1270, 583));
        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnlFondo.setBackground(new java.awt.Color(244, 241, 222));
        pnlFondo.setMaximumSize(new java.awt.Dimension(1270, 583));
        pnlFondo.setMinimumSize(new java.awt.Dimension(1270, 583));
        pnlFondo.setPreferredSize(new java.awt.Dimension(1270, 583));
        pnlFondo.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Eliminar usuario");
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
        lblUsuario.setBounds(10, 20, 820, 30);

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
        pnlCabezera.setBounds(0, 0, 1270, 66);

        pnlInformacion.setBackground(new java.awt.Color(244, 241, 222));
        pnlInformacion.setLayout(null);

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(102, 102, 102));
        txtNombre.setText("Nombre.");
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        pnlInformacion.add(txtNombre);
        txtNombre.setBounds(20, 10, 202, 26);

        btnConsultar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setActionCommand("Registrar");
        btnConsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, new java.awt.Color(0, 0, 0), java.awt.Color.black, java.awt.Color.black));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        pnlInformacion.add(btnConsultar);
        btnConsultar.setBounds(280, 10, 130, 30);

        pnlFondo.add(pnlInformacion);
        pnlInformacion.setBounds(410, 180, 420, 60);

        tblUsuarios.setBackground(new java.awt.Color(244, 241, 222));
        tblUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Telefono", "Usuario", "Contraseña", "Correo", "Dirección", "Cargo", "Fecha", "Status"
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
        jScrollPane1.setBounds(270, 250, 760, 190);

        btnEliminarPedido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarPedido.setText("Eliminar Usuario");
        btnEliminarPedido.setActionCommand("Registrar");
        btnEliminarPedido.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnEliminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPedidoActionPerformed(evt);
            }
        });
        pnlFondo.add(btnEliminarPedido);
        btnEliminarPedido.setBounds(270, 460, 170, 60);

        btnRegresar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.setActionCommand("Registrar");
        btnRegresar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRegresar);
        btnRegresar.setBounds(860, 460, 170, 60);

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

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        if(txtNombre.getText().equals("Nombre.")){
            txtNombre.setText("");
            txtNombre.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if(txtNombre.getText().equals("")){
            txtNombre.setText("Nombre.");
            txtNombre.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try {
            if (txtNombre.getText().equals("Nombre.")) {
                CargarUsuarios();
            }
            else
                ConsultaUsuario();
            txtNombre.setText("Nombre.");
            txtNombre.setForeground(new Color(102,102,102));
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnEliminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPedidoActionPerformed
        try {
            int resp = JOptionPane.showConfirmDialog(null, 
                "¿Los datos son correctos?", "Registrar.",JOptionPane.OK_CANCEL_OPTION);
            if(resp==0){
                EliminarUsuario();
                int resp2 = JOptionPane.showConfirmDialog(null, 
                    "¿Desea hacer un nuevo registro?", "Registrar.",JOptionPane.YES_NO_OPTION);
                if(resp2 == 1)
                    MandaInfoVUP();
                else{
                    limpiarTabla();
                    CargarUsuarios();
                    txtNombre.setText("Nombre.");
                    txtNombre.setForeground(new Color(102,102,102));
                }
            }
                else{
                JOptionPane.showMessageDialog(null, "Se ha cancelado el registro.");
                txtNombre.setText("Nombre.");
                txtNombre.setForeground(new Color(102,102,102));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnEliminarPedidoActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        try {
            MandaInfoVUP();
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
            if(Nombre_Usuario.isEmpty())txtNombre.setText("Nombre.");
            else txtNombre.setText(Nombre_Usuario);
            
            lblUsuario.setText(Actual_Cargo+": "+Actual_Nombre_Usuario+" "+Actual_Apellido_Usuario);
            if (txtNombre.getText().equals("Nombre.")) {
                CargarUsuarios();
            }
            else
                ConsultaUsuario();
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        try {
            int Fila = tblUsuarios.getSelectedRow();
            UsuarioSeleccionado(Fila);
            //JOptionPane.showMessageDialog(null, Nombre_Usuario+" "+Apellido_Usuario+" "+Telefono+" "+U+" "+C+" "+Correo+" "+Direccion+" "+Cargo+" "+Fecha+" "+Status);
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
            java.util.logging.Logger.getLogger(Ventana_Usuario_EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Usuario_EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Usuario_EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Usuario_EliminarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Usuario_EliminarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnEliminarPedido;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
