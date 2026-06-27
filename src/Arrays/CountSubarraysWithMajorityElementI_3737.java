//3737. Count Subarrays With Majority Element I
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array nums and an integer target.
//
//Return the number of subarrays of nums in which target is the majority element.
//
//The majority element of a subarray is the element that appears strictly more than half of the times in that subarray.
//
//
//
//Example 1:
//
//Input: nums = [1,2,2,3], target = 2
//
//Output: 5
//
//Explanation:
//
//Valid subarrays with target = 2 as the majority element:
//
//nums[1..1] = [2]
//nums[2..2] = [2]
//nums[1..2] = [2,2]
//nums[0..2] = [1,2,2]
//nums[1..3] = [2,2,3]
//So there are 5 such subarrays.
//
//Example 2:
//
//Input: nums = [1,1,1,1], target = 1
//
//Output: 10
//
//Explanation:
//
//​​​​​​​All 10 subarrays have 1 as the majority element.
//
//Example 3:
//
//Input: nums = [1,2,3], target = 4
//
//Output: 0
//
//Explanation:
//
//target = 4 does not appear in nums at all. Therefore, there cannot be any subarray where 4 is the majority element. Hence the answer is 0.
//
//
//
//Constraints:
//
//1 <= nums.length <= 1000
//1 <= nums[i] <= 10​​​​​​​9
//1 <= target <= 109
package Arrays;

public class CountSubarraysWithMajorityElementI_3737 {
//   approch : we can find every single subarray and track the count of
//    target and check its is the majority element or not
//    time complexity : O(n *n)
//    space complexity : O(1)
    public static int countMajoritySubarrays(int[] nums, int target) {
        int res=0;
        for(int i =0;i<nums.length;i++){
            int targetCount=0;
            for(int j=i;j<nums.length;j++){
                if(target==nums[j]){
                    targetCount++;
                }
                int size = j-i+1;
                if(targetCount>size/2){
                    res++;
                }
            }
        }
        return res;

    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,2,3};
        int target1 = 2;
        int output1 = 5;

        //Example 2:

        int [] nums2 = {1,1,1,1};
        int target2 = 1;
        int output2 = 10;
        //Example 3:

        int [] nums3 = {1,2,3};
        int target3 = 4;
        int output3 = 0;

        int ans1= countMajoritySubarrays(nums1,target1);
        int ans2= countMajoritySubarrays(nums2,target2);
        int ans3= countMajoritySubarrays(nums3,target3);
        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
    }
}
