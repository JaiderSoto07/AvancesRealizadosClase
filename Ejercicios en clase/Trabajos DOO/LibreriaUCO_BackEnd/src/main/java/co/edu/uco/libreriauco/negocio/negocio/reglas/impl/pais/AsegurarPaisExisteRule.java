package co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais;

import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.negocio.negocio.reglas.Rule;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCONegocioException;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class AsegurarPaisExisteRule implements Rule<Object> {

	private static final Rule<Object> intancia = new AsegurarPaisExisteRule();


	private AsegurarPaisExisteRule() {

	}

	public static final Rule<Object> obtenerInstancia(){
		return intancia;
	}

	@Override
	public void ejecutar(Object... datos) {

		var idPais = (UUID)datos[0];
		var daoFactory = (DAOFactory)datos[1];

		var resultado = daoFactory.obtenerPaisDAO().consultarPorId(idPais);

		if (UtilUUID.UUID_DEFECTO.equals(resultado.getId())) {
			var mensajeUsuario = CatalogoMensajes.PaisNegocioImpl.PAIS_NO_EXISTE;
			throw LibreriaUCONegocioException.crear(mensajeUsuario);
		}

	}

}
