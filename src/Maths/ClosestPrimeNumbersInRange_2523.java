//2523. Closest Prime Numbers in Range
//Solved
//Medium
//Topics
//Companies
//Hint
//Given two positive integers left and right, find the two integers num1 and num2 such that:
//
//left <= num1 < num2 <= right .
//Both num1 and num2 are prime numbers.
//num2 - num1 is the minimum amongst all other pairs satisfying the above conditions.
//Return the positive integer array ans = [num1, num2]. If there are multiple pairs satisfying these conditions, return the one with the smallest num1 value. If no such numbers exist, return [-1, -1].
//
// 
//
//Example 1:
//
//Input: left = 10, right = 19
//Output: [11,13]
//Explanation: The prime numbers between 10 and 19 are 11, 13, 17, and 19.
//The closest gap between any pair is 2, which can be achieved by [11,13] or [17,19].
//Since 11 is smaller than 17, we return the first pair.
//Example 2:
//
//Input: left = 4, right = 6
//Output: [-1,-1]
//Explanation: There exists only one prime number in the given range, so the conditions cannot be satisfied.
// 
//
//Constraints:
//
//1 <= left <= right <= 106


package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestPrimeNumbersInRange_2523 {
//	brute force approoch : this approch will not get accepted
//	find all time number btw the left and right including both left and right
//	store all prime number in a list then 
//	now use the prime list to compare i and i+1 in that list and get min differenee btw the prime numbers 
//	time complexity : O(n*x) : here n = difference btw left - right and x is the number btw 2 till n-1
//	space complexity :O(p) : it can be said because the more prime it will get it will increase
	    public static int[] closestPrimesBruteForce(int left, int right) {
	        List<Integer> primelist = new ArrayList<Integer>();
	        for(int start=left;start<=right;start++){
	            if(isPrime(start)){
	                primelist.add(start);
	            }
	        }
	        if(primelist.size()<=1) return new int []{-1,-1};
	        int num1=primelist.get(0);
	        int num2=primelist.get(1);
	        int mindiff=num2-num1;
	        for(int i =1;i<primelist.size()-1;i++){
	            int n1=primelist.get(i);
	            int n2=primelist.get(i+1);
	            if(mindiff>n2-n1){
	                num1=n1;
	                num2=n2;
	                mindiff=num2-num1;
	            }
	        }
	        return new int [] {num1,num2};
	    }
//	    here we check from 2 till n-1 number if any number divisible by n its nota prime number
	    public static boolean isPrime(int x){
	        if (x<2) return false;
	        if (x == 2) return true;
	        boolean isprime=true;
	        for( int i=2;i<x;i++){
	            if(x%i==0){
	                isprime=false;
	                break;
	            }
	        }
	        return isprime;
	    }
	
//	    Better approch :
//	    here we can reduce the time of finding the prime number significantly using a method
//	    by terminating the redundanct check of number
//		here we only check a number is prime if n 2 <= n-1 and loop will break if i*i<=n
//		time complexity : O(n*root(x)) : here n = difference btw left - right and x is the number btw 2 till n-1
//		space complexity :O(p) : it can be said because the more prime it will get it will increase
	    public static int[] closestPrimesBetter(int left, int right) {
	    	List<Integer> primelist = new ArrayList<Integer>();
	    	for(int start=left;start<=right;start++){
	    		if(isPrimeBetter(start)){
	    			primelist.add(start);
	    		}
	    	}
	    	if(primelist.size()<=1) return new int []{-1,-1};
	    	int num1=primelist.get(0);
	    	int num2=primelist.get(1);
	    	int mindiff=num2-num1;
	    	for(int i =1;i<primelist.size()-1;i++){
	    		int n1=primelist.get(i);
	    		int n2=primelist.get(i+1);
	    		if(mindiff>n2-n1){
	    			num1=n1;
	    			num2=n2;
	    			mindiff=num2-num1;
	    		}
	    	}
	    	return new int [] {num1,num2};
	    }
	    public static boolean isPrimeBetter(int x){
	    	if (x<2) return false;
	    	if (x == 2) return true;
	    	boolean isprime=true;
	    	for( int i=2;i*i<=x;i++){
	    		if(x%i==0){
	    			isprime=false;
	    			break;
	    		}
	    	}
	    	return isprime;
	    }
//	    here we check for the prime number on the go and check the min ddifferenece
//	    time complexiyty :O((R - L)√N)
//	    space complexity : O(1)
	    public static int[] closestPrimesBest(int left, int right) {
	        int num1 = -1, num2 = -1;
	        int prevPrime = -1;
	        int minDiff = Integer.MAX_VALUE;
	        int[] ans = {-1, -1};

	        for (int i = left; i <= right; i++) {
	            if (isPrimeBest(i)) {
	                if (prevPrime != -1) { // We found a second prime
	                    int diff = i - prevPrime;
	                    if (diff < minDiff) {
	                        minDiff = diff;
	                        ans[0] = prevPrime;
	                        ans[1] = i;
	                    }
	                }
	                prevPrime = i; // Update previous prime
	            }
	        }

	        return ans;
	    }
	    public static boolean isPrimeBest(int x) {
	    	  if (x < 2) return false;
	    	    if (x == 2) return true;
	    	    if (x % 2 == 0) return false; // Skip even numbers
	    	    for (int i = 3; i * i <= x; i += 2) { // Check odd divisors only
	    	        if (x % i == 0) return false;
	    	    }
	    	    return true;
	    }
	    public static boolean check(int [] ans, int [] output) {
	    	if(ans.length!=output.length) {
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
		//
		int left1 = 10, right1 = 19;
		int [] output1= {11,13};
		
		
		//Example 2:
		//
		int left2 = 4, right2 = 6;
		int [] output2= {-1,-1};
		
		//Example 3:
		//
		int left3 = 84084, right3 = 407043;
		int [] output3= {84179,84181};
		
				
		
		System.out.println("Brute Force Approch :");
		
		int [] ans1 = closestPrimesBruteForce(left1, right1);
		int [] ans2 = closestPrimesBruteForce(left2, right2);
		int []ans3= null;// this brute force willtake a lot of time
//		int [] ans3 = closestPrimesBruteForce(left3, right3);

		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
//		if(check(ans3,output3)) {
//			System.out.println("Case 3 Passed ");
//		}else {
//			System.out.println("Case 3 Failed");
//			System.out.println("Excepted Output : "+ Arrays.toString(output3));
//			System.out.println("Your Output : "+ Arrays.toString(ans3));
//		}
		
		System.out.println("Better Approch :");
		
		ans1 = closestPrimesBetter(left1, right1);
		ans2 = closestPrimesBetter(left2, right2);
		ans3 = closestPrimesBetter(left3, right3);
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
		if(check(ans3,output3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output3));
			System.out.println("Your Output : "+ Arrays.toString(ans3));
		}
		
		System.out.println("best Approch :");
		
		ans1 = closestPrimesBest(left1, right1);
		ans2 = closestPrimesBest(left2, right2);
		ans3 = closestPrimesBest(left3, right3);
		
		if(check(ans1,output1)) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output1));
			System.out.println("Your Output : "+ Arrays.toString(ans1));
		}
		if(check(ans2,output2)) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output2));
			System.out.println("Your Output : "+ Arrays.toString(ans2));
		}
		if(check(ans3,output3)) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Excepted Output : "+ Arrays.toString(output3));
			System.out.println("Your Output : "+ Arrays.toString(ans3));
		}
		
		
		

		
	}

}
