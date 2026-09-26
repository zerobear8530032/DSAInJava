
//1658. Minimum Operations to Reduce X to Zero
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array nums and an integer x. In one operation, you can either remove the leftmost or the rightmost element from the array nums and subtract its value from x. Note that this modifies the array for future operations.
//
//Return the minimum number of operations to reduce x to exactly 0 if it is possible, otherwise, return -1.
//
//
//
//Example 1:
//
//Input: nums = [1,1,4,2,3], x = 5
//Output: 2
//Explanation: The optimal solution is to remove the last two elements to reduce x to zero.
//Example 2:
//
//Input: nums = [5,6,7,8,9], x = 4
//Output: -1
//Example 3:
//
//Input: nums = [3,2,20,1,1,3], x = 10
//Output: 5
//Explanation: The optimal solution is to remove the last three elements and the first two elements (5 operations in total) to reduce x to zero.
//
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 104
//1 <= x <= 109
package DynamicProgramming;
public class MinimumOperationsToReduceXToZero_1658 {
//    approch :
//    instead of thinking about removing elements we can think about what elements to keep in mid
//    after removal which leads to our answer
//    we can find longest continous subarray which will tell which element left after removal of
//    elements then rest of elements are the one we need to remove to get our answer
//    time complexity : O(n)
//    space complexity : O(n)
    public static int minOperations(int[] nums, int x) {
        int sum =0;
        for(int num : nums){
            sum +=num;
        }
        if(sum<x){
            return -1;
        }
        if(sum==x){
            return nums.length;
        }
        int target = sum-x;
        int l =0;
        int curr=0;
        int len =0;
        for(int r =0;r<nums.length;r++){
            curr += nums[r];
            while(l<=r && curr>target){
                curr -= nums[l];
                l++;
            }
            if(curr == target){
                len = Math.max(r-l+1,len);
            }
        }
        if(len==0){
            return -1;
        }
        return nums.length - len;
    }

    public static void main(String[] args) {
        //Example 1:

        int []nums1 = {1,1,4,2,3};
        int x1= 5;
        int output1 =2;

        //Example 2:

        int [] nums2 = {5,6,7,8,9};
        int x2= 4;
        int output2 =-1;

        //Example 3:

        int [] nums3 = {3,2,20,1,1,3};
        int x3= 10;
        int output3 =5;

        int ans1= minOperations(nums1,x1);
        int ans2= minOperations(nums2,x2);
        int ans3= minOperations(nums3,x3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Output :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }


    }
}
