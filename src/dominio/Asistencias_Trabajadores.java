/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

import java.util.Date;

/**
 *
 * @author Levi
 */
public class Asistencias_Trabajadores {

    private int id;
    private String nombre_reunion;
    private String fecha_inicio;
    private String fecha_fin;

    public Asistencias_Trabajadores(int id, String nombre_reunion, String fecha_inicio, String fecha_fin) {
        this.id = id;
        this.nombre_reunion = nombre_reunion;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_reunion() {
        return nombre_reunion;
    }

    public void setNombre_reunion(String nombre_reunion) {
        this.nombre_reunion = nombre_reunion;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    @Override
    public String toString() {
        return "Asistencias_Trabajadores{" + "id=" + id + ", nombre_reunion=" + nombre_reunion + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + '}';
    }

    

    
    

    
}
