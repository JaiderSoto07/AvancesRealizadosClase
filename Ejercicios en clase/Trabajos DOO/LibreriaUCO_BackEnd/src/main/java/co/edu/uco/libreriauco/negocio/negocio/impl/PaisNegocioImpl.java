package co.edu.uco.libreriauco.negocio.negocio.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.negocio.negocio.PaisNegocio;
import co.edu.uco.libreriauco.negocio.negocio.assembler.impl.PaisEntidadEAssembler;
import co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais.AsegurarNombreNuevoPaisNoExistaRule;
import co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais.AsegurarNombrePaisValidoRule;
import co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais.ValidarDatosRegistrarNuevoPaisRule;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCONegocioException;

public class PaisNegocioImpl implements PaisNegocio{
	
	private DAOFactory daoFactory;
	
	protected PaisNegocioImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public void registrarInformacionNuevoPais(PaisDominio datos) {
		ValidarDatosRegistrarNuevoPaisRule.obtenerIntancia().ejecutar(datos);
		AsegurarNombreNuevoPaisNoExistaRule.obtenerInstancia().ejecutar(datos.getNombre(), daoFactory);
	
		
		var paisEntidad = PaisEntidadEAssembler.getIntance().convertirAEntidad(datos);
		paisEntidad.setId(generarIdPaisUnico());
		
		
		daoFactory.obtenerPaisDAO().crear(paisEntidad);
		
		
	}
	
	private void asegurarDatosRegistroNueviPaisValidos(PaisDominio nombrePais)
	{
				
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
