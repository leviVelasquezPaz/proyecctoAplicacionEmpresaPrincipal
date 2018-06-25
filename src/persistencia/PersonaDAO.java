package persistencia;

import dominio.Persona;
import dominio.Sub_Proyectos;
import java.awt.BorderLayout;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import presentacion.frmPrincipal;
import static presentacion.frmPrincipal.opciones;
import static presentacion.frmPrincipal.principal;
import presentacion.otros.Notificacion;
import presentacion.panel;
import presentacion.trabajador.Panel_Agregar_Trabajador;

public class PersonaDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    Panel_Agregar_Trabajador agrega;
    frmPrincipal a;

    public void agregar(Persona p) {

        String texto = "insert into persona(id_persona,nombre_persona,paterno_persona,materno_persona,sexo_persona,nacimiento__persona,direccion_persona,celular_persona,dni_persona,cargo_persona,estado_persona)values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            System.out.println("pas");
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, p.getCodigo());
            ps.setString(2, p.getNombre());
            ps.setString(3, p.getPaterno());
            ps.setString(4, p.getMaterno());
            ps.setString(5, p.getSexo());
            ps.setString(6, p.getNacimiento());
            ps.setString(7, p.getDireccion());
            ps.setString(8, p.getNumeroTelefono());
            ps.setString(9, p.getDni());
            ps.setString(10, p.getCargo());
            ps.setString(11, p.getEstado());
            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public void eliminar(int id, String titulo) {
        String texto = "delete from persona where id_persona=?";
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

    public void modificar(Persona p) {
        String texto = "update persona set nombre_persona=?, paterno_persona=?, materno_persona=?,sexo_persona=?,dni_persona=?,celular_persona=?,direccion_persona=?,nacimiento__persona=?,cargo_persona=?,estado_persona=? where id_persona=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setString(1, p.getNombre());
            ps.setString(2, p.getPaterno());
            ps.setString(3, p.getMaterno());
            ps.setString(4, p.getSexo());
            ps.setString(5, p.getDni());
            ps.setString(6, p.getNumeroTelefono());
            ps.setString(7, p.getDireccion());
            ps.setString(8, p.getNacimiento());
            ps.setString(9, p.getCargo());
            ps.setString(10, p.getEstado());
            ps.setInt(11, p.getCodigo());
            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
    }

    public DefaultTableModel mostrarTrabajadores() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";

        texto = "select *from persona ";

        int ultimoCodigo = 0;
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
                if (!rs.getString("cargo_persona").equals("Cliente")) {
                    modelo.addRow(cabecera);
                }

            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public DefaultTableModel mostrarClientes() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";

        texto = "select *from persona where cargo_persona='Cliente'";

        int ultimoCodigo = 0;
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
                if (rs.getString("cargo_persona").equals("Cliente")) {
                    modelo.addRow(cabecera);
                }

            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public int obtnerCodigoPersona() {

        String texto = "select *from persona";

        int ultimoCodigo = 0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                ultimoCodigo = rs.getInt("id_persona");
                a.controladorErrores("id actualizado", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
        return ultimoCodigo + 1;
    }

    public DefaultTableModel mostrarTodosLosTrabajadores(String titulo, String cargo) {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto;
        if (cargo == "") {
            texto = "select *from persona";
        } else {
            texto = "select *from persona where cargo='" + cargo + "'";
        }

        modelo.addColumn("Trabajador");;
        modelo.addColumn("Sexo");
        modelo.addColumn("DNI");
        modelo.addColumn("Cargo");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("nombre") + " " + rs.getString("paterno") + " " + rs.getString("materno");
                cabecera[1] = rs.getString("sexo");
                cabecera[2] = rs.getString("dni");
                cabecera[3] = rs.getString("cargo");
                modelo.addRow(cabecera);
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "check");
        }

        return modelo;
    }

    public DefaultTableModel obtenerSoloClientes(String titulo) {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "select *from persona where cargo='Cliente' ";
        modelo.addColumn("nombre");;
        modelo.addColumn("dni");
        modelo.addColumn("DNI");
        modelo.addColumn("Cargo");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = rs.getString("nombre") + " " + rs.getString("paterno") + " " + rs.getString("materno");
                cabecera[1] = rs.getString("sexo");
                cabecera[2] = rs.getString("dni");
                cabecera[3] = rs.getString("cargo");
                modelo.addRow(cabecera);
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");

        }

        return modelo;
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
