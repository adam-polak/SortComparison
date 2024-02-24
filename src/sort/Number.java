package sort;

public class Number {
	
	private class Node {
		int num;
		Node next;
		Node(int n, Node x) {
			num = n;
			next = x;
		}
	}
	
	Node dummy = new Node(-1, null);
	
	public Number() {
		randomGen();
	}
	
	/*
	 * Creates a list of 100 random numbers between (0, 1,000]
	 */
	public void randomGen() {
		int random;
		Node prev = dummy.next;
		Node add;
		for(int i = 0; i < 100; i++) {
			random = (int)(Math.random() * 1000) + 1;
			add = new Node(random, prev);
			dummy.next = add;
			prev = add;
		}
	}
	
	/*
	 * Uses insertion sort to sort the 1000 numbers;
	 */
	public void insertionSort() {
		Node lag = dummy.next;
		Node current = lag == null ? null : lag.next;
		Node temp = current;
		if(lag != null) lag.next = null;
		Node find;
		boolean found = false;
		while(current != null) {
			temp = current;
			current = current.next;
			temp.next = null;
			
			find = dummy;
			found = false;
			while(find.next != null) {
				if(temp.num <= find.next.num) {
					temp.next = find.next;
					find.next = temp;
					found = true;
					break;
				}
				find = find.next;
			}
			if(!found) find.next = temp;
		}
	}

}
