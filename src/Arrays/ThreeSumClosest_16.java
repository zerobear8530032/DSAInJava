//16. 3Sum Closest
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
//
//Return the sum of the three integers.
//
//You may assume that each input would have exactly one solution.
//
//
//
//Example 1:
//
//Input: nums = [-1,2,1,-4], target = 1
//Output: 2
//Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
//Example 2:
//
//Input: nums = [0,0,0], target = 1
//Output: 0
//Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
//
//
//Constraints:
//
//3 <= nums.length <= 500
//-1000 <= nums[i] <= 1000
//-104 <= target <= 104
package Arrays;

import java.util.Arrays;

public class ThreeSumClosest_16 {
    public static int threeSumClosest(int[] nums, int target) {
        // sort the values
        Arrays.sort(nums);
        int res=nums[0]+nums[1]+nums[2];
        for(int i =0;i<nums.length-2;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                int sum =nums[i]+nums[j]+nums[k];
                int diff= Math.abs(sum-target);
                if(diff<Math.abs(res-target)){
                    res=sum;
                }
                if(sum<target){
                    j++;
                }else{
                    k--;
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {-1,2,1,-4};
        int target1 = 1;
        int output1=2;

        //Example 2:

        int [] nums2 = {0,0,0};
        int target2 = 1;
        int output2=0;

        //Example 3:

        int [] nums3 = {0,1,2};
        int target3 = 0;
        int output3=3;


        int  ans1 = threeSumClosest(nums1,target1);
        int  ans2 = threeSumClosest(nums2,target2);
        int  ans3 = threeSumClosest(nums3,target3);

        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }
    }
}
