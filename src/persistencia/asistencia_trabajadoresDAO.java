/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Asistencias_Trabajadores;
import dominio.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import presentacion.frmPrincipal;
import presentacion.trabajador.Panel_Agregar_Trabajador;
import presentacion.trabajador.panel_asistencias_trabajadores;
import static presentacion.trabajador.panel_asistencias_trabajadores.id_asitencias;

/**
 *
 * @author Levi
 */
public class asistencia_trabajadoresDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    Panel_Agregar_Trabajador agrega;
    frmPrincipal a;
    private ProyectoDAO proyecto = new ProyectoDAO();
    private Detalle_asistenciasDAO detalle_asistenciaDAO = new Detalle_asistenciasDAO();
    private ArrayList<Asistencias_Trabajadores> listaTrabajadores = new ArrayList<Asistencias_Trabajadores>();
    Asistencias_Trabajadores asistencias_traba;

    public void agregar(Asistencias_Trabajadores p) {
        String texto = "insert into asisetncia_trabajadore(id,nombre_reunion,fecha_inicio,fecha_fin) values(?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getNombre_reunion());
            ps.setString(3, p.getFecha_inicio());
            ps.setString(4, p.getFecha_fin());
            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void eliminar(int id, String titulo) {
        String texto = "delete from asisetncia_trabajadore where id=?";
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

    public void modificar(Asistencias_Trabajadores p) {
        String texto = "update asisetncia_trabajadore set nombre_reunion=?,fecha_inicio=?,fecha_fin=? where id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, p.getNombre_reunion());
            ps.setString(2, p.getFecha_inicio());
            ps.setString(3, p.getFecha_fin());
            ps.setInt(4, p.getId());
            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "select *from asisetncia_trabajadore ";
        modelo.addColumn("Id");
        modelo.addColumn("nombre reunion");
        modelo.addColumn("fecha inicio");
        modelo.addColumn("fecha fin");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("id"));
                cabecera[1] = rs.getString("nombre_reunion");
                cabecera[2] = rs.getString("fecha_inicio");
                cabecera[3] = rs.getString("fecha_fin");
                modelo.addRow(cabecera);
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public int obtenerCodigoAsistencia() {

        String texto = "select *from asisetncia_trabajadore";

        int ultimoCodigo = 0;

        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("id");
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return ultimoCodigo + 1;
    }

    public void insetarEnAsistencias() {
        proyecto.cargarTrabajadores();
        for (Persona lista : proyecto.listaTrabajadores) {
            insetarEnDetalleAsistencias(lista.getCodigo(), panel_asistencias_trabajadores.fecha_Seleccionada, panel_asistencias_trabajadores.id_asitencias, "Ninguno");
        }
    }

    public void insetarEnDetalleAsistencias(int id_trabajador, String fecha, int id_asistencias, String estado) {
        String texto = "insert into detalle_asistencias(id,id_asistencias,id_trabajador,hora_llegada,fecha,estado)values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, detalle_asistenciaDAO.obtnerCodigo());
            ps.setInt(2, id_asistencias);
            ps.setInt(3, id_trabajador);
            ps.setString(4, "");
            ps.setString(5, fecha);
            ps.setString(6, "Ninguno");
            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al intentar agregar ", "fail");
        }
    }

    public void obtenerIdTrabajadoresAsistente() {
        String texto = "select *from detalle_asistencias where id_asistencias='" + panel_asistencias_trabajadores.id_asitencias + "'";
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                int id = rs.getInt("id");
                int id_cliente = rs.getInt("id_trabajador");
                asistencias_traba = new Asistencias_Trabajadores(id, "", "", "");
                listaTrabajadores.add(asistencias_traba);
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }

    }

    public void eliminarDetalle_Asistencias() {
        obtenerIdTrabajadoresAsistente();
        for (Asistencias_Trabajadores lista : listaTrabajadores) {
            deleteDetellaAsistencia(lista.getId());
        }
    }

    public void deleteDetellaAsistencia(int id_asistencia) {
        String texto = "delete from detalle_asistencias where id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, id_asistencia);
            ps.executeUpdate();
            a.controladorErrores("se elimino correctamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al intentar agregar ", "fail");
        }
    }

}
