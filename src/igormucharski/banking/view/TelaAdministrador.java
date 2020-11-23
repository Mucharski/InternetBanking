package igormucharski.banking.view;

import java.util.Scanner;

import igormucharski.banking.controller.AdmController;

public class TelaAdministrador {

	static Scanner leitor = new Scanner(System.in);
	static AdmController controller = new AdmController();
	int opcaoEscolhida;

	public void menuAdministracao() {
		do {
			System.out.println("Selecione a operação desejada: ");
			System.out.println(
					"1. Cadastrar Cliente\n2. Buscar Cliente\n3. Atualizar Cadastro\n4. Excluir Cliente\n0. Sair");
			opcaoEscolhida = leitor.nextInt();

			switch (opcaoEscolhida) {

			case 1:
				controller.criarCliente();
				break;
			case 2:
				controller.buscarCliente();
				break;
			case 3:
				controller.atualizarCliente();
				break;
			case 4:
				controller.apagarCliente();
				break;
			case 0:
				System.exit(0);
				break;
			default:
				System.out.println("Digite um número válido\n");
				break;
			}
		} while (opcaoEscolhida != 0);
		
		leitor.close();
	}
}
