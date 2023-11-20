package co.empresa.parcial.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	
	public Conexion() {
		try {
			Class.forName(driver).newInstance();
			con =(Connection)DriverManager.getConnection(url+dbName,username,password);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			//TODO Auto-generado catch-block
			e.printStackTrace();
		}catch (Exception e){
			//TODO Auto-generado catch-block
			e.printStackTrace();
		}
		
		
	}
	
	public void cerrarConexion(){
		try {
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static Conexion getConexion() {
		if(db==null) {
			db = new Conexion();
		}
		return db;
	}
	
	public ResultSet query()throws SQLException{
		ResultSet res = preparedstatement.executeQuery();
		return res;
	}
	
	public int execute()throws SQLException{
		int result = preparedstatement.executeUpdate();
		return result;
		
	}
	
	public Connection getCon() {
		return this.con;
	}
	
	public PreparedStatement setPreparedStatement(String sql) throws SQLException{
		this.preparedstatement = con.prepareStatement(sql);
		return this.preparedstatement;
		
		
	}
	

}
	
