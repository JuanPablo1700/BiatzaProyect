/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
/**
 *
 * @author diana
 */
public class Ventana_Usuario_RegistrarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Usuario_RegistrarUsuario
     */
    public Ventana_Usuario_RegistrarUsuario() {
        initComponents();
        
    }
    
    public String Actual_Nombre_Usuario,Actual_Apellido_Usuario,Actual_Cargo;
    private ConeccionBD CBD = new ConeccionBD();
    
    
    private boolean Vacio(){
        boolean vacio=true;
        if(!txtNombre.getText().equals("") && !txtApellido.getText().equals("") && !txtTelefono.getText().equals("")
                 && !txtUsuario.getText().equals("Usuario.") && !txtContraseña.getText().equals("Contraseña.") && !txtCorreo.getText().equals("")
                 && !txtDireccion.getText().equals("") && cmbCargo.getSelectedIndex()!=0)vacio=false;

        return vacio;
    }
    
    private void MandaInfoVUP(){
        Ventana_Usuario_Principal VUP = new Ventana_Usuario_Principal();
        VUP.Actual_Nombre_Usuario = Actual_Nombre_Usuario;
        VUP.Actual_Apellido_Usuario = Actual_Apellido_Usuario;
        VUP.Actual_Cargo = Actual_Cargo;
        this.dispose();
        VUP.setVisible(true);
    }
     
    private void RegistraUsuario(){
         String nombre, apellido,telefono,usuario,contraseña,correo,direccion,cargo,fecha;
            nombre=txtNombre.getText();
            apellido=txtApellido.getText();
            telefono=txtTelefono.getText();
            usuario=txtUsuario.getText();
            contraseña=txtContraseña.getText();
            correo=txtCorreo.getText();
            direccion=txtDireccion.getText();
            cargo=cmbCargo.getSelectedItem().toString();
            DateTimeFormatter hora_sistema = DateTimeFormatter.ofPattern("yy/MM/dd");
            fecha = hora_sistema.format(LocalDateTime.now());
            
            try {
                Connection conectar = CBD.conectar();
                String sql = "insert into usuarios (Nombre,Apellido,Telefono,Nom_Usuario,Contraseña,Correo,Direccion,Cargo,Fecha_Registro,Status)"
                        + "values (?,?,?,?,?,?,?,?,?,?)";
                
                PreparedStatement pst = conectar.prepareStatement(sql);
                pst.setString(1, nombre);
                pst.setString(2, apellido);
                pst.setString(3, telefono);
                pst.setString(4, usuario);
                pst.setString(5, contraseña);
                pst.setString(6, correo);
                pst.setString(7, direccion);
                pst.setString(8, cargo);
                pst.setString(9, fecha);
                pst.setInt(10, 0);
                
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Registro exitoso.");
               
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error al registrar.");
         }
     }
    
    private void Limpiar(){
        txtNombre.setText("Nombre.");
        txtNombre.setForeground(new Color(102,102,102));
        txtApellido.setText("Apellido.");
        txtApellido.setForeground(new Color(102,102,102));
        txtTelefono.setText("Teléfono.");
        txtTelefono.setForeground(new Color(102,102,102));
        txtUsuario.setText("Usuario.");
        txtUsuario.setForeground(new Color(102,102,102));
        txtContraseña.setText("Contraseña.");
        txtContraseña.setForeground(new Color(102,102,102));
        txtCorreo.setText("Correo.");
        txtCorreo.setForeground(new Color(102,102,102));
        txtDireccion.setText("Dirección.");
        txtDireccion.setForeground(new Color(102,102,102));
        cmbCargo.setSelectedIndex(0);
        cmbCargo.setForeground(new Color(102,102,102));
        
    }
    private boolean validaTexto(JTextField texto){
       boolean res=false;
       res=texto.getText().toUpperCase().matches("[A-Z]+.*");
       texto.requestFocus();
       return res;
    }
    private boolean validaTel(JTextField texto){
        boolean res=false;
        res=texto.getText().matches("\\d{10}");
        texto.requestFocus();
        return res;
    }
    private boolean validaCorreo(JTextField texto){
       boolean res=false;
       Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
       Matcher mather = pattern.matcher(texto.getText());
       if (mather.find() == true) {
            res=true;
        }else texto.requestFocus();
       return res;
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
        txtApellido = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cmbCargo = new javax.swing.JComboBox<>();
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
        jLabel7.setText("Registrar usuario");
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
        lblUsuario.setBounds(10, 20, 780, 30);

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
        txtApellido.setBounds(20, 70, 202, 26);

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(102, 102, 102));
        txtUsuario.setText("Usuario.");
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        pnlInformacion.add(txtUsuario);
        txtUsuario.setBounds(20, 130, 202, 26);

        txtContraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(102, 102, 102));
        txtContraseña.setText("Contraseña.");
        txtContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContraseñaFocusLost(evt);
            }
        });
        pnlInformacion.add(txtContraseña);
        txtContraseña.setBounds(20, 190, 202, 26);

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(102, 102, 102));
        txtCorreo.setText("Correo.");
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        pnlInformacion.add(txtCorreo);
        txtCorreo.setBounds(250, 10, 202, 26);

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
        pnlInformacion.add(txtDireccion);
        txtDireccion.setBounds(20, 250, 430, 26);

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
        txtTelefono.setBounds(250, 70, 202, 26);

        cmbCargo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un cargo.", "Cajero", "Administrador" }));
        pnlInformacion.add(cmbCargo);
        cmbCargo.setBounds(250, 130, 200, 30);

        pnlFondo.add(pnlInformacion);
        pnlInformacion.setBounds(410, 180, 470, 300);

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistrar.setText("Registrar usuario");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), java.awt.Color.black, java.awt.Color.black));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRegistrar);
        btnRegistrar.setBounds(430, 480, 170, 70);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), java.awt.Color.black, java.awt.Color.black));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnCancelar);
        btnCancelar.setBounds(690, 480, 170, 70);

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            MandaInfoVUP();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

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

    private void txtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusGained
        if(txtUsuario.getText().equals("Usuario.")){
            txtUsuario.setText("");
            txtUsuario.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtUsuarioFocusGained

    private void txtUsuarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUsuarioFocusLost
        if(txtUsuario.getText().equals("")){
            txtUsuario.setText("Usuario.");
            txtUsuario.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtUsuarioFocusLost

    private void txtContraseñaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaFocusGained
        if(txtContraseña.getText().equals("Contraseña.")){
            txtContraseña.setText("");
            txtContraseña.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtContraseñaFocusGained

    private void txtContraseñaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtContraseñaFocusLost
        if(txtContraseña.getText().equals("")){
            txtContraseña.setText("Contraseña.");
            txtContraseña.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtContraseñaFocusLost

    private void txtDireccionFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusGained
        if(txtDireccion.getText().equals("Dirección.")){
            txtDireccion.setText("");
            txtDireccion.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtDireccionFocusGained

    private void txtDireccionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDireccionFocusLost
        if(txtDireccion.getText().equals("")){
            txtDireccion.setText("Dirección.");
            txtDireccion.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtDireccionFocusLost

    private void txtCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusGained
        if(txtCorreo.getText().equals("Correo.")){
            txtCorreo.setText("");
            txtCorreo.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtCorreoFocusGained

    private void txtCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCorreoFocusLost
        if(txtCorreo.getText().equals("")){
            txtCorreo.setText("Correo.");
            txtCorreo.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtCorreoFocusLost

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

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            lblUsuario.setText(Actual_Cargo+": "+Actual_Nombre_Usuario+" "+Actual_Apellido_Usuario);
        } catch (Exception e) {
        }
       
    }//GEN-LAST:event_formWindowOpened

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        
        if (Vacio()==false) {
            if(!validaTel(txtTelefono)){
            JOptionPane.showMessageDialog(this,"Datos invalidos"); return;
            }if(!validaTexto(txtNombre)){
            JOptionPane.showMessageDialog(this,"Datos invalidos"); return;
            }
            if(!validaCorreo(txtCorreo)){
            JOptionPane.showMessageDialog(this,"Datos invalidos"); return;
            }if(!validaTexto(txtApellido)){
            JOptionPane.showMessageDialog(this,"Datos invalidos"); return;
            }if(!validaTexto(txtUsuario)){
            JOptionPane.showMessageDialog(this,"Datos invalidos"); return;
            }
            int resp = JOptionPane.showConfirmDialog(null, 
                "¿Los datos son correctos?", "Registrar.",JOptionPane.OK_CANCEL_OPTION);
            if(resp == 0){
                RegistraUsuario();
                int resp2 = JOptionPane.showConfirmDialog(null, 
                    "¿Desea hacer un nuevo registro?", "Registrar.",JOptionPane.YES_NO_OPTION);
                if(resp2 == 1)
                    MandaInfoVUP();
                else
                    Limpiar();
                }
            else{
                JOptionPane.showMessageDialog(null, "Se ha cancelado el registro.");
                Limpiar();
            }
            
        }
        else
            JOptionPane.showMessageDialog(null, "Hay campos vacios.");
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana_Usuario_RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Usuario_RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Usuario_RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Usuario_RegistrarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Usuario_RegistrarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
