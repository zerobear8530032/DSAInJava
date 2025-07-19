//Reverse first K of a Queue
//Difficulty: EasyAccuracy: 81.28%Submissions: 151K+Points: 2
//Given an integer k and a queue of integers, we need to reverse the order of the first k elements of the queue, leaving the other elements in the same relative order.
//
//Only following standard operations are allowed on queue.
//
//enqueue(x) : Add an item x to rear of queue
//dequeue() : Remove an item from front of queue
//size() : Returns number of elements in queue.
//front() : Finds front item.
//Note: The above operations represent the general processings. In-built functions of the respective languages can be used to solve the problem.
//
//"If the size of queue is smaller than the given k , then return the original queue."
//
//Examples:
//
//Input: q = [1, 2, 3, 4, 5], k = 3
//Output: [3, 2, 1, 4, 5]
//Explanation: After reversing the first 3 elements from the given queue the resultant queue will be 3 2 1 4 5
//Input: q = [4, 3, 2, 1], k = 4
//Output: [1, 2, 3, 4] 
//Explanation: After reversing the first 4 elements from the given queue the resultant queue will be 1 2 3 4 
//Constraints:
//1<=q[i]<=105
//1<=q.size()<=105
//1<=k<=105

package Queue;

import java.util.*;

public class ReverseFirstKOfAQueue_GFG {
//	approch :
//	first check q size is smaller then k if yes return original queue
//	if not then use a stack where we remove first k element from the queue and push in stack
//	now we keep count of remaining elements 
//	and now we can just remove all element from stack and push in the queue
//	and now we remove remaining element from queue from front and add it back at end 
//	in the queue 
//	time complexity :O(n)
//	space complexity :O(n)
	    public static Queue<Integer> reverseFirstK(Queue<Integer> q, int k) {
	        // code here
	        int size = q.size();
	        if(size<k){
	            return q;
	        }
	        Stack<Integer> stk= new Stack();
	        for(int i =0;i<k;i++){
	            stk.push(q.remove());
	        }
	        int remaining= size-k;
	        
	        
	        while(!stk.isEmpty()){
	            q.add(stk.pop());
	        }
	        for(int i =0;i<remaining;i++){
	            int x= q.remove();
	            q.add(x);
	        }
	        
	        return q;
	    }
	
	    
	    public static boolean check(Queue<Integer> ans, Queue<Integer> output) {
	    	if(ans.size()!=output.size()) {
	    		return false;
	    	}
	    	List<Integer> removeans = new ArrayList( ); 
	    	List<Integer> removeoutput = new ArrayList( ); 
	    	boolean pass = true;
	    	for(int i =0;i<ans.size();i++) {
	    		int a=ans.remove();
	    		int o = output.remove();
	    		if(a!=o) {
	    			pass=false;
	    		}
	    	}
	    	for(int x:removeans) {
	    		ans.add(x);
	    	}
	    	for(int x:removeoutput) {
	    		output.add(x);
	    	}
	    	return pass;
	    }

	public static void main(String[] args) {
		
		//Example 1 :
		
		Queue <Integer>q1 =  new ArrayDeque<Integer>( Arrays.asList(1, 2, 3, 4, 5));
		int k1 = 3;
		Queue <Integer>output1 =  new ArrayDeque<Integer>( Arrays.asList(3,2,1, 4, 5));

		//Example 2 :
		
		Queue <Integer>q2 =  new ArrayDeque<Integer>( Arrays.asList(4,3,2,1));
		Queue <Integer>output2 =  new ArrayDeque<Integer>( Arrays.asList(1,2,3,4));
		int k2 = 4;

		
		System.out.println("Best Approch :");
		
		Queue<Integer> ans1= reverseFirstK(q1,k1);
		Queue<Integer> ans2= reverseFirstK(q2,k2);
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(check(ans1,output1)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		

	}

}
