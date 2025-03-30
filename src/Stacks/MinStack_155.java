//155. Min Stack
//Solved
//Medium
//Topics
//Companies
//Hint
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//Implement the MinStack class:
//
//MinStack() initializes the stack object.
//void push(int val) pushes the element val onto the stack.
//void pop() removes the element on the top of the stack.
//int top() gets the top element of the stack.
//int getMin() retrieves the minimum element in the stack.
//You must implement a solution with O(1) time complexity for each function.
//
// 
//
//Example 1:
//
//Input
//["MinStack","push","push","push","getMin","pop","top","getMin"]
//[[],[-2],[0],[-3],[],[],[],[]]
//
//Output
//[null,null,null,null,-3,null,0,-2]
//
//Explanation
//MinStack minStack = new MinStack();
//minStack.push(-2);
//minStack.push(0);
//minStack.push(-3);
//minStack.getMin(); // return -3
//minStack.pop();
//minStack.top();    // return 0
//minStack.getMin(); // return -2
// 
//
//Constraints:
//
//-231 <= val <= 231 - 1
//Methods pop, top and getMin operations will always be called on non-empty stacks.
//At most 3 * 104 calls will be made to push, pop, top, and getMin.


package Stacks;

import java.util.Stack;

// here we use 2 simple stack where one stack contain elements in order 
// and second contains element min at first
// as constructor we assign to stack of same size 
// for push we will push the val in first stack
// and check the current top in minstack if the top is smaller we will push top again
// if val is smaller we will push val on top of min stack
// for pop we just pop from both stack but we return the stack top not minstack top
//for top we can just return top without poping it from stack
// for min we can get top from min stack 

// time complexity : O(1)
// space complexity : O(2n)
class MinStack {
Stack<Integer> stk;
Stack<Integer>  minstk;
    public MinStack() {
        stk = new Stack();
        minstk = new Stack();
    }
    
    public void push(int val) {
        stk.push(val);
        if(minstk.isEmpty()){
            minstk.push(val);
        }else{
            int prevmin= minstk.peek();
            minstk.push(Math.min(prevmin,val));
        }
    }
    
    public void pop() {
        stk.pop();
        minstk.pop();
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return minstk.peek();
    }
}


public class MinStack_155 {
	
	

	public static void main(String[] args) {
		//Example 1:
		
		MinStack minStack = new MinStack();
		minStack.push(-2);
		minStack.push(0);
		minStack.push(-3);
		System.out.println(minStack.getMin()); // return -3
		minStack.pop();
		minStack.top();    // return 0
		System.out.println(minStack.getMin()); // return -3


	}

}
