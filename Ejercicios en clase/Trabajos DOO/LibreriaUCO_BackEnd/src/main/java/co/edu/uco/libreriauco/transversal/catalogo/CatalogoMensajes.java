package co.edu.uco.libreriauco.transversal.catalogo;

public class CatalogoMensajes {
	
	private CatalogoMensajes() {
		
	}
	
	
	public static class UtilSQL {
		
		private UtilSQL() {
			
		}
		
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "se ha presentado un problema tratando de validar si la conexion contra la funete de informacion en la cual se hiba a tratar de llevar a cabo la operacion deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_ABIERTA = "se ha presentado un problema NO CONTROLADO tratando de validar si la conexion contra la fuente de informacion en la cual se hiba a tratar de llevar a cabo la operacion deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_VALIDANDO_SI_CONEXION_SQL_ESTA_INICIADA = "se ha presentado un problema tratando de validar si la conexion contra la fuente de informacion estaba en un estado consistente al tratar de llevar a cabo la operacion deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_VALIDANDO_SI_CONEXION_SQL_ESTA_INICIADA = "se ha presentado un problema NO CONTROLADO tratando de validar si la conexion contra la funete de informacion estaba en un estado consistente al tratar de llevar a cabo la operacion deseada estaba o no abierta. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_INICIAR_TRANSACCION_SQL = "no e sposible continuar con la conexion por que la fuente se encuentra en un estado inconsistente por que esta cerrada , esta vacia o porque la transaccion ya fue inicada. Por favor intente de nuevo y si el problema persiste contacte al administrador ";
	}

}
