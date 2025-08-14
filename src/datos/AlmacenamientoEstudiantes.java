/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import logica.Estudiante;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlmacenamientoEstudiantes {
    private final List<Estudiante> lista = new ArrayList<>();

    public void insertar(Estudiante e, AlmacenamientoCarreras almCarreras) {
        if (existeCarnet(e.getCarnet()))
            throw new IllegalArgumentException("Carnet duplicado: " + e.getCarnet());
        if (existeCedula(e.getCedula()))
            throw new IllegalArgumentException("Cédula duplicada: " + e.getCedula());
        if (!almCarreras.existeId(e.getIdCarrera()))
            throw new IllegalArgumentException("Carrera no existe: " + e.getIdCarrera());
        lista.add(e);
    }

    public boolean existeCarnet(String carnet) {
        return lista.stream().anyMatch(x -> x.getCarnet().equalsIgnoreCase(carnet));
    }

    public boolean existeCedula(String cedula) {
        return lista.stream().anyMatch(x -> x.getCedula().equalsIgnoreCase(cedula));
    }

    public Optional<Estudiante> buscarPorCarnet(String carnet) {
        return lista.stream().filter(x -> x.getCarnet().equalsIgnoreCase(carnet)).findFirst();
    }

    public Optional<Estudiante> buscarPorCedula(String cedula) {
        return lista.stream().filter(x -> x.getCedula().equalsIgnoreCase(cedula)).findFirst();
    }

    public List<Estudiante> filtrarPorNombre(String texto) {
        String t = texto == null ? "" : texto.toLowerCase();
        return lista.stream()
                .filter(x -> x.getNombre() != null && x.getNombre().toLowerCase().contains(t))
                .collect(Collectors.toList());
    }

    public void modificar(Estudiante e, AlmacenamientoCarreras almCarreras) {
        Estudiante found = buscarPorCarnet(e.getCarnet())
                .orElseThrow(() -> new IllegalArgumentException("Estudiante no existe: " + e.getCarnet()));
        // Validar carrera
        if (!almCarreras.existeId(e.getIdCarrera()))
            throw new IllegalArgumentException("Carrera no existe: " + e.getIdCarrera());
        // Actualizar campos mutables (carnet es PK, no lo cambiamos aquí)
        found.setNombre(e.getNombre());
        found.setFechNac(e.getFechNac());
        found.setDireccion(e.getDireccion());
        found.setTelefono(e.getTelefono());
        found.setEmail(e.getEmail());
        found.setFechIngreso(e.getFechIngreso());
        found.setFechEgreso(e.getFechEgreso());
        found.setIdCarrera(e.getIdCarrera());
    }

    public void eliminarPorCarnet(String carnet) {
        lista.removeIf(x -> x.getCarnet().equalsIgnoreCase(carnet));
    }

    public List<Estudiante> listarTodos() { return new ArrayList<>(lista); }
}

