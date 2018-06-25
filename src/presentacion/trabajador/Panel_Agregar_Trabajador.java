/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.trabajador;

import com.sun.glass.events.KeyEvent;
import dominio.Persona;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Point;
import java.awt.TextField;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import persistencia.PersonaDAO;
import persistencia.SueldoDAO;
import presentacion.frmPrincipal;
import sun.security.x509.IssuingDistributionPointExtension;

/**
 *
 * @author MINERAMIRAFLORES
 */
public class Panel_Agregar_Trabajador extends javax.swing.JPanel {

    Persona persona;
    private String nombre = "", paterno = "", celular = "", materno = "", sexo = "", dni = "", nacimiento = "", direccion = "", cargo = "", estado = "";
    private int id;
    PersonaDAO personaDAO;
    int posicionSeleccion;
    frmPrincipal p;
    SueldoDAO sueldoDAO;
    

    public Panel_Agregar_Trabajador() {
        initComponents();
        personaDAO = new PersonaDAO();
        sueldoDAO = new SueldoDAO();
        agregar.setEnabled(false);
        txtId.setEnabled(false);
        inabilitarTextos(false);
        obtenerDatos();
        borrarDatosTextos();
        cargarCargosTrabajadores();
        inabilitarBotones(false);
        txtNombre.requestFocus();

    }

    void inabilitarBotones(boolean estado) {
        agregar.setEnabled(estado);
        actualizar.setEnabled(!estado);
        eliminar.setEnabled(!estado);
    }

    void cargarCargosTrabajadores() {
        sueldoDAO.cargarCargos();
        ArrayList listCargos = sueldoDAO.listaCargos;
        cbxCargo.removeAllItems();
        for (int i = 0; i < listCargos.size(); i++) {
            cbxCargo.addItem(listCargos.get(i).toString());
        }
        sueldoDAO.listaCargos.clear();

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
        if (fecha_nacimiento.getDate() != null) {
            Date date = fecha_nacimiento.getDate();
            SimpleDateFormat formet = new SimpleDateFormat("dd-MM-yyyy");
            nacimiento = formet.format(date);
        }
        direccion = txtDireccion.getText();
        celular = txtCelular.getText();
        dni = txtDNI.getText();
        cargo = cbxCargo.getSelectedItem().toString();
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
        tableMetroICM1.getColumnModel().getColumn(3).setMaxWidth(0);
        tableMetroICM1.getColumnModel().getColumn(3).setMinWidth(0);
        tableMetroICM1.getColumnModel().getColumn(3).setPreferredWidth(0);

        tableMetroICM1.getColumnModel().getColumn(4).setMaxWidth(0);
        tableMetroICM1.getColumnModel().getColumn(4).setMinWidth(0);
        tableMetroICM1.getColumnModel().getColumn(4).setPreferredWidth(0);

        tableMetroICM1.getColumnModel().getColumn(5).setMaxWidth(0);
        tableMetroICM1.getColumnModel().getColumn(5).setMinWidth(0);
        tableMetroICM1.getColumnModel().getColumn(5).setPreferredWidth(0);

        tableMetroICM1.getColumnModel().getColumn(6).setMaxWidth(0);
        tableMetroICM1.getColumnModel().getColumn(6).setMinWidth(0);
        tableMetroICM1.getColumnModel().getColumn(6).setPreferredWidth(0);

        tableMetroICM1.getColumnModel().getColumn(7).setMaxWidth(0);
        tableMetroICM1.getColumnModel().getColumn(7).setMinWidth(0);
        tableMetroICM1.getColumnModel().getColumn(7).setPreferredWidth(0);

        tableMetroICM1.getColumnModel().getColumn(8).setMaxWidth(0);
        tableMetroICM1.getColumnModel().getColumn(8).setMinWidth(0);
        tableMetroICM1.getColumnModel().getColumn(8).setPreferredWidth(0);
    }

    void obtenerDatos() {
        DefaultTableModel model = personaDAO.mostrarTrabajadores();
        tableMetroICM1.setModel(model);
        visibilidadTamañoColumnas();
    }

