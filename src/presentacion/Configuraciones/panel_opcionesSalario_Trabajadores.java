/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Configuraciones;

import com.sun.glass.events.KeyEvent;
import dominio.Sueldo;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.SueldoDAO;
import presentacion.frmPrincipal;
import presentacion.trabajador.Panel_Home_Trabajador;

/**
 *
 * @author USUARIO
 */
public class panel_opcionesSalario_Trabajadores extends javax.swing.JPanel {

    frmPrincipal p;
    int id;
    private String cargo, descripcion, estado;
    private double sueldo = 0;
    Sueldo suel;
    SueldoDAO sueldoDAO;
    int posicionSeleccion;

    public panel_opcionesSalario_Trabajadores() {
        initComponents();
        sueldoDAO = new SueldoDAO();
        importanteParaTabla();
        obtenerDatos();
        limpiarTexto();
        txtId.setEnabled(false);
        inabilitarTextos(false);
        inhabilitarBotones(true);
        txtCargo.requestFocus();

    }

    void inhabilitarBotones(boolean blo) {
        btnNuevo.setEnabled(blo);
        btnAgregar.setEnabled(!blo);
        btnEliminar.setEnabled(blo);
        btnActualizar.setEnabled(blo);

    }

    void importanteParaTabla() {
        tabla_opciones.setShowHorizontalLines(false);
        //Ocultar linea vertical
        tabla_opciones.setShowVerticalLines(false);
    }

    void inabilitarTextos(boolean estado) {
        txtCargo.setEnabled(estado);
        txtDescripcion.setEnabled(estado);
        txtSueldo.setEnabled(estado);
    }

    void limpiarTexto() {
        txtId.setText(String.valueOf(sueldoDAO.obtnerCodigoSueldo()));
        txtCargo.setText("");
        txtDescripcion.setText("");
        txtSueldo.setText("");
    }

    Sueldo recogerDatos() {

        id = Integer.parseInt(txtId.getText());

        if (txtCargo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(this, "Falta llenar el campo cargo" + JOptionPane.WARNING_MESSAGE);
            txtCargo.requestFocusInWindow();

        }
        if (txtSueldo.getText().length() == 0) {
            JOptionPane.showConfirmDialog(this, "Falta llenar el campo Sueldo" + JOptionPane.WARNING_MESSAGE);
            txtSueldo.requestFocusInWindow();
        }
        cargo = txtCargo.getText();
        descripcion = txtDescripcion.getText();
        sueldo = Double.parseDouble(txtSueldo.getText());
        if (Activo.isSelected()) {
            estado = "Activo";
        } else {
            estado = "Inactivo";
        }
        suel = new Sueldo(id, cargo, descripcion, sueldo, estado);
        return suel;

    }

    void obtenerDatos() {
        DefaultTableModel modelo = sueldoDAO.mostrar();
        tabla_opciones.setModel(modelo);

    }

