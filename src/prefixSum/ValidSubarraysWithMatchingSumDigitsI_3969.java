//3969. Valid Subarrays With Matching Sum Digits I
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given an integer array nums and an integer digit x.
//
//A subarray nums[l..r] is considered valid if the sum of its elements satisfies both of the following conditions:
//
//The first digit of the sum is equal to x.
//The last digit of the sum is equal to x.
//Return the number of valid subarrays.
//
//
//
//Example 1:
//
//Input: nums = [1,100,1], x = 1
//
//Output: 4
//
//Explanation:
//
//The valid subarrays are:
//
//nums[0..0]: sum = 1
//nums[0..1]: sum = 1 + 100 = 101
//nums[1..2]: sum = 100 + 1 = 101
//nums[2..2]: sum = 1
//Thus, the answer is 4.
//
//Example 2:
//
//Input: nums = [1], x = 2
//
//Output: 0
//
//Explanation:
//
//The only subarray is nums[0..0] with a sum of 1, which does not satisfy the conditions.
//
//Thus, the answer is 0.
//
//
//
//Constraints:
//
//1 <= nums.length <= 1500
//1 <= nums[i] <= 109
//1 <= x <= 9
package prefixSum;

public class ValidSubarraysWithMatchingSumDigitsI_3969 {
//    approch : we can use 2 nested loop to find every single subarray and by prefix sum
//    we can take ongoing sum and check the first and last character of the number
//    and return true if both are equal
//    time complexity : O(n*n)
//    space complexity : O(n*n)
    public static int countValidSubarrays(int[] nums, int x) {
        int res=0;
        for(int i =0;i<nums.length;i++){
            long sum =0;
            for(int j =i;j<nums.length;j++){
                sum+=nums[j];
                if(check(sum,x)){
                    res++;
                }
            }
        }
        return res;
    }

    private  static boolean check(long x , int target){
        String s= Long.toString(x);
        int f= s.charAt(0)-'0';
        int l= s.charAt(s.length()-1)-'0';
        return f== target && l==target;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,100,1};
        int x1 = 1;
        int output1=4;

        //Example 2:

        int [] nums2 = {1};
        int x2 = 2;
        int output2=0;

        int ans1= countValidSubarrays(nums1,x1);
        int ans2= countValidSubarrays(nums2,x2);


        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
    }
}
