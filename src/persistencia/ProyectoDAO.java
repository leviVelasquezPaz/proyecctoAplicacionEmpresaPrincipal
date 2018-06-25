package persistencia;

import dominio.Persona;
import dominio.Proyecto;
import dominio.auxTrabajadoresClientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import presentacion.frmPrincipal;
import presentacion.trabajador.Panel_Agregar_Trabajador;

/**
 *
 * @author USUARIO
 */
public class ProyectoDAO {

    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    Panel_Agregar_Trabajador agrega;
    frmPrincipal a;
    auxTrabajadoresClientes auxCliente;
    auxTrabajadoresClientes auxTrabajador;
    Persona persona;
    public ArrayList<Persona> listaTrabajadores = new ArrayList<Persona>();
    public ArrayList<Persona> listaClientes = new ArrayList<Persona>();

    public void agregar(Proyecto p) {

        String texto = "insert into proyecto(id_proyecto,id_cliente,id_trabajador,nombre_proyecto,rubro_proyecto,descripcion_proyecto,fecha_Incio_proyecto,fecha_Fin_proyecto,estado_proyecto)values(?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, p.getId_proyecto());
            ps.setInt(2, p.getId_cliente());
            ps.setInt(3, p.getId_trabajador());
            ps.setString(4, p.getNombre());
            ps.setString(5, p.getRubro());
            ps.setString(6, p.getDescripcion());
            ps.setString(7, p.getFechaIncio());
            ps.setString(8, p.getFechFin());
            ps.setString(9, p.getEstado());
            ps.executeUpdate();
            a.controladorErrores("se agrego corectamente", "check");
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error al agrega", "fail");
        }
    }

    public String devolverDNICliente(int id) {
        String dni = "";
        for (Persona lista : listaClientes) {
            if (lista.getCodigo() == id) {
                dni = lista.getNombre();
            }
        }
        return dni;
    }

    public String devolverDNITrabajador(int id) {
        String dni = "";
        for (Persona lista : listaTrabajadores) {
            if (lista.getCodigo() == id) {
                dni = lista.getNombre();
            }
        }
        return dni;
    }

    public int devolverIdCliente(String nombre) {
        int id = -1;
        for (Persona lista : listaClientes) {
            if (lista.getNombre().equals(nombre)) {
                id = lista.getCodigo();
            }
        }
        return id;
    }

    public int devolverIdTrabajadores(String nombre) {
        int id = -1;
        for (Persona lista : listaTrabajadores) {
            if (lista.getNombre().equals(nombre)) {
                id = lista.getCodigo();
            }
        }
        return id;
    }

    public void eliminar(int id) {
        String texto = "delete from proyecto where id_proyecto=?";
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

    public void modificar(Proyecto p) {
        String texto = "update proyecto set id_cliente=?,id_trabajador=?,nombre_proyecto=?,rubro_proyecto=?,descripcion_proyecto=?,fecha_Incio_proyecto=?,fecha_Fin_proyecto=?,estado_proyecto=? where id_proyecto=?";
        try {
            PreparedStatement ps = cn.prepareStatement(texto);
            ps.setInt(1, p.getId_cliente());
            ps.setInt(2, p.getId_trabajador());
            ps.setString(3, p.getNombre());
            ps.setString(4, p.getRubro());
            ps.setString(5, p.getDescripcion());
            ps.setString(6, p.getFechaIncio());
            ps.setString(7, p.getFechFin());
            ps.setString(8, p.getEstado());
            ps.setInt(9, p.getId_proyecto());
            ps.executeUpdate();
            a.controladorErrores("se modifico corectamente", "check");

        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
    }

    public DefaultTableModel mostrar() {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";
        texto = "select *from proyecto  pro inner  join persona  per on pro.id_cliente=per.id_persona";

        int ultimoCodigo = 0;
        modelo.addColumn("Id proyecto");
        modelo.addColumn("Cliente");
        modelo.addColumn("id_trabajador");
        modelo.addColumn("proyecto");
        modelo.addColumn("rubro");
        modelo.addColumn("descripcion");
        modelo.addColumn("fecha incio");
        modelo.addColumn("fecha fin ");
        modelo.addColumn("estado");
        modelo.addColumn("id_cliente");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("pro.id_proyecto"));
                cabecera[1] = rs.getString("per.nombre_persona");
                cabecera[2] = rs.getString("pro.id_trabajador");
                cabecera[3] = rs.getString("pro.nombre_proyecto");
                cabecera[4] = rs.getString("pro.rubro_proyecto");
                cabecera[5] = rs.getString("pro.descripcion_proyecto");
                cabecera[6] = rs.getString("pro.fecha_Incio_proyecto");
                cabecera[7] = rs.getString("pro.fecha_Fin_proyecto");
                cabecera[8] = rs.getString("pro.estado_proyecto");
                cabecera[9] = String.valueOf(rs.getInt("pro.id_cliente"));
                modelo.addRow(cabecera);
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public DefaultTableModel buscar(String buscar) {
        DefaultTableModel modelo = new DefaultTableModel();
        String texto = "";
        texto = "select *from proyecto  pro inner  join persona  per on pro.id_cliente=per.id_persona where per.cargo_persona='Cliente' and per.nombre_persona like'%" + buscar + "%'";

        modelo.addColumn("Id proyecto");
        modelo.addColumn("clinete");
        modelo.addColumn("id_trabajador");
        modelo.addColumn("proyecto");
        modelo.addColumn("rubro");
        modelo.addColumn("descripcion");
        modelo.addColumn("fecha incio");
        modelo.addColumn("fecha fin ");
        modelo.addColumn("estado");
        modelo.addColumn("id_cliente");
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                cabecera[0] = String.valueOf(rs.getInt("id_proyecto"));
                cabecera[1] = rs.getString("per.nombre_persona");
                cabecera[2] = rs.getString("id_trabajador");
                cabecera[3] = rs.getString("nombre_proyecto");
                cabecera[4] = rs.getString("rubro_proyecto");
                cabecera[5] = rs.getString("descripcion_proyecto");
                cabecera[6] = rs.getString("fecha_Incio_proyecto");
                cabecera[7] = rs.getString("fecha_Fin_proyecto");
                cabecera[8] = rs.getString("estado_proyecto");
                cabecera[9] = String.valueOf(rs.getInt("pro.id_cliente"));

                modelo.addRow(cabecera);

            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
        return modelo;
    }

    public int obtnerCodigoProyecto() {

        String texto = "select *from proyecto";

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

    public void cargarClientes() {
        String texto = "select *from persona";
        int id;
        String dni;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                id = rs.getInt("id_persona");
                String nombre = rs.getString("nombre_persona");
                String paterno = rs.getString("paterno_persona");
                String materno = rs.getString("materno_persona");
                persona = new Persona(id, nombre + " " + paterno + " " + materno, paterno, materno, "", "", "", "", "", "", "");
                if (rs.getString("cargo_persona").equals("Cliente")) {
                    listaClientes.add(persona);
                }

                a.controladorErrores("Cargando datos", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
    }

    public void cargarTrabajadores() {
        String texto = "select *from persona";
        int id;
        String dni;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                id = rs.getInt("id_persona");
                String nombre = rs.getString("nombre_persona");
                String paterno = rs.getString("paterno_persona");
                String materno = rs.getString("materno_persona");
                persona = new Persona(id, nombre + " " + paterno + " " + materno, paterno, materno, "", "", "", "", "", "", "");
                if (!rs.getString("cargo_persona").equals("Cliente")) {
                    listaTrabajadores.add(persona);
                }
                a.controladorErrores("Cargando datos", "check");
            }
        } catch (Exception e) {
            a.controladorErrores("se se puede obtener el id nuevo", "fail");
        }
    }

    public DefaultTableModel buscarr(String cargo, String persona) {
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
