/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author Levi
 */
public class Ingreso_Soles_Trabajadores {

    private int id;
    private int id_trabajador;
    private String estado;

    public Ingreso_Soles_Trabajadores(int id, int id_trabajador, String estado) {
        this.id = id;
        this.id_trabajador = id_trabajador;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Ingreso_Soles_Trabajadores{" + "id=" + id + ", id_trabajador=" + id_trabajador + ", estado=" + estado + '}';
    }

}
