import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedWriter;

class GenrenciaCadastro{
	Scanner in;
	private Aeronave [] aeronaves;
	private int qnt_aeronaves;
	
	private Fabricante [] fabricantes;
	private int qnt_fabricantes;
	
	
	// SET
	public void setAeronaves(Aeronave[] aeronaves) {
		this.aeronaves = aeronaves;
	}
	public void setQnt_aeronaves(int qnt_aeronaves) {
		this.qnt_aeronaves = qnt_aeronaves;
	}
	public void setFabricantes(Fabricante[] fabricantes) {
		this.fabricantes = fabricantes;
	}
	public void setQnt_fabricantes(int qnt_fabricantes) {
		this.qnt_fabricantes = qnt_fabricantes;
	}
	
	public GenrenciaCadastro() {
		in = new Scanner(System.in);
		aeronaves = new Aeronave[20];
		fabricantes = new Fabricante[20];
		qnt_aeronaves = 0;
		qnt_fabricantes = 0;
	}
	
	
	
	public void insertFabricante(Fabricante fabricante){
		fabricantes[qnt_fabricantes++] = fabricante;
	}
	public void gera_e_insere_fabricante(){
		System.out.print("Digite o nome: ");
		String nome_fabricante = in.nextLine();
		System.out.print("Digite o pais deste fabricante: ");
		String pais = in.nextLine();
		System.out.print("Digite o código do fabricante: ");
		int cod = in.nextInt();
		in.nextLine();
		
		Fabricante novo_fabricante = new Fabricante(nome_fabricante, pais, cod);
		
		this.insertFabricante(novo_fabricante);
		
		System.out.println("CADASTRO REALIZADO COM SUCESSO!");
	}
	
	
	
	public void show_Fabricantes () {
		
		if (qnt_fabricantes==0) {
			System.out.println("\n[ERRO]: Não há fabricantes.");
			return;
		}
		
		
		System.out.println("OS FABRICANTES EXISTENTES SÃO:");
		for (int i = 0; i < qnt_fabricantes; i++) {
			System.out.println("NOME: " + fabricantes[i].get_nome_fabricante() + " - COD INTERNACIONAL: " 
								+ fabricantes[i].get_cod_intern_fabricante()
								+ " - PAIS: " + fabricantes[i].get_pais());
		}
		System.out.println("");
	}
	public void show_aeronaves() {
		System.out.println("AS AERONAVES SÃO:");
		if(qnt_aeronaves==0){
			System.out.println("[ERRO]: Não há aeronaves.");
			return;
		}
		for (int i = 0; i < qnt_aeronaves; i++) {
			System.out.println("NOME: " + this.aeronaves[i].getNome_aeronave()
					+ " ### MATRICULA: " + this.aeronaves[i].getNatricula_aeronave()
					+ " ### CODIGO: " + this.aeronaves[i].getCod_internacional_fabricante());
		}
	}
	
	
	public void insertAeronave(Aeronave nova_aeronave) {
		this.aeronaves[qnt_aeronaves++] = nova_aeronave;
	}
	public void gera_e_insereve_aeronave() {
		Scanner in = new Scanner(System.in);
		System.out.print("Digite o nome: ");
		String nome = in.nextLine();
		System.out.print("Digite o modelo: ");
		String modelo = in.nextLine();
		System.out.print("Digite a matricula: ");
		String matricula = in.nextLine();
		System.out.println("\nESCOLHA o codigo internacional ");
		this.show_Fabricantes();
		System.out.print("Digite o codigo internacional: ");
		int cod = in.nextInt();
		in.nextLine();
		
		Aeronave nova_aeronave = new Aeronave(nome, modelo,matricula, cod);
		insertAeronave(nova_aeronave);
		
		System.out.println("CADASTRO REALIZADO COM SUCESSO!");
	}
	
	
	public void remove_aeronave_byIndex(int pos) {
		this.setQnt_aeronaves( this.qnt_aeronaves-1 );
		for (int i = pos; i < qnt_aeronaves; i++) {
			this.aeronaves[i] = aeronaves[i+1];
		}
	}
	public void remove_aeronave(String matricula){
		if (qnt_aeronaves==0) {
			System.out.println("[ERRO]: Não há aeronaves.");
		}
		
		for (int i = 0; i < qnt_aeronaves; i++) {
			if ( this.aeronaves[i].getNatricula_aeronave().equalsIgnoreCase(matricula) ) {
				this.remove_aeronave_byIndex(i);
				return;
			}
		}
	}
	public void remove_aeronave(int cod_rem) {
		if(qnt_aeronaves==0){
			System.out.println("[ERRO]: Não há aeronaves.");
			return;
		}
		
		for (int i = 0; i < qnt_aeronaves; i++) {
			if ( this.aeronaves[i].getCod_internacional_fabricante() == cod_rem ) {
				this.remove_aeronave_byIndex(i);
				i--;
			}
		}
	}
	
