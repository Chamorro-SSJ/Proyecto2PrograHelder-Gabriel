/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Objects;

public class Carrera {
    private int idCarrera;      // PK única
    private String nomCarrera;
    private String grado;       // Diplomado, Bachiller, Maestría

    public Carrera() {}

    public Carrera(int idCarrera, String nomCarrera, String grado) {
        this.idCarrera = idCarrera;
        this.nomCarrera = nomCarrera;
        this.grado = grado;
    }

    public int getIdCarrera() { return idCarrera; }
    public void setIdCarrera(int idCarrera) { this.idCarrera = idCarrera; }
    public String getNomCarrera() { return nomCarrera; }
    public void setNomCarrera(String nomCarrera) { this.nomCarrera = nomCarrera; }
    public String getGrado() { return grado; }
    public void setGrado(String grado) { this.grado = grado; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Carrera)) return false;
        Carrera carrera = (Carrera) o;
        return idCarrera == carrera.idCarrera;
    }

    @Override
    public int hashCode() { return Objects.hash(idCarrera); }

    @Override
    public String toString() {
        return idCarrera + " - " + nomCarrera + " (" + grado + ")";
    }
}