    void ponerDatosTextos() {

        id = Integer.parseInt(tabla_opciones.getValueAt(posicionSeleccion, 0).toString());
        cargo = tabla_opciones.getValueAt(posicionSeleccion, 1).toString();
        descripcion = tabla_opciones.getValueAt(posicionSeleccion, 2).toString();
        sueldo = Double.parseDouble(tabla_opciones.getValueAt(posicionSeleccion, 3).toString());
        estado = tabla_opciones.getValueAt(posicionSeleccion, 4).toString();
        txtId.setText(String.valueOf(id));
        txtCargo.setText(cargo);
        txtDescripcion.setText(descripcion);
        txtSueldo.setText(String.valueOf(sueldo));
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

        grupo_estado = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnNuevo = new rojeru_san.RSButton();
        btnAgregar = new rojeru_san.RSButton();
        btnEliminar = new rojeru_san.RSButton();
        btnActualizar = new rojeru_san.RSButton();
        txtBuscar = new org.jdesktop.swingx.JXSearchField();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        Inactivo = new javax.swing.JRadioButton();
        Activo = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jXTreeTable1 = new org.jdesktop.swingx.JXTreeTable();
        txtCargo = new rojerusan.RSMetroTextFullPlaceHolder();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        txtSueldo = new rojerusan.RSMetroTextFullPlaceHolder();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla_opciones = new rojerusan.RSTableMetro();

        setBackground(new java.awt.Color(255, 255, 255));
        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 200, 91), 5));
        setPreferredSize(new java.awt.Dimension(800, 617));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
                .addContainerGap(720, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 790, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 0, 2, 0, new java.awt.Color(0, 200, 91)));

        btnNuevo.setBackground(new java.awt.Color(0, 220, 91));
        btnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Configuraciones/imagenes/icons8_Add_New_34px_1.png"))); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.setToolTipText("");
        btnNuevo.setColorText(new java.awt.Color(0, 0, 0));
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(new java.awt.Color(0, 220, 91));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Configuraciones/imagenes/icons8_Save_34px.png"))); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.setColorText(new java.awt.Color(0, 0, 0));
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 220, 91));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Configuraciones/imagenes/icons8_Delete_File_34px.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.setColorText(new java.awt.Color(0, 0, 0));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(0, 220, 91));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Configuraciones/imagenes/icons8_Update_34px.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.setColorText(new java.awt.Color(0, 0, 0));
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 100, 790, -1));

        txtBuscar.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 200, 91)));
        txtBuscar.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBuscar.setName(""); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
        });
        add(txtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 179, 19));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("id:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(74, 240, -1, -1));

        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 227, 191, 42));

        Inactivo.setBackground(new java.awt.Color(255, 255, 255));
        grupo_estado.add(Inactivo);
        Inactivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Inactivo.setText("Inactivo");
        add(Inactivo, new org.netbeans.lib.awtextra.AbsoluteConstraints(639, 371, -1, -1));

        Activo.setBackground(new java.awt.Color(255, 255, 255));
        grupo_estado.add(Activo);
        Activo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Activo.setSelected(true);
        Activo.setText("Activo");
        add(Activo, new org.netbeans.lib.awtextra.AbsoluteConstraints(537, 371, 69, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Estado:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(434, 371, -1, -1));

        jScrollPane4.setBackground(new java.awt.Color(0, 200, 91));
        jScrollPane4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 200, 91)));

        jXTreeTable1.setBackground(new java.awt.Color(0, 200, 91));
        jScrollPane4.setViewportView(jXTreeTable1);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, 234));

        txtCargo.setForeground(new java.awt.Color(0, 0, 0));
        txtCargo.setBorderColor(new java.awt.Color(0, 200, 91));
        txtCargo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtCargo.setPhColor(new java.awt.Color(0, 0, 0));
        txtCargo.setSoloLetras(true);
        txtCargo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCargoKeyTyped(evt);
            }
        });
        add(txtCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 287, 191, -1));

        jXLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel1.setText("Cargo:");
        jXLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(jXLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 298, 74, -1));

        txtSueldo.setForeground(new java.awt.Color(0, 0, 0));
        txtSueldo.setBorderColor(new java.awt.Color(0, 200, 91));
        txtSueldo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtSueldo.setPhColor(new java.awt.Color(0, 0, 0));
        txtSueldo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSueldoKeyTyped(evt);
            }
        });
        add(txtSueldo, new org.netbeans.lib.awtextra.AbsoluteConstraints(99, 347, 191, -1));

        jXLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel2.setText("Sueldo:");
        jXLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(jXLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 358, 74, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDescripcion.setRows(5);
        jScrollPane2.setViewportView(txtDescripcion);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(508, 233, 258, 98));

        jXLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jXLabel3.setText("Descripción:");
        jXLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        add(jXLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(389, 265, 91, -1));

        tabla_opciones.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla_opciones.setAltoHead(35);
        tabla_opciones.setColorBackgoundHead(new java.awt.Color(0, 200, 91));
        tabla_opciones.setColorBordeHead(new java.awt.Color(204, 204, 204));
        tabla_opciones.setColorFilasForeground1(new java.awt.Color(0, 126, 51));
        tabla_opciones.setColorFilasForeground2(new java.awt.Color(0, 126, 51));
        tabla_opciones.setColorForegroundHead(new java.awt.Color(0, 0, 0));
        tabla_opciones.setColorSelBackgound(new java.awt.Color(0, 200, 91));
        tabla_opciones.setGrosorBordeFilas(0);
        tabla_opciones.setRowHeight(25);
        tabla_opciones.getTableHeader().setResizingAllowed(false);
        tabla_opciones.getTableHeader().setReorderingAllowed(false);
        tabla_opciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tabla_opcionesMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tabla_opciones);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 452, 770, 180));
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        this.setVisible(false);
        panel_home_confiraciones a = new panel_home_confiraciones();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
        
      
    }//GEN-LAST:event_jLabel2MouseClicked

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        limpiarTexto();
        inabilitarTextos(true);
        inhabilitarBotones(false);
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        sueldoDAO.agregar(recogerDatos());
        obtenerDatos();
        inabilitarTextos(false);
        limpiarTexto();
        inhabilitarBotones(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        id = Integer.parseInt(tabla_opciones.getValueAt(posicionSeleccion, 0).toString());
        sueldoDAO.eliminar(id);
        obtenerDatos();
        inabilitarTextos(false);
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        sueldoDAO.modificar(recogerDatos());
        obtenerDatos();
        inabilitarTextos(false);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdActionPerformed

    private void tabla_opcionesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla_opcionesMousePressed
        posicionSeleccion = tabla_opciones.getSelectedRow();
        ponerDatosTextos();
        inabilitarTextos(true);
    }//GEN-LAST:event_tabla_opcionesMousePressed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed
        if (txtBuscar.getText().equals("")) {
            obtenerDatos();
        } else {
            DefaultTableModel modelo = sueldoDAO.buscar(txtBuscar.getText());
            tabla_opciones.setModel(modelo);
          
        }
    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtCargoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCargoKeyTyped
       if(evt.getKeyChar()==KeyEvent.VK_ENTER)
       {
           txtSueldo.requestFocus();
       }
        
    }//GEN-LAST:event_txtCargoKeyTyped

    private void txtSueldoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSueldoKeyTyped
        if(evt.getKeyChar()==KeyEvent.VK_ENTER)
       {
           txtDescripcion.requestFocus();
       }
    }//GEN-LAST:event_txtSueldoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Activo;
    private javax.swing.JRadioButton Inactivo;
    private rojeru_san.RSButton btnActualizar;
    private rojeru_san.RSButton btnAgregar;
    private rojeru_san.RSButton btnEliminar;
    private rojeru_san.RSButton btnNuevo;
    private javax.swing.ButtonGroup grupo_estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXTreeTable jXTreeTable1;
    private rojerusan.RSTableMetro tabla_opciones;
    private org.jdesktop.swingx.JXSearchField txtBuscar;
    private rojerusan.RSMetroTextFullPlaceHolder txtCargo;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtId;
    private rojerusan.RSMetroTextFullPlaceHolder txtSueldo;
    // End of variables declaration//GEN-END:variables
}
