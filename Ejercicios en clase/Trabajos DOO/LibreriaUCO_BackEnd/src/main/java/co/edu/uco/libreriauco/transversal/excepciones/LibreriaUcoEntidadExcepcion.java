package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUcoEntidadExcepcion extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = 4868744836742316617L;

	private LibreriaUcoEntidadExcepcion( String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.ENTIDAD, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
