/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.otros;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author MINERAMIRAFLORES
 */
public class Notificacion extends javax.swing.JPanel {

    /**
     * Creates new form Notificacion
     */
    public Notificacion(String titulo, String cuerpo, String quienActiva) {
        initComponents();
        lblTitulo.setText(titulo);
        lblCuerpo.setText(cuerpo);
        check.setVisible(false);
        fail.setVisible(false);
        if (quienActiva.equals("check")) {
            check.setVisible(true);
        } else if (quienActiva.equals("fail")) {
            fail.setVisible(true);
        }
    }

     void setColor(JPanel panel) {
        panel.setBackground(new Color(153, 153, 153));
    }

    void resetColor(JPanel panel) {
        panel.setBackground(new Color(240, 240, 240));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        check = new javax.swing.JLabel();
        fail = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        fail1 = new javax.swing.JLabel();
        check1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblCuerpo = new javax.swing.JLabel();
        aceptar = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cancelar = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N
        jPanel2.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

        fail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fail.png"))); // NOI18N
        jPanel2.add(fail, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 60, 40));

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(255, 255, 255));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Agregar Trabajador");
        jPanel2.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));
        jPanel2.add(fail1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 63, 55));
        jPanel2.add(check1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 63, 55));

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 436, 75));

        jPanel3.setBackground(new java.awt.Color(204, 102, 0));

        lblCuerpo.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        lblCuerpo.setForeground(new java.awt.Color(255, 255, 255));
        lblCuerpo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCuerpo.setText("Agregar Trabajador");

        aceptar.setBackground(java.awt.SystemColor.controlHighlight);
        aceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                aceptarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                aceptarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                aceptarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                aceptarMousePressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(45, 118, 232));
        jLabel13.setText("Aceptar");

        javax.swing.GroupLayout aceptarLayout = new javax.swing.GroupLayout(aceptar);
        aceptar.setLayout(aceptarLayout);
        aceptarLayout.setHorizontalGroup(
            aceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(aceptarLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel13)
                .addContainerGap(42, Short.MAX_VALUE))
        );
        aceptarLayout.setVerticalGroup(
            aceptarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, aceptarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel13)
                .addGap(22, 22, 22))
        );

        cancelar.setBackground(java.awt.SystemColor.controlHighlight);
        cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelarMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelarMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cancelarMousePressed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(45, 118, 232));
        jLabel15.setText("Cancelar");

        javax.swing.GroupLayout cancelarLayout = new javax.swing.GroupLayout(cancelar);
        cancelar.setLayout(cancelarLayout);
        cancelarLayout.setHorizontalGroup(
            cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelarLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cancelarLayout.setVerticalGroup(
            cancelarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cancelarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCuerpo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblCuerpo)
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 436, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarMouseClicked
        setVisible(false);
    }//GEN-LAST:event_aceptarMouseClicked

    private void aceptarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarMouseEntered
        setColor(aceptar);
    }//GEN-LAST:event_aceptarMouseEntered

    private void aceptarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarMouseExited
        resetColor(aceptar);
    }//GEN-LAST:event_aceptarMouseExited

    private void aceptarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_aceptarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_aceptarMousePressed

    private void cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseClicked
        setVisible(false);
    }//GEN-LAST:event_cancelarMouseClicked

    private void cancelarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseEntered
        setColor(cancelar);
    }//GEN-LAST:event_cancelarMouseEntered

    private void cancelarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMouseExited
        resetColor(cancelar);
    }//GEN-LAST:event_cancelarMouseExited

    private void cancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelarMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelarMousePressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel aceptar;
    private javax.swing.JPanel cancelar;
    private javax.swing.JLabel check;
    private javax.swing.JLabel check1;
    private javax.swing.JLabel fail;
    private javax.swing.JLabel fail1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCuerpo;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
