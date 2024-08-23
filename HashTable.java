package application;

/***
 * This class is used as a separate chaining hash table for the dictionary application
 * 
 * NOTE : does not work properly with duplicates.
 * Instance variables:
 * 	arr : hold the lists that hold the values
 * 	isThereMemory : to check if there is enough memory or not
 * 	nItems : to check for the number of occupied elements 
 */
public class HashTable implements Constants{
	
	private List arr[];
	private boolean isThereMemory;
	private int nItems;
	
	/***
	 * initialize the instance variables
	 * if size is too big then use the SUGGESTED_MEMORY
	 * @param size
	 */
	public HashTable(int size) {
		try {
			isThereMemory = true;
			nItems = 0;
			arr = new List[size];
			for(int i = 0;i < size;i++) {
				arr[i] = new List();
			}
		}catch(OutOfMemoryError e) {
			arr = null;
			arr = new List[SUGGESTED_MEMORY];
			for(int i = 0;i < SUGGESTED_MEMORY;i++) {
				arr[i] = new List();
			}
		}
	}
	
	/***
	 * It only hashes the ASCII characters
	 * @param elem
	 * @return hash value
	 */
	private int hashFn(String elem) {
		int hashval = 0;
		for(int i = 0;i < elem.length();i++) {
			if(elem.charAt(i) > ASCII_MAX) {return ERROR_CODE;}
			
			hashval = ((hashval << MULTIPLIER) + elem.charAt(i)) % arr.length;// (<< MULTIPLIER) is the same as multiply by 2^multiplier
		}
		
		return hashval;
	}
	
	/***
	 * add an element to the hashTable
	 * @param elem
	 */
	public void add(String elem) {
		int hashval = hashFn(elem);
		
		if(hashval == ERROR_CODE) {
			System.out.println("Error: non ASCII characters have been entered");
			return;
		}
		
		if(isThereMemory) {
			try {
				arr[hashval].add(elem);
				nItems += 1;
				if(nItems / arr.length >= 2) {rehash();}
			}catch(OutOfMemoryError e) {
				isThereMemory = false;
			}
		}
	}
	
	/***
	 *Rehashes if the load factor >= 2 to keep high performance
	 */
	private void rehash() {
		List arr2[] = arr;
		String elem;
		int initailSize = arr.length, newSize = 2 * arr.length;
		arr = new List[newSize];
		int j = 1;
		
		for(int i = 0;i < newSize;i++) {
			arr[i] = new List();
		}
		
		for(int i = 0;i < initailSize;i++) {
			elem = arr2[i].search(0);
			while(elem != null) {
				int hashval = hashFn(elem);
				arr[hashval].add(elem);
				elem = arr2[i].search(j);
				j++;
			}
			j = 1;
		}
	}
	
	/***
	 * Delete the wanted element if found else do nothing
	 * @param elem
	 */
	public void delete(String elem) {
		
		int hashval = hashFn(elem);
		if(hashval == ERROR_CODE) {
			System.out.println("Error: Not found");
			return;
		}
		arr[hashval].delete(elem);
	}
	
	/***
	 * It is used to display the under hood array for testing purposes only
	 */
	public void display() {
		for(List list : arr) {
			list.display();
		}
	}
}
