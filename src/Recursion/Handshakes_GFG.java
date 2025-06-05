//https://www.geeksforgeeks.org/problems/handshakes1303/1
//Handshakes
//Difficulty: MediumAccuracy: 48.96%Submissions: 19K+Points: 4
//We have N persons sitting on a round table. Any person can do a handshake with any other person.
//
//     1
//2         3
//     4
//
//Handshake with 2-3 and 1-4 will cause cross.
//
//In how many ways these N people can make handshakes so that no two handshakes cross each other. N would be even. 
// 
//
//Example 1:
//
//Input:
//N = 2
//Output:
//1
//Explanation:
//{1,2} handshake is
//possible.
//Example 2:
//
//Input:
//N = 4
//Output:
//2
//Explanation:
//{{1, 2}, {3, 4}} are the
//two handshakes possible.
//{{1, 3}, {2, 4}} is another
//set of handshakes possible.
//
//Your Task:
//You don't need to read input or print anything. Your task is to complete the function count() which takes an integer N as input parameters and returns an integer, the total number of handshakes possible so that no two handshakes cross each other.
// 
//
//Expected Time Complexity: O(2^N)
//Expected Space Complexity: O(1)
//
//Constraints:
//1 <= N <= 30
package Recursion;

import java.util.HashMap;

public class Handshakes_GFG {

//	brute force approch:
//	first we fix 1 and try to pair every single number from 1 till n and check there left side and right
//	side if left and right are even we can  just accept it and multiply both of them
//	and do this recursively and dd all of them to get answer 
//	Time Complexity: O(2^N)
//  Space Complexity: O(1)
	public static int countBruteForce(int n) {
		if(n==0) {
			return 1;
		}

		int res =0;
		for(int i = 2;i<=n;i+=2) {// here 1 is consider first 
//			so we can find every even number from 1 to n  by incrementing by 2
//			first even is 2 cause 1 cannot handhake with itself
			int remainingleftside= i-2;// here we get all people on left side if 1 and i hand shake
			int remainingrightside= n-i;// here we consider right side people if 1 and i hand shake
			int left = countBetter(remainingleftside);// reccursively calculate rest hand shake
			int right = countBetter(remainingrightside);
			int total= left*right;// to find all way we can multiply both and add to the total answer 
			res+=total;
		}
		return res;
	}
	
	
//	better approch with memprization
//	Time Complexity: O(2^N)
//  Space Complexity: O(1)

	public static int countBetter(int n) {
		HashMap<Integer,Integer> memo= new HashMap();
		return helper(memo,n);
	}
	
	public static int helper(HashMap<Integer,Integer> memo,int n) {
		if(n==0) {
			return 1;
		}
		if(memo.containsKey(n)) {
			return memo.get(n);
		}
		int res =0;
		for(int i = 2;i<=n;i+=2) {
			int remainingleftside= i-2;
			int remainingrightside= n-i;
			int left = helper(memo,remainingleftside);
			int right = helper(memo,remainingrightside);
			int total= left*right;
			res+=total;
		}
		memo.put(n,res);
		return res;
	}
	public static void main(String[] args) {
		
		//Example 1:

		int n1=2;
		int output1=1;
		
		//Example 2:
		
		int n2=4;
		int output2=2;
		
		//Example 3:
		
		int n3=6;
		int output3=5;
		
		System.out.println("Brute Force Approch");
		
		int ans1 = countBruteForce(n1);
		int ans2 = countBruteForce(n2);
		int ans3 = countBruteForce(n3);
		
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}
		
		System.out.println("Better Approch");
		
		ans1 = countBetter(n1);
		ans2 = countBetter(n2);
		ans3 = countBetter(n3);
		
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
			System.out.println("Actual Output :"+output3 );
			System.out.println("Your Output :"+ans3);
		}

		
		
	}
}
