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
public class Ventana_Inventario_Agregar extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Usuario_RegistrarUsuario
     */
    public Ventana_Inventario_Agregar() {
        initComponents();
        
    }
    
    public String Nombre="",Stock="",Costo="",Unidad_Medida="";
    public String Actual_Nombre_Usuario,Actual_Apellido_Usuario,Actual_Cargo;
    public int id_Inventario;
    private ConeccionBD CBD = new ConeccionBD();
    
    private boolean Vacio(){
        boolean vacio=true;
        if(!txtNombre.getText().equals("") && !txtStock.getText().equals("") && !txtCosto.getText().equals("")
                && cmbUnidad_Medida.getSelectedIndex()!=0)vacio=false;

        return vacio;
    }
    
    private void SacaID(String nom, float stock, float costo, String Und_Med){
            String sql = "select ID_Inventario from Inventario where Nombre='"+nom+"' and Stock = "+stock+" and Costo= "+costo+" "
                    + " and Unidad_Medida = '"+Und_Med+"' ";
            try {
                Connection conectar = CBD.conectar();
                Statement st = conectar.createStatement();
                ResultSet rs = st.executeQuery(sql);
                System.out.println(sql);
                try {
                    while (rs.next()){
                        id_Inventario = rs.getInt(1);
                    }
                   
                    System.out.println(id_Inventario);
                    
                    
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana_Acceso.class.getName()).log(Level.SEVERE, null, ex);
                }
              conectar.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error.");
            }
    }
    
    private void MandaInfoVIP(){
        Ventana_Inventario_Principal VIP = new Ventana_Inventario_Principal();
        VIP.Actual_Nombre_Usuario = Actual_Nombre_Usuario;
        VIP.Actual_Apellido_Usuario = Actual_Apellido_Usuario;
        VIP.Actual_Cargo = Actual_Cargo;
        this.dispose();
        VIP.setVisible(true);
    }
    
    private void AgregarInventario(){
         String nombre,  unidad_medida;
         float stock, costo;
            nombre=txtNombre.getText();
            stock=Float.parseFloat(txtStock.getText());
            costo=Float.parseFloat( txtCosto.getText());
            unidad_medida=cmbUnidad_Medida.getSelectedItem().toString();
      
            try {
                Connection conectar = CBD.conectar();
                String sql = "insert into inventario (Nombre,Stock,Costo,Unidad_Medida)"
                        + "values (?,?,?,?)";
                
                
                
                PreparedStatement pst = conectar.prepareStatement(sql);
                pst.setString(1, nombre);
                pst.setFloat(2, stock);
                pst.setFloat(3, costo);
                pst.setString(4, unidad_medida);
                
                System.out.println(nombre+" "+ stock+""+ costo +""+ unidad_medida);
                pst.executeUpdate();
                
                JOptionPane.showMessageDialog(null, "Registro exitoso.");
               
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Error al registrar.");
         }
     }
    
    private void Limpiar(){
        txtNombre.setText("Nombre.");
        txtNombre.setForeground(new Color(102,102,102));
        txtStock.setText("Stock.");
        txtStock.setForeground(new Color(102,102,102));
        txtCosto.setText("Costo.");
        txtCosto.setForeground(new Color(102,102,102));  
        cmbUnidad_Medida.setSelectedIndex(0);
        cmbUnidad_Medida.setForeground(new Color(102,102,102));
          
    }
    
    public void InventarioSeleccionado(int Fila){
        Nombre = tblInventario.getValueAt(Fila, 0).toString();
        Stock= tblInventario.getValueAt(Fila, 1).toString();
        Costo= tblInventario.getValueAt(Fila, 2).toString();
        Unidad_Medida= tblInventario.getValueAt(Fila, 3).toString();
        
    }
    
    public void limpiarTabla(){
        try {
            //System.out.println("Limpiando tabla");
            DefaultTableModel mod=(DefaultTableModel) tblInventario.getModel();
            int a=tblInventario.getRowCount()-1;
            for (int i = a; i >= 0; i--) {
                mod.removeRow(mod.getRowCount()-1);
            }
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
    private void CargarInventario(){
        limpiarTabla();
        DefaultTableModel mod=(DefaultTableModel) tblInventario.getModel();
        tblInventario.setModel(mod);
        String sql=""; 
        sql = "select Nombre,Stock,Costo,Unidad_Medida from Inventario";
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

    private void ConsultaInventario(){
        limpiarTabla();
        String nombre = txtNombre.getText()+"%";
        String sql = "select * from Inventario where Nombre like '"+nombre+"'";
                
        String[] Datos = new String[4];
        DefaultTableModel mod=(DefaultTableModel) tblInventario.getModel();
        try {
            Connection conectar = CBD.conectar();
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                Datos[0]=rs.getString(2);
                Datos[1]=rs.getString(3);
                Datos[2]=rs.getString(4);
                Datos[3]=rs.getString(5);
                
                mod.addRow(Datos);
            }
        conectar.close();    
        } catch (Exception e) {
        }
    }
    
    /*private void SumaInventario(){//muy dificil
      float stock_actual=0;
        String sql=""; 
        sql = "select Stock from Inventario where ID_Inventario = "+id_Inventario+"";
        try {
            Connection conectar = CBD.conectar();
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                        stock_actual = rs.getFloat(1);
            }

            
        conectar.close();    
        } catch (Exception e) {
        }  
        
            
            stock_actual-= Float.parseFloat(jsCantidad.getValue().toString());

            try {
                    Connection conectar = CBD.conectar();

                        sql = "UPDATE Inventario "
                        + "set Stock = "+stock_actual+""   
                        + "where ID_Inventario = "+id_Inventario+"";

                    PreparedStatement pst = conectar.prepareStatement(sql);
                    pst.executeUpdate();
                    conectar.close();

                    CargarInventario();
            }catch (Exception e) {
            }
         
            
        
     }    */
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
        txtStock = new javax.swing.JTextField();
        txtCosto = new javax.swing.JTextField();
        cmbUnidad_Medida = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInventario = new javax.swing.JTable();

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
        jLabel7.setText("Agregar Inventario");
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
        lblUsuario.setBounds(10, 20, 610, 30);

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
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        pnlInformacion.add(txtNombre);
        txtNombre.setBounds(20, 30, 202, 40);

        txtStock.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtStock.setForeground(new java.awt.Color(102, 102, 102));
        txtStock.setText("Stock.");
        txtStock.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtStockFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtStockFocusLost(evt);
            }
        });
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        pnlInformacion.add(txtStock);
        txtStock.setBounds(20, 108, 202, 40);

        txtCosto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCosto.setForeground(new java.awt.Color(102, 102, 102));
        txtCosto.setText("Costo.");
        txtCosto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCostoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCostoFocusLost(evt);
            }
        });
        txtCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoActionPerformed(evt);
            }
        });
        pnlInformacion.add(txtCosto);
        txtCosto.setBounds(250, 30, 202, 40);

        cmbUnidad_Medida.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbUnidad_Medida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Unidad de Medida", "KG", "Litros" }));
        cmbUnidad_Medida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUnidad_MedidaActionPerformed(evt);
            }
        });
        pnlInformacion.add(cmbUnidad_Medida);
        cmbUnidad_Medida.setBounds(250, 110, 200, 40);

        pnlFondo.add(pnlInformacion);
        pnlInformacion.setBounds(250, 200, 490, 170);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnCancelar);
        btnCancelar.setBounds(980, 430, 170, 70);

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistrar.setText("Agregar inventario");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRegistrar);
        btnRegistrar.setBounds(330, 430, 170, 70);

        tblInventario.setBackground(new java.awt.Color(244, 241, 222));
        tblInventario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        tblInventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Stock", "Costo", "Unidad_Medida"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInventario.getTableHeader().setReorderingAllowed(false);
        tblInventario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInventarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblInventario);

        pnlFondo.add(jScrollPane1);
        jScrollPane1.setBounds(750, 200, 470, 210);

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

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            MandaInfoVIP();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        if(txtNombre.getText().equals("Nombre.")){
            txtNombre.setText("");
            txtNombre.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtStockFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockFocusGained
        if(txtStock.getText().equals("Stock.")){
            txtStock.setText("");
            txtStock.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtStockFocusGained

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if(txtNombre.getText().equals("")){
            txtNombre.setText("Nombre.");
            txtNombre.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void txtStockFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtStockFocusLost
        if(txtStock.getText().equals("")){
            txtStock.setText("Stock.");
            txtStock.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtStockFocusLost

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (Vacio()==false) {
            int resp = JOptionPane.showConfirmDialog(null, 
                "¿Los datos son correctos?", "Agregar.",JOptionPane.OK_CANCEL_OPTION);
            if(resp == 0){
                AgregarInventario();
                int resp2 = JOptionPane.showConfirmDialog(null, 
                    "¿Desea hacer un nuevo registro?", "Agregar.",JOptionPane.YES_NO_OPTION);
                if(resp2 == 1){
                    MandaInfoVIP();
                }
                else{
                    Limpiar();
                    //limpiarTabla();
                    CargarInventario();
                }
                 
                }
                else{
                JOptionPane.showMessageDialog(null, "Se ha cancelado el registro.");
                Limpiar();
                 
            }
            
        }
        else
            JOptionPane.showMessageDialog(null, "Hay campos vacios.");
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            CargarInventario();
            lblUsuario.setText(Actual_Cargo+": "+Actual_Nombre_Usuario+" "+Actual_Apellido_Usuario);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed

    private void txtCostoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCostoFocusGained
     if(txtCosto.getText().equals("Costo.")){
            txtCosto.setText("");
            txtCosto.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtCostoFocusGained

    private void txtCostoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCostoFocusLost
        if(txtCosto.getText().equals("")){
            txtCosto.setText("Costo.");
            txtCosto.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtCostoFocusLost

    private void txtCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoActionPerformed

    private void cmbUnidad_MedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUnidad_MedidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUnidad_MedidaActionPerformed

    private void tblInventarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInventarioMouseClicked
        try {
            int Fila = tblInventario.getSelectedRow();
            InventarioSeleccionado(Fila);
            //JOptionPane.showMessageDialog(null, Nombre_Usuario+" "+Apellido_Usuario+" "+Telefono+" "+U+" "+C+" "+Correo+" "+Direccion+" "+Cargo+" "+Fecha+" "+Status);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblInventarioMouseClicked

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
            java.util.logging.Logger.getLogger(Ventana_Inventario_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inventario_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inventario_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inventario_Agregar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Inventario_Agregar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbUnidad_Medida;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
