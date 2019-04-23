package mappers;

import dtos.ClienteDto;
import dtos.HistoricoDto;
import dtos.LibroDto;
import dtos.TemaDto;
import dtos.VentaDto;
import entidades.Cliente;
import entidades.Historico;
import entidades.Libro;
import entidades.Tema;
import entidades.Venta;

public class MapperADtos {
	
	protected ClienteDto obtenerDto(Cliente c) {
		return new ClienteDto(c.getIdCliente(),c.getEmail(),c.getPassword(),c.getTelefono(),c.getUsuario());
	}
	
	protected HistoricoDto obtenerDto(Historico h) {
		HistoricoDto hd=new HistoricoDto();
		hd.setIdHistorico(h.getIdHistorico());
		hd.setCantidad(h.getCantidad());
		hd.setCliente(obtenerDto(h.getCliente()));
		return hd;
	}
	
	protected LibroDto obtenerDto(Libro l) {
		LibroDto ld=new LibroDto();
		ld.setAutor(l.getAutor());
		ld.setIsbn(l.getIsbn());
		ld.setPaginas(l.getPaginas());
		ld.setPrecio(l.getPrecio());
		ld.setTema(obtenerDto(l.getTema()));
		ld.setTitulo(l.getTitulo());
		return ld;
	}

	protected TemaDto obtenerDto(Tema t) {
		TemaDto td=new TemaDto();
		td.setIdTema(t.getIdTema());
		td.setTema(t.getTema());
		return td;
	}
	
	protected VentaDto obtenerDto(Venta v) {
		VentaDto vd=new VentaDto();
		vd.setFecha(v.getFecha());
		vd.setIdCliente(v.getIdCliente());
		vd.setIdLibro(v.getIdLibro());
		vd.setIdVEnta(v.getIdVEnta());
		return vd;
	}
	
	protected Libro obtenerEnt(LibroDto ld) {
		Libro l=new Libro();
		l.setAutor(ld.getAutor());
		l.setIsbn(ld.getIsbn());
		l.setPaginas(ld.getPaginas());
		l.setPrecio(ld.getPrecio());
		l.setTema(obtenerEnt(ld.getTema()));
		l.setTitulo(ld.getTitulo());
		return l;
	}

	protected Tema obtenerEnt(TemaDto td) {
		Tema t=new Tema();
		t.setIdTema(td.getIdTema());
		t.setTema(td.getTema());
		return t;
	}

}
