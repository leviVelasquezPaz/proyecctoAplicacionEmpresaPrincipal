/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Proyectos;

import presentacion.Cliente.*;
import presentacion.trabajador.*;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import presentacion.frmPrincipal;
import static presentacion.frmPrincipal.opciones;

/**
 *
 * @author MINERAMIRAFLORES
 */
public class Panel_Home_Proyectos extends javax.swing.JPanel {

    int x, y;
    frmPrincipal p;
    public static boolean estado = false;

    public Panel_Home_Proyectos() {
        initComponents();

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

        jPanel5 = new javax.swing.JPanel();
        panelAgregar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        montoClientes = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        agregar_descripciones = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(800, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(800, 550));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAgregar.setBackground(new java.awt.Color(255, 255, 255));
        panelAgregar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelAgregar.setPreferredSize(new java.awt.Dimension(200, 150));
        panelAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelAgregarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelAgregarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelAgregarMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/trabajador.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel2.setText("Agregar");

        jLabel3.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel3.setText("Agrega un nuevo proyeccto ");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Cliente/Imagenes/icons8_Right_32px.png"))); // NOI18N

        javax.swing.GroupLayout panelAgregarLayout = new javax.swing.GroupLayout(panelAgregar);
        panelAgregar.setLayout(panelAgregarLayout);
        panelAgregarLayout.setHorizontalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(27, 27, 27))
        );
        panelAgregarLayout.setVerticalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAgregarLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3))
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(panelAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 390, 100));

        montoClientes.setBackground(new java.awt.Color(255, 255, 255));
        montoClientes.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        montoClientes.setPreferredSize(new java.awt.Dimension(200, 150));
        montoClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                montoClientesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                montoClientesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                montoClientesMouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Cliente/Imagenes/money.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel10.setText("Visualizar monto de ");

        jLabel11.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel11.setText("Agrega un nuevo cliente ");

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Cliente/Imagenes/icons8_Right_32px.png"))); // NOI18N

        javax.swing.GroupLayout montoClientesLayout = new javax.swing.GroupLayout(montoClientes);
        montoClientes.setLayout(montoClientesLayout);
        montoClientesLayout.setHorizontalGroup(
            montoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(montoClientesLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(montoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );
        montoClientesLayout.setVerticalGroup(
            montoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(montoClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(montoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12)
                    .addGroup(montoClientesLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel11))
                    .addComponent(jLabel9))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPanel5.add(montoClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 390, 100));
        jPanel5.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 800, 10));

        agregar_descripciones.setBackground(new java.awt.Color(255, 255, 255));
        agregar_descripciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        agregar_descripciones.setPreferredSize(new java.awt.Dimension(200, 150));
        agregar_descripciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregar_descripcionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agregar_descripcionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                agregar_descripcionesMouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/trabajador.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel6.setText("Agregar descripciones");

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel7.setText("Descripciones de los proyectos ");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Cliente/Imagenes/icons8_Right_32px.png"))); // NOI18N

        javax.swing.GroupLayout agregar_descripcionesLayout = new javax.swing.GroupLayout(agregar_descripciones);
        agregar_descripciones.setLayout(agregar_descripcionesLayout);
        agregar_descripcionesLayout.setHorizontalGroup(
            agregar_descripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregar_descripcionesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(agregar_descripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(27, 27, 27))
        );
        agregar_descripcionesLayout.setVerticalGroup(
            agregar_descripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregar_descripcionesLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(agregar_descripcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(agregar_descripcionesLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7))
                    .addComponent(jLabel5)
                    .addComponent(jLabel8))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.add(agregar_descripciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 390, 100));
        jPanel5.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 800, 20));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void panelAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAgregarMouseClicked
        panel_agregar_proyectos a = new panel_agregar_proyectos();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        panel_agregar_proyectos.txtBuscar.setVisible(true);
        estado = false;
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
        estaActivoPanel_Descripciones=false;

    }//GEN-LAST:event_panelAgregarMouseClicked

    private void panelAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAgregarMouseEntered
        setColor(panelAgregar);
    }//GEN-LAST:event_panelAgregarMouseEntered

    private void panelAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAgregarMouseExited
        resetColor(panelAgregar);
    }//GEN-LAST:event_panelAgregarMouseExited

    private void montoClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montoClientesMouseClicked
        panel_monto_Clientes a = new panel_monto_Clientes();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
    }//GEN-LAST:event_montoClientesMouseClicked

    private void montoClientesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montoClientesMouseEntered
        setColor(montoClientes);
    }//GEN-LAST:event_montoClientesMouseEntered

    private void montoClientesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_montoClientesMouseExited
        resetColor(montoClientes);
    }//GEN-LAST:event_montoClientesMouseExited

    private void agregar_descripcionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregar_descripcionesMouseExited
        resetColor(agregar_descripciones);
    }//GEN-LAST:event_agregar_descripcionesMouseExited

    private void agregar_descripcionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregar_descripcionesMouseEntered
        setColor(agregar_descripciones);
    }//GEN-LAST:event_agregar_descripcionesMouseEntered
    public static boolean estaActivoPanel_Descripciones = false;
    private void agregar_descripcionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregar_descripcionesMouseClicked
        panel_agregar_proyectos a = new panel_agregar_proyectos();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        panel_agregar_proyectos.panel_configuraciones.setVisible(false);
        panel_agregar_proyectos.panel_descripciones.setVisible(false);
        panel_agregar_proyectos.txtBuscar.setVisible(true);
        estado = true;
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
        estaActivoPanel_Descripciones = true;


    }//GEN-LAST:event_agregar_descripcionesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel agregar_descripciones;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel montoClientes;
    private javax.swing.JPanel panelAgregar;
    // End of variables declaration//GEN-END:variables
}
