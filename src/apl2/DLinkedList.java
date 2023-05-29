// arquivo: src/apl2/DLinkedList.java

// NOME: Enrico Cuono Alves Pereira		TIA: 32258798
// NOME: Erik Samuel Viana Hsu			TIA: 32265921
// NOME: Mateus Kenzo Iochimoto			TIA: 32216289
// NOME: Rodrigo Machado de Assis Oliveira de Lima		TIA: 32234678
// NOME: Thiago Shihan Cardoso Toma		TIA: 32210744

package apl2;

public class DLinkedList {
	
	private Node head;
	private Node tail;
	private int count;
	

// OPERAÇÃO:		Método construtor
// COMPORTAMENTO:	Cria uma lista vazia.
	public DLinkedList() {
		head = null;
		tail = null;
		count = 0;
	}

	
// OPERAÇÃO:		insert(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//						novo nó no início da lista.
	public void insert(String id, String nome, float nota) {
		Node node = new Node(id, nome, nota, head, null);
		    
		if (isEmpty()) {
		    tail = node;
		} else {
		    head.setPrev(node);
		}
		    
		head = node;
		count++;
	}



// OPERAÇÃO:		append(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//							novo nó no final da lista.
	public void append(String id, String nome, float nota) {
		Node node = new Node(id, nome, nota, null, tail);
			    
		if (isEmpty()) {
			head = node;
		} else {
			tail.setNext(node);
		}
		
		tail = node;
		count++;
	}



// OPERAÇÃO: 		removeHead()
// COMPORTAMENTO:	Remove o nó do início da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeHead() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		if (isEmpty()) {
			return null;
		}
		
		Node toRemove = head;

		head = head.getNext();
		--count;
		
		if (isEmpty()) {
			tail = null;
		}
		else {
			head.setPrev(null);
		}
		
		toRemove.setNext(null);
		return toRemove;
	}


// OPERAÇÃO:		removeTail()
// COMPORTAMENTO:	Remove o nó do final da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeTail() {
		if (isEmpty()) 
			return null;
		if (head == tail)
			return removeHead();
		
		Node toRemove = tail;
		
		tail = tail.getPrev();
		--count;
		
		tail.setNext(null);

		toRemove.setPrev(null);
		return toRemove;
	}


// OPERAÇÃO:		removeNode(<ID da pessoa>)
// COMPORTAMENTO:	Remove o nó que contém o <ID da pessoa> da lista e retorna
//					a referência do nó removido.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node removeNode(String id) {
	    Node pAnda = head;

	    while (pAnda != null) {
	        if (pAnda.getId().equals(id)) {
	            Node prox = pAnda.getNext();
	            Node ant = pAnda.getPrev();

	            if (ant != null) {
	                ant.setNext(prox);
	            } else {
	                head = prox;
	            }

	            if (prox != null) {
	                prox.setPrev(ant);
	            } else {
	                tail = ant;
	            }

	            pAnda.setNext(null);
	            pAnda.setPrev(null);

	            --count;
	            return pAnda;
	        }
	        
	        pAnda = pAnda.getNext();
	    }
	    
	    return null;
	}



// OPERAÇÃO:		getHead()
// COMPORTAMENTO:	Retorna uma referência para o nó do início da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getHead() {
		return head;
	}


// OPERAÇÃO:		getTail()
// COMPORTAMENTO:	Retorna uma referência para o nó do final da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getTail() {
		return tail;
	}


// OPERAÇÃO:		getNode(<ID da pessoa>)
// COMPORTAMENTO:	Retorna uma referência para o nó que contém o <ID da pessoa>
//					da lista.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node getNode(String id) {
		Node pAnda = head;
		
		while(pAnda != null) {
			if(pAnda.getId().equals(id)) {
				return pAnda;
			}
			pAnda = pAnda.getNext();
		}
		
		return null;
		
	}
		


// OPERAÇÃO:		count()
// COMPORTAMENTO:	Retorna a quantidade de nós da lista.
	public int count() {
		return count;
	}


// OPERAÇÃO:		isEmpty()
// COMPORTAMENTO:	Retorna true se a lista estiver vazia ou false, caso contrário.
	public boolean isEmpty() {
		return head == null;
	}


// OPERAÇÃO:		clear()
// COMPORTAMENTO:	Esvazia a lista, liberando a memória de todos os nós da lista.
	public void clear() {
		while (!isEmpty()) {
			removeHead();	
		}
	}


// OPERAÇÃO:		toString()
// COMPORTAMENTO:	Retorna uma string com o conteúdo da lista (caso queira, use o
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(" + count + ") \n");
		
		Node node = head;
		while (node != null) { 
			if (node.getPrev() != null) { //Quando o nó anterior não for null
				sb.append(node.getPrev().getId());
			}
			else {
				sb.append("null");
			}
			
			sb.append(" <-(")
			.append(node.getId())
			.append("; ")
			.append(node.getNome())
			.append("; ")
			.append(node.getNota())
			.append(")-> ");
			
			if(node.getNext() != null) { //Quando o próximo nó não for null
				sb.append(node.getNext().getId());
			}
			else {
				sb.append("null");
			}
			sb.append("\n");
			node = node.getNext();
		}
		
		
		return sb.toString();
	}

}
