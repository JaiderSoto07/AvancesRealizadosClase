package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOTransversalException extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = -2434674487388203584L;

	private LibreriaUCOTransversalException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.TRANSVERSAL, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
