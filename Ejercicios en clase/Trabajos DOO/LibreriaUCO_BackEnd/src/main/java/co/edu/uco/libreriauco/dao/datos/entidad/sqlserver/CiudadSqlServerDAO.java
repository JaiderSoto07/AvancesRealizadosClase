package co.edu.uco.libreriauco.dao.datos.entidad.sqlserver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dao.datos.entidad.CiudadDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.SqlDAO;
import co.edu.uco.libreriauco.entidad.CiudadEntidad;
import co.edu.uco.libreriauco.entidad.DepartamentoEntidad;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCODatosException;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class CiudadSqlServerDAO extends SqlDAO implements CiudadDAO {

	private static final String SELECT_BASE = "SELECT c.id, c.nombre, "
			+ "d.id AS id_departamento, d.nombre AS nombre_departamento, "
			+ "p.id AS id_pais, p.nombre AS nombre_pais "
			+ "FROM ciudad c "
			+ "INNER JOIN departamento d ON d.id = c.departamento "
			+ "INNER JOIN pais p ON p.id = d.pais";

	public CiudadSqlServerDAO(Connection conexion) {
		super(conexion);
	}

	@Override
	public CiudadEntidad consultarPorId(UUID id) {
		var sentenciaSql = SELECT_BASE + " WHERE c.id = ?";
		var ciudadEncontrada = new CiudadEntidad.Builder().Build();

		try (var sentencia = getConnection().prepareStatement(sentenciaSql)) {
			sentencia.setString(1, UtilUUID.obtenerValorDefecto(id).toString());

			try (var resultado = sentencia.executeQuery()) {
				if (resultado.next()) {
					ciudadEncontrada = mapear(resultado);
				}
			}
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadSqlServerDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CIUDAD_POR_ID;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadSqlServerDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDAD_POR_ID;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}

		return ciudadEncontrada;
	}

	@Override
	public List<CiudadEntidad> consultarPorFiltro(CiudadEntidad filtro) {
		var filtroSeguro = UtilObjeto.obtenerValorDefectoSiNulo(filtro, new CiudadEntidad.Builder().Build());
		var sentenciaSql = new StringBuilder(SELECT_BASE).append(" WHERE 1 = 1");
		var parametros = new ArrayList<String>();

		if (!UtilUUID.UUID_DEFECTO.equals(filtroSeguro.getId())) {
			sentenciaSql.append(" AND c.id = ?");
			parametros.add(filtroSeguro.getId().toString());
		}
		if (!UtilTexto.getUtilTexto().esVacia(filtroSeguro.getNombre())) {
			sentenciaSql.append(" AND c.nombre = ?");
			parametros.add(filtroSeguro.getNombre());
		}
		if (!UtilUUID.UUID_DEFECTO.equals(filtroSeguro.getDepartamento().getId())) {
			sentenciaSql.append(" AND d.id = ?");
			parametros.add(filtroSeguro.getDepartamento().getId().toString());
		}
		if (!UtilUUID.UUID_DEFECTO.equals(filtroSeguro.getDepartamento().getPais().getId())) {
			sentenciaSql.append(" AND p.id = ?");
			parametros.add(filtroSeguro.getDepartamento().getPais().getId().toString());
		}
		sentenciaSql.append(" ORDER BY c.nombre");

		try (var sentencia = getConnection().prepareStatement(sentenciaSql.toString())) {
			for (var indice = 0; indice < parametros.size(); indice++) {
				sentencia.setString(indice + 1, parametros.get(indice));
			}
			return ejecutarConsulta(sentencia.executeQuery());
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadSqlServerDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_CIUDADES_POR_FILTRO;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadSqlServerDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDADES_POR_FILTRO;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	@Override
	public List<CiudadEntidad> consultarTodos() {
		var sentenciaSql = SELECT_BASE + " ORDER BY c.nombre";

		try (var sentencia = getConnection().prepareStatement(sentenciaSql)) {
			return ejecutarConsulta(sentencia.executeQuery());
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadSqlServerDAO.USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODAS_LAS_CIUDADES;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.CiudadSqlServerDAO.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TODAS_LAS_CIUDADES;
			throw LibreriaUCODatosException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	private List<CiudadEntidad> ejecutarConsulta(ResultSet resultado) throws SQLException {
		var ciudades = new ArrayList<CiudadEntidad>();

		try (resultado) {
			while (resultado.next()) {
				ciudades.add(mapear(resultado));
			}
		}

		return ciudades;
	}

	private CiudadEntidad mapear(ResultSet resultado) throws SQLException {
		var pais = new PaisEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id_pais")))
				.nombre(resultado.getString("nombre_pais"))
				.Build();

		var departamento = new DepartamentoEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id_departamento")))
				.nombre(resultado.getString("nombre_departamento"))
				.pais(pais)
				.Build();

		return new CiudadEntidad.Builder()
				.id(UUID.fromString(resultado.getString("id")))
				.nombre(resultado.getString("nombre"))
				.departamento(departamento)
				.Build();
	}

}
