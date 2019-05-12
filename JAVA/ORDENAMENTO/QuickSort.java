class QuickSort
{
	
	static void swap(int [] vet, int a, int b) {int temp = vet[a]; vet[a]=vet[b]; vet[b]=temp;}
	
	
	static void Quick_Sort(int [] vet, int start, int end)
	{
		if(start >= end) return;
		
		int pivotIndex = partition(vet, start, end);
		
		Quick_Sort(vet, start, pivotIndex-1);
		Quick_Sort(vet, pivotIndex+1, end);
	}
	
	
	
	
	
	
	static int partition(int [] vet, int start, int end)
	{
		int pivot = vet[end];
		
		// Essa variavel mostra o primeiro elemento que é maior que o PIVOT
		int j = start-1;
		
		for (int i = start; i < end; i++)
		{
			if (vet[i] <= pivot) { j++; swap(vet,i,j); }
		}
		
		swap(vet,j+1,end);
		
		return j+1;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	
	{
		
		Aleatorio obj = new Aleatorio();
		
		int [] vet = obj.intArray(20);
		
		obj.printArray(vet);
		
		Quick_Sort(vet, 0, 19);
		
		obj.printArray(vet);
		
		
	}
	
	
}
