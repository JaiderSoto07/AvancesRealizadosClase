package co.edu.uco.libreriauco.negocio.negocio.assembler.impl;

import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.negocio.negocio.assembler.EntidadAssembler;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;

public class PaisEntidadEAssembler implements EntidadAssembler<PaisDominio, PaisEntidad>{
	
	
	private static final EntidadAssembler<PaisDominio, PaisEntidad> instancia = new PaisEntidadEAssembler();
	
	private PaisEntidadEAssembler() {
		
	}
	
	public static EntidadAssembler<PaisDominio, PaisEntidad> getIntance(){
		return instancia;
	}

	@Override
	public PaisEntidad convertirAEntidad(PaisDominio dominio) {
		var dominioTmpo = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new PaisDominio.Builder().Build());
		return new PaisEntidad(dominioTmpo.getId() , dominioTmpo.getNombre());
	}

	@Override
	public PaisDominio convertirADominio(PaisEntidad entidad) {
		var entidadTmP = UtilObjeto.obtenerValorDefectoSiNulo(entidad, new PaisEntidad());
		return new PaisDominio.Builder().id(entidadTmP.getId()).nombre(entidadTmP.getNombre()).Build();
	}

}
