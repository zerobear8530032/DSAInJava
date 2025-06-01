//2929. Distribute Candies Among Children II
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given two positive integers n and limit.
//
//Return the total number of ways to distribute n candies among 3 children such that no child gets more than limit candies.
//
// 
//
//Example 1:
//
//Input: n = 5, limit = 2
//Output: 3
//Explanation: There are 3 ways to distribute 5 candies such that no child gets more than 2 candies: (1, 2, 2), (2, 1, 2) and (2, 2, 1).
//Example 2:
//
//Input: n = 3, limit = 3
//Output: 10
//Explanation: There are 10 ways to distribute 3 candies such that no child gets more than 3 candies: (0, 0, 3), (0, 1, 2), (0, 2, 1), (0, 3, 0), (1, 0, 2), (1, 1, 1), (1, 2, 0), (2, 0, 1), (2, 1, 0) and (3, 0, 0).
// 
//
//Constraints:
//
//1 <= n <= 106
//1 <= limit <= 106




package Recursion;

import java.util.ArrayList;
import java.util.List;

public class DistributeCandiesAmongChildrenII_2929 {
//	brute force approch :
//	we can check every single option from the list using back tracking 
//	time complexity : O(limit^3)
//	space complexity : O(3)
	
	public static long distributeCandies(int n, int limit) {
        List<Long> arr = new ArrayList<Long>();
        
        return helper(n,limit,arr);
    }

    public static long helper(long n , long limit, List<Long> arr){
        if(arr.size()==3 && n==0){
            return 1;
        }
        if(n!=0 && arr.size()==3){
            return 0;
        }
        int res=0;
        for(int i =0;i<=limit;i++){
            long x= n-i;
            arr.add((long)i);
            res+=helper(x,limit,arr);
            arr.removeLast();
        }
        return res;
    }
    
//	brute force approch :
//	we can check every single option from the list using back tracking 
//	time complexity : O(n*3*limit)
//	space complexity : O(n*3)
    
    public static long distributeCandiesBetter(int n, int limit) {
        // Using a 2D array for memoization: [remaining candies][people assigned]
        Long[][] dp = new Long[n + 1][4]; // max 3 people + 1 for base case
        return helperBetter(n, 0, limit, dp);
    }
    
    public static long helperBetter(int n , int index,int limit, Long[][] dp){
    	   if (index == 3) {
               return n == 0 ? 1 : 0;
           }
           if (dp[n][index] != null) {
               return dp[n][index];
           }

           long res = 0;
           for (int i = 0; i <= Math.min(n, limit); i++) {
               res += helperBetter(n - i, index + 1, limit, dp);
           }

           dp[n][index] = res;
           return res;
    }
	public static void main(String[] args) {

		//Example 1:

		int n1 = 5, limit1 = 2;
		long output1=3;

		//Example 2:

		int n2 = 3, limit2 = 3;
		long output2=10;
		
		//Example 3:
		
		int n3 = 10001, limit3 = 20001;
		long output3=10;
		
		System.out.println("Brute Force approch :");

		long ans1=distributeCandies(n1,limit1);
		long ans2=distributeCandies(n2,limit2);
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
