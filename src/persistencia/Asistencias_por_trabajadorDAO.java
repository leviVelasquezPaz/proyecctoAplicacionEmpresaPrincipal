/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import presentacion.frmPrincipal;
import presentacion.trabajador.Panel_Agregar_Trabajador;

/**
 *
 * @author Levi
 */
public class Asistencias_por_trabajadorDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    Panel_Agregar_Trabajador agrega;
    frmPrincipal a;
    public static int total_asistencias;

    public DefaultTableModel mostrar(int id) {
        DefaultTableModel modelo = new DefaultTableModel();

        String texto = "select *from detalle_asistencias where id_trabajador='" + id + "' ";
        modelo.addColumn("Id");
        modelo.addColumn("hora llegada");
        modelo.addColumn("fecha ");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("id"));
                cabecera[1] = rs.getString("hora_llegada");
                cabecera[2] = rs.getString("fecha");
                modelo.addRow(cabecera);
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public void contador(int id) {
        DefaultTableModel modelo = new DefaultTableModel();

        String texto = "select count(*)from detalle_asistencias where id_trabajador='" + id + "' ";
        modelo.addColumn("Id");
        modelo.addColumn("hora llegada");
        modelo.addColumn("fecha ");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                total_asistencias = rs.getInt("sum(*)");
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }

    }

}
