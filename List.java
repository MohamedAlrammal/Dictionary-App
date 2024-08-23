package application;

/***
 * This class is used as a list to be used in
 * the separate chaining hash table
 * 
 * Instance variables:
 * 	head node: represents the first node in the list
 */
public class List {
	
	private Node head;
	
	/***
	 * Add a new element to the singly linked list
	 * @param elem
	 */
	public void add(String elem) {
		Node newNode = new Node(elem);
		newNode.next = head;
		head = newNode;
	}
	
	/***
	 * Delete an element from the linked list
	 * @param elem
	 */
	public void delete(String elem) {
		Node current = head, previous = head;
		while(current != null && !current.wordToMeaning.equals(elem)) {
			previous = current;
			current = current.next;
		}
		if(current != null) {
			previous.next = current.next;
			if(head == current) {
				head = head.next;
			}
		}
	}
	
	/***
	 * Search by using the index
	 * @param index
	 * @return the element if exists else null
	 */
	public String search(int index) {
		Node current = head;
		int currentIndex = 0;
		while(current != null && currentIndex != index){
			current = current.next;
			currentIndex++;
		}
		if(current != null) {
			return current.wordToMeaning;
		}
		return null;
	}
	
	/***
	 * Search by using the the string itself
	 * @param index
	 * @return the element if exists else null
	 */
	public String search(String elem) {
		Node current = head;
		while(current != null && !current.wordToMeaning.equals(elem)){
			current = current.next;
		}
		if(current != null) {
			return current.wordToMeaning;
		}
		return null;
	}
	
	/***
	 * It is used to display the list elements for testing purposes only
	 */
	public void display() {
		Node current = head;
		System.out.print("{");
		while(current != null){
			System.out.print(current.wordToMeaning + ", ");
			current = current.next;
		}
		System.out.println("}");
	}
}
