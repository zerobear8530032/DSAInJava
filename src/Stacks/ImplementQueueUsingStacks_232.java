//232. Implement Queue using Stacks
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
//
//Implement the MyQueue class:
//
//void push(int x) Pushes element x to the back of the queue.
//int pop() Removes the element from the front of the queue and returns it.
//int peek() Returns the element at the front of the queue.
//boolean empty() Returns true if the queue is empty, false otherwise.
//Notes:
//
//You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
//Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations.
// 
//
//Example 1:
//
//Input
//["MyQueue", "push", "push", "peek", "pop", "empty"]
//[[], [1], [2], [], [], []]
//Output
//[null, null, null, 1, 1, false]
//
//Explanation
//MyQueue myQueue = new MyQueue();
//myQueue.push(1); // queue is: [1]
//myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
//myQueue.peek(); // return 1
//myQueue.pop(); // return 1, queue is [2]
//myQueue.empty(); // return false
// 
//
//Constraints:
//
//1 <= x <= 9
//At most 100 calls will be made to push, pop, peek, and empty.
//All the calls to pop and peek are valid.
// 
//
//Follow-up: Can you implement the queue such that each operation is amortized O(1) time complexity? In other words, performing n operations will take overall O(n) time even if one of those operations may take longer.

package Stacks;
import java.util.*;
public class ImplementQueueUsingStacks_232 {
//	approch : here we use 2 stacks where we use a stk 1 where we push each time an 
//	element comes 
//	when pop we will pop all element from stk 1  and push in stk 2 
//	at the end the top of stk 2 is the element we have to pop 
//	so we will pop it 
//	and again pop all element from stk 2 and push back to stk 1
	static class MyQueueFastPush {
        Stack<Integer> stk1;
        Stack<Integer> stk2;

    public MyQueueFastPush() {
        stk1= new Stack();
        stk2= new Stack();
    }
    
    public void push(int x) {
        stk1.push(x);
    }
//    time complexity :O(n)
    public int pop() {
        swapElements(stk1,stk2);
        int res= stk2.pop();
        swapElements(stk2,stk1);
        return res;
    }
    private void swapElements(Stack<Integer> stk1, Stack<Integer> stk2){
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
    }
    
    public int peek() {
        swapElements(stk1,stk2);
        int res= stk2.peek();
        swapElements(stk2,stk1);
        return res;
    }
    
    public boolean empty() {
        return stk1.size()==0;
    }
    
    }
//
    
    
   static  class MyQueueFastPop {
        Stack<Integer> stk1;
        Stack<Integer> stk2;

    public MyQueueFastPop(){
        stk1= new Stack();
        stk2= new Stack();
    }
    
    public void push(int x) {
        swapElements(stk1,stk2);
        stk1.push(x);
        swapElements(stk2,stk1);
    }
    
    public int pop() {
        return stk1.pop();
    }
    private void swapElements(Stack<Integer> stk1, Stack<Integer> stk2){
        while(!stk1.isEmpty()){
            stk2.push(stk1.pop());
        }
    }
    
    public int peek() {
        return stk1.peek();
    }
    
    public boolean empty() {
        return stk1.size()==0;
    }
}
    


	
	public static void main(String[] args) {
		MyQueueFastPush myQueue1 = new MyQueueFastPush();
		myQueue1.push(1); // queue is: [1]
		myQueue1.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		myQueue1.peek(); // return 1
		myQueue1.pop(); // return 1, queue is [2]
		myQueue1.empty(); // return false
		
		
		MyQueueFastPop myQueue2 = new MyQueueFastPop();
		myQueue2.push(1); // queue is: [1]
		myQueue2.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		myQueue2.peek(); // return 1
		myQueue2.pop(); // return 1, queue is [2]
		myQueue2.empty(); // return false

	}

}
