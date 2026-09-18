package co.edu.uco.libreriauco.dao.factoria.impl;

import java.sql.Connection;

import co.edu.uco.libreriauco.dao.datos.entidad.DepartamentoDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.PaisDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.DepartamentoSqlServerDAO;
import co.edu.uco.libreriauco.dao.datos.entidad.sqlserver.PaisSqlServerDAO;
import co.edu.uco.libreriauco.dao.factoria.DAOFactory;

public class SqlServerDAOFactory extends DAOFactory {

	@Override
	protected void abrirConexion() {
		// Tarea: ¿Como abrir una conexion con SQL Server desde Java?
		Connection conexion = null;
		setConexion(conexion);
		
		
	}

	@Override
	public PaisDAO obtenerPaisDAO() {
		// TODO Auto-generated method stub
		return new PaisSqlServerDAO(getConexion());
	}

	@Override
	public DepartamentoDAO obtenerDepartamentoDAO() {
		// TODO Auto-generated method stub
		return new DepartamentoSqlServerDAO(getConexion());
	}

}
