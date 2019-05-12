package beans;

import java.io.Serializable;
import java.util.Date;


public class Venta implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idVEnta;

	private Date fecha;

	private int idCliente;

	private int idLibro;

	public Venta() {
	}

	public int getIdVEnta() {
		return this.idVEnta;
	}

	public void setIdVEnta(int idVEnta) {
		this.idVEnta = idVEnta;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdLibro() {
		return this.idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
	}

}