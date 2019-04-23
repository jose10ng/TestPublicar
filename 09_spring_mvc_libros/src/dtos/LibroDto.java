package dtos;

import java.io.Serializable;


public class LibroDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int isbn;

	private String autor;

	private int paginas;

	private double precio;

	private String titulo;

	private TemaDto tema;

	public LibroDto() {
	}
	
	public int getIsbn() {
		return this.isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPaginas() {
		return this.paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}

	public double getPrecio() {
		return this.precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TemaDto getTema() {
		return this.tema;
	}

	public void setTema(TemaDto tema) {
		this.tema = tema;
	}
}