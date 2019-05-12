package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idCliente;

	private String email;

	private String password;

	private int telefono;

	private String usuario;

	//bi-directional many-to-one association to Historico
	@OneToMany(mappedBy="cliente")
	private List<Historico> historicos;

	//bi-directional many-to-many association to Libro
	@ManyToMany
	@JoinTable(name="ventas",
			   joinColumns={@JoinColumn(name="idCliente",referencedColumnName="idCliente")},
			   inverseJoinColumns={@JoinColumn(name="idLibro",referencedColumnName="isbn")}
	)
	private List<Libro> libros;

	public Cliente() {
	}
	
	public Cliente(String email, String password, int telefono, String usuario) {
		super();
		this.email = email;
		this.password = password;
		this.telefono = telefono;
		this.usuario = usuario;
	}
	
	public Cliente(int idCliente, String email, String password, int telefono, String usuario) {
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

	public List<Historico> getHistoricos() {
		return this.historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	public Historico addHistorico(Historico historico) {
		getHistoricos().add(historico);
		historico.setCliente(this);

		return historico;
	}

	public Historico removeHistorico(Historico historico) {
		getHistoricos().remove(historico);
		historico.setCliente(null);

		return historico;
	}

	public List<Libro> getLibros() {
		return this.libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

}