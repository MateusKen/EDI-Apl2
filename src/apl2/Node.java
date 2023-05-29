// arquivo: src/apl2/Node.java

// NOME: Enrico Cuono Alves Pereira		TIA: 32258798
// NOME: Erik Samuel Viana Hsu			TIA: 32265921
// NOME: Mateus Kenzo Iochimoto			TIA: 32216289
// NOME: Rodrigo Machado de Assis Oliveira de Lima		TIA: 32234678
// NOME: Thiago Shihan Cardoso Toma		TIA: 32210744


package apl2;

// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

public class Node {
	
private String id;
private String nome;
private float nota;
private Node next;
private Node prev;

  public Node(){
    this("", "", 0, null, null);
  }
  
  public Node(String id, String nome, float nota, Node next, Node prev){
    this.id = id;
    this.nome = nome;
    this.nota = nota;
    this.next = next;
    this.prev = prev;
  }
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public float getNota() {
		return nota;
	}
	
	public void setNota(float nota) {
		this.nota = nota;
	}

  	public Node getNext(){
    		return next;
  	}

  	public void setNext(Node next){
    		this.next = next;
  	}

  	public Node getPrev(){
    		return prev;
  	}	

  	public void setPrev(Node prev){
    		this.prev = prev;
  	}

  @Override
  public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append(prev == null ? "null" : prev.getId());
	    sb.append(" <- ");
	    sb.append("(");
	    sb.append(id);
	    sb.append(";");
	    sb.append(nome);
	    sb.append(";");
	    sb.append(nota);
	    sb.append(")");
	    sb.append(" -> ");
	    sb.append(next == null ? "null" : next.getId());
	    return sb.toString();
	    
	}
} 
