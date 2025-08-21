package logica;

import java.time.LocalDate;
import java.util.Objects;

public class PagosMensuales {
    private int idPago;                 // PK única y consecutiva
    private LocalDate fechCreacion;    // fecha del sistema
    private int mes;                   // 1-12 (mostrar como texto)
    private int anio;
    private LocalDate fechaPago;       // fecha efectiva de pago
    private String estudiante;         // cedula del estudiante (FK)
    private double totalBeneficios;
    private double deducSeguro;        // 10%
    private double deducRenta;         // 5%
    private double pagoNeto;           // total - deducciones

    public PagosMensuales() {}
    //holaaaaaaaaa
    public PagosMensuales(int idPago, LocalDate fechCreacion, int mes, int anio,
                          LocalDate fechaPago, String estudiante,
                          double totalBeneficios, double deducSeguro,
                          double deducRenta, double pagoNeto) {
        this.idPago = idPago;
        this.fechCreacion = fechCreacion;
        this.mes = mes;
        this.anio = anio;
        this.fechaPago = fechaPago;
        this.estudiante = estudiante;
        this.totalBeneficios = totalBeneficios;
        this.deducSeguro = deducSeguro;
        this.deducRenta = deducRenta;
        this.pagoNeto = pagoNeto;
    }

    public int getIdPago() {
        return idPago;
    }

    public void setIdPago(int idPago) {
        this.idPago = idPago;
    }

    public LocalDate getFechCreacion() {
        return fechCreacion;
    }

    public void setFechCreacion(LocalDate fechCreacion) {
        this.fechCreacion = fechCreacion;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public LocalDate getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(LocalDate fechaPago) {
        this.fechaPago = fechaPago;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public double getTotalBeneficios() {
        return totalBeneficios;
    }

    public void setTotalBeneficios(double totalBeneficios) {
        this.totalBeneficios = totalBeneficios;
    }

    public double getDeducSeguro() {
        return deducSeguro;
    }

    public void setDeducSeguro(double deducSeguro) {
        this.deducSeguro = deducSeguro;
    }

    public double getDeducRenta() {
        return deducRenta;
    }

    public void setDeducRenta(double deducRenta) {
        this.deducRenta = deducRenta;
    }

    public double getPagoNeto() {
        return pagoNeto;
    }

    public void setPagoNeto(double pagoNeto) {
        this.pagoNeto = pagoNeto;
    }

    public static double calcularSeguro(double totalBeneficios) {
        return totalBeneficios * 0.10;
    }

    public static double calcularRenta(double totalBeneficios) {
        return totalBeneficios * 0.05;
    }

    public static String nombreMes(int mes) {
        return switch (mes) {
            case 1 -> "Enero";
            case 2 -> "Febrero";
            case 3 -> "Marzo";
            case 4 -> "Abril";
            case 5 -> "Mayo";
            case 6 -> "Junio";
            case 7 -> "Julio";
            case 8 -> "Agosto";
            case 9 -> "Septiembre";
            case 10 -> "Octubre";
            case 11 -> "Noviembre";
            case 12 -> "Diciembre";
            default -> "Mes inválido";
        };
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PagosMensuales)) return false;
        PagosMensuales that = (PagosMensuales) o;
        return idPago == that.idPago;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPago);
    }
}
