package co.edu.uco.libreriauco.negocio.fachada.assembler.impl;

import java.util.ArrayList;
import java.util.List;
import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.dto.PaisDTO;
import co.edu.uco.libreriauco.negocio.fachada.assembler.DTOAssembler;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilObjeto;


public class PaisDToAssembler implements DTOAssembler<PaisDominio, PaisDTO> {

	private static final DTOAssembler<PaisDominio, PaisDTO> instancia = new PaisDToAssembler();

	private PaisDToAssembler() {

	}

	public static DTOAssembler<PaisDominio, PaisDTO> getIntance(){
		return instancia;
	}


	@Override
	public PaisDTO convertirADTO(PaisDominio dominio) {
		var dominioTmp = UtilObjeto.obtenerValorDefectoSiNulo(dominio, new PaisDominio.Builder().Build());
		var dto = new PaisDTO();
		dto.setId(dominioTmp.getId());
		dto.setNombre(dominioTmp.getNombre());
		return dto;
	}

	@Override
	public PaisDominio convertirADominio(PaisDTO dto) {
		var dtoTmp = UtilObjeto.obtenerValorDefectoSiNulo(dto, new PaisDTO());
		return new PaisDominio.Builder().id(dtoTmp.getId()).nombre(dtoTmp.getNombre()).Build();
	}

	@Override
	public List<PaisDTO> convertirADTO(List<PaisDominio> listadominios) {
		var listaTmp = UtilObjeto.obtenerValorDefectoSiNulo(listadominios, new ArrayList<PaisDominio>());
		return listaTmp.stream().map(this::convertirADTO).toList();
	}


}
