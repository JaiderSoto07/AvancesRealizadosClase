package co.edu.uco.libreriauco.pruebas;

import co.edu.uco.libreriauco.dao.factoria.impl.SqlServerDAOFactory;

public class PruebaConexion {

	public static void main(String[] args) {
		var factoria = new SqlServerDAOFactory();
		System.out.println("Conexion con SQL Server abierta correctamente");

		factoria.obtenerPaisDAO();
		System.out.println("PaisDAO creado con la conexion abierta");

		factoria.cerrarConexion();
		System.out.println("Conexion cerrada correctamente");
	}

}
