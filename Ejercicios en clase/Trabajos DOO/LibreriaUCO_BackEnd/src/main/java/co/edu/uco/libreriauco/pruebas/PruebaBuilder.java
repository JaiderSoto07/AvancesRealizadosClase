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

		System.out.println("Pais uno: id=" + dominioPaisUno.getId() + ", nombre=" + dominioPaisUno.getNombre());
		System.out.println("Pais con id: id=" + dominiopaisconID.getId() + ", nombre=" + dominiopaisconID.getNombre());
		System.out.println("Pais con nombre: id=" + dominiopaisConNombre.getId() + ", nombre=" + dominiopaisConNombre.getNombre());
		System.out.println("Pais completo: id=" + dominioPaisCompleto.getId() + ", nombre=" + dominioPaisCompleto.getNombre());
	}

}
