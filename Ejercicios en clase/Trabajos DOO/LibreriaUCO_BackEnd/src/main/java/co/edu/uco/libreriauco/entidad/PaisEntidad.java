package co.edu.uco.libreriauco.entidad;

import java.util.UUID;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PaisEntidad {

	private UUID id;
	private String nombre;

	private PaisEntidad(UUID id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	private PaisEntidad(Builder builder) {
		this.id = builder.id;
		this.nombre = builder.nombre;
	}
	

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public static class Builder {
		private UUID id;
		private String nombre;
		
		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
			return this;
		}
		
		public PaisEntidad Build() {
			return new PaisEntidad(this);
		}

	}
	

}
