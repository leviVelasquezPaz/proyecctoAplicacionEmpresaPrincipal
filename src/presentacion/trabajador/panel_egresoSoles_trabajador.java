/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.trabajador;

import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import presentacion.frmPrincipal;
import persistencia.Ingreso_Soles_TrabajadoresDAO;
import dominio.Ingreso_Soles_Trabajadores;
import dominio.Persona;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Levi
 */
public class panel_egresoSoles_trabajador extends javax.swing.JPanel {

    frmPrincipal p;
    Ingreso_Soles_TrabajadoresDAO ingresoDAO;
    Ingreso_Soles_Trabajadores ingreso;
    int posicionSeleccion;
    public static int id_trabajador;

    public panel_egresoSoles_trabajador() {
        initComponents();
        Ingreso_Soles_TrabajadoresDAO.listaTrabajadores.clear();
        ingresoDAO = new Ingreso_Soles_TrabajadoresDAO();
        obtenerDatos();
        borrarDatosTextos();
        inabilitarTextos(false);
        autoCompleter();
        poputaTable();
    }

    public void poputaTable() {
        JPopupMenu popuMenu = new JPopupMenu();
        JMenuItem menuItem = new JMenuItem("Agregar ingreso o egreso de dinero");
        menuItem.addActionListener(new listener());
        popuMenu.add(menuItem);
        tabla_trabajadores.setComponentPopupMenu(popuMenu);
    }

