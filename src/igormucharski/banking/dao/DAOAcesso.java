package igormucharski.banking.dao;

public interface DAOAcesso<SQL> {

	boolean entrar(SQL entidade);
	
}
