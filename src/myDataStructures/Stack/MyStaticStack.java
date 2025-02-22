package myDataStructures.Stack;

import java.security.InvalidAlgorithmParameterException;

import java.util.Arrays;
import java.util.EmptyStackException;

import java.util.Stack;




public class MyStaticStack {
	int [] stack ;
	int top;
	int size;
	
	private final int INITIAL_STACK= 1000;
	public MyStaticStack () {// create default stack
		stack = new int [this.INITIAL_STACK];
		top=-1;// empty stack so the top is -1
		size=this.INITIAL_STACK;
	}
	public MyStaticStack (int size) {//  initiate the stack custom size
		stack = new int [size];
		top=-1;// intial stack top =-1
		this.size = size;
	}
	
	
	public void push(int x) {
		if(isFull()) {// before push we check stack have space or not
			throw new   OutOfMemoryError();
		}
		top=top+1;// increment top 
		stack[top]=x;		
	}
	public int pop() {
		if(isEmpty()) {// before pop we check stack have element or not
			throw new   EmptyStackException();
		}
		int element = stack[top];
		top=top-1;
		return element;		
	}
	public int peek() {// get top element without pop

		return stack[top];// return top element
	}
	
	public boolean isEmpty () {// check stack is empty
		return top==-1; // if top ==-1 means stack is empty
	}
	public boolean isFull() {// check stack is full or not
		return top==stack.length-1;// if top is at the max length -1 means stack is full
	}
	
	public boolean contains(int element) {// check element exists in stack or not 
		for(int i=0;i<=top;i++) {
			if(stack[i]==element) {
				return true;
			}
		}
		return false;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void clean() { // remove every thing from stack 
			top=-1;
	}

	@Override
	public String toString() {
		if(top==-1) {
			return "[]";
		}
		StringBuilder str = new StringBuilder("[");
		for(int i=0;i<top;i++) {	
			str.append(stack[i]).append(",");
		}
		str.append(stack[top]).append("]");
		return str.toString();
	}
	
	
	
	
	public static void main(String[] args) {
		
		MyStaticStack stack = new MyStaticStack(5);

		System.out.println("is empty :" + stack.isEmpty());
		stack.push(21);
		System.out.println("is empty :" + stack.isEmpty());
		stack.push(24);
		stack.push(22);
		stack.push(21);
		stack.push(24);
		System.out.println("is Full :" + stack.isFull());
		System.out.println("stack :"+stack.toString());
		
		System.out.println("stack poped"+stack.pop());
		System.out.println("stack poped"+stack.pop());
		System.out.println("stack poped"+stack.pop());
		System.out.println("stack poped"+stack.pop());
		System.out.println("stack poped"+stack.pop());
		System.out.println(stack);
		stack.push(0);
		stack.push(1);
		stack.push(2);

		System.out.println("stack poped"+stack.pop());
		System.out.println("stack poped"+stack.pop());
		System.out.println("stack poped"+stack.pop());
		stack.push(3);
		stack.push(4);
		System.out.println(stack.contains(0));
		System.out.println(stack.peek());
		
		stack.clean();
		System.out.println(stack);
		
		
		
		
	}

}
