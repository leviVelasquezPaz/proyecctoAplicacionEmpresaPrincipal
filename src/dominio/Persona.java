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
public class Persona {

    private int codigo;
    private String nombre;
    private String paterno;
    private String materno;
    private String sexo;
    private String dni;
    private String numeroTelefono;
    private String direccion;
    private String nacimiento;
    private String cargo;
    private String estado;

    public Persona(int codigo, String nombre, String paterno, String materno, String sexo, String dni, String numeroTelefono, String direccion, String nacimiento, String cargo, String estado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.paterno = paterno;
        this.materno = materno;
        this.sexo = sexo;
        this.dni = dni;
        this.numeroTelefono = numeroTelefono;
        this.direccion = direccion;
        this.nacimiento = nacimiento;
        this.cargo = cargo;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Persona{" + "codigo=" + codigo + ", nombre=" + nombre + ", paterno=" + paterno + ", materno=" + materno + ", sexo=" + sexo + ", dni=" + dni + ", numeroTelefono=" + numeroTelefono + ", direccion=" + direccion + ", nacimiento=" + nacimiento + ", cargo=" + cargo + ", estado=" + estado + '}';
    }

}
