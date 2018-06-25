/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.CuentaBanco;
import dominio.Persona;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import presentacion.frmPrincipal;

/**
 *
 * @author MINERAMIRAFLORES
 */
public class Cuenta_BancariaDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frmPrincipal a;
    public static double suma_total_monto;
    public static ArrayList<Persona> listaTrabajadores = new ArrayList<Persona>();

    public void agregar(CuentaBanco c) {

        String texto = "insert into cuenta_bancaria(id,id_trabajador,descripcion,monto,fecha,metodo,estado) values(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, c.getId());
            ps.setInt(2, c.getId_cliente());
            ps.setString(3, c.getDescripcion());
            ps.setDouble(4, c.getMonto());
            ps.setString(5, c.getFecha());
            ps.setString(6, c.getMetodo());
            ps.setString(7, c.getEstado());
            ps.executeUpdate();
            a.controladorErrores("Se agrego correctamente", "check");
        } catch (Exception e) {
            a.controladorErrores("error inesperado al agregar", "fail");
        }

    }

    public void eliminar(int id, String titulo) {
        String texto = "delete from cuenta_bancaria where id=?";
        int ultimoCodigo = 0;
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, id);
            ps.executeUpdate();
            a.controladorErrores("Se elimino correctamente", "check");

        } catch (Exception e) {
            a.controladorErrores("error inesperado al eliminar", "fail");

        }
    }

    public void modificar(CuentaBanco c, String titulo) {
        String texto = "update cuenta_bancaria set id_trabajador=?,descripcion=?,monto=?,fecha=?,metodo=?,estado=? where id=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, c.getId_cliente());
            ps.setString(2, c.getDescripcion());
            ps.setDouble(3, c.getMonto());
            ps.setString(4, c.getFecha());
            ps.setString(5, c.getMetodo());
            ps.setString(6, c.getEstado());
            ps.setInt(7, c.getId());
            ps.executeUpdate();
            a.controladorErrores("Se modificó correctamente", "check");

        } catch (Exception e) {
            a.controladorErrores("error inesperado al modificar", "fail");
        }

    }

    public DefaultTableModel mostrarTrabajadores(int id) {
        modelo = new DefaultTableModel();
        String texto = "select *from cuenta_bancaria cb inner join persona per  on cb.id_trabajador=per.id_persona";
        int ultimoCodigo = 0;
        modelo.addColumn("id");
        modelo.addColumn("dni");
        modelo.addColumn("Descripción");
        modelo.addColumn("monto");
        modelo.addColumn("Fecha");
        modelo.addColumn("método");
        modelo.addColumn("estado");

        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                if (rs.getInt("cb.id_trabajador") == id) {
                    cabecera[0] = String.valueOf(rs.getInt("cb.id"));
                    cabecera[1] = rs.getString("per.nombre_persona") + " " + rs.getString("per.paterno_persona") + " " + rs.getString("per.materno_persona");
                    cabecera[2] = rs.getString("cb.descripcion");
                    cabecera[3] = rs.getString("cb.monto");
                    cabecera[4] = rs.getString("cb.fecha");
                    cabecera[5] = rs.getString("cb.metodo");
                    cabecera[6] = rs.getString("cb.estado");
                    modelo.addRow(cabecera);
                }

            }
        } catch (Exception e) {
            a.controladorErrores("error inesperado al mostrar", "fail");

        }
        return modelo;
    }

    public DefaultTableModel buscar(String titulo, String buscar, String entrada) {
        modelo = new DefaultTableModel();
        String texto = "select *from cuenta_bancaria cb inner join persona per  on cb.id_trabajador=per.id_persona where dni='" + buscar + "' and metodo='" + entrada + "'";
        modelo.addColumn("id");
        modelo.addColumn("trabajador");
        modelo.addColumn("Descripción");
        modelo.addColumn("monto");
        modelo.addColumn("Fecha");
        modelo.addColumn("método");
        modelo.addColumn("estado");

        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("cb.id"));
                cabecera[1] = rs.getString("per.nombre_persona") + " " + rs.getString("per.paterno_persona") + " " + rs.getString("per.materno_persona");
                cabecera[2] = rs.getString("cb.descripcion");
                cabecera[3] = rs.getString("cb.monto");
                cabecera[4] = rs.getString("cb.fecha");
                cabecera[5] = rs.getString("cb.metodo");
                cabecera[6] = rs.getString("cb.estado");
                modelo.addRow(cabecera);
            }
        } catch (Exception e) {
            a.controladorErrores("error inesperado al mostrar", "fail");
        }
        return modelo;
    }

    public int obtnerCodigoPersona() {
        String texto = "select max(id) from cuenta_bancaria";
        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("max(id)");
            }
        } catch (Exception e) {
            a.controladorErrores("error inesperado al agregar", "fail");
        }
        return ultimoCodigo + 1;
    }

    public double sumarMontoTotal(int id) {
        String texto = "select sum(monto) as suma from cuenta_bancaria where id_trabajador='" + id + "'";
        double monto = 0.0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                monto = rs.getDouble("suma");
            }
        } catch (Exception e) {
            a.controladorErrores("error inesperado al agregar", "fail");
        }
        return monto;
    }

    public void cargarListaTrabajadores() {
        String texto = "select *from persona";
        int ultimoCodigo = 0;
        Persona persona;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {

                if (!rs.getString("cargo_persona").equals("Cliente")) {
                    ultimoCodigo = rs.getInt("id_persona");
                    String nombre = rs.getString("nombre_persona") + " " + rs.getString("paterno_persona") + " " + rs.getString("materno_persona");
                    persona = new Persona(ultimoCodigo, nombre, "", "", "", "", "", "", "", "", "");
                    listaTrabajadores.add(persona);
                }

            }
        } catch (Exception e) {
            a.controladorErrores("error inesperado al agregar", "fail");
        }
    }

    public int devolverIDTrabajador(String nombre) {
        int id = -1;
        for (Persona lista : listaTrabajadores) {
            if (lista.getNombre().equals(nombre)) {
                id = lista.getCodigo();
            }
        }
        return id;
    }

    public String devolverNombreTrabajador(int id) {
        String nombre = "";
        for (Persona lista : listaTrabajadores) {
            if (lista.getCodigo() == id) {
                nombre = lista.getNombre();
            }
        }
        return nombre;
    }
}