    void ponerDatosEnTextos() {
        id = Integer.parseInt(tableMetroICM1.getValueAt(posicionSeleccion, 0).toString());
        nombre = tableMetroICM1.getValueAt(posicionSeleccion, 1).toString();
        paterno = tableMetroICM1.getValueAt(posicionSeleccion, 2).toString();
        materno = tableMetroICM1.getValueAt(posicionSeleccion, 3).toString();
        sexo = tableMetroICM1.getValueAt(posicionSeleccion, 4).toString();
        dni = tableMetroICM1.getValueAt(posicionSeleccion, 5).toString();
        celular = tableMetroICM1.getValueAt(posicionSeleccion, 6).toString();
        direccion = tableMetroICM1.getValueAt(posicionSeleccion, 7).toString();
        nacimiento = tableMetroICM1.getValueAt(posicionSeleccion, 8).toString();
        cargo = tableMetroICM1.getValueAt(posicionSeleccion, 9).toString();
        estado = tableMetroICM1.getValueAt(posicionSeleccion, 10).toString();

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
            fecha_nacimiento.setDate(date);
        } catch (Exception e) {
        }
        txtDireccion.setText(direccion);
        txtCelular.setText(celular);
        txtDNI.setText(dni);
        cbxCargo.setSelectedItem(cargo);
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
        panel_principal_agregar = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        nuevo = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        agregar = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        eliminar = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        actualizar = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableMetroICM1 = new javax.swing.JTable();
        rSPanelsSlider1 = new rojeru_san.RSPanelsSlider();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        rSPanelsSlider2 = new rojeru_san.RSPanelsSlider();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new rojeru_san.RSMTextFull();
        jLabel5 = new javax.swing.JLabel();
        txtPaterno = new rojeru_san.RSMTextFull();
        txtMaterno = new rojeru_san.RSMTextFull();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDNI = new rojeru_san.RSMTextFull();
        txtDireccion = new rojeru_san.RSMTextFull();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hombre = new javax.swing.JRadioButton();
        Mujer = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        activo = new javax.swing.JRadioButton();
        inactivo = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        cbxCargo = new com.icm.components.metro.ComboboxMetroICM();
        fecha_nacimiento = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCelular = new rojeru_san.RSMTextFull();

