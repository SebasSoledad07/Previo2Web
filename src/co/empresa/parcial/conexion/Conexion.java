package co.empresa.parcial.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;

import co.empresa.parcial.conexion.Conexion;

public class Conexion {
	private Connection con = null;
	private PreparedStatement preparedstatement;
	private static Conexion db;
	
	private static final String url = " fanny.db.elephantsql.com"; 
	private static final String dbName = "jnvgnqqv"; 
	private static final String driver = "com.mysql.jdbc.Driver"; 
	private static final String username = "jnvgnqqv"; 
	private static final String password = "aTo0Yykrx9nCmRavmYFsikv_usQtfOen"; 
}
