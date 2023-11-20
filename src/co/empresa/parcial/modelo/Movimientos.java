package co.empresa.parcial.modelo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movimientos {
	
	public Integer id;
	public Integer serial;
	public Integer user_id;
	public String movimiento;
	public int valor; 
	public int tipo;
	public String descripcion;
	
	
}
