//3727. Maximum Alternating Sum of Squares
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given an integer array nums. You may rearrange the elements in any order.
//
//The alternating score of an array arr is defined as:
//
//score = arr[0]2 - arr[1]2 + arr[2]2 - arr[3]2 + ...
//Return an integer denoting the maximum possible alternating score of nums after rearranging its elements.
//
//
//
//Example 1:
//
//Input: nums = [1,2,3]
//
//Output: 12
//
//Explanation:
//
//A possible rearrangement for nums is [2,1,3], which gives the maximum alternating score among all possible rearrangements.
//
//The alternating score is calculated as:
//
//score = 22 - 12 + 32 = 4 - 1 + 9 = 12
//
//Example 2:
//
//Input: nums = [1,-1,2,-2,3,-3]
//
//Output: 16
//
//Explanation:
//
//A possible rearrangement for nums is [-3,-1,-2,1,3,2], which gives the maximum alternating score among all possible rearrangements.
//
//The alternating score is calculated as:
//
//score = (-3)2 - (-1)2 + (-2)2 - (1)2 + (3)2 - (2)2 = 9 - 1 + 4 - 1 + 9 - 4 = 16
//
//
//
//Constraints:
//
//1 <= nums.length <= 105
//-4 * 104 <= nums[i] <= 4 * 104
package Arrays;

import java.util.Arrays;

public class MaximumAlternatingSumOfSquares_3727 {
//     approch :
//    by seeing in formula we can see - ve number dose not matter because of square
//    and all even index are the one will become negative
//    so if we sort the array after squaring all numbers
//    we can get all elements at even index from left to right
//    and all odd index element from right to left
//    and we apply this arrangement in the formula is our max answer:
//    time compelxity : O (n log n)
//    space compelxity : O (1): we can directly compute the res without actuall creating arrangement
public static long maxAlternatingSum(int[] nums) {
    for(int i=0;i<nums.length;i++){
        nums[i]= nums[i]*nums[i];
    }
    Arrays.sort(nums);
    int s=0;
    int e=nums.length-1;
    long res=0;
    while(s<e){
        int l=nums[s];
        int r=nums[e];
        res+= r-l;
        e--;
        s++;
    }
    if(s==e){
        res+=nums[s];
    }
    return res;
}
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,3};
        int output1= 12;

        //Example 2:

        int [] nums2 = {1,-1,2,-2,3,-3};
        int output2= 16;

        long ans1 = maxAlternatingSum(nums1);
        long ans2 = maxAlternatingSum(nums2);

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

    }
}
