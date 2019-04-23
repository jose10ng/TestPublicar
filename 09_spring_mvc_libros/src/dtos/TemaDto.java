package dtos;

import java.io.Serializable;


public class TemaDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idTema;

	private String tema;

	public TemaDto() {
	}

	public int getIdTema() {
		return this.idTema;
	}

	public void setIdTema(int idTema) {
		this.idTema = idTema;
	}

	public String getTema() {
		return this.tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}
}