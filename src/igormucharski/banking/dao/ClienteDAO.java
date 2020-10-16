package igormucharski.banking.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import igormucharski.banking.model.Cliente;

public class ClienteDAO implements DAO<Cliente> {

	@Override //metodo para salvar os clientes na tabela Clientes do BD
	public Cliente salvar(Cliente cliente) {

		String sql = "INSERT INTO clientes(nome, sobrenome, num_conta, senha) VALUES (?, ?, ?, ?)";

		try {

			ConexãoSQL conexão = new ConexãoSQL();
			PreparedStatement executor = conexão.getConexaoSQL().prepareStatement(sql);
			executor.setString(1, cliente.getNome());
			executor.setString(2, cliente.getSobrenome());
			executor.setString(3, cliente.getNumConta());
			executor.setString(4, cliente.getSenha());
			
			executor.executeUpdate();
			
			executor.close();
			conexão.getConexaoSQL().close();

		} catch (SQLException e) {
			
			System.out.println("Não foi possível adicionar o cliente ao Banco de Dados.");
			
		}

		return cliente;
	}

	@Override
	public Cliente atualizar(Cliente entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarConta(Cliente cliente) {
		String sql = "SELECT nome, sobrenome, num_conta FROM CLIENTES WHERE num_conta = ?";
		
		try {
			
			ConexãoSQL conexão = new ConexãoSQL();
			PreparedStatement executor = conexão.getConexaoSQL().prepareStatement(sql);
			executor.setString(1, cliente.getNumConta());
			
			executor.executeUpdate();
			
			executor.close();
			conexão.getConexaoSQL().close();

			
		} catch(SQLException e) {
			
		}
		
		return cliente;
		
	}

}
