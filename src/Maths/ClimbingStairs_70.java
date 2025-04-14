//70. Climbing Stairs
//Easy
//Topics
//Companies
//Hint
//You are climbing a staircase. It takes n steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
// 
//
//Example 1:
//
//Input: n = 2
//Output: 2
//Explanation: There are two ways to climb to the top.
//1. 1 step + 1 step
//2. 2 steps
//Example 2:
//
//Input: n = 3
//Output: 3
//Explanation: There are three ways to climb to the top.
//1. 1 step + 1 step + 1 step
//2. 1 step + 2 steps
//3. 2 steps + 1 step
// 
//
//Constraints:
//
//1 <= n <= 45



package Maths;

import java.util.HashMap;

public class ClimbingStairs_70 {
//	brute force approch:
//	try every single combination : 
//	time complexity : O(2 ^n);
//	space complexity : O(n);
	 public static int climbStairsBruteForce(int n) {
		 if(n<=0) return 0;
		 if(n==1) {
			 return 1;
		 }
		 if(n==2) {
			 return 2;
		 }
		 int onestep=climbStairsBruteForce(n-1);
		 int twostep=climbStairsBruteForce(n-2);
		 return onestep+twostep;
	    }
	 
	 
//	better force approch:
//	we can use memorizations:
//	time complexity : O(n);
//	space complexity : O(n);
	 static HashMap<Integer,Integer> memo= new HashMap();
	 public static int climbStairsMemo(int n) {
			    if (n <= 0) return 0;
			    if (n == 1) return 1;
			    if (n == 2) return 2;

			    if (memo.containsKey(n)) {
			        return memo.get(n);
			    }

			    int result = climbStairsMemo(n - 1) + climbStairsMemo(n - 2);
			    memo.put(n, result);
			    return result;
			
		 	 }

	public static void main(String[] args) {
		
		
		
		//Example 1:
	
		int n1 = 2;
		int output1=2;
		
		//Example 2:
		
		int  n2 = 3;
		int output2=3;
		
		//Example 3:
		
		int  n3 = 4;
		int output3=5;

		
		System.out.println("Brute Force");
		
		int ans1=climbStairsBruteForce(n1);		
		int ans2=climbStairsBruteForce(n2);		
		int ans3=climbStairsBruteForce(n3);	
		
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}
		
		
		System.out.println("Memo Force");
		
		ans1=climbStairsMemo(n1);		
		ans2=climbStairsMemo(n2);		
		ans3=climbStairsMemo(n3);	
		
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3==ans3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}

	}

}
