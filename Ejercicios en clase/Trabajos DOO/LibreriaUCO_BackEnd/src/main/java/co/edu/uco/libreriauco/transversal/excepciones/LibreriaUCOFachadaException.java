package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUCOFachadaException extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = 4984254421034523716L;

	private LibreriaUCOFachadaException( String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.CONTROLADOR, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static LibreriaUCOExcepcion crear (String mensajeUsuario) {
		return new LibreriaUCOFachadaException(mensajeUsuario, mensajeUsuario, 
				new Exception(mensajeUsuario));
		
	}
	
	public static LibreriaUCOExcepcion crear (String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUCOFachadaException(mensajeUsuario, mensajeTecnico, 
				new Exception(mensajeTecnico));
		
	}
	
	public static LibreriaUCOExcepcion crear (String mensajeUsuario, String mensajeTecnico, Exception exceptionRaiz) {
		return new LibreriaUCOFachadaException(mensajeUsuario, mensajeTecnico, exceptionRaiz);
		
	}

}
