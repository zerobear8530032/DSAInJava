//338. Counting Bits
//Solved
//Easy
//Topics
//Companies
//Hint
//Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
//
//Example 1:
//
//Input: n = 2
//Output: [0,1,1]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
//Example 2:
//
//Input: n = 5
//Output: [0,1,1,2,1,2]
//Explanation:
//0 --> 0
//1 --> 1
//2 --> 10
//3 --> 11
//4 --> 100
//5 --> 101
// 
//
//Constraints:
//
//0 <= n <= 105
// 
//
//Follow up:
//
//It is very easy to come up with a solution with a runtime of O(n log n). Can you do it in linear time O(n) and possibly in a single pass?
//Can you do it without using any built-in function (i.e., like __builtin_popcount in C++)?
package BitWise;

import java.util.Arrays;

public class CountingBits_338 {
	
//	brute force approch :
//	here we iterate from 0 till n and count each number bits
//	time complexity : O(n *n)
//	time complexity : O(1)
//	this will count the bits in Log n time   
	public static int countBruteForce(int n) {
		        int c=0;
		        while(n!=0){
		            if((n&1)==1) {
		            	c++;
		            }
		            n=n>>1;
		        }
		        return c;
		    }
	
//	here we go from  o till n  and count every single bit present in the number using a function
	
	    public static int[] countBitsBruteForce(int n) {
	        int [] ans = new int [n+1];
	        for(int i =0;i<n+1;i++){
	            ans[i]= countBruteForce(i);
	        }
	        return ans;
	    }
	
//	better approch : here iterate  over all the bits but optimizie way which reduce the time 
//	time complexity :O(n log n)
//	space complexity :O(1)
//	this will count the bits in Log n time   
	    public static int countBetter(int n) {
	    	int c=0;
	    	while(n!=0){
	    		int setbit = n&(-n);// get the set bit
	    		n=n-setbit;// remove the set bit
	    		c++;
	    	}
	    	return c;
	    }
//	here we go from  o till n  and count every single bit present in the number using a function
	    
	    public static int[] countBitsBetter(int n) {
	    	int [] ans = new int [n+1];
	    	for(int i =0;i<n+1;i++){
	    		ans[i]= countBetter(i);
	    	}
	    	return ans;
	    }
	    
	    
	    

		private static boolean check(int[] ans, int[] output) {
			if(ans.length!=output.length) return false;
			for(int i =0;i<ans.length;i++) {
				if(ans[i]!=output[i]) return false;
			}
			return true;
		}
	    
//		Best approch :
//		i dont understand it 
//		// one bit group
//		 0=   0(0)
//		 1=   1(1)
//		// two bits group
//		 2=  10(1) = 10(higest bit) + 0
//		 3=  11(2) = 10 + 1
//		// three bits group
//		 4= 100(1) = 100(higest bit) + 0
//		 5= 101(2) = 100 + 1
//		 6= 110(2) = 100 + 2
//		 7= 111(3) = 100 + 3
//		// four bits group
//		 8=1000(1)=1000(higest bit) + 0
//		 9=1001(2) = 1000 + 1
//		10=1010(2) = 1000 + 2
//		11=1011(3) = 1000 + 3
//		12=1100(2) = 1000 + 4
//		13=1101(3) = 1000 + 5
//		14=1110(3) = 1000 + 6
//		15=1111(4) = 1000 + 7
//		// five bits group
//		16=10000(1)
//		...and so on
//		time complexity :O(n)
//		time complexity :O(1)
		   public static int[] countBits(int n) {
			   int[] dp = new int[n + 1];
			    for (int i = 1; i <= n; i++) {
			        dp[i] = dp[i >> 1] + (i & 1);
			    }
			    return dp;

		    }
		
	    public static void main(String[] args) {
	    	//Example 1:

	    	int n1=2;
	    	int [] output1= {0,1,1};
	    	
	    	//Example 2:

	    	int n2=5;
	    	int [] output2= {0,1,1,2,1,2};
	    	
	    	int [] ans1 = countBitsBruteForce(n1);
	    	int [] ans2 = countBitsBruteForce(n2);
	    	System.out.println("Brute Force Approch :");
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
			
			System.out.println("Better approch :");
			
			 ans1 = countBitsBetter(n1);
		     ans2 = countBitsBetter(n2);
			
			
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
			
			System.out.println("Best Approch ");
			
			ans1 = countBits(n1);
			ans2 = countBits(n2);
			
			
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

	    	

		}

}

