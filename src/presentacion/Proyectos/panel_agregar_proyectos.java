/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Proyectos;

import com.mxrck.autocompleter.TextAutoCompleter;
import dominio.Persona;
import dominio.Proyecto;
import dominio.auxTrabajadoresClientes;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;
import persistencia.ProyectoDAO;
import presentacion.frmPrincipal;

/**
 *
 * @author USUARIO
 */
public class panel_agregar_proyectos extends javax.swing.JPanel {

    frmPrincipal p;
    int posicionEleccion;
    private int id_proyecto, id_trabajador, id_cliente;
    private String nombre_proyecto = "", descripcion = "", rubro = "", fIncio = "", fFin = "", estdao = "";
    Proyecto proyecto;
    ProyectoDAO proyectoDAO;
    public static int aux_id_proyecto, aux_id_cliente;
    public static boolean estaActivado = false;

    public panel_agregar_proyectos() {
        initComponents();
        proyectoDAO = new ProyectoDAO();
        inabilitarTextos(false);
        borrarDatosTextos();
        autcompletadorClientes();
        autocompletadorTrabajadores();
        obtenerDatos();
        Activo.setSelected(true);
        poputaTable();
    }

    public void poputaTable() {
        JPopupMenu popuMenu = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Agregar descripcion del proyecto");
        menuItem.addActionListener(new listener());
        popuMenu.add(menuItem);
        tabl_proyecto.setComponentPopupMenu(popuMenu);
    }

