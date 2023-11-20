package co.empresa.parcial.modelo;

import java.io.Serializable;
import java.util.Date;

import co.empresa.parcial.modelo.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movimientos {
	
	public Integer serial;
	public Date fecha_mov;
	public Integer user_id;
	public Integer valor; 
	public Integer tipo;
	public String descripcion;
	
	public Movimientos(Integer serial, Date fecha_mov, Integer valor, Integer tipo, String descripcion) {
		
		this.serial = serial;
		this.fecha_mov = fecha_mov;
		this.valor = valor;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}

	public Movimientos(Integer valor, Integer tipo, String descripcion) {
		
		this.valor = valor;
		this.tipo = tipo;
		this.descripcion = descripcion;
	}
	
	
	
}
