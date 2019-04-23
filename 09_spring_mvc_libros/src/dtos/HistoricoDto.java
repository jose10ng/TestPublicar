package dtos;

import java.io.Serializable;


public class HistoricoDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idHistorico;

	private double cantidad;

	private ClienteDto cliente;

	public HistoricoDto() {
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

	public ClienteDto getCliente() {
		return this.cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}

}