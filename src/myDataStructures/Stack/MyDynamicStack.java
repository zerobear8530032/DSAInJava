package myDataStructures.Stack;
import java.util.EmptyStackException;
import myDataStructures.LinkedList.MySinglyLinkedList;

public class MyDynamicStack {

	MySinglyLinkedList stack ;
	int size =0;	

	int top;
	
	public MyDynamicStack () {// create default stack
		stack= new MySinglyLinkedList();
		size=0;
	}
	
	
	
	public void push(int x) {
		stack.insertAtHead(x);
		size=stack.getSize();
	}
	public int pop() {
	    if (isEmpty()) { // Use isEmpty() method for clarity
	        throw new EmptyStackException();
	    }
	    int output = stack.get(0);  
	    stack.deleteAtHead();  // Removing the top element from the stack
		size=stack.getSize(); // Update size after popping
	    return output;
	}
	public int peek() {// get top element without pop
		if(stack.isEmpty()) {
			throw new EmptyStackException();
		}
		return stack.get(0);
	}
	
	public boolean isEmpty () {// check stack is empty
		return size==0;
	}
	
	
	public boolean contains(int element) {// check element exists in stack or not 
		return stack.search(element);
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void clean() { // remove every thing from stack 
			stack.clear();
	}

	@Override
	public String toString() {
		return stack.toString();
		}
	
	
	
	
	public static void main(String[] args) {
		
		MyDynamicStack stack = new MyDynamicStack();
		System.out.println(stack);
		stack.push(0);
		System.out.println(stack);
		stack.push(1);
		System.out.println(stack);
		stack.push(2);
		System.out.println(stack);
		stack.push(3);
		System.out.println(stack);
		stack.push(4);
		System.out.println(stack);
		stack.push(5);
		System.out.println(stack);

		System.out.println("pop");
		
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);


	
		
	}

}
