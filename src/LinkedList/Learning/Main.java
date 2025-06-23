package LinkedList.Learning;

public class Main {
	
	
	
	
	
	public static void main(String[] args) {
//		LL list = new LL();
//		
//		list.insertAtFirst(3);
//		list.insertAtFirst(2);
//		list.insertAtFirst(1);
//		list.insertAtLast(5);
//		list.insertAtIndex(0, 0);
//		list.insertAtIndex(4, 4);
//		list.insertAtIndex(6, 6);
//		list.display();
//		list.display();
//		System.out.println(list.find(10));
//		list.insertAtIndex(10, 6);
//		list.display();
		
		
		DLL dlist= new DLL();
		
		dlist.addAtIndex(0,0);
		dlist.addAtIndex(5,1);
		dlist.addAtIndex(2,2);
		dlist.addAtIndex(4,1);
		dlist.insertAfterVal(2,12);
		dlist.display();
		dlist.displayRevese();
		
		System.out.println();
		
		
	}

}
