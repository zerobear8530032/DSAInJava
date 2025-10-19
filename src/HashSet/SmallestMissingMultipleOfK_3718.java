//3718 Smallest Missing Multiple of K
//Solved
//Easy
//3 pt.
//Given an integer array nums and an integer k, return the smallest positive multiple of k that is missing from nums.
//
//A multiple of k is any positive integer divisible by k.
//
// 
//
//Example 1:
//
//Input: nums = [8,2,3,4,6], k = 2
//
//Output: 10
//
//Explanation:
//
//The multiples of k = 2 are 2, 4, 6, 8, 10, 12... and the smallest multiple missing from nums is 10.
//
//Example 2:
//
//Input: nums = [1,4,7,10,15], k = 5
//
//Output: 5
//
//Explanation:
//
//The multiples of k = 5 are 5, 10, 15, 20... and the smallest multiple missing from nums is 5.
//
// 
//
//Constraints:
//
//1 <= nums.length <= 100
//1 <= nums[i] <= 100
//1 <= k <= 100©leetcode
package HashSet;

import java.util.HashSet;

public class SmallestMissingMultipleOfK_3718 {
    public static int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set=new HashSet();
        for(int x:nums){
            set.add(x);
        }
        int i=1;
        while(set.contains(k*i)){
            i++;
        }
        return k*i;
    }
    public static void main(String[] args) {


        //Example 1:

        int [] nums1 = {8,2,3,4,6};
        int k1 = 2;
        int output1= 10;

        //Example 2:

        int [] nums2 = {1,4,7,10,15};
        int k2 = 5;
        int output2= 5;

        int ans1=missingMultiple(nums1,k1);
        int ans2=missingMultiple(nums2,k2);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }



    }
}
