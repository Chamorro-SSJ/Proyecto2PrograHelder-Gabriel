/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import logica.BeneficioEstudiante;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlmacenamientoBeneficiosEstudiantes {
    private final List<BeneficioEstudiante> lista = new ArrayList<>();

    public void asignar(String cedula, int idBeneficio,
                        AlmacenamientoEstudiantes almEst, AlmacenamientoBeneficios almBen) {
        if (!almEst.existeCedula(cedula))
            throw new IllegalArgumentException("Estudiante no existe (cédula): " + cedula);
        if (!almBen.existeId(idBeneficio))
            throw new IllegalArgumentException("Beneficio no existe: " + idBeneficio);

        BeneficioEstudiante be = new BeneficioEstudiante(cedula, idBeneficio);
        if (lista.contains(be))
            throw new IllegalArgumentException("Ya asignado ese beneficio a este estudiante.");
        lista.add(be);
    }

    public void quitar(String cedula, int idBeneficio) {
        lista.removeIf(x -> x.getCedula().equalsIgnoreCase(cedula) && x.getIdBeneficio() == idBeneficio);
    }

    public List<BeneficioEstudiante> listarPorEstudiante(String cedula) {
        return lista.stream().filter(x -> x.getCedula().equalsIgnoreCase(cedula))
                .collect(Collectors.toList());
    }

    public List<Integer> listarIdBeneficiosPorEstudiante(String cedula) {
        return listarPorEstudiante(cedula).stream().map(BeneficioEstudiante::getIdBeneficio)
                .collect(Collectors.toList());
    }

    public List<BeneficioEstudiante> listarTodos() { return new ArrayList<>(lista); }
}

