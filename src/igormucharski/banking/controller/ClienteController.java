package igormucharski.banking.controller;

import java.util.Scanner;

import igormucharski.banking.dao.AcessoDAO;
import igormucharski.banking.model.Acesso;
import igormucharski.banking.model.Cliente;
import igormucharski.banking.view.Tela;

public class ClienteController {

	// Controller inicia a cria��o do cliente -> Instancia "Cliente" para que seja feita a grava��o no BD atrav�s da MODEL
	public void criarCliente() {
		
		String nome, sobrenome, numeroConta, senha;

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o nome do cliente: ");
		nome = sc.nextLine();
		System.out.println("Digite o sobrenome do cliente: ");
		sobrenome = sc.nextLine();
		System.out.println("Digite o numero da conta do cliente: ");
		numeroConta = sc.nextLine();
		System.out.println("Digite a senha do cliente: ");
		senha = sc.nextLine();
		
		Cliente cliente = new Cliente();
		
		cliente.salvarCliente(nome, sobrenome, numeroConta, senha);
		
		sc.close();
		
	}
	
	public void entrarAdministracao() {
		Tela tela = new Tela();
		
		Acesso acessar = tela.usuarioAdministrador(); // armazena o objeto retornado usuario+senha
		
		AcessoDAO acessoDAO = new AcessoDAO();
		acessoDAO.entrar(acessar); //entra no m�todo de acessoDAO com o objeto usuario+senha
		
		if(acessoDAO.entrar(acessar) == true) { // se usu�rio for encontrado
			System.out.println("Seja bem-vindo(a) " + acessar.getNome() + "!");
		} else {
			System.out.println("Usu�rio n�o encontrado!");
			tela.carregarMenu(); 
		}
		
	}
	
}
