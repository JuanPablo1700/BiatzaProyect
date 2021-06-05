package Proyecto;


import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arlet
 */
public class Ventana_CorteDeCaja extends javax.swing.JFrame {

    /**
     * Creates new form RetiroEfectivo
     */
    public Ventana_CorteDeCaja() {
        initComponents();
        this.setSize(new Dimension(1275, 585));
        setLocationRelativeTo(null);
    }

    public String Fecha="",Concepto="",Detalles="", Saldo = "0";
    public float Ingreso = 0, Retiro = 0;
    
    public String Actual_Nombre_Usuario,Actual_Apellido_Usuario,Actual_Cargo;
    
    private ConeccionBD CBD = new ConeccionBD();
    Connection conectar = CBD.conectar();
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
        lblSaldo = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMovimientosCaja = new javax.swing.JTable();
        btnRealizarRetiro = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnRealizarIngreso = new javax.swing.JButton();

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
        lblUsuario.setBounds(10, 23, 390, 22);

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
        jLabel7.setText("Corte de caja");
        pnlClaro.add(jLabel7);
        jLabel7.setBounds(0, 120, 1270, 58);

        lblSaldo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblSaldo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSaldo.setText("2080");
        pnlClaro.add(lblSaldo);
        lblSaldo.setBounds(560, 220, 320, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setText("Saldo total en caja $");
        pnlClaro.add(jLabel14);
        jLabel14.setBounds(390, 220, 170, 30);

        tblMovimientosCaja.setBackground(new java.awt.Color(244, 241, 222));
        tblMovimientosCaja.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        tblMovimientosCaja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Concepto", "Ingreso", "Retiro", "Saldo", "Detalles"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMovimientosCaja.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblMovimientosCaja);

        pnlClaro.add(jScrollPane2);
        jScrollPane2.setBounds(300, 270, 760, 190);

        btnRealizarRetiro.setBackground(new java.awt.Color(204, 204, 204));
        btnRealizarRetiro.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRealizarRetiro.setText("Realizar Retiro");
        btnRealizarRetiro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnRealizarRetiro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRealizarRetiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarRetiroActionPerformed(evt);
            }
        });
        pnlClaro.add(btnRealizarRetiro);
        btnRealizarRetiro.setBounds(600, 510, 170, 70);

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
        btnCancelar.setBounds(890, 510, 170, 70);

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
        btnRealizarIngreso.setBounds(300, 510, 170, 70);

        getContentPane().add(pnlClaro);
        pnlClaro.setBounds(0, 0, 1270, 583);
    }// </editor-fold>//GEN-END:initComponents

    private void cargarMovimientos (){
        DefaultTableModel mod=(DefaultTableModel) tblMovimientosCaja.getModel();
        tblMovimientosCaja.setModel(mod);
        
        String sql="select Fecha,Concepto, Ingreso, Retiro, Saldo, Detalles from Corte_Caja";
        String[] Datos = new String[6];
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
                
                mod.addRow(Datos);
            }
            conectar.close();    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al consultar los datos");
        } 
    }
       
    private void MandaInfoIP(){
        Interfaz_Principal IP = new Interfaz_Principal();
            IP.Actual_Nombre_Usuario=Actual_Nombre_Usuario;
            IP.Actual_Apellido_Usuario=Actual_Apellido_Usuario;
            IP.Actual_Cargo=Actual_Cargo;
            this.dispose();
            IP.setVisible(true);
    }
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
                new Ventana_CorteDeCaja().setVisible(true);
            }
        });
       
        
    }
    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnRealizarRetiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarRetiroActionPerformed
        
        Ventana_RetiroEfectivo RE = new Ventana_RetiroEfectivo();
        RE.Actual_Nombre_Usuario=Actual_Nombre_Usuario;
        RE.Actual_Apellido_Usuario=Actual_Apellido_Usuario;
        RE.Actual_Cargo=Actual_Cargo;
        RE.Saldo = Saldo;
        this.dispose();
        RE.setVisible(true);
    }//GEN-LAST:event_btnRealizarRetiroActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        MandaInfoIP();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnRealizarIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarIngresoActionPerformed
        
        Ventana_IngresoEfectivo VIE = new Ventana_IngresoEfectivo();
        VIE.Actual_Nombre_Usuario=Actual_Nombre_Usuario;
        VIE.Actual_Apellido_Usuario=Actual_Apellido_Usuario;
        VIE.Actual_Cargo=Actual_Cargo;
        VIE.Saldo = Saldo;
        VIE.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRealizarIngresoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lblUsuario.setText(Actual_Cargo+": "+Actual_Nombre_Usuario+" "+Actual_Apellido_Usuario);
        
        cargarMovimientos();
        
        //si es la primera vez que se loguea el usuario en el día soliciar ingreso inicial
        if(tblMovimientosCaja.getRowCount() == 0){
            this.dispose();
            Ventana_IngresoEfectivo VIE = new Ventana_IngresoEfectivo();
            VIE.setVisible(true);
        }
        Saldo =  tblMovimientosCaja.getValueAt(tblMovimientosCaja.getRowCount()-1, 4) + "";
        //Saldo = tblMovimientosCaja.getValueAt(tblMovimientosCaja.getRowCount()-1, 4);
        lblSaldo.setText(Saldo + "");
    }//GEN-LAST:event_formWindowOpened


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRealizarIngreso;
    private javax.swing.JButton btnRealizarRetiro;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlClaro;
    private javax.swing.JPanel pnlNaranja;
    private javax.swing.JTable tblMovimientosCaja;
    // End of variables declaration//GEN-END:variables
}