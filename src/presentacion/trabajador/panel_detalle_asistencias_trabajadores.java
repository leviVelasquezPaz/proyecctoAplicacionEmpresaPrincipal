
package presentacion.trabajador;

import com.mxrck.autocompleter.TextAutoCompleter;
import dominio.Detalle_Asistencias;
import dominio.FormatoTabla;
import dominio.Persona;
import dominio.Proyecto;
import java.awt.BorderLayout;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import persistencia.Detalle_asistenciasDAO;
import persistencia.ProyectoDAO;
import static presentacion.Proyectos.panel_agregar_proyectos.tabl_proyecto;
import presentacion.frmPrincipal;

/**
 *
 * @author Levi
 */
public class panel_detalle_asistencias_trabajadores extends javax.swing.JPanel {

    frmPrincipal p;
    TextAutoCompleter autocompleter;
    ProyectoDAO proyecto;
    Detalle_Asistencias asistencias;
    Detalle_asistenciasDAO detalle_asistenciaDAO;
    int posicionEleccion;
    Date fecha_actual = null;

    public panel_detalle_asistencias_trabajadores() {
        initComponents();
        proyecto = new ProyectoDAO();
        detalle_asistenciaDAO = new Detalle_asistenciasDAO();
        fecha_actual = new Date();
        fecha_asistentecias.setDate(fecha_actual);
        obtenerDatos();
        borrarDatosTextos();
        inabilitarTextos(false);
        autocompletar();
        inabilitarBotones(false);
    }

    void pintarTabla() {
        FormatoTabla pintar = new FormatoTabla(6);
        tabla_asistencias.setDefaultRenderer(Object.class, pintar);
    }

    void autocompletar() {
        proyecto.cargarTrabajadores();
        ArrayList<Persona> listaClientes = proyecto.listaTrabajadores;
        autocompleter = new TextAutoCompleter(txtTrabajador);
        for (Persona lista : listaClientes) {
            autocompleter.addItem(lista.getNombre());
        }
    }

    void borrarDatosTextos() {
        txtId.setText(String.valueOf(detalle_asistenciaDAO.obtnerCodigo()));
        txtTrabajador.setText("");
        lblHora.setText("click para obtener la hora ");
    }

    void inabilitarTextos(boolean estado) {
        txtTrabajador.setEnabled(estado);
        lblHora.setEnabled(estado);
        fecha_asistentecias.setEnabled(estado);
    }

    void inabilitarBotones(boolean estado) {
        agregar.setEnabled(estado);
        actualizar.setEnabled(!estado);
        eliminar.setEnabled(!estado);
    }

