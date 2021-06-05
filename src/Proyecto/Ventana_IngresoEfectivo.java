package Proyecto;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author arlet
 */
public class Ventana_IngresoEfectivo extends javax.swing.JFrame {

    public String Concepto = "", Detalles = "", Saldo = "0", id_Usuario;
    public String Tipo = "Ingreso";
    public float Monto = 0;

    public String Actual_Nombre_Usuario, Actual_Apellido_Usuario, Actual_Cargo;

    private ConeccionBD CBD = new ConeccionBD();
    Connection conectar = CBD.conectar();

    /**
     * Creates new form RetiroEfectivo
     */
    public Ventana_IngresoEfectivo() {
        initComponents();
        this.setSize(new Dimension(1275, 585));
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNaranja = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        pnlClaro = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        txtMonto = new javax.swing.JTextField();
        lblSaldo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TxtDecripción = new javax.swing.JTextArea();
        btnRealizarIngreso = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmbConcepto = new javax.swing.JComboBox<>();

        setUndecorated(true);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        pnlNaranja.setBackground(new java.awt.Color(224, 122, 95));
        pnlNaranja.setPreferredSize(new java.awt.Dimension(1270, 66));
        pnlNaranja.setLayout(null);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setText("Administrador: Nombre_Usuario");
        pnlNaranja.add(lblUsuario);
        lblUsuario.setBounds(10, 23, 510, 22);

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

        getContentPane().add(pnlNaranja);
        pnlNaranja.setBounds(0, 0, 1270, 66);

        pnlClaro.setBackground(new java.awt.Color(244, 241, 222));
        pnlClaro.setMaximumSize(new java.awt.Dimension(1270, 583));
        pnlClaro.setMinimumSize(new java.awt.Dimension(1270, 583));
        pnlClaro.setPreferredSize(new java.awt.Dimension(1270, 583));
        pnlClaro.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ingreso de efectivo");
        pnlClaro.add(jLabel7);
        jLabel7.setBounds(0, 120, 1270, 58);

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlClaro.add(btnCancelar);
        btnCancelar.setBounds(710, 450, 170, 70);

        txtMonto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMonto.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtMonto.setText("$");
        txtMonto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(0, 0, 0)));
        txtMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtMontoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMontoFocusLost(evt);
            }
        });
        txtMonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMontoActionPerformed(evt);
            }
        });
        pnlClaro.add(txtMonto);
        txtMonto.setBounds(560, 280, 320, 30);

        lblSaldo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldo.setText("$");
        pnlClaro.add(lblSaldo);
        lblSaldo.setBounds(560, 220, 320, 30);

        TxtDecripción.setColumns(20);
        TxtDecripción.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        TxtDecripción.setForeground(new java.awt.Color(102, 102, 102));
        TxtDecripción.setRows(5);
        TxtDecripción.setText("Escribe aquí los detalles");
        TxtDecripción.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                TxtDecripciónFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                TxtDecripciónFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(TxtDecripción);

        pnlClaro.add(jScrollPane1);
        jScrollPane1.setBounds(560, 360, 320, 70);

        btnRealizarIngreso.setBackground(new java.awt.Color(204, 204, 204));
        btnRealizarIngreso.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRealizarIngreso.setText("Realizar ingreso");
        btnRealizarIngreso.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnRealizarIngreso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRealizarIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarIngresoActionPerformed(evt);
            }
        });
        pnlClaro.add(btnRealizarIngreso);
        btnRealizarIngreso.setBounds(380, 450, 170, 70);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Saldo total en caja $");
        pnlClaro.add(jLabel14);
        jLabel14.setBounds(370, 220, 170, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setText("Monto a ingresar   $");
        pnlClaro.add(jLabel15);
        jLabel15.setBounds(370, 280, 170, 30);

        cmbConcepto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbConcepto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Concepto", "Fondos a caja", "Venta", "Otro", " " }));
        cmbConcepto.setActionCommand("cmbConcepto");
        cmbConcepto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        pnlClaro.add(cmbConcepto);
        cmbConcepto.setBounds(370, 370, 170, 30);

        getContentPane().add(pnlClaro);
        pnlClaro.setBounds(0, 0, 1270, 583);
    }// </editor-fold>//GEN-END:initComponents

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
                new Ventana_IngresoEfectivo().setVisible(true);
            }
        });
    }
    private void txtMontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMontoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        Ventana_CorteDeCaja VCC = new Ventana_CorteDeCaja();
        VCC.setVisible(true);
        VCC.Actual_Nombre_Usuario = Actual_Nombre_Usuario;
        VCC.Actual_Apellido_Usuario = Actual_Apellido_Usuario;
        VCC.Actual_Cargo = Actual_Cargo;
        VCC.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private boolean ValidaCombos(JComboBox combo) {
        try {
            if (combo.getSelectedIndex() == 0) {
                throw new Exception("Concepto inválido, selecciona una opción.");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(this, err.getMessage());
            combo.requestFocus();
            return false;
        }
        return true;
    }

    private void ValidaNumeros(JTextField valor) throws Exception {
        String saldo = valor.getText();
        if (saldo.equals("")) {
            throw new Exception("Error, ingresa el saldo.");
        }
        if (!saldo.matches("[\\d]?[\\d]?[\\d]?[\\d][.]?[\\d]?[\\d]?[\\d]?")) {
            throw new Exception("Monto inválido, solo números.");
        }
    }

    private boolean ValidaMonto(JTextField valor) throws Exception {
        try{
            ValidaNumeros(valor);
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
            valor.setText(""); valor.requestFocus(); return false;
        }
        
        return true;
    }
    private void obtenerIdUsuario(){
        String sql = "select ID_Usuario from usuarios where nombre='"+Actual_Nombre_Usuario+"';";
        System.out.print(sql);
        try{
            Connection conectar = CBD.conectar();
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            id_Usuario = rs.getString(1);
            System.out.println(id_Usuario);
            conectar.close(); 
        }catch(Exception e){}
    }
     private boolean guardar(){
        boolean estado = false;
        float saldoNuevo = Float.parseFloat(Saldo);
        int idUser = Integer.parseInt(id_Usuario);
        
        Concepto = cmbConcepto.getSelectedItem().toString();
        Monto = Float.parseFloat(txtMonto.getText());
        
        saldoNuevo = saldoNuevo + Monto;
        Saldo = saldoNuevo +"";
        if(TxtDecripción.getText().equals("Escribe aquí los detalles")){
            Detalles = "";
        }else
            Detalles = TxtDecripción.getText();
        
        CBD.conectar();
        String sql = "insert into Corte_caja(Fecha,Tipo, Concepto, Monto, Saldo, Detalles, Id_Usuario) "
                + "values(curdate(),"
                + "'" + Tipo + "',"
                + "'" + Concepto + "',"
                + Monto + ","
                + saldoNuevo + ","
                + "'" + Detalles + "',"
                + idUser 
                + ")";
        if(CBD.ejecutar(sql)){
            estado = true;
        }
        CBD.desconectar();
        return estado;
    }
      private void limpiarCampos(){
        cmbConcepto.setSelectedIndex(0);
        txtMonto.setText("");
        TxtDecripción.setText("Escribe aquí los detalles del ingreso");
    }
    private void btnRealizarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarIngresoActionPerformed
        if (!ValidaCombos(cmbConcepto)) {
            return;
        }

        try {
            if(!ValidaMonto(txtMonto))return;
        } catch (Exception ex) {
            Logger.getLogger(Ventana_Producto_Registrar.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(guardar()){
            JOptionPane.showMessageDialog(null, "Datos registrados correctamente.");
            lblSaldo.setText(Saldo + "");
            limpiarCampos();
            
        }else{
            JOptionPane.showMessageDialog(null, "Error: No se registraron los datos.");
        }

    }//GEN-LAST:event_btnRealizarIngresoActionPerformed


    private void txtMontoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoFocusGained
        if (txtMonto.getText().equals("$")) {
            txtMonto.setText("");
            txtMonto.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtMontoFocusGained

    private void txtMontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMontoFocusLost
        if (txtMonto.getText().equals("")) {
            txtMonto.setText("$");
            txtMonto.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_txtMontoFocusLost

    private void TxtDecripciónFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtDecripciónFocusGained
        if (TxtDecripción.getText().equals("Escribe aquí los detalles")) {
            TxtDecripción.setText("");
            TxtDecripción.setForeground(Color.black);
        }
    }//GEN-LAST:event_TxtDecripciónFocusGained

    private void TxtDecripciónFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_TxtDecripciónFocusLost
        if (TxtDecripción.getText().equals("")) {
            TxtDecripción.setText("Escribe aquí los detalles");
            TxtDecripción.setForeground(new Color(102, 102, 102));
        }
    }//GEN-LAST:event_TxtDecripciónFocusLost

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lblUsuario.setText(Actual_Cargo+": "+Actual_Nombre_Usuario+" "+Actual_Apellido_Usuario);
        lblSaldo.setText(Saldo + "");
        obtenerIdUsuario();
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea TxtDecripción;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRealizarIngreso;
    private javax.swing.JComboBox<String> cmbConcepto;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlClaro;
    private javax.swing.JPanel pnlNaranja;
    private javax.swing.JTextField txtMonto;
    // End of variables declaration//GEN-END:variables
}
