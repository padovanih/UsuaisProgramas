class Test1
{
	
	
	
	
	
	
	
	public static void main(String[] args)
	
	{
		
		ClasseQlqr [] vetObj = new ClasseQlqr[5];
		
		
		Node<ClasseQlqr> head;
		Node<ClasseQlqr> tail;
		
		
		
		//                       PRIMEIRO:
		vetObj[0] = new ClasseQlqr();
		
		// Muito cuidado, ambos devem apontar para o mesmo nó no começo.
		Node<ClasseQlqr> tmp = new Node<>( vetObj[0] );
		head = tmp;
		tail = tmp;
		
		System.out.println(vetObj[0].getValor());
		
		
		
		
		//                       SEGUNDO e demais
		for (int i = 1; i < vetObj.length; i++)
		{
			vetObj[i] = new ClasseQlqr();
			
			// Esse será o novo TAIL
			tmp = new Node<>(vetObj[i]);
			
			System.out.println(vetObj[i].getValor());
			
			tmp.setPrev(tail);
			tail.setNext(tmp);
			tail = tmp;
		}
		
		
		// Pra navegar entre os nós, tem que criar outro
		Node<ClasseQlqr> aux = head;
		
		while ( aux != null )
		{
			System.out.println(aux.getObj().getValor());
			aux = aux.getNext();
		}
		
		
		
		
		
		
	}
	
	
}
