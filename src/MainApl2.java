//*************************** ATENÇÃO! ****************************
// O método main() deve ser alterado somente nos comentários TODO.
// Todas as outras instruções devem permanecer intactas e o código
// deve funcionar conforme descrito no enunciado da atividade.
//*************************** ATENÇÃO! ****************************
// arquivo: src/MainApl2.java

// NOME: Enrico Cuono Alves Pereira		TIA: 32258798
// NOME: Erik Samuel Viana Hsu			TIA: 32265921
// NOME: Mateus Kenzo Iochimoto			TIA: 32216289
// NOME: Rodrigo Machado de Assis Oliveira de Lima		TIA: 32234678
// NOME: Thiago Shihan Cardoso Toma		TIA: 32210744

// TODO: Listar todas as referências consultadas para solucionar a atividade.

import java.io.IOException;
import java.util.Scanner;

import apl2.DLinkedList;
import apl2.Data;
import apl2.LinkedListOriginal;
import apl2.Node;
import apl2.NodeOriginal;
import apl2.Operation;

public class MainApl2 {
	
	public static void main(String[] args) {
		
		// Le o arquivo dados.txt e coloca todo o texto em uma string "conteudo"

		String conteudo = null;
		try {
		conteudo = Data.loadTextFileToString("dados.txt");
		} catch (IOException e) {
		System.err.println("Arquivo não encontrado!");
		e.printStackTrace();
		System.exit(-1); 
		}
		
		//Coloca cada linha em um node da lista
		LinkedListOriginal list = new LinkedListOriginal();
		
		String[] linhas = conteudo.split("\n");
		
		for (int i = 0; i < linhas.length; i++) {
			
			String linha = linhas[i];
			
			//Cada parte da linha em um atributo do node
			String[] partes = linha.split("#");
			list.append(Integer.parseInt(partes[0]), 
						partes[1], 
						Integer.parseInt(partes[2]), 
						Integer.parseInt(partes[3]));

		}
			
		boolean flag = false;
		
		 String opcoes = "\n\nMenu de Opções\n\n1 - Dados originais:\n2 - Dados convertidos:\n3 - Lista notas filtradas válidas:\n4 - Lista notas filtradas inválidas:\n5 - Média de notas válidas:\n6 - Notas acima da média:\n7 - Lista mapeada para uma única string:\n8 - Finaliza sistema.\n\n Opção:";
		
		 DLinkedList fixedList = Operation.map(list);
		 DLinkedList filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
		 DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
		 float average = Operation.reduce(filteredGradedList);
		 DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
		 String contents = Operation.mapToString(fixedList);
		 
		 Scanner ent = new Scanner(System.in);
		  int opcao = 0;
		  do{
		    System.out.print(opcoes);
		    opcao = ent.nextInt();
		    switch(opcao){
		      case 1:
				System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
				System.out.println(list);
				System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");
				break;
				
		      case 2:
		    	//Gerar o arquivo CSV.
		    	try {
		    		Data.saveStringToTextFile("dados.csv", contents);
		    	} catch(IOException e) {
		    		System.err.println("Erro ao gravar arquivo!\n");
		    	}
		   
				//DLinkedList fixedList = Operation.map(list);
				System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
				System.out.println(fixedList);
				System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");
				break;
				
		      case 3:
				//DLinkedList filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
				System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
				System.out.println(filteredGradedList);
				System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");
				break;
				
		      case 4:
		    	  
				//DLinkedList filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
				System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
				System.out.println(filteredNonGradedList);
				System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");
				break;
				
		      case 5:
		    	  
				//float average = Operation.reduce(filteredGradedList);
				System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
				System.out.println(average);
				System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");
				break;
				
		      case 6:
				//DLinkedList aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
				System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
				System.out.println(aboveAverageList);
				System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");
				break;
		      case 7:
				//String contents = Operation.mapToString(fixedList);
				System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
				System.out.println(contents);
				System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");
				break;
				
		      case 8:
		    	  System.out.println("Encerra o programa");
		          break;
		        }
		  }while (opcao != 8);
				//Item 2 do menu
				// TODO: Salvar o conteúdo da String contents em um arquivo chamado "dados.csv".
				String nomeArquivoCSV = "dados.csv";
				String conteudo2 = "* nó,da,DLinkedList";
				try {
					Data.saveStringToTextFile(nomeArquivoCSV, conteudo2);
				} catch (IOException e){
					System.err.println("Erro ao gravar arquivo!");
					e.printStackTrace();
				}
				
				Node test1 = fixedList.getNode("23.S1-999");
				System.out.println(">>>>>>>>>> test1 >>>>>>>>>>\n" + test1.getPrev().getId() + "<-"+ test1 + "->" + test1.getNext().getId() + "\n<<<<<<<<<< test1 <<<<<<<<<<\n");
				
				
				Node test2 = fixedList.removeNode("23.S1-999");
				System.out.println(">>>>>>>>>> test2 >>>>>>>>>>");
				if (test2 != null) {
				    System.out.println(test2.getPrev() + "<-(" + test2 + ")->" + test2.getNext());
				} else {
				    System.out.println("null <- (" + test2.getId() + ") -> null");
				}
				System.out.println("<<<<<<<<<< test2 <<<<<<<<<<\n");		
				
				Node test3 = fixedList.getNode("23.S1-999");
				System.out.println(">>>>>>>>>> test3 >>>>>>>>>>\n" + test3 + "\n<<<<<<<<<< test3 <<<<<<<<<<\n");
		
				aboveAverageList.clear();
				System.out.println(">>>>>>>>>> aboveAverageList.clear() >>>>>>>>>>\n" + aboveAverageList + "\n<<<<<<<<<< aboveAverageList.clear() <<<<<<<<<<\n");
		
				DLinkedList testList = new DLinkedList();
				// TODO: Inserir um nó no início da lista testList com os dados ("ABC", "John Doe", 4.7f).
				testList.insert("ABC", "John Doe", 4.7f);
				// TODO: Inserir um nó no final da lista testList com os dados ("XYZ", "Jane Doe", 9.9f).
				testList.append("XYZ", "Jane Doe", 9.9f);
				// TODO: Inserir um nó no início da lista testList com os dados ("321", "Test", 2.3f).
				testList.insert("321", "Test", 2.3f);
				// TODO: Inserir um nó no final da lista testList com os dados ("Nothing", "Yada yada yada", 99.9f).
				testList.append("Nothing", "Yada yada yada", 99.9f);
				System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
				System.out.println("testList.getHead(): " + testList.getHead());
				System.out.println("testList.getTail(): " + testList.getTail());
				System.out.println("testList.removeHead(): " + testList.removeHead());
				System.out.println("testList.removeTail(): " + testList.removeTail() + '\n');
				System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
				System.out.println("testList.getHead(): " + testList.getHead());
				System.out.println("testList.getTail(): " + testList.getTail());
				System.out.println("testList.removeNode(\"ABC\"): " + testList.removeNode("ABC") + '\n');
				System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
				System.out.println("testList.getHead(): " + testList.getHead());
				System.out.println("testList.getTail(): " + testList.getTail() + '\n');
				// TODO: Inserir um nó no início da lista testList com os dados ("qwerty", "QWERTY", 1.2f).
				testList.insert("qwerty", "QWERTY", 1.2f);
				// TODO: Inserir um nó no final da lista testList com os dados ("WASD", "wasd", 3.4f).
				testList.append("WASD", "wasd", 3.4f);
				// TODO: Inserir um nó no início da lista testList com os dados ("ijkl", "IJKL", 5.6f).
				testList.insert("ijkl", "IJKL", 5.6f);
				// TODO: Inserir um nó no final da lista testList com os dados ("1234", "Um Dois Tres Quatro", 7.8f).
				testList.append("1234", "Um Dois Tres Quatro", 7.8f);
				System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
				testList.clear();
				System.out.println(">>>>>>>>>> testList.clear() >>>>>>>>>>\n" + testList  + "\n<<<<<<<<<< testList.clear() <<<<<<<<<<\n");
		
	}

}
