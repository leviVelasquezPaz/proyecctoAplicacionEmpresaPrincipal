/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author USUARIO
 */
public class Sub_Proyectos {

    private int id;
    private int id_cliente;
    private String titulo;
    private String descripcion;
    private String fecha;

    public Sub_Proyectos(int id, int id_cliente, String titulo, String descripcion, String fecha) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Sub_Proyectos{" + "id=" + id + ", id_cliente=" + id_cliente + ", titulo=" + titulo + ", descripcion=" + descripcion + ", fecha=" + fecha + '}';
    }

    

}
