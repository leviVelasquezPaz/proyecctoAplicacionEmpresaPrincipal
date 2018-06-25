package presentacion.Cliente;

import presentacion.trabajador.*;
import dominio.Persona;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import persistencia.PersonaDAO;
import persistencia.SueldoDAO;
import presentacion.frmPrincipal;
import sun.security.x509.IssuingDistributionPointExtension;

public class Panel_Agregar_Cliente extends javax.swing.JPanel {

    public static String codigo = "", id_consulta = "";
    Persona persona;
    private String nombre = "", paterno = "", celular = "", materno = "", sexo = "", dni = "", nacimiento = "", direccion = "", cargo = "", estado = "";
    private int id;
    PersonaDAO personaDAO;
    int posicionSeleccion;
    frmPrincipal p;
    SueldoDAO sueldoDAO;

    public Panel_Agregar_Cliente() {
        initComponents();
        personaDAO = new PersonaDAO();
        sueldoDAO = new SueldoDAO();
     
        txtId.setEnabled(true);
        inabilitarTextos(false);
        obtenerDatos();
        borrarDatosTextos();
        inabilitarBotones(true);
        Menu.add(pnlOpcionesP);
       

    }

    void inabilitarBotones(boolean estado) {
        btnNuevo.setEnabled(estado);
        btnAgregar.setEnabled(!estado);
        btnActualizar.setEnabled(estado);
       
    }

