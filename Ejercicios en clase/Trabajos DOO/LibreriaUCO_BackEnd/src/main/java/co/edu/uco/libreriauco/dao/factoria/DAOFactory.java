package co.edu.uco.libreriauco.dao.factoria;

import java.sql.Connection;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;

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
		//Tarea : ¿Como se cierra la conexion de forma segura?
	}
	
	public void iniciarTransaccion() {
		//Tarea : ¿Como se inicia una transaccion de forma segura?
	}
	
	public void confirmarTransaccion() {
		//Tarea : ¿Como se confirmar una transaccion de forma segura?
	}
	
	public void cancelarTransaccion() {
		//Tarea : ¿Como se cancelar una transaccion de forma segura?
	}
	
	public abstract PaisDAO obtenerPaisDAO();
	
	public abstract DepartamentoDAO obtenerDepartamentoDAO();
	
	
	
	

}
