//3350. Adjacent Increasing Subarrays Detection II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given an array nums of n integers, your task is to find the maximum value of k for which there exist two adjacent subarrays of length k each, such that both subarrays are strictly increasing. Specifically, check if there are two subarrays of length k starting at indices a and b (a < b), where:
//
//Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
//The subarrays must be adjacent, meaning b = a + k.
//Return the maximum possible value of k.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//
//
//Example 1:
//
//Input: nums = [2,5,7,8,9,2,3,4,3,1]
//
//Output: 3
//
//Explanation:
//
//The subarray starting at index 2 is [7, 8, 9], which is strictly increasing.
//The subarray starting at index 5 is [2, 3, 4], which is also strictly increasing.
//These two subarrays are adjacent, and 3 is the maximum possible value of k for which two such adjacent strictly increasing subarrays exist.
//Example 2:
//
//Input: nums = [1,2,3,4,4,4,4,5,6,7]
//
//Output: 2
//
//Explanation:
//
//The subarray starting at index 0 is [1, 2], which is strictly increasing.
//The subarray starting at index 2 is [3, 4], which is also strictly increasing.
//These two subarrays are adjacent, and 2 is the maximum possible value of k for which two such adjacent strictly increasing subarrays exist.
//
//
//Constraints:
//
//2 <= nums.length <= 2 * 105
//-109 <= nums[i] <= 109

package Arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacentIncreasingSubarraysDetectionII_3350 {
//    approch :
//    we first find the strictly incresing sequence and then find next sticrly increasing sequence
//    if we observer we can convert  a single increasing sequence in 2 adjecent one by dividing its element in 2 parts
//    so we will try to compare  the fisst sequence length/2 and second sequence length /2
//    or the first and second sequence min and return the max of all of this
//    time complexity : O(n)
//    space complexity : O(1)
    public static int maxIncreasingSubarrays(List<Integer> nums) {
        int idx=0;
        int n = nums.size();
        int first=getIncreasingSequenceLength(nums,idx);
        idx+=first;
        int maxSequence=first/2;
        while(idx<n){
            int second = getIncreasingSequenceLength(nums,idx);
            idx+=second;
            maxSequence = Math.max(maxSequence,second/2);
            maxSequence = Math.max(maxSequence,Math.min(second,first));
            first=second;
        }
        return maxSequence;
    }

    public static int getIncreasingSequenceLength(List<Integer> arr, int origin){
        int idx=origin;
        while((idx+1)<arr.size() && arr.get(idx)<arr.get(idx+1)){
            idx++;
        }
        return idx-origin+1;
    }
    public static void main(String[] args) {
        //Example 1:
        List<Integer> nums1  = new ArrayList<>(Arrays.asList(2,5,7,8,9,2,3,4,3,1));
        int output1= 3;

        //Example 2:


        List<Integer> nums2 = new ArrayList<>(Arrays.asList(1,2,3,4,4,4,4,5,6,7));
        int output2= 2;

        int ans1= maxIncreasingSubarrays(nums1);
        int ans2= maxIncreasingSubarrays(nums1);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }

    }

}
