/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.trabajador;

import com.mxrck.autocompleter.TextAutoCompleter;
import dominio.CuentaBanco;
import dominio.Persona;
import dominio.auxTrabajadoresClientes;
import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.Cuenta_BancariaDAO;
import persistencia.ProyectoDAO;
import presentacion.frmPrincipal;

/**
 *
 * @author USUARIO
 */
public class panel_Detalle_egresoSoles_Trabajadores extends javax.swing.JPanel {

    frmPrincipal p;
    Cuenta_BancariaDAO bancoDAO;
    int id;
    double monto;
    String trabajdor, descripcion, fechas, estado;
    CuentaBanco cuenta;
    frmPrincipal a;
    ProyectoDAO proyectoDAO;
    int indicePosicion;

    public panel_Detalle_egresoSoles_Trabajadores() {
        initComponents();
        Cuenta_BancariaDAO.listaTrabajadores.clear();
        proyectoDAO = new ProyectoDAO();
        bancoDAO = new Cuenta_BancariaDAO();
        botonesTransparentes();
        autcompletadorDNITrabajadores();
        inabilitarTextos(false);
        borrarDatos();
        obtenerDatos();
        autocompleter();
        txtDescripcion.setLineWrap(true);

//        cbxMetodo.setEnabled(true);
//        cbdEstado1.setEnabled(true);
    }

    void autocompleter() {
        bancoDAO.cargarListaTrabajadores();
        TextAutoCompleter texto = new TextAutoCompleter(txtTrabajador);
        ArrayList<Persona> listaTra = bancoDAO.listaTrabajadores;
        for (Persona lista : listaTra) {
            texto.addItem(lista.getNombre());
        }
    }

    void obtenerDatos() {
        DefaultTableModel model = bancoDAO.mostrarTrabajadores(panel_egresoSoles_trabajador.id_trabajador);
        tablaIngresoDinero.setModel(model);
        lblSumaTotal.setText(String.valueOf(bancoDAO.sumarMontoTotal(panel_egresoSoles_trabajador.id_trabajador)));

    }

    void borrarDatos() {
        txtId.setText(String.valueOf(bancoDAO.obtnerCodigoPersona()));
        txtMontoIngreso.setText("");
        txtDescripcion.setText("");
    }

    void inabilitarTextos(boolean estado) {
        txtId.setEnabled(false);
        txtDescripcion.setEnabled(estado);
        txtTrabajador.setEnabled(false);
        txtMontoIngreso.setEnabled(estado);
        fecha.setEnabled(estado);
        cbdEstado1.setEnabled(estado);
        cbxMetodo.setEnabled(estado);
    }

    public void inabiliatar(boolean estado) {
        guardar.setEnabled(estado);
        actualizar.setEnabled(!estado);
        eliminar.setEnabled(!estado);
        cancelar.setEnabled(estado);
    }

    void botonesTransparentes() {
        nuevo.setOpaque(false);
        nuevo.setContentAreaFilled(false);
        nuevo.setBorderPainted(false);
        guardar.setOpaque(false);
        guardar.setContentAreaFilled(false);
        guardar.setBorderPainted(false);
        eliminar.setOpaque(false);
        eliminar.setContentAreaFilled(false);
        eliminar.setBorderPainted(false);
        cancelar.setOpaque(false);
        cancelar.setContentAreaFilled(false);
        cancelar.setBorderPainted(false);
        actualizar.setOpaque(false);
        actualizar.setContentAreaFilled(false);
        actualizar.setBorderPainted(false);

    }

    void ponerDatosTextos() {
        txtId.setText(tablaIngresoDinero.getValueAt(indicePosicion, 0).toString());
        txtTrabajador.setText(tablaIngresoDinero.getValueAt(indicePosicion, 1).toString());
        txtDescripcion.setText(tablaIngresoDinero.getValueAt(indicePosicion, 2).toString());
        txtMontoIngreso.setText(tablaIngresoDinero.getValueAt(indicePosicion, 3).toString());
        String fechas = tablaIngresoDinero.getValueAt(indicePosicion, 4).toString();
        try {
            Date date = null;
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
            date = formato.parse(fechas);
            fecha.setDate(date);
        } catch (Exception e) {
        }
        String metodoIngreso = tablaIngresoDinero.getValueAt(indicePosicion, 5).toString();
        cbxMetodo.setSelectedItem(metodoIngreso);
        String estado = tablaIngresoDinero.getValueAt(indicePosicion, 6).toString();
        cbdEstado1.setSelectedItem(estado);

    }

