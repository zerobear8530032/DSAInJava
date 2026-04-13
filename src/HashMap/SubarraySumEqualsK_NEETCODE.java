//Subarray Sum Equals K
//Medium
//Topics
//Company Tags
//You are given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//Example 1:
//
//Input: nums = [2,-1,1,2], k = 2
//
//Output: 4
//Explanation: [2], [2,-1,1], [-1,1,2], [2] are the subarrays whose sum is equals to k.
//
//Example 2:
//
//Input: nums = [4,4,4,4,4,4], k = 4
//
//Output: 6
//Constraints:
//
//1 <= nums.length <= 20,000
//-1,000 <= nums[i] <= 1,000
//-10,000,000 <= k <= 10,000,000
package HashMap;

import java.util.HashMap;

public class SubarraySumEqualsK_NEETCODE {
//    we use a hashmap to keep track of number of prefix sum we got as we go thorught and find the
//    current prefix sum -k exists in out map if exists we found  a valid subarray
//    make sure the inital map hve a pair (0,1)
//    time complexity : O(n)
//    space complexity : O(n)
    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap();
        int prefix=0;
        int res=0;
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            prefix+=nums[i];
            int remaing= prefix -k;
            if(map.containsKey(remaing)){
                res+=map.get(remaing);
            }
            map.put(prefix,map.getOrDefault(prefix,0)+1);
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {2,-1,1,2};
        int k1 = 2;
        int output1= 4;

        //Example 2:

        int [] nums2 = {4,4,4,4,4,4};
        int k2 = 4;
        int output2=6;

        int ans1=  subarraySum(nums1,k1);
        int ans2=  subarraySum(nums2,k2);

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

    }
}
