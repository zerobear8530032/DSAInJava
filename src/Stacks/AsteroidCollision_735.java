//735. Asteroid Collision
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//We are given an array asteroids of integers representing asteroids in a row. The indices of the asteriod in the array represent their relative position in space.
//
//For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
//
//Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.
//
//Example 1:
//
//Input: asteroids = [5,10,-5]
//Output: [5,10]
//Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
//Example 2:
//
//Input: asteroids = [8,-8]
//Output: []
//Explanation: The 8 and -8 collide exploding each other.
//Example 3:
//
//Input: asteroids = [10,2,-5]
//Output: [10]
//Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
// 
//
//Constraints:
//
//2 <= asteroids.length <= 104
//-1000 <= asteroids[i] <= 1000
//asteroids[i] != 0


package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision_735 {
//	approch :
//	we will add all element if stack is empty
//	or if top is negative 
//	or the astroid[i] is positive
//	other wise we will check top is positive and current number is negative 
//	then we simulate collition where we check if top is greater then x if yes does not add it
//	other wise both are equal then pop first element and not add the x 
//	else we will pop element and add the new x in the stack 
//	repeat all of it for each x
//	time complexity :O(n)
//	space complexity :O(n)
	    public static int[] asteroidCollision(int[] asteroids) {
	        Stack<Integer> stk = new Stack();
	        // iterate over artroids
	        for (int x : asteroids) {
	            // check if empty push without checking sign
	            // if top is negeative or positive number comes we can push
	            if (stk.isEmpty() || x > 0 || stk.peek() < 0) {
	                stk.push(x);
	                continue;
	            }
	            // if top is positive and next is negative we then it will colide
	            if (stk.peek() > 0 && x < 0) {
	                boolean bothequal = false;
	                // we will check until top is positive and negative is not destroyed 
	                while (!stk.isEmpty() && stk.peek() > 0) {
	                    // if top is bigger we can exxits
	                    if (stk.peek() > Math.abs(x)) {
	                        break;
	                        // if top is smaller we can pop the top and check next in the stack
	                    } else if (stk.peek() < Math.abs(x)) {
	                        stk.pop();
	                        // if both are equal we can remove the top 
	                    } else {
	                        stk.pop();
	                        bothequal = true;
	                        break;
	                    }
	                }
	                // this checks if stk is emptyy
	                // mean negative remain or top is negative we can push negative as it destroued all the positive
	                // if both equal is true means both got destroy so if !true == false so if both does not get destrou we can add it in stack
	                if ((stk.isEmpty() || stk.peek() < 0) && !bothequal) {
	                    stk.push(x);
	                }
	            }
	        }
	        // reverse fill array fro stack 
	        int[] res = new int[stk.size()];
	        for (int i = res.length - 1; i >= 0; i--) {
	            res[i] = stk.pop();
	        }
	        return res;
	    }
	
	    
	    public static boolean check( int [] ans, int [] output) {
	    	if(ans.length!= output.length) {
	    		return false;
	    	}
	    	for(int i =0;i<ans.length;i++) {
	    		if(ans[i]!=output[i]) {
	    			return false;
	    		}
	    	}
	    	return true;
	    }
	public static void main(String[] args) {
		
		//Example 1:

		int [] asteroids1 ={5,10,-5};
		int [] output1 =  {5,10};
		
		//Example 2:
		
		int [] asteroids2 = {8,-8};
		int [] output2 = {};
		
		//Example 3:

		int [] asteroids3 = {10,2,-5};
		int [] output3 = {10};
		
		
		
		int  []ans1=asteroidCollision(asteroids1);
		int  []ans2=asteroidCollision(asteroids2);
		int  []ans3=asteroidCollision(asteroids3);
		
		System.out.println("Brute Force Approch :");
		
		if(check(output1,ans1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+Arrays.toString(ans1) );
			System.out.println("Actual Output :"+ Arrays.toString(output1));			
		}
		if(check(output2,ans2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ Arrays.toString(ans2));
			System.out.println("Actual Output :"+ Arrays.toString(output2));			
		}
		if(check(output3,ans3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Your Output :"+ Arrays.toString(ans3));
			System.out.println("Actual Output :"+ Arrays.toString(output3));			
		}



	}

}
