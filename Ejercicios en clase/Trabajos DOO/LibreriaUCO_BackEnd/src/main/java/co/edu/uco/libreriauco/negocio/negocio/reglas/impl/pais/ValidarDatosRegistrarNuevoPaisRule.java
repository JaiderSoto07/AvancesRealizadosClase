package co.edu.uco.libreriauco.negocio.negocio.reglas.impl.pais;

import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.negocio.negocio.reglas.Rule;

public class ValidarDatosRegistrarNuevoPaisRule implements Rule<PaisDominio> {
	
	
	private static final Rule<PaisDominio> intancia = new ValidarDatosRegistrarNuevoPaisRule();
	
	private ValidarDatosRegistrarNuevoPaisRule() {
		
	}
	
	public static final Rule<PaisDominio> obtenerIntancia(){
		return intancia;
	}
	

	@Override
	public void ejecutar(PaisDominio... datos) {
		var dominio = datos[0];
		
		AsegurarNombrePaisValidoRule.obtenerIntancia().ejecutar(dominio.getNombre());
		
	}

}
