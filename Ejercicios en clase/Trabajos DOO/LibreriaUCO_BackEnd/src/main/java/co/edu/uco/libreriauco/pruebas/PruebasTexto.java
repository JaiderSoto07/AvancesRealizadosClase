package co.edu.uco.libreriauco.pruebas;

import static co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto.getUtilTexto;
public class PruebasTexto {

	public static void main(String[] args) {
		
		String miVariable = null;
		String espaciosEnBlanco = "   Hola Mundo   ";
		
		System.out.println(miVariable);
		System.out.println(getUtilTexto().obtenerLongitudCadena(espaciosEnBlanco, false));
		System.out.println(getUtilTexto().obtenerLongitudCadena(espaciosEnBlanco, true));
	}

}
