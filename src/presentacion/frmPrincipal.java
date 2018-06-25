/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import presentacion.Cliente.Panel_Home_Cliente;
import presentacion.Configuraciones.panel_home_confiraciones;
import presentacion.Proyectos.Panel_Home_Proyectos;

import presentacion.trabajador.Panel_Home_Trabajador;

/**
 *
 * @author Levi
 */
public class frmPrincipal extends javax.swing.JFrame {

    int anchoPantalla;
    int alturaPantalla;
    public int x, y;

    public frmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        x = this.getX();
        y = this.getY();
        fail.setVisible(false);
        check.setVisible(false);
    }

    public static void controladorErrores(String titulo, String quienActiva) {
        lblTitulo.setVisible(true);
        if (quienActiva.equals("check")) {
            check.setVisible(true);
        } else if (quienActiva.equals("fail")) {
            fail.setVisible(true);
        }
        lblTitulo.setText(titulo);
        Timer timer = new Timer(8000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                check.setVisible(false);
                fail.setVisible(false);
                lblTitulo.setVisible(false);
            }
        });
        timer.start();

    }

    public void fullScreen() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension miPantalla = tk.getScreenSize();
        anchoPantalla = miPantalla.width;
        alturaPantalla = miPantalla.height;
        System.out.println("ancho " + anchoPantalla);
        System.out.println("altura " + alturaPantalla);

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

        panel_principal = new javax.swing.JPanel();
        cabecera = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        check = new javax.swing.JLabel();
        fail = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        opciones = new javax.swing.JPanel();
        trabajadores = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        configuraciones = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Cliente = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Proyectos = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        principal = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        panel_principal.setPreferredSize(new java.awt.Dimension(1000, 600));
        panel_principal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cabecera.setBackground(new java.awt.Color(0, 200, 91));
        cabecera.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 200, 91)));
        cabecera.setPreferredSize(new java.awt.Dimension(1000, 50));
        cabecera.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/expand2-32.png"))); // NOI18N
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        cabecera.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 10, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/ex-32.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        cabecera.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, -1, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 24)); // NOI18N
        jLabel5.setText("Empresa");
        cabecera.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 130, -1));

        check.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check.png"))); // NOI18N
        cabecera.add(check, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 50, 50));

        fail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fail.png"))); // NOI18N
        cabecera.add(fail, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 0, 60, 50));

        lblTitulo.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(51, 51, 51));
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        cabecera.add(lblTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 360, 20));

        panel_principal.add(cabecera, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        opciones.setBackground(new java.awt.Color(255, 255, 255));
        opciones.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 2, 2, 2, new java.awt.Color(0, 200, 91)));
        opciones.setPreferredSize(new java.awt.Dimension(200, 650));

        trabajadores.setBackground(new java.awt.Color(255, 255, 255));
        trabajadores.setMinimumSize(new java.awt.Dimension(200, 50));
        trabajadores.setPreferredSize(new java.awt.Dimension(200, 50));
        trabajadores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                trabajadoresMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                trabajadoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                trabajadoresMouseExited(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel3.setText("Trabajadores");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/people.png"))); // NOI18N

        javax.swing.GroupLayout trabajadoresLayout = new javax.swing.GroupLayout(trabajadores);
        trabajadores.setLayout(trabajadoresLayout);
        trabajadoresLayout.setHorizontalGroup(
            trabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(trabajadoresLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        trabajadoresLayout.setVerticalGroup(
            trabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, trabajadoresLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(trabajadoresLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        configuraciones.setBackground(new java.awt.Color(255, 255, 255));
        configuraciones.setMinimumSize(new java.awt.Dimension(200, 50));
        configuraciones.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                configuracionesMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                configuracionesMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                configuracionesMouseExited(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel6.setText("Configuraciones");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/presentacion/Configuraciones/imagenes/configuration.png"))); // NOI18N

        javax.swing.GroupLayout configuracionesLayout = new javax.swing.GroupLayout(configuraciones);
        configuraciones.setLayout(configuracionesLayout);
        configuracionesLayout.setHorizontalGroup(
            configuracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(configuracionesLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        configuracionesLayout.setVerticalGroup(
            configuracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, configuracionesLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(configuracionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        Cliente.setBackground(new java.awt.Color(255, 255, 255));
        Cliente.setMinimumSize(new java.awt.Dimension(200, 50));
        Cliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ClienteMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ClienteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ClienteMouseExited(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel8.setText("Clientes");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/people.png"))); // NOI18N

        javax.swing.GroupLayout ClienteLayout = new javax.swing.GroupLayout(Cliente);
        Cliente.setLayout(ClienteLayout);
        ClienteLayout.setHorizontalGroup(
            ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ClienteLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ClienteLayout.setVerticalGroup(
            ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClienteLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(ClienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addContainerGap())
        );

        Proyectos.setBackground(new java.awt.Color(255, 255, 255));
        Proyectos.setMinimumSize(new java.awt.Dimension(200, 50));
        Proyectos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ProyectosMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                ProyectosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ProyectosMouseExited(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel10.setText("Proyectos");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/people.png"))); // NOI18N

        javax.swing.GroupLayout ProyectosLayout = new javax.swing.GroupLayout(Proyectos);
        Proyectos.setLayout(ProyectosLayout);
        ProyectosLayout.setHorizontalGroup(
            ProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProyectosLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        ProyectosLayout.setVerticalGroup(
            ProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProyectosLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(ProyectosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addContainerGap())
        );

        javax.swing.GroupLayout opcionesLayout = new javax.swing.GroupLayout(opciones);
        opciones.setLayout(opcionesLayout);
        opcionesLayout.setHorizontalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, opcionesLayout.createSequentialGroup()
                .addGroup(opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(configuraciones, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(trabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Cliente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Proyectos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        opcionesLayout.setVerticalGroup(
            opcionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesLayout.createSequentialGroup()
                .addComponent(configuraciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(trabajadores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Proyectos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel_principal.add(opciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 200, 650));

        principal.setBackground(new java.awt.Color(255, 255, 255));
        principal.setPreferredSize(new java.awt.Dimension(800, 650));

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        panel_principal.add(principal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 800, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel_principal, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved

    }//GEN-LAST:event_formMouseMoved

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        this.setLocation(this.getLocation().x + evt.getX() - x, this.getLocation().y + evt.getY() - y);
    }//GEN-LAST:event_formMouseDragged

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void trabajadoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trabajadoresMouseEntered
        setColor(trabajadores);
    }//GEN-LAST:event_trabajadoresMouseEntered

    private void trabajadoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trabajadoresMouseExited
        resetColor(trabajadores);
    }//GEN-LAST:event_trabajadoresMouseExited

    private void trabajadoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_trabajadoresMouseClicked
        Panel_Home_Trabajador a = new Panel_Home_Trabajador();
        a.setBounds(0, 0, 1000 - opciones.getWidth(), 650);
        principal.removeAll();
        principal.add(a, BorderLayout.CENTER);
        principal.revalidate();
        principal.repaint();
    }//GEN-LAST:event_trabajadoresMouseClicked

    private void configuracionesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configuracionesMouseClicked
        panel_home_confiraciones a = new panel_home_confiraciones();
        a.setBounds(0, 0, 1000 - opciones.getWidth(), 650);
        principal.removeAll();
        principal.add(a, BorderLayout.CENTER);
        principal.revalidate();
        principal.repaint();
    }//GEN-LAST:event_configuracionesMouseClicked

    private void configuracionesMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configuracionesMouseEntered
        setColor(configuraciones);
    }//GEN-LAST:event_configuracionesMouseEntered

    private void configuracionesMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_configuracionesMouseExited
        resetColor(configuraciones);
    }//GEN-LAST:event_configuracionesMouseExited

    private void ClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClienteMouseClicked

        Panel_Home_Cliente a = new Panel_Home_Cliente();
        a.setBounds(0, 0, 1000 - opciones.getWidth(), 650);
        principal.removeAll();
        principal.add(a, BorderLayout.CENTER);
        principal.revalidate();
        principal.repaint();


    }//GEN-LAST:event_ClienteMouseClicked

    private void ClienteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClienteMouseEntered
        setColor(Cliente);
    }//GEN-LAST:event_ClienteMouseEntered

    private void ClienteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ClienteMouseExited
        resetColor(Cliente);    }//GEN-LAST:event_ClienteMouseExited

    private void ProyectosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProyectosMouseClicked
        Panel_Home_Proyectos a = new Panel_Home_Proyectos();
        a.setBounds(0, 0, 1000 - opciones.getWidth(), 650);
        principal.removeAll();
        principal.add(a, BorderLayout.CENTER);
        principal.revalidate();
        principal.repaint();
    }//GEN-LAST:event_ProyectosMouseClicked

    private void ProyectosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProyectosMouseEntered
        setColor(Proyectos);
    }//GEN-LAST:event_ProyectosMouseEntered

    private void ProyectosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ProyectosMouseExited
        resetColor(Proyectos);
    }//GEN-LAST:event_ProyectosMouseExited

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed

        x = evt.getX();
        y = evt.getY();
    }//GEN-LAST:event_formMousePressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Cliente;
    private javax.swing.JPanel Proyectos;
    public static javax.swing.JPanel cabecera;
    public static javax.swing.JLabel check;
    private javax.swing.JPanel configuraciones;
    public static javax.swing.JLabel fail;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    public static javax.swing.JLabel lblTitulo;
    public static javax.swing.JPanel opciones;
    private javax.swing.JPanel panel_principal;
    public static javax.swing.JPanel principal;
    private javax.swing.JPanel trabajadores;
    // End of variables declaration//GEN-END:variables
}
