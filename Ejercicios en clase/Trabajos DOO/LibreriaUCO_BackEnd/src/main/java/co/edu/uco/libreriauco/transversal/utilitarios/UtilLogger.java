package co.edu.uco.libreriauco.transversal.utilitarios;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;

public class UtilLogger {

	private Logger logger;

	private UtilLogger(Class<?> clase) {
		logger = LoggerFactory.getLogger(clase);
	}

	public static UtilLogger obtenerLogger(Class<?> clase) {
		return new UtilLogger(clase);
	}

	public void printException(Exception excepcion) {

		if (excepcion instanceof LibreriaUCOExcepcion excepcionLibreria) {
			logger.error("Capa: {} | Mensaje usuario: {} | Mensaje tecnico: {}",
					excepcionLibreria.getCapa(),
					excepcionLibreria.getMensajeUsuario(),
					excepcionLibreria.getMensajeTecnico(),
					excepcionLibreria.getExcepcionRaiz());
		} else {
			logger.error(excepcion.getMessage(), excepcion);
		}
	}

}
