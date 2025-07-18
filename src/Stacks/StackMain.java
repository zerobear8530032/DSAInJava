package Stacks;

import Stacks.stackutil.MyDynamicStack;
import Stacks.stackutil.MyStack;

public class StackMain {
	public static void main(String[] args) {		
		MyDynamicStack stk = new MyDynamicStack();
		
		stk.push(1);
		stk.push(2);
		stk.push(3);
		stk.push(4);
		stk.push(5);
		stk.push(6);
		stk.push(7);
		stk.push(8);
		stk.push(9);
		stk.push(10);
		stk.push(11);
		stk.push(11);
		stk.push(11);
		stk.push(11);
		
		System.out.println("pop elements ");
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.peek());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		System.out.println(stk.pop());
		
	}

}
