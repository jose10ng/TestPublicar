package beans;

import java.io.Serializable;

public class Historico implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idHistorico;

	private double cantidad;

	private Cliente cliente;

	public Historico() {
	}
	
	public int getIdHistorico() {
		return this.idHistorico;
	}

	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}

	public double getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}