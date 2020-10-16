package igormucharski.banking.model;

import igormucharski.banking.dao.ClienteDAO;

public class Cliente {

	private String nome;
	private String sobrenome;
	private String numConta;
	private String senha;

	// Construtor com parâmetros
	public Cliente(String nome, String sobrenome, String numConta, String senha) {

		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numConta = numConta;
		this.senha = senha;

	}

	public Cliente() {
		// Construtor sem parâmetros
	}

	// Método para salvar os clientes no Banco de Dados
	public void salvarCliente(String nome, String sobrenome, String numConta, String senha) {

		ClienteDAO clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente(nome, sobrenome, numConta, senha);

		clienteDAO.salvar(cliente);

		System.out.println(cliente);

	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nSobrenome: " + sobrenome + "\nNúmero da Conta: " + numConta + "\nSua senha: "
				+ senha;
	}
}
