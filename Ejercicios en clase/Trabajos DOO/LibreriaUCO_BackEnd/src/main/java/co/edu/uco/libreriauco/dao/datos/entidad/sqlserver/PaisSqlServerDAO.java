package co.edu.uco.libreriauco.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.SqlDAO;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCODatosException;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PaisSqlServerDAO extends SqlDAO implements PaisDAO{

	private static final String SELECT_BASE = "SELECT id, nombre FROM pais";

	public PaisSqlServerDAO(Connection conexion) {
		super(conexion);

	}

	@Override
	public void crear(PaisEntidad entidad) {
		var sentenciaSql = "INSERT INTO pais (id, nombre) VALUES (?, ?)";

		try (var sentencia = getConnection().prepareStatement(sentenciaSql)) {
			sentencia.setString(1, entidad.getId().toString());
			sentencia.setString(2, entidad.getNombre());
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisSqlServerDAO.USUARIO_ERROR_PROBLEMA_CREANDO_PAIS;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisSqlServerDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PAIS;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public PaisEntidad consultarPorId(UUID id) {
		var sentenciaSql = SELECT_BASE + " WHERE id = ?";
		var paisEncontrado = new PaisEntidad.Builder().Build();

		try (var sentencia = getConnection().prepareStatement(sentenciaSql)) {
			sentencia.setString(1, UtilUUID.obtenerValorDefecto(id).toString());

			try (var resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					paisEncontrado = mapear(resultado);
				}
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisSqlServerDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAIS_POR_ID;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisSqlServerDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAIS_POR_ID;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}

		return paisEncontrado;
	}

	@Override
	public List<PaisEntidad> consultarPorFiltro(PaisEntidad filtro) {
		// Solo se filtra por los campos que traen valor; un filtro vacio trae todos los paises
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiNulo(filtro, new PaisEntidad.Builder().Build());
		var sentenciaSql = new StringBuilder(SELECT_BASE).append(" WHERE 1 = 1");
		var parametros = new ArrayList<String>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtroSeguro.getId())) {
			sentenciaSql.append(" AND id = ?");
			parametros.add(filtroSeguro.getId().toString());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroSeguro.getNombre())) {
			sentenciaSql.append(" AND nombre = ?");
			parametros.add(filtroSeguro.getNombre());
		}
		sentenciaSql.append(" ORDER BY nombre");

		try (var sentencia = getConnection().prepareStatement(sentenciaSql.toString())) {
			for (var indice = 0; indice < parametros.size(); indice++) {
				sentencia.setString(indice + 1, parametros.get(indice));
			}
			return ejecutarConsulta(sentencia.executeQuery());
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisSqlServerDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAISES_POR_FILTRO;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisSqlServerDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAISES_POR_FILTRO;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public List<PaisEntidad> consultarTodos() {
		var sentenciaSql = SELECT_BASE + " ORDER BY nombre";

		try (var sentencia = getConnection().prepareStatement(sentenciaSql)) {
			return ejecutarConsulta(sentencia.executeQuery());
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisSqlServerDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODOS_LOS_PAISES;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisSqlServerDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TODOS_LOS_PAISES;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public void actualizar(UUID id, PaisEntidad entidad) {
		var sentenciaSql = "UPDATE pais SET nombre = ? WHERE id = ?";

		try (var sentencia = getConnection().prepareStatement(sentenciaSql)) {
			sentencia.setString(1, entidad.getNombre());
			sentencia.setString(2, UtilUUID.obtenerValorDefecto(id).toString());
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisSqlServerDAO.USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_PAIS;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisSqlServerDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_PAIS;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public void eliminar(UUID id) {
		var sentenciaSql = "DELETE FROM pais WHERE id = ?";

		try (var sentencia = getConnection().prepareStatement(sentenciaSql)) {
			sentencia.setString(1, UtilUUID.obtenerValorDefecto(id).toString());
			sentencia.executeUpdate();
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisSqlServerDAO.USUARIO_ERROR_PROBLEMA_ELIMINANDO_PAIS;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.PaisSqlServerDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_PAIS;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	private List<PaisEntidad> ejecutarConsulta(ResultSet resultado) throws SQLException {
		var paises = new ArrayList<PaisEntidad>();

		try (resultado) {
			while (resultado.next()) {
				paises.add(mapear(resultado));
			}
		}

		return paises;
	}

	private PaisEntidad mapear(ResultSet resultado) throws SQLException {
		return new PaisEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.nombre(resultado.getString("nombre"))
				.Build();
	}

}
