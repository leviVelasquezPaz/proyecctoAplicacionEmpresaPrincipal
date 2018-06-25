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
public class Sueldo {
    private int id_sueldo;
    private String cargo;
    private String descripcion;
    private double sueldo;
    private String estado;

    public Sueldo(int id_sueldo, String cargo, String descripcion, double sueldo, String estado) {
        this.id_sueldo = id_sueldo;
        this.cargo = cargo;
        this.descripcion = descripcion;
        this.sueldo = sueldo;
        this.estado = estado;
    }

    public int getId_sueldo() {
        return id_sueldo;
    }

    public void setId_sueldo(int id_sueldo) {
        this.id_sueldo = id_sueldo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Sueldo{" + "id_sueldo=" + id_sueldo + ", cargo=" + cargo + ", descripcion=" + descripcion + ", sueldo=" + sueldo + ", estado=" + estado + '}';
    }
    
    
}
