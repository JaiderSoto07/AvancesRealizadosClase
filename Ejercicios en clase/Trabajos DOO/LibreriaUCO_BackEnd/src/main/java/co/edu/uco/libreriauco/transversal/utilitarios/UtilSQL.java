package co.edu.uco.libreriauco.transversal.utilitarios;

import java.sql.Connection;
import java.sql.SQLException;

import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOTransversalException;

public class UtilSQL {
	
	private UtilSQL() {
		
	}
	
	public static boolean conexionEstaAbierta(Connection conexion) {
		try {
			return(!conexionEstaVacia(conexion) && !conexion.isClosed());
		}	catch(SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			
			throw LibreriaUCOTransversalException.crear(mensajeUsuario , excepcion.getMessage(), excepcion );
		
			
			
		} catch (Exception excepxion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLANDO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA;
			
			throw LibreriaUCOTransversalException.crear(mensajeUsuario , excepxion.getMessage(), excepxion );
		}
	}
	
	public static void iniciarTransaccion(Connection conexion) {
		
		if (transaccionEstaIniciada(conexion)) {
			var mensajeUsuario=CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw  LibreriaUCOTransversalException.crear(mensajeUsuario);
		}
		
		//Tarea que se tenia de como iniciar la transaccion
		
	}
	
	public static void confirmarTransaccion(Connection conexion) {
		if (transaccionEstaIniciada(conexion)) {
			var mensajeUsuario=CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw  LibreriaUCOTransversalException.crear(mensajeUsuario);
		
	}
		
		//Tarea que se tenia de como confirmar la transaccion
		
	}
	
	
	public static void cancelarTransaccion(Connection conexion) {
		
		if (transaccionEstaIniciada(conexion)) {
			var mensajeUsuario=CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw  LibreriaUCOTransversalException.crear(mensajeUsuario);
			
	}
		
		//Tarea que se tenia de como cancelar la transaccion
		
	}
	
	public static void cerrarConexion(Connection conexion) {
		
		if (transaccionEstaIniciada(conexion)) {
			var mensajeUsuario=CatalogoMensajes.UtilSQL.USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL;
			throw  LibreriaUCOTransversalException.crear(mensajeUsuario);
			
	}
		//Tarea que se tenia de como cerrar la transaccion
	}
	
	
	public static void asegurarConexionAbierta(Connection conexion) {
		if(!conexionEstaAbierta(conexion)) {
			var mensajeUsuario = "";
			throw LibreriaUCOTransversalException.crear(mensajeUsuario);
			
		}
	}
	
	
	
	
	public static boolean transaccionEstaIniciada(Connection conexion) {
		
		try {return(!conexionEstaVacia(conexion) && !conexion.isClosed());
		}	catch(SQLException excepcion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_INICIADA;
			
			throw LibreriaUCOTransversalException.crear(mensajeUsuario , excepcion.getMessage(), excepcion );
		
			
			
		} catch (Exception excepxion) {
			var mensajeUsuario = CatalogoMensajes.UtilSQL.USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_INICIADA;
			
			throw LibreriaUCOTransversalException.crear(mensajeUsuario , excepxion.getMessage(), excepxion );
		}
	
		return conexionEstaAbierta(conexion) && !conexion.getAutoCommit();
		
	}
	
	public static boolean conexionEstaVacia(Connection conexion) {
		
		return UtilObjeto.esNulo(conexion);
		
	}

}
