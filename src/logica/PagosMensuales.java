/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;

import java.util.Calendar;
import java.util.Objects;

public class PagosMensuales {
    private int idPago;                 // PK única y consecutiva
    private Calendar fechCreacion;      // fecha del sistema
    private int mes;                    // 1-12 (mostrar como texto)
    private int anio;
    private Calendar fechaPago;         // fecha efectiva de pago
    private String estudiante;          // cedula del estudiante (FK)
    private double totalBeneficios;
    private double deducSeguro;         // 10%
    private double deducRenta;          // 5%
    private double pagoNeto;            // total - deducciones

    public PagosMensuales() {}

    public PagosMensuales(int idPago, Calendar fechCreacion, int mes, int anio,
                          Calendar fechaPago, String estudiante,
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

    public Calendar getFechCreacion() {
        return fechCreacion;
    }

    public void setFechCreacion(Calendar fechCreacion) {
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

    public Calendar getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Calendar fechaPago) {
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
        switch (mes) {
            case 1: return "Enero";
            case 2: return "Febrero";
            case 3: return "Marzo";
            case 4: return "Abril";
            case 5: return "Mayo";
            case 6: return "Junio";
            case 7: return "Julio";
            case 8: return "Agosto";
            case 9: return "Septiembre";
            case 10: return "Octubre";
            case 11: return "Noviembre";
            case 12: return "Diciembre";
            default: return "Mes inválido";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PagosMensuales)) return false;
        PagosMensuales that = (PagosMensuales) o;
        return idPago == that.idPago;
    }

    @Override
    public int hashCode() { return Objects.hash(idPago); }
}

