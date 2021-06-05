/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Proyecto;

import com.sun.corba.se.impl.orbutil.CorbaResourceUtil;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diana
 */
public class Ventana_Usuario_ModificarUsuario extends javax.swing.JFrame {

    /**
     * Creates new form Ventana_Usuario_RegistrarUsuario
     */
    public Ventana_Usuario_ModificarUsuario() {
        initComponents();
        
    }
    
    public String Nombre_Usuario,Apellido_Usuario,Telefono,U,C,Correo,Direccion,Cargo,Fecha,Status;
    
    public String Actual_Nombre_Usuario,Actual_Apellido_Usuario,Actual_Telefono,Actual_U,Actual_C,
            Actual_Correo,Actual_Direccion,Actual_Cargo,Actual_Fecha,Actual_Status;
    public int id_Usuario;
    private final ConeccionBD CBD = new ConeccionBD();
    
    
    
    private boolean Vacio(){
        boolean vacio=true;
        if(!txtNombre.getText().equals("") && !txtApellido.getText().equals("") && !txtTelefono.getText().equals("")
                 && !txtUsuario.getText().equals("Usuario.") && !txtContraseña.getText().equals("Contraseña.") && !txtCorreo.getText().equals("")
                 && !txtDireccion.getText().equals("") && !txtFecha.getText().equals("") && cmbCargo.getSelectedIndex()!=0)vacio=false;

        return vacio;
    }

    private void CargaUsuario(){
        if(!Nombre_Usuario.equals(""))txtNombre.setText(Nombre_Usuario);
        if(!Apellido_Usuario.equals(""))txtApellido.setText(Apellido_Usuario);
        if(!Telefono.equals(""))txtTelefono.setText(Telefono);
        if(!U.equals(""))txtUsuario.setText(U);
        if(!C.equals(""))txtContraseña.setText(C);
        if(!Correo.equals(""))txtCorreo.setText(Correo);
        if(!Direccion.equals(""))txtDireccion.setText(Direccion);
        if(!Fecha.equals(""))txtFecha.setText(Fecha);
        
        if(Cargo.equals("Cajero")){
            cmbCargo.setSelectedIndex(1);
        }else if(Cargo.equals("Administrador")){
            cmbCargo.setSelectedIndex(2);
        }else
            cmbCargo.setSelectedIndex(0);
    }
    
    private void MandaInfoVUP(){
        Ventana_Usuario_Principal VUP = new Ventana_Usuario_Principal();
        VUP.Actual_Nombre_Usuario = Actual_Nombre_Usuario;
        VUP.Actual_Apellido_Usuario = Actual_Apellido_Usuario;
        VUP.Actual_Cargo = Actual_Cargo;
        this.dispose();
        VUP.setVisible(true);
    }
    
    private boolean validarDomicilio(JTextField c){
        String dom = c.getText();
        if(dom.matches("[a-zA-Z0-9 ]{1,} #[0-9]{1,} [a-zA-Z0-9 ]{1,}"))return true;
        else{
            c.requestFocus();
            showMessageDialog(this,"Ingrese un domicilio valido");
            return false;
        }
    }
    
    private void Orden(){
        btnConsultar.setVisible(false);
        jScrollPane1.setVisible(false);
        jLabel7.setText("Cambia tu informacion");
        txtNombre.setLocation(txtNombre.getX()+360, txtNombre.getY());
        txtCorreo.setLocation(txtCorreo.getX()+360, txtCorreo.getY());
        txtApellido.setLocation(txtApellido.getX()+360, txtApellido.getY());
        txtTelefono.setLocation(txtTelefono.getX()+360, txtTelefono.getY());
        txtUsuario.setLocation(txtUsuario.getX()+360, txtUsuario.getY());
        cmbCargo.setLocation(cmbCargo.getX()+360, cmbCargo.getY());
        txtContraseña.setLocation(txtContraseña.getX()+360, txtContraseña.getY());
        txtFecha.setLocation(txtFecha.getX()+360, txtFecha.getY());
        txtDireccion.setLocation(txtDireccion.getX()+360, txtDireccion.getY());
        btnModificar.setLocation(btnModificar.getX()+140, btnModificar.getY());
        
        txtNombre.setEnabled(false);
        txtCorreo.setEnabled(false);
        txtApellido.setEnabled(false);
        txtTelefono.setEnabled(false);
        cmbCargo.setEnabled(false);
        txtFecha.setEnabled(false);
        txtDireccion.setEnabled(false);
        btnCancelar.setVisible(false);
    }
    private void MandaInfoIP(){
        Interfaz_Principal IP = new Interfaz_Principal();
            IP.Actual_Nombre_Usuario=Actual_Nombre_Usuario;
            IP.Actual_Apellido_Usuario=Actual_Apellido_Usuario;
            IP.Actual_Telefono=Actual_Telefono;
            IP.Actual_U=Actual_U;
            IP.Actual_C=Actual_C;
            IP.Actual_Correo=Actual_Correo;
            IP.Actual_Direccion=Actual_Direccion;
            IP.Actual_Cargo=Actual_Cargo;
            IP.Actual_Fecha=Actual_Fecha;
            IP.Actual_Status="1";
            this.dispose();
            IP.setVisible(true);
    }
    
