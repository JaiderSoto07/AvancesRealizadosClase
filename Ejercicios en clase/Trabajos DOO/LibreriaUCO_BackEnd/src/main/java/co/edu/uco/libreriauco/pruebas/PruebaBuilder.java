package co.edu.uco.libreriauco.pruebas;

import co.edu.uco.libreriauco.dominio.PaisDominio;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PruebaBuilder {
	
	public static void main (String[] args) {
		PaisDominio dominioPaisUno = new PaisDominio.Builder().Build();
		PaisDominio dominiopaisconID= new PaisDominio.Builder().id(UtilUUID.generar()).Build();
		PaisDominio dominiopaisConNombre = new PaisDominio.Builder().nombre("C").Build();
		PaisDominio dominioPaisCompleto = new PaisDominio.Builder()
				.nombre("C")
				.id(UtilUUID.generar())
				.Build();
	}

}
