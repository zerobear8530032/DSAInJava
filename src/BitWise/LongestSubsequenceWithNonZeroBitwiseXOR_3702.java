//3702. Longest Subsequence With Non-Zero Bitwise XOR
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given an integer array nums.
//
//Return the length of the longest subsequence in nums whose bitwise XOR is non-zero. If no such subsequence exists, return 0.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3]
//
//Output: 2
//
//Explanation:
//
//One longest subsequence is [2, 3]. The bitwise XOR is computed as 2 XOR 3 = 1, which is non-zero.
//
//Example 2:
//
//Input: nums = [2,3,4]
//
//Output: 3
//
//Explanation:
//
//The longest subsequence is [2, 3, 4]. The bitwise XOR is computed as 2 XOR 3 XOR 4 = 5, which is non-zero.
//
//
//
//Constraints:
//
//1 <= nums.length <= 105
//0 <= nums[i] <= 109
package BitWise;

public class LongestSubsequenceWithNonZeroBitwiseXOR_3702 {
// approch :
//    if we can say xor of all element is not 0 we can return length
//    but if its is then we can remove a single element form that can make it non 0
//    but if all elements are 0 then there is no non zero XOR array:
//    time complexity : O(n)
//    space complexity : O(1)
    public static int longestSubsequence(int[] nums) {
        int XOR=0;
        int zeroFreq=0;
        for(int x:nums){
            if(x==0){
                zeroFreq++;
            }
            XOR= XOR^x;
        }
        if(zeroFreq==nums.length){return 0;}
        return XOR==0? nums.length-1:nums.length;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,3};
        int output1=2;

        //Example 2:

        int [] nums2 = {2,3,4};
        int output2=3;

        int ans1 = longestSubsequence(nums1);
        int ans2 = longestSubsequence(nums2);


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