    class listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            panel_Detalle_egresoSoles_Trabajadores a = new panel_Detalle_egresoSoles_Trabajadores();
            a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
            panel_Detalle_egresoSoles_Trabajadores.txtTrabajador.setText(txtTrabajador.getText());
            p.principal.removeAll();
            p.principal.add(a, BorderLayout.CENTER);
            p.principal.revalidate();
            p.principal.repaint();
        }
    }

    void autoCompleter() {
        TextAutoCompleter texto = new TextAutoCompleter(txtTrabajador);
        ingresoDAO.cargarListaTrabajador();
        ArrayList<Persona> listaTrabajador = ingresoDAO.listaTrabajadores;
        for (Persona lista : listaTrabajador) {
            texto.addItem(lista.getNombre());
        }
    }

    void borrarDatosTextos() {
        txtId.setText(String.valueOf(ingresoDAO.obtnerCodigoSueldo()));
        txtTrabajador.setText("");
    }

    void inabilitarBotones(boolean estado) {
        agregar.setEnabled(estado);
        actualizar.setEnabled(!estado);
        eliminar.setEnabled(!estado);
    }

    void inabilitarTextos(boolean estado) {
        txtTrabajador.setEnabled(estado);
    }

    void setColor(JPanel panel) {
        panel.setBackground(new Color(220, 220, 220));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(255, 255, 255));
    }

    Ingreso_Soles_Trabajadores recogerDatos() {
        int id = Integer.parseInt(txtId.getText());
        String aux_nombre = txtTrabajador.getText();
        String estado = "";
        if (Activo.isSelected()) {
            estado = "Activo";

        } else {
            estado = "Inactivo";
        }
        ingreso = new Ingreso_Soles_Trabajadores(id, ingresoDAO.devolverIdTrabajador(aux_nombre), estado);
        return ingreso;
    }

    void obtenerDatos() {
        DefaultTableModel model = ingresoDAO.mostrar();
        tabla_trabajadores.setModel(model);
    }

    void ponerDatosTextos() {
        txtId.setText(tabla_trabajadores.getValueAt(posicionSeleccion, 0).toString());
        txtTrabajador.setText(tabla_trabajadores.getValueAt(posicionSeleccion, 1).toString());
        String estado = tabla_trabajadores.getValueAt(posicionSeleccion, 2).toString();
        if (estado.equals("Activo")) {
            Activo.setSelected(true);
            Inactivo.setSelected(false);
        } else {
            Activo.setSelected(false);
            Inactivo.setSelected(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_trabajadores = new javax.swing.JTable();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtTrabajador = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        Activo = new javax.swing.JRadioButton();
        Inactivo = new javax.swing.JRadioButton();

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

        tabla_trabajadores.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_trabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_trabajadoresMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla_trabajadores);

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
                .addGap(39, 39, 39)
                .addGroup(nuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        nuevoLayout.setVerticalGroup(
            nuevoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel14)
                .addGap(10, 10, 10)
                .addComponent(jLabel13)
                .addContainerGap(33, Short.MAX_VALUE))
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
                .addGap(39, 39, 39)
                .addGroup(agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        agregarLayout.setVerticalGroup(
            agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregarLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addContainerGap(35, Short.MAX_VALUE))
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
                .addGap(40, 40, 40)
                .addGroup(eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        eliminarLayout.setVerticalGroup(
            eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(eliminarLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel17)
                .addGap(10, 10, 10)
                .addComponent(jLabel18)
                .addContainerGap(33, Short.MAX_VALUE))
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
                .addGap(37, 37, 37)
                .addGroup(actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel20)
                    .addComponent(jLabel19))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        actualizarLayout.setVerticalGroup(
            actualizarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(actualizarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel19)
                .addGap(10, 10, 10)
                .addComponent(jLabel20)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(actualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(eliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(actualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(nuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(agregar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 204)));

        jLabel1.setText("Id");

        jLabel3.setText("Trabajador");

        jLabel4.setText("Estado");

        txtTrabajador.setForeground(new java.awt.Color(0, 153, 153));

        jPanel4.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 204, 204)));

        buttonGroup1.add(Activo);
        Activo.setSelected(true);
        Activo.setText("Activo");

        buttonGroup1.add(Inactivo);
        Inactivo.setText("Inactivo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(Activo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Inactivo)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Activo)
                    .addComponent(Inactivo)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(45, 45, 45)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTrabajador)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTrabajador, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(85, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
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
        ingresoDAO.listaTrabajadores.clear();
    }//GEN-LAST:event_jLabel2MouseClicked

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

        ingresoDAO.agregar(recogerDatos());
        inabilitarBotones(false);
        obtenerDatos();
    }//GEN-LAST:event_agregarMouseClicked

    private void agregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseEntered
        setColor(agregar);
    }//GEN-LAST:event_agregarMouseEntered

    private void agregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregarMouseExited
        resetColor(agregar);
    }//GEN-LAST:event_agregarMouseExited

    private void eliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseClicked
        int id = Integer.parseInt(tabla_trabajadores.getValueAt(posicionSeleccion, 0).toString());
        ingresoDAO.eliminar(id);
        obtenerDatos();
    }//GEN-LAST:event_eliminarMouseClicked

    private void eliminarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseEntered
        setColor(eliminar);
    }//GEN-LAST:event_eliminarMouseEntered

    private void eliminarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarMouseExited
        resetColor(eliminar);
    }//GEN-LAST:event_eliminarMouseExited

    private void actualizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseClicked
        ingresoDAO.modificar(recogerDatos());
        obtenerDatos();
    }//GEN-LAST:event_actualizarMouseClicked

    private void actualizarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseEntered
        setColor(actualizar);
    }//GEN-LAST:event_actualizarMouseEntered

    private void actualizarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_actualizarMouseExited

    }//GEN-LAST:event_actualizarMouseExited

    private void tabla_trabajadoresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_trabajadoresMousePressed
        posicionSeleccion = tabla_trabajadores.getSelectedRow();
        ponerDatosTextos();
        id_trabajador = ingresoDAO.devolverIdTrabajador(txtTrabajador.getText());


    }//GEN-LAST:event_tabla_trabajadoresMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Activo;
    private javax.swing.JRadioButton Inactivo;
    private javax.swing.JPanel actualizar;
    private javax.swing.JPanel agregar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel eliminar;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel nuevo;
    private javax.swing.JTable tabla_trabajadores;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtTrabajador;
    // End of variables declaration//GEN-END:variables
}
