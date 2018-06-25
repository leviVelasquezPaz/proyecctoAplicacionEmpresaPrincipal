/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import dominio.Persona;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import presentacion.frmPrincipal;

/**
 *
 * @author Levi
 */
public class ClienteDAO {
    
    private Conexion con = new Conexion();
    private Connection cn = con.conexion();
    DefaultTableModel modelo;
    frmPrincipal a;
    public ArrayList<Persona> listaClientes = new ArrayList<Persona>();
    Persona persona;

    // para mostrar todos los datos 
    //importante no borrar
    public static int PASO = 1;
    
    public static int codigo;
    public static String nombre = "";
    public static String paterno = "";
    public static String materno = "";
    public static String sexo = "";
    public static String dni = "";
    public static String numeroTelefono = "";
    public static String direccion = "";
    public static String nacimiento = "";
    public static String cargo = "";
    public static String estado = "";
    
    public void cargarDatosClientes() {
        String texto = "select *from persona";
        
        String[] cabecera = new String[15];
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(texto);
            while (rs.next()) {
                int id = rs.getInt("id_persona");
                String nombre = rs.getString("nombre_persona");
                String paterno = rs.getString("paterno_persona");
                String materno = rs.getString("materno_persona");
                String sexo = rs.getString("sexo_persona");
                String dni = rs.getString("dni_persona");
                String celular = rs.getString("celular_persona");
                String direccion = rs.getString("direccion_persona");
                String nacimeinto = rs.getString("nacimiento__persona");
                String cargo = rs.getString("cargo_persona");
                String estado = rs.getString("estado_persona");
                if (rs.getString("cargo_persona").equals("Cliente")) {
                    persona = new Persona(id, nombre, paterno, materno, sexo, dni, celular, direccion, nacimeinto, cargo, estado);
                    listaClientes.add(persona);
                }
                
            }
        } catch (Exception e) {
            a.controladorErrores("ocurrio un error inesperado", "fail");
        }
    }

    //para mostrar los datos del cliente en la venta emergente
    // datos importantes no borrar
    public static void verDatos(presentacion.Cliente.Panel_VisualizarDatosCliente ver, String codigo) {
        int c = 0;
        Connection cn = Conexion.conexion();
        String SQL = "SELECT * FROM persona where id_persona=" + codigo;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getInt(1);
                ClienteDAO.codigo = rs.getInt(1);
                ClienteDAO.nombre = rs.getString(2);
                ClienteDAO.paterno = rs.getString(3);
                ClienteDAO.materno = rs.getString(4);
                ClienteDAO.sexo = rs.getString(5);
                ClienteDAO.nacimiento = rs.getString(6);
                ClienteDAO.direccion = rs.getString(7);
                ClienteDAO.numeroTelefono = rs.getString(8);
                ClienteDAO.dni = rs.getString(9);
                ClienteDAO.cargo = rs.getString(10);
                ClienteDAO.estado = rs.getString(11);                
            }
            ver.limpiarlabel();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR AL MOSTRAR LOS DATOS", "INFORMACION", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
