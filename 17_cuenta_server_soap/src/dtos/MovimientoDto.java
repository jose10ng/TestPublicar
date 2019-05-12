package dtos;

import java.io.Serializable;
import java.util.Date;

public class MovimientoDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int idMovimiento;
	private double cantidad;
	private Date fecha;
	private String operacion;
	private CuentaDto cuentaDto;
	private String cuentaRecibeTransf;
	
		
	public MovimientoDto() {
	}	
	
	public MovimientoDto(double cantidad, Date fecha, String operacion, CuentaDto cuentaDto, String cuentaRecibeTransf) {
		super();
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.operacion = operacion;
		this.cuentaDto = cuentaDto;
		this.cuentaRecibeTransf = cuentaRecibeTransf;
	}

	public MovimientoDto(int idMovimiento, double cantidad, Date fecha, String operacion, CuentaDto cuentaDto,
			String cuentaRecibeTransf) {
		super();
		this.idMovimiento = idMovimiento;
		this.cantidad = cantidad;
		this.fecha = fecha;
		this.operacion = operacion;
		this.cuentaDto = cuentaDto;
		this.cuentaRecibeTransf = cuentaRecibeTransf;
	}

	public int getIdMovimiento() {
		return idMovimiento;
	}

	public void setIdMovimiento(int idMovimiento) {
		this.idMovimiento = idMovimiento;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(double cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getOperacion() {
		return operacion;
	}

	public void setOperacion(String operacion) {
		this.operacion = operacion;
	}

	public CuentaDto getCuentaDto() {
		return cuentaDto;
	}

	public void setCuentaDto(CuentaDto cuentaDto) {
		this.cuentaDto = cuentaDto;
	}

	public String getCuentaRecibeTransf() {
		return cuentaRecibeTransf;
	}

	public void setCuentaRecibeTransf(String cuentaRecibeTransf) {
		this.cuentaRecibeTransf = cuentaRecibeTransf;
	}
	
}
