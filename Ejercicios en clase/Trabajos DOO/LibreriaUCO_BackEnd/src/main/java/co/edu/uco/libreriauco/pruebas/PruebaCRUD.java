package co.edu.uco.libreriauco.pruebas;

import co.edu.uco.libreriauco.dao.factoria.impl.SqlServerDAOFactory;
import co.edu.uco.libreriauco.entidad.CiudadEntidad;
import co.edu.uco.libreriauco.entidad.DepartamentoEntidad;
import co.edu.uco.libreriauco.entidad.PaisEntidad;
import co.edu.uco.libreriauco.transversal.excepciones.LibreriaUCOExcepcion;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilUUID;

public class PruebaCRUD {

	public static void main(String[] args) {
		var factoria = new SqlServerDAOFactory();

		try {
			probarPais(factoria);
			probarDepartamento(factoria);
			probarCiudad(factoria);
		} catch (LibreriaUCOExcepcion excepcion) {
			System.out.println("ERROR (" + excepcion.getCapa() + "): " + excepcion.getMensajeUsuario());
			System.out.println("Detalle tecnico: " + excepcion.getMensajeTecnico());
		} finally {
			factoria.cerrarConexion();
		}
	}

	private static void probarPais(SqlServerDAOFactory factoria) {
		System.out.println("===== PAIS: CRUD completo =====");
		var paisDAO = factoria.obtenerPaisDAO();
		var id = UtilUUID.generar();

		factoria.iniciarTransaccion();
		paisDAO.crear(new PaisEntidad.Builder().id(id).nombre("Pais de prueba").Build());
		factoria.confirmarTransaccion();
		System.out.println("Creado:          " + paisDAO.consultarPorId(id).getNombre());

		factoria.iniciarTransaccion();
		paisDAO.actualizar(id, new PaisEntidad.Builder().nombre("Pais de prueba actualizado").Build());
		factoria.confirmarTransaccion();
		System.out.println("Actualizado:     " + paisDAO.consultarPorId(id).getNombre());

		var filtro = new PaisEntidad.Builder().nombre("Pais de prueba actualizado").Build();
		System.out.println("Por filtro:      " + paisDAO.consultarPorFiltro(filtro).size() + " resultado(s)");

		System.out.print("Todos:           ");
		paisDAO.consultarTodos().forEach(pais -> System.out.print(pais.getNombre() + " | "));
		System.out.println();

		factoria.iniciarTransaccion();
		paisDAO.eliminar(id);
		factoria.confirmarTransaccion();
		var eliminado = paisDAO.consultarPorId(id);
		System.out.println("Eliminado:       " + UtilUUID.UUID_DEFECTO.equals(eliminado.getId()));
	}

	private static void probarDepartamento(SqlServerDAOFactory factoria) {
		System.out.println("===== DEPARTAMENTO: consultas =====");
		var departamentoDAO = factoria.obtenerDepartamentoDAO();

		var todos = departamentoDAO.consultarTodos();
		todos.forEach(departamento -> System.out.println("Todos:           "
				+ departamento.getNombre() + " (" + departamento.getPais().getNombre() + ")"));

		if (!todos.isEmpty()) {
			var primero = todos.get(0);
			System.out.println("Por id:          " + departamentoDAO.consultarPorId(primero.getId()).getNombre());

			var filtro = new DepartamentoEntidad.Builder().pais(primero.getPais()).Build();
			System.out.println("Por filtro pais: " + departamentoDAO.consultarPorFiltro(filtro).size() + " resultado(s)");
		}
	}

	private static void probarCiudad(SqlServerDAOFactory factoria) {
		System.out.println("===== CIUDAD: consultas =====");
		var ciudadDAO = factoria.obtenerCiudadDAO();

		var todas = ciudadDAO.consultarTodos();
		todas.forEach(ciudad -> System.out.println("Todas:           " + ciudad.getNombre() + " ("
				+ ciudad.getDepartamento().getNombre() + ", " + ciudad.getDepartamento().getPais().getNombre() + ")"));

		if (!todas.isEmpty()) {
			var primera = todas.get(0);
			System.out.println("Por id:          " + ciudadDAO.consultarPorId(primera.getId()).getNombre());

			var filtro = new CiudadEntidad.Builder().departamento(primera.getDepartamento()).Build();
			System.out.println("Por filtro dpto: " + ciudadDAO.consultarPorFiltro(filtro).size() + " resultado(s)");
		}
	}

}
