package co.edu.uco.libreriauco.negocio.fachada.impl;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.dto.PaisDTO;
import co.edu.uco.libreriauco.negocio.fachada.PaisFachada;
import co.edu.uco.libreriauco.negocio.fachada.assembler.impl.PaisDToAssembler;
import co.edu.uco.libreriauco.negocio.negocio.PaisNegocio;
import co.edu.uco.libreriauco.negocio.negocio.impl.PaisNegocioImpl;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOFachadaException;


public class PaisFachadaImpl implements PaisFachada {
	
	private DAOFactory daoFactory;
	private PaisNegocio paisNegocio;
	
	public PaisFachadaImpl() {
		daoFactory = DAOFactory.obtenerFactoria();	
		paisNegocio = new PaisNegocioImpl(daoFactory);
	}

	@Override
	public void registrarInformacionNuevoPais(PaisDTO datos) {
		
		daoFactory.iniciarTransaccion();
		
		try {
			var paisDominio = PaisDToAssembler.getIntance().convertirADominio(datos);
			paisNegocio.registrarInformacionNuevoPais(paisDominio);
			daoFactory.confirmarTransaccion();
			
		} 	catch (LibreriaUCOExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} 	catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_PROBLEMA_INESPERADO_REGISTRANDO_PAIS;
			throw LibreriaUCOFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} 	finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public void modificarInformacionPaisExistente(UUID id, PaisDTO datos) {
		
		daoFactory.iniciarTransaccion();
		
		try {
			var paisDominio = PaisDToAssembler.getIntance().convertirADominio(datos);
			paisNegocio.modificarInformacionPaisExistente(id ,paisDominio);
			daoFactory.confirmarTransaccion();
			
		} 	catch (LibreriaUCOExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} 	catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();
			
			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_PROBLEMA_INESPERADO_MODIFICANDO_PAIS;
			throw LibreriaUCOFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} 	finally {
			daoFactory.cerrarConexion();
		}
		
		
	}

	@Override
	public void DarBajaInformacionPaisExistente(UUID id) {

		daoFactory.iniciarTransaccion();

		try {
			paisNegocio.DarBajaInformacionPaisExistente(id);
			daoFactory.confirmarTransaccion();

		} 	catch (LibreriaUCOExcepcion excepcion) {
			daoFactory.cancelarTransaccion();
			throw excepcion;
		} 	catch (Exception excepcion) {
			daoFactory.cancelarTransaccion();

			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_PROBLEMA_INESPERADO_DANDO_BAJA_PAIS;
			throw LibreriaUCOFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} 	finally {
			daoFactory.cerrarConexion();
		}

	}

	@Override
	public List<PaisDTO> ConsultarPorFiltro(PaisDTO filtro) {

		try {
			var filtroDominio = PaisDToAssembler.getIntance().convertirADominio(filtro);
			var listaPaisesDominio = paisNegocio.ConsultarPorFiltro(filtroDominio);
			return PaisDToAssembler.getIntance().convertirADTO(listaPaisesDominio);

		} 	catch (LibreriaUCOExcepcion excepcion) {
			throw excepcion;
		} 	catch (Exception excepcion) {

			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_PROBLEMA_INESPERADO_CONSULTANDO_PAISES_POR_FILTRO;
			throw LibreriaUCOFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} 	finally {
			daoFactory.cerrarConexion();
		}

	}

	@Override
	public List<PaisDTO> consultarTodos() {
		
		
		try {
			
			var listaPaisesDominio = paisNegocio.consultarTodos();
			return PaisDToAssembler.getIntance().convertirADTO(listaPaisesDominio);
			
	
			
		} 	catch (LibreriaUCOExcepcion excepcion) {
			throw excepcion;
		} 	catch (Exception excepcion) {
			
			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_PROBLEMA_INESPERADO_CONSULTANDO_TODOS_LOS_PAISES;
			throw LibreriaUCOFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} 	finally {
			daoFactory.cerrarConexion();
		}
		
	}

	@Override
	public PaisDTO consultarPorID(UUID id) {

		try {
			var paisDominio = paisNegocio.consultarPorID(id);
			return PaisDToAssembler.getIntance().convertirADTO(paisDominio);

		} 	catch (LibreriaUCOExcepcion excepcion) {
			throw excepcion;
		} 	catch (Exception excepcion) {

			var mensajeUsuario = CatalogoMensajes.PaisFachadaImpl.USUARIO_ERROR_PROBLEMA_INESPERADO_CONSULTANDO_PAIS_POR_ID;
			throw LibreriaUCOFachadaException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} 	finally {
			daoFactory.cerrarConexion();
		}

	}

}
