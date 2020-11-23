package igormucharski.banking.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import igormucharski.banking.dao.ClienteDAO;

@Entity
@Table(name = "clientes")
public class Cliente {

	private String nome;
	private String sobrenome;
	@Column(name = "num_conta")
	private int numConta;
	private String senha;
	@Id
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

	}

	public void buscarCliente(String CPF) {

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscarPorId(CPF);

		if (clienteDAO.buscarPorId(CPF) == null) {
			System.out.println("\nUsuário não encontrado\n");
		} else {
			System.out.println(cliente + "\n");
		}

	}

	public void atualizarCliente(String nome, String sobrenome, String senha, int numConta, String CPF) {
		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setSobrenome(sobrenome);
		cliente.setSenha(senha);
		cliente.setNumConta(numConta);
		cliente.setCPF(CPF);

		clienteDAO.atualizarCliente(cliente);
	}

	public void apagarCliente(String CPF) {
		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.apagar(CPF);

	}
	
	
	// GETTERS E SETTERS //

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
