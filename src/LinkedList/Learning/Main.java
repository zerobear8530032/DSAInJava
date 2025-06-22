package LinkedList.Learning;

public class Main {
	
	
	
	
	
	public static void main(String[] args) {
		LL list = new LL();
		
		list.insertAtFirst(3);
		list.insertAtFirst(2);
		list.insertAtFirst(1);
		list.insertAtLast(5);
		list.insertAtIndex(0, 0);
		list.insertAtIndex(4, 4);
		list.insertAtIndex(6, 6);
		list.display();
		list.display();
		System.out.println(list.find(10));
		list.insertAtIndex(10, 6);
		list.display();

	}

}