    void ponerDatosTextos() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        txtId.setText(tabla_asistencias.getValueAt(posicionEleccion, 0).toString());
        txtTrabajador.setText(proyecto.devolverDNITrabajador(Integer.parseInt(tabla_asistencias.getValueAt(posicionEleccion, 5).toString())));
        String fecha_seleccionada = tabla_asistencias.getValueAt(posicionEleccion, 4).toString();
        try {
            Date dates = format.parse(fecha_seleccionada);
            fecha_asistentecias.setDate(dates);
        } catch (Exception e) {
        }
        lblHora.setText(tabla_asistencias.getValueAt(posicionEleccion, 3).toString());
        String estado = tabla_asistencias.getValueAt(posicionEleccion, 6).toString();
        cbxEstado.setSelectedItem(estado);

    }

    void obtenerDatos() {
        DefaultTableModel modelo = detalle_asistenciaDAO.mostrar();
        tabla_asistencias.setModel(modelo);
        visibilidadTamañoColumnas();
        pintarTabla();
    }

    Detalle_Asistencias recogerDatos() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        int id = Integer.parseInt(txtId.getText());
        int id_trabajador = proyecto.devolverIdTrabajadores(txtTrabajador.getText());
        String hora_llegada = lblHora.getText();
        Date date = fecha_asistentecias.getDate();
        String fecha_seleccionada = "";
        String estado = cbxEstado.getSelectedItem().toString();
        try {
            fecha_seleccionada = format.format(date);
        } catch (Exception e) {
        }
        asistencias = new Detalle_Asistencias(id, panel_asistencias_trabajadores.id_asitencias, id_trabajador, hora_llegada, fecha_seleccionada, estado);
        return asistencias;
    }

    void visibilidadTamañoColumnas() {
        tabla_asistencias.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla_asistencias.getColumnModel().getColumn(0).setMinWidth(0);
        tabla_asistencias.getColumnModel().getColumn(0).setPreferredWidth(0);

        tabla_asistencias.getColumnModel().getColumn(1).setMaxWidth(0);
        tabla_asistencias.getColumnModel().getColumn(1).setMinWidth(0);
        tabla_asistencias.getColumnModel().getColumn(1).setPreferredWidth(0);

        tabla_asistencias.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla_asistencias.getColumnModel().getColumn(5).setMinWidth(0);
        tabla_asistencias.getColumnModel().getColumn(5).setPreferredWidth(0);

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

        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtTrabajador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblHora = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        fecha_asistentecias = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cbxEstado = new javax.swing.JComboBox<>();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_asistencias = new javax.swing.JTable();

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 500, Short.MAX_VALUE)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 204)), "Detallle Trabajador"));

        jLabel1.setText("Trabajador");

        txtTrabajador.setText("jTextField1");

        jLabel3.setText("Hora llegada");

        lblHora.setText("click para obtener la hora ");
        lblHora.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHoraMouseClicked(evt);
            }
        });

        jLabel4.setText("Id");

        txtId.setEnabled(false);

        jLabel5.setText("Fecha");

        jLabel6.setText("Estado");

        cbxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ninguno", "Tarde", "Temprano", "Permiso", "Falta", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fecha_asistentecias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3)
                    .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(fecha_asistentecias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        tabla_asistencias.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_asistencias.setRowHeight(25);
        tabla_asistencias.setRowMargin(3);
        tabla_asistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_asistenciasMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_asistencias);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 703, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setVisible(false);
        Panel_Home_Trabajador a = new Panel_Home_Trabajador();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txtBuscarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusGained
        if (txtBuscar.getText().equals("Buscar Trabajador")) {
            txtBuscar.setText("");
        }
    }//GEN-LAST:event_txtBuscarFocusGained

    private void txtBuscarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtBuscarFocusLost
        if (txtBuscar.getText().equals("")) {
            txtBuscar.setText("Buscar Trabajador");
        }
    }//GEN-LAST:event_txtBuscarFocusLost

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (txtBuscar.getText().equals("")) {
            obtenerDatos();
        } else {
            //            DefaultTableModel modelo = asistencia.buscar("Trabajador", txtBuscar.getText());
            //            ta.setModel(modelo);
            //            visibilidadTamañoColumnas();
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void nuevoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseClicked
        borrarDatosTextos();
        inabilitarBotones(true);
        inabilitarTextos(true);
    }//GEN-LAST:event_nuevoMouseClicked

    private void nuevoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseEntered
        setColor(nuevo);
    }//GEN-LAST:event_nuevoMouseEntered

    private void nuevoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nuevoMouseExited
        resetColor(nuevo);
    }//GEN-LAST:event_nuevoMouseExited

    private void agregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseClicked

        if (detalle_asistenciaDAO.verificarAsistencias(proyecto.devolverIdTrabajadores(txtTrabajador.getText()))) {
            JOptionPane.showMessageDialog(null, "El trabajador ingresado ya se encuentra registrado \n En la asistencia");

        } else {
            detalle_asistenciaDAO.agregar(recogerDatos());
            inabilitarBotones(false);
            obtenerDatos();
            inabilitarTextos(false);
        }


    }//GEN-LAST:event_agregarMouseClicked

    private void agregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseEntered
        setColor(agregar);
    }//GEN-LAST:event_agregarMouseEntered

    private void agregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseExited
        resetColor(agregar);
    }//GEN-LAST:event_agregarMouseExited

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
        int id = Integer.parseInt(tabla_asistencias.getValueAt(posicionEleccion, 0).toString());
        detalle_asistenciaDAO.eliminar(id);
        obtenerDatos();
        inabilitarTextos(false);
    }//GEN-LAST:event_eliminarMouseClicked

    private void eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseEntered
        setColor(eliminar);
    }//GEN-LAST:event_eliminarMouseEntered

    private void eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseExited
        resetColor(eliminar);
    }//GEN-LAST:event_eliminarMouseExited

    private void actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseClicked
        detalle_asistenciaDAO.modificar(recogerDatos());
        obtenerDatos();
    }//GEN-LAST:event_actualizarMouseClicked

    private void actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseEntered
        setColor(actualizar);
    }//GEN-LAST:event_actualizarMouseEntered

    private void actualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseExited

    }//GEN-LAST:event_actualizarMouseExited

    private void tabla_asistenciasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_asistenciasMousePressed

        posicionEleccion = tabla_asistencias.getSelectedRow();
        ponerDatosTextos();
        inabilitarTextos(true);


    }//GEN-LAST:event_tabla_asistenciasMousePressed

    private void lblHoraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHoraMouseClicked
        Calendar calendario = new GregorianCalendar();
        int hora = calendario.get(Calendar.HOUR_OF_DAY);
        int minutos = calendario.get(Calendar.MINUTE);
        int segundos = calendario.get(Calendar.SECOND);
        String tiempo = hora + ":" + minutos + ":" + segundos;
        lblHora.setText(tiempo);
    }//GEN-LAST:event_lblHoraMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel actualizar;
    private javax.swing.JPanel agregar;
    private javax.swing.JComboBox<String> cbxEstado;
    private javax.swing.JPanel eliminar;
    private com.toedter.calendar.JDateChooser fecha_asistentecias;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHora;
    private javax.swing.JPanel nuevo;
    private javax.swing.JTable tabla_asistencias;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtTrabajador;
    // End of variables declaration//GEN-END:variables
}
