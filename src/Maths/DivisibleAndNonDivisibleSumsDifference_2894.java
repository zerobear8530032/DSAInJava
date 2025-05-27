//2894. Divisible and Non-divisible Sums Difference
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given positive integers n and m.
//
//Define two integers as follows:
//
//num1: The sum of all integers in the range [1, n] (both inclusive) that are not divisible by m.
//num2: The sum of all integers in the range [1, n] (both inclusive) that are divisible by m.
//Return the integer num1 - num2.
//
// 
//
//Example 1:
//
//Input: n = 10, m = 3
//Output: 19
//Explanation: In the given example:
//- Integers in the range [1, 10] that are not divisible by 3 are [1,2,4,5,7,8,10], num1 is the sum of those integers = 37.
//- Integers in the range [1, 10] that are divisible by 3 are [3,6,9], num2 is the sum of those integers = 18.
//We return 37 - 18 = 19 as the answer.
//Example 2:
//
//Input: n = 5, m = 6
//Output: 15
//Explanation: In the given example:
//- Integers in the range [1, 5] that are not divisible by 6 are [1,2,3,4,5], num1 is the sum of those integers = 15.
//- Integers in the range [1, 5] that are divisible by 6 are [], num2 is the sum of those integers = 0.
//We return 15 - 0 = 15 as the answer.
//Example 3:
//
//Input: n = 5, m = 1
//Output: -15
//Explanation: In the given example:
//- Integers in the range [1, 5] that are not divisible by 1 are [], num1 is the sum of those integers = 0.
//- Integers in the range [1, 5] that are divisible by 1 are [1,2,3,4,5], num2 is the sum of those integers = 15.
//We return 0 - 15 = -15 as the answer.
// 
//
//Constraints:
//
//1 <= n, m <= 1000


package Maths;

public class DivisibleAndNonDivisibleSumsDifference_2894 {

// approch we can iterate from 1 till n and check number is divisble or not
//	and add them up amd take difference
//	time complexity :O(n)
//	space complexity :O(n)
    public static int differenceOfSumsBruteForce(int n, int m) {
	        int i=1;
	        int div=0;
	        while(i*m<=n){
	            div+=i*m;
	            i++;
	        }
	        int total = n*(n+1)/2;
	        int  ndiv= total-div;
	        return ndiv-div;
	    }
    
    

 // approch we can generate number divisible by m by taking multiple of m from 1 till  n where i*m<=n
//  then we can take total number from the formula n*(n+1)/2:
//   now we can get non divisible by taking difference of total - div 
//    at last we can just take difference of divisble and non divisible numbers
//	time complexity :O(n) : O(n/m) but if m == 1 it will be o(n)
//	space complexity :O(n)
        public static int differenceOfSumsBest(int n, int m) {
            int div=0;
            int ndiv=0;
            for(int i =1;i<=n;i++){
                if(i%m==0){
                    div+=i;
                }else{
                    ndiv+=i;
                }
            }
            return ndiv-div;
        }
    
	
	public static void main(String[] args) {
		
		//Example 1:

		int n1 = 10, m1 = 3;
		int output1=19;

		//Example 2:

		int n2= 5, m2 = 6;
		int output2=15;

		//Example 3:

		int n3= 5, m3 = 1;
		int output3=-15;

		System.out.println("Brute Force  Approch ");
		int ans1 = differenceOfSumsBruteForce(n1,m1);
		int ans2 = differenceOfSumsBruteForce(n2,m2);
		int ans3 = differenceOfSumsBruteForce(n3,m3);
		if(output1== ans1) {
			System.out.println("Case 1 Passed ");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Expected Output : "+output1);
			System.out.println("Your Output : "+ans1);
		}
		if(output2== ans2) {
			System.out.println("Case 2 Passed ");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Expected Output : "+output2);
			System.out.println("Your Output : "+ans2);
		}
		if(output3== ans3) {
			System.out.println("Case 3 Passed ");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Expected Output : "+output3);
			System.out.println("Your Output : "+ans3);
		}
		
		System.out.println("Best Approch");
		ans1 = differenceOfSumsBest(n1,m1);
		ans2 = differenceOfSumsBest(n2,m2);
		ans3 = differenceOfSumsBest(n3,m3);
	   	if(output1== ans1) {
    		System.out.println("Case 1 Passed ");
    	}else {
    		System.out.println("Case 1 Failed");
    		System.out.println("Expected Output : "+output1);
    		System.out.println("Your Output : "+ans1);
    	}
    	if(output2== ans2) {
    		System.out.println("Case 2 Passed ");
    	}else {
    		System.out.println("Case 2 Failed");
    		System.out.println("Expected Output : "+output2);
    		System.out.println("Your Output : "+ans2);
    	}
    	if(output3== ans3) {
    		System.out.println("Case 3 Passed ");
    	}else {
    		System.out.println("Case 3 Failed");
    		System.out.println("Expected Output : "+output3);
    		System.out.println("Your Output : "+ans3);
    	}


	}

}
