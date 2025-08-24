//3659. Partition Array Into K-Distinct Groups
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given an integer array nums and an integer k.
//
//Your task is to determine whether it is possible to partition all elements of nums into one or more groups such that:
//
//Each group contains exactly k distinct elements.
//Each element in nums must be assigned to exactly one group.
//Return true if such a partition is possible, otherwise return false.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3,4], k = 2
//
//Output: true
//
//Explanation:
//
//One possible partition is to have 2 groups:
//
//Group 1: [1, 2]
//Group 2: [3, 4]
//Each group contains k = 2 distinct elements, and all elements are used exactly once.
//
//Example 2:
//
//Input: nums = [3,5,2,2], k = 2
//
//Output: true
//
//Explanation:
//
//One possible partition is to have 2 groups:
//
//Group 1: [2, 3]
//Group 2: [2, 5]
//Each group contains k = 2 distinct elements, and all elements are used exactly once.
//
//Example 3:
//
//Input: nums = [1,5,2,3], k = 3
//
//Output: false
//
//Explanation:
//
//We cannot form groups of k = 3 distinct elements using all values exactly once.
//
//
//
//Constraints:
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 105
//​​​​​​​1 <= k <= nums.length

package Arrays;

import java.util.HashMap;

public class PartitionArrayIntoK_DistinctGroups_3659 {
//   approch : the total number of group we can make
//   if k distinct elements should be present in each grp is
//    n/k : if n%k!=0 mean some elements are not present in any grp
//    means not possible
//    second condition was to each grp can have only distinct elements
//   so if maxfreq of elements are more then our n/k groups mean
//    either extra duplicate elements need to be ingrp
//    or left out
//    so we can return false if any of these two condition does not satisfy
//    we can use hashmap to store max freq
//    time complexity :O(n)
//    space complexity :O(n)
    public static boolean partitionArray(int[] nums, int k) {
        //  all elements can be in k groups if n%k==0
        // the max number of groups that can be made is the max frequency cause no duplicate allow in group
        if(nums.length%k==0){
            HashMap<Integer,Integer> map = new HashMap();
            int maxFreq=0;
            int groups= nums.length/k;
            for(int x:nums){
                map.put(x,map.getOrDefault(x,0)+1);
                maxFreq= Math.max(maxFreq,map.get(x));
            }
            return maxFreq<=groups;
        }
        return false;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,3,4};
        int k1 = 2;
        boolean output1=true;

        //Example 2:

        int [] nums2 = {3,5,2,2};
        int k2 = 2;
        boolean output2=true;

        //Example 3:

        int [] nums3 = {1,5,2,3};
        int k3 = 3;
        boolean output3=false;

        boolean ans1= partitionArray(nums1,k1);
        boolean ans2= partitionArray(nums2,k2);
        boolean ans3= partitionArray(nums3,k3);

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
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }

    }
}
