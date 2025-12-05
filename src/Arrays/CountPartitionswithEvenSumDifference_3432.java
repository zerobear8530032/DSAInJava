//3432. Count Partitions with Even Sum Difference
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array nums of length n.
//
//A partition is defined as an index i where 0 <= i < n - 1, splitting the array into two non-empty subarrays such that:
//
//Left subarray contains indices [0, i].
//Right subarray contains indices [i + 1, n - 1].
//Return the number of partitions where the difference between the sum of the left and right subarrays is even.
//
//
//
//Example 1:
//
//Input: nums = [10,10,3,7,6]
//
//Output: 4
//
//Explanation:
//
//The 4 partitions are:
//
//[10], [10, 3, 7, 6] with a sum difference of 10 - 26 = -16, which is even.
//[10, 10], [3, 7, 6] with a sum difference of 20 - 16 = 4, which is even.
//[10, 10, 3], [7, 6] with a sum difference of 23 - 13 = 10, which is even.
//[10, 10, 3, 7], [6] with a sum difference of 30 - 6 = 24, which is even.
//Example 2:
//
//Input: nums = [1,2,2]
//
//Output: 0
//
//Explanation:
//
//No partition results in an even sum difference.
//
//Example 3:
//
//Input: nums = [2,4,6,8]
//
//Output: 3
//
//Explanation:
//
//All partitions result in an even sum difference.
//
//
//
//Constraints:
//
//2 <= n == nums.length <= 100
//1 <= nums[i] <= 100
package Arrays;

public class CountPartitionswithEvenSumDifference_3432 {
    public static int countPartitions(int[] nums) {
        int sum =0;
        for(int i =0;i<nums.length;i++){
            sum+= nums[i];
        }

        int res=0;
        int leftSubrray=0;
        for(int i =0;i<nums.length-1;i++){
            leftSubrray+=nums[i];
            sum-=nums[i];
            if(Math.abs(leftSubrray-sum)%2==0){
                res++;
            }

        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {10,10,3,7,6};
        int output1=4;

        //Example 2:

        int [] nums2 = {1,2,2};
        int output2=0;

        //Example 3:

        int [] nums3 = {2,4,6,8};
        int output3=3;

        int ans1= countPartitions(nums1);
        int ans2= countPartitions(nums2);
        int ans3= countPartitions(nums3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
