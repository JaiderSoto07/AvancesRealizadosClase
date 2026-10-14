package co.edu.uco.libreriauco.controlador.respuesta;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilFecha;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

class Respuesta<D> {

	private LocalDateTime timestamp;
	private String correlationID;
	private List<String> mensajes;
	private List<D> datos;
	private EstadoRespuesta estado;
	
	protected Respuesta(List<String> mensajes, List<D> datos ,  EstadoRespuesta estado){
		
		setMensajes(mensajes);
		setDatos(datos);
		setEstado(estado);
		timestamp = UtilFecha.obtenerFechaHoraActual();
		correlationID = UtilUUID.generarComoTexto();
	}

	private void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	private void setMensajes(List<String> mensajes) {
		this.mensajes = UtilObjeto.obtenerValorDefectoSiNulo(mensajes, new ArrayList<String>());
	}

	private void setDatos(List<D> datos) {
		this.datos = UtilObjeto.obtenerValorDefectoSiNulo(datos, new ArrayList<D>());
	}

	private void setEstado(EstadoRespuesta estado) {
		this.estado = UtilObjeto.obtenerValorDefectoSiNulo(estado, EstadoRespuesta.ERROR);
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public List<String> getMensajes() {
		return mensajes;
	}

	public List<D> getDatos() {
		return datos;
	}

	public EstadoRespuesta getEstado() {
		return estado;
	}
	
	public String getCorrelationID() {
		return correlationID;
	}
	
	
	
	
	
	
}