    private void ModificaUsuarioInicio(){
            
            String usuario=U,contraseña=C;
            
            try {
                Connection conectar = CBD.conectar();
                String sql;
                    sql = "UPDATE usuarios "
                    + "set Nom_Usuario = '"+usuario+"',"
                        + "Contraseña = '"+contraseña+"', "
                        + "Status = 1 "
                        + "where Nom_Usuario = '"+U+"' and Contraseña = '"+C+"'";
                
                    
                PreparedStatement pst = conectar.prepareStatement(sql);
                pst.executeUpdate();
                conectar.close();
                JOptionPane.showMessageDialog(null, "Se han guardado los cambios.");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la info.");
        }
    }
    private void SacaID(){
        String usuario = txtUsuario.getText();
        String contraseña=txtContraseña.getText();
            String sql = "select * from usuarios where Nom_Usuario='"+usuario+"' and Contraseña='"+contraseña+"'";
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
    private void ModificaUsuario(){
            String nombre, apellido,telefono,usuario,contraseña,correo,direccion,cargo,fecha;
            nombre=txtNombre.getText();
            apellido=txtApellido.getText();
            telefono=txtTelefono.getText();
            usuario=txtUsuario.getText();
            contraseña=txtContraseña.getText();
            correo=txtCorreo.getText();
            direccion=txtDireccion.getText();
            cargo=cmbCargo.getSelectedItem().toString();
            fecha=txtFecha.getText();
            
            try {
                SacaID();
                //System.out.println("ID: "+ id_Usuario);
                Connection conectar = CBD.conectar();
                
                String sql = "UPDATE usuarios set "
                        + "Nombre = ?,"
                        + "Apellido = ?,"
                        + "Telefono = ?,"
                        + "Nom_Usuario = ?,"
                        + "Contraseña = ?,"
                        + "Correo = ?,"
                        + "Direccion = ?,"
                        + "Cargo = ?,"
                        + "Fecha_Registro = ? "
                        + "where ID_Usuario = ?";
                    
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
                pst.setInt(10, id_Usuario);
                
                
                pst.executeUpdate();
                conectar.close();
                JOptionPane.showMessageDialog(null, "Se han guardado los cambios.");
           
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al guardar la informacion");
        
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
        String apellido = txtApellido.getText()+"%";
        String sql;
        if (txtApellido.getText().equals("Apellido.")){
            sql = "select * from usuarios where Nombre like '"+nombre+"'";
        }
        else{
            sql = "select * from usuarios where Nombre like '"+nombre+"' and Apellido like '"+apellido+"'";
        }
        
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
        txtFecha.setText("Fecha.");
        txtFecha.setForeground(new Color(102,102,102));
        cmbCargo.setSelectedIndex(0);
        
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        pnlInformacion = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtUsuario = new javax.swing.JTextField();
        txtContraseña = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        cmbCargo = new javax.swing.JComboBox<>();
        txtFecha = new javax.swing.JTextField();
        btnConsultar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
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
        jLabel7.setText("Modificar usuario");
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

        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logout.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar sesión");
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });
        pnlCabezera.add(btnCerrarSesion);
        btnCerrarSesion.setBounds(1087, 15, 160, 40);

        pnlFondo.add(pnlCabezera);
        pnlCabezera.setBounds(0, 0, 1270, 66);

        tblUsuarios.setBackground(new java.awt.Color(244, 241, 222));
        tblUsuarios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Apellido", "Usuario", "Contraseña", "Correo", "Dirección", "Telefono", "Cargo", "Fecha", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
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
        jScrollPane1.setBounds(710, 200, 530, 260);

        pnlInformacion.setBackground(new java.awt.Color(244, 241, 222));
        pnlInformacion.setLayout(null);

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtNombre.setForeground(new java.awt.Color(102, 102, 102));
        txtNombre.setText("Nombre.");
        txtNombre.setMaximumSize(new java.awt.Dimension(202, 28));
        txtNombre.setMinimumSize(new java.awt.Dimension(202, 28));
        txtNombre.setPreferredSize(new java.awt.Dimension(202, 28));
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtNombreFocusLost(evt);
            }
        });
        pnlInformacion.add(txtNombre);
        txtNombre.setBounds(20, 10, 202, 28);

        txtApellido.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtApellido.setForeground(new java.awt.Color(102, 102, 102));
        txtApellido.setText("Apellido.");
        txtApellido.setMaximumSize(new java.awt.Dimension(202, 28));
        txtApellido.setMinimumSize(new java.awt.Dimension(202, 28));
        txtApellido.setPreferredSize(new java.awt.Dimension(202, 28));
        txtApellido.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtApellidoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtApellidoFocusLost(evt);
            }
        });
        pnlInformacion.add(txtApellido);
        txtApellido.setBounds(20, 70, 202, 28);

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtUsuario.setForeground(new java.awt.Color(102, 102, 102));
        txtUsuario.setText("Usuario.");
        txtUsuario.setMaximumSize(new java.awt.Dimension(202, 28));
        txtUsuario.setMinimumSize(new java.awt.Dimension(202, 28));
        txtUsuario.setPreferredSize(new java.awt.Dimension(202, 28));
        txtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtUsuarioFocusLost(evt);
            }
        });
        pnlInformacion.add(txtUsuario);
        txtUsuario.setBounds(20, 130, 202, 28);

        txtContraseña.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtContraseña.setForeground(new java.awt.Color(102, 102, 102));
        txtContraseña.setText("Contraseña.");
        txtContraseña.setMaximumSize(new java.awt.Dimension(202, 28));
        txtContraseña.setMinimumSize(new java.awt.Dimension(202, 28));
        txtContraseña.setPreferredSize(new java.awt.Dimension(202, 28));
        txtContraseña.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtContraseñaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtContraseñaFocusLost(evt);
            }
        });
        pnlInformacion.add(txtContraseña);
        txtContraseña.setBounds(20, 190, 202, 28);

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtCorreo.setForeground(new java.awt.Color(102, 102, 102));
        txtCorreo.setText("Correo.");
        txtCorreo.setMaximumSize(new java.awt.Dimension(202, 28));
        txtCorreo.setMinimumSize(new java.awt.Dimension(202, 28));
        txtCorreo.setPreferredSize(new java.awt.Dimension(202, 28));
        txtCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCorreoFocusLost(evt);
            }
        });
        pnlInformacion.add(txtCorreo);
        txtCorreo.setBounds(250, 10, 202, 28);

        txtDireccion.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtDireccion.setForeground(new java.awt.Color(102, 102, 102));
        txtDireccion.setText("Dirección");
        txtDireccion.setMaximumSize(new java.awt.Dimension(438, 28));
        txtDireccion.setMinimumSize(new java.awt.Dimension(438, 28));
        txtDireccion.setPreferredSize(new java.awt.Dimension(438, 28));
        txtDireccion.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDireccionFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDireccionFocusLost(evt);
            }
        });
        pnlInformacion.add(txtDireccion);
        txtDireccion.setBounds(20, 250, 438, 28);

        txtTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTelefono.setForeground(new java.awt.Color(102, 102, 102));
        txtTelefono.setText("Teléfono.");
        txtTelefono.setMaximumSize(new java.awt.Dimension(202, 28));
        txtTelefono.setMinimumSize(new java.awt.Dimension(202, 28));
        txtTelefono.setPreferredSize(new java.awt.Dimension(202, 28));
        txtTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTelefonoFocusLost(evt);
            }
        });
        pnlInformacion.add(txtTelefono);
        txtTelefono.setBounds(250, 70, 202, 28);

        cmbCargo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmbCargo.setForeground(new java.awt.Color(102, 102, 102));
        cmbCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un cargo", "Cajero", "Administrador" }));
        cmbCargo.setMaximumSize(new java.awt.Dimension(202, 28));
        cmbCargo.setMinimumSize(new java.awt.Dimension(202, 28));
        cmbCargo.setPreferredSize(new java.awt.Dimension(202, 28));
        cmbCargo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                cmbCargoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                cmbCargoFocusLost(evt);
            }
        });
        pnlInformacion.add(cmbCargo);
        cmbCargo.setBounds(250, 130, 202, 28);

        txtFecha.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtFecha.setForeground(new java.awt.Color(102, 102, 102));
        txtFecha.setText("Fecha.");
        txtFecha.setMaximumSize(new java.awt.Dimension(202, 28));
        txtFecha.setMinimumSize(new java.awt.Dimension(202, 28));
        txtFecha.setPreferredSize(new java.awt.Dimension(202, 28));
        txtFecha.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtFechaFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtFechaFocusLost(evt);
            }
        });
        pnlInformacion.add(txtFecha);
        txtFecha.setBounds(250, 190, 202, 28);

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
        btnConsultar.setBounds(460, 10, 200, 30);

        pnlFondo.add(pnlInformacion);
        pnlInformacion.setBounds(40, 190, 1170, 290);

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnModificar.setText("Modificar usuario");
        btnModificar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnModificar);
        btnModificar.setBounds(410, 490, 170, 70);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pnlFondo.add(btnCancelar);
        btnCancelar.setBounds(670, 490, 170, 70);

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

    private void txtFechaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFocusGained
        if(txtFecha.getText().equals("Fecha.")){
            txtFecha.setText("");
            txtFecha.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtFechaFocusGained

    private void txtFechaFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtFechaFocusLost
        if(txtFecha.getText().equals("")){
            txtFecha.setText("Fecha.");
            txtFecha.setForeground(new Color(102,102,102));
        }
    }//GEN-LAST:event_txtFechaFocusLost

    private void btnConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarActionPerformed
        try {
            
                if(txtNombre.getText().equals("Nombre."))CargarUsuarios();
                else ConsultaUsuario();
            Limpiar();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnConsultarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            MandaInfoVUP();
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        this.dispose();
        Ventana_Acceso VA = new Ventana_Acceso();
        VA.setVisible(true);

    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            
            lblUsuario.setText(Actual_Cargo+": "+Actual_Nombre_Usuario+" "+Actual_Apellido_Usuario);
            CargarUsuarios();
            CargaUsuario();
            if(Actual_Status.equals("0"))
                Orden();
            
                
        } catch (Exception e) {
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(validarDomicilio(txtDireccion))
        try {
            int resp = JOptionPane.showConfirmDialog(null, 
                "¿Los datos son correctos?", "Registrar.",JOptionPane.OK_CANCEL_OPTION);
            if(resp==0){
            if(Actual_Status==null)Actual_Status="1";
            //System.out.println("Actual Status: "+Actual_Status);
            if(Actual_Status.equals("0")){
                if(Vacio()==false){
                    ModificaUsuarioInicio();
                    MandaInfoIP();
                }
                else
                    JOptionPane.showMessageDialog(null, "Hay campos vacios.");
            
            }   
            else {
                if(Vacio()==false){
                    ModificaUsuario();
                    int resp2 = JOptionPane.showConfirmDialog(null, 
                    "¿Desea modificar otro usuario?", "Modificar.",JOptionPane.YES_NO_OPTION);
                    if(resp2 == 1)
                        MandaInfoVUP();
                    else{
                        Limpiar();
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Hay campos vacios.");
            }
            }
            else{
                JOptionPane.showMessageDialog(null, "Se ha cancelado el registro.");
                Limpiar();
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        try {
            int Fila = tblUsuarios.getSelectedRow();
            UsuarioSeleccionado(Fila);
            //JOptionPane.showMessageDialog(null, Nombre_Usuario+" "+Apellido_Usuario+" "+Telefono+" "+U+" "+C+" "+Correo+" "+Direccion+" "+Cargo+" "+Fecha+" "+Status);
            CargaUsuario();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    private void cmbCargoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbCargoFocusGained
        if(cmbCargo.getSelectedIndex()!=0){
            
            cmbCargo.setForeground(Color.black);
        }
    }//GEN-LAST:event_cmbCargoFocusGained

    private void cmbCargoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_cmbCargoFocusLost
        if(cmbCargo.getSelectedIndex()==0){
            cmbCargo.setForeground(new Color(102,102,102));
            
        }
    }//GEN-LAST:event_cmbCargoFocusLost

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
            java.util.logging.Logger.getLogger(Ventana_Usuario_ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_Usuario_ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_Usuario_ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_Usuario_ModificarUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana_Usuario_ModificarUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCerrarSesion;
    private javax.swing.JButton btnConsultar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbCargo;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JPanel pnlCabezera;
    private javax.swing.JPanel pnlFondo;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContraseña;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
