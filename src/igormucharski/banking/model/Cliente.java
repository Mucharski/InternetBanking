package igormucharski.banking.model;

import igormucharski.banking.dao.ClienteDAO;

public class Cliente {

	private String nome;
	private String sobrenome;
	private int numConta;
	private String senha;
	private String CPF;

	// Construtor com parâmetros
	public Cliente(String nome, String sobrenome, int numConta, String senha, String CPF) {

		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.numConta = numConta;
		this.senha = senha;
		this.CPF = CPF;

	}

	public Cliente() {
		// Construtor sem parâmetros
	}

	// Método para salvar os clientes no Banco de Dados
	public void salvarCliente(String nome, String sobrenome, int numConta, String senha, String CPF) {

		ClienteDAO clienteDAO = new ClienteDAO();

		Cliente cliente = new Cliente(nome, sobrenome, numConta, senha, CPF);

		clienteDAO.salvarCliente(cliente);

		System.out.println(cliente);

	}

	public void buscarCliente(String CPF) {
		
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		cliente.setCPF(CPF);
		clienteDAO.buscarCliente(cliente);
		
		if(cliente.getNome() != null) {
			System.out.println(cliente);
		} else {
			System.out.println("Número da conta pesquisada não existe.");
		}
		
		
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

	public int getNumConta() {
		return numConta;
	}

	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	@Override
	public String toString() {
		return "Nome: " + nome + "\nSobrenome: " + sobrenome + "\nNúmero da Conta: " + numConta + "\nSua senha: "
				+ senha;
	}
}
