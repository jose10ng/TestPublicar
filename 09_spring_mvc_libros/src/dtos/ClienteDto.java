package dtos;

import java.io.Serializable;

public class ClienteDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idCliente;

	private String email;

	private String password;

	private int telefono;

	private String usuario;

	public ClienteDto() {
	}
	
	public ClienteDto(String email, String password, int telefono, String usuario) {
		super();
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.usuario = usuario;
	}
	
	public ClienteDto(int idCliente, String email, String password, int telefono, String usuario) {
		super();
		this.idCliente = idCliente;
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.usuario = usuario;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTelefono() {
		return this.telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return this.usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}