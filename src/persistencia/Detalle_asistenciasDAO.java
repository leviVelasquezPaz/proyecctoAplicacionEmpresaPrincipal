/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Detalle_Asistencias;
import dominio.Sub_Proyectos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import presentacion.Proyectos.panel_agregar_proyectos;
import presentacion.frmPrincipal;
import presentacion.trabajador.Panel_Agregar_Trabajador;
import presentacion.trabajador.panel_asistencias_trabajadores;

/**
 *
 * @author Levi
 */
public class Detalle_asistenciasDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    Panel_Agregar_Trabajador agrega;
    frmPrincipal a;

    public void agregar(Detalle_Asistencias p) {
        String texto = "insert into detalle_asistencias(id,id_asistencias,id_trabajador,hora_llegada,fecha,estado)values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getId_control_asistencias());
            ps.setInt(3, p.getId_trabajador());
            ps.setString(4, p.getHora_llegada());
            ps.setString(5, p.getFecha());
            ps.setString(6, p.getEstado());
            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void eliminar(int id) {
        String texto = "delete from detalle_asistencias where id=?";
        int ultimoCodigo = 0;
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, id);
            ps.executeUpdate();
            a.controladorErrores("se elimino correctamente", "fail");
        } catch (Exception e) {
            a.controladorErrores("Error al eliminar", "fail");
        }
    }

    public void modificar(Detalle_Asistencias p) {
        String texto = "update detalle_asistencias set id_asistencias=?,id_trabajador=?,hora_llegada=?,fecha=?,estado=? where id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, p.getId_control_asistencias());
            ps.setInt(2, p.getId_trabajador());
            ps.setString(3, p.getHora_llegada());
            ps.setString(4, p.getFecha());
            ps.setString(5, p.getEstado());
            ps.setInt(6, p.getId());
            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
    }

    public boolean verificarAsistencias(int id_trabajador) {
        String texto = "select *from detalle_asistencias where id_asistencias='" + panel_asistencias_trabajadores.id_asitencias + "'";
        boolean estado = false;
        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                if (rs.getInt("id_trabajador") == id_trabajador) {
                    a.controladorErrores("El trabajador ya esta registrado", "fail");
                    estado = true;
                }
                ultimoCodigo = rs.getInt("id");

            }
        } catch (Exception e) {
            a.controladorErrores("Ocurrio un error", "fail");
        }
        return estado;
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";
        texto = "select *from detalle_asistencias da inner join persona per on per.id_persona=da.id_trabajador where id_asistencias='" + panel_asistencias_trabajadores.id_asitencias + "'";
        int ultimoCodigo = 0;
        modelo.addColumn("id");
        modelo.addColumn("id_asstencias");
        modelo.addColumn("trabajador");
        modelo.addColumn("hora llegada");
        modelo.addColumn("fecha");
        modelo.addColumn("id_trabajador");
        modelo.addColumn("Estado");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("da.id"));
                cabecera[1] = String.valueOf(rs.getInt("da.id_asistencias"));
                cabecera[2] = rs.getString("per.nombre_persona");
                cabecera[3] = rs.getString("da.hora_llegada");
                cabecera[4] = rs.getString("da.fecha");
                cabecera[5] = rs.getString("da.id_trabajador");
                cabecera[6] = rs.getString("da.estado");
                modelo.addRow(cabecera);
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public int obtnerCodigo() {

        String texto = "select *from detalle_asistencias";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("id");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }
}
