//46. Permutations
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3]
//Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
//Example 2:
//
//Input: nums = [0,1]
//Output: [[0,1],[1,0]]
//Example 3:
//
//Input: nums = [1]
//Output: [[1]]
//
//
//Constraints:
//
//1 <= nums.length <= 6
//-10 <= nums[i] <= 10
//All the integers of nums are unique.
package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_46 {
//    logic is just take one element and skip one element
//    time complexity O(N*N!)
//    space complexity : O(n) : with extra space of used array

        public static List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> output = new ArrayList();
            boolean [] used= new boolean[nums.length];
            helper(nums,used,output,new ArrayList<>());
            return output;
        }
        public static void helper(int [] nums,boolean [] used, List<List<Integer>> output,List<Integer> currList){
            if(currList.size()==nums.length){
                output.add(new ArrayList(currList));
            }
            for(int i =0;i<nums.length;i++){
                if(!used[i]){
                    currList.add(nums[i]);
                    used[i]=true;
                    helper(nums,used,output,currList);
                    currList.remove(currList.size()-1);
                    used[i]=false;
                }
            }

        }

    //    time complexity O(N*N!)
    //    space complexity : O(n) : np extra spaec other then callstack
    public static List<List<Integer>> permuteBetter(int[] nums) {
        List<List<Integer>> output= new ArrayList();
        backtrack(nums,0,output);
        return output;
    }

    public static void backtrack(int [] nums,int start,List<List<Integer>> output){
        if(start==nums.length){
            List<Integer> comb= new ArrayList();
            for(int x:nums){
                comb.add(x);
            }
            output.add(comb);
            return ;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            backtrack(nums, start + 1, output);
            swap(nums, start, i);
        }
    }

    public static void swap(int [] nums,int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1]=nums[idx2];
        nums[idx2]=temp;
    }


    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,3};
        List<List<Integer>> output1= new ArrayList<>(
                Arrays.asList(
                Arrays.asList(1,2,3),Arrays.asList(1,3,2),Arrays.asList(2,1,3)
                ,Arrays.asList(2,3,1),Arrays.asList(3,1,2), Arrays.asList(3,2,1)
                )
        );

        // Example 2:

        int [] nums2 = {0,1};
        List<List<Integer>> output2= new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(0,1),Arrays.asList(1,0)
                )
        );


        //Example 3:

        int [] nums3 = {1};
        List<List<Integer>> output3= new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1)
                )
        );

        List<List<Integer>> ans1= permute(nums1);
        List<List<Integer>> ans2= permute(nums2);
        List<List<Integer>> ans3= permute(nums3);
        System.out.println("Brute Force Approch :");

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }
        System.out.println("Better Approch :");


        ans1= permute(nums1);
        ans2= permute(nums2);
        ans3= permute(nums3);

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }


    }
}
