//47. Permutations II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
//
//
//
//Example 1:
//
//Input: nums = [1,1,2]
//Output:
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
//Example 2:
//
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//
//
//Constraints:
//
//1 <= nums.length <= 8
//-10 <= nums[i] <= 10

package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII_47 {
    public static boolean check(List<List<Integer>> res, List<List<Integer>> output) {
        if(res.size()!= output.size()){
            return false;
        }
        List<List<Integer>> a = new ArrayList<>();
        for(List<Integer> l: res){
            a.add(new ArrayList<>(l));
        }
        List<List<Integer>> b = new ArrayList<>();
        for(List<Integer> l: res){
            b.add(new ArrayList<>(l));
        }
        for(int i =0;i<a.size();i++){
            boolean ispresent= false;
            for(int j=0;j<b.size();j++){
                if(a.get(i).equals(b.get(j))){
                    ispresent=true;
                }
            }
            if(ispresent==false){
                return false;
            }
        }
        return true;
    }
//    we find all permutation using recursive back tracking when we take a number once we does not take it for next recursion call
//    time complexity :O(n2⋅n!)
//    space complexity :O(n*n!)

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        boolean[] used= new boolean [nums.length];
        Arrays.sort(nums);
        helper(nums,res,used, new ArrayList<>());
        return res;
    }

    public static void helper(int [] nums , List<List<Integer>> res, boolean [] used, List<Integer> curr){
        if(curr.size()==nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i =0;i<used.length;i++){
            if(!used[i]){

                curr.add(nums[i]);
                used[i]=true;
                helper(nums,res,used,curr);
                used[i]=false;
                curr.remove(curr.size()-1);
                while(i+1<nums.length && nums[i]==nums[i+1]){i++;}
            }
        }
    }

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,1,2};
        List<List<Integer>> output1= Arrays.asList(
                Arrays.asList(1,1,2),
                Arrays.asList(1,2,1),
                Arrays.asList(2,1,1)
        );
        //Example 2:

        int [] nums2 = {1,2,3};
        List<List<Integer>> output2= Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(1,3,2),
                Arrays.asList(2,1,3),
                Arrays.asList(2,3,1),
                Arrays.asList(3,1,2),
                Arrays.asList(3,2,1)
        );

        List<List<Integer>> ans1= permuteUnique(nums1);
        List<List<Integer>> ans2= permuteUnique(nums2);

        if(check(output1,ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }

        if(check(output2,ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }

    }
}
