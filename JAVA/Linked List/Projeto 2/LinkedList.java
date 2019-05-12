class LinkedList<E>
{
	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	
	// Criado pra auxiliar os metodos
	private Node<E> auxNode;
	
	
	public LinkedList() { size=0; }
	// public MyLinkedList() {}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//                          GET's
	
	
	// -------------------------------------------------------------- //
	
	// GET FIRST 
	public E getFirst() {
		if(size==0)
			return null;
		return head.obj;
	}
	
	// -------------------------------------------------------------- //
	
	// GET LAST
	public E getLast() {
		if(size==0) { return null; }
		return tail.getOBJ();
	}
	
	// -------------------------------------------------------------- //
	
	// GET BY INDEX
	public E getByIndex(int k) {
		if(size <= k) { return null; }
		
		auxNode = head;
		for (int i = 1; i < k; i++)
			auxNode = auxNode.getNext();
		
		return auxNode.getOBJ();
	}
	
	// -------------------------------------------------------------- //
	
	// GET ALL
	public void getAll() {
		
		if (size==0) {System.out.println("VAZIO"); return;}
		
		auxNode = head;
		
		System.out.println(" - ALL ELEMENTS - ");
		for (int i = 0; i < size; i++)
		{
			System.out.println(i + " : " + auxNode.getOBJ() );
			auxNode = auxNode.getNext();
		}
		System.out.println("");
	}
	
	// -------------------------------------------------------------- //
	
	// GET ALL REVERSE
	/*
	public void getAllReverse() {
		
		if (size == 0) { System.out.println("VAZIO"); return; }
		
		auxNode = tail;
		System.out.println(" - ALL ELEMENTS - ");
		
		for (int i = 0; i < size; i++)
		{
			System.out.println(i + " : " + auxNode.getOBJ() );
			auxNode = auxNode.getNext();
		}
	}
	*/
	
	// -------------------------------------------------------------- //
	
	
	
	
	
	
	
	
	
	// ############################################################## //
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//                          ADD's
	
	// Add first position - PUSH
	// O(1)
	public void addFirst(E objParam) {
		if(size==0){
			auxNode = new Node<>(objParam);
			head = auxNode;
		}
		else {
			auxNode = new Node<>(objParam);
			auxNode.setNext(head);
			// auxNode.setPrev(null); // Desnecessário devio o construtor
			
			head.setPrev(auxNode);
			
			head = auxNode;
			
			// Também tem que atualizar o TAIL
			
			
		}
		
		size++;
	}
	
	// Add to END - APPEND
	// O(n)
	public void addEnd(E objParam)
	{
		// Caso esteja vazio
		if(size==0) { addFirst(objParam); }
		
		auxNode = new Node<>(objParam);
		
		Node<E> last = head;
		
		// vai até o ultimo existente
		while(last.getNext() != null) { last = last.getNext(); }
		
		auxNode.setPrev(last);
		last.setNext(auxNode);
		size++;
	}
	
	
	// Add to index
	// O(n)
	public void addByIndex(E objParam, int index)
	{
		// Se index for errado
		if ( index<0 || index>size ) { System.out.println("Não dá pra adicionar no index: "+index); return; }
		// Se index for 0
		if ( index == 0 )             { addFirst(objParam); return; }
		// Se for IGUAL ao tamanho, isto é, colocar no final
		if ( index == (size) )      { addEnd(objParam); return; }
		
		
		auxNode = new Node<>(objParam); // Esse ficará no INDEX
		Node<E> current = head;         // Esse está no INDEX-1
		
		for (int i = 0; i < index-1 ; i++)
			current = head.getNext();
		
		
		// O próximo do que eu estou colocando (atual INDEX), será o próximo do atual (INDEX-1)
		auxNode.setNext( current.getNext() );
		
		// O anterior do auxNode será o que current(INDEX-1)
		auxNode.setPrev(current);
		
		// O anterior do que está no INDEX, será o auxNode
		current.getNext().setPrev(auxNode);
		
		// O próximo do que está no INDEX-1 (current), será o novo que coloquei
		current.setNext(auxNode);
		
		size++;
	}
	
	
	
	
	
	
	
}
