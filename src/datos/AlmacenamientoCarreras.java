/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import logica.Carrera;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlmacenamientoCarreras {
    private final List<Carrera> lista = new ArrayList<>();

    public void insertar(Carrera c) {
        if (existeId(c.getIdCarrera()))
            throw new IllegalArgumentException("idCarrera duplicado: " + c.getIdCarrera());
        lista.add(c);
    }

    public boolean existeId(int idCarrera) {
        return lista.stream().anyMatch(x -> x.getIdCarrera() == idCarrera);
    }

    public Optional<Carrera> buscarPorId(int idCarrera) {
        return lista.stream().filter(x -> x.getIdCarrera() == idCarrera).findFirst();
    }

    public List<Carrera> filtrarPorNombre(String texto) {
        String t = texto == null ? "" : texto.toLowerCase();
        return lista.stream()
                .filter(x -> x.getNomCarrera() != null && x.getNomCarrera().toLowerCase().contains(t))
                .collect(Collectors.toList());
    }

    public void modificar(Carrera c) {
        Carrera found = buscarPorId(c.getIdCarrera())
                .orElseThrow(() -> new IllegalArgumentException("Carrera no existe: " + c.getIdCarrera()));
        found.setNomCarrera(c.getNomCarrera());
        found.setGrado(c.getGrado());
    }

    public void eliminar(int idCarrera) {
        lista.removeIf(x -> x.getIdCarrera() == idCarrera);
    }

    public List<Carrera> listarTodos() { return new ArrayList<>(lista); }
}

