//895. Maximum Frequency Stack
//Hard
//Topics
//Companies
//Design a stack-like data structure to push elements to the stack and pop the most frequent element from the stack.
//
//Implement the FreqStack class:
//
//FreqStack() constructs an empty frequency stack.
//void push(int val) pushes an integer val onto the top of the stack.
//int pop() removes and returns the most frequent element in the stack.
//If there is a tie for the most frequent element, the element closest to the stack's top is removed and returned.
//
//Example 1:
//
//Input:
//["FreqStack", "push", "push", "push", "push", "push", "push", "pop", "pop", "pop", "pop"]
//[[], [5], [7], [5], [7], [4], [5], [], [], [], []]
//
//Output:
//[null, null, null, null, null, null, null, 5, 7, 5, 4]
//
//Explanation:
//FreqStack freqStack = new FreqStack();
//freqStack.push(5); // The stack is [5]
//freqStack.push(7); // The stack is [5,7]
//freqStack.push(5); // The stack is [5,7,5]
//freqStack.push(7); // The stack is [5,7,5,7]
//freqStack.push(4); // The stack is [5,7,5,7,4]
//freqStack.push(5); // The stack is [5,7,5,7,4,5]
//
//freqStack.pop(); // return 5
//freqStack.pop(); // return 7
//freqStack.pop(); // return 5
//freqStack.pop(); // return 4
//
//Constraints:
//
//0 <= val <= 1,000,000,000
//At most 20,000 calls will be made to push and pop.
//It is guaranteed that there will be at least one element in the stack before calling pop.

package Stacks;

import java.util.HashMap;
import java.util.Stack;

public class MaximumFrequencyStack_895 {

//	Approach :
//
//	We need two HashMaps:
//
//	1. count map
//	   Stores frequency of each number.
//
//	   Example:
//	   5 -> 3
//	   7 -> 2
//
//	2. stacks map
//	   Stores stack of elements for every frequency.
//
//	   Example:
//	   frequency 1 -> [5,7,4]
//	   frequency 2 -> [5,7]
//	   frequency 3 -> [5]
//
//	maxCount stores current highest frequency.
//
//	When pushing:
//	- increase frequency
//	- push element into stack of that frequency
//	- update maxCount
//
//	When popping:
//	- remove top element from stack of maxCount
//	- decrease its frequency
//	- if current max frequency stack becomes empty,
//	  reduce maxCount
//
//	This automatically handles tie cases because
//	stack gives most recent element first.
//  time complexity : O(1)
//  Space complexity : O(n)
	static class FreqStack {

		HashMap<Integer, Stack<Integer>> stacks;
		HashMap<Integer, Integer> count;
		int maxCount;

		public FreqStack() {
			stacks = new HashMap<>();
			count = new HashMap<>();
			maxCount = 0;
		}

		public void push(int val) {

			// update frequency of value
			count.put(val, count.getOrDefault(val, 0) + 1);

			int currCount = count.get(val);

			// update maximum frequency
			maxCount = Math.max(maxCount, currCount);

			// create stack if frequency not present
			if (!stacks.containsKey(currCount)) {
				stacks.put(currCount, new Stack<>());
			}

			// push value into frequency stack
			stacks.get(currCount).push(val);
		}

		public int pop() {

			// remove most recent element from max frequency stack
			int res = stacks.get(maxCount).pop();

			// decrease frequency
			count.put(res, count.get(res) - 1);

			// if no element left at max frequency
			// reduce maxCount
			if (stacks.get(maxCount).isEmpty()) {
				maxCount--;
			}

			return res;
		}
	}

	public static boolean check(int actual, int expected) {
		return actual == expected;
	}

	public static void main(String[] args) {

		FreqStack freqStack = new FreqStack();

		// push operations
		freqStack.push(5);
		freqStack.push(7);
		freqStack.push(5);
		freqStack.push(7);
		freqStack.push(4);
		freqStack.push(5);

		// expected outputs
		int output1 = 5;
		int output2 = 7;
		int output3 = 5;
		int output4 = 4;

		// actual outputs
		int ans1 = freqStack.pop();
		int ans2 = freqStack.pop();
		int ans3 = freqStack.pop();
		int ans4 = freqStack.pop();

		if (check(ans1, output1)) {
			System.out.println("Case 1 Passed");
		} else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Output : " + output1);
			System.out.println("Your Output : " + ans1);
		}

		if (check(ans2, output2)) {
			System.out.println("Case 2 Passed");
		} else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Output : " + output2);
			System.out.println("Your Output : " + ans2);
		}

		if (check(ans3, output3)) {
			System.out.println("Case 3 Passed");
		} else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Output : " + output3);
			System.out.println("Your Output : " + ans3);
		}

		if (check(ans4, output4)) {
			System.out.println("Case 4 Passed");
		} else {
			System.out.println("Case 4 Failed");
			System.out.println("Expected Output : " + output4);
			System.out.println("Your Output : " + ans4);
		}
	}
}