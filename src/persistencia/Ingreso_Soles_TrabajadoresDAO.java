/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Ingreso_Soles_Trabajadores;
import dominio.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import presentacion.frmPrincipal;

/**
 *
 * @author Levi
 */
public class Ingreso_Soles_TrabajadoresDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    frmPrincipal a;

    public static ArrayList<Persona> listaTrabajadores = new ArrayList<Persona>();

    public void agregar(Ingreso_Soles_Trabajadores p) {
        String texto = "insert into ingreso_soles_trabajadores(id,id_trabajador,estado)values(?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getId_trabajador());
            ps.setString(3, p.getEstado());
            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void eliminar(int id) {
        String texto = "delete from ingreso_soles_trabajadores where id=?";
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

    public int obtnerCodigoSueldo() {
        String texto = "select *from ingreso_soles_trabajadores";
        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("id");
            }
        } catch (Exception e) {
            a.controladorErrores("no se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

    public void modificar(Ingreso_Soles_Trabajadores p) {
        String texto = "update ingreso_soles_trabajadores set id_trabajador=?, estado=? where id=?";
        try{
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, p.getId_trabajador());
            ps.setString(2, p.getEstado());
            ps.setInt(3, p.getId());
            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto;
        texto = "select *from ingreso_soles_trabajadores ist inner join persona  p on p.id_persona=ist.id_trabajador  where ist.estado='Activo'";
        int ultimoCodigo = 0;
        modelo.addColumn("Id");
        modelo.addColumn("Trabajador");
        modelo.addColumn("Estado");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("ist.id"));
                String nombre = rs.getString("p.nombre_persona");
                String paterno = rs.getString("p.paterno_persona");
                String materno = rs.getString("p.materno_persona");
                cabecera[1] = nombre + " " + paterno + " " + materno;
                cabecera[2] = rs.getString("ist.estado");
                modelo.addRow(cabecera);
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public void cargarListaTrabajador() {
        Persona persona;

        String texto = "select * from persona where cargo_persona!='Cliente' ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                int codigo = rs.getInt("id_persona");
                String aux_nombre = rs.getString("nombre_persona");
                String paterno = rs.getString("paterno_persona");
                String materno = rs.getString("materno_persona");
                String nombre = aux_nombre + " " + paterno + " " + materno;
                persona = new Persona(codigo, nombre, "", "", "", "", "", "", "", "", "");
                listaTrabajadores.add(persona);
            }
        } catch (Exception e) {
            a.controladorErrores("no se puede obtener para trabajadores", "fail");
        }
    }

    public int devolverIdTrabajador(String nombre) {
        int codigo = -1;
        for (Persona lista : listaTrabajadores) {
            if (lista.getNombre().equals(nombre)) {
                codigo = lista.getCodigo();
            }
        }
        return codigo;
    }
}
