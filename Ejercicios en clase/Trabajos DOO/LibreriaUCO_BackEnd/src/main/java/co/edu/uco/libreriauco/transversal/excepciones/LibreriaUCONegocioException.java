package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCONegocioException extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = 6217087357862168565L;

	protected LibreriaUCONegocioException(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.NEGOCIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static LibreriaUCOExcepcion crear (String mensajeUsuario) {
		return new LibreriaUCONegocioException(mensajeUsuario, mensajeUsuario,
				new Exception(mensajeUsuario));

	}

	public static LibreriaUCOExcepcion crear (String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCONegocioException(mensajeUsuario, mensajeTecnico,
				new Exception(mensajeTecnico));

	}

	public static LibreriaUCOExcepcion crear (String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new LibreriaUCONegocioException(mensajeUsuario, mensajeTecnico, excepcionRaiz);

	}

}
