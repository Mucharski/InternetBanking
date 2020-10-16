package igormucharski.banking.dao;

public interface DAO<SQL> {

	SQL salvarCliente(SQL entidade);
	SQL atualizarCliente (SQL entidade);
	SQL buscarCliente (SQL entidade);
	SQL excluirCliente(SQL entidade);
	
	
}
