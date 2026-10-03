package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUcoDominioExcepcion extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = -8983092286071457746L;

	private LibreriaUcoDominioExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DOMINIO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}
	
	public static LibreriaUCOExcepcion crear (String mensajeUsuario) {
		return new LibreriaUcoDominioExcepcion(mensajeUsuario, mensajeUsuario,
				new Exception(mensajeUsuario));

	}

	public static LibreriaUCOExcepcion crear (String mensajeUsuario, String mensajeTecnico) {
		return new LibreriaUcoDominioExcepcion(mensajeUsuario, mensajeTecnico,
				new Exception(mensajeTecnico));

	}

	public static LibreriaUCOExcepcion crear (String mensajeUsuario, String mensajeTecnico, Exception excepcionRaiz) {
		return new LibreriaUcoDominioExcepcion(mensajeUsuario, mensajeTecnico, excepcionRaiz);

	}

}
