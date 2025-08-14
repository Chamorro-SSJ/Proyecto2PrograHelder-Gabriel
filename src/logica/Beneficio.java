/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Objects;

public class Beneficio {
    private int idBeneficio;        // PK única
    private String nomBeneficio;
    private String descripcion;
    private double montoBeneficio;

    public Beneficio() {}

    public Beneficio(int idBeneficio, String nomBeneficio, String descripcion, double montoBeneficio) {
        this.idBeneficio = idBeneficio;
        this.nomBeneficio = nomBeneficio;
        this.descripcion = descripcion;
        this.montoBeneficio = montoBeneficio;
    }

    public int getIdBeneficio() {
        return idBeneficio;
    }

    public void setIdBeneficio(int idBeneficio) {
        this.idBeneficio = idBeneficio;
    }

    public String getNomBeneficio() {
        return nomBeneficio;
    }

    public void setNomBeneficio(String nomBeneficio) {
        this.nomBeneficio = nomBeneficio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMontoBeneficio() {
        return montoBeneficio;
    }

    public void setMontoBeneficio(double montoBeneficio) {
        this.montoBeneficio = montoBeneficio;
    }
    


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beneficio)) return false;
        Beneficio that = (Beneficio) o;
        return idBeneficio == that.idBeneficio;
    }

    @Override
    public int hashCode() { return Objects.hash(idBeneficio); }

    @Override
    public String toString() {
        return idBeneficio + " - " + nomBeneficio + " ₡" + montoBeneficio;
    }
}
