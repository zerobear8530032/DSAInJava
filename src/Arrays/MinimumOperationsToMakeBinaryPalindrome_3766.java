// 3766 Minimum Operations to Make Binary Palindrome
//Solved
//Medium
//5 pt.
//You are given an integer array nums.
//
//For each element nums[i], you may perform the following operations any number of times (including zero):
//
//Increase nums[i] by 1, or
//Decrease nums[i] by 1.
//A number is called a binary palindrome if its binary representation without leading zeros reads the same forward and backward.
//
//Your task is to return an integer array ans, where ans[i] represents the minimum number of operations required to convert nums[i] into a binary palindrome.
//
// 
//
//Example 1:
//
//Input: nums = [1,2,4]
//
//Output: [0,1,1]
//
//Explanation:
//
//One optimal set of operations:
//
//nums[i]	Binary(nums[i])	Nearest
//Palindrome	Binary
//(Palindrome)	Operations Required	ans[i]
//1	1	1	1	Already palindrome	0
//2	10	3	11	Increase by 1	1
//4	100	3	11	Decrease by 1	1
//Thus, ans = [0, 1, 1].
//
//Example 2:
//
//Input: nums = [6,7,12]
//
//Output: [1,0,3]
//
//Explanation:
//
//One optimal set of operations:
//
//nums[i]	Binary(nums[i])	Nearest
//Palindrome	Binary
//(Palindrome)	Operations Required	ans[i]
//6	110	5	101	Decrease by 1	1
//7	111	7	111	Already palindrome	0
//12	1100	15	1111	Increase by 3	3
//Thus, ans = [1, 0, 3].
//
// 
//
//Constraints:
//
//1 <= nums.length <= 5000
//​​​​​​​1 <= nums[i] <= 5000©leetcode
package Arrays;

import java.util.Arrays;

public class MinimumOperationsToMakeBinaryPalindrome_3766 {
//    we can use brute force approch:
//    time complexity : O(n)
//    space complexity : O(1)
    public static int[] minOperations(int[] nums) {
        int [] res = new int [nums.length];
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            int addOperations= 0;
            while(!binaryPalindrome(num)){
                addOperations++;
                num++;
            }
            num=nums[i];
            int subOperations= 0;
            while(!binaryPalindrome(num)){
                subOperations++;
                num--;
            }
            res[i]=Math.min(subOperations,addOperations);
        }
        return res;
    }

    public static boolean binaryPalindrome(int n){
        int rev=0;
        int temp =n;
        while(temp!=0){
            int bit = temp&1;
            rev= rev<<1;
            rev= rev | bit;
            temp= temp>>1;
        }
        return rev==n;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,4};
        int [] output1= {0,1,1};

        //Example 2:

        int [] nums2 = {6,7,12};
        int [] output2= {1,0,3};

        int [] ans1= minOperations(nums1);
        int [] ans2= minOperations(nums2);
        if(Arrays.equals(ans1,output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output1) );
            System.out.println("Your Output :"+Arrays.toString(ans1));
        }
        if(Arrays.equals(output2,ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output2 ));
            System.out.println("Your Output :"+Arrays.toString(ans2));
        }
    }
}
