package co.edu.uco.libreriauco.controlador;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import co.edu.uco.libreriauco.controlador.respuesta.RespuestaError;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

@RestControllerAdvice
public abstract class AbstractRestController {
	
	@ExceptionHandler (LibreriaUCOExcepcion.class)
	public ResponseEntity<RespuestaError<String>> controlarLibreriaUCOExcepcion(LibreriaUCOExcepcion excepcion){
		var respuesta = RespuestaError.crear(excepcion.getMensajeUsuario()) ;
		//logger.printException
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}
	
	@ExceptionHandler (Exception.class)
	public ResponseEntity<RespuestaError<String>> ControlarException(Exception excepcion){
		
		var mensajeRespuesta = "Se ha presentado un problema inesperado tratando de llevar a cabo la operacion deseada,por favor intente de nuevo y si el problema persiste contacte al administrador de la aplicacion y entreguele el codigo que se muestra a continuacion";
		var respuesta = RespuestaError.crear(excepcion.getMessage()) ;
		//logger.printException
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuesta);
	}

}
