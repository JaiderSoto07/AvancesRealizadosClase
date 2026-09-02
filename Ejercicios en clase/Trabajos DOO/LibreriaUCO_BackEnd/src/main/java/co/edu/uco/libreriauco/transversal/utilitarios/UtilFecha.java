package co.edu.uco.libreriauco.transversal.utilitarios;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class UtilFecha {
    public static LocalDate obtenerFechaActual() {
        return LocalDate.now();
    }

    public static boolean esNula(LocalDate fecha) {
        return fecha == null;
    }

    public static LocalDate obtenerValorDefecto(
            LocalDate fecha, LocalDate fechaDefecto) {

        return fecha == null ? fechaDefecto : fecha;
    }

    public static LocalDate obtenerValorDefecto(LocalDate fecha) {
        return obtenerValorDefecto(fecha, obtenerFechaActual());
    }

    public static boolean menorQue(
            LocalDate fechaUno, LocalDate fechaDos) {

        return fechaUno.isBefore(fechaDos);
    }

    public static boolean menorIgualQue(
            LocalDate fechaUno, LocalDate fechaDos) {

        return fechaUno.isBefore(fechaDos)
                || fechaUno.isEqual(fechaDos);
    }

    public static boolean mayorQue(
            LocalDate fechaUno, LocalDate fechaDos) {

        return fechaUno.isAfter(fechaDos);
    }

    public static boolean mayorIgualQue(
            LocalDate fechaUno, LocalDate fechaDos) {

        return fechaUno.isAfter(fechaDos)
                || fechaUno.isEqual(fechaDos);
    }

    public static boolean igualQue(
            LocalDate fechaUno, LocalDate fechaDos) {

        return fechaUno.isEqual(fechaDos);
    }

    public static boolean diferenteQue(
            LocalDate fechaUno, LocalDate fechaDos) {

        return !fechaUno.isEqual(fechaDos);
    }

    public static boolean estaEntreIncluido(
            LocalDate fechaInicial,
            LocalDate fechaFinal,
            LocalDate fecha) {

        return mayorIgualQue(fecha, fechaInicial)
                && menorIgualQue(fecha, fechaFinal);
    }

    public static boolean estaEntreNoIncluido(
            LocalDate fechaInicial,
            LocalDate fechaFinal,
            LocalDate fecha) {

        return mayorQue(fecha, fechaInicial)
                && menorQue(fecha, fechaFinal);
    }

    public static long calcularDiferenciaEntreFechas(
            LocalDate fechaInicial,
            LocalDate fechaFinal) {

        return ChronoUnit.DAYS.between(
                fechaInicial, fechaFinal);
    }
}
