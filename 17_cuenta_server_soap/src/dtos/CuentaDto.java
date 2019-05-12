package dtos;

import java.io.Serializable;

public class CuentaDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int numeroCuenta;

	private double saldo;

	private String tipocuenta;

	private ClienteDto[] clienteDtos;
	
	private MovimientoDto[] movimientoDtos;

	public CuentaDto() {
	}	

	public CuentaDto(int numeroCuenta, double saldo, String tipocuenta) {
		super();
		this.numeroCuenta = numeroCuenta;
		this.saldo = saldo;
		this.tipocuenta = tipocuenta;
	}

	public int getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public String getTipocuenta() {
		return tipocuenta;
	}

	public void setTipocuenta(String tipocuenta) {
		this.tipocuenta = tipocuenta;
	}

	public ClienteDto[] getClienteDtos() {
		return clienteDtos;
	}

	public void setClienteDtos(ClienteDto[] clienteDtos) {
		this.clienteDtos = clienteDtos;
	}

	public MovimientoDto[] getMovimientoDtos() {
		return movimientoDtos;
	}

	public void setMovimientoDtos(MovimientoDto[] movimientoDtos) {
		this.movimientoDtos = movimientoDtos;
	}
	
}
