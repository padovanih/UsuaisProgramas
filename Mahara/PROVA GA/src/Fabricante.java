import java.util.Random;

public class Fabricante
{
	private int chave_id;
	private String nome_fabricante;
	private String pais;
	private int cod_intern_fabricante;
	
	
	public Fabricante(String nome_fabricante, String pais, int cod)
	{
		this.chave_id = geraChaveId();
		this.nome_fabricante = nome_fabricante;
		this.pais = pais;
		this.cod_intern_fabricante = cod;
	}
	
	
	// ############################################################################################################
	// ############################################################################################################
	//GET'S
	public int get_chave_id(){return chave_id;}
	public String get_nome_fabricante(){return nome_fabricante;}
	public String get_pais(){return pais;}
	public int get_cod_intern_fabricante(){return cod_intern_fabricante;}
	//SET'S
	public void set_chave_Id(int chave_id){this.chave_id = chave_id;}
	public void set_nome_fabricante(String nome_fabricante){this.nome_fabricante = nome_fabricante;}
	public void set_pais(String pais){this.pais = pais;}
	public void set_cod_intern_fabri(int cod_intern_fabricante){this.cod_intern_fabricante = cod_intern_fabricante;}
	// ############################################################################################################
	// ############################################################################################################
	
	
	
	
	
	
	
	
	public int geraChaveId()
	{
		Random gerador = new Random();
		return gerador.nextInt(9999) + 1;
	}
	
	
	
	
	
}
