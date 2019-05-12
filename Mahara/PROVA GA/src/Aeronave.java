import java.util.Random;

public class Aeronave implements ChaveId
{
	private int chaveId;
	private String nome_aeronave;
	private String modelo_aeronave;
	private String natricula_aeronave;
	private int cod_internacional_fabricante;
	
	
	
	
	
	
	public Aeronave(String nome_aeronave, String modelo_aeronave, String natricula_aeronave ,int cod_internacional_fabricante)
	{
		this.chaveId = geraChaveId();
		this.nome_aeronave = nome_aeronave;
		this.modelo_aeronave = modelo_aeronave;
		this.natricula_aeronave = natricula_aeronave;
		this.cod_internacional_fabricante = cod_internacional_fabricante;
	}
	
	
	// ############################################################################################################
	// ############################################################################################################
	public int getChaveId() {
		return chaveId;
	}
	public void setChaveId(int chaveId) {
		this.chaveId = chaveId;
	}
	public String getNome_aeronave() {
		return nome_aeronave;
	}
	public void setNome_aeronave(String nome_aeronave) {
		this.nome_aeronave = nome_aeronave;
	}
	public String getModelo_aeronave() {
		return modelo_aeronave;
	}
	public void setModelo_aeronave(String modelo_aeronave) {
		this.modelo_aeronave = modelo_aeronave;
	}
	public int getCod_internacional_fabricante() {
		return cod_internacional_fabricante;
	}
	public void setCod_internacional_fabricante(int cod_internacional_fabricante) {
		this.cod_internacional_fabricante = cod_internacional_fabricante;
	}
	public String getNatricula_aeronave() {
		return natricula_aeronave;
	}
	public void setNatricula_aeronave(String natricula_aeronave) {
		this.natricula_aeronave = natricula_aeronave;
	}
	
	// ############################################################################################################
	// ############################################################################################################
	
	
	
	
	
	
	
	
	public int geraChaveId()
	{
		Random gerador = new Random();
		return gerador.nextInt(9999) + 1;
	}
	
}
