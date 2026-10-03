package co.edu.uco.libreriauco.dao.factoria.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import co.edu.uco.libreriauco.dao.datos.entidad.CiudadDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.CiudadSqlServerDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import co.edu.uco.libreriauco.dao.factoria.DAOFactory;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOTransversalException;

public class SqlServerDAOFactory extends DAOFactory {

	// Archivo del classpath (src/main/resources) con los datos de conexion; no se sube a Git
	private static final String ARCHIVO_CONFIGURACION = "basedatos.properties";
	private static final String PROPIEDAD_URL = "spring.datasource.url";
	private static final String PROPIEDAD_USUARIO = "spring.datasource.username";
	private static final String PROPIEDAD_CLAVE = "spring.datasource.password";

	@Override
	protected void abrirConexion() {
		var configuracion = cargarConfiguracion();

		try {
			var conexion = DriverManager.getConnection(
					configuracion.getProperty(PROPIEDAD_URL),
					configuracion.getProperty(PROPIEDAD_USUARIO),
					configuracion.getProperty(PROPIEDAD_CLAVE));
			setConexion(conexion);
		} catch (SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.SqlServerDAOFactory.USUARIO_ERROR_PROBLEMA_ABRIENDO_CONEXION_SQL;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		} catch (Exception excepcion) {
			var mensajeUsuario = CatalogoMensajes.SqlServerDAOFactory.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ABRIENDO_CONEXION_SQL;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}
	}

	private static Properties cargarConfiguracion() {
		var configuracion = new Properties();

		try (var archivo = SqlServerDAOFactory.class.getClassLoader().getResourceAsStream(ARCHIVO_CONFIGURACION)) {
			if (archivo == null) {
				throw new IOException("No se encontro el archivo " + ARCHIVO_CONFIGURACION + " en el classpath");
			}
			configuracion.load(archivo);
		} catch (IOException excepcion) {
			var mensajeUsuario = CatalogoMensajes.SqlServerDAOFactory.USUARIO_ERROR_PROBLEMA_CARGANDO_CONFIGURACION_CONEXION_SQL;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
		}

		return configuracion;
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		return new PaisSqlServerDAO(getConexion());
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		return new DepartamentoSqlServerDAO(getConexion());
	}

	@Override
	public CiudadDAO obtenerCiudadDAO() {
		return new CiudadSqlServerDAO(getConexion());
	}

}
