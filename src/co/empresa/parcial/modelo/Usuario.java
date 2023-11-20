package co.empresa.parcial.modelo;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

	public Integer id;
	public String user;
	public String password;
	public String email;
	
	
	
}
