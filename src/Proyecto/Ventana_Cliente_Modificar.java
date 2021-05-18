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
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diana
 */
public class Ventana_Cliente_Modificar extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Usuario_RegistrarUsuario
     */
    public Ventana_Cliente_Modificar() {
        initComponents();
        
    }
    
    public String Tel_Cliente,Nom_Cliente,Ape_Cliente,Direccion_Cliente;
    
    public String Actual_Nombre_Usuario,Actual_Apellido_Usuario,Actual_Cargo;
    
    private ConeccionBD CBD = new ConeccionBD();
    Connection conectar = CBD.conectar();
    
    private void CargarClientes(){
        limpiarTabla();
        DefaultTableModel mod=(DefaultTableModel) tblCliente.getModel();
        tblCliente.setModel(mod);
        String sql= "select * from cliente";
        String[] Datos = new String[4];
        try {
            Connection conectar = CBD.conectar();
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                Datos[0]=rs.getString(1);
                Datos[1]=rs.getString(2);
                Datos[2]=rs.getString(3);
                Datos[3]=rs.getString(4);
                
                mod.addRow(Datos);
            }
        conectar.close();    
        } catch (Exception e) {
        }
       
    }
    
    private void CargaCliente(){
        txtNombre.setText(Nom_Cliente);
        txtApellido.setText(Ape_Cliente);
        txtTelefono.setText(Tel_Cliente);
        txtDireccion.setText(Direccion_Cliente);
        
    }
    
    private void Limpiar(){
        txtNombre.setText("Nombre.");
        txtNombre.setForeground(new Color(102,102,102));
        txtApellido.setText("Apellido.");
        txtApellido.setForeground(new Color(102,102,102));
        txtTelefono.setText("Teléfono.");
        txtTelefono.setForeground(new Color(102,102,102));
        txtDireccion.setText("Dirección.");
        txtDireccion.setForeground(new Color(102,102,102));
        
    }
    
    public void limpiarTabla(){
        try {
            //System.out.println("Limpiando tabla");
            DefaultTableModel mod=(DefaultTableModel) tblCliente.getModel();
            int a=tblCliente.getRowCount()-1;
            for (int i = a; i >= 0; i--) {
                mod.removeRow(mod.getRowCount()-1);
            }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
    private void ConsultaCliente(){
        limpiarTabla();
        String telefono = txtTelefono.getText();
        String sql = "select * from cliente where Tel_Cliente like '"+telefono+"'";
        
        String[] Datos = new String[4];
        DefaultTableModel mod=(DefaultTableModel) tblCliente.getModel();
        try {
            Connection conectar = CBD.conectar();
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                Datos[0]=rs.getString(1);
                Datos[1]=rs.getString(2);
                Datos[2]=rs.getString(3);
                Datos[3]=rs.getString(4);
                
                mod.addRow(Datos);
            }
        conectar.close();    
        } catch (Exception e) {
        }
    }
    
    private void MandaInfoVCP(){
        Ventana_Cliente_Principal VCP = new Ventana_Cliente_Principal();
        VCP.Actual_Nombre_Usuario = Actual_Nombre_Usuario;
        VCP.Actual_Apellido_Usuario = Actual_Apellido_Usuario;
        VCP.Actual_Cargo = Actual_Cargo;
        this.dispose();
        VCP.setVisible(true);
    }
    
    public void ClienteSeleccionado(int Fila){
        Tel_Cliente = tblCliente.getValueAt(Fila, 0).toString();
        Nom_Cliente= tblCliente.getValueAt(Fila, 1).toString();
        Ape_Cliente= tblCliente.getValueAt(Fila, 2).toString();
        Direccion_Cliente= tblCliente.getValueAt(Fila, 3).toString();
    }
    
    private void ModificaCliente(){
            String nombre, apellido,telefono,direccion;
            nombre=txtNombre.getText();
            apellido=txtApellido.getText();
            telefono=txtTelefono.getText();
            direccion=txtDireccion.getText();
            
            try {
                
                Connection conectar = CBD.conectar();
                
                String sql = "UPDATE cliente set "
                        + "Nom_Cliente = '"+nombre+"',"
                        + "Ape_Cliente = '"+apellido+"',"
                        + "Direccion_Cliente = '"+direccion+"'"
                        + "where Tel_Cliente = '"+telefono+"'";
                    
                PreparedStatement pst = conectar.prepareStatement(sql);
                
                pst.executeUpdate();
                conectar.close();
                JOptionPane.showMessageDialog(null, "Se han guardado los cambios.");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la informacion");
        
        }
    }
    
    private boolean Vacio(){
        boolean vacio=true;
        if(!txtNombre.getText().equals("Nombre.") && !txtApellido.getText().equals("Apellido.") && !txtTelefono.getText().equals("Teléfono.")
                 && !txtDireccion.getText().equals("Dirección."))vacio=false;

        return vacio;
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
        lblUsuario = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        pnlInformacion = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCliente = new javax.swing.JTable();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Modificar cliente");
        pnlFondo.add(jLabel7);
        jLabel7.setBounds(0, 120, 1270, 58);

        pnlCabezera.setBackground(new java.awt.Color(224, 122, 95));
        pnlCabezera.setMaximumSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setMinimumSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setPreferredSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setLayout(null);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setText("Administrador: Nombre_Usuario");
        pnlCabezera.add(lblUsuario);
        lblUsuario.setBounds(10, 20, 760, 30);

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
        pnlCabezera.setBounds(0, 0, 1270, 70);

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
        txtNombre.setBounds(480, 10, 202, 26);

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(102, 102, 102));
        txtTelefono.setText("Teléfono.");
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        pnlInformacion.add(txtTelefono);
        txtTelefono.setBounds(250, 10, 200, 26);

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(102, 102, 102));
        txtDireccion.setText("Dirección.");
        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDireccionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionFocusLost(evt);
            }
        });
        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });
        pnlInformacion.add(txtDireccion);
        txtDireccion.setBounds(480, 60, 200, 26);

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(102, 102, 102));
        txtApellido.setText("Apellido.");
        txtApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidoFocusLost(evt);
            }
        });
        pnlInformacion.add(txtApellido);
        txtApellido.setBounds(250, 60, 200, 26);

        btnConsultar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnConsultar.setText("Consultar");
        btnConsultar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnConsultar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarActionPerformed(evt);
            }
        });
        pnlInformacion.add(btnConsultar);
        btnConsultar.setBounds(110, 10, 120, 30);

        pnlFondo.add(pnlInformacion);
        pnlInformacion.setBounds(170, 180, 890, 110);

        tblCliente.setBackground(new java.awt.Color(244, 241, 222));
        tblCliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Telefono", "Nombre", "Apellido", "Dirección"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.getTableHeader().setReorderingAllowed(false);
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblCliente);
        if (tblCliente.getColumnModel().getColumnCount() > 0) {
            tblCliente.getColumnModel().getColumn(0).setResizable(false);
            tblCliente.getColumnModel().getColumn(1).setResizable(false);
            tblCliente.getColumnModel().getColumn(2).setResizable(false);
            tblCliente.getColumnModel().getColumn(3).setResizable(false);
        }

        pnlFondo.add(jScrollPane1);
        jScrollPane1.setBounds(420, 290, 430, 180);

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistrar.setText("Modificar cliente");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRegistrar);
        btnRegistrar.setBounds(420, 480, 170, 70);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnCancelar);
        btnCancelar.setBounds(680, 480, 170, 70);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            int resp = JOptionPane.showConfirmDialog(null, 
                "¿Los datos son correctos?", "Registrar.",JOptionPane.OK_CANCEL_OPTION);
            if(resp==0){
                if(Vacio()==false){
                        ModificaCliente();
                        int resp2 = JOptionPane.showConfirmDialog(null, 
                        "¿Desea modificar otro usuario?", "Modificar.",JOptionPane.YES_NO_OPTION);
                        if(resp2 == 1)
                            MandaInfoVCP();
                        else{
                            Limpiar();
                            CargarClientes();
                        }
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Hay campos vacios.");

              
            }else{
                JOptionPane.showMessageDialog(null, "Se ha cancelado el registro.");
                Limpiar();
            }
                        
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            MandaInfoVCP();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            lblUsuario.setText(Actual_Cargo+": "+Actual_Nombre_Usuario+" "+Actual_Apellido_Usuario);
            CargarClientes();
            if(!Tel_Cliente.isEmpty() && !Nom_Cliente.isEmpty() && !Ape_Cliente.isEmpty() && !Direccion_Cliente.isEmpty())CargaCliente();
            
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try {

            if(!txtTelefono.getText().equals("Teléfono.")){
                ConsultaCliente();
                
            }
            else {
                CargarClientes();
            }
            Limpiar();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void txtTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusGained
        if(txtTelefono.getText().equals("Teléfono.")){
            txtTelefono.setText("");
            txtTelefono.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtTelefonoFocusGained

    private void txtTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTelefonoFocusLost
        if(txtTelefono.getText().equals("")){
            txtTelefono.setText("Teléfono.");
            txtTelefono.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtTelefonoFocusLost

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

    private void txtApellidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusGained
        if(txtApellido.getText().equals("Apellido.")){
            txtApellido.setText("");
            txtApellido.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtApellidoFocusGained

    private void txtApellidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtApellidoFocusLost
        if(txtApellido.getText().equals("")){
            txtApellido.setText("Apellido.");
            txtApellido.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtApellidoFocusLost

    private void txtDireccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusGained
        if(txtDireccion.getText().equals("")){
            txtDireccion.setText("Dirección.");
            txtDireccion.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_txtDireccionFocusGained

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost
        if(txtDireccion.getText().equals("")){
            txtDireccion.setText("Dirección.");
            txtDireccion.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtDireccionFocusLost

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        try {
            int Fila = tblCliente.getSelectedRow();
            ClienteSeleccionado(Fila);
            //JOptionPane.showMessageDialog(null, Nombre_Usuario+" "+Apellido_Usuario+" "+Telefono+" "+U+" "+C+" "+Correo+" "+Direccion+" "+Cargo+" "+Fecha+" "+Status);
            CargaCliente();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblClienteMouseClicked

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
            java.util.logging.Logger.getLogger(Ventana_Cliente_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Cliente_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Cliente_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Cliente_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Ventana_Cliente_Modificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
