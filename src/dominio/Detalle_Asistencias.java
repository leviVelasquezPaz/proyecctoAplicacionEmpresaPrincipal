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
public class Detalle_Asistencias {

    private int id;
    private int id_control_asistencias;
    private int id_trabajador;
    private String hora_llegada;
    private String fecha;
    private String estado;

    public Detalle_Asistencias(int id, int id_control_asistencias, int id_trabajador, String hora_llegada, String fecha, String estado) {
        this.id = id;
        this.id_control_asistencias = id_control_asistencias;
        this.id_trabajador = id_trabajador;
        this.hora_llegada = hora_llegada;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_control_asistencias() {
        return id_control_asistencias;
    }

    public void setId_control_asistencias(int id_control_asistencias) {
        this.id_control_asistencias = id_control_asistencias;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getHora_llegada() {
        return hora_llegada;
    }

    public void setHora_llegada(String hora_llegada) {
        this.hora_llegada = hora_llegada;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Detalle_Asistencias{" + "id=" + id + ", id_control_asistencias=" + id_control_asistencias + ", id_trabajador=" + id_trabajador + ", hora_llegada=" + hora_llegada + ", fecha=" + fecha + ", estado=" + estado + '}';
    }

}
