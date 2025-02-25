//509. Fibonacci Number
//Solved
//Easy
//Topics
//Companies
//The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
//
//F(0) = 0, F(1) = 1
//F(n) = F(n - 1) + F(n - 2), for n > 1.
//Given n, calculate F(n).
//
// 
//
//Example 1:
//
//Input: n = 2
//Output: 1
//Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
//Example 2:
//
//Input: n = 3
//Output: 2
//Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
//Example 3:
//
//Input: n = 4
//Output: 3
//Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
// 
//
//Constraints:
//
//0 <= n <= 30


package Recursion;

import java.util.HashMap;

class FibonacciNumber_509 {
//	using loop :
//	time complexity O(n);
//	Space complexity O(1);
    public static int fib(int n) {
        int first=0;
        int second=1;
        if(n==0){
            return first;
        }else if(n==1){
            return second;
        }
        for(int i=2;i<=n;i++){
            int next= first+second;
            first=second;
            second=next;
        }
        return second;
    }

//    fibonacii recursion solution: 
//	time complexity O(n);
//	Space complexity O(n);
    public static int fibRec(int n) {
    	if(n==0) {
    		return 0;
    	}
    	if(n==1) {
    		return 1;
    	}
    	return fibRec(n-1)+fibRec(n-2);
    }
    
//    fibnacy recursion using memo solution
//    time complexity :O(n)
//    space complexity :O(n)
    public static HashMap <Integer,Integer> map = new HashMap(); 
    public static int fibMemoRec(int n) {
    	if(n==0) {
    		return 0;
    	}
    	if(n==1) {
    		return 1;
    	}
    	if(map.containsKey(n)) {
    		return map.get(n);
    	}else {
    		map.put(n,fibMemoRec(n-1)+fibMemoRec(n-2));
    	}
    	
    	return map.get(n);
    }
    

    public static void main(String[] args) {
    	//Example 1:
    	//
    	int  n1 = 2, output1=1;
    	int  n2 = 3, output2=2;
    	int  n3 = 4, output3=3;
    	
    	System.out.println("Iterative Approch :");
    	
    	int ans1=fib(n1);    	
    	int ans2=fib(n2);    	
    	int ans3=fib(n3);    	
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Your Output :"+ans1);
    		System.out.println("Actual Output :"+output1);
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Your Output :"+ans2);
    		System.out.println("Actual Output :"+output2);
    	}
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Your Output :"+ans3);
    		System.out.println("Actual Output :"+output3);
    	}
    	
    	System.out.println("Recursion Approch :");
    	
    	ans1=fibRec(n1);    	
    	ans2=fibRec(n2);    	
    	ans3=fibRec(n3);    	
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Your Output :"+ans1);
    		System.out.println("Actual Output :"+output1);
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Your Output :"+ans2);
    		System.out.println("Actual Output :"+output2);
    	}
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Your Output :"+ans3);
    		System.out.println("Actual Output :"+output3);
    	}
    	
    	System.out.println("Recursion With Memorization Approch :");
    	
    	ans1=fibMemoRec(n1);    	
    	ans2=fibMemoRec(n2);    	
    	ans3=fibMemoRec(n3);    	
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Your Output :"+ans1);
    		System.out.println("Actual Output :"+output1);
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Your Output :"+ans2);
    		System.out.println("Actual Output :"+output2);
    	}
    	if(output3==ans3) {
    		System.out.println("Case 3 Passed");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Your Output :"+ans3);
    		System.out.println("Actual Output :"+output3);
    	}
    	
	}
}