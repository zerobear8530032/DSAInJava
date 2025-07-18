package Stacks.stackutil;

public class MyStack {
	protected int [] stack;
	private int top;
	private final int DEFAULT_SIZE=10;
	public MyStack(int size) {
		stack= new int [size];
		top=-1;
	}
	
	public MyStack() {
		stack= new int [DEFAULT_SIZE];
		top=-1;
	}
	
	
	public boolean push(int item) {
		if(isFull()) {
			throw new RuntimeException("Stack is Full");
//			return false;
		}
		top++;
		stack[top]=item;
		return true;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		int val= stack[top];
		top--;
		return val;
	}
	public int peek() {
		if(isEmpty()) {
			throw new RuntimeException("Stack is Empty");
		}
		return stack[top];
		}
	
	
	public boolean isFull() {
		return top==stack.length-1;
	}
	
	public boolean isEmpty() {
		return top==-1;
	}

	public static void main(String[] args) {

	}

}
