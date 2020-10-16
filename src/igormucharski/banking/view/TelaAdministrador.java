package igormucharski.banking.view;

import java.util.Scanner;

import igormucharski.banking.controller.AdmController;

public class TelaAdministrador {
	
	static Scanner leitor = new Scanner(System.in);
	static AdmController controller = new AdmController();

	public void menuAdministracao() {
		int opcaoEscolhida = 0;
		System.out.println("Selecione a operação desejada: ");
		System.out.println("1. Cadastrar novo cliente no Banco\n2. Buscar cliente\n3. Atualizar cadastro\n4. Excluir conta ");
		opcaoEscolhida = leitor.nextInt();
		
		switch(opcaoEscolhida) {
		
		case 1:
			controller.criarCliente();
			break;
		case 2:
			controller.buscarCliente();
			break;
		}
	}	
}
