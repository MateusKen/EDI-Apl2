//*************************** ATENÇÃO! *****************************
// As assinaturas dos métodos desta classe não devem ser alteradas!
//*************************** ATENÇÃO! *****************************
// arquivo: src/apl2/Operation.java

// TODO: Colocar a identificação dos(as) integrantes aqui.

package apl2;

public class Operation {

	/**
	 * <p>Recebe como parâmetro uma lista encadeada do tipo {@code LinkedListOriginal}, sendo que os nós da lista estão
	 * populados com o conteúdo da base de dados original (conteúdo do arquivo dados.txt).</p>
	 * <p>A operação {@code map()} deve mapear os dados originais para uma lista encadeada do tipo {@code DLinkedList} e
	 * retornar a referência da {@code DLinkedList} que possui os dados mapeados para a nova estrutura usada pelo sistema de notas.</p>
	 * 
	 * @param original Base de dados original carregada em uma {@code LinkedListOriginal}.
	 * @return Uma nova {@code DLinkedList} que contém o mapeamento da coleção de dados {@code original} para a nova estrutura usada pelo sistema de notas. 
	 */
	public static DLinkedList map(final LinkedListOriginal list) {
		DLinkedList ListaMapeada = new DLinkedList(); //Cria a DLinkedList "ListaMapeada"
		NodeOriginal pAnda = list.getHead();
		
		
		while(pAnda != null) {
			//Pega os dados do nó da LinkedListOriginal
			int id = pAnda.getId();
			String nome = pAnda.getNome();
			int inteiro = pAnda.getInteiro();
			int decimo = pAnda.getDecimo();
			NodeOriginal next = pAnda.getNext();
			
			
			String IdNovo = "23.S1-" + id;
			Node noNovo = new Node();
			noNovo.setId(IdNovo);
			noNovo.setNome(nome);
			
			float nota;
			if (inteiro == -1 || decimo == -1) {
				nota = 99.9f;
			}
			
			else if (decimo == 0) {
				nota = inteiro + 0.0f;
			} else {
				nota = ((float) inteiro + ((float) decimo) / 10);
			}
			noNovo.setNota(nota);
			
			if (next != null) {
				Node nextNode = new Node();
				nextNode.setId(String.valueOf(next.getId()));
				nextNode.setNome(next.getNome());
				nextNode.setNota(((float) next.getInteiro() + (float) next.getDecimo()) / 10);
				noNovo.setNext(nextNode);
			}
			
			ListaMapeada.append(IdNovo, nome, nota);
			pAnda = next;
		}
		
		return ListaMapeada;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code filterRemoveNonGraded()} deve filtrar os nós que não possuem notas válidas (caso de "ausência de nota")
	 * e retornar uma nova lista do tipo {@code DLinkedList} contendo apenas os nós com notas válidas.</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada com nós que possuem apenas pessoas com notas válidas.
	 */
	public static DLinkedList filterRemoveNonGraded(final DLinkedList data) {
		DLinkedList ListaValida = new DLinkedList(); //Cria a DLinkedList "ListaValida"
		Node pAnda = data.getHead();
		
		while(pAnda != null) {
			float nota = pAnda.getNota();
			if (nota == 99.9f) 
				pAnda = pAnda.getNext();		
			else {	
				ListaValida.append(pAnda.getId(),pAnda.getNome(),pAnda.getNota());
				pAnda = pAnda.getNext();
			}
		}
		
		return ListaValida;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code filterRemoveGraded()} deve filtrar os nós que possuem notas válidas e retornar uma nova lista do
	 * tipo {@code DLinkedList} contendo apenas os nós com notas inválidas (caso de "ausência de nota").</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada com nós que possuem apenas pessoas com notas inválidas.
	 */
	public static DLinkedList filterRemoveGraded(final DLinkedList data) {
		DLinkedList ListaInvalida = new DLinkedList(); //Cria a DLinkedList "Listainvalida"
		Node pAnda = data.getHead();
		
		while(pAnda != null) {
			float nota = pAnda.getNota();
			if (nota != 99.9f) 
				pAnda = pAnda.getNext();			
			else {
				ListaInvalida.append(pAnda.getId(),pAnda.getNome(),pAnda.getNota());
				pAnda = pAnda.getNext();
			}
		}
		
		return ListaInvalida;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code filterRemoveNonGraded()}, e a média de notas válidas, calculadas com a
	 * operação {@code reduce()}.</p>
	 * <p>A operação {@code filterRemoveBelowAverage()} deve filtrar os nós que possuem notas abaixo da média e retornar uma
	 * nova lista do tipo {@code DLinkedList} contendo apenas os nós com notas acima da média.
	 * 
	 * @param data Base de dados filtrada com a operação {@code filterRemoveNonGraded()}.
	 * @param average Média de notas válidas calculada com a operação {@code reduce()}.
	 * @return Uma nova {@code DLinkedList} que contém a coleção de dados ({@code data}) filtrada somente com pessoas com notas maiores do que {@code average}.
	 */
	public static DLinkedList filterRemoveBelowAverage(final DLinkedList data, float average) {
		Node pAnda = data.getHead();
		DLinkedList ListaAcimaMedia = new DLinkedList(); //Cria a DLinkedList "ListaAcimaMedia"
		
		while(pAnda != null) {
			float nota = pAnda.getNota();
			if (nota < average) {
				pAnda = pAnda.getNext();
				}
			else {
				ListaAcimaMedia.append(pAnda.getId(),pAnda.getNome(),pAnda.getNota());
				pAnda = pAnda.getNext();
			}
		}
		
		return ListaAcimaMedia;
	}
	
	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code filterRemoveNonGraded()}.</p>
	 * <p>A operação {@code reduce()} deve calcular a média das notas contidas na coleção de dados passada como parâmetro e
	 * retornar a média calculada.
	 * 
	 * @param data Base de dados filtrada com a operação {@code filterRemoveNonGraded()}.
	 * @return Média das notas ({@code float}) contidas na coleção de dados ({@code data}).
	 */
	public static float reduce(final DLinkedList data) {
		Node pAnda = data.getHead();
		float soma = 0;
		int count = 0;
		
		while(pAnda != null) {
			float nota = pAnda.getNota();
			if (nota == 99.9f) {
				nota = 0;
			}
			soma+=nota;
			count+=1;
			pAnda = pAnda.getNext();
		}
		float media = soma/count;
		return media;
	}

	/**
	 * <p>Recebe como parâmetro uma lista duplamente encadeada do tipo {@code DLinkedList}, sendo que os nós da lista estão
	 * populados com o resultado da operação {@code map()}.</p>
	 * <p>A operação {@code mapToString()} deve mapear todos os nós da coleção de dados passada como parâmetro para uma única
	 * {@code String}, sendo que cada dado de uma pessoa é separado por ponto-e-vírgula (;) e cada pessoa é separada por uma
	 * quebra de linha.</p>
	 * 
	 * @param data Base de dados mapeada para o formato {@code DLinkedList} (via operação {@code map()}).
	 * @return {@code String} com a coleção de dados separada por ponto-e-vírgula (dados de cada pessoa) e quebras de linha (cada pessoa).
	 */
	public static String mapToString(final DLinkedList data) {
		String StringFormatada = "";
		Node pAnda = data.getHead();
		
		while(pAnda != null) {
			StringFormatada += pAnda.getId() + ";";
			StringFormatada += pAnda.getNome() + ";";
			StringFormatada += pAnda.getNota() + "\n";
			pAnda = pAnda.getNext();
		}
	
		return StringFormatada;
		
	}

}
