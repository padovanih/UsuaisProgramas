class Node<E>
{
	public E obj;
	public Node<E> next;
	public Node<E> prev;
	
	
	public Node(E obj) { this.obj = obj; this.next=null; this.prev=null;}
	
	
	
	
	
	
	
	// GET
	public E       getOBJ()  { return this.obj;  }
	public Node<E> getNext() { return this.next; }
	
	
	// SET
	public void setOBJ(E obj)         { this.obj = obj;   }
	public void setNext(Node<E> next) { this.next = next; }
	public void setPrev(Node<E> prev) { this.prev = prev; }
	
	// INSERT
	//public void addFirst(E obj) {}
	
	
	
	
	
	
}
