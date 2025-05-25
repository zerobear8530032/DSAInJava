//40. Combination Sum II
//Medium
//Topics
//Companies
//Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
//
//Each number in candidates may only be used once in the combination.
//
//Note: The solution set must not contain duplicate combinations.
//
// 
//
//Example 1:
//
//Input: candidates = [10,1,2,7,6,1,5], target = 8
//Output: 
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
//Example 2:
//
//Input: candidates = [2,5,2,1,2], target = 5
//Output: 
//[
//[1,2,2],
//[5]
//]
// 
//
//Constraints:
//
//1 <= candidates.length <= 100
//1 <= candidates[i] <= 50
//1 <= target <= 30




package Recursion;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;

public class CombinationSumII_40 {
	
	
//	 brute force approch uses a hash set which store all the subset combination 
//	sum upto target and by sorting it makes it no equal pairs get in output 
//	time complexity :  O(2^n * k log k)
//	space complexity : O(n)
	public static List<List<Integer>> combinationSum2BruteForce(int[] candidates, int target) {
	        HashSet<List<Integer>> res= new HashSet();
	        Arrays.sort(candidates);
	        helper(candidates,res, new ArrayList(), 0, target);
	        return new ArrayList(res);
	}
	
	

	public static void helper(int [] candiates,HashSet<List<Integer>> res, List<Integer> curroutput, int start, int target) {
		if(target==0) {
			Collections.sort(curroutput);
			res.add(new ArrayList(curroutput));
			return ;
		}
		for(int i =start;i<candiates.length;i++ ) {
			int x= candiates[i];
			
			if(target-x<0  || x==0) {
				continue;
			}
			curroutput.add(x);
			helper(candiates,res,curroutput,start+1,target-x);
			// back track 
			curroutput.remove(curroutput.size()-1);
		}
	}
	
	
	
//	better approch :
//	we can skip all occurence of duplicate element by sorting it and skipping all of them

//	time complexity :  O(2^n * k log k)
//	time complexity :   `O(2^n)`  
//	space complexity :   `O(n)`  
	public static List<List<Integer>> combinationSum2Better(int[] candidates, int target) {
		List<List<Integer>> res= new ArrayList();
		Arrays.sort(candidates);
		helper2(candidates,res, new ArrayList(), 0, target);
		return new ArrayList(res);
	}
	
	

	public static void helper2(int [] candiates,List<List<Integer>> res, List<Integer> cur, int start, int target) {
		if(target==0) {
			res.add(new ArrayList(cur));
			return ;
		}
		if(target<0) {
			return ;
		}
		if(candiates.length==start) {
			return ;
		}
		
//		include candidate at [i]
		cur.add(candiates[start]);
		helper2(candiates, res, cur, start+1, target-candiates[start]);
		cur.remove(cur.size()-1);
//		skip candidate at [i]
		while(start+1<candiates.length && candiates[start]==candiates[start+1]) {
			start++;
		}
		helper2(candiates, res, cur, start+1, target);
		
//		back tracking 
		
	}
	
	

	public static void main(String[] args) {
		
		
		//Example 1:

		int [] candidates1 = {10,1,2,7,6,1,5};
		int target1 = 8;
		List<List<Integer>> output1= new ArrayList(
			Arrays.asList(
					Arrays.asList(1,1,6),
					Arrays.asList(1,2,5),
					Arrays.asList(1,7),
					Arrays.asList(2,6)					
					)
				);

		//Example 2:
		
		int [] candidates2 = {2,5,2,1,2};
		int target2 = 5;
		List<List<Integer>> output2= new ArrayList(
				Arrays.asList(
						Arrays.asList(1,2,2),
						Arrays.asList(5)
						)
				);
		
		System.out.println(combinationSum2Better(candidates1, target1));



	}

}
