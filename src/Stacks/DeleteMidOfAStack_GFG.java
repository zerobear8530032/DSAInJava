//Delete Mid of a Stack
//Difficulty: EasyAccuracy: 53.71%Submissions: 158K+Points: 2
//Given a stack s, delete the middle element of the stack without using any additional data structure.
//
//Middle element:- floor((size_of_stack+1)/2) (1-based indexing) from the bottom of the stack.
//
//Note: The output shown by the compiler is the stack from top to bottom.
//
//Examples:
//
//Input: s = [10, 20, 30, 40, 50]
//Output: [50, 40, 20, 10]
//Explanation: The bottom-most element will be 10 and the top-most element will be 50. Middle element will be element at index 3 from bottom, which is 30. Deleting 30, stack will look like {10 20 40 50}.
//Input: s = [10, 20, 30, 40]
//Output: [40, 30, 10]
//Explanation: The bottom-most element will be 10 and the top-most element will be 40. Middle element will be element at index 2 from bottom, which is 20. Deleting 20, stack will look like {10 30 40}.
//Input: s = [5, 8, 6, 7, 6, 6, 5, 10, 12, 9]
//Output: [9, 12, 10, 5, 6, 7, 6, 8, 5]
//Constraints:
//2 ≤ element of stack ≤ 105
//2 ≤ s.size() ≤ 104
//


package Stacks;

import java.util.*;

public class DeleteMidOfAStack_GFG {
	
	public static void pushAll(Stack<Integer> stk,List <Integer> list) {
		for(int x:list) {
			stk.add(x);
		}
	}
	
	
	 public static void deleteMid(Stack<Integer> s) {
		 int size = s.size();
		 int mid = (size+1) /2;
		 removeMid(s,mid,1,0);
		 s.pop();
	 }
	 
	 public static void removeMid(Stack<Integer> s, int mididx, int curr, int e) {
		 if(s.isEmpty()) {
			 s.push(e);
			 return ;
		 }
		 removeMid(s,mididx,curr+1,s.pop());
		 if(curr!=mididx) {			 
		 s.push(e);
		 }
	 }

	public static void main(String[] args) {	
		//Example 1 :
		
		Stack<Integer> s1 = new Stack();
		pushAll(s1,Arrays.asList(10, 20, 30, 40, 50));
		Stack<Integer> output1 = new Stack();
		pushAll(output1,Arrays.asList(50,40,20,10));

		//Example 2 :
		
		Stack<Integer> s2 = new Stack();
		pushAll(s2,Arrays.asList(10, 20,30,  40));
		Stack<Integer> output2 = new Stack();
		pushAll(output2,Arrays.asList(40,30,10));

		//Example 3 :
		
		Stack<Integer> s3 = new Stack();
		pushAll(s3,Arrays.asList(5, 8, 6, 7, 6, 6, 5, 10, 12, 9));
		Stack<Integer> output3 = new Stack();
		pushAll(output3,Arrays.asList(9, 12, 10, 5, 6, 7, 6, 8, 5));
		
		deleteMid(s1);
		deleteMid(s2);
		deleteMid(s3);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
//		System.out.println(s1.pop());

	}

}
