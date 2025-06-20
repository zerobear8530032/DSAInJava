//39. Combination Sum
//Medium
//Topics
//Companies
//Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
//
//The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.
//
//The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

//Example 1:
//
//Input: candidates = [2,3,6,7], target = 7
//Output: [[2,2,3],[7]]
//Explanation:
//2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
//7 is a candidate, and 7 = 7.
//These are the only two combinations.
//Example 2:
//
//Input: candidates = [2,3,5], target = 8
//Output: [[2,2,2,2],[2,3,3],[3,5]]
//Example 3:
//
//Input: candidates = [2], target = 1
//Output: []
// 
//
//Constraints:
//
//1 <= candidates.length <= 30
//2 <= candidates[i] <= 40
//All elements of candidates are distinct.
//1 <= target <= 40
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum_39 {
//	back trackking approch :
//	we apply process unprocess approch :
//	here the res is the final answer and currlist is the sum
//	by recursive back tracking we build up the res where if target ==0 we add to result list
//	important note here : currlist deep copy should be added in the last result
//	and each iteration check every single element present in array from current till end
//	not from 0 
//	Time Complexity :O(k * 2^T)
//	Space Complexity :O(target + R * k)

	 public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		 List<List<Integer>> res= new ArrayList<List<Integer>>();
		 sumHelper(res,new ArrayList(),candidates,target,0);
	        return res;
	    }
	 
	 public static void sumHelper(List<List<Integer>> res,List<Integer> currlist,int [] candidates, int target ,int index){
		 if(target==0) {
			 res.add(new ArrayList<>(currlist)); // Make a deep copy		
			return ;
		 }
		 if(index>=candidates.length) return ;
		 
		 for(int i =index;i<candidates.length;i++) {
			 int x= candidates[i];
			 if((target-x)>=0) {
				 currlist.add(x);
				 sumHelper(res,currlist,candidates,target-x,i);
				 currlist.remove(currlist.size()-1);
			 }
		 } 
	 }

	public   static void main(String[] args) {
		
		
		//Example 1:

		int [] candidates1 = {2,3,6,7};
		int target1 = 7;
		List<List<Integer>> output1= new ArrayList(Arrays.asList(Arrays.asList(2,2,3),Arrays.asList(7)));

		//Example 2:
	
		int [] candidates2 = {2,3,5};
		int target2 = 8;
		List<List<Integer>> output2= new ArrayList(Arrays.asList(Arrays.asList(2,2,2,2),Arrays.asList(2,3,3),Arrays.asList(3,5)));

		//Example 3:

		int [] candidates3 = {2};
		int target3 = 1;
		List<List<Integer>> output3= new ArrayList();
		
		
		
		List<List<Integer>> ans1=combinationSum(candidates1, target1);
		List<List<Integer>>ans2=combinationSum(candidates2, target2);
		List<List<Integer>>ans3=combinationSum(candidates3,target3);
		
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
