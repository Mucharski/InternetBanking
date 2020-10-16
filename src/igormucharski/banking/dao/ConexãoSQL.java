package igormucharski.banking.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conex�oSQL {

	private String serverName = "localhost:3306";
	private String bancoAConectar = "MucharskiBanking";
	private String username = "root";
	private String password = "Mucharski23!";

	private final String URL = "jdbc:mysql://" + serverName + "/" + bancoAConectar + "?useTimezone=true&serverTimezone=UTC";

	public Connection getConexaoSQL() {

		Connection connection = null;

		String driverName = "com.mysql.cj.jdbc.Driver";

		try {

			Class.forName(driverName);

			connection = DriverManager.getConnection(URL, username, password);

		} catch (ClassNotFoundException e) {

			System.out.println("Classe n�o encontrada");

		} catch (SQLException e) {

			System.out.println("N�o foi poss�vel se conectar ao Banco de Dados.");

		}

		return connection;

	}

}
