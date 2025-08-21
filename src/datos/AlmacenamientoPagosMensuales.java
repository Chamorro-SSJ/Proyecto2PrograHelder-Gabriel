package datos;

import logica.Beneficio;
import logica.PagosMensuales;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public List<PagosMensuales> listarTodos() {
        return new ArrayList<>(lista);
    }

    public List<PagosMensuales> listarPorMesAnio(int mes, int anio) {
        return lista.stream()
                .filter(x -> x.getMes() == mes && x.getAnio() == anio)
                .collect(Collectors.toList());
    }

    public List<PagosMensuales> filtrar(String cedula, Integer mes, Integer anio) {
        return lista.stream().filter(x ->
                (cedula == null || x.getEstudiante().equalsIgnoreCase(cedula)) &&
                (mes == null || x.getMes() == mes) &&
                (anio == null || x.getAnio() == anio)
        ).collect(Collectors.toList());
    }

    // Regla: no generar planilla de un mes/año anterior al actual
    private void validarFechaPlanillaNoPasada(int mes, int anio) {
        LocalDate hoy = LocalDate.now();
        int mesActual = hoy.getMonthValue();
        int anioActual = hoy.getYear();
        if (anio < anioActual || (anio == anioActual && mes < mesActual)) {
            throw new IllegalArgumentException("No se puede generar planilla para un mes/año anterior al actual.");
        }
    }

    // Genera un registro por cada estudiante con beneficios asignados
    public List<PagosMensuales> generarPlanilla(int mes, int anio, LocalDate fechaPago,
                                                AlmacenamientoEstudiantes almEst,
                                                AlmacenamientoBeneficiosEstudiantes almBE,
                                                AlmacenamientoBeneficios almBen) {
        validarFechaPlanillaNoPasada(mes, anio);
        if (existePlanillaMesAnio(mes, anio))
            throw new IllegalArgumentException("Ya existe planilla para " + PagosMensuales.nombreMes(mes) + " " + anio);

        List<PagosMensuales> generados = new ArrayList<>();
        LocalDate ahora = LocalDate.now();

        almEst.listarTodos().forEach(est -> {
            List<Integer> idsBen = almBE.listarIdBeneficiosPorEstudiante(est.getCedula());
            if (idsBen.isEmpty()) return; // estudiante sin beneficios -> no se genera pago

            double total = idsBen.stream()
                    .map(idb -> almBen.buscarPorId(idb))
                    .filter(Optional::isPresent)
                    .mapToDouble(opt -> opt.get().getMontoBeneficio())
                    .sum();

            double seguro = PagosMensuales.calcularSeguro(total);
            double renta = PagosMensuales.calcularRenta(total);
            double neto = total - seguro - renta;

            PagosMensuales pago = new PagosMensuales(
                    siguienteIdPago(),
                    ahora,
                    mes,
                    anio,
                    fechaPago,
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
