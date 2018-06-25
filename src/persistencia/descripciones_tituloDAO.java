/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Persona;
import dominio.descripcion_titulos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import presentacion.frmPrincipal;
import presentacion.trabajador.Panel_Agregar_Trabajador;

/**
 *
 * @author Levi
 */
public class descripciones_tituloDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    Panel_Agregar_Trabajador agrega;
    frmPrincipal a;

    public void agregar(descripcion_titulos p) {

        String texto = "insert into descripciones_titulos_proyectos(id,titulo)values(?,?)";
        try {
            System.out.println("pas");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getTitulo());
            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void eliminar(int id) {
        String texto = "delete from descripciones_titulos_proyectos where id=?";
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

    public void modificar(descripcion_titulos p) {
        String texto = "update descripciones_titulos_proyectos set  titulo=? where id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);

            ps.setString(1, p.getTitulo());
            ps.setInt(2, p.getId());

            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";

        texto = "select *from descripciones_titulos_proyectos";

        modelo.addColumn("Id");
        modelo.addColumn("titulo");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("id"));
                cabecera[1] = rs.getString("titulo");
                modelo.addRow(cabecera);
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public int  devolverUltimoCodigo() {
        int codigo = 0;

        String texto = "select *from descripciones_titulos_proyectos";

        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
               codigo=rs.getInt("id");  
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return codigo+1;
    }

}
