//191. Number of 1 Bits
//Solved
//Easy
//Topics
//Companies
//Given a positive integer n, write a function that returns the number of set bits in its binary representation (also known as the Hamming weight).
//
// 
//
//Example 1:
//
//Input: n = 11
//
//Output: 3
//
//Explanation:
//
//The input binary string 1011 has a total of three set bits.
//
//Example 2:
//
//Input: n = 128
//
//Output: 1
//
//Explanation:
//
//The input binary string 10000000 has a total of one set bit.
//
//Example 3:
//
//Input: n = 2147483645
//
//Output: 30
//
//Explanation:
//
//The input binary string 1111111111111111111111111111101 has a total of thirty set bits.
//
// 
//
//Constraints:
//
//1 <= n <= 231 - 1
// 
//
//Follow up: If this function is called many times, how would you optimize it?



package BitWise;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Numberof1Bits_191{


//	we  can use right shift operation repeatedly untill the number is not zero
//	and use n&1 to check current lsb is a set bit or not
//	time complexity :O(n): n is number of bits
//	space complexity :O(1)
	
	public static int hammingWeightBruteForce(int n) {
		int c=0;
		while(n!=0){
			if((n&1)==1) {
				c++;
			}
			n=n>>1;
		}
		return c;
	}
//	best we can use same logic as brurte force :
//	but we can find the first set bit much faster then traversing the entire number bits 
//	and we can remove the set bit by setbit-n;
//	time complexity :O(log n)
//	space complexity :O(1)
	
	 public static int hammingWeightBest(int n) {
	        int c=0;
	        while(n!=0){
	            int setbit = n&(-n);// get the set bit
	            n=n-setbit;// remove the set bit
	            c++;
	        }
	        return c;
	    }
	public static void main(String[] args) {
		
		//Example 1:
		
		int n1=11;
		int output1=3;
		
		//Example 2:
	
		int n2=128;
		int output2=1;

		//Example 3:
		
		int n3 = 2147483645;
		int output3=30;
		
		
		int ans1= hammingWeightBruteForce(n1);	
		int ans2= hammingWeightBruteForce(n2);	
		int ans3= hammingWeightBruteForce(n3);	
		
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
		
		System.out.println("Best Approch :");
		 	
		ans1= hammingWeightBest(n1);	
		ans2= hammingWeightBest(n2);	
		ans3= hammingWeightBest(n3);	
		if(ans1==output1) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Ouput :"+ (output1));
			System.out.println("Your Answer :"+ (ans1));
		}
		if(ans2==output2) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Ouput :"+ (output2));
			System.out.println("Your Answer :"+ (ans2));
		}
		if(ans3==output3) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Ouput :"+ (output3));
			System.out.println("Your Answer :"+ (ans3));
		}
	}

}
