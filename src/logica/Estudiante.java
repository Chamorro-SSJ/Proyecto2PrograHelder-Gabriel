/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Calendar;
import java.util.Objects;

public class Estudiante extends Persona {
    private String carnet;          // PK única
    private Calendar fechIngreso;
    private Calendar fechEgreso;
    private int idCarrera;          // FK a Carrera

    public Estudiante() {}

    public Estudiante(String cedula, String nombre, Calendar fechNac,
                      String direccion, String telefono, String email,
                      String carnet, Calendar fechIngreso, Calendar fechEgreso,
                      int idCarrera) {
        super(cedula, nombre, fechNac, direccion, telefono, email);
        this.carnet = carnet;
        this.fechIngreso = fechIngreso;
        this.fechEgreso = fechEgreso;
        this.idCarrera = idCarrera;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public Calendar getFechIngreso() {
        return fechIngreso;
    }

    public void setFechIngreso(Calendar fechIngreso) {
        this.fechIngreso = fechIngreso;
    }

    public Calendar getFechEgreso() {
        return fechEgreso;
    }

    public void setFechEgreso(Calendar fechEgreso) {
        this.fechEgreso = fechEgreso;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

  

    // Igualdad por carnet (PK). Cedula también es única, pero la PK pedida es carnet.
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(carnet, that.carnet);
    }

    @Override
    public int hashCode() { return Objects.hash(carnet); }

    @Override
    public String toString() {
        return getNombre() + " - Carnet: " + carnet;
    }
}

