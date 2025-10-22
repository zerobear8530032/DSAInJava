//3347. Maximum Frequency of an Element After Performing Operations II
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array nums and two integers k and numOperations.
//
//You must perform an operation numOperations times on nums, where in each operation you:
//
//Select an index i that was not selected in any previous operations.
//Add an integer in the range [-k, k] to nums[i].
//Return the maximum possible frequency of any element in nums after performing the operations.
//
//
//
//Example 1:
//
//Input: nums = [1,4,5], k = 1, numOperations = 2
//
//Output: 2
//
//Explanation:
//
//We can achieve a maximum frequency of two by:
//
//Adding 0 to nums[1], after which nums becomes [1, 4, 5].
//Adding -1 to nums[2], after which nums becomes [1, 4, 4].
//Example 2:
//
//Input: nums = [5,11,20,20], k = 5, numOperations = 1
//
//Output: 2
//
//Explanation:
//
//We can achieve a maximum frequency of two by:
//
//Adding 0 to nums[1].
//
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 109
//0 <= k <= 109
//0 <= numOperations <= nums.length

package BinarySearch;

import java.util.Arrays;

public class MaximumFrequencyOfAnElementAfterPerformingOperationsII_3347 {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        return -1;
    }

    public static int binarySearchFoundUpperBound(int [] nums , int target, int k){
        int s=0;
        int e= nums.length-1;
        while(s<e){
            int m = s+e/2;
            if((nums[m]+k)>target){
                e=m;
            }else{
                s=m+1;
            }
        }
        return s;
    }
    public static void main(String[] args) {
        //Example 1:

        int[] nums1 = {1, 4, 5};
        int k1 = 1, numOperations1 = 2;
        int output1 = 2;

        //Example 2:

        int[] nums2 = {5, 11, 20, 20};
        int k2 = 5, numOperations2 = 1;
        int output2 = 2;

        //Example 3:

        int[] nums3 = {1,1,2,2,3,3,4,4,4,4,5,5,6,6,7,8,8,10};
        int k3 = 1, numOperations3 = 2;
        int output3 = 2;

        System.out.println(binarySearchFoundUpperBound(nums3,1,k3));

    }
}
