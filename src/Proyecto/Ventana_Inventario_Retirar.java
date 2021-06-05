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
public class Ventana_Inventario_Retirar extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Usuario_RegistrarUsuario
     */
    public Ventana_Inventario_Retirar() {
        initComponents();
        
    }
    
    public String Nombre="",Stock="",Costo="",Unidad_Medida="";
    
    public String Actual_Nombre_Usuario,Actual_Apellido_Usuario,Actual_Cargo;
    public int id_Inventario;
    private final ConeccionBD CBD = new ConeccionBD();
    
    /**
     * compara los campos de la interfaz con la cadena vacia para retornar la 
     * variable booleana falsa
     * @return 
     */
    private boolean Vacio(){
        boolean vacio=true;
        if(!txtNombre.getText().equals("") )vacio=false;

        return vacio;
    }
    
    /**
     * hace una consulta a la tabla inventario para almacenar el id_ inventario
     * @param nom
     * @param stock
     * @param costo
     * @param Und_Med 
     */
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
    
    /**
     * permite que al hacer clic en un registro de la tabla se mantenga seleccionado
     * @param Fila 
     */
    public void InventarioSeleccionado(int Fila){
        Nombre = tblInventario.getValueAt(Fila, 0).toString();
        Stock= tblInventario.getValueAt(Fila, 1).toString();
        Costo= tblInventario.getValueAt(Fila, 2).toString();
        Unidad_Medida= tblInventario.getValueAt(Fila, 3).toString();
        
    }
    
    /**
     * toma la información de logeo de la interfaz para
     * enviarla a la interfaz de inventario principal
     */
    private void MandaInfoVIP(){
        Ventana_Inventario_Principal VIP = new Ventana_Inventario_Principal();
        VIP.Actual_Nombre_Usuario = Actual_Nombre_Usuario;
        VIP.Actual_Apellido_Usuario = Actual_Apellido_Usuario;
        VIP.Actual_Cargo = Actual_Cargo;
        this.dispose();
        VIP.setVisible(true);
    }
    
    
    /**
     * esta función quita la informacion previamente insertada en el campo
     * de texto nombre
     */
    private void Limpiar(){
        txtNombre.setText("Nombre.");
        txtNombre.setForeground(new Color(102,102,102));  
    }
    
    /**
     * esta funcion remueve todos los registros que se muestran sobre tabla
     * en la interfaz eliminar inventario
     */
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
    
    /**
     * funcion donde muestra todos los registros  de la tabla inventario y se muestra
     * en la tabla de la interfaz
     */
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
   
    /**
     * función donde hace una consulta de todos los datos de la tabla inventario donde
     * la condición sea el nombre guardandolo en una matriz
     */
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
     
     /**
      * función donde guarda el stock del registro y se resta con la cantidad 
      * establecida para actualizar el registro, validando que no sea mayor y que
      * no sea un numero negativo
      */
     private void RetiraInventario(){
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
        
        if (stock_actual< Float.parseFloat(jsCantidad.getValue().toString())){
            JOptionPane.showMessageDialog(null, "Asigne un valor menor a la existencia");
            jsCantidad.setValue(0);
              
        } else if (Float.parseFloat(jsCantidad.getValue().toString())<0){
            JOptionPane.showMessageDialog(null, "Asigne Valores positivos para retirar");
            jsCantidad.setValue(0);
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
        jsCantidad = new javax.swing.JSpinner();
        btnRetirar = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
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
        jLabel7.setText("Retirar Inventario");
        pnlFondo.add(jLabel7);
        jLabel7.setBounds(0, 100, 1270, 58);

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
        txtNombre.setBounds(0, 20, 202, 30);

        jsCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jsCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jsCantidad.setRequestFocusEnabled(false);
        jsCantidad.setValue(1);
        jsCantidad.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jsCantidadMouseClicked(evt);
            }
        });
        pnlInformacion.add(jsCantidad);
        jsCantidad.setBounds(400, 20, 120, 30);

        btnRetirar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRetirar.setText("Retirar");
        btnRetirar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnRetirar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetirarActionPerformed(evt);
            }
        });
        pnlInformacion.add(btnRetirar);
        btnRetirar.setBounds(580, 20, 120, 30);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlInformacion.add(btnBuscar);
        btnBuscar.setBounds(230, 20, 120, 30);

        pnlFondo.add(pnlInformacion);
        pnlInformacion.setBounds(230, 180, 720, 60);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnCancelar);
        btnCancelar.setBounds(780, 500, 150, 60);

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
        jScrollPane1.setBounds(230, 250, 700, 210);

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

    private void txtNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusLost
        if(txtNombre.getText().equals("")){
            txtNombre.setText("Nombre.");
            txtNombre.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtNombreFocusLost

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            CargarInventario();
            lblUsuario.setText(Actual_Cargo+": "+Actual_Nombre_Usuario+" "+Actual_Apellido_Usuario);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_formWindowOpened

    private void jsCantidadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jsCantidadMouseClicked
        if(Integer.parseInt(jsCantidad.getValue().toString())<=1)jsCantidad.setValue(1);
    }//GEN-LAST:event_jsCantidadMouseClicked

    private void btnRetirarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetirarActionPerformed
        RetiraInventario();
    }//GEN-LAST:event_btnRetirarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        try {
            if (txtNombre.getText().equals("Nombre.")) {
                CargarInventario();
            }
            else{
            ConsultaInventario();
            txtNombre.setText("Nombre.");
            txtNombre.setForeground(new Color(102,102,102));
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana_Inventario_Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inventario_Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inventario_Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Inventario_Retirar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Ventana_Inventario_Retirar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRetirar;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner jsCantidad;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JTable tblInventario;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
