package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOControladorException extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = 4984254421034523716L;

	private LibreriaUCOControladorException( String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.CONTROLADOR, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static LibreriaUCOExcepcion crear (String mensajeUsuario) {
		return new LibreriaUCOControladorException(mensajeUsuario, mensajeUsuario, 
				new Exception(mensajeUsuario));
		
	}
	
	public static LibreriaUCOExcepcion crear (String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCOControladorException(mensajeUsuario, mensajeUsuario, 
				new Exception(mensajeUsuario));
		
	}
	
	public static LibreriaUCOExcepcion crear (String mensajeUsuario, String mensajeTecnico, Exception exceptionRaiz) {
		return new LibreriaUCOControladorException(mensajeUsuario, mensajeUsuario, 
				new Exception(mensajeUsuario));
		
	}

}