    void autcompletadorDNITrabajadores() {
        TextAutoCompleter textAutoCompleterClientes = new TextAutoCompleter(txtTrabajador);
        proyectoDAO.cargarTrabajadores();
        ArrayList<Persona> listaClientes = proyectoDAO.listaTrabajadores;
        for (Persona lista : listaClientes) {
            textAutoCompleterClientes.addItem(lista.getDni());
        }
    }

    CuentaBanco recogerDatos() {
        if (txtTrabajador.getText() != "" && txtDescripcion.getText() != "" && txtMontoIngreso.getText() != "") {
            if (fecha.getDate() != null) {
                id = Integer.parseInt(txtId.getText());
                trabajdor = txtTrabajador.getText();
                descripcion = txtDescripcion.getText();
                monto = Double.parseDouble(txtMontoIngreso.getText());
                Date date = fecha.getDate();
                SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
                fechas = formato.format(date);
                estado = cbdEstado1.getSelectedItem().toString();
//              estado = cbxMetodo.getSelectedItem().toString();
                String metodo = cbxMetodo.getSelectedItem().toString();
                cuenta = new CuentaBanco(id, bancoDAO.devolverIDTrabajador(trabajdor), descripcion, monto, fechas, metodo, estado);
                System.out.println(cuenta.toString());
            } else {
                a.controladorErrores("Falta ingresar la fecha", "fail");

            }
        } else {
            a.controladorErrores("Falta ingresar datos", "fail");
        }

        return cuenta;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        fecha = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        cbxMetodo = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        nuevo = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        cancelar = new javax.swing.JButton();
        actualizar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        titulo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbdEstado1 = new javax.swing.JComboBox();
        txtId = new rojeru_san.RSMTextFull();
        txtTrabajador = new rojeru_san.RSMTextFull();
        txtMontoIngreso = new rojeru_san.RSMTextFull();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        rSPanelsSlider1 = new rojeru_san.RSPanelsSlider();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaIngresoDinero = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        lblSumaTotal = new javax.swing.JLabel();
        rSPanelsSlider2 = new rojeru_san.RSPanelsSlider();

        setBackground(new java.awt.Color(207, 216, 220));
        setPreferredSize(new java.awt.Dimension(800, 650));

        jPanel1.setBackground(new java.awt.Color(0, 200, 81));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        panel.setBackground(new java.awt.Color(11, 232, 183));
        panel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(0, 112, 192), java.awt.Color.blue, null));

        jLabel5.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        jLabel5.setText("Monto Ingreso:");

        jLabel6.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        jLabel6.setText("Estado:");

        fecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                fechaMouseClicked(evt);
            }
        });
        fecha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fechaKeyTyped(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        jLabel8.setText("Descripción:");

        cbxMetodo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ingreso Dinero", "Salida Dinero" }));
        cbxMetodo.setEnabled(false);
        cbxMetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMetodoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        jLabel9.setText("Fecha:");

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 255, 255)));

        nuevo.setBackground(new java.awt.Color(255, 255, 255));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/nuevo.png"))); // NOI18N
        nuevo.setToolTipText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/guardar.png"))); // NOI18N
        guardar.setToolTipText("Guardar");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/cancel.png"))); // NOI18N
        cancelar.setToolTipText("Cancelar");
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/actualizarmoney.png"))); // NOI18N
        actualizar.setToolTipText("Actualizar");
        actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                actualizarActionPerformed(evt);
            }
        });

        eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/delte.png"))); // NOI18N
        eliminar.setToolTipText("Eliminar");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(31, 31, 31)
                            .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nuevo, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(actualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(215, 215, 215))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jLabel11.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        jLabel11.setText("Trabajador");

        jLabel12.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        jLabel12.setText("Id:");

        titulo.setFont(new java.awt.Font("BatangChe", 0, 18)); // NOI18N
        titulo.setText("Salida Dinero");

        jLabel7.setFont(new java.awt.Font("BatangChe", 1, 12)); // NOI18N
        jLabel7.setText("Método:");

        cbdEstado1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Activo", "Inactivo" }));
        cbdEstado1.setEnabled(false);
        cbdEstado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbdEstado1ActionPerformed(evt);
            }
        });

        txtId.setEnabled(false);
        txtId.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });

        txtTrabajador.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        txtTrabajador.setPlaceholder("Ingrese nombre del trabajdor");
        txtTrabajador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTrabajadorKeyTyped(evt);
            }
        });

        txtMontoIngreso.setFont(new java.awt.Font("Roboto Bold", 1, 12)); // NOI18N
        txtMontoIngreso.setPlaceholder("Ingrese monto");
        txtMontoIngreso.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMontoIngresoKeyTyped(evt);
            }
        });

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        txtDescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDescripcionKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(txtDescripcion);

        tablaIngresoDinero.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaIngresoDinero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaIngresoDineroMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaIngresoDinero);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 255, 255)), "Suma total monto", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), new java.awt.Color(0, 0, 255))); // NOI18N

        lblSumaTotal.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblSumaTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSumaTotal.setText("jLabel1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblSumaTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(lblSumaTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(txtMontoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(fecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxMetodo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cbdEstado1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(250, 250, 250))
            .addComponent(jScrollPane1)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(rSPanelsSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelLayout.createSequentialGroup()
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(15, 15, 15)))
                                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMontoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxMetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbdEstado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbdEstado1, fecha, txtId, txtMontoIngreso, txtTrabajador});

        rSPanelsSlider2.setBackground(new java.awt.Color(0, 200, 81));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(rSPanelsSlider2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 526, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(rSPanelsSlider2, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setVisible(false);
        panel_egresoSoles_trabajador a = new panel_egresoSoles_trabajador();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        borrarDatos();
        inabilitarTextos(true);
        inabiliatar(true);
    }//GEN-LAST:event_nuevoActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        inabiliatar(true);
        if (recogerDatos() != null) {
            bancoDAO.agregar(recogerDatos());
            obtenerDatos();
            borrarDatos();
            inabilitarTextos(false);

        }
    }//GEN-LAST:event_guardarActionPerformed

    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        borrarDatos();
        inabiliatar(false);
    }//GEN-LAST:event_cancelarActionPerformed

    private void actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_actualizarActionPerformed
        inabiliatar(true);
        if (recogerDatos() != null) {
            bancoDAO.modificar(recogerDatos(), "Cunta bancaria");
            obtenerDatos();
            borrarDatos();
            inabilitarTextos(false);

        }
    }//GEN-LAST:event_actualizarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        bancoDAO.eliminar(Integer.parseInt(txtId.getText()), "Banco");
        obtenerDatos();
        inabiliatar(false);
        borrarDatos();
    }//GEN-LAST:event_eliminarActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        // TODO add your handling code here:
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtTrabajador.requestFocus();
        }
    }//GEN-LAST:event_txtIdKeyTyped

    private void txtTrabajadorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTrabajadorKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtDescripcion.requestFocus();
        }
    }//GEN-LAST:event_txtTrabajadorKeyTyped

    private void txtDescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDescripcionKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            txtMontoIngreso.requestFocus();
        }
    }//GEN-LAST:event_txtDescripcionKeyTyped

    private void txtMontoIngresoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMontoIngresoKeyTyped

    }//GEN-LAST:event_txtMontoIngresoKeyTyped

    private void fechaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fechaKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ENTER) {
            cbxMetodo.requestFocus();
        }
    }//GEN-LAST:event_fechaKeyTyped

    private void fechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_fechaMouseClicked

        cbxMetodo.requestFocus();

    }//GEN-LAST:event_fechaMouseClicked

    private void cbdEstado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbdEstado1ActionPerformed

    }//GEN-LAST:event_cbdEstado1ActionPerformed

    private void cbxMetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMetodoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMetodoActionPerformed

    private void tablaIngresoDineroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaIngresoDineroMousePressed
        indicePosicion = tablaIngresoDinero.getSelectedRow();
        ponerDatosTextos();
        inabilitarTextos(true);
        inabiliatar(false);
    }//GEN-LAST:event_tablaIngresoDineroMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton actualizar;
    private javax.swing.JButton cancelar;
    public static javax.swing.JComboBox cbdEstado1;
    public static javax.swing.JComboBox cbxMetodo;
    private javax.swing.JButton eliminar;
    public static com.toedter.calendar.JDateChooser fecha;
    private javax.swing.JButton guardar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel lblSumaTotal;
    private javax.swing.JButton nuevo;
    public static javax.swing.JPanel panel;
    private rojeru_san.RSPanelsSlider rSPanelsSlider1;
    private rojeru_san.RSPanelsSlider rSPanelsSlider2;
    private javax.swing.JTable tablaIngresoDinero;
    public static javax.swing.JLabel titulo;
    private javax.swing.JTextArea txtDescripcion;
    private rojeru_san.RSMTextFull txtId;
    private rojeru_san.RSMTextFull txtMontoIngreso;
    public static rojeru_san.RSMTextFull txtTrabajador;
    // End of variables declaration//GEN-END:variables
}
