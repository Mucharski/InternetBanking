package igormucharski.banking.controller;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import igormucharski.banking.dao.AcessoDAO;
import igormucharski.banking.model.Acesso;
import igormucharski.banking.model.Cliente;
import igormucharski.banking.view.Tela;
import igormucharski.banking.view.TelaAdministrador;

public class AdmController {

	static Scanner sc = new Scanner(System.in);

	public boolean entrarAdministracao() throws IOException {
		boolean entrou = false;
		Tela tela = new Tela();

		Acesso acessar = tela.loginAdministrador(); // armazena o objeto retornado usuario+senha

		AcessoDAO acessoDAO = new AcessoDAO();
		acessoDAO.entrar(acessar); // entra no método de acessoDAO com o objeto usuario+senha

		if (acessoDAO.entrar(acessar) == true) { // se usuário for encontrado entra no menu administrativo
			System.out.println("Seja bem-vindo(a) " + acessar.getNome() + "!");
			TelaAdministrador viewAdm = new TelaAdministrador();
			viewAdm.menuAdministracao();
			entrou = true;
		} else {
			System.out.println("Usuário não encontrado!\nPor favor, aperte ENTER para tentar novamente..\n");
			System.in.read(); // espera o enter do usuário para voltar ao menu principal
			tela.menuPrincipal();
			entrou = false;
		}

		return entrou; // no momento o retorno desse método não é usado para nada;

	}

	public Cliente criarCliente() {

		String nome, sobrenome, senha, CPF;
		int numeroConta;
		Random numConta = new Random();

		System.out.println("Digite o nome do cliente: ");
		nome = sc.nextLine();
		System.out.println("Digite o sobrenome do cliente: ");
		sobrenome = sc.nextLine();
		numeroConta = numConta.nextInt(10000);
		System.out.println("Digite o CPF do cliente: ");
		CPF = sc.nextLine();
		System.out.println("Digite a senha do cliente: ");
		senha = sc.nextLine();

		Cliente cliente = new Cliente();

		cliente.salvarCliente(nome, sobrenome, numeroConta, senha, CPF);


		return cliente;

	}

	public void buscarCliente() {

		String CPF;
		System.out.println("Digite o CPF do cliente");
		CPF = sc.nextLine();
		
		Cliente cliente = new Cliente();
		cliente.buscarCliente(CPF);
		
		

	}

}
