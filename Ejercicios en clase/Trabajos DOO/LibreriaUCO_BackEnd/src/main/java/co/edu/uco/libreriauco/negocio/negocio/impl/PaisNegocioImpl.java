package co.edu.uco.libreriauco.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.negocio.negocio.PaisNegocio;
import co.edu.uco.libreriauco.negocio.negocio.assembler.impl.PaisEntidadEAssembler;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCONegocioException;

public class PaisNegocioImpl implements PaisNegocio{
	
	private DAOFactory daoFactory;
	
	protected PaisNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoPais(PaisDominio datos) {
		asegurarDatosRegistroNueviPaisValidos(datos);
		asegurarNombreNuevoPaisNoExista(datos.getNombre());
		
		
		var paisEntidad = PaisEntidadEAssembler.getIntance().convertirAEntidad(datos);
		paisEntidad.setId(generarIdPaisUnico());
		
		
		daoFactory.obtenerPaisDAO().crear(paisEntidad);
		
		
	}
	
	private void asegurarDatosRegistroNueviPaisValidos(PaisDominio nombrePais)
	{
				
	}
	
	private void asegurarNombreNuevoPaisNoExista(String nombrePais)
	{
		
		var entidadFiltro = new PaisEntidad();
		entidadFiltro.setNombre(nombrePais);
		
		var resultado = daoFactory.obtenerPaisDAO().consultarPorFiltro(entidadFiltro);
		
		if (!resultado.isEmpty()) {
			var mensajeUsuario = CatalogoMensajes.PaisNegocioImpl.PAIS_YA_EXISTE_CON_EL_MISMO_NOMBRE_DE_PAIS_A_CREAR;
			throw LibreriaUCONegocioException.crear(mensajeUsuario);
		}
		
		
	}
	
	private UUID generarIdPaisUnico()
	{
		return UUID.randomUUID()
;		
	}
	
	@Override
	public void modificarInformacionPaisExistente(UUID id, PaisDominio datos) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void DarBajaInformacionPaisExistente(UUID id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PaisDominio> ConsultarPorFiltro(PaisDominio filtro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PaisDominio> consultarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PaisDominio consultarPorID(UUID id) {
		// TODO Auto-generated method stub
		return null;
	}

}
