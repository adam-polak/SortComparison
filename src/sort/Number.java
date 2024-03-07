package sort;

public class Number {
	
	public class Node {
		int num;
		Node next;
		Node(int n, Node x) {
			num = n;
			next = x;
		}
	}
	
	private Node dummy = new Node(-1, null);
	private Node nextValue = dummy;
	
	/*
	 * Returns the value of the next node in the list.
	 */
	public int getNextNum() {
		if(nextValue != null && nextValue.next != null) {
			nextValue = nextValue.next;
			return nextValue.num;
		} else {
			nextValue = dummy;
			return -1;
		}
	}
	
	public Number() {
		randomGen();
	}
	
	public void showList() {
		System.out.println("-------------------------------------------------");
		Node check = dummy.next;
		while(check != null) {
			System.out.println(check.num);
			check = check.next;
		}
		System.out.println("-------------------------------------------------");
	}
	
	/*
	 * Creates a list of 100 random numbers between (0, 1,000]
	 */
	public void randomGen() {
		int random;
		dummy.next = null;
		Node prev = dummy.next;
		Node add;
		for(int i = 0; i < 100; i++) {
			random = (int)(Math.random() * 1000) + 1;
			add = new Node(random, prev);
			dummy.next = add;
			prev = add;
		}
		
		showList();
	}
	
	public Node getFirst() {
		return dummy.next;
	}
	
	public Node insert(Node x) {
		if(x == null || (x == dummy.next && x.next == null)) return null;
		
		Node current = x.next;
		Node temp = current;
		Node find = dummy;
		current = current.next;
		temp.next = null;
		boolean found = false;
		Node lag = find;
		int count = 0;
		
		found = false;
		while(find.next != null || count != 2) {
			if(temp.num <= find.next.num) {
				temp.next = find.next;
				find.next = temp;
				found = true;
				break;
			}
			System.out.println(find.num);
			lag = find;
			find = find.next;
			count++;
		}
		if(!found) find.next = temp;
		
		return current;
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
		
		showList();
	}

}
