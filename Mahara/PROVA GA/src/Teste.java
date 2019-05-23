import java.io.IOException;
import java.util.Scanner;



class Teste{
	
	
	public static void mostraCatalago(){
		System.out.println("\n --> ESCOLHA A OPÇÃO PELO RESPECTIVO NUMERO:\n");
		System.out.println(" 0 - Sair.");
		System.out.println(" 1 - Inserir um Fabricante.");
		System.out.println(" 2 - Inserir uma Aeronave.");
		System.out.println(" 3 - Remover uma aeronave pela matricula. ");
		System.out.println(" 4 - Remover uma ou mais aeronaves pelo código. ");
		System.out.println(" 5 - Remover um fabricante pelo código.");
		System.out.println(" 6 - Criar arquivo com os dados das aeronaves atuais.");
		
		System.out.println(" 11 - Mostrar os fabricantes existentes.");
		System.out.println(" 12 - Mostrar as aeronaves existentes.");
		System.out.println(" 13 - Mostrar as aeronaves completamente.");
		System.out.println("");
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		mostraCatalago();
		System.out.print("Digite a opção desejada: ");
		int opcao = in.nextInt();
		in.nextLine();
		System.out.println("");
		
		
		
		GenrenciaCadastro gerencia = new GenrenciaCadastro();
		
		while (opcao != 0) {
			
			switch (opcao){
				case 1:
					System.out.println("Voce selecionou a primeiro opção: INSERIR FABRICANTE.");
					gerencia.gera_e_insere_fabricante();
					break;
				case 2:
					System.out.println("Você selecionou a segunda opção: INSERIR UMA AERONAVE.");
					gerencia.gera_e_insereve_aeronave();
					break;
				
				case 11:
					System.out.println("Você selecionou a opção: MOSTRA FABRICANTES.");
					gerencia.show_Fabricantes();
					break;
				
				case 12:
					System.out.println("Você selecionou a opção: MOSTRA AERONAVES.");
					gerencia.show_aeronaves();
					break;
				
				case 3:
					System.out.println("Você selecionou a opção: REMOVE AERONAVE POR MATRICULA.");
					System.out.print("Digite a matricula: ");
					String matricula = in.nextLine();
					gerencia.remove_aeronave(matricula);
					break;
				
				case 4:
					System.out.println("Você selecionou a opção: REMOVE AERONAVES POR CÓDIGO.");
					System.out.print("Digite o CÓDIGO: ");
					int cod = in.nextInt();
					gerencia.remove_aeronave(cod);
					break;
				
				case 5:
					System.out.println("Você selecionou a opção: REMOVE FORNECEDOR PELO CÓDIGO.");
					System.out.print("Digite o CÓDIGO: ");
					int cod_forn = in.nextInt();
					gerencia.remove_fabricante(cod_forn);
					break;
				
				case 13:
					System.out.println("Você selecionou a opção: MOSTRA AERONAVES COMPLETO.");
					gerencia.show_aeronaves_completo();
					break;
				
				case 6:
					System.out.println("Você selecionou a opção: CRIAR ARQUIVO.");
					try {
						gerencia.gera_arquivo("relatorio_aeronaves.txt");
					}
					catch (IOException exp){
						System.out.println("[ERRO]: DEU PAU JUVENAL!");
					}
					break;
				
				default:
					System.out.println("ERRO: código inválido, favor confira a opção desejada.");
					break;
			}
			
			mostraCatalago();
			System.out.print("\nDigite a opção desejada: ");
			opcao = in.nextInt();
			in.nextLine();
			System.out.println("");
		}
		System.out.println("\nFIM!");
		
		
		
		 
		
		
		
		
		
	}
	
	
	
	
}
