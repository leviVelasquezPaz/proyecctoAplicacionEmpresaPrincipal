/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.Cliente;

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
public class Panel_Home_Cliente extends javax.swing.JPanel {

    int x, y;
    frmPrincipal p;

    public Panel_Home_Cliente() {
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

        jPanel5 = new javax.swing.JPanel();
        panelAgregar = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        depositoPorCliente = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        montoClientes = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(800, 650));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(800, 550));

        panelAgregar.setBackground(new java.awt.Color(255, 255, 255));
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
        jLabel3.setText("Agrega un nuevo cliente ");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Cliente/Imagenes/icons8_Right_32px.png"))); // NOI18N

        javax.swing.GroupLayout panelAgregarLayout = new javax.swing.GroupLayout(panelAgregar);
        panelAgregar.setLayout(panelAgregarLayout);
        panelAgregarLayout.setHorizontalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(60, 60, 60)
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addContainerGap())
        );
        panelAgregarLayout.setVerticalGroup(
            panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAgregarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(panelAgregarLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(panelAgregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(panelAgregarLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        depositoPorCliente.setBackground(new java.awt.Color(255, 255, 255));
        depositoPorCliente.setPreferredSize(new java.awt.Dimension(200, 150));
        depositoPorCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                depositoPorClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                depositoPorClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                depositoPorClienteMouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Cliente/Imagenes/money.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Courier New", 0, 18)); // NOI18N
        jLabel6.setText("Visualizar monto de clientes");

        jLabel7.setFont(new java.awt.Font("Courier New", 0, 14)); // NOI18N
        jLabel7.setText("Agrega un nuevo cliente ");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Cliente/Imagenes/icons8_Right_32px.png"))); // NOI18N

        javax.swing.GroupLayout depositoPorClienteLayout = new javax.swing.GroupLayout(depositoPorCliente);
        depositoPorCliente.setLayout(depositoPorClienteLayout);
        depositoPorClienteLayout.setHorizontalGroup(
            depositoPorClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depositoPorClienteLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addGap(60, 60, 60)
                .addGroup(depositoPorClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addContainerGap())
        );
        depositoPorClienteLayout.setVerticalGroup(
            depositoPorClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(depositoPorClienteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(depositoPorClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(depositoPorClienteLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(depositoPorClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(depositoPorClienteLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        montoClientes.setBackground(new java.awt.Color(255, 255, 255));
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
        jLabel10.setText("Visualizar monto de clientes");

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
                .addGap(60, 60, 60)
                .addGroup(montoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 321, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addContainerGap())
        );
        montoClientesLayout.setVerticalGroup(
            montoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(montoClientesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(montoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addGroup(montoClientesLayout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(montoClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(montoClientesLayout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)))))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(montoClientes, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
            .addComponent(depositoPorCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(montoClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(depositoPorCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 650));
    }// </editor-fold>//GEN-END:initComponents

    private void panelAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelAgregarMouseClicked
        Panel_Agregar_Cliente a = new Panel_Agregar_Cliente();
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

    private void depositoPorClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositoPorClienteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_depositoPorClienteMouseClicked

    private void depositoPorClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositoPorClienteMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_depositoPorClienteMouseEntered

    private void depositoPorClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_depositoPorClienteMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_depositoPorClienteMouseExited

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel depositoPorCliente;
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
    private javax.swing.JPanel montoClientes;
    private javax.swing.JPanel panelAgregar;
    // End of variables declaration//GEN-END:variables
}
