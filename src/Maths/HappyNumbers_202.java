//202. Happy Number
//Attempted
//Easy
//Topics
//Companies
//Write an algorithm to determine if a number n is happy.
//
//A happy number is a number defined by the following process:
//
//Starting with any positive integer, replace the number by the sum of the squares of its digits.
//Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
//Those numbers for which this process ends in 1 are happy.
//Return true if n is a happy number, and false if not.
//
// 
//
//Example 1:
//
//Input: n = 19
//Output: true
//Explanation:
//12 + 92 = 82
//82 + 22 = 68
//62 + 82 = 100
//12 + 02 + 02 = 1
//Example 2:
//
//Input: n = 2
//Output: false
// 
//
//Constraints:
//
//1 <= n <= 231 - 1


package Maths;

import java.util.HashSet;

public class HappyNumbers_202 {
//		 brute fforce approch :
//		 we know its a cycle where at last the number will come back to
//		back to its original ppointer
//		 so we can taks a hashset to keep track of all int generated 
//		 and if any reapeated we can exit loop and check its the one we want 
//		 if its 1 returnt true other wise false'
//	    time complexity :O(n)
//	    space complexity :O(n)
	 public static boolean isHappyBruteForce(int n) {
		 HashSet<Integer> set = new HashSet<Integer>();
	        int x=n;
	        while(x!=1){
	        	if(set.contains(x)) break;
	        	set.add(x);
	            x=sqrsum(x);
	        }
	        return x==1;
	    }
	    public static int sqrsum(int x){
	        int sum =0;
	        while(x>0){
	            int r=x%10;
	            sum+=r*r;
	            x=x/10;
	        }
	        return sum;
	    }
	    
//	    optimize approch :
//	  if its a cycle we can use cycle detection algo to remove the required space
//	    time complexity :O(n)
//	    space complexity :O(1)
	    public static boolean isHappyBest(int n) {
	    	int s=n;
	    	int f= sqrsum(n);
	    	while(f!=s) {
	    		s=sqrsum(s);
	    		f=sqrsum(sqrsum(f));
	    	}
	    	return f==1;
	    }


	
	public static void main(String[] args) {
		//Example 1:
		
		int n1 = 19;
		boolean output1= true;

		//Example 1:
		
		int n2=2;
		boolean output2=false;
		
		boolean ans1=isHappyBruteForce(n1);
		boolean ans2=isHappyBruteForce(n2);
		
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
		
		System.out.println("Best Approch :");
		
		ans1=isHappyBest(n1);
		ans2=isHappyBest(n2);
		
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
		

 
		
	}

}

