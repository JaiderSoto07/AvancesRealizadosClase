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
		public static final String USUARIO_ERROR_PROBLEMA_INICIANDO_TRANSACCION_SQL = "se ha presentado un problema tratando de iniciar la transaccion contra la fuente de informacion en la cual se hiba a tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CONFIRMAR_TRANSACCION_SQL = "no es posible confirmar la transaccion por que la conexion no esta abierta o porque no hay una transaccion iniciada sobre la cual llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONFIRMANDO_TRANSACCION_SQL = "se ha presentado un problema tratando de confirmar la transaccion contra la fuente de informacion en la cual se hiba a tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CANCELAR_TRANSACCION_SQL = "no es posible cancelar la transaccion por que la conexion no esta abierta o porque no hay una transaccion iniciada sobre la cual llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CANCELANDO_TRANSACCION_SQL = "se ha presentado un problema tratando de cancelar la transaccion contra la fuente de informacion en la cual se hiba a tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_NO_ES_POSIBLE_CERRAR_CONEXION_SQL = "no es posible cerrar la conexion por que esta ya se encuentra cerrada o es invalida. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CERRANDO_CONEXION_SQL = "se ha presentado un problema tratando de cerrar la conexion contra la fuente de informacion en la cual se hiba a tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador";
	}

	public static class SqlServerDAOFactory {

		private SqlServerDAOFactory() {

		}

		public static final String USUARIO_ERROR_PROBLEMA_CARGANDO_CONFIGURACION_CONEXION_SQL = "se ha presentado un problema tratando de cargar la configuracion necesaria para conectarse con la fuente de informacion. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_ABRIENDO_CONEXION_SQL = "se ha presentado un problema tratando de abrir la conexion contra la fuente de informacion en la cual se hiba a tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ABRIENDO_CONEXION_SQL = "se ha presentado un problema NO CONTROLADO tratando de abrir la conexion contra la fuente de informacion en la cual se hiba a tratar de llevar a cabo la operacion deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador";
	}

	public static class PaisSqlServerDAO {

		private PaisSqlServerDAO() {

		}

		public static final String USUARIO_ERROR_PROBLEMA_CREANDO_PAIS = "se ha presentado un problema tratando de registrar la informacion del nuevo pais. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CREANDO_PAIS = "se ha presentado un problema NO CONTROLADO tratando de registrar la informacion del nuevo pais. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAIS_POR_ID = "se ha presentado un problema tratando de consultar la informacion del pais deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAIS_POR_ID = "se ha presentado un problema NO CONTROLADO tratando de consultar la informacion del pais deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_PAISES_POR_FILTRO = "se ha presentado un problema tratando de consultar la informacion de los paises que cumplen con el filtro deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_PAISES_POR_FILTRO = "se ha presentado un problema NO CONTROLADO tratando de consultar la informacion de los paises que cumplen con el filtro deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODOS_LOS_PAISES = "se ha presentado un problema tratando de consultar la informacion de todos los paises. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TODOS_LOS_PAISES = "se ha presentado un problema NO CONTROLADO tratando de consultar la informacion de todos los paises. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_ACTUALIZANDO_PAIS = "se ha presentado un problema tratando de actualizar la informacion del pais deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ACTUALIZANDO_PAIS = "se ha presentado un problema NO CONTROLADO tratando de actualizar la informacion del pais deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_ELIMINANDO_PAIS = "se ha presentado un problema tratando de eliminar la informacion del pais deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_ELIMINANDO_PAIS = "se ha presentado un problema NO CONTROLADO tratando de eliminar la informacion del pais deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
	}

	public static class DepartamentoSqlServerDAO {

		private DepartamentoSqlServerDAO() {

		}

		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_DEPARTAMENTO_POR_ID = "se ha presentado un problema tratando de consultar la informacion del departamento deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEPARTAMENTO_POR_ID = "se ha presentado un problema NO CONTROLADO tratando de consultar la informacion del departamento deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_DEPARTAMENTOS_POR_FILTRO = "se ha presentado un problema tratando de consultar la informacion de los departamentos que cumplen con el filtro deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_DEPARTAMENTOS_POR_FILTRO = "se ha presentado un problema NO CONTROLADO tratando de consultar la informacion de los departamentos que cumplen con el filtro deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODOS_LOS_DEPARTAMENTOS = "se ha presentado un problema tratando de consultar la informacion de todos los departamentos. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TODOS_LOS_DEPARTAMENTOS = "se ha presentado un problema NO CONTROLADO tratando de consultar la informacion de todos los departamentos. Por favor intente de nuevo y si el problema persiste contacte al administrador";
	}

	public static class CiudadSqlServerDAO {

		private CiudadSqlServerDAO() {

		}

		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_CIUDAD_POR_ID = "se ha presentado un problema tratando de consultar la informacion de la ciudad deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDAD_POR_ID = "se ha presentado un problema NO CONTROLADO tratando de consultar la informacion de la ciudad deseada. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_CIUDADES_POR_FILTRO = "se ha presentado un problema tratando de consultar la informacion de las ciudades que cumplen con el filtro deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_CIUDADES_POR_FILTRO = "se ha presentado un problema NO CONTROLADO tratando de consultar la informacion de las ciudades que cumplen con el filtro deseado. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_CONSULTANDO_TODAS_LAS_CIUDADES = "se ha presentado un problema tratando de consultar la informacion de todas las ciudades. Por favor intente de nuevo y si el problema persiste contacte al administrador";
		public static final String USUARIO_ERROR_PROBLEMA_NO_CONTROLADO_CONSULTANDO_TODAS_LAS_CIUDADES = "se ha presentado un problema NO CONTROLADO tratando de consultar la informacion de todas las ciudades. Por favor intente de nuevo y si el problema persiste contacte al administrador";
	}
	
	public static class  PaisNegocioImpl{
		private PaisNegocioImpl() {
			
		}
		
		
		public static final String PAIS_YA_EXISTE_CON_EL_MISMO_NOMBRE_DE_PAIS_A_CREAR = "ya existe otro pais con el cual se desea crear el pais deseado";
		
		public static  final String NOMBRE_PAIS_OBLIGATORIO  = "El nombre del pais es obligatorio para llevar a cabo la operacion deseada";
		public static final String LONGITUD_NOMBRE_PAIS_NO_VALIDA = "La longitud del pais no es válida. Asegurese que esté entre 1 y 50";
		public static final String FORMATO_NOMBRE_PAIS_NO_VALIDO = "El formato del pais no es valido asegurese de copiarlo de forma correcta, qe tenga letras de la a a la z, mayusculas o minusculas y espacios";
	}
	}
