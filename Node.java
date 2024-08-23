package application;

/***
 * This class is used to save the data of every word and its meaning
 * in the dictionary and it represents the nodes in the list class
 * 
 * Instance variables:
 * 	wordToMeaning : holds the word and its meaning
 * 	next : reference to the next node
 */
public class Node {
	public String wordToMeaning;
	public Node next;
	
	public Node(String elem) {
		wordToMeaning = elem;
		next = null;
	}
	
	public String toString() {return wordToMeaning;}
	
}
