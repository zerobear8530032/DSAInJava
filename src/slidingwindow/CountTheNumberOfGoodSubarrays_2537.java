//2537. Count the Number of Good Subarrays
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given an integer array nums and an integer k, return the number of good subarrays of nums.
//
//A subarray arr is good if there are at least k pairs of indices (i, j) such that i < j and arr[i] == arr[j].
//
//A subarray is a contiguous non-empty sequence of elements within an array.
//
//
//
//Example 1:
//
//Input: nums = [1,1,1,1,1], k = 10
//Output: 1
//Explanation: The only good subarray is the array nums itself.
//Example 2:
//
//Input: nums = [3,1,4,3,2,2,4], k = 2
//Output: 4
//Explanation: There are 4 different good subarrays:
//- [3,1,4,3,2,2] that has 2 pairs.
//- [3,1,4,3,2,2,4] that has 3 pairs.
//- [1,4,3,2,2,4] that has 2 pairs.
//- [4,3,2,2,4] that has 2 pairs.
//
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i], k <= 109
package slidingwindow;

import java.util.HashMap;

public class CountTheNumberOfGoodSubarrays_2537 {
//     approch :
//    we can use hashmap to keep track of pairs and
//    if pairs are equal to k  we can assume rest of subarray will also be good subarray
//    time complexity : O(n)
//    space complexity : O(n)
    public static long countGood(int[] nums, int k) {
        long res=0;
        long pairs= 0;
        int l=0;
        int r =0;
        HashMap<Integer,Integer> map= new HashMap();
        while(r<nums.length){
            pairs= pairs+ map.getOrDefault(nums[r],0);
            map.put(nums[r],map.getOrDefault(nums[r],0)+1);
            while(pairs>=k){
                res+= (nums.length-r);
                map.put(nums[l],map.getOrDefault(nums[l],0)-1);
                pairs=pairs- map.getOrDefault(nums[l],0);
                l++;
            }
            r++;
        }
        return res;
    }
    public static void main(String[] args) {

        //Example 1:

        int [] nums1 = {1,1,1,1,1};
        int k1 = 10;
        int output1= 1;

        //Example 2:

        int [] nums2 = {3,1,4,3,2,2,4};
        int k2 = 2;
        int output2= 4;

        long ans1= countGood(nums1,k1);
        long ans2= countGood(nums2,k2);

        if(ans1==output1) {
            System.out.println("Case 1 Passed ");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Excepted Output : "+ output1);
            System.out.println("Your Output : "+ ans1);
        }

        if(ans2==output2) {
            System.out.println("Case 2 Passed ");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Excepted Output : "+ output2);
            System.out.println("Your Output : "+ ans2);
        }

    }
}
