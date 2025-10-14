//3349. Adjacent Increasing Subarrays Detection I
//Attempted
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given an array nums of n integers and an integer k, determine whether there exist two adjacent subarrays of length k such that both subarrays are strictly increasing. Specifically, check if there are two subarrays starting at indices a and b (a < b), where:
//
//Both subarrays nums[a..a + k - 1] and nums[b..b + k - 1] are strictly increasing.
//The subarrays must be adjacent, meaning b = a + k.
//Return true if it is possible to find two such subarrays, and false otherwise.
//
//
//
//Example 1:
//
//Input: nums = [2,5,7,8,9,2,3,4,3,1], k = 3
//
//Output: true
//
//Explanation:
//
//The subarray starting at index 2 is [7, 8, 9], which is strictly increasing.
//The subarray starting at index 5 is [2, 3, 4], which is also strictly increasing.
//These two subarrays are adjacent, so the result is true.
//Example 2:
//
//Input: nums = [1,2,3,4,4,4,4,5,6,7], k = 5
//
//Output: false
//
//
//
//Constraints:
//
//2 <= nums.length <= 100
//1 < 2 * k <= nums.length
//-1000 <= nums[i] <= 1000
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI_3349 {
// approch:
// start from 0 and check what is the increasing sequence you can  get from there if the sequence
// if greteger or equal k*2 then return true other wise
// we can check it greater or equal to k we we can increase index + increasing sequence and check for next sub array
// if the increasing sequence is smaller then k we can reset the first check form idx+= increasing
//    time complexity : O(n)
//    space complexity : O(1)

    public static  boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int idx =0;
        while(idx<n){
            int increasing =numberOfIncreasingSequence(idx,nums);
            if(increasing>=k*2){return true;}
            if(increasing<k){
                idx+=increasing;
            }else{
                idx+=increasing;
                int remaining = numberOfIncreasingSequence(idx,nums);
                if(remaining>=k){return true;}
                idx+=remaining;
            }
        }

        return false;
    }

    public static int numberOfIncreasingSequence(int origin , List<Integer> nums){
        int idx=origin;
        while(idx+1<nums.size() && nums.get(idx)<nums.get(idx+1)){
            idx++;
        }
        return idx-origin +1;
    }
    public static void main(String[] args) {
        //Example 1:

        List<Integer> nums1 = new ArrayList<>(Arrays.asList(2,5,7,8,9,2,3,4,3,1));
        int k1 = 3;
        boolean output1= true;

        //Example 2:
        List<Integer> nums2 = new ArrayList<>(Arrays.asList(1,2,3,4,4,4,4,5,6,7));
        int k2 = 5;
        boolean output2= false;

        //Example 36tg:
        List<Integer> nums3 = new ArrayList<>(Arrays.asList(2,5,7,8,9,10,11,14,3,1));
        int k3= 3;
        boolean output3= true;

        boolean ans1=  hasIncreasingSubarrays(nums1,k1);
        boolean ans2=  hasIncreasingSubarrays(nums2,k2);
        boolean ans3=  hasIncreasingSubarrays(nums3,k3);

    }
}
