//40. Combination Sum II
//Solved
//Medium
//Topics
//premium lock icon
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
package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII_40 {
//    here we can use simple backtracking where we will do one thing where we try to take all elements one time and skip all elements
//    one time to not take duplicate of same values
//    time complexity : O(n^m)
//    space complexity : O(n)
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res= new ArrayList();
        Arrays.sort(candidates);
        helper(candidates, res,new ArrayList<>(),0,target);
        return res;
    }
    public static void helper(int [] nums , List<List<Integer>> res, List<Integer> curr,int idx,int target){
        if(target==0){
            res.add(new ArrayList(curr));
            return ;
        }
        if(target<0 || idx==nums.length){
            return ;
        }
        //  include every thing :
        curr.add(nums[idx]);
        helper(nums,res,curr,idx+1,target-nums[idx]);
        curr.remove(curr.size()-1);
        //  exclude  the num[i] used above:
        while(idx+1 <nums.length && nums[idx]==nums[idx+1]){
            idx++;
        }
        helper(nums,res,curr,idx+1,target);
    }
    public static void main(String[] args) {
        //Example 1:

        int [] candidates1 = {10,1,2,7,6,1,5};
        int target1 = 8;
        List<List<Integer>> output1= new ArrayList<>(
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
        List<List<Integer>> output2= new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1,2,2),
                        Arrays.asList(5)
                )
        );

        List<List<Integer>> ans1 =  combinationSum2(candidates1,target1);
        List<List<Integer>> ans2 =  combinationSum2(candidates2,target2);

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




    }
}
