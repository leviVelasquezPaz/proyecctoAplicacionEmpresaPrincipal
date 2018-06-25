/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Persona;
import dominio.Sueldo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import presentacion.frmPrincipal;

/**
 *
 * @author USUARIO
 */
public class SueldoDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    frmPrincipal a;

    public ArrayList listaCargos = new ArrayList();

    public void agregar(Sueldo p) {
        String texto = "insert into sueldo(id_sueldo,cargo_sueldo,descripcion_sueldo,sueldo_sueldo,estado_sueldo)values(?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, p.getId_sueldo());
            ps.setString(2, p.getCargo());
            ps.setString(3, p.getDescripcion());
            ps.setDouble(4, p.getSueldo());
            ps.setString(5, p.getEstado());
            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void eliminar(int id) {
        String texto = "delete from sueldo where id_sueldo=?";
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
        String texto = "select id_sueldo from sueldo";
        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                System.out.println("esta pasando por qui");
                ultimoCodigo = rs.getInt("id_sueldo");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("no se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

    public void modificar(Sueldo p) {
        String texto = "update sueldo set cargo_sueldo=?, descripcion_sueldo=?, sueldo_sueldo=?,estado_sueldo=? where id_sueldo=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, p.getCargo());
            ps.setString(2, p.getDescripcion());
            ps.setDouble(3, p.getSueldo());
            ps.setString(4, p.getEstado());
            ps.setInt(5, p.getId_sueldo());
            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto;

        texto = "select * from sueldo ";
        int ultimoCodigo = 0;
        modelo.addColumn("Id");
        modelo.addColumn("cargo");
        modelo.addColumn("descripcion");
        modelo.addColumn("sueldo");
        modelo.addColumn("estado");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("id_sueldo"));
                cabecera[1] = rs.getString("cargo_sueldo");
                cabecera[2] = rs.getString("descripcion_sueldo");
                cabecera[3] = rs.getString("sueldo_sueldo");
                cabecera[4] = rs.getString("estado_sueldo");
                modelo.addRow(cabecera);
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public void cargarCargos() {
        String texto = "select *from sueldo";
        String cargo = "";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cargo = rs.getString("cargo_sueldo");
                listaCargos.add(cargo);
                a.controladorErrores("Cargando datos", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("no se puede obtener el id nuevo", "fail");
        }

    }

    public DefaultTableModel buscar(String Cargo) {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "select * from sueldo where cargo_sueldo like '%" + Cargo + "%'";
        modelo.addColumn("Id");
        modelo.addColumn("cargo");
        modelo.addColumn("descripcion");
        modelo.addColumn("sueldo");
        modelo.addColumn("estado");
        String[] cabecera = new String[5];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("id_sueldo"));
                cabecera[1] = rs.getString("cargo_sueldo");
                cabecera[2] = rs.getString("descripcion_sueldo");
                cabecera[3] = rs.getString("sueldo_sueldo");
                cabecera[4] = rs.getString("estado_sueldo");
                modelo.addRow(cabecera);
            }

        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }
}
