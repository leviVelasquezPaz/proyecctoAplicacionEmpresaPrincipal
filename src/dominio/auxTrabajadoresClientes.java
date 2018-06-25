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
public class auxTrabajadoresClientes {
    private String dni;
    private int id;

    public auxTrabajadoresClientes(String dni, int id) {
        this.dni = dni;
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "auxTrabajadoresClientes{" + "dni=" + dni + ", id=" + id + '}';
    }
    
    
}
