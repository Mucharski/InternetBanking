package igormucharski.banking.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import igormucharski.banking.model.Acesso;

public class AcessoDAO implements DAOAcesso<Acesso> {

	@Override
	public boolean entrar(Acesso acesso) {
		boolean autenticado = false;
		String sql = "SELECT usuario, senha, nome FROM administradores WHERE usuario = ? and senha = ?";

		try {

			ConexãoSQL conexão = new ConexãoSQL();
			PreparedStatement executor = conexão.getConexaoSQL().prepareStatement(sql);
			executor.setString(1, acesso.getUsuario()); // pega o usuário
			executor.setString(2, acesso.getSenha()); //**

			ResultSet rs;
			rs = executor.executeQuery();

			if (rs.next()) {

				@SuppressWarnings("unused")
				String loginAdm = rs.getString("usuario");
				@SuppressWarnings("unused")
				String senhaBanco = rs.getString("senha");
				acesso.setNome(rs.getString("nome"));
				autenticado = true;

			} else {

				executor.close();
				conexão.getConexaoSQL().close();

			}

		} catch (SQLException e) {

			System.out.println("Houve um problema na conexão ao banco");

		}

		return autenticado;

	}

}
