/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import java.awt.Color;
import java.awt.HeadlessException;
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
public class Ventana_Producto_Modificar extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Usuario_RegistrarUsuario
     */
    public Ventana_Producto_Modificar() {
        initComponents();
        
    }

    public String Nom_Producto="",Tipo="",Tamaño="",Descripcion="";
    
    public float Precio=0;
    public int id_Producto;
    public String Actual_Nombre_Usuario,Actual_Apellido_Usuario,Actual_Cargo;
    public String Anterior_Nombre, Anterior_Tipo, Anterior_Tamaño;
    private ConeccionBD CBD = new ConeccionBD();
    Connection conectar = CBD.conectar();
    
    public void ProductoSeleccionado(int Fila){
        Nom_Producto = tblProductos.getValueAt(Fila, 1).toString();
        Anterior_Nombre = tblProductos.getValueAt(Fila, 1).toString();
        Tipo = tblProductos.getValueAt(Fila, 2).toString();
        Anterior_Tipo =tblProductos.getValueAt(Fila, 2).toString();
        Tamaño = tblProductos.getValueAt(Fila, 3).toString();
        Anterior_Tamaño = tblProductos.getValueAt(Fila, 3).toString();
        Precio = Float.parseFloat(tblProductos.getValueAt(Fila, 4).toString());
        Descripcion = tblProductos.getValueAt(Fila, 5).toString();
    }
    
    private void Limpiar(){
        txtNomProducto.setText("Nombre del producto");
        txtNomProducto.setForeground(new Color(102,102,102));
        txtPrecioProducto.setText("Precio");
        txtPrecioProducto.setForeground(new Color(102,102,102));
        ta_desc.setText("Descripcion del Producto");
        ta_desc.setForeground(new Color(102,102,102));
        cmbTipo.setForeground(new Color(102,102,102));
        cmbTipo.setSelectedIndex(0);
        cmbTam.setForeground(new Color(102,102,102));
        cmbTam.setSelectedIndex(0);
    }
    
    public void limpiarTabla(){
        try {
            //System.out.println("Limpiando tabla");
            DefaultTableModel mod=(DefaultTableModel) tblProductos.getModel();
            int a=tblProductos.getRowCount()-1;
            for (int i = a; i >= 0; i--) {
                mod.removeRow(mod.getRowCount()-1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
    }
    
    private void CargarProductos(){
        limpiarTabla();
        DefaultTableModel mod =(DefaultTableModel) tblProductos.getModel();
        tblProductos.setModel(mod);
        String sql="select * from productos";
        String[] Datos = new String[6];
        try {
            CBD.conectar();
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
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos e la tabla.");
        }        
    }
    
    private void CargaProducto(){
        txtNomProducto.setText(Nom_Producto);
        txtPrecioProducto.setText(Precio+"");
        ta_desc.setText(Descripcion);
        
        switch (Tamaño) {
            case "Chico":
                cmbTam.setSelectedIndex(1);
                break;
            case "Mediano":
                cmbTam.setSelectedIndex(2);
                break;
            case "Grande":
                cmbTam.setSelectedIndex(3);
                break;
            default:
                cmbTam.setSelectedIndex(0);
                break;
        }
        
        switch (Tipo) {
            case "Pizza":
                cmbTipo.setSelectedIndex(1);
                break;
            case "Refresco":
                cmbTipo.setSelectedIndex(2);
                break;
            case "Otro":
                cmbTipo.setSelectedIndex(3);
                break;
            default:
                cmbTipo.setSelectedIndex(0);
                break;
        }
    }
    


    private void ConsultaProductos(){
        limpiarTabla();
        String nombre = txtNomProducto.getText()+"%";
        String tipo = cmbTipo.getSelectedItem().toString();
        String sql="";
        if (txtNomProducto.getText().equals("Nombre del producto") && cmbTipo.getSelectedIndex() > 0){
            sql = "select * from productos where Tipo like '"+tipo+"'";
        }
        
        if(!txtNomProducto.getText().equals("Nombre del producto") && cmbTipo.getSelectedIndex() > 0){
            sql = "select * from productos where Nom_Producto like '"+nombre+"' and Tipo like '"+tipo+"'";
        }
        
        if(!txtNomProducto.getText().equals("Nombre del producto") && cmbTipo.getSelectedIndex() == 0){
            sql = "select * from productos where Nom_Producto like '"+nombre+"'";
        }
        
        if(txtNomProducto.getText().equals("Nombre del producto") && cmbTipo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Ingresa un Nombre y/o Tipo de Producto.");
        }
        
        String[] Datos = new String[6];
        DefaultTableModel mod=(DefaultTableModel) tblProductos.getModel();
        try {
            Connection conectar = CBD.conectar();
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
            Limpiar();
        conectar.close();    
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos en la tabla.");
        }
    }
    
    private boolean Vacio(){
        boolean vacio=true;
        if(cmbTipo.getSelectedIndex()!=0 && !txtNomProducto.getText().equals("Nombre del producto") && cmbTam.getSelectedIndex()!=0
                 && !txtPrecioProducto.getText().equals("Precio") && !ta_desc.getText().equals("Descripcion del Producto"))vacio=false;

        return vacio;
    }
    
    private void SacaID(){
        String nombreProducto = txtNomProducto.getText();
        String tipo = cmbTipo.getSelectedItem().toString();
        String tamaño = cmbTam.getSelectedItem().toString();
            String sql = "select ID_Productos from productos where Nom_Producto ='"+Anterior_Nombre+"' AND Tipo = '"+Anterior_Tipo+"' AND Tamaño = '"+Anterior_Tamaño+"'";
            try {
                Connection conectar = CBD.conectar();
                Statement st = conectar.createStatement();
                ResultSet rs = st.executeQuery(sql);
                System.out.println(sql);
                try {
                    while (rs.next()){
                        id_Producto = rs.getInt(1);
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Ventana_Acceso.class.getName()).log(Level.SEVERE, null, ex);
                }
              conectar.close();
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error.");
            }
    }
    
    private boolean campoVacio(){
        boolean vacio=false;
        if(txtNomProducto.getText().equals("") || cmbTipo.getSelectedIndex() == 0 || 
                cmbTam.getSelectedIndex() == 0 || ta_desc.getText().equals("")
                || txtPrecioProducto.getText().equals(""))vacio=true;
        return vacio;
    }
    
    private void ModificaProducto(){
        Nom_Producto = txtNomProducto.getText();
        Tipo = cmbTipo.getSelectedItem().toString();
        Tamaño = cmbTam.getSelectedItem().toString();
        Precio = Float.parseFloat(txtPrecioProducto.getText());
        Descripcion = ta_desc.getText();
        
            
            try {
                SacaID();
                System.out.println(id_Producto);
                Connection conectar = CBD.conectar();
                
                String sql = "UPDATE productos set "
                        + "Nom_Producto = ?,"
                        + "Tipo = ?,"
                        + "Tamaño = ?,"
                        + "Precio = ?,"
                        + "Descripcion = ?"
                        + "where ID_Productos = ?";
                    
                PreparedStatement pst = conectar.prepareStatement(sql);
                pst.setString(1, Nom_Producto);
                pst.setString(2, Tipo);
                pst.setString(3, Tamaño);
                pst.setFloat(4, Precio);
                pst.setString(5, Descripcion);
                pst.setInt(6, id_Producto);
                             
                pst.executeUpdate();
                conectar.close();
                JOptionPane.showMessageDialog(null, "Se han guardado los cambios.");
           
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la informacion"+e);
        
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
        btnCerrarSesion = new javax.swing.JButton();
        lblUsuario = new javax.swing.JLabel();
        pnlInformacion = new javax.swing.JPanel();
        txtPrecioProducto = new javax.swing.JTextField();
        txtNomProducto = new javax.swing.JTextField();
        cmbTam = new javax.swing.JComboBox<>();
        cmbTipo = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_desc = new javax.swing.JTextArea();
        btnConsultar = new javax.swing.JButton();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();

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
        jLabel7.setText("Modificar producto");
        pnlFondo.add(jLabel7);
        jLabel7.setBounds(0, 120, 1270, 58);

        pnlCabezera.setBackground(new java.awt.Color(224, 122, 95));
        pnlCabezera.setMaximumSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setMinimumSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setPreferredSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setLayout(null);

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        pnlCabezera.add(btnCerrarSesion);
        btnCerrarSesion.setBounds(1087, 15, 160, 40);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setText("Administrador: Nombre_Usuario");
        pnlCabezera.add(lblUsuario);
        lblUsuario.setBounds(10, 20, 530, 30);

        pnlFondo.add(pnlCabezera);
        pnlCabezera.setBounds(0, 0, 1270, 66);

        pnlInformacion.setBackground(new java.awt.Color(244, 241, 222));
        pnlInformacion.setLayout(null);

        txtPrecioProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtPrecioProducto.setForeground(new java.awt.Color(102, 102, 102));
        txtPrecioProducto.setText("Precio");
        txtPrecioProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtPrecioProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtPrecioProductoFocusLost(evt);
            }
        });
        txtPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioProductoActionPerformed(evt);
            }
        });
        pnlInformacion.add(txtPrecioProducto);
        txtPrecioProducto.setBounds(230, 70, 202, 28);

        txtNomProducto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNomProducto.setForeground(new java.awt.Color(102, 102, 102));
        txtNomProducto.setText("Nombre del producto");
        txtNomProducto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNomProductoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNomProductoFocusLost(evt);
            }
        });
        txtNomProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomProductoActionPerformed(evt);
            }
        });
        pnlInformacion.add(txtNomProducto);
        txtNomProducto.setBounds(230, 10, 202, 28);

        cmbTam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbTam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tamaño", "Chico", "Mediano", "Grande" }));
        pnlInformacion.add(cmbTam);
        cmbTam.setBounds(0, 70, 200, 30);

        cmbTipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tipo de producto", "Pizza", "Refresco", "Otro" }));
        pnlInformacion.add(cmbTipo);
        cmbTipo.setBounds(0, 10, 200, 30);

        jScrollPane1.setForeground(new java.awt.Color(102, 102, 102));

        ta_desc.setColumns(20);
        ta_desc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ta_desc.setForeground(new java.awt.Color(102, 102, 102));
        ta_desc.setRows(5);
        ta_desc.setText("Descripcion del Producto");
        ta_desc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                ta_descFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                ta_descFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(ta_desc);

        pnlInformacion.add(jScrollPane1);
        jScrollPane1.setBounds(0, 130, 430, 100);

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
        btnConsultar.setBounds(440, 10, 130, 30);

        pnlFondo.add(pnlInformacion);
        pnlInformacion.setBounds(70, 180, 570, 240);

        btnRegistrar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnRegistrar.setText("Modificar producto");
        btnRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnRegistrar);
        btnRegistrar.setBounds(410, 460, 170, 70);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnCancelar);
        btnCancelar.setBounds(670, 460, 170, 70);

        tblProductos.setBackground(new java.awt.Color(244, 241, 222));
        tblProductos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idProducto", "NombreProducto", "Tipo", "Tamaño", "Precio", "Descripcion"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.getTableHeader().setReorderingAllowed(false);
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProductos);
        if (tblProductos.getColumnModel().getColumnCount() > 0) {
            tblProductos.getColumnModel().getColumn(0).setResizable(false);
            tblProductos.getColumnModel().getColumn(1).setResizable(false);
            tblProductos.getColumnModel().getColumn(2).setResizable(false);
            tblProductos.getColumnModel().getColumn(3).setResizable(false);
            tblProductos.getColumnModel().getColumn(4).setResizable(false);
            tblProductos.getColumnModel().getColumn(5).setResizable(false);
        }

        pnlFondo.add(jScrollPane2);
        jScrollPane2.setBounds(680, 190, 550, 230);

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

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);
       
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        MandaInfoVPP();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNomProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomProductoFocusGained
        if(txtNomProducto.getText().equals("Nombre del producto")){
            txtNomProducto.setText("");
            txtNomProducto.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNomProductoFocusGained

    private void txtNomProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomProductoActionPerformed

    private void txtNomProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNomProductoFocusLost
        if(txtNomProducto.getText().equals("")){
            txtNomProducto.setText("Nombre del producto");
            txtNomProducto.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtNomProductoFocusLost

    private void txtPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioProductoActionPerformed

    private void txtPrecioProductoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioProductoFocusGained
        if(txtPrecioProducto.getText().equals("Precio")){
            txtPrecioProducto.setText("");
            txtPrecioProducto.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtPrecioProductoFocusGained

    private void txtPrecioProductoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtPrecioProductoFocusLost
        if(txtPrecioProducto.getText().equals("")){
            txtPrecioProducto.setText("Precio");
            txtPrecioProducto.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtPrecioProductoFocusLost

    private void ta_descFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ta_descFocusGained
        if(ta_desc.getText().equals("Descripcion del Producto")){
            ta_desc.setText("");
            ta_desc.setForeground(Color.black);
        }
    }//GEN-LAST:event_ta_descFocusGained

    private void ta_descFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ta_descFocusLost
        if(ta_desc.getText().equals("")){
            ta_desc.setText("Descripcion del Producto");
            ta_desc.setForeground(Color.black);
        }
    }//GEN-LAST:event_ta_descFocusLost

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try {    
            limpiarTabla();
            if(txtNomProducto.getText().equals("Nombre del producto") && cmbTipo.getSelectedIndex() == 0){
                CargarProductos();
            }else{
                ConsultaProductos();
            }
            Limpiar();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lblUsuario.setText(Actual_Cargo+": "+Actual_Nombre_Usuario+" "+Actual_Apellido_Usuario);
    }//GEN-LAST:event_formWindowOpened

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        try {
            int resp = JOptionPane.showConfirmDialog(null, 
                "¿Los datos son correctos?", "Modificar.",JOptionPane.OK_CANCEL_OPTION);
            if(resp==0){
            
                if(Vacio()==false){
                    ModificaProducto();
                    int resp2 = JOptionPane.showConfirmDialog(null, 
                    "¿Desea hacer un nuevo registro?", "Registrar.",JOptionPane.YES_NO_OPTION);
                    if(resp2 == 1)
                        MandaInfoVPP();
                    else
                        Limpiar();
                }
                else
                    JOptionPane.showMessageDialog(null, "Hay campos vacios.");
            
            }
            else{
                JOptionPane.showMessageDialog(null, "Se ha cancelado el registro.");
                Limpiar();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        try {
            int Fila = tblProductos.getSelectedRow();
            ProductoSeleccionado(Fila);
            CargaProducto();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al cargar los datos e la tabla.");
        }
    }//GEN-LAST:event_tblProductosMouseClicked

    private void MandaInfoVPP(){
        Ventana_Producto_Principal VPP = new Ventana_Producto_Principal();
        VPP.Actual_Nombre_Usuario=Actual_Nombre_Usuario;
        VPP.Actual_Apellido_Usuario=Actual_Apellido_Usuario;
        VPP.Actual_Cargo=Actual_Cargo;
        this.dispose();
        VPP.setVisible(true);
    }
    
    
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
            java.util.logging.Logger.getLogger(Ventana_Producto_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Producto_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Producto_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Producto_Modificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Producto_Modificar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JComboBox<String> cmbTam;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JTextArea ta_desc;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtNomProducto;
    private javax.swing.JTextField txtPrecioProducto;
    // End of variables declaration//GEN-END:variables
}
