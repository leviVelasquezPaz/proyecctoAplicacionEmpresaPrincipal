/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Configuraciones;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import presentacion.frmPrincipal;
import presentacion.trabajador.Panel_Agregar_Trabajador;

/**
 *
 * @author USUARIO
 */
public class panel_home_confiraciones extends javax.swing.JPanel {

    frmPrincipal p;

    public panel_home_confiraciones() {
        initComponents();
    }

   void setColor(JPanel panel) {
        panel.setBackground(new Color(220,220,220));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(255,255,255));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        agregar_sueldo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        titulo_sub_proyectos = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        agregar_sueldo.setBackground(new java.awt.Color(255, 255, 255));
        agregar_sueldo.setPreferredSize(new java.awt.Dimension(150, 150));
        agregar_sueldo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                agregar_sueldoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                agregar_sueldoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                agregar_sueldoMouseExited(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Configuraciones/imagenes/icons8_Money_Bag_50px.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel2.setText("Sueldos");

        javax.swing.GroupLayout agregar_sueldoLayout = new javax.swing.GroupLayout(agregar_sueldo);
        agregar_sueldo.setLayout(agregar_sueldoLayout);
        agregar_sueldoLayout.setHorizontalGroup(
            agregar_sueldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregar_sueldoLayout.createSequentialGroup()
                .addGroup(agregar_sueldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(agregar_sueldoLayout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel1))
                    .addGroup(agregar_sueldoLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel2)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        agregar_sueldoLayout.setVerticalGroup(
            agregar_sueldoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(agregar_sueldoLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addGap(29, 29, 29))
        );

        titulo_sub_proyectos.setBackground(new java.awt.Color(255, 255, 255));
        titulo_sub_proyectos.setPreferredSize(new java.awt.Dimension(150, 150));
        titulo_sub_proyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                titulo_sub_proyectosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                titulo_sub_proyectosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                titulo_sub_proyectosMouseExited(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Configuraciones/imagenes/icons8_Money_Bag_50px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Courier New", 0, 12)); // NOI18N
        jLabel4.setText("Titulos sub proyectos");

        javax.swing.GroupLayout titulo_sub_proyectosLayout = new javax.swing.GroupLayout(titulo_sub_proyectos);
        titulo_sub_proyectos.setLayout(titulo_sub_proyectosLayout);
        titulo_sub_proyectosLayout.setHorizontalGroup(
            titulo_sub_proyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titulo_sub_proyectosLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(titulo_sub_proyectosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );
        titulo_sub_proyectosLayout.setVerticalGroup(
            titulo_sub_proyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(titulo_sub_proyectosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(agregar_sueldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(titulo_sub_proyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(236, 236, 236)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(agregar_sueldo, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(titulo_sub_proyectos, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
                .addGap(260, 260, 260))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void agregar_sueldoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregar_sueldoMouseClicked
        panel_opcionesSalario_Trabajadores a = new panel_opcionesSalario_Trabajadores();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
    }//GEN-LAST:event_agregar_sueldoMouseClicked

    private void agregar_sueldoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregar_sueldoMouseEntered
        setColor(agregar_sueldo);
    }//GEN-LAST:event_agregar_sueldoMouseEntered

    private void agregar_sueldoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_agregar_sueldoMouseExited
        resetColor(agregar_sueldo);
    }//GEN-LAST:event_agregar_sueldoMouseExited

    private void titulo_sub_proyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titulo_sub_proyectosMouseClicked
        panel_agregar_descripciones_titulos_proyectos a = new panel_agregar_descripciones_titulos_proyectos();
        a.setBounds(0, 0, 1000 - p.opciones.getWidth(), 650);
        p.principal.removeAll();
        p.principal.add(a, BorderLayout.CENTER);
        p.principal.revalidate();
        p.principal.repaint();
    }//GEN-LAST:event_titulo_sub_proyectosMouseClicked

    private void titulo_sub_proyectosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titulo_sub_proyectosMouseEntered
        setColor(titulo_sub_proyectos);
    }//GEN-LAST:event_titulo_sub_proyectosMouseEntered

    private void titulo_sub_proyectosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_titulo_sub_proyectosMouseExited
        resetColor(titulo_sub_proyectos);
    }//GEN-LAST:event_titulo_sub_proyectosMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel agregar_sueldo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel titulo_sub_proyectos;
    // End of variables declaration//GEN-END:variables
}
