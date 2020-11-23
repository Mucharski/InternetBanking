package igormucharski.banking.view;

import java.io.IOException;
import java.util.Scanner;

import igormucharski.banking.controller.AdmController;
import igormucharski.banking.model.Acesso;

public class Tela {

	static Scanner leitor = new Scanner(System.in);

	public void menuPrincipal() throws IOException {

		int opcaoEscolhida = 0;
		AdmController controller = new AdmController();
		System.out.println("======SEJA BEM-VINDO AO MUCHARSKI BANKING======");
		System.out.println("SELECIONE A OPERAÇÃO DESEJADA: ");
		System.out.println("2. Administração");
		opcaoEscolhida = leitor.nextInt();

		switch (opcaoEscolhida) {

		case 1:
			break;
		case 2:
			controller.entrarAdministracao();
			break;
		}

		leitor.close();

	}

	public Acesso loginAdministrador() {
		String usuario, senha;

		System.out.println("Digite seu usuário de administrador: ");
		usuario = leitor.next();
		System.out.println("Digite sua senha: ");
		senha = leitor.next();

		Acesso acesso = new Acesso();
		acesso.setUsuario(usuario); // dá um set do nome do usuario
		acesso.setSenha(senha); // **

		return acesso; // retorna o objeto usuario+senha

	}

}
