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
public class Proyecto {

    private int id_proyecto;
    private int id_cliente;
    private int id_trabajador;
    private String nombre;
    private String rubro;
    private String descripcion;
    private String fechaIncio;
    private String fechFin;
    private String estado;

    public Proyecto(int id_proyecto, int id_cliente, int id_trabajador, String nombre, String rubro, String descripcion, String fechaIncio, String fechFin, String estado) {
        this.id_proyecto = id_proyecto;
        this.id_cliente = id_cliente;
        this.id_trabajador = id_trabajador;
        this.nombre = nombre;
        this.rubro = rubro;
        this.descripcion = descripcion;
        this.fechaIncio = fechaIncio;
        this.fechFin = fechFin;
        this.estado = estado;
    }

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaIncio() {
        return fechaIncio;
    }

    public void setFechaIncio(String fechaIncio) {
        this.fechaIncio = fechaIncio;
    }

    public String getFechFin() {
        return fechFin;
    }

    public void setFechFin(String fechFin) {
        this.fechFin = fechFin;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proyecto{" + "id_proyecto=" + id_proyecto + ", id_cliente=" + id_cliente + ", id_trabajador=" + id_trabajador + ", nombre=" + nombre + ", rubro=" + rubro + ", descripcion=" + descripcion + ", fechaIncio=" + fechaIncio + ", fechFin=" + fechFin + ", estado=" + estado + '}';
    }
    

   

    
}
