package co.edu.uco.libreriauco.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import co.edu.uco.libreriauco.controlador.respuesta.RespuestaError;
import co.edu.uco.libreriauco.transversal.catalogo.CatalogoMensajes;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilLogger;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

@RestControllerAdvice
public abstract class AbstractRestController {

	private static final UtilLogger logger = UtilLogger.obtenerLogger(AbstractRestController.class);

	@ExceptionHandler (LibreriaUCOExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarLibreriaUCOExcepcion(LibreriaUCOExcepcion excepcion){
		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario()) ;
		logger.printException(excepcion);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}
	
	@ExceptionHandler (NoResourceFoundException.class)
	public ResponseEntity<RespuestaError<String>> ControlarNoResourceFoundException(NoResourceFoundException excepcion){
		
		var mensajeRespuesta = UtilTexto.getUtilTexto().concatenar(CatalogoMensajes.AbstractRestController.USUARIO_ERROR_RECURSO_NO_EXISTE, excepcion.getResourcePath(), " por el metodo ", excepcion.getHttpMethod());
		var respuesta = RespuestaError.crear(mensajeRespuesta) ;
		logger.printException(excepcion);

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(respuesta);
	}


	@ExceptionHandler (Exception.class)
	public ResponseEntity<RespuestaError<String>> ControlarException(Exception excepcion){
		
		var mensajeRespuesta = CatalogoMensajes.AbstractRestController.USUARIO_ERROR_PROBLEMA_INESPERADO_EN_CONTROLADOR;
		var respuesta = RespuestaError.crear(mensajeRespuesta) ;
		logger.printException(excepcion);
		
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuesta);
	}

}
