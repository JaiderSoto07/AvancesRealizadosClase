package co.edu.uco.libreriauco.dominio;

import java.util.UUID;

import co.edu.uco.libreriauco.dominio.PaisDominio.Builder;
import co.edu.uco.libreriauco.dto.PaisDTO;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilTexto;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class DepartamentoDominio {
	
	private UUID id;
	private String nombre;
	private PaisDominio pais;
	
	public DepartamentoDominio(UUID id, String nombre, PaisDominio pais) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pais = pais;
	}

	public UUID getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}


	public PaisDominio getPais() {
		return pais;
	}
	
	public static class Builder {
		private UUID id;
		private String nombre;
		private PaisDominio pais;
		
		public Builder() {
			id = UtilUUID.obtenerValorDefecto(id);
			nombre = UtilTexto.VACIO;
			departamento = new DepartamentoDominio.Builder().Build();
		}

		public Builder id(UUID id) {
			this.id = UtilUUID.obtenerValorDefecto(id);
			return this;
		}

		public Builder nombre(String nombre) {
			this.nombre = UtilTexto.getUtilTexto().quitarEspaciosEnBlanco(nombre);
			return this;
		}
		
		public Builder pais(DepartamentoDominio departamento) {
			this.departamento = 
			return this;
		}
		
		
		//builder pais..........
		
		public PaisDominio Build() {
			return new DepartamentoDominio(this);
		}

	}

	
	
	

}
