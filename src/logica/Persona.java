/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Calendar;
import java.util.Objects;

public abstract class Persona {
    private String cedula;      // único
    private String nombre;
    private Calendar fechNac;
    private String direccion;
    private String telefono;
    private String email;

    protected Persona() {}

    protected Persona(String cedula, String nombre, Calendar fechNac,
                      String direccion, String telefono, String email) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechNac = fechNac;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }
     

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Calendar getFechNac() {
        return fechNac;
    }

    public void setFechNac(Calendar fechNac) {
        this.fechNac = fechNac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
   
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Persona)) return false;
        Persona persona = (Persona) o;
        return Objects.equals(cedula, persona.cedula);
    }

    @Override
    public int hashCode() { return Objects.hash(cedula); }

    @Override
    public String toString() {
        return nombre + " (" + cedula + ")";
    }
}
