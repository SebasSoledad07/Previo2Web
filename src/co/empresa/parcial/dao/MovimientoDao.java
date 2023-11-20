package co.empresa.parcial.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import co.empresa.parcial.conexion.Conexion;
import co.empresa.parcial.modelo.Movimientos;

public class MovimientoDao {
private Conexion conexion;
	
	private static final String INSERT_USUARIO_SQL = "INSERT INTO bill(value,type,observation) VALUES (?,?,?);";
	private static final String DELETE_USUARIO_SQL = "DELETE FROM  bill WHERE id=?;, date_bill=?";
	private static final String UPDATE_USUARIO_SQL = "UPDATE bill SET value = ?,type = ?,observation = ? WHEREid=?;, date_bill=?";
	private static final String SELECT_USUARIO_BY_ID = "SELECT * FROM bill WHERE id=?;";
	private static final String SELECT_ALL_USUARIOS = "SELECT * FROM bill;";

	public MovimientoDao() {
		this.conexion = Conexion.getConexion();
	}

	public void insert(Movimientos movimientos)throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(INSERT_USUARIO_SQL);
			preparedStatement.setInt(1,movimientos.valor);
			preparedStatement.setInt(2,movimientos.tipo);
			preparedStatement.setString(3,movimientos.descripcion);
		}catch(SQLException e) {
			
		}
		
	}
	public void delete(int serial,Date fecha_mov)throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(DELETE_USUARIO_SQL);
			preparedStatement.setInt(1,serial);
			preparedStatement.setDate(2,fecha_mov);
		}catch(SQLException e) {
			
		}
		
	}
	
	public void update(Movimientos movimientos) throws SQLException {
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(UPDATE_USUARIO_SQL);
			preparedStatement.setInt(1,movimientos.valor);
			preparedStatement.setInt(2,movimientos.tipo);
			preparedStatement.setString(3,movimientos.descripcion);
			preparedStatement.setInt(4,movimientos.serial);
			preparedStatement.setDate(5,(Date) movimientos.fecha_mov);
		}catch(SQLException e) {
			
		}
		
	}
	public List <Movimientos> selectAll() {
		List <Movimientos> movimientos = new ArrayList();
		try {
			PreparedStatement preparedStatement = conexion.setPreparedStatement(SELECT_ALL_USUARIOS);
			ResultSet rs = conexion.query();
			while(rs.next()) {
				int serial = rs.getInt("serial");
				Date fecha_mov = rs.getDate("fecha_mov");
				Integer valor = rs.getInt("valor");
				Integer tipo = rs.getInt("tipo");
				String descripcion = rs.getString("descripcion");
				movimientos.add(new Movimientos(serial,fecha_mov,valor,tipo,descripcion));
			}
		}catch(SQLException e) {
			
		}
		
		return movimientos;
	}
	public Movimientos select(int serial, Date fecha_mov) {
		Movimientos movimientos = null;
		try {
			PreparedStatement preparedStatement =(PreparedStatement) conexion.setPreparedStatement(SELECT_USUARIO_BY_ID);
			preparedStatement.setInt(1,serial);
			preparedStatement.setDate(2,fecha_mov);
			ResultSet rs = conexion.query();
			
			while(rs.next()) {
				String user = rs.getString("user");
				Date fecha_mov1= rs.getDate("fecha_mov");
				Integer valor = rs.getInt("valor");
				Integer tipo = rs.getInt("tipo");
				String descripcion = rs.getString("descripcion");
				movimientos = new Movimientos(serial,fecha_mov1,valor,tipo,descripcion);
			}
		}catch(SQLException e) {
			
		}
		
		return movimientos;
	}
	
	
}
}
