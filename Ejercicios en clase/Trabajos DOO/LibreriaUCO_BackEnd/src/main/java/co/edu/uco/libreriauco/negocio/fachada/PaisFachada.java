package co.edu.uco.libreriauco.negocio.fachada;

import java.util.List;
import java.util.UUID;

import co.edu.uco.libreriauco.dto.PaisDTO;

public interface PaisFachada  {
	
	void registrarInformacionNuevoPais(PaisDTO datos);
	
	void modificarInformacionPaisExistente(UUID id ,PaisDTO datos);  	//pacth
	
	void DarBajaInformacionPaisExistente(UUID id);						//delete
	
	List<PaisDTO> ConsultarPorFiltro(PaisDTO filtro);
	
	List<PaisDTO> consultarTodos ();
	
	PaisDTO consultarPorID (UUID id);

}
