class ClasseQlqr
{
	
	private double valor;
	
	
	
	
	public ClasseQlqr()
	{
		this.valor = (int)(Math.random()*100);
	}
	
	public ClasseQlqr(double valor)
	{
		this.valor = valor;
	}
	
	
	
	
	
	
	
	public double getValor()
	{
		return this.valor;
	}
	
	public void setValor(double valor)
	{
		this.valor = valor;
	}
	
	
}
