//3637. Trionic Array I
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array nums of length n.
//
//An array is trionic if there exist indices 0 < p < q < n − 1 such that:
//
//nums[0...p] is strictly increasing,
//nums[p...q] is strictly decreasing,
//nums[q...n − 1] is strictly increasing.
//Return true if nums is trionic, otherwise return false.
//
//
//
//Example 1:
//
//Input: nums = [1,3,5,4,2,6]
//
//Output: true
//
//Explanation:
//
//Pick p = 2, q = 4:
//
//nums[0...2] = [1, 3, 5] is strictly increasing (1 < 3 < 5).
//nums[2...4] = [5, 4, 2] is strictly decreasing (5 > 4 > 2).
//nums[4...5] = [2, 6] is strictly increasing (2 < 6).
//Example 2:
//
//Input: nums = [2,1,3]
//
//Output: false
//
//Explanation:
//
//There is no way to pick p and q to form the required three segments.
//
//
//
//Constraints:
//
//3 <= n <= 100
//-1000 <= nums[i] <= 1000
package TwoPointers;

public class TrionicArrayI_3637 {
//     approch :
//    here we can go from left to right to get incresing sequence and right to left to find
//    decreasing sequnce
//    once reached if both pointer are equal we return false or any one pointer have not moved at all or reached at end of enteire array
//    once they reach their potion end we can move a single pointer which will cober the  remaing distnce to meet eacht otehr
//    if they meet its true oter wise false
//    time compelxity : O(n)
//    space compelxity : O(1)
    public static boolean isTrionic(int[] nums) {
        int s =0;
        while(s<nums.length-1 && nums[s]<nums[s+1]){
            s++;
        }
        int e =nums.length-1;
        while(e>0 && nums[e]>nums[e-1]){
            e--;
        }
        if(e==1 || s==nums.length-1 || e==nums.length-1 || s==0){return false;}
        while(s<nums.length-1 && nums[s]>nums[s+1]){
            s++;
        }
        return s==e;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,3,5,4,2,6};
        boolean output1 = true;

        //Example 2:

        int [] nums2 = {2,1,3};
        boolean output2 = false;


    }
}
