// arquivo: src/apl2/DLinkedList.java

// TODO: Colocar a identificação dos(as) integrantes aqui.

package apl2;

// -- A classe DLinkedList (que pertence ao pacote apl2) deve implementar uma
// lista duplamente encadeada. Os nós dessa lista são do tipo [da classe] Node.
// -- A classe deve possuir dois nós especiais, head e tail, que são
// referências para o primeiro e último nó da lista, respectivamente.
// -- A classe deve possuir um contador de quantos nós existem na lista.
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com o conteúdo da lista.
// -- A classe deve implementar as operações a seguir, respeitando o
// comportamento descrito em cada operação.

public class DLinkedList {
	
	// TODO: Implementar a classe conforme o enunciado da atividade Apl2.


// OPERAÇÃO:		Método construtor
// COMPORTAMENTO:	Cria uma lista vazia.
	public DLinkedList() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		insert(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no início da lista.
	public void insert(/*dados da pessoa*/) {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		append(<dados da pessoa>)
// COMPORTAMENTO:	Aloca um Node que contém os <dados da pessoa> e insere o
//					novo nó no final da lista.
	public void append(/*dados da pessoa*/) {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO: 		removeHead()
// COMPORTAMENTO:	Remove o nó do início da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeHead() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		removeTail()
// COMPORTAMENTO:	Remove o nó do final da lista e retorna a referência do
//					nó removido.
//					Ou retorna null caso a lista esteja vazia.
	public Node removeTail() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		removeNode(<ID da pessoa>)
// COMPORTAMENTO:	Remove o nó que contém o <ID da pessoa> da lista e retorna
//					a referência do nó removido.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node removeNode(String id) {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		getHead()
// COMPORTAMENTO:	Retorna uma referência para o nó do início da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getHead() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		getTail()
// COMPORTAMENTO:	Retorna uma referência para o nó do final da lista.
//					Ou retorna null caso a lista esteja vazia.
	public Node getTail() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		getNode(<ID da pessoa>)
// COMPORTAMENTO:	Retorna uma referência para o nó que contém o <ID da pessoa>
//					da lista.
//					Ou retorna null caso não exista um nó com <ID da pessoa>.
	public Node getNode(String id) {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		count()
// COMPORTAMENTO:	Retorna a quantidade de nós da lista.
	public int count() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		isEmpty()
// COMPORTAMENTO:	Retorna true se a lista estiver vazia ou false, caso contrário.
	public boolean isEmpty() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		clear()
// COMPORTAMENTO:	Esvazia a lista, liberando a memória de todos os nós da lista.
	public void clear() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}


// OPERAÇÃO:		toString()
// COMPORTAMENTO:	Retorna uma string com o conteúdo da lista (caso queira, use o
//					exemplo do método toString() da classe LinkedListOriginal).
	@Override
	public String toString() {
		// TODO: Implementar o método e remover o lançamento de exceção abaixo.
		throw new UnsupportedOperationException("Método ainda não implementado.");
	}

}