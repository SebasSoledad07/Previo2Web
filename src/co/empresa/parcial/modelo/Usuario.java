package co.empresa.parcial.modelo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
public class Usuario implements Serializable {

	public String user;
	public String password;
	
	public String movimiento;
	public int valor; 
	
}
