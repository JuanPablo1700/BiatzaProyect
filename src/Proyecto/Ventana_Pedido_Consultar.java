/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author arlet
 */
public class Ventana_Pedido_Consultar extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Usuario_Principal
     */
    public String Actual_Nombre_Usuario,Actual_Apellido_Usuario,Actual_Telefono,Actual_U,Actual_C,
            Actual_Correo,Actual_Direccion,Actual_Cargo,Actual_Fecha,Actual_Status;
    private DefaultTableModel m;
    private DefaultTableModel m2;
    private ConeccionBD CBD = new ConeccionBD();
    
    
    public Ventana_Pedido_Consultar() {
        initComponents();
    }

    private void cargarTabla(String sql){
        m.setRowCount(0);
        Connection conectar = CBD.conectar();
        try{
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String[] O = new String[7];
            while(rs.next()){
                O[0] = rs.getString(1);
                O[1] = rs.getString(2);
                O[2] = rs.getString(3);
                O[3] = rs.getString(4);
                O[4] = rs.getString(5);
                O[5] = rs.getString(6);
                O[6] = rs.getString(7);
                m.addRow(O);
            }
            conectar.close(); 
        }catch(Exception e){}
    }//En este metodo se inicializa la tabla y el label con los datos
    
    private void cargarUsuarios(String sql){
        Connection conectar = CBD.conectar();
        try{
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               cmbUsuario.addItem(rs.getString(1));
            }
            conectar.close(); 
        }catch(Exception e){}
    }
    private void mandaInfoVPP(Ventana_Pedido_Principal vtn){
        vtn.Actual_Nombre_Usuario=Actual_Nombre_Usuario;
        vtn.Actual_Apellido_Usuario=Actual_Apellido_Usuario;
        vtn.Actual_Telefono=Actual_Telefono;
        vtn.Actual_U=Actual_U;
        vtn.Actual_C=Actual_C;
        vtn.Actual_Correo=Actual_Correo;
        vtn.Actual_Direccion=Actual_Direccion;
        vtn.Actual_Cargo=Actual_Cargo;
        vtn.Actual_Fecha=Actual_Fecha;
        vtn.Actual_Status=Actual_Status;
        this.dispose();
        vtn.setVisible(true);
    }
    
    public boolean validarJDateChooser(JDateChooser d){
        if((((JTextField)d.getDateEditor().getUiComponent()).getText().isEmpty())){
            /*Toolkit.getDefaultToolkit().beep();
            d.requestFocus();
            showMessageDialog(this,"Inserte una fecha valida");
            */
            return false;
        }
        return true;
    }
    
    private void cargarDetallePedido(int id){
        m2.setRowCount(0);

        Connection conectar = CBD.conectar();
        String sql = "select p.Nom_Producto,dp.Cantidad,dp.PrecioUnitario,dp.Importe "
                + "from detalle_pedido dp inner join productos p on dp.Productos_ID_Productos=p.ID_Productos where "
                + "dp.Pedido_ID_Pedido= "+id;
        CBD.conectar();
        try{
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String[] O = new String[4];
            float total=0;
            while(rs.next()){
                O[0] = rs.getString(1);
                O[1] = rs.getString(2);
                O[2] = rs.getString(3);
                O[3] = rs.getString(4);
                total+=Float.parseFloat(O[3]+"");
                m2.addRow(O);
            }
            lblTotal.setText(total+"");
            conectar.close(); 
        }catch(Exception e){}
    }
    private void cargarReclamo(int id){
        lblTotal.setText("");
        String sql = "select Descripcion from pedido where ID_Pedido =  "+id;
        Connection conectar = CBD.conectar();
        try{
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            txtIdPedido1.setText(rs.getString(1));
            conectar.close();
         }catch(Exception e){}
        if(txtIdPedido1.getText().equals(""))txtIdPedido1.setText("Descripción del Reclamo");
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelClaro = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        pnlCabezera = new javax.swing.JPanel();
        lblUsuario = new javax.swing.JLabel();
        btnCerrarSesion = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        lblTotal = new javax.swing.JLabel();
        btnRegresar1 = new javax.swing.JButton();
        dcFecha = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedidos = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        cmbEstatus = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        cmbUsuario = new javax.swing.JComboBox<>();
        txtIdPedido1 = new javax.swing.JTextField();

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

        panelClaro.setBackground(new java.awt.Color(244, 241, 222));
        panelClaro.setMaximumSize(new java.awt.Dimension(1270, 583));
        panelClaro.setMinimumSize(new java.awt.Dimension(1270, 583));
        panelClaro.setPreferredSize(new java.awt.Dimension(1270, 583));
        panelClaro.setLayout(null);

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Consultar pedido");
        panelClaro.add(lblTitulo);
        lblTitulo.setBounds(0, 80, 1270, 58);

        pnlCabezera.setBackground(new java.awt.Color(224, 122, 95));
        pnlCabezera.setMaximumSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setMinimumSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setPreferredSize(new java.awt.Dimension(1270, 66));
        pnlCabezera.setLayout(null);

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setText("Administrador: Nombre_Usuario");
        pnlCabezera.add(lblUsuario);
        lblUsuario.setBounds(10, 20, 700, 30);

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

        panelClaro.add(pnlCabezera);
        pnlCabezera.setBounds(0, 0, 1270, 60);

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setText("Consultar");
        btnBuscar.setActionCommand("Registrar");
        btnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        panelClaro.add(btnBuscar);
        btnBuscar.setBounds(920, 160, 130, 30);

        lblTotal.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panelClaro.add(lblTotal);
        lblTotal.setBounds(850, 490, 200, 30);

        btnRegresar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnRegresar1.setText("Regresar");
        btnRegresar1.setActionCommand("Registrar");
        btnRegresar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnRegresar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresar1ActionPerformed(evt);
            }
        });
        panelClaro.add(btnRegresar1);
        btnRegresar1.setBounds(580, 510, 170, 60);
        panelClaro.add(dcFecha);
        dcFecha.setBounds(360, 160, 100, 30);

        tblDetalle.setBackground(new java.awt.Color(244, 241, 222));
        tblDetalle.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        tblDetalle.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Producto", "Cantidad", "Precio Unitario", "Importe"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDetalle.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblDetalle.getTableHeader().setReorderingAllowed(false);
        tblDetalle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDetalleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDetalle);

        panelClaro.add(jScrollPane1);
        jScrollPane1.setBounds(300, 400, 750, 90);

        tblPedidos.setBackground(new java.awt.Color(244, 241, 222));
        tblPedidos.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        tblPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "idPedido", "idUsuario", "Cliente Telefono", "Fecha", "Hora", "Total", "Estatus"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedidos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblPedidos.getTableHeader().setReorderingAllowed(false);
        tblPedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPedidos);

        panelClaro.add(jScrollPane2);
        jScrollPane2.setBounds(300, 240, 750, 150);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Total:");
        panelClaro.add(jLabel3);
        jLabel3.setBounds(790, 490, 60, 30);

        cmbEstatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbEstatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estatus", "Activo", "Pagado", "Reclamacion" }));
        cmbEstatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstatusActionPerformed(evt);
            }
        });
        panelClaro.add(cmbEstatus);
        cmbEstatus.setBounds(490, 160, 160, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Fecha:");
        panelClaro.add(jLabel5);
        jLabel5.setBounds(280, 160, 60, 30);

        cmbUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cmbUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Atendió" }));
        cmbUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbUsuarioActionPerformed(evt);
            }
        });
        panelClaro.add(cmbUsuario);
        cmbUsuario.setBounds(670, 160, 230, 30);

        txtIdPedido1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtIdPedido1.setForeground(new java.awt.Color(102, 102, 102));
        txtIdPedido1.setText("Descripción del Reclamo");
        txtIdPedido1.setEnabled(false);
        txtIdPedido1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtIdPedido1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtIdPedido1FocusLost(evt);
            }
        });
        txtIdPedido1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdPedido1ActionPerformed(evt);
            }
        });
        panelClaro.add(txtIdPedido1);
        txtIdPedido1.setBounds(300, 200, 750, 30);

        getContentPane().add(panelClaro);
        panelClaro.setBounds(0, 0, 1270, 680);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String query = "";
        String nombreC[] = cmbUsuario.getSelectedItem().toString().split(" , ");
        if(validarJDateChooser(dcFecha)){
            String fecha = dcFecha.getDate().getYear()+"/"+((dcFecha.getDate().getMonth())+1)+"/"+dcFecha.getDate().getDate();
            fecha = fecha.substring(1, fecha.length());
            if(cmbEstatus.getSelectedIndex()<=0 && cmbUsuario.getSelectedIndex()<=0)query = "select p.ID_Pedido,u.nombre,p.Cliente_Tel_Cliente,p.Fecha,p.Hora,p.Total,p.status from pedido p inner join usuarios u on p.Usuarios_ID_Usuario=u.ID_Usuario where p.Fecha = '"+fecha+"';";
            else if (cmbEstatus.getSelectedIndex()>0 && cmbUsuario.getSelectedIndex()>0) query = "select p.ID_Pedido,u.nombre,p.Cliente_Tel_Cliente,p.Fecha,p.Hora,p.Total,p.status from pedido p inner join usuarios u on p.Usuarios_ID_Usuario=u.ID_Usuario where p.Fecha = '"+fecha+"' and  u.nombre = '"+nombreC[0]+
                    "' and u.Apellido = '"+nombreC[1]+"'and p.Status = '"+cmbEstatus.getSelectedItem()+"';";
            else if (cmbEstatus.getSelectedIndex()>0 && cmbUsuario.getSelectedIndex()<=0)query = "select p.ID_Pedido,u.nombre,p.Cliente_Tel_Cliente,p.Fecha,p.Hora,p.Total,p.status from pedido p inner join usuarios u on p.Usuarios_ID_Usuario=u.ID_Usuario where p.Fecha = '"+fecha+"' and p.Status = '"+
                    cmbEstatus.getSelectedItem()+"';";
            else if (cmbEstatus.getSelectedIndex()<=0 && cmbUsuario.getSelectedIndex()>0)query = "select p.ID_Pedido,u.nombre,p.Cliente_Tel_Cliente,p.Fecha,p.Hora,p.Total,p.status from pedido p inner join usuarios u on p.Usuarios_ID_Usuario=u.ID_Usuario where p.Fecha = '"+fecha+"' and u.nombre = '"+nombreC[0]+
                    "' and u.Apellido = '"+nombreC[1]+"';";
        }else{
            
            if(cmbEstatus.getSelectedIndex()<=0 && cmbUsuario.getSelectedIndex()<=0)query = "select p.ID_Pedido,u.nombre,p.Cliente_Tel_Cliente,p.Fecha,p.Hora,p.Total,p.status from pedido p inner join usuarios u on p.Usuarios_ID_Usuario=u.ID_Usuario;";
            else if (cmbEstatus.getSelectedIndex()>0 && cmbUsuario.getSelectedIndex()>0) query = "select p.ID_Pedido,u.nombre,p.Cliente_Tel_Cliente,p.Fecha,p.Hora,p.Total,p.status from pedido p inner join usuarios u on p.Usuarios_ID_Usuario=u.ID_Usuario where u.nombre = '"+nombreC[0]+
                    "' and u.Apellido = '"+nombreC[1]+"'and p.Status = '"+cmbEstatus.getSelectedItem()+"';";
            else if (cmbEstatus.getSelectedIndex()>0 && cmbUsuario.getSelectedIndex()<=0)query = "select p.ID_Pedido,u.nombre,p.Cliente_Tel_Cliente,p.Fecha,p.Hora,p.Total,p.status from pedido p inner join usuarios u on p.Usuarios_ID_Usuario=u.ID_Usuario where p.Status = '"+
                    cmbEstatus.getSelectedItem()+"';";
            else if (cmbEstatus.getSelectedIndex()<=0 && cmbUsuario.getSelectedIndex()>0)query = "select p.ID_Pedido,u.nombre,p.Cliente_Tel_Cliente,p.Fecha,p.Hora,p.Total,p.status from pedido p inner join usuarios u on p.Usuarios_ID_Usuario=u.ID_Usuario where u.nombre = '"+nombreC[0]+
                    "' and u.Apellido = '"+nombreC[1]+"';";
            
        }
        cargarTabla(query);
        
        
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegresar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresar1ActionPerformed
        //txtIdPedido.setEnabled(false);
        Ventana_Pedido_Principal vtn = new Ventana_Pedido_Principal();
        mandaInfoVPP(vtn);
    }//GEN-LAST:event_btnRegresar1ActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
    //txtIdPedido.setEnabled(false);
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lblUsuario.setText(Actual_Cargo+": "+Actual_Nombre_Usuario+" "+Actual_Apellido_Usuario);
        m = (DefaultTableModel) tblPedidos.getModel();
        tblPedidos.setModel(m);
        m2 = (DefaultTableModel) tblDetalle.getModel();
        tblDetalle.setModel(m2);
        cargarTabla("select P.ID_Pedido,concat(U.Nombre,' ',U.apellido),P.Cliente_Tel_Cliente,P.Fecha,P.Hora,P.Total,P.Status from pedido P inner join usuarios U on P.Usuarios_ID_Usuario=U.ID_Usuario");
        cargarUsuarios("select concat(Nombre,' , ',Apellido) as nombreCompleto from usuarios;");
    }//GEN-LAST:event_formWindowOpened

    private void tblDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleMouseClicked
        
    }//GEN-LAST:event_tblDetalleMouseClicked

    private void tblPedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidosMouseClicked

        try {
            int Fila = tblPedidos.getSelectedRow();
            int id_Det = Integer.parseInt(m.getValueAt(Fila,0)+"");
            cargarDetallePedido(id_Det);
            cargarReclamo(id_Det);
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblPedidosMouseClicked

    private void cmbEstatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstatusActionPerformed

    }//GEN-LAST:event_cmbEstatusActionPerformed

    private void cmbUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbUsuarioActionPerformed

    private void txtIdPedido1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdPedido1FocusGained
    }//GEN-LAST:event_txtIdPedido1FocusGained

    private void txtIdPedido1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtIdPedido1FocusLost
    }//GEN-LAST:event_txtIdPedido1FocusLost

    private void txtIdPedido1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdPedido1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdPedido1ActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana_Pedido_Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Pedido_Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Pedido_Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Pedido_Consultar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Ventana_Pedido_Consultar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JComboBox<String> cmbEstatus;
    private javax.swing.JComboBox<String> cmbUsuario;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelClaro;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTable tblPedidos;
    private javax.swing.JTextField txtIdPedido1;
    // End of variables declaration//GEN-END:variables
}
