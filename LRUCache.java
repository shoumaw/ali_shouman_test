import java.util.HashMap;

public class LRUCache<T>{
	
	abstract class CachedObject<T>{
		T value;
		public abstract Boolean isExpired();
	} 

	class Node<T>{
		CachedObject<T> value;
		int key;
		Node previous;
		Node next;
	}
	HashMap<Integer, Node<T>> hashmap;
	Node start, end;
	int size;
	public LRUCache( int size) {
		hashmap = new HashMap<Integer, Node<T>>();
		this.size = size;
	}

	public CachedObject<T> getEntry(int key) {
		if (hashmap.containsKey(key)) 
		{
			Node entry = hashmap.get(key);
			removeNode(entry);
			addToStart(entry);
			return entry.value;
		}
		return null;
	}

	public void putEntry(int key, CachedObject<T>  value) {
		if (hashmap.containsKey(key)) 
		{
			Node node = hashmap.get(key);
			node.value = value;
			removeNode(node);
			addToStart(node);
		} else {
			Node newNode = new Node();
			newNode.previous = null;
			newNode.next = null;
			newNode.value = value;
			newNode.key = key;
			if (hashmap.size() > size)
			{
				hashmap.remove(end.key);
				removeNode(end);				
				addToStart(newNode);

			} else {
				addToStart(newNode);
			}

			hashmap.put(key, newNode);
		}
	}
	public void addToStart(Node node) {
		node.next = start;
		node.previous = null;
		if (start != null)
			start.previous = node;
		start = node;
		if (end == null)
			end = start;
	}

	public void removeNode(Node node) {

		if (node.previous != null) {
			node.previous.next = node.next;
		} else {
			start = node.next;
		}

		if (node.next != null) {
			node.next.previous = node.previous;
		} else {
			end = node.previous;
		}
	}

	public void removeExpiredNodes(){
		Node currentNode = start;
		while(currentNode.next != null){
			if (currentNode.value.isExpired()){
				removeNode(currentNode);
			}
			currentNode = currentNode.next;
		}
	}
}