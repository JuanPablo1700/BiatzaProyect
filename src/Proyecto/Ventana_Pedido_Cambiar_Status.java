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
import java.awt.event.KeyEvent;
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
public class Ventana_Pedido_Cambiar_Status extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Usuario_Principal
     */
    public String Actual_Nombre_Usuario,Actual_Apellido_Usuario,Actual_Telefono,Actual_U,Actual_C,
            Actual_Correo,Actual_Direccion,Actual_Cargo,Actual_Fecha,Actual_Status, Id_Usuario;
    public int Actual_ID;
    private DefaultTableModel m2;
    private ConeccionBD CBD = new ConeccionBD();
    
    
    public Ventana_Pedido_Cambiar_Status() {
        initComponents();
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
    
    private void cargarDetallePedido(){
        m2.setRowCount(0);
        lblTotal.setText("");
        String sql = "select p.Nom_Producto,dp.Cantidad,dp.PrecioUnitario,dp.Importe "
                + "from detalle_pedido dp inner join productos p on dp.Productos_ID_Productos=p.ID_Productos where "
                + "dp.Pedido_ID_Pedido= "+Actual_ID;
        Connection conectar = CBD.conectar();
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
    
    private void calcularCambio(){
        float recibido = Float.parseFloat(txtRecibido.getText()), 
                total = Float.parseFloat(lblTotal.getText());
        if(recibido<total)showMessageDialog(this,"No se cubre el monto completo");
        else lblCambio.setText((recibido-total)+"");
    }
    
    private void modificarEstatus(){
        if(insertarBillullo()){
            try {
                Connection conectar = CBD.conectar();
                
                String sql = "UPDATE pedido set "
                        + "Status = ? "
                        + "where ID_Pedido = ?";
                System.out.println(sql);
                PreparedStatement pst = conectar.prepareStatement(sql);
                pst.setString(1, "Pagado");
                pst.setInt(2, Actual_ID);
                
                
                pst.executeUpdate();
                conectar.close();
               
                JOptionPane.showMessageDialog(null, "Movimiento realizado.");
                Ventana_Pedido_Principal vtn = new Ventana_Pedido_Principal();
                mandaInfoVPP(vtn);
           
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error al guardar la informacion");

                }
        } 
        
    }
    
    private boolean insertarBillullo(){
        float saldo=0;
        String sql = "select Saldo from Corte_Caja where idMovimiento = (select MAX(idMovimiento) from Corte_CAJA)";
        Connection conectar = CBD.conectar();
        try{
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            String[] O = new String[4];
            rs.next();
            saldo=Float.parseFloat(rs.getString(1));
           
        }catch(Exception e){}
        try {
                
                sql = "insert into Corte_Caja (Fecha, Tipo, Concepto, Monto, Saldo, Id_Usuario) " +
                                                             "values (curdate(),'Ingreso','Venta',?,?,?)";
                float monto = Float.parseFloat(lblTotal.getText());
                saldo += monto;
                System.out.println(" Consulta: "+sql + monto +" "+ saldo+" "+ Id_Usuario);   
                PreparedStatement pst = conectar.prepareStatement(sql);
                
                pst.setFloat(1, monto);
                pst.setFloat(2, saldo);
                pst.setString(3, Id_Usuario);
                
                pst.executeUpdate();
                conectar.close();
                return true;
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al insertar la billetiza");
        
        }
        return false;
    }
    
    private void obtenerIdUsuario(){
        String sql = "select ID_Usuario from usuarios where nombre='"+Actual_Nombre_Usuario+"' and Apellido = '"+Actual_Apellido_Usuario+"' and Telefono = '"+Actual_Telefono+"';";
        try{
            Connection conectar = CBD.conectar();
            Statement st = conectar.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            Id_Usuario = rs.getString(1);
            conectar.close(); 
        }catch(Exception e){}
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
        lblTotal = new javax.swing.JLabel();
        btnRegresar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDetalle = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtRecibido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lblCambio = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

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
        lblTitulo.setText("Dar de baja pedido");
        panelClaro.add(lblTitulo);
        lblTitulo.setBounds(0, 60, 1270, 58);

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

        lblTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblTotal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panelClaro.add(lblTotal);
        lblTotal.setBounds(380, 390, 200, 30);

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
        btnRegresar1.setBounds(730, 500, 170, 60);

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
        jScrollPane1.setBounds(280, 120, 750, 260);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Cambio:");
        panelClaro.add(jLabel3);
        jLabel3.setBounds(470, 440, 130, 30);

        txtRecibido.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtRecibido.setForeground(new java.awt.Color(102, 102, 102));
        txtRecibido.setText("Cantidad Recibida");
        txtRecibido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtRecibidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtRecibidoFocusLost(evt);
            }
        });
        txtRecibido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtRecibidoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRecibidoKeyReleased(evt);
            }
        });
        panelClaro.add(txtRecibido);
        txtRecibido.setBounds(810, 390, 210, 35);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Total:");
        panelClaro.add(jLabel4);
        jLabel4.setBounds(280, 390, 90, 30);

        lblCambio.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblCambio.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        panelClaro.add(lblCambio);
        lblCambio.setBounds(630, 440, 200, 30);

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setActionCommand("Registrar");
        btnAceptar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        panelClaro.add(btnAceptar);
        btnAceptar.setBounds(390, 500, 170, 60);

        getContentPane().add(panelClaro);
        panelClaro.setBounds(0, 0, 1270, 680);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
        m2 = (DefaultTableModel) tblDetalle.getModel();
        tblDetalle.setModel(m2);
        cargarDetallePedido();
        obtenerIdUsuario();
        //cargarTabla("select P.ID_Pedido,concat(U.Nombre,' ',U.apellido),P.Cliente_Tel_Cliente,P.Fecha,P.Hora,P.Total,P.Status from pedido P inner join usuarios U on P.Usuarios_ID_Usuario=U.ID_Usuario");
    }//GEN-LAST:event_formWindowOpened

    private void tblDetalleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDetalleMouseClicked
        
    }//GEN-LAST:event_tblDetalleMouseClicked

    private void txtRecibidoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRecibidoFocusGained
        if(txtRecibido.getText().equals("Cantidad Recibida")){
            txtRecibido.setText("");
            txtRecibido.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtRecibidoFocusGained

    private void txtRecibidoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtRecibidoFocusLost
        if(txtRecibido.getText().equals("")){
            txtRecibido.setText("Cantidad Recibida");
            txtRecibido.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtRecibidoFocusLost

    private void txtRecibidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecibidoKeyReleased
        
    }//GEN-LAST:event_txtRecibidoKeyReleased

    private void txtRecibidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRecibidoKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            calcularCambio();
            btnAceptar.setEnabled(true);
        }
    }//GEN-LAST:event_txtRecibidoKeyPressed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        modificarEstatus();
    }//GEN-LAST:event_btnAceptarActionPerformed

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
            java.util.logging.Logger.getLogger(Ventana_Pedido_Cambiar_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Pedido_Cambiar_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Pedido_Cambiar_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Pedido_Cambiar_Status.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new Ventana_Pedido_Cambiar_Status().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnRegresar1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCambio;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel panelClaro;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JTable tblDetalle;
    private javax.swing.JTextField txtRecibido;
    // End of variables declaration//GEN-END:variables
}
