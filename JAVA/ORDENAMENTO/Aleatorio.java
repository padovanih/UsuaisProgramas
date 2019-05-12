import java.util.Random;



class Aleatorio
{
	
	public Random r;
	
	
	
	
	Aleatorio() { r = new Random();}
	
	
	
	
	
	System.out.println("A mahara é uma chatona");
	
	
	
	
	
	//                                              PRINTA ARRAY
	public void printArray(int [] vet)
	{
		for (int i = 0; i < vet.length; i++)
			System.out.print(vet[i] + " ");
		System.out.print("\n");
	}
	
	
	
	
	
	
	
	
	
	
	
	//                                              ARRAY DE DOUBLE
	public double [] doubleArray(int size)
	{
		double [] vet = new double[size];
		for (int i = 0; i < size; i++) vet[i] = r.nextDouble()*100.0;
		return vet;
	}
	
	
	
	
	
	
	
	//                                             ARRAY DE INT
	public int [] intArray(int size)
	{
		int [] vet = new int[size];
		for (int i = 0; i < size; i++) vet[i] = r.nextInt(100);
		return vet;
	}
	
	
	
}
