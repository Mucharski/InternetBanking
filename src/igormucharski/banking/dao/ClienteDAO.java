package igormucharski.banking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import igormucharski.banking.model.Cliente;

public class ClienteDAO implements DAO<Cliente> {

	@Override // metodo para salvar os clientes na tabela Clientes do BD
	public Cliente salvarCliente(Cliente cliente) {

		String sql = "INSERT INTO clientes(nome, sobrenome, num_conta, senha, CPF) VALUES (?, ?, ?, ?, ?)";

		try {

			ConexãoSQL conexão = new ConexãoSQL();
			PreparedStatement executor = conexão.getConexaoSQL().prepareStatement(sql);
			executor.setString(1, cliente.getNome());
			executor.setString(2, cliente.getSobrenome());
			executor.setInt(3, cliente.getNumConta());
			executor.setString(4, cliente.getSenha());
			executor.setString(5, cliente.getCPF());

			executor.executeUpdate();

			executor.close();
			conexão.getConexaoSQL().close();

		} catch (SQLException e) {

			System.out.println("Não foi possível adicionar o cliente ao Banco de Dados.");

		}

		return cliente;
	}

	@Override
	public Cliente atualizarCliente(Cliente entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente buscarCliente(Cliente cliente) {
		String sql = "SELECT nome, sobrenome, num_conta, senha FROM clientes WHERE CPF = ?";

		try {

			ConexãoSQL conexão = new ConexãoSQL();
			PreparedStatement executor = conexão.getConexaoSQL().prepareStatement(sql);
			executor.setString(1, cliente.getCPF());

			ResultSet rs;
			rs = executor.executeQuery();

			if (rs.next()) {
				cliente.setNome(rs.getString("nome"));
				cliente.setSobrenome(rs.getString("sobrenome"));
				cliente.setNumConta(rs.getInt("num_conta"));
				cliente.setSenha(rs.getString("senha"));
			}

			else {
				executor.close();
				conexão.getConexaoSQL().close();
			}
		} catch (SQLException e) {

		}

		return cliente;

	}

	@Override
	public Cliente excluirCliente(Cliente entidade) {
		// TODO Auto-generated method stub
		return null;
	}

}