        setMinimumSize(new java.awt.Dimension(800, 650));
        setPreferredSize(new java.awt.Dimension(800, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_principal_agregar.setBackground(new java.awt.Color(189, 189, 189));
        panel_principal_agregar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        panel_principal_agregar.setToolTipText("");
        panel_principal_agregar.setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel2.setBackground(new java.awt.Color(0, 200, 81));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 50));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        txtBuscar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtBuscarFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtBuscarFocusLost(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 518, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Id");

        txtId.setText("3");
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)));

        nuevo.setBackground(new java.awt.Color(255, 255, 255));
        nuevo.setMinimumSize(new java.awt.Dimension(50, 50));
        nuevo.setPreferredSize(new java.awt.Dimension(70, 70));
        nuevo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nuevoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nuevoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nuevoMouseExited(evt);
            }
        });

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/new.png"))); // NOI18N

        jLabel13.setText("Nuevo");

        javax.swing.GroupLayout nuevoLayout = new javax.swing.GroupLayout(nuevo);
        nuevo.setLayout(nuevoLayout);
        nuevoLayout.setHorizontalGroup(
            nuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(nuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14)))
        );
        nuevoLayout.setVerticalGroup(
            nuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel14)
                .addGap(10, 10, 10)
                .addComponent(jLabel13))
        );

        agregar.setBackground(new java.awt.Color(255, 255, 255));
        agregar.setMinimumSize(new java.awt.Dimension(50, 50));
        agregar.setPreferredSize(new java.awt.Dimension(70, 70));
        agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                agregarMouseExited(evt);
            }
        });

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/save.png"))); // NOI18N

        jLabel16.setText("Agregar");

        javax.swing.GroupLayout agregarLayout = new javax.swing.GroupLayout(agregar);
        agregar.setLayout(agregarLayout);
        agregarLayout.setHorizontalGroup(
            agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        agregarLayout.setVerticalGroup(
            agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16))
        );

        eliminar.setBackground(new java.awt.Color(255, 255, 255));
        eliminar.setMinimumSize(new java.awt.Dimension(50, 50));
        eliminar.setPreferredSize(new java.awt.Dimension(70, 70));
        eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                eliminarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                eliminarMouseExited(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/eliminar.png"))); // NOI18N

        jLabel18.setText("Eliminar");

        javax.swing.GroupLayout eliminarLayout = new javax.swing.GroupLayout(eliminar);
        eliminar.setLayout(eliminarLayout);
        eliminarLayout.setHorizontalGroup(
            eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)))
        );
        eliminarLayout.setVerticalGroup(
            eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel17)
                .addGap(10, 10, 10)
                .addComponent(jLabel18))
        );

        actualizar.setBackground(new java.awt.Color(255, 255, 255));
        actualizar.setMinimumSize(new java.awt.Dimension(50, 50));
        actualizar.setPreferredSize(new java.awt.Dimension(70, 70));
        actualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                actualizarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                actualizarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                actualizarMouseExited(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/actualizar.png"))); // NOI18N

        jLabel20.setText("Actualizar");

        javax.swing.GroupLayout actualizarLayout = new javax.swing.GroupLayout(actualizar);
        actualizar.setLayout(actualizarLayout);
        actualizarLayout.setHorizontalGroup(
            actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actualizarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19)))
        );
        actualizarLayout.setVerticalGroup(
            actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actualizarLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel19)
                .addGap(10, 10, 10)
                .addComponent(jLabel20))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {actualizar, agregar, eliminar, nuevo});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {actualizar, agregar, eliminar, nuevo});

        tableMetroICM1.setBackground(new java.awt.Color(0, 200, 81));
        tableMetroICM1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        tableMetroICM1.setRowHeight(25);
        tableMetroICM1.setSelectionForeground(new java.awt.Color(189, 189, 189));
        tableMetroICM1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMetroICM1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tableMetroICM1MousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tableMetroICM1);

        rSPanelsSlider1.setBackground(new java.awt.Color(0, 200, 81));

        jTabbedPane1.setBackground(new java.awt.Color(0, 200, 81));

        rSPanelsSlider2.setBackground(new java.awt.Color(11, 230, 185));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Nombre:");

        txtNombre.setForeground(new java.awt.Color(33, 33, 33));
        txtNombre.setToolTipText("");
        txtNombre.setBordeColorFocus(new java.awt.Color(0, 200, 81));
        txtNombre.setPlaceholder("Escribe Nombre...");
        txtNombre.setSoloLetras(true);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Paterno:");

        txtPaterno.setForeground(new java.awt.Color(33, 33, 33));
        txtPaterno.setToolTipText("");
        txtPaterno.setBordeColorFocus(new java.awt.Color(0, 200, 81));
        txtPaterno.setPlaceholder("Apellido Paterno...");
        txtPaterno.setSoloLetras(true);
        txtPaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPaternoKeyTyped(evt);
            }
        });

        txtMaterno.setForeground(new java.awt.Color(33, 33, 33));
        txtMaterno.setToolTipText("");
        txtMaterno.setBordeColorFocus(new java.awt.Color(0, 200, 81));
        txtMaterno.setPlaceholder("Apellido Materno...");
        txtMaterno.setSoloLetras(true);
        txtMaterno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaternoActionPerformed(evt);
            }
        });
        txtMaterno.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMaternoKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Materno:");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("DNI:");

        txtDNI.setForeground(new java.awt.Color(33, 33, 33));
        txtDNI.setToolTipText("");
        txtDNI.setBordeColorFocus(new java.awt.Color(0, 200, 81));
        txtDNI.setPlaceholder("N° De DNI");
        txtDNI.setSoloNumeros(true);
        txtDNI.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtDNIFocusGained(evt);
            }
        });
        txtDNI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDNIKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDNIKeyTyped(evt);
            }
        });

        txtDireccion.setForeground(new java.awt.Color(33, 33, 33));
        txtDireccion.setToolTipText("");
        txtDireccion.setBordeColorFocus(new java.awt.Color(0, 200, 81));
        txtDireccion.setPlaceholder("Ingrese Direccion...");
        txtDireccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDireccionKeyTyped(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Direccion:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Sexo:");

        hombre.setBackground(new java.awt.Color(11, 230, 185));
        botonSexo.add(hombre);
        hombre.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        hombre.setForeground(new java.awt.Color(33, 33, 33));
        hombre.setSelected(true);
        hombre.setText("Hombre");
        hombre.setAlignmentY(0.2F);

        Mujer.setBackground(new java.awt.Color(11, 230, 185));
        botonSexo.add(Mujer);
        Mujer.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        Mujer.setText("Mujer");
        Mujer.setAlignmentY(0.2F);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Estado:");

        activo.setBackground(new java.awt.Color(11, 230, 185));
        botonEstado.add(activo);
        activo.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        activo.setSelected(true);
        activo.setText("Activo");

        inactivo.setBackground(new java.awt.Color(11, 230, 185));
        botonEstado.add(inactivo);
        inactivo.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        inactivo.setText("Inactivo");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Cargo:");

        cbxCargo.setBackground(new java.awt.Color(0, 200, 81));
        cbxCargo.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 200, 81), 1, true));
        cbxCargo.setForeground(new java.awt.Color(0, 0, 0));
        cbxCargo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Trabajador", "Cliente" }));

        fecha_nacimiento.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 200, 81), 1, true));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Nacimiento:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Celular:");

        txtCelular.setForeground(new java.awt.Color(33, 33, 33));
        txtCelular.setToolTipText("");
        txtCelular.setBordeColorFocus(new java.awt.Color(0, 200, 81));
        txtCelular.setPlaceholder("Ingrese N° Celular...");
        txtCelular.setSoloNumeros(true);
        txtCelular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCelularKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout rSPanelsSlider2Layout = new javax.swing.GroupLayout(rSPanelsSlider2);
        rSPanelsSlider2.setLayout(rSPanelsSlider2Layout);
        rSPanelsSlider2Layout.setHorizontalGroup(
            rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelsSlider2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rSPanelsSlider2Layout.createSequentialGroup()
                        .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(txtPaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtMaterno, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelsSlider2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelsSlider2Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(fecha_nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))
                    .addGroup(rSPanelsSlider2Layout.createSequentialGroup()
                        .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(rSPanelsSlider2Layout.createSequentialGroup()
                                .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rSPanelsSlider2Layout.createSequentialGroup()
                                        .addComponent(hombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(Mujer, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(68, 68, 68)
                                .addComponent(jLabel3)
                                .addGap(33, 33, 33)
                                .addComponent(activo, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(inactivo)))
                        .addContainerGap(38, Short.MAX_VALUE))))
        );

        rSPanelsSlider2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbxCargo, fecha_nacimiento});

        rSPanelsSlider2Layout.setVerticalGroup(
            rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rSPanelsSlider2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fecha_nacimiento, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(activo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(inactivo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rSPanelsSlider2Layout.createSequentialGroup()
                        .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(rSPanelsSlider2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(Mujer, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(hombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        rSPanelsSlider2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtDNI, txtDireccion, txtMaterno, txtNombre, txtPaterno});

        rSPanelsSlider2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbxCargo, fecha_nacimiento});

        jTabbedPane1.addTab("DATOS DEL TRABAJADOR", rSPanelsSlider2);

        javax.swing.GroupLayout panel_principal_agregarLayout = new javax.swing.GroupLayout(panel_principal_agregar);
        panel_principal_agregar.setLayout(panel_principal_agregarLayout);
        panel_principal_agregarLayout.setHorizontalGroup(
            panel_principal_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principal_agregarLayout.createSequentialGroup()
                .addGroup(panel_principal_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_principal_agregarLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(panel_principal_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panel_principal_agregarLayout.createSequentialGroup()
                                .addGroup(panel_principal_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panel_principal_agregarLayout.createSequentialGroup()
                                        .addGap(308, 308, 308)
                                        .addComponent(jLabel1)
                                        .addGap(10, 10, 10)
                                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(71, 71, 71))
        );
        panel_principal_agregarLayout.setVerticalGroup(
            panel_principal_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_principal_agregarLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(panel_principal_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel_principal_agregarLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(panel_principal_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel_principal_agregarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(panel_principal_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 650));

        getAccessibleContext().setAccessibleName("");
        getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (txtBuscar.getText().equals("")) {
            obtenerDatos();
        } else {
            DefaultTableModel modelo = personaDAO.buscar("Trabajador", txtBuscar.getText());
            tableMetroICM1.setModel(modelo);
            visibilidadTamañoColumnas();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        if (txtBuscar.getText().equals("")) {
            txtBuscar.setText("Buscar Trabajador");
        }
    }//GEN-LAST:event_txtBuscarFocusLost

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        if (txtBuscar.getText().equals("Buscar Trabajador")) {
            txtBuscar.setText("");
        }
    }//GEN-LAST:event_txtBuscarFocusGained

    private void actualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseExited

    }//GEN-LAST:event_actualizarMouseExited

    private void actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseEntered
        setColor(actualizar);
    }//GEN-LAST:event_actualizarMouseEntered

    private void actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseClicked
        personaDAO.modificar(recogerDatos());
        obtenerDatos();
    }//GEN-LAST:event_actualizarMouseClicked

    private void eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseExited
        resetColor(eliminar);
    }//GEN-LAST:event_eliminarMouseExited

    private void eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseEntered
        setColor(eliminar);
    }//GEN-LAST:event_eliminarMouseEntered

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
        int id = Integer.parseInt(tableMetroICM1.getValueAt(posicionSeleccion, 0).toString());
        personaDAO.eliminar(id, "Trabajador");
        obtenerDatos();
    }//GEN-LAST:event_eliminarMouseClicked

    private void agregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseExited
        resetColor(agregar);
    }//GEN-LAST:event_agregarMouseExited

    private void agregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseEntered
        setColor(agregar);
    }//GEN-LAST:event_agregarMouseEntered

    private void agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseClicked

        personaDAO.agregar(recogerDatos());
        inabilitarBotones(false);
        obtenerDatos();
    }//GEN-LAST:event_agregarMouseClicked

    private void nuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseExited
        resetColor(nuevo);
    }//GEN-LAST:event_nuevoMouseExited

    private void nuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseEntered
        setColor(nuevo);
    }//GEN-LAST:event_nuevoMouseEntered

    private void nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseClicked
        borrarDatosTextos();
        inabilitarBotones(true);
        inabilitarTextos(true);
    }//GEN-LAST:event_nuevoMouseClicked

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setVisible(false);
        Panel_Home_Trabajador a = new Panel_Home_Trabajador();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tableMetroICM1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMetroICM1MousePressed
        posicionSeleccion = tableMetroICM1.getSelectedRow();
        ponerDatosEnTextos();
        inabilitarTextos(true);
    }//GEN-LAST:event_tableMetroICM1MousePressed

    private void tableMetroICM1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMetroICM1MouseClicked

    }//GEN-LAST:event_tableMetroICM1MouseClicked

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtPaterno.requestFocus();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtPaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaternoKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtMaterno.requestFocus();
        }
    }//GEN-LAST:event_txtPaternoKeyTyped

    private void txtMaternoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaternoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaternoActionPerformed

    private void txtMaternoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaternoKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtDNI.requestFocus();
        }
    }//GEN-LAST:event_txtMaternoKeyTyped

    private void txtDNIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtDireccion.requestFocus();
        }
    }//GEN-LAST:event_txtDNIKeyTyped

    private void txtDireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDireccionKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtCelular.requestFocus();
        }
    }//GEN-LAST:event_txtDireccionKeyTyped

    private void txtCelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCelularKeyTyped
