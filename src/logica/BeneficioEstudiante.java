/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Objects;

// Tabla intermedia: un estudiante puede tener varios beneficios
public class BeneficioEstudiante {
    private String cedula;      // FK a Estudiante (por cedula)
    private int idBeneficio;    // FK a Beneficio

    public BeneficioEstudiante() {}

    public BeneficioEstudiante(String cedula, int idBeneficio) {
        this.cedula = cedula;
        this.idBeneficio = idBeneficio;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public int getIdBeneficio() {
        return idBeneficio;
    }

    public void setIdBeneficio(int idBeneficio) {
        this.idBeneficio = idBeneficio;
    }

 

    // Evitar duplicar la misma asignación (cedula + beneficio)
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BeneficioEstudiante)) return false;
        BeneficioEstudiante that = (BeneficioEstudiante) o;
        return idBeneficio == that.idBeneficio &&
               Objects.equals(cedula, that.cedula);
    }

    @Override
    public int hashCode() { return Objects.hash(cedula, idBeneficio); }

    @Override
    public String toString() {
        return "Est: " + cedula + " -> Benef: " + idBeneficio;
    }
}

