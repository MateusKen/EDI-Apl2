//******************** ATENÇÃO! *********************
// O conteúdo deste arquivo não deve ser modificado!
//******************** ATENÇÃO! *********************
// arquivo: src/apl2/LinkedListOriginal.java

package apl2;

public class LinkedListOriginal {
	
	private NodeOriginal head;
	private NodeOriginal tail;
	private int count;
	
	public LinkedListOriginal() {
		head = null;
		tail = null;
		count = 0;
	}
	
	public void destroy() {
		clear();
	}
	
	public void insert(int id, String nome, int inteiro, int decimo) {
		NodeOriginal node = new NodeOriginal(id, nome, inteiro, decimo, head);
		
		if (isEmpty()) {
			tail = node;
		}
		
		head = node;
		++count;
	}
	
	public void append(int id, String nome, int inteiro, int decimo) {
		NodeOriginal node = new NodeOriginal(id, nome, inteiro, decimo, null);
		
		if (isEmpty()) {
			head = node;
		} else {
			tail.setNext(node);
		}
		
		tail = node;
		++count;
	}
	
	public NodeOriginal removeHead() {
		if (isEmpty()) {
			return null;
		}
		
		NodeOriginal toRemove = head;

		head = head.getNext();
		--count;
		
		if (isEmpty()) {
			tail = null;
		}
		
		toRemove.setNext(null);
		return toRemove;
	}
	
	public NodeOriginal removeTail() {
		if (head == tail)
			return removeHead();
		
		NodeOriginal toRemove = head;
		NodeOriginal previous = null;
		while (toRemove != tail) {
			previous = toRemove;
			toRemove = toRemove.getNext();
		}
		
		tail = previous;
		tail.setNext(null);
		--count;
		
		toRemove.setNext(null);
		return toRemove;
	}
	
	public NodeOriginal removeNode(int id) {
		NodeOriginal toRemove = head;
		NodeOriginal previous = null;
		while (toRemove != null && toRemove.getId() != id) {
			previous = toRemove;
			toRemove = toRemove.getNext();
		}
		
		if (toRemove == null) {
			return null;
		}
		
		if (toRemove == head) {
			return removeHead();
		}
		
		if (toRemove == tail) {
			return removeTail();
		}
		
		previous.setNext(toRemove.getNext());
		--count;
		
		toRemove.setNext(null);		
		return toRemove;
	}

	public NodeOriginal getHead() {
		return head;
	}
	
	public NodeOriginal getTail() {
		return tail;
	}
	
	public NodeOriginal getNode(int id) {
		NodeOriginal node = head;
		while (node != null) {
			if (node.getId() == id) {
				return node;
			}
			node = node.getNext();
		}
		
		return null;
	}
	
	public int count() {
		return count;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void clear() {
		while (!isEmpty()) {
			removeHead();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("(" + count + ") \n");
		
		NodeOriginal node = head;
		while (node != null) {
			sb.append("(")
			.append(node.getId())
			.append(" # ")
			.append(node.getNome())
			.append(" # ")
			.append(node.getInteiro())
			.append(" # ")
			.append(node.getDecimo())
			.append(") -> \n");
			node = node.getNext();
		}
		sb.append("null.");
		
		return sb.toString();
	}

}
