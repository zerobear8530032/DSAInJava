//2958. Length of Longest Subarray With at Most K Frequency
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array nums and an integer k.
//
//The frequency of an element x is the number of times it occurs in an array.
//
//An array is called good if the frequency of each element in this array is less than or equal to k.
//
//Return the length of the longest good subarray of nums.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,1,2,3,1,2], k = 2
//Output: 6
//Explanation: The longest possible good subarray is [1,2,3,1,2,3] since the values 1, 2, and 3 occur at most twice in this subarray. Note that the subarrays [2,3,1,2,3,1] and [3,1,2,3,1,2] are also good.
//It can be shown that there are no good subarrays with length more than 6.
//Example 2:
//
//Input: nums = [1,2,1,2,1,2,1,2], k = 1
//Output: 2
//Explanation: The longest possible good subarray is [1,2] since the values 1 and 2 occur at most once in this subarray. Note that the subarray [2,1] is also good.
//It can be shown that there are no good subarrays with length more than 2.
//Example 3:
//
//Input: nums = [5,5,5,5,5,5,5], k = 4
//Output: 4
//Explanation: The longest possible good subarray is [5,5,5,5] since the value 5 occurs 4 times in this subarray.
//It can be shown that there are no good subarrays with length more than 4.
//
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 109
//1 <= k <= nums.length
package Graphs;

import java.util.HashMap;

public class LengthOfLongestSubarrayWithAtMostKFrequency_2958 {
    public static int maxSubarrayLength(int[] nums, int k) {
        int s=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int res=0;
        for(int e=0;e<nums.length;e++){
            map.put(nums[e],map.getOrDefault(nums[e],0)+1);
            while(map.get(nums[e])>k){
                map.put(nums[s],map.get(nums[s])-1);
                if(map.get(nums[s])==0){
                    map.remove(nums[s]);
                }
                s++;
            }
            res=Math.max(res,e-s+1);
        }
        return res;
    }

    public static boolean isValid(HashMap<Integer,Integer> map, int k){
        for(int key : map.keySet()){
            if(map.get(key)>k){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,3,1,2,3,1,2};
        int k1 = 2;
        int output1 =6;

        //Example 2:

        int [] nums2 = {1,2,1,2,1,2,1,2};
        int k2 = 1;
        int output2 =2;

        //Example 3:

        int [] nums3 = {5,5,5,5,5,5,5,5};
        int k3 = 4;
        int output3 =4;


        int ans1= maxSubarrayLength(nums1,k1);
        int ans2= maxSubarrayLength(nums2,k2);
        int ans3= maxSubarrayLength(nums3,k3);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
    }
}