//    char el=evt.getKeyChar();
//    if((el<'0' || el>'9' ) && txtCelular.getText().contains (".")
//           && (el!=(char)KeyEvent.VK_SPACE) ){
//             evt.consume();
//             JOptionPane.showMessageDialog(null, "Solo numeros","Validar Números",JOptionPane.INFORMATION_MESSAGE);  
//         }
    }//GEN-LAST:event_txtCelularKeyTyped

    private void txtDNIKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDNIKeyPressed
        if (txtDNI.getText().length() > 6) {
            txtDireccion.requestFocus();
        }
    }//GEN-LAST:event_txtDNIKeyPressed

    private void txtDNIFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDNIFocusGained
        
    }//GEN-LAST:event_txtDNIFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Mujer;
    private javax.swing.JRadioButton activo;
    private javax.swing.JPanel actualizar;
    private javax.swing.JPanel agregar;
    private javax.swing.ButtonGroup botonEstado;
    private javax.swing.ButtonGroup botonSexo;
    private com.icm.components.metro.ComboboxMetroICM cbxCargo;
    private javax.swing.JPanel eliminar;
    private com.toedter.calendar.JDateChooser fecha_nacimiento;
    private javax.swing.JRadioButton hombre;
    private javax.swing.JRadioButton inactivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel nuevo;
    public static javax.swing.JPanel panel_principal_agregar;
    private rojeru_san.RSPanelsSlider rSPanelsSlider1;
    private rojeru_san.RSPanelsSlider rSPanelsSlider2;
    private javax.swing.JTable tableMetroICM1;
    private javax.swing.JTextField txtBuscar;
    private rojeru_san.RSMTextFull txtCelular;
    private rojeru_san.RSMTextFull txtDNI;
    private rojeru_san.RSMTextFull txtDireccion;
    private javax.swing.JTextField txtId;
    private rojeru_san.RSMTextFull txtMaterno;
    private rojeru_san.RSMTextFull txtNombre;
    private rojeru_san.RSMTextFull txtPaterno;
    // End of variables declaration//GEN-END:variables
}
