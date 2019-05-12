package utiliades;

import dtos.ClienteDto;
import dtos.CuentaDto;
import dtos.MovimientoDto;
import entidades.Cliente;
import entidades.Cuenta;
import entidades.Movimiento;

public class Herramientas {
	/*
	public static String jsonCuentaDtos(List<Cuenta> cuentas) {
		JSONArray cuentaDtos=new JSONArray();
		cuentas.forEach(c->{
			JSONObject obj=new JSONObject();
			obj.put("numero",c.getNumeroCuenta());
			obj.put("saldo",c.getSaldo());
			obj.put("tipo",c.getTipocuenta());
			cuentaDtos.add(obj);
		});
		return JSONValue.toJSONString(cuentaDtos);
	}

	public static String jsonMovimientoDtos(List<Movimiento> movimientos) {
		JSONArray movimientoDtos=new JSONArray();
		movimientos.forEach(m->{
			JSONObject obj=new JSONObject();
			obj.put("cantidad",m.getCantidad());
			obj.put("numeroCuenta",m.getCuenta().getNumeroCuenta());
			obj.put("cuentaRecibe",m.getCuentaRecibeTransf());
			obj.put("fecha",m.getFecha());
			obj.put("idMov",m.getIdMovimiento());
			obj.put("operacion",m.getOperacion());
			movimientoDtos.add(obj);
		});
		return JSONValue.toJSONString(movimientoDtos);
	}

	public static String jsonClienteDtos(List<Cliente> clientes) {
		JSONArray clienteDtos=new JSONArray();
		clientes.forEach(cl->{
			JSONObject obj=new JSONObject();
			obj.put("direccion",cl.getDireccion());
			obj.put("dni",cl.getDni());
			obj.put("nombre",cl.getNombre());
			obj.put("telefono",cl.getTelefono());
			clienteDtos.add(obj);
		});
		return JSONValue.toJSONString(clienteDtos);
	}*/
	
	public static CuentaDto obtenerDto(Cuenta cuenta) {
		CuentaDto cuentaDto=new CuentaDto();
		//cuentaDto.setClienteDtos(cuenta.getClientes().stream().map(c->obtenerDto(c)).toArray(n->new ClienteDto[n]));
		//cuentaDto.setMovimientoDtos(cuenta.getMovimientos().stream().map(m->obtenerDto(m)).toArray(n->new MovimientoDto[n]));
		cuentaDto.setNumeroCuenta(cuenta.getNumeroCuenta());
		cuentaDto.setSaldo(cuenta.getSaldo());
		cuentaDto.setTipocuenta(cuenta.getTipocuenta());
		return cuentaDto;
	}
	
	public static MovimientoDto obtenerDto(Movimiento movi) {
		MovimientoDto movimientoDto=new MovimientoDto();
		movimientoDto.setCantidad(movi.getCantidad());
		movimientoDto.setCuentaDto(obtenerDto(movi.getCuenta()));
		movimientoDto.setCuentaRecibeTransf(movi.getCuentaRecibeTransf());
		movimientoDto.setFecha(movi.getFecha());
		movimientoDto.setIdMovimiento(movi.getIdMovimiento());
		movimientoDto.setOperacion(movi.getOperacion());
		return movimientoDto;
	}
	
	public static ClienteDto obtenerDto(Cliente cliente) {
		ClienteDto clienteDto=new ClienteDto();
		//clienteDto.setCuentaDtos(cliente.getCuentas().stream().map(c->obtenerDto(c)).toArray(n->new CuentaDto[n]));
		clienteDto.setDireccion(cliente.getDireccion());
		clienteDto.setDni(cliente.getDni());
		clienteDto.setNombre(cliente.getNombre());
		clienteDto.setTelefono(cliente.getTelefono());
		return clienteDto;
	}
	
	public static Movimiento obtenerEntidad(MovimientoDto moviDto) {
		Movimiento movimiento=new Movimiento();
		movimiento.setCantidad(moviDto.getCantidad());
		movimiento.setCuenta(obtenerEntidad(moviDto.getCuentaDto()));
		movimiento.setCuentaRecibeTransf(moviDto.getCuentaRecibeTransf());
		movimiento.setFecha(moviDto.getFecha());
		movimiento.setIdMovimiento(moviDto.getIdMovimiento());
		movimiento.setOperacion(moviDto.getOperacion());
		return movimiento;
	}

	public static Cuenta obtenerEntidad(CuentaDto cuentaDto) {
		Cuenta cuenta=new Cuenta();
		cuenta.setNumeroCuenta(cuentaDto.getNumeroCuenta());
		cuenta.setSaldo(cuentaDto.getSaldo());
		cuenta.setTipocuenta(cuentaDto.getTipocuenta());
		return cuenta;
	}

}
