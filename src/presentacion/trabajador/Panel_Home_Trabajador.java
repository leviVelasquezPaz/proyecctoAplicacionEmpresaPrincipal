/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.trabajador;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import presentacion.frmPrincipal;
import static presentacion.frmPrincipal.opciones;

/**
 *
 * @author MINERAMIRAFLORES
 */
public class Panel_Home_Trabajador extends javax.swing.JPanel {

    int x, y;
    frmPrincipal p;

    public Panel_Home_Trabajador() {
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
        estado = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        panelEgresoDinero = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        asistencias = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        asistencias_trabajador = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(800, 550));

        panelAgregar.setBackground(new java.awt.Color(255, 255, 255));
        panelAgregar.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 255, 255)));
        panelAgregar.setPreferredSize(new java.awt.Dimension(150, 150));
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

        javax.swing.GroupLayout panelAgregarLayout = new javax.swing.GroupLayout(panelAgregar);
        panelAgregar.setLayout(panelAgregarLayout);
        panelAgregarLayout.setHorizontalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        panelAgregarLayout.setVerticalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(18, 18, 18))
        );

        estado.setBackground(new java.awt.Color(255, 255, 255));
        estado.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 255, 255)));
        estado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                estadoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                estadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                estadoMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel8.setText("Estado tra");

        javax.swing.GroupLayout estadoLayout = new javax.swing.GroupLayout(estado);
        estado.setLayout(estadoLayout);
        estadoLayout.setHorizontalGroup(
            estadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(estadoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addContainerGap(13, Short.MAX_VALUE))
        );
        estadoLayout.setVerticalGroup(
            estadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, estadoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(24, 24, 24))
        );

        panelEgresoDinero.setBackground(new java.awt.Color(255, 255, 255));
        panelEgresoDinero.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 255, 255)));
        panelEgresoDinero.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                panelEgresoDineroMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelEgresoDineroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelEgresoDineroMouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/icons8_Money_Bag_60px.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel9.setText("Dinero");

        javax.swing.GroupLayout panelEgresoDineroLayout = new javax.swing.GroupLayout(panelEgresoDinero);
        panelEgresoDinero.setLayout(panelEgresoDineroLayout);
        panelEgresoDineroLayout.setHorizontalGroup(
            panelEgresoDineroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEgresoDineroLayout.createSequentialGroup()
                .addGroup(panelEgresoDineroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEgresoDineroLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel3))
                    .addGroup(panelEgresoDineroLayout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel9)))
                .addContainerGap(45, Short.MAX_VALUE))
        );
        panelEgresoDineroLayout.setVerticalGroup(
            panelEgresoDineroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelEgresoDineroLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(5, 5, 5))
        );

        asistencias.setBackground(new java.awt.Color(255, 255, 255));
        asistencias.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 255, 255)));
        asistencias.setPreferredSize(new java.awt.Dimension(150, 150));
        asistencias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asistenciasMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                asistenciasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                asistenciasMouseExited(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/trabajador.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel5.setText("Asistencias");

        javax.swing.GroupLayout asistenciasLayout = new javax.swing.GroupLayout(asistencias);
        asistencias.setLayout(asistenciasLayout);
        asistenciasLayout.setHorizontalGroup(
            asistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asistenciasLayout.createSequentialGroup()
                .addGroup(asistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(asistenciasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5))
                    .addGroup(asistenciasLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        asistenciasLayout.setVerticalGroup(
            asistenciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asistenciasLayout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18))
        );

        asistencias_trabajador.setBackground(new java.awt.Color(255, 255, 255));
        asistencias_trabajador.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 255, 255)));
        asistencias_trabajador.setPreferredSize(new java.awt.Dimension(150, 150));
        asistencias_trabajador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                asistencias_trabajadorMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                asistencias_trabajadorMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                asistencias_trabajadorMouseExited(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/trabajador/Imagenes/trabajador.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel7.setText("Asis. Trabajador");

        javax.swing.GroupLayout asistencias_trabajadorLayout = new javax.swing.GroupLayout(asistencias_trabajador);
        asistencias_trabajador.setLayout(asistencias_trabajadorLayout);
        asistencias_trabajadorLayout.setHorizontalGroup(
            asistencias_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asistencias_trabajadorLayout.createSequentialGroup()
                .addGroup(asistencias_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(asistencias_trabajadorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel7))
                    .addGroup(asistencias_trabajadorLayout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(jLabel6)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        asistencias_trabajadorLayout.setVerticalGroup(
            asistencias_trabajadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(asistencias_trabajadorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(18, 18, 18))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(panelAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(estado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(panelEgresoDinero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(asistencias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(asistencias_trabajador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(183, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(182, 182, 182)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEgresoDinero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(estado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelAgregar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(asistencias_trabajador, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                    .addComponent(asistencias, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
                .addContainerGap(130, Short.MAX_VALUE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void panelAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAgregarMouseClicked
        Panel_Agregar_Trabajador a = new Panel_Agregar_Trabajador();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();

    }//GEN-LAST:event_panelAgregarMouseClicked

    private void panelAgregarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAgregarMouseEntered
        setColor(panelAgregar);
    }//GEN-LAST:event_panelAgregarMouseEntered

    private void panelAgregarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAgregarMouseExited
        resetColor(panelAgregar);
    }//GEN-LAST:event_panelAgregarMouseExited

    private void estadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estadoMouseClicked
        panel_Estado_Trabajador a = new panel_Estado_Trabajador();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
    }//GEN-LAST:event_estadoMouseClicked

    private void estadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estadoMouseEntered
        setColor(estado);
    }//GEN-LAST:event_estadoMouseEntered

    private void estadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_estadoMouseExited
        resetColor(estado);    }//GEN-LAST:event_estadoMouseExited

    private void panelEgresoDineroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEgresoDineroMouseClicked
        panel_egresoSoles_trabajador a = new panel_egresoSoles_trabajador();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
    }//GEN-LAST:event_panelEgresoDineroMouseClicked

    private void panelEgresoDineroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEgresoDineroMouseEntered
        setColor(panelEgresoDinero);

    }//GEN-LAST:event_panelEgresoDineroMouseEntered

    private void panelEgresoDineroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelEgresoDineroMouseExited

        resetColor(panelEgresoDinero);
    }//GEN-LAST:event_panelEgresoDineroMouseExited

    private void asistenciasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asistenciasMouseClicked
        panel_asistencias_trabajadores a = new panel_asistencias_trabajadores();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();

    }//GEN-LAST:event_asistenciasMouseClicked

    private void asistenciasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asistenciasMouseEntered
        setColor(asistencias);
    }//GEN-LAST:event_asistenciasMouseEntered

    private void asistenciasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asistenciasMouseExited
        resetColor(asistencias);
    }//GEN-LAST:event_asistenciasMouseExited

    private void asistencias_trabajadorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asistencias_trabajadorMouseClicked
        panel_asistencias_por_trabajador a = new panel_asistencias_por_trabajador();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
    }//GEN-LAST:event_asistencias_trabajadorMouseClicked

    private void asistencias_trabajadorMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asistencias_trabajadorMouseEntered
        setColor(asistencias_trabajador);
    }//GEN-LAST:event_asistencias_trabajadorMouseEntered

    private void asistencias_trabajadorMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_asistencias_trabajadorMouseExited
        resetColor(asistencias_trabajador);
    }//GEN-LAST:event_asistencias_trabajadorMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel asistencias;
    private javax.swing.JPanel asistencias_trabajador;
    private javax.swing.JPanel estado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel panelAgregar;
    private javax.swing.JPanel panelEgresoDinero;
    // End of variables declaration//GEN-END:variables
}