    void setColor(JPanel panel) {
        panel.setBackground(new Color(220, 220, 220));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(255, 255, 255));
    }

    void borrarDatosTextos() {
        txtId.setText(String.valueOf(personaDAO.obtnerCodigoPersona()));
        txtCelular.setText("");
        txtDNI.setText("");
        txtDireccion.setText("");
        txtMaterno.setText("");
        txtNombre.setText("");
        txtPaterno.setText("");
    }

    void inabilitarTextos(boolean estado) {
        txtCelular.setEnabled(estado);
        txtDNI.setEnabled(estado);
        txtDireccion.setEnabled(estado);
        txtMaterno.setEnabled(estado);
        fecha_nacimiento.setEnabled(estado);
        txtNombre.setEnabled(estado);
        txtPaterno.setEnabled(estado);
    }

    Persona recogerDatos() {
        id = Integer.parseInt(txtId.getText());
        nombre = txtNombre.getText();
        paterno = txtPaterno.getText();
        materno = txtMaterno.getText();
        if (hombre.isSelected()) {
            sexo = "Hombre";
        } else {
            sexo = "Mujer";
        }
        if (fecha_nacimiento.getDatoFecha() != null) {
            Date date = fecha_nacimiento.getDatoFecha();
            SimpleDateFormat formet = new SimpleDateFormat("dd-MM-yyyy");
            nacimiento = formet.format(date);
        }
        direccion = txtDireccion.getText();
        celular = txtCelular.getText();
        dni = txtDNI.getText();
        cargo = cboCargo.getSelectedItem().toString();
        if (activo.isSelected()) {
            estado = "Activo";
        } else {
            estado = "Inactivo";
        }
        persona = new Persona(id, nombre, paterno, materno, sexo, dni, celular, direccion, nacimiento, cargo, estado);
        System.out.println(persona.toString());
        return persona;
    }

    void visibilidadTamañoColumnas() {
        tabla_trabajador.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla_trabajador.getColumnModel().getColumn(3).setMinWidth(0);
        tabla_trabajador.getColumnModel().getColumn(3).setPreferredWidth(0);

        tabla_trabajador.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla_trabajador.getColumnModel().getColumn(4).setMinWidth(0);
        tabla_trabajador.getColumnModel().getColumn(4).setPreferredWidth(0);

        tabla_trabajador.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla_trabajador.getColumnModel().getColumn(5).setMinWidth(0);
        tabla_trabajador.getColumnModel().getColumn(5).setPreferredWidth(0);

        tabla_trabajador.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla_trabajador.getColumnModel().getColumn(6).setMinWidth(0);
        tabla_trabajador.getColumnModel().getColumn(6).setPreferredWidth(0);

        tabla_trabajador.getColumnModel().getColumn(7).setMaxWidth(0);
        tabla_trabajador.getColumnModel().getColumn(7).setMinWidth(0);
        tabla_trabajador.getColumnModel().getColumn(7).setPreferredWidth(0);

        tabla_trabajador.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla_trabajador.getColumnModel().getColumn(8).setMinWidth(0);
        tabla_trabajador.getColumnModel().getColumn(8).setPreferredWidth(0);
    }

    void obtenerDatos() {
        DefaultTableModel model = personaDAO.mostrarClientes();
        tabla_trabajador.setModel(model);
        visibilidadTamañoColumnas();
    }

    void ponerDatosEnTextos() {
        id = Integer.parseInt(tabla_trabajador.getValueAt(posicionSeleccion, 0).toString());
        nombre = tabla_trabajador.getValueAt(posicionSeleccion, 1).toString();
        paterno = tabla_trabajador.getValueAt(posicionSeleccion, 2).toString();
        materno = tabla_trabajador.getValueAt(posicionSeleccion, 3).toString();
        sexo = tabla_trabajador.getValueAt(posicionSeleccion, 4).toString();
        dni = tabla_trabajador.getValueAt(posicionSeleccion, 5).toString();
        celular = tabla_trabajador.getValueAt(posicionSeleccion, 6).toString();
        direccion = tabla_trabajador.getValueAt(posicionSeleccion, 7).toString();
        nacimiento = tabla_trabajador.getValueAt(posicionSeleccion, 8).toString();
        cargo = tabla_trabajador.getValueAt(posicionSeleccion, 9).toString();
        estado = tabla_trabajador.getValueAt(posicionSeleccion, 10).toString();

        txtId.setText(String.valueOf(id));
        txtNombre.setText(nombre);
        txtPaterno.setText(paterno);
        txtMaterno.setText(materno);
        if (sexo.equals("Hombre")) {
            hombre.setSelected(true);
            Mujer.setSelected(false);
        } else {
            hombre.setSelected(false);
            Mujer.setSelected(true);
        }

        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            Date date = format.parse(nacimiento);
            fecha_nacimiento.setDatoFecha(date);
        } catch (Exception e) {
        }
        txtDireccion.setText(direccion);
        txtCelular.setText(celular);
        txtDNI.setText(dni);
        cboCargo.setSelectedItem(cargo);
        if (estado.equals("Activo")) {
            activo.setSelected(true);
            inactivo.setSelected(false);
        } else {
            activo.setSelected(false);
            inactivo.setSelected(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonSexo = new javax.swing.ButtonGroup();
        botonEstado = new javax.swing.ButtonGroup();
        pnlOpcionesP = new javax.swing.JPanel();
        btnEliminar1 = new rojerusan.RSButtonPane();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnVer = new rojerusan.RSButtonPane();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Menu = new rojerusan.RSPopuMenu();
        panel_principal_agregar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        hombre = new javax.swing.JRadioButton();
        Mujer = new javax.swing.JRadioButton();
        activo = new javax.swing.JRadioButton();
        inactivo = new javax.swing.JRadioButton();
        rSPanelsSlider1 = new rojeru_san.RSPanelsSlider();
        txtBuscar = new org.jdesktop.swingx.JXSearchField();
        jPanel4 = new javax.swing.JPanel();
        btnNuevo = new rojerusan.RSButtonHover();
        btnAgregar = new rojerusan.RSButtonHover();
        btnActualizar = new rojerusan.RSButtonHover();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNombre = new rojerusan.RSMetroTextFullPlaceHolder();
        txtMaterno = new rojerusan.RSMetroTextFullPlaceHolder();
        txtPaterno = new rojerusan.RSMetroTextFullPlaceHolder();
        txtDNI = new rojerusan.RSMetroTextFullPlaceHolder();
        txtCelular = new rojerusan.RSMetroTextFullPlaceHolder();
        txtDireccion = new rojerusan.RSMetroTextFullPlaceHolder();
        cboCargo = new rojerusan.RSComboMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_trabajador = new rojerusan.RSTableMetro();
        fecha_nacimiento = new rojeru_san.componentes.RSDateChooser();

        btnEliminar1.setBackground(new java.awt.Color(255, 255, 255));
        btnEliminar1.setColorHover(new java.awt.Color(240, 240, 240));
        btnEliminar1.setColorNormal(new java.awt.Color(255, 255, 255));
        btnEliminar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEliminar1MousePressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 200, 91));
        jLabel15.setText("Eliminar");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Cliente/Imagenes/IconoEliminar.png"))); // NOI18N

        javax.swing.GroupLayout btnEliminar1Layout = new javax.swing.GroupLayout(btnEliminar1);
        btnEliminar1.setLayout(btnEliminar1Layout);
        btnEliminar1Layout.setHorizontalGroup(
            btnEliminar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnEliminar1Layout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(btnEliminar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnEliminar1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );
        btnEliminar1Layout.setVerticalGroup(
            btnEliminar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(btnEliminar1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnVer.setBackground(new java.awt.Color(255, 255, 255));
        btnVer.setColorHover(new java.awt.Color(240, 240, 240));
        btnVer.setColorNormal(new java.awt.Color(255, 255, 255));
        btnVer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVerMousePressed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 200, 91));
        jLabel17.setText("Ver datos completos");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Cliente/Imagenes/IconoShow.png"))); // NOI18N

        javax.swing.GroupLayout btnVerLayout = new javax.swing.GroupLayout(btnVer);
        btnVer.setLayout(btnVerLayout);
        btnVerLayout.setHorizontalGroup(
            btnVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnVerLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(btnVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(btnVerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(185, Short.MAX_VALUE)))
        );
        btnVerLayout.setVerticalGroup(
            btnVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
            .addGroup(btnVerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlOpcionesPLayout = new javax.swing.GroupLayout(pnlOpcionesP);
        pnlOpcionesP.setLayout(pnlOpcionesPLayout);
        pnlOpcionesPLayout.setHorizontalGroup(
            pnlOpcionesPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        pnlOpcionesPLayout.setVerticalGroup(
            pnlOpcionesPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlOpcionesPLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btnEliminar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnVer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_principal_agregar.setBackground(new java.awt.Color(255, 255, 255));
        panel_principal_agregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 200, 91), 5));
        panel_principal_agregar.setPreferredSize(new java.awt.Dimension(800, 650));
        panel_principal_agregar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 200, 81));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_principal_agregar.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, -1, 43));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Estado");
        panel_principal_agregar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(279, 408, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Sexo:");
        panel_principal_agregar.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(532, 336, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nacimiento:");
        panel_principal_agregar.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 342, -1, -1));

        hombre.setBackground(new java.awt.Color(255, 255, 255));
        botonSexo.add(hombre);
        hombre.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        hombre.setSelected(true);
        hombre.setText("Hombre");
        hombre.setAlignmentY(0.2F);
        panel_principal_agregar.add(hombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(602, 333, 80, 20));

        Mujer.setBackground(new java.awt.Color(255, 255, 255));
        botonSexo.add(Mujer);
        Mujer.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        Mujer.setText("Mujer");
        Mujer.setAlignmentY(0.2F);
        panel_principal_agregar.add(Mujer, new org.netbeans.lib.awtextra.AbsoluteConstraints(682, 333, 70, 20));

        activo.setBackground(new java.awt.Color(255, 255, 255));
        botonEstado.add(activo);
        activo.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        activo.setSelected(true);
        activo.setText("Activo");
        panel_principal_agregar.add(activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 405, 70, 20));

        inactivo.setBackground(new java.awt.Color(255, 255, 255));
        botonEstado.add(inactivo);
        inactivo.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        inactivo.setText("Inactivo");
        panel_principal_agregar.add(inactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(437, 405, -1, 20));

        rSPanelsSlider1.setBackground(new java.awt.Color(0, 200, 81));
        panel_principal_agregar.add(rSPanelsSlider1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 632, 800, 13));

        txtBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 200, 91)));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setName(""); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });
        panel_principal_agregar.add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(585, 57, 191, 30));

        jPanel4.setBackground(new java.awt.Color(250, 250, 250));
        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(0, 200, 91)));

        btnNuevo.setBackground(new java.awt.Color(0, 200, 91));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Cliente/Imagenes/IconoNuevo.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setColorText(new java.awt.Color(0, 0, 0));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(0, 200, 91));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Cliente/Imagenes/IconoGuardar.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setColorText(new java.awt.Color(0, 0, 0));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(0, 200, 91));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Cliente/Imagenes/IconoEditar.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setColorText(new java.awt.Color(0, 0, 0));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panel_principal_agregar.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 98, 790, -1));

        jLabel1.setText("Id");
        panel_principal_agregar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(56, 181, -1, -1));

        txtId.setText("3");
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        panel_principal_agregar.add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 175, 52, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre:");
        panel_principal_agregar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 227, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Materno:");
        panel_principal_agregar.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Paterno:");
        panel_principal_agregar.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 230, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("DNI:");
        panel_principal_agregar.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 287, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Celular:");
        panel_principal_agregar.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(266, 287, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Cargo:");
        panel_principal_agregar.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 342, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Direccion:");
        panel_principal_agregar.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(507, 287, -1, -1));

        txtNombre.setBorderColor(new java.awt.Color(0, 200, 91));
        txtNombre.setPhColor(new java.awt.Color(0, 0, 0));
        txtNombre.setSoloLetras(true);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        panel_principal_agregar.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 213, 148, -1));

        txtMaterno.setBorderColor(new java.awt.Color(0, 200, 91));
        txtMaterno.setPhColor(new java.awt.Color(0, 0, 0));
        txtMaterno.setSoloLetras(true);
        panel_principal_agregar.add(txtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 210, 160, -1));

        txtPaterno.setBorderColor(new java.awt.Color(0, 200, 91));
        txtPaterno.setPhColor(new java.awt.Color(0, 0, 0));
        txtPaterno.setSoloLetras(true);
        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaternoKeyTyped(evt);
            }
        });
        panel_principal_agregar.add(txtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 162, -1));

        txtDNI.setBorderColor(new java.awt.Color(0, 200, 91));
        txtDNI.setPhColor(new java.awt.Color(0, 0, 0));
        txtDNI.setSoloNumeros(true);
        txtDNI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDNIActionPerformed(evt);
            }
        });
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });
        panel_principal_agregar.add(txtDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 273, 152, -1));

        txtCelular.setBorderColor(new java.awt.Color(0, 200, 91));
        txtCelular.setPhColor(new java.awt.Color(0, 0, 0));
        txtCelular.setSoloNumeros(true);
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCelularKeyPressed(evt);
            }
        });
        panel_principal_agregar.add(txtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 273, 160, -1));

        txtDireccion.setBorderColor(new java.awt.Color(0, 200, 91));
        txtDireccion.setPhColor(new java.awt.Color(0, 0, 0));
        panel_principal_agregar.add(txtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(592, 273, 160, -1));

        cboCargo.setBackground(new java.awt.Color(0, 0, 0));
        cboCargo.setForeground(new java.awt.Color(0, 0, 0));
        cboCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cliente" }));
        cboCargo.setColorArrow(new java.awt.Color(0, 200, 91));
        cboCargo.setColorBorde(new java.awt.Color(0, 200, 91));
        cboCargo.setColorFondo(new java.awt.Color(0, 200, 91));
        cboCargo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        panel_principal_agregar.add(cboCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 333, 152, -1));

        tabla_trabajador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabla_trabajador.setAltoHead(35);
        tabla_trabajador.setColorBackgoundHead(new java.awt.Color(0, 200, 91));
        tabla_trabajador.setComponentPopupMenu(Menu);
        tabla_trabajador.setGrosorBordeFilas(0);
        tabla_trabajador.setGrosorBordeHead(0);
        tabla_trabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_trabajadorMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_trabajador);

        panel_principal_agregar.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 443, 758, 171));

        fecha_nacimiento.setColorBackground(new java.awt.Color(0, 200, 91));
        fecha_nacimiento.setColorButtonHover(new java.awt.Color(153, 153, 153));
        panel_principal_agregar.add(fecha_nacimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(327, 333, 162, -1));

        add(panel_principal_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setVisible(false);
        Panel_Home_Cliente a = new Panel_Home_Cliente();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (txtBuscar.getText().equals("")) {
            obtenerDatos();
        } else {
            DefaultTableModel modelo = personaDAO.buscar("Cliente", txtBuscar.getText());
            tabla_trabajador.setModel(modelo);
            visibilidadTamañoColumnas();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        borrarDatosTextos();
        inabilitarBotones(false);
        inabilitarTextos(true);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        personaDAO.agregar(recogerDatos());
        inabilitarBotones(true);
        obtenerDatos();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtDNIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDNIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDNIActionPerformed

    private void tabla_trabajadorMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_trabajadorMousePressed
        posicionSeleccion = tabla_trabajador.getSelectedRow();
        ponerDatosEnTextos();
        inabilitarTextos(true);

    }//GEN-LAST:event_tabla_trabajadorMousePressed

    private void txtCelularKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyPressed

    }//GEN-LAST:event_txtCelularKeyPressed

    private void btnEliminar1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminar1MousePressed
        int id = Integer.parseInt(tabla_trabajador.getValueAt(posicionSeleccion, 0).toString());
        personaDAO.eliminar(id, "Trabajador");
        obtenerDatos();
      
    }//GEN-LAST:event_btnEliminar1MousePressed

    private void btnVerMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerMousePressed
        if ((evt.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
            //  this.Menu.setVisible(false);
            int fila = this.tabla_trabajador.getSelectedRow();
            codigo = this.tabla_trabajador.getValueAt(fila, 0).toString();
            Panel_VisualizarDatosCliente s = new Panel_VisualizarDatosCliente(null, true);

            s.setVisible(true);

        }
    }//GEN-LAST:event_btnVerMousePressed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
          personaDAO.modificar(recogerDatos());
        obtenerDatos();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
   if(evt.getKeyChar()== KeyEvent.VK_ENTER){
       txtPaterno.requestFocus();
   }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        if(evt.getKeyChar()== KeyEvent.VK_ENTER){
            txtCelular.requestFocus();
        }
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyTyped
       if(evt.getKeyChar()==KeyEvent.VK_ENTER){
           
       }
           
    }//GEN-LAST:event_txtPaternoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSPopuMenu Menu;
    private javax.swing.JRadioButton Mujer;
    private javax.swing.JRadioButton activo;
    private javax.swing.ButtonGroup botonEstado;
    private javax.swing.ButtonGroup botonSexo;
    private rojerusan.RSButtonHover btnActualizar;
    private rojerusan.RSButtonHover btnAgregar;
    private rojerusan.RSButtonPane btnEliminar1;
    private rojerusan.RSButtonHover btnNuevo;
    private rojerusan.RSButtonPane btnVer;
    private rojerusan.RSComboMetro cboCargo;
    private rojeru_san.componentes.RSDateChooser fecha_nacimiento;
    private javax.swing.JRadioButton hombre;
    private javax.swing.JRadioButton inactivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JPanel panel_principal_agregar;
    private javax.swing.JPanel pnlOpcionesP;
    private rojeru_san.RSPanelsSlider rSPanelsSlider1;
    private rojerusan.RSTableMetro tabla_trabajador;
    private org.jdesktop.swingx.JXSearchField txtBuscar;
    private rojerusan.RSMetroTextFullPlaceHolder txtCelular;
    private rojerusan.RSMetroTextFullPlaceHolder txtDNI;
    private rojerusan.RSMetroTextFullPlaceHolder txtDireccion;
    private javax.swing.JTextField txtId;
    private rojerusan.RSMetroTextFullPlaceHolder txtMaterno;
    private rojerusan.RSMetroTextFullPlaceHolder txtNombre;
    private rojerusan.RSMetroTextFullPlaceHolder txtPaterno;
    // End of variables declaration//GEN-END:variables
}
