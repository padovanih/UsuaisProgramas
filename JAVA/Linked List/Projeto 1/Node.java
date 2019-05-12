class Node<E>
{
	
	private Node<E> next;
	private Node<E> prev;
	
	private E obj;
	
	
	
	public Node()               { this.next=null; this.prev=null; this.obj = null;}
	public Node(E obj)          { this.next=null; this.prev=null; this.obj = obj;}
	
	// public Node(E obj1, E obj2) { this.next=obj1; this.prev=obj2; }
	
	
	
	// GET's
	public E getObj()        { return this.obj; }
	public Node<E> getNext() { return this.next; }
	public Node<E> getPrev() { return this.prev; }
	
	
	// SET's
	public void setObj(E obj)         { this.obj = obj; }
	public void setNext(Node<E> next) { this.next = next; }
	public void setPrev(Node<E> prev) { this.prev = prev; }
	
	
	
	
	
}
