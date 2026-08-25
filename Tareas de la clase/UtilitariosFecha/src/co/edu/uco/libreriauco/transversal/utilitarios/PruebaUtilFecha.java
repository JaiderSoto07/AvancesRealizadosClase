package co.edu.uco.libreriauco.transversal.utilitarios;

import java.time.LocalDate;

public class PruebaUtilFecha {

	public static void main(String[] args) {


		LocalDate fechaUno = LocalDate.of(2026, 8, 1);
        LocalDate fechaDos = LocalDate.of(2026, 8, 25);
        LocalDate fechaTres = LocalDate.of(2026, 8, 15);

        System.out.println("Fecha actual: "
                + UtilFecha.obtenerFechaActual());

        System.out.println("menorQue: "
                + UtilFecha.menorQue(fechaUno, fechaDos));

        System.out.println("menorIgualQue: "
                + UtilFecha.menorIgualQue(fechaUno, fechaDos));

        System.out.println("mayorQue: "
                + UtilFecha.mayorQue(fechaDos, fechaUno));

        System.out.println("mayorIgualQue: "
                + UtilFecha.mayorIgualQue(fechaDos, fechaUno));

        System.out.println("igualQue: "
                + UtilFecha.igualQue(fechaUno, fechaUno));

        System.out.println("diferenteQue: "
                + UtilFecha.diferenteQue(fechaUno, fechaDos));

        System.out.println("Entre incluido: "
                + UtilFecha.estaEntreIncluido(
                        fechaUno, fechaDos, fechaTres));

        System.out.println("Entre no incluido: "
                + UtilFecha.estaEntreNoIncluido(
                        fechaUno, fechaDos, fechaTres));

        System.out.println("Diferencia de días: "
                + UtilFecha.calcularDiferenciaEntreFechas(
                        fechaUno, fechaDos));
    }
}
