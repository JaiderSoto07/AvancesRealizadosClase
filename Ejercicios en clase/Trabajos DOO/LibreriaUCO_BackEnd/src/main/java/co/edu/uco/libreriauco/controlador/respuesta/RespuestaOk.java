package co.edu.uco.libreriauco.controlador.respuesta;

import java.util.List;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;

public class RespuestaOk<D> extends Respuesta<D> {

	protected RespuestaOk(List<String> mensajes, List<D> datos) {
		super(mensajes, datos, EstadoRespuesta.OK);
	}
	
	
	
	
	public static <D> RespuestaOk<D> crear(List<String> mensajes, List<D> datos){
		return new RespuestaOk<>(mensajes,datos);
	}
	
	public static <D> RespuestaOk<D> crear(String mensajes){
		var mensajeFormateado = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(mensajes);
		return new RespuestaOk<>(List.of(mensajeFormateado), List.of());
	}
	
	public static <D> RespuestaOk<D> crear(List<D> datos){
		return new RespuestaOk<>(List.of(),datos);
	}
	
	public static <D> RespuestaOk<D> crear(D dato){
		return new RespuestaOk<>(List.of(),List.of(dato));
	}

	public static <D> RespuestaOk<D> crear(){
		return new RespuestaOk<>(List.of(),List.of());
	}
}
