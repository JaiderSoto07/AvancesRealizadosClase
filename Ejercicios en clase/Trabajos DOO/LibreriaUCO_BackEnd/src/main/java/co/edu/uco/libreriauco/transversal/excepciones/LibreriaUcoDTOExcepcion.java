package co.edu.uco.libreriauco.transversal.excepciones;

import co.edu.uco.libreriauco.transversal.excepciones.enums.Capa;

public class LibreriaUcoDTOExcepcion extends LibreriaUCOExcepcion {

	private static final long serialVersionUID = 2338266948386302150L;

	private LibreriaUcoDTOExcepcion(String mensajeUsuario, String mensajeTecnico,
			Exception excepcionRaiz) {
		super(Capa.DTO, mensajeUsuario, mensajeTecnico, excepcionRaiz);
	}

}
