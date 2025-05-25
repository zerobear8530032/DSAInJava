//216. Combination Sum III
//Medium
//Topics
//Companies
//Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
//
//Only numbers 1 through 9 are used.
//Each number is used at most once.
//Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
//
// 
//
//Example 1:
//
//Input: k = 3, n = 7
//Output: [[1,2,4]]
//Explanation:
//1 + 2 + 4 = 7
//There are no other valid combinations.
//Example 2:
//
//Input: k = 3, n = 9
//Output: [[1,2,6],[1,3,5],[2,3,4]]
//Explanation:
//1 + 2 + 6 = 9
//1 + 3 + 5 = 9
//2 + 3 + 4 = 9
//There are no other valid combinations.
//Example 3:
//
//Input: k = 4, n = 1
//Output: []
//Explanation: There are no valid combinations.
//Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
// 
//
//Constraints:
//
//2 <= k <= 9
//1 <= n <= 60


package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIII_216 {

//	approch : we can use back tracking to generate all integer combination from start 1 till 9
//	time complexity : O(combination(9,k)*)
//	space complexity : O(k)
	public static List<List<Integer>> combinationSum3(int k, int n) {
	        List<List<Integer>> res= new ArrayList<List<Integer>>();
	        List<Integer> curr = new ArrayList();
	        int target =n;
	        int start=1;
	        helper(start,k,target,res,curr);
	        return res;
	    }
	    public static void helper(int start,int k , int target , List<List<Integer>> res , List<Integer> curr){
	    	
	        if (curr.size() > k || target < 0) return;
	    	if(target ==0 && curr.size()==k){
	            res.add(new ArrayList(curr));
	            return ;
	        }
	        for(int i =start;i<=9;i++){
	            if(target-i<0){
	                continue;
	            }
	            curr.add(i);
	            helper(i+1,k,target-i,res,curr);
	            curr.remove(curr.size()-1);
	        }
	    }
	
	    public static void main(String[] args) {
		
		//Example 1:

		int k1 = 3, n1 = 7;
		List<List<Integer>> output1= new ArrayList(
				Arrays.asList(
						Arrays.asList(1,2,4)
						)
				);
		
		//Example 2:

		int k2 = 3, n2 = 9;
		List<List<Integer>> output2= new ArrayList(
				Arrays.asList(
						Arrays.asList(1,2,6),
						Arrays.asList(1,3,5),
						Arrays.asList(2,3,4)						
						)
				);

		//Example 3:
		
		int k3 = 4, n3 = 1;
		List<List<Integer>> output3= new ArrayList();
		
		System.out.println("Best Approch :");
		
		List<List<Integer>>ans1=combinationSum3(k1,n1);
		List<List<Integer>>ans2=combinationSum3(k2,n2);
		List<List<Integer>>ans3=combinationSum3(k3,n3);
		
		if(output1.equals(ans1)) {
			System.out.println("Case 1 Passed");
		}else {
			System.out.println("Case 1 Failed");
			System.out.println("Actual Output :"+output1 );
			System.out.println("Your Output :"+ans1);
		}
		if(output2.equals(ans2)) {
			System.out.println("Case 2 Passed");
		}else {
			System.out.println("Case 2 Failed");
			System.out.println("Actual Output :"+output2 );
			System.out.println("Your Output :"+ans2);
		}
		if(output3.equals(ans3)) {
			System.out.println("Case 3 Passed");
		}else {
			System.out.println("Case 3 Failed");
			System.out.println("Actual Output :"+output3);
			System.out.println("Your Output :"+ans3);
		}



	}

}
