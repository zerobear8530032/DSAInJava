//1381. Design a Stack With Increment Operation
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Design a stack that supports increment operations on its elements.
//
//Implement the CustomStack class:
//
//CustomStack(int maxSize) Initializes the object with maxSize which is the maximum number of elements in the stack.
//void push(int x) Adds x to the top of the stack if the stack has not reached the maxSize.
//int pop() Pops and returns the top of the stack or -1 if the stack is empty.
//void inc(int k, int val) Increments the bottom k elements of the stack by val. If there are less than k elements in the stack, increment all the elements in the stack.
// 
//
//Example 1:
//
//Input
//["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
//[[3],[1],[2],[],[2],[3],[4],[5,100],[2,100],[],[],[],[]]
//Output
//[null,null,null,2,null,null,null,null,null,103,202,201,-1]
//Explanation
//CustomStack stk = new CustomStack(3); // Stack is Empty []
//stk.push(1);                          // stack becomes [1]
//stk.push(2);                          // stack becomes [1, 2]
//stk.pop();                            // return 2 --> Return top of the stack 2, stack becomes [1]
//stk.push(2);                          // stack becomes [1, 2]
//stk.push(3);                          // stack becomes [1, 2, 3]
//stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
//stk.increment(5, 100);                // stack becomes [101, 102, 103]
//stk.increment(2, 100);                // stack becomes [201, 202, 103]
//stk.pop();                            // return 103 --> Return top of the stack 103, stack becomes [201, 202]
//stk.pop();                            // return 202 --> Return top of the stack 202, stack becomes [201]
//stk.pop();                            // return 201 --> Return top of the stack 201, stack becomes []
//stk.pop();                            // return -1 --> Stack is empty return -1.
// 
//
//Constraints:
//
//1 <= maxSize, x, k <= 1000
//0 <= val <= 100
//At most 1000 calls will be made to each method of increment, push and pop each separately.



package Stacks;

public class DesignAStackWithIncrementOperation_1381 {
//	approch is simple:
//	implement a stack n the way you want
//	when increse k operation comes 
//	just increment the  starting k values of the stack 
	
	static class CustomStack {
	    int [] stack;
	    int top=-1;
	    public CustomStack(int maxSize) {
	        stack =new int [maxSize];
	    }
//	time complexity :O(1)    
//	space complexity :O(1)    
	    public boolean isEmpty(){
	        return top==-1;
	    }
//	time complexity :O(1)    
//	space complexity :O(1)    
	    public boolean isFull(){
	        return top==stack.length-1;
	    }
//	time complexity :O(1)    
//	space complexity :O(1)    
	    public void push(int x) {
	        if(isFull()){
	            return ;
	        } 
	        top++;
	        stack[top]=x;       
	    }
	    
//	time complexity :O(1)    
//	space complexity :O(1)    
	    public int pop() {
	        if(isEmpty()){
	            return -1;
	        }      
	        int val = stack[top];
	        top--;
	        return val;
	    }
	    
//	time complexity :O(k)    
//	space complexity :O(1)    
	    public void increment(int k, int val) {
	        for(int i =0;i<k;i++){
	            if(i>top){
	                break;
	            }
	            stack[i]+=val;
	        }
	    }
	}

	/**
	 * Your CustomStack object will be instantiated and called as such:
	 * CustomStack obj = new CustomStack(maxSize);
	 * obj.push(x);
	 * int param_2 = obj.pop();
	 * obj.increment(k,val);
	 */

	public static void main(String[] args) {
		
		CustomStack stk = new CustomStack(3); // Stack is Empty []
		stk.push(1);                          // stack becomes [1]
		stk.push(2);                          // stack becomes [1, 2]
		System.out.println(stk.pop());        // return 2 --> Return top of the stack 2, stack becomes [1]
		stk.push(2);                          // stack becomes [1, 2]
		stk.push(3);                          // stack becomes [1, 2, 3]
		stk.push(4);                          // stack still [1, 2, 3], Do not add another elements as size is 4
		stk.increment(5, 100);                // stack becomes [101, 102, 103]
		stk.increment(2, 100);                // stack becomes [201, 202, 103]
		System.out.println(stk.pop());		  // return 103 --> Return top of the stack 103, stack becomes [201, 202]
		System.out.println(stk.pop());        // return 202 --> Return top of the stack 202, stack becomes [201]
		System.out.println(stk.pop());        // return 201 --> Return top of the stack 201, stack becomes []
		System.out.println(stk.pop());        // return -1 --> Stack is empty return -1.



	}

}
