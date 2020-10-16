package igormucharski.banking.view;

import java.util.Scanner;

import igormucharski.banking.controller.ClienteController;
import igormucharski.banking.model.Acesso;

public class Tela {

	public void carregarMenu() {

		int opcaoEscolhida = 0;
		Scanner lt = new Scanner(System.in);
		System.out.println("===SEJA BEM-VINDO AO MUCHARSKI BANKING===");
		System.out.println("SELECIONE A OPERAÇÃO DESEJADA: ");
		System.out.println("1. Entrar");
		System.out.println("2. Administração");
		opcaoEscolhida = lt.nextInt();

		switch (opcaoEscolhida) {

		case 1:
			// entrarConta();
			break;
		case 2:
			ClienteController controller = new ClienteController();
			controller.entrarAdministracao();
			break;
		}

		lt.close();

	}

	public void entrarConta() {

	}

	public Acesso usuarioAdministrador() {
		String usuario, senha;

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite seu usuário de administrador: ");
		usuario = sc.nextLine();
		System.out.println("Digite sua senha: ");
		senha = sc.nextLine();

		Acesso acesso = new Acesso();
		acesso.setUsuario(usuario); // dá um set do nome do usuario
		acesso.setSenha(senha); // **

		sc.close();

		return acesso; // retorna o objeto usuario+senha

	}

}
