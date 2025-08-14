/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import logica.Beneficio;
import logica.PagosMensuales;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class AlmacenamientoPagosMensuales {
    private final List<PagosMensuales> lista = new ArrayList<>();

    public int siguienteIdPago() {
        return lista.stream().map(PagosMensuales::getIdPago).max(Comparator.naturalOrder()).orElse(0) + 1;
    }

    public void insertar(PagosMensuales p) {
        if (existeIdPago(p.getIdPago()))
            throw new IllegalArgumentException("idPago duplicado: " + p.getIdPago());
        lista.add(p);
    }

    public boolean existeIdPago(int idPago) {
        return lista.stream().anyMatch(x -> x.getIdPago() == idPago);
    }

    public boolean existePlanillaMesAnio(int mes, int anio) {
        return lista.stream().anyMatch(x -> x.getMes() == mes && x.getAnio() == anio);
    }

    public List<PagosMensuales> listarTodos() { return new ArrayList<>(lista); }

    public List<PagosMensuales> listarPorMesAnio(int mes, int anio) {
        return lista.stream().filter(x -> x.getMes() == mes && x.getAnio() == anio)
                .collect(Collectors.toList());
    }

    public List<PagosMensuales> filtrar(String cedula, Integer mes, Integer anio) {
        return lista.stream().filter(x ->
                (cedula == null || x.getEstudiante().equalsIgnoreCase(cedula)) &&
                (mes == null || x.getMes() == mes) &&
                (anio == null || x.getAnio() == anio)
        ).collect(Collectors.toList());
    }

    // Regla: no generar planilla de un mes/anio anterior al actual
    private void validarFechaPlanillaNoPasada(int mes, int anio) {
        Calendar hoy = Calendar.getInstance();
        int mesActual = hoy.get(Calendar.MONTH) + 1;
        int anioActual = hoy.get(Calendar.YEAR);
        if (anio < anioActual || (anio == anioActual && mes < mesActual)) {
            throw new IllegalArgumentException("No se puede generar planilla para un mes/año anterior al actual.");
        }
    }

    // Genera un registro por cada estudiante con beneficios asignados
    public List<PagosMensuales> generarPlanilla(int mes, int anio, Calendar fechaPago,
                                                AlmacenamientoEstudiantes almEst,
                                                AlmacenamientoBeneficiosEstudiantes almBE,
                                                AlmacenamientoBeneficios almBen) {
        validarFechaPlanillaNoPasada(mes, anio);
        if (existePlanillaMesAnio(mes, anio))
            throw new IllegalArgumentException("Ya existe planilla para " + PagosMensuales.nombreMes(mes) + " " + anio);

        List<PagosMensuales> generados = new ArrayList<>();
        Calendar ahora = Calendar.getInstance();

        almEst.listarTodos().forEach(est -> {
            List<Integer> idsBen = almBE.listarIdBeneficiosPorEstudiante(est.getCedula());
            if (idsBen.isEmpty()) return; // estudiante sin beneficios -> no se genera pago

            double total = 0.0;
            for (Integer idb : idsBen) {
                Optional<Beneficio> ben = almBen.buscarPorId(idb);
                if (ben.isPresent()) total += ben.get().getMontoBeneficio();
            }
            double seguro = PagosMensuales.calcularSeguro(total);
            double renta = PagosMensuales.calcularRenta(total);
            double neto = total - seguro - renta;

            PagosMensuales pago = new PagosMensuales(
                    siguienteIdPago(),
                    (Calendar) ahora.clone(),
                    mes,
                    anio,
                    (Calendar) fechaPago.clone(),
                    est.getCedula(),
                    redondear2(total),
                    redondear2(seguro),
                    redondear2(renta),
                    redondear2(neto)
            );
            insertar(pago);
            generados.add(pago);
        });

        return generados;
    }

    private double redondear2(double val) {
        return Math.round(val * 100.0) / 100.0;
    }
}

