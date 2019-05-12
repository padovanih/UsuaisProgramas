class MergeSort
{
	
	static void Merge_Sort(double [] vet)
	{
		int size = vet.length;
		if (size <= 1) return;
		
		int mid = (int)(size/2);
		
		double[] left  = new double[mid];
		double[] right = new double[size-mid];
		
		for (int i = 0; i < mid; i++)      { left[i]  = vet[i]; }
		for (int i = 0; i < size-mid; i++) { right[i] = vet[mid+i]; }
		
		Merge_Sort(left);
		Merge_Sort(right);
		Merge(left,right,vet);
	}
	
	
	static void Merge(double [] left, double [] right, double [] vet)
	{
		int sleft = left.length;
		int sright = right.length;
		int i, j, k; i=0;j=0;k=0;
		
		while ( i < sleft && j < sright )
		{
			if( left[i] < right[j] ) { vet[k++] = left[i++]; }
			else                     { vet[k++] = right[j++]; }
		}
		
		while( i < sleft )
			vet[k++] = left[i++];
		
		while ( j < sright )
			vet[k++] = right[j++];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args)
	
	{
		System.out.println("Hello");
		
		double [] v = {-1, 2, 4, 1, 0 , 9, 10, 9.5, -50.3, 90};
		
		for (int i = 0; i < v.length; i++)
		{
			System.out.print( v[i] + " ");
		}
		System.out.print( "\n");
		
		Merge_Sort(v);
		
		
		
		for (int i = 0; i < v.length; i++)
		{
			System.out.print( v[i] + " ");
		}
		
		
	}
	
}
