/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import logica.Beneficio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlmacenamientoBeneficios {
    private final List<Beneficio> lista = new ArrayList<>();

    public void insertar(Beneficio b) {
        if (existeId(b.getIdBeneficio()))
            throw new IllegalArgumentException("idBeneficio duplicado: " + b.getIdBeneficio());
        lista.add(b);
    }

    public boolean existeId(int idBeneficio) {
        return lista.stream().anyMatch(x -> x.getIdBeneficio() == idBeneficio);
    }

    public Optional<Beneficio> buscarPorId(int idBeneficio) {
        return lista.stream().filter(x -> x.getIdBeneficio() == idBeneficio).findFirst();
    }

    public List<Beneficio> filtrarPorNombre(String texto) {
        String t = texto == null ? "" : texto.toLowerCase();
        return lista.stream()
                .filter(x -> x.getNomBeneficio() != null && x.getNomBeneficio().toLowerCase().contains(t))
                .collect(Collectors.toList());
    }

    public void modificar(Beneficio b) {
        Beneficio found = buscarPorId(b.getIdBeneficio())
                .orElseThrow(() -> new IllegalArgumentException("Beneficio no existe: " + b.getIdBeneficio()));
        found.setNomBeneficio(b.getNomBeneficio());
        found.setDescripcion(b.getDescripcion());
        found.setMontoBeneficio(b.getMontoBeneficio());
    }

    public void eliminar(int idBeneficio) {
        lista.removeIf(x -> x.getIdBeneficio() == idBeneficio);
    }

    public List<Beneficio> listarTodos() { return new ArrayList<>(lista); }
}

