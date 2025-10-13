//Find the Duplicate Number
//Solved
//You are given an array of integers nums containing n + 1 integers. Each integer in nums is in the range [1, n] inclusive.
//
//Every integer appears exactly once, except for one integer which appears two or more times. Return the integer that appears more than once.
//
//Example 1:
//
//Input: nums = [1,2,3,2,2]
//
//Output: 2
//Example 2:
//
//Input: nums = [1,2,3,4,4]
//
//Output: 4
//Follow-up: Can you solve the problem without modifying the array nums and using
//O
//(
//1
//)
//O(1) extra space?
//
//Constraints:
//
//1 <= n <= 10000
//nums.length == n + 1
//1 <= nums[i] <= n
package Arrays;

import java.util.Arrays;

public class FindTheDuplicateNumber_NEETCODE {
//     approch : simply use count sort and
//    put all elements to thre value-i index and check if before are index -1 have alreay same element if true
//    return the value other wise swap and do it for all elments in the end the return -1 if no found
//    time complexity : O(n)
//    space complexity : O(1)// we can replace elements inplace in original array
    public static int findDuplicate(int[] nums) {
        int idx=0;
        int [] arr = Arrays.copyOf(nums,nums.length);
        while(idx<arr.length){
            while(arr[idx]-1!=idx){
                if(arr[arr[idx]-1]==arr[idx]){return arr[idx];}
                swap(arr,arr[idx]-1,idx);
            }
            idx++;
        }
        return -1;
    }


    public static void swap(int []nums ,int i1 ,int i2){
        int temp = nums[i1];
        nums[i1]= nums[i2];
        nums[i2]=temp;
    }

// here we simply use cycle detection algorithm and try to find the  starting of cycle
//    time complexity : O(n)
//    space complexity : O(1)
    public static int findDuplicateBetter(int[] nums) {
        int s= 0;
        int f= 0;
        do{
            s=nums[s];
            f=nums[nums[f]];
        }while(s!=f);
        f=0;
        while(f!=s){
            f=nums[f];
            s=nums[s];
        }
        return s;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {1,2,3,2,2};
        int output1= 2;

        //Example 2:

        int [] nums2 = {1,2,3,4,4};
        int output2= 4;

        int ans1 = findDuplicate(nums1);
        int ans2 = findDuplicate(nums2);

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

        System.out.println("Better Approch :");

        ans1 = findDuplicateBetter(nums1);
        ans2 = findDuplicateBetter(nums2);

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



    }
}
