package igormucharski.banking.dao;

public interface DAO<SQL> {

	SQL salvar(SQL entidade);
	SQL atualizar (SQL entidade);
	SQL buscarConta (SQL entidade);
	
	
}
