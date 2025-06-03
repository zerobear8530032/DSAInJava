//https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
//How to Reverse a Stack using Recursion
//Last Updated : 09 Apr, 2025
//Write a program to reverse a stack using recursion, without using any loop.
//
//Example: 
//
//Input: elements present in stack from top to bottom 4 3 2 1
//Output: 1 2 3 4
//
//Input: elements present in stack from top to bottom 1 2 3
//Output: 3 2 1
package Recursion;

import java.util.Stack;

public class ReverseTheStackRec {
	public static void reverseStackRec(Stack<Integer>  stk) {
		reverse(stk);
	}
	public static void reverse(Stack <Integer>stk) {
		if (!stk.isEmpty()) {
			int x = stk.pop();
			reverse(stk);
			insertAtBottom(stk, x);
		}
	}
	public static void insertAtBottom(Stack<Integer> stk,int n) {
		if (stk.isEmpty()) {
			stk.push(n);
		} else {
			int a = stk.pop();
			insertAtBottom(stk, n);
			stk.push(a);
		}
	}
	
	public static void main(String[] args) {
		Stack<Integer> stack1 = new Stack();
		stack1.push(4);
		stack1.push(3);
		stack1.push(2);
		stack1.push(1);
	
		
		reverseStackRec(stack1);
		System.out.println(stack1);
	}

}
