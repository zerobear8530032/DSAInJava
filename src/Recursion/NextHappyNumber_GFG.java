//For a given non-negative integer N, find the next smallest Happy Number. A number is called Happy if it leads to 1 after a sequence of steps. Wherein at each step the number is replaced by the sum of squares of its digits that is, if we start with Happy Number and keep replacing it with sum of squares of its digits, we reach 1 at some point.
//Example 1:
//
//Input:
//N = 8
//Output:
//10
//Explanation:
//Next happy number after 8 is 10 since
//1*1 + 0*0 = 1
//Example 2:
//
//Input:
//N = 10
//Output
//13
//Explanation:
//After 10, 13 is the smallest happy number because
//1*1 + 3*3 = 10, so we replace 13 by 10 and 1*1 + 0*0 = 1.
//Your Task:
//You don't need to read input or print anything. Your task is to complete the function nextHappy() which takes an integer N as input parameters and returns an integer, next Happy number after N.
//
//Expected Time Complexity: O(Nlog10N)
//Expected Space Complexity: O(1)
// 
//Constraints:
//1<=N<=105
//


package Recursion;

import java.util.HashSet;

public class NextHappyNumber_GFG {
//	iteartive approch :
//	we go from inital n till infinite  and check weather the current number is the 
//	happy number by applying the opearation if yes we get out output other wise we can continue
//	time complexity N* (Log 10 N)
	public static int nextHappy(int n) {
		int start = n+1;
		if(isHappy(start)) {
			return start;
		}
		return nextHappy(start);
	}
	
	public static boolean isHappy(int n) {
		HashSet<Integer> set= new HashSet<Integer>();
		set.add(n);
		while(true) {	
			n = operation(n);
			if(set.contains(n)) {
				return false;
			}
			if(n==1) {
				return true;
			}
			set.add(n);
		}
	}
	
	public static int operation( int n) {
		int res = 0;
		while(n>0) {
			int rem = n%10;
			n/=10;
			res += rem*rem;
		}
		return res;
	}
	
	
	
//	iteartive approch :
//	we go from inital n till infinite  and check weather the current number is the 
//	happy number by applying the opearation if yes we get out output other wise we can continue
//	time complexity N* (Log 10 N)
	public static int nextHappyRec(int n) {
		if(n==1000000) {
			return -1;
		}
		int start = n+1;
		while(true) {
			HashSet<Integer> set= new HashSet<Integer>();
			if(isHappyRec(start,set)) {
				return start;
			}
			start+=1;
		}
	}
	
	public static boolean isHappyRec(int n, HashSet<Integer> set) {
		if(n==1) {
			return true;
		}
		if(set.contains(n)) {
			return false;
		}
		set.add(n);
		n = operation(n);
		return isHappyRec(n,set);
	}

	

	public static void main(String[] args) {
//		Example 1:
		int n1 =8;
		int output1=10;

//		Example 2:

		int n2 =10;
		int output2=13;
		

    	int ans1=nextHappy(n1);
    	int ans2=nextHappy(n2);
    	
    	System.out.println("Iterative Approch :");
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
			System.out.println("Your Answer :"+ ans1);  		
    	}
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}

    	ans1=nextHappyRec(n1);
    	ans2=nextHappyRec(n2);
    	
    	System.out.println("Recursive Approch :");
    	
    	if(output1==ans1) {
    		System.out.println("Case 1 Passed");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Ouput :"+ output1);
    		System.out.println("Your Answer :"+ ans1);  		
    	}
    	
    	if(output2==ans2) {
    		System.out.println("Case 2 Passed");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Ouput :"+ output2);
    		System.out.println("Your Answer :"+ ans2);  		
    	}

		

	}

}
