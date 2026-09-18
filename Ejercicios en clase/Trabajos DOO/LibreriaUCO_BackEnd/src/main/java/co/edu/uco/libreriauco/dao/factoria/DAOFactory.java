package co.edu.uco.libreriauco.dao.factoria;

import java.sql.Connection;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import co.edu.uco.libreriauco.transversal.utilitarios.UtilSQL;

public abstract class DAOFactory {
	
	private Connection conexion;
	
	protected DAOFactory () {
		abrirConexion();
	}

	protected Connection getConexion() {
		return conexion;
	}

	protected void setConexion(Connection conexion) {
		//Tarea:Asegurar que la conexion sea abierta y sea valida
		this.conexion = conexion;
	}
	
	protected abstract void abrirConexion();
	
	public void cerrarConexion() {
		UtilSQL.cerrarConexion(conexion);
	}
	
	public void iniciarTransaccion() {
		UtilSQL.iniciarTransacion(conexion);
	}
	
	public void confirmarTransaccion() {
		UtilSQL.confirmarTransaccion(conexion);
	}
	
	public void cancelarTransaccion() {
		UtilSQL.cancelarTransaccion(conexion);
	}
	
	public PaisDAO obtenerPaisDAO() {
		return new PaisSqlServerDAO(getConexion());
	}
	
	public DepartamentoDAO obtenerDepartamentoDAO() {
		return new DepartamentoSqlServerDAO(getConexion());
	}
	
	
	
	

}
