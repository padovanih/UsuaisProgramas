	public class StaticList<E> implements List<E> {
	
	protected E[] elements;
	int numElements;
	
	public StaticList(int maxSize) {
		elements = (E[])new Object[maxSize];
		numElements = 0;
	}
	public int numElements() {
		return numElements;
	}
	public boolean isEmpty() {
		return numElements == 0;
	}
	public boolean isFull() {
		return numElements == elements.length;
	}
	public void insert(E element, int pos) {
		if (isFull())
			System.out.println("ERRO: DEU PAU JUVENAL!!");
		if (pos < 0 || pos > numElements)
			System.out.println("ERRO: DEU PAU JUVENAL!!");
		for (int i = numElements-1; i >= pos; i--)
			elements[i+1] = elements[i];
		elements[pos] = element;
		numElements++;
	}
	public E remove(int pos) {
		if (pos < 0 || pos >= numElements)
			System.out.println("ERRO: DEU PAU JUVENAL!!");
		E element = elements[pos];
		for (int i = pos; i < numElements-1; i++)
			elements[i] = elements[i+1];
		elements[numElements-1] = null;
		numElements--;
		return element;
		
		
	}
	public E get(int pos) {
		if (pos < 0 || pos >= numElements)
			System.out.println("ERRO: DEU PAU JUVENAL!!");
		return elements[pos];
	}
	public int search(E element) {
		for (int i = 0; i < numElements; i++)
			if (element.equals(elements[i]))
				return i;
		return -1;
	}
	
	
	
	
	
	
	// *************************************
	
	
	
	
	public String toString(){
		String x = "[ ";
		int i=0;
		for (; i < numElements-1; i++)
		{
			x = x + this.get(i) + " , ";
		}
		x = x + this.get(i) + " ]";
		return x;
	}
	
	
	
	
	
	public boolean remove_e(E element){
		for (int i = 0; i < numElements; i++)
		{
			if (element.equals(this.elements[i]) )
			{
				//elements[i] = null;
				this.remove(i);
				return true;
			}
		}
		return false;
	}
	
	// EXERCÍCIO 6
	public void swap(int pos1, int pos2){
		E aux = elements[pos1];
		elements[pos1] = elements[pos2];
		elements[pos2] = aux;
	}
	
	// EXERCÍCIO 7
	public void flip(){
		for (int i =0;i < numElements/2 ;i++){
			this.swap(i, numElements-i-1);
			// Troca o primeiro com o ultimo, o segundo com o penúltimo, terceiro com antepenúltimo,
			// até chegar no meio.
		}
	}
	
	
	// EXERCÍCIO 8
	public void insert(List<E> list_param, int pos){
		int tamanho_da_lista_passada = list_param.numElements();
		
		// a variavel pos indica onde vai ser adicionado na list atual, já tem uma função que adiciona na posição que eu desejo,
		for (int i = 0; i < tamanho_da_lista_passada; i++) {
			// vou pegar o ulimo elemento e adicionar na posição desejada,
			// depois pego o penultimo e adiciono na posicao desejada,
			// lembra que quando eu adiciono, a funcao move todos os elementos que estãoa frente, uma posição pra frente
			this.insert(list_param.get(tamanho_da_lista_passada-1-i), pos);
		}
	}
	
	// pesquisa a partir de uma posição
	public int search(E element, int pos) {
		for (int i = pos; i < numElements; i++)
			if (element.equals(elements[i]))
				return i;
		return -1;
	}
	
	// Exercicio 9
	public void dedup(){
		int i=0;
		while (i<numElements){
			int resultado_da_pesquisa = this.search(this.get(i), i+1); // Pesquiso a partir do cara que eu estou agora.
			if (resultado_da_pesquisa != -1){ // se ecnontrou um cara igual o atual em uma posição mais adiante, eu devo deleta-lo
				this.remove(resultado_da_pesquisa);
				i--; // Devo decrementar o i, pois pode ser que a lista tenho mais de uma ocorrencia do mesmo elemento
					 // por exemplo: ['A','B','A','C','A']
					 // quando i=0, ele vai procurar pelo 'A' no vetor, depois de tirar o 'A' que tá na posição 2
					 // vai ficar:   ['A','B','C','A']
					 // e ai eu tenho que refazer com o mesmo 'i' pra poder retirar o outro 'A'
			}
			i++;
		}
	}
	
	
	// EXERCICIO 10
	public boolean equals(List list_param){
		// se tem tamanho diferente já pode parar.
		if(this.numElements != list_param.numElements()) {return false;}
		
		for (int i = 0; i < this.numElements; i++) {
			if ( this.get(i) != list_param.get(i) ) { return false; }
		}
		// se tudo for igual
		return true;
	}
	
	
	
	// EXERCICIO 11
	public StaticList<E> clone(){
		int tamanho_do_array = this.elements.length; // CUIDADO ISSO NÃO É O MESMO QUE QUANTOS ELEMENTOS QUE TEM NA LISTA
		
		StaticList<E> list_que_vai_ser_retornada = new StaticList<E>(tamanho_do_array);
		
		list_que_vai_ser_retornada.elements = this.elements;
		list_que_vai_ser_retornada.numElements = this.numElements;
		
		return list_que_vai_ser_retornada;
		
	}
	
	
	// exercicio 12
	public int remove(int ini, int fim){
		for (int i = ini; i <= fim; i++) {
			// ja existe uma função que remove UM elemento, e reorganiza os elementos
			// basta eu remover N vezes o elemento que está na posição INI
			// pois a função que remove reorganiza os elementos
			this.remove(ini);
		}
		return fim-ini+1;
	}
	
	
	// exercicio 13
	public List<E> split(int pos){
		
		int tamanho_do_ARRAY = this.elements.length; // NAO É O MESMO QUE A QUANTIDADE DE ELEMENTOS, é o tamanho do ARRAY
		
		List<E> nova_list = new StaticList<E>(tamanho_do_ARRAY);
		
		
		for (int i = pos; i < this.numElements; i++) {
			nova_list.insert( this.get(pos), i-pos ); // no primeiro loop:  i-pos = 0, no segundo loop: i-pos=1
			this.remove(i); // Isso faz com que eu sempre vá ter que pegar o elemento que tá no posição 'pos' do vetor atual.
		}
		
		
		return nova_list;
	}
	
	
	
}
