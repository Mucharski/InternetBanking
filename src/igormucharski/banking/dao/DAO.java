package igormucharski.banking.dao;

import java.util.List;

public interface DAO<SQL> {

	SQL salvarCliente(SQL entidade);
	SQL atualizarCliente (SQL entidade);
	List<SQL> listarCliente (SQL entidade);
	SQL buscarPorId(String CPF);
	void apagar(String CPF);
	
}
