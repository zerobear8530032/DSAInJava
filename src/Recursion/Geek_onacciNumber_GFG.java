//	Geek-onacci Number
//	Difficulty: EasyAccuracy: 60.47%Submissions: 19K+Points: 2
//	Geek created a random series and given a name geek-onacci series. Given four integers A, B, C, N. A, B, C represents the first three numbers of geek-onacci series. Find the Nth number of the series. The nth number of geek-onacci series is a sum of the last three numbers (summation of N-1th, N-2th, and N-3th geek-onacci numbers)
//	
//	Input:
//	1. The first line of the input contains a single integer T denoting the number of test cases. The description of T test cases follows.
//	2. The first line of each test case contains four space-separated integers A, B, C, and N.
//	
//	Output: For each test case, print Nth geek-onacci number
//	
//	Constraints:
//	1. 1 <= T <= 3
//	2. 1 <= A, B, C <= 100
//	3. 4 <= N <= 10
//	
//	Example:
//	Input:
//	3
//	1 3 2 4
//	1 3 2 5
//	1 3 2 6
//	
//	Output:
//	6
//	11
//	19



package Recursion;

import java.util.HashMap;

public class Geek_onacciNumber_GFG {
//	iterative method :
//	time complexity :O(n)
//	time complexity :O(1)
	public static int geekonacciNumber_Iterative(int a,int b,int c,int n) {
		if(n==1) return a;
		if(n==2) return b;
		if(n==3) return c;
		
		for(int i =4;i<=n;i++) {
			int nextnumber=  a+b+c;
			a=b;
			b=c;
			c=nextnumber;
		}
		return c;		
	}
//	recursion method :
//	recursion brute force approch :
//	time complexity :O(n)
//	time complexity :O(n)
	private static int geekonacciNumber_RecBruteForce(int a, int b, int c, int n) {
		if(n==1) return a;
		if(n==2) return b;
		if(n==3) return c;

		return geekonacciNumber_RecBruteForce(a, b, c, n-1)+geekonacciNumber_RecBruteForce(a, b, c, n-2)+geekonacciNumber_RecBruteForce(a, b, c, n-3);		
	}

//	recursion method :
//	recursion Using memorization approch :
//	time complexity :O(n)
//	time complexity :O(n)
	public static HashMap <Integer,Integer>memo = new HashMap();
	private static int geekonacciNumber_RecMemo(int a, int b, int c, int n) {
		if(n==1) return a;
		if(n==2) return b;
		if(n==3) return c;
		if(!memo.containsKey(n)) {
			memo.put(n, geekonacciNumber_RecBruteForce(a, b, c, n-1)+geekonacciNumber_RecBruteForce(a, b, c, n-2)+geekonacciNumber_RecBruteForce(a, b, c, n-3));
		}
		
		return memo.get(n);		
	}
		
	public static void main(String args[]) {
		// Example 1:
		int a1=1,b1=3,c1=2,n1=4,output1=6;
		int a2=1,b2=3,c2=2,n2=5,output2=11;
		int a3=1,b3=3,c3=2,n3=6,output3=19;
		
		int ans1=geekonacciNumber_Iterative(a1,b1,c1,n1);
		int ans2=geekonacciNumber_Iterative(a2,b2,c2,n2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		
		System.out.println("Recursion Approch :");
		
		ans1=geekonacciNumber_RecBruteForce(a1,b1,c1,n1);
		ans2=geekonacciNumber_RecBruteForce(a2,b2,c2,n2);
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		
		
		System.out.println("Recursion Memo Approch :");
		
		ans1=geekonacciNumber_RecMemo(a1,b1,c1,n1);
		memo.clear();
		ans2=geekonacciNumber_RecMemo(a2,b2,c2,n2);
		memo.clear();
		
		if(output1==ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Your Output :"+ ans1);
			System.out.println("Actual Output :"+ output1);			
		}
		if(output2==ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Your Output :"+ ans2);
			System.out.println("Actual Output :"+ output2);			
		}
		

		
	}


	
	
}

