package logica;

import java.time.LocalDate;
import java.util.Objects;
import java.time.ZoneId;
import java.util.Date;
public class Estudiante extends Persona {
    private String carnet;
    private LocalDate fechIngreso;
    private LocalDate fechEgreso;
    private int idCarrera;


    public Estudiante() {}

   
    public Estudiante(String cedula, String nombre, LocalDate fechNac,
                      String direccion, String telefono, String email,
                      String carnet, LocalDate fechIngreso, LocalDate fechEgreso,
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

    public LocalDate getFechIngreso() {
    return fechIngreso;
}


    public void setFechaIngreso(LocalDate fechIngreso) {
        this.fechIngreso = fechIngreso;
    }

    public LocalDate getFechEgreso() {
        return fechEgreso;
    }

    public void setFechaEgreso(LocalDate fechEgreso) {
        this.fechEgreso = fechEgreso;
    }

    public int getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(int idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudiante)) return false;
        Estudiante that = (Estudiante) o;
        return Objects.equals(carnet, that.carnet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carnet);
    }

    @Override
    public String toString() {
        return getNombre() + " - Carnet: " + carnet;
    }
}
