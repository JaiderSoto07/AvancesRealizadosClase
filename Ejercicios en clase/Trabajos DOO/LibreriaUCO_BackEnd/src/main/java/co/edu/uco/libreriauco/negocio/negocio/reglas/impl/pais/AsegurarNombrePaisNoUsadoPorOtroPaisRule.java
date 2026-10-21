package co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais;

import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.negocio.negocio.reglas.Rule;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCONegocioException;

public class AsegurarNombrePaisNoUsadoPorOtroPaisRule implements Rule<Object> {

	private static final Rule<Object> intancia = new AsegurarNombrePaisNoUsadoPorOtroPaisRule();


	private AsegurarNombrePaisNoUsadoPorOtroPaisRule() {

	}

	public static final Rule<Object> obtenerInstancia(){
		return intancia;
	}

	@Override
	public void ejecutar(Object... datos) {

		var idPais = (UUID)datos[0];
		var nombrePais = (String)datos[1];
		var daoFactory = (DAOFactory)datos[2];

		var entidadFiltro = new PaisEntidad();
		entidadFiltro.setNombre(nombrePais);

		var resultado = daoFactory.obtenerPaisDAO().consultarPorFiltro(entidadFiltro);

		// Si el unico pais con ese nombre es el mismo que se esta modificando, no hay problema
		var existeOtroPaisConMismoNombre = resultado.stream().anyMatch(pais -> !pais.getId().equals(idPais));

		if (existeOtroPaisConMismoNombre) {
			var mensajeUsuario = CatalogoMensajes.PaisNegocioImpl.PAIS_YA_EXISTE_CON_EL_MISMO_NOMBRE_DE_PAIS_A_MODIFICAR;
			throw LibreriaUCONegocioException.crear(mensajeUsuario);
		}

	}

}
