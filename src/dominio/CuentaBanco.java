/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominio;

/**
 *
 * @author MINERAMIRAFLORES
 */
public class CuentaBanco {

    private int id;
    private int id_cliente;
    private String descripcion;
    private double monto;
    private String fecha;
    private String metodo;
    private String estado;

    public CuentaBanco(int id, int id_cliente, String descripcion, double monto, String fecha, String metodo, String estado) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.descripcion = descripcion;
        this.monto = monto;
        this.fecha = fecha;
        this.metodo = metodo;
        this.estado = estado;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getMetodo() {
        return metodo;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "CuentaBanco{" + "id=" + id + ", id_cliente=" + id_cliente + ", descripcion=" + descripcion + ", monto=" + monto + ", fecha=" + fecha + ", metodo=" + metodo + ", estado=" + estado + '}';
    }

}
