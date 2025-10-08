//33. Search in Rotated Sorted Array
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//There is an integer array nums sorted in ascending order (with distinct values).
//
//Prior to being passed to your function, nums is possibly left rotated at an unknown index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be left rotated by 3 indices and become [4,5,6,7,0,1,2].
//
//Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//
//You must write an algorithm with O(log n) runtime complexity.
//
//
//
//Example 1:
//
//Input: nums = [4,5,6,7,0,1,2], target = 0
//Output: 4
//Example 2:
//
//Input: nums = [4,5,6,7,0,1,2], target = 3
//Output: -1
//Example 3:
//
//Input: nums = [1], target = 0
//Output: -1
//
//
//Constraints:
//
//1 <= nums.length <= 5000
//-104 <= nums[i] <= 104
//All values of nums are unique.
//nums is an ascending array that is possibly rotated.
//-104 <= target <= 104

package BinarySearch;

public class SearchInRotatedSorted_33 {
    public static int search(int[] nums, int target) {
        int s=0;
        int e = nums.length-1;
        while(s<=e){
            int m = s+(e-s)/2;
            if(nums[m]==target){
                return m;
            }
            if(nums[s]<=nums[m]){
                if(nums[s]<=target && target< nums[m]){
                    e=m-1;
                }else{
                    s=m+1;
                }
            }else{
                if(nums[m]<target && target<=nums[e]){
                    s=m+1;
                }else{
                    e=m-1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {4,5,6,7,0,1,2};
        int target1 = 0;
        int output1= 4;

        //Example 2:

        int [] nums2 = {4,5,6,7,0,1,2};
        int target2 = 3;
        int output2= -1;

        //Example 3:


        int [] nums3 = {1};
        int target3 = 0;
        int output3= -1;

        int ans1 = search(nums1,target1);
        int ans2 = search(nums2,target2);
        int ans3 = search(nums3,target3);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }






    }
}