	public void remove_fabricante_byIndex(int pos) {
		this.setQnt_fabricantes( this.qnt_fabricantes-1 );
		for (int i = pos; i < qnt_fabricantes; i++) {
			fabricantes[i] = fabricantes[i+1];
		}
	} 
	public void remove_fabricante(int cod){
		if(qnt_fabricantes==0) {
			System.out.println("[ERRO]: Não há fabricantes.");
		}
		
		this.remove_aeronave(cod);
		
		for (int i = 0; i < qnt_fabricantes; i++) {
			if ( fabricantes[i].get_cod_intern_fabricante() == cod ){
				this.remove_fabricante_byIndex(i);
			}
		}
		
	}
	
	
	public String toString_Fabricante_byCod(int cod){
		for (int i = 0; i < qnt_fabricantes; i++) {
			if ( this.fabricantes[i].get_cod_intern_fabricante() == cod ) {
				Fabricante fab = this.fabricantes[i];
				return " ### Fabricante: " + fab.get_nome_fabricante() + " ### Pais: " + fab.get_pais();
			}
		}
		System.out.println("\n\n\n[ERRO]: CÓDIGO do fabricante não encontrado.");
		return " ";
	}
	
	public String toString_Aernave_byIndex(int index){
		
		if ( index<0 || index>=qnt_aeronaves ){
			System.out.println("ERRO !!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		
		return "NOME: " + this.aeronaves[index].getNome_aeronave()
				+ " ### MATRICULA: " + this.aeronaves[index].getNatricula_aeronave()
				+ " ### CODIGO: " + this.aeronaves[index].getCod_internacional_fabricante();
	}
	
	public void show_aeronaves_completo_recursao(int index) {
		if(index==0) {
			System.out.println( this.toString_Aernave_byIndex(index)
								+ this.toString_Fabricante_byCod(this.aeronaves[index].getCod_internacional_fabricante()) );
			return;
		}
		
		this.show_aeronaves_completo_recursao( (index-1) );
		
		System.out.println(this.toString_Aernave_byIndex(index)
							+ this.toString_Fabricante_byCod(this.aeronaves[index].getCod_internacional_fabricante()) );
		
		
	}
	
	
	public void show_aeronaves_completo() {
		System.out.println("\tAs aeronaves são:");
		
		this.show_aeronaves_completo_recursao( (qnt_aeronaves-1) );
	}
	
	
	public String relatorio_aeronave(){
		String conteudo="";
		for (int i = 0; i < qnt_aeronaves; i++) {
			conteudo += this.toString_Aernave_byIndex(i)
					  + this.toString_Fabricante_byCod(this.aeronaves[i].getCod_internacional_fabricante())
					  + "\n";
		}
		return conteudo;
	}
	
	
	
	public void gera_arquivo(String nome_arquivo) throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter(nome_arquivo));
		writer.write( this.relatorio_aeronave() );
		writer.close();
	}
	
}
