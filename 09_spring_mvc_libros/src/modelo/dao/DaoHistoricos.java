package modelo.dao;

import java.util.List;

import entidades.Cliente;
import entidades.Historico;

public interface DaoHistoricos {

	void alta(Historico h);
	boolean baja(int idHistorico);
	Historico buscar(int idHistorico);
	List<Historico> lista();
	Cliente clienteDeUnHistorico(int idHistorico);
}