    class listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panel_agregar_descripciones_proyectos a = new panel_agregar_descripciones_proyectos();
            a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
            p.principal.removeAll();
            p.principal.add(a, BorderLayout.CENTER);
            p.principal.revalidate();
            p.principal.repaint();
            estaActivado = true;
        }
    }

    void visibilidadTamañoColumnas() {
        tabl_proyecto.getColumnModel().getColumn(0).setMaxWidth(0);
        tabl_proyecto.getColumnModel().getColumn(0).setMinWidth(0);
        tabl_proyecto.getColumnModel().getColumn(0).setPreferredWidth(0);
//
//        tabl_proyecto.getColumnModel().getColumn(1).setMaxWidth(0);
//        tabl_proyecto.getColumnModel().getColumn(1).setMinWidth(0);
//        tabl_proyecto.getColumnModel().getColumn(1).setPreferredWidth(0);

        tabl_proyecto.getColumnModel().getColumn(2).setMaxWidth(0);
        tabl_proyecto.getColumnModel().getColumn(2).setMinWidth(0);
        tabl_proyecto.getColumnModel().getColumn(2).setPreferredWidth(0);

        tabl_proyecto.getColumnModel().getColumn(4).setMaxWidth(0);
        tabl_proyecto.getColumnModel().getColumn(4).setMinWidth(0);
        tabl_proyecto.getColumnModel().getColumn(4).setPreferredWidth(0);

        tabl_proyecto.getColumnModel().getColumn(5).setMaxWidth(0);
        tabl_proyecto.getColumnModel().getColumn(5).setMinWidth(0);
        tabl_proyecto.getColumnModel().getColumn(5).setPreferredWidth(0);

        tabl_proyecto.getColumnModel().getColumn(9).setMaxWidth(0);
        tabl_proyecto.getColumnModel().getColumn(9).setMinWidth(0);
        tabl_proyecto.getColumnModel().getColumn(9).setPreferredWidth(0);

    }

    void borrarDatosTextos() {
        txtId_proyecto.setText(String.valueOf(proyectoDAO.obtnerCodigoProyecto()));
        txtCliente.setText("");
        txtDescripcion.setText("");
        txtNombreProyecto.setText("");
        txtRubroNegocio.setText("");
        txtTrabajador.setText("");
    }

    void inabilitarTextos(boolean estado) {
        txtCliente.setEnabled(estado);
        txtDescripcion.setEnabled(estado);
        txtNombreProyecto.setEnabled(estado);
        txtRubroNegocio.setEnabled(estado);
        txtTrabajador.setEnabled(estado);

    }

    void autcompletadorClientes() {
        TextAutoCompleter textAutoCompleterClientes = new TextAutoCompleter(txtCliente);
        proyectoDAO.cargarClientes();
        ArrayList<Persona> listaClientes = proyectoDAO.listaClientes;
        for (Persona lista : listaClientes) {
            textAutoCompleterClientes.addItem(lista.getNombre());
        }
//        textAutoCompleter.addItem("uno");
//        textAutoCompleter.addItem("dos");
//        textAutoCompleter.addItem("tres");
//        textAutoCompleter.addItem("cuatro");
    }

    void autocompletadorTrabajadores() {
        proyectoDAO.cargarTrabajadores();
        TextAutoCompleter textAutoCompleterTrabajadores = new TextAutoCompleter(txtTrabajador);
        ArrayList<Persona> listaTrabajadores = proyectoDAO.listaTrabajadores;
        for (Persona lista : listaTrabajadores) {
            textAutoCompleterTrabajadores.addItem(lista.getNombre());
        }

    }

    void ponerDatosTextos() {
        id_proyecto = Integer.parseInt(tabl_proyecto.getValueAt(posicionEleccion, 0).toString());
        id_cliente = Integer.parseInt(tabl_proyecto.getValueAt(posicionEleccion, 9).toString());
        id_trabajador = Integer.parseInt(tabl_proyecto.getValueAt(posicionEleccion, 2).toString());

        nombre_proyecto = tabl_proyecto.getValueAt(posicionEleccion, 3).toString();
        rubro = tabl_proyecto.getValueAt(posicionEleccion, 4).toString();
        descripcion = tabl_proyecto.getValueAt(posicionEleccion, 5).toString();

        fIncio = tabl_proyecto.getValueAt(posicionEleccion, 6).toString();
        fFin = tabl_proyecto.getValueAt(posicionEleccion, 7).toString();
        estdao = tabl_proyecto.getValueAt(posicionEleccion, 8).toString();

        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = format.parse(fIncio);
            fechaIncio.setDate(date);
            date = format.parse(fFin);
            fechaFin.setDate(date);

        } catch (Exception e) {
        }
        txtId_proyecto.setText(String.valueOf(id_proyecto));
        txtCliente.setText(proyectoDAO.devolverDNICliente(id_cliente));
        txtTrabajador.setText(proyectoDAO.devolverDNITrabajador(id_trabajador));
        txtNombreProyecto.setText(nombre_proyecto);
        txtRubroNegocio.setText(rubro);
        txtDescripcion.setText(descripcion);
        if (estdao.equals("Activo")) {
            Activo.setSelected(true);
            Inactivo.setSelected(false);
        } else {
            Activo.setSelected(false);
            Inactivo.setSelected(true);
        }
    }

    void obtenerDatos() {
        DefaultTableModel modelo = proyectoDAO.mostrar();
        tabl_proyecto.setModel(modelo);
        visibilidadTamañoColumnas();
    }

    Proyecto recogerDatos() {
        id_proyecto = Integer.parseInt(txtId_proyecto.getText());
        String auxCliente = txtCliente.getText();
        id_cliente = proyectoDAO.devolverIdCliente(auxCliente);
        String auxTrabajador = txtTrabajador.getText();
        id_trabajador = proyectoDAO.devolverIdTrabajadores(auxTrabajador);
        nombre_proyecto = txtNombreProyecto.getText();
        rubro = txtRubroNegocio.getText();
        descripcion = txtDescripcion.getText();
        Date date = fechaIncio.getDate();
        SimpleDateFormat format = new SimpleDateFormat("dd--MM-yyyy");

        fIncio = format.format(date);
        date = fechaFin.getDate();
        fFin = format.format(date);
        if (Activo.isSelected()) {
            estdao = "Activo";
        } else {
            estdao = "Inactivo";
        }
        proyecto = new Proyecto(id_proyecto, id_cliente, id_trabajador, nombre_proyecto, rubro, descripcion, fIncio, fFin, estdao);
        System.out.println(proyecto.toString());
        return proyecto;
    }

    void setColor(JPanel panel) {
        panel.setBackground(new Color(220, 220, 220));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(255, 255, 255));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupo_sexo = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        panel_descripciones = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        txtId_proyecto = new javax.swing.JTextField();
        txtCliente = new javax.swing.JTextField();
        txtTrabajador = new javax.swing.JTextField();
        txtNombreProyecto = new javax.swing.JTextField();
        txtRubroNegocio = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        fechaIncio = new com.toedter.calendar.JDateChooser();
        fechaFin = new com.toedter.calendar.JDateChooser();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        Activo = new javax.swing.JRadioButton();
        Inactivo = new javax.swing.JRadioButton();
        panel_configuraciones = new javax.swing.JPanel();
        nuevo = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        agregar = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        eliminar = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        actualizar = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabl_proyecto = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(204, 0, 0));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 50));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/atras.png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Menu principal");

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(292, 292, 292)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(188, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(98, 98, 98)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(537, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtBuscar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(58, 58, 58)))
        );

        panel_descripciones.setBackground(new java.awt.Color(255, 255, 255));
        panel_descripciones.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 0, 51)));
        panel_descripciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setBackground(new java.awt.Color(0, 255, 255));
        jLabel13.setForeground(new java.awt.Color(0, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Rectangle_20px.png"))); // NOI18N
        panel_descripciones.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 20, -1, 12));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("id");
        panel_descripciones.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 20, 20, -1));

        jLabel15.setBackground(new java.awt.Color(0, 255, 255));
        jLabel15.setForeground(new java.awt.Color(0, 255, 255));
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Rectangle_20px.png"))); // NOI18N
        panel_descripciones.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 51, -1, 12));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Cliente");
        panel_descripciones.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 51, 50, -1));

        jLabel17.setBackground(new java.awt.Color(0, 255, 255));
        jLabel17.setForeground(new java.awt.Color(0, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Rectangle_20px.png"))); // NOI18N
        panel_descripciones.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 82, -1, 12));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Trabajador");
        panel_descripciones.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 82, -1, -1));

        jLabel19.setBackground(new java.awt.Color(0, 255, 255));
        jLabel19.setForeground(new java.awt.Color(0, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Rectangle_20px.png"))); // NOI18N
        panel_descripciones.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 108, -1, 12));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Nombre proyecto");
        panel_descripciones.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 108, -1, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Rubro del negocio");
        panel_descripciones.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 134, -1, -1));

        jLabel22.setBackground(new java.awt.Color(0, 255, 255));
        jLabel22.setForeground(new java.awt.Color(0, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Rectangle_20px.png"))); // NOI18N
        panel_descripciones.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 134, -1, 12));
        panel_descripciones.add(txtId_proyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 20, 229, -1));

        txtCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtClienteFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtClienteFocusLost(evt);
            }
        });
        panel_descripciones.add(txtCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 51, 229, -1));
        panel_descripciones.add(txtTrabajador, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 82, 229, -1));
        panel_descripciones.add(txtNombreProyecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 108, 229, -1));
        panel_descripciones.add(txtRubroNegocio, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 134, 229, -1));

        jLabel23.setBackground(new java.awt.Color(0, 255, 255));
        jLabel23.setForeground(new java.awt.Color(0, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Rectangle_20px.png"))); // NOI18N
        panel_descripciones.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 165, -1, 12));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Descripcion del proyecto");
        panel_descripciones.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 165, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        panel_descripciones.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 165, 229, 83));

        jLabel25.setBackground(new java.awt.Color(0, 255, 255));
        jLabel25.setForeground(new java.awt.Color(0, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Rectangle_20px.png"))); // NOI18N
        panel_descripciones.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 271, -1, 12));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Fecha inicializacion ");
        panel_descripciones.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 269, -1, -1));

        jLabel27.setBackground(new java.awt.Color(0, 255, 255));
        jLabel27.setForeground(new java.awt.Color(0, 255, 255));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Rectangle_20px.png"))); // NOI18N
        panel_descripciones.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 297, -1, 12));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Fecha finalizacion");
        panel_descripciones.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 292, -1, -1));
        panel_descripciones.add(fechaIncio, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 266, 160, -1));
        panel_descripciones.add(fechaFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 292, 160, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Estado");
        panel_descripciones.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 323, -1, -1));

        jLabel38.setBackground(new java.awt.Color(0, 255, 255));
        jLabel38.setForeground(new java.awt.Color(0, 255, 255));
        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Rectangle_20px.png"))); // NOI18N
        panel_descripciones.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 328, -1, 12));

        grupo_sexo.add(Activo);
        Activo.setText("Activo");
        panel_descripciones.add(Activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, -1, -1));

        grupo_sexo.add(Inactivo);
        Inactivo.setText("Inactivo");
        panel_descripciones.add(Inactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        panel_configuraciones.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Add_New_40px.png"))); // NOI18N

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Nuevo");

        javax.swing.GroupLayout nuevoLayout = new javax.swing.GroupLayout(nuevo);
        nuevo.setLayout(nuevoLayout);
        nuevoLayout.setHorizontalGroup(
            nuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel29)
                .addGap(31, 31, 31)
                .addComponent(jLabel30)
                .addContainerGap())
        );
        nuevoLayout.setVerticalGroup(
            nuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoLayout.createSequentialGroup()
                .addGroup(nuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nuevoLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel30))
                    .addGroup(nuevoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel29)))
                .addContainerGap(19, Short.MAX_VALUE))
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

        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Save_All_40px.png"))); // NOI18N

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel32.setText("Agregar");

        javax.swing.GroupLayout agregarLayout = new javax.swing.GroupLayout(agregar);
        agregar.setLayout(agregarLayout);
        agregarLayout.setHorizontalGroup(
            agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarLayout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel31)
                .addGap(30, 30, 30)
                .addComponent(jLabel32)
                .addContainerGap())
        );
        agregarLayout.setVerticalGroup(
            agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarLayout.createSequentialGroup()
                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(agregarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel32))
                    .addGroup(agregarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31)))
                .addContainerGap(19, Short.MAX_VALUE))
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

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Trash_Can_40px.png"))); // NOI18N

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Eliminar");

        javax.swing.GroupLayout eliminarLayout = new javax.swing.GroupLayout(eliminar);
        eliminar.setLayout(eliminarLayout);
        eliminarLayout.setHorizontalGroup(
            eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel33)
                .addGap(32, 32, 32)
                .addComponent(jLabel34)
                .addContainerGap())
        );
        eliminarLayout.setVerticalGroup(
            eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarLayout.createSequentialGroup()
                .addGroup(eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(eliminarLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel34))
                    .addGroup(eliminarLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33)))
                .addContainerGap(19, Short.MAX_VALUE))
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

        jLabel35.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Proyectos/Imagenes/icons8_Refresh_Shield_40px.png"))); // NOI18N

        jLabel36.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel36.setText("Actualizar");

        javax.swing.GroupLayout actualizarLayout = new javax.swing.GroupLayout(actualizar);
        actualizar.setLayout(actualizarLayout);
        actualizarLayout.setHorizontalGroup(
            actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actualizarLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel35)
                .addGap(30, 30, 30)
                .addComponent(jLabel36)
                .addContainerGap())
        );
        actualizarLayout.setVerticalGroup(
            actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, actualizarLayout.createSequentialGroup()
                .addGap(0, 30, Short.MAX_VALUE)
                .addComponent(jLabel35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, actualizarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel36)
                .addContainerGap())
        );

        javax.swing.GroupLayout panel_configuracionesLayout = new javax.swing.GroupLayout(panel_configuraciones);
        panel_configuraciones.setLayout(panel_configuracionesLayout);
        panel_configuracionesLayout.setHorizontalGroup(
            panel_configuracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_configuracionesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(panel_configuracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel_configuracionesLayout.setVerticalGroup(
            panel_configuracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel_configuracionesLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(panel_configuracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panel_configuracionesLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tabl_proyecto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabl_proyecto.setModel(new javax.swing.table.DefaultTableModel(
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
        tabl_proyecto.setRowHeight(25);
        tabl_proyecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabl_proyectoMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tabl_proyecto);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel_descripciones, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panel_configuraciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panel_configuraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panel_descripciones, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
        Panel_Home_Proyectos a = new Panel_Home_Proyectos();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
        estaActivado = false;
    }//GEN-LAST:event_jLabel11MouseClicked

    private void nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseClicked
        borrarDatosTextos();
        inabilitarTextos(true);
    }//GEN-LAST:event_nuevoMouseClicked

    private void nuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseEntered
        setColor(nuevo);
    }//GEN-LAST:event_nuevoMouseEntered

    private void nuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseExited
        resetColor(nuevo);
    }//GEN-LAST:event_nuevoMouseExited

    private void agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseClicked
        proyectoDAO.agregar(recogerDatos());

        obtenerDatos();
    }//GEN-LAST:event_agregarMouseClicked

    private void agregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseEntered
        setColor(agregar);
    }//GEN-LAST:event_agregarMouseEntered

    private void agregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseExited
        resetColor(agregar);
    }//GEN-LAST:event_agregarMouseExited

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
        int id = Integer.parseInt(tabl_proyecto.getValueAt(posicionEleccion, 0).toString());
        proyectoDAO.eliminar(id);
        obtenerDatos();
    }//GEN-LAST:event_eliminarMouseClicked

    private void eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseEntered
        setColor(eliminar);
    }//GEN-LAST:event_eliminarMouseEntered

    private void eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseExited
        resetColor(eliminar);
    }//GEN-LAST:event_eliminarMouseExited

    private void actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseClicked
        proyectoDAO.modificar(recogerDatos());
        obtenerDatos();
    }//GEN-LAST:event_actualizarMouseClicked

    private void actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseEntered
        setColor(actualizar);
    }//GEN-LAST:event_actualizarMouseEntered

    private void actualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseExited
        resetColor(actualizar);
    }//GEN-LAST:event_actualizarMouseExited

    private void tabl_proyectoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabl_proyectoMousePressed
        posicionEleccion = tabl_proyecto.getSelectedRow();
        aux_id_cliente = Integer.parseInt(tabl_proyecto.getValueAt(posicionEleccion, 9).toString());
        aux_id_proyecto = Integer.parseInt(tabl_proyecto.getValueAt(posicionEleccion, 2).toString());
        ponerDatosTextos();
        inabilitarTextos(true);
    }//GEN-LAST:event_tabl_proyectoMousePressed

    private void txtClienteFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClienteFocusGained

    }//GEN-LAST:event_txtClienteFocusGained

    private void txtClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClienteFocusLost

    }//GEN-LAST:event_txtClienteFocusLost

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (txtBuscar.getText().equals("")) {
            obtenerDatos();
        } else {
            DefaultTableModel modelo = proyectoDAO.buscar(txtBuscar.getText());
            tabl_proyecto.setModel(modelo);
            visibilidadTamañoColumnas();
        }


    }//GEN-LAST:event_txtBuscarKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Activo;
    private javax.swing.JRadioButton Inactivo;
    private javax.swing.JPanel actualizar;
    private javax.swing.JPanel agregar;
    private javax.swing.JPanel eliminar;
    private com.toedter.calendar.JDateChooser fechaFin;
    private com.toedter.calendar.JDateChooser fechaIncio;
    private javax.swing.ButtonGroup grupo_sexo;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel nuevo;
    public static javax.swing.JPanel panel_configuraciones;
    public static javax.swing.JPanel panel_descripciones;
    public static javax.swing.JTable tabl_proyecto;
    public static javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId_proyecto;
    private javax.swing.JTextField txtNombreProyecto;
    private javax.swing.JTextField txtRubroNegocio;
    private javax.swing.JTextField txtTrabajador;
    // End of variables declaration//GEN-END:variables
}
