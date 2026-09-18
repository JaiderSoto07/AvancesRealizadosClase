package co.edu.uco.libreriauco.dao.datos.entidad;

import java.sql.Connection;

import co.edu.uco.libreriauco.transversal.utilitarios.UtilSQL;

public abstract class SqlDAO {
	
	private Connection conexion;
	
	protected SqlDAO(Connection conexion) {
		
		setConexion(conexion);
		
	}
	
	private void setConexion (Connection conexion) {
		this.conexion = conexion;
	}
	
	private void getConexion(Connection conexion) {
		UtilSQL.asegurarConexionAbierta(conexion);
		this.conexion=conexion;
	}

}
