/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Persona;
import dominio.Sub_Proyectos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import presentacion.Proyectos.panel_agregar_proyectos;
import static presentacion.Proyectos.panel_agregar_proyectos.aux_id_cliente;
import presentacion.frmPrincipal;
import presentacion.trabajador.Panel_Agregar_Trabajador;

public class Sub_ProyectoDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    Panel_Agregar_Trabajador agrega;
    frmPrincipal a;

    public void agregar(Sub_Proyectos p) {
        String texto = "insert into sub_proyecto(id_proyecto,id_cliente,titulo_proyecto,descripcion_proyecto,fecha)values(?,?,?,?,?)";
        try {
            System.out.println("pas");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, p.getId());
            ps.setInt(2, p.getId_cliente());
            ps.setString(3, p.getTitulo());
            ps.setString(4, p.getDescripcion());
            ps.setString(5, p.getFecha());
            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void eliminar(int id) {
        String texto = "delete from sub_proyecto where id_proyecto=?";
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

    public void modificar(Sub_Proyectos p) {
        String texto = "update sub_proyecto set id_cliente=?,titulo_proyecto=?,descripcion_proyecto=?,fecha=? where id_proyecto=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, p.getId_cliente());
            ps.setString(2, p.getTitulo());
            ps.setString(3, p.getDescripcion());
            ps.setString(4, p.getFecha());
            ps.setInt(5, p.getId());
            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";
        texto = "select *from sub_proyecto where id_cliente='" + panel_agregar_proyectos.aux_id_cliente + "'";

        int ultimoCodigo = 0;
        modelo.addColumn("Id_proyecto");
        modelo.addColumn("id_cliente");
        modelo.addColumn("titulo");
        modelo.addColumn("fecha");
        modelo.addColumn("descripcion");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("id_proyecto"));
                cabecera[1] = String.valueOf(rs.getInt("id_cliente"));
                cabecera[2] = rs.getString("titulo_proyecto");
                cabecera[3] = rs.getString("fecha");
                cabecera[4] = rs.getString("descripcion_proyecto");
                modelo.addRow(cabecera);
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public int obtnerCodigo() {

        String texto = "select *from sub_proyecto";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("id_proyecto");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

    public DefaultTableModel buscar(String cargo, String persona) {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "select *from persona where nombre_persona like'%" + persona + "%' or dni_persona like'%" + persona + "%' or paterno_persona like'%" + persona + "%' or materno_persona like'%" + persona + "%' and cargo_persona='" + cargo + "' ";
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Paterno");
        modelo.addColumn("Materno");
        modelo.addColumn("Sexo");
        modelo.addColumn("DNI");
        modelo.addColumn("Celular");
        modelo.addColumn("Direción");
        modelo.addColumn("Fecha Nacimiento");
        modelo.addColumn("Cargo");
        modelo.addColumn("estado");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("id_persona"));
                cabecera[1] = rs.getString("nombre_persona");
                cabecera[2] = rs.getString("paterno_persona");
                cabecera[3] = rs.getString("materno_persona");
                cabecera[4] = rs.getString("sexo_persona");
                cabecera[5] = rs.getString("dni_persona");
                cabecera[6] = rs.getString("celular_persona");
                cabecera[7] = rs.getString("direccion_persona");
                cabecera[8] = rs.getString("nacimiento__persona");
                cabecera[9] = rs.getString("cargo_persona");
                cabecera[10] = rs.getString("estado_persona");
                if (cargo.equals("Cliente")) {
                    modelo.addRow(cabecera);
                }
                if (cargo.equals("Trabajadores")) {
                    modelo.addRow(cabecera);
                }
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }
}
