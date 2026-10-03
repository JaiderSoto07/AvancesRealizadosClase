package co.edu.uco.libreriauco.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOControladorException;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOTransversalException;

public class UtilSQL {
	
private UtilSQL() {
		
	}
	
	public static boolean conexionEstaAbierta(Connection conexion) {
		try {
			return (!conexionEstaVacia(conexion)) && !conexion.isClosed();
			} catch (SQLException excepcion) {
				
				var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
				throw LibreriaUCOControladorException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
				
			}catch(Exception excepcion) {
				
				var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
				throw LibreriaUCOControladorException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);

			}
	}
	
	public static void asegurarConexionAbierta(Connection conexion) {
		if(!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = "mensaje que indique en terminos de usuario que no es posible continuar por que no es posible continuar por que la conexion no esta abierta";
			throw LibreriaUCOControladorException.crear(mensajeUsuario);
			
		}
	}
	
	public static void iniciarTransacion(Connection conexion) {

		asegurarConexionAbierta(conexion);

		if(transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}

		try {
			conexion.setAutoCommit(false);
			} catch (SQLException excepcion) {

				var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_INICIANDO_TRANSACCION_SQL;
				throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);

			}catch(Exception excepcion) {

				var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_INICIANDO_TRANSACCION_SQL;
				throw LibreriaUCOControladorException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
			}
	}

	public static void confirmarTransaccion(Connection conexion) {

		if(!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}

		try {
			conexion.commit();
			conexion.setAutoCommit(true);
			} catch (SQLException excepcion) {

				var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CONFIRMANDO_TRANSACCION_SQL;
				throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);

			}catch(Exception excepcion) {

				var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CONFIRMANDO_TRANSACCION_SQL;
				throw LibreriaUCOControladorException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
			}
	}

	public static void cancelarTransaccion(Connection conexion) {

		if(!transaccionEstaIniciada(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}

		try {
			conexion.rollback();
			conexion.setAutoCommit(true);
			} catch (SQLException excepcion) {

				var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CANCELANDO_TRANSACCION_SQL;
				throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);

			}catch(Exception excepcion) {

				var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CANCELANDO_TRANSACCION_SQL;
				throw LibreriaUCOControladorException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
			}
	}

	public static void cerrarConexion(Connection conexion) {

		if(!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL;
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
		}

		try {
			conexion.close();
			} catch (SQLException excepcion) {

				var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CERRANDO_CONEXION_SQL;
				throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);

			}catch(Exception excepcion) {

				var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_CERRANDO_CONEXION_SQL;
				throw LibreriaUCOControladorException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
			}
	}
	
	public static Boolean transaccionEstaIniciada(Connection conexion) {
		try {
			return conexionEstaAbierta(conexion) && !conexion.getAutoCommit();
			} catch (SQLException excepcion) {
				
				var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_INICIADA;
				throw LibreriaUCOTransversalException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
				
			}catch(Exception excepcion) {
				
				var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_INICIADA;
				throw LibreriaUCOControladorException.crear(mensajeUsuario, excepcion.getMessage(), excepcion);
			}
	}
	
	public static boolean conexionEstaVacia(Connection conexion) {
		
		return UtilObjeto.esNulo(conexion);
	}

}
