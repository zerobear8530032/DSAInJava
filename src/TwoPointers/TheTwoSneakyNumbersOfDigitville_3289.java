//3289. The Two Sneaky Numbers of Digitville
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//In the town of Digitville, there was a list of numbers called nums containing integers from 0 to n - 1. Each number was supposed to appear exactly once in the list, however, two mischievous numbers sneaked in an additional time, making the list longer than usual.
//
//As the town detective, your task is to find these two sneaky numbers. Return an array of size two containing the two numbers (in any order), so peace can return to Digitville.
//
//
//
//Example 1:
//
//Input: nums = [0,1,1,0]
//
//Output: [0,1]
//
//Explanation:
//
//The numbers 0 and 1 each appear twice in the array.
//
//Example 2:
//
//Input: nums = [0,3,2,1,3,2]
//
//Output: [2,3]
//
//Explanation:
//
//The numbers 2 and 3 each appear twice in the array.
//
//Example 3:
//
//Input: nums = [7,1,5,4,3,4,6,0,9,5,8,2]
//
//Output: [4,5]
//
//Explanation:
//
//The numbers 4 and 5 each appear twice in the array.
//
//
//
//Constraints:
//
//2 <= n <= 100
//nums.length == n + 2
//0 <= nums[i] < n
//The input is generated such that nums contains exactly two repeated elements.
package TwoPointers;

import java.util.Arrays;

public class TheTwoSneakyNumbersOfDigitville_3289 {
//    approch:
//    here we can map each number to a index of map array and compute their frequency
//    if the frequency of any number is 2 we can add it to answer
//    time complexity : O(n)
//    space complexity : O(n)
    public static int[] getSneakyNumbersBruteForce(int[] nums) {
        int []values = new int [nums.length];
        for(int x:nums){values[x]++;}
        int [] res= new int [2];
        int idx=0;
        for(int i =0;i<nums.length;i++){
            if(values[i]==2){
                res[idx]=i;
                idx++;
            }
        }
        return res;
    }

    
    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {0,1,1,0};
        int [] output1= {0,1};

        //Example 2:

        int [] nums2 = {0,3,2,1,3,2};
        int [] output2= {2,3};

        //Example 3:

        int [] nums3 = {7,1,5,4,3,4,6,0,9,5,8,2};
        int [] output3= {4,5};

        int [] ans1 =getSneakyNumbersBruteForce(nums1);
        int [] ans2 =getSneakyNumbersBruteForce(nums2);
        int [] ans3 =getSneakyNumbersBruteForce(nums3);

        Arrays.sort(ans1);
        Arrays.sort(ans2);
        Arrays.sort(ans3);
        if(Arrays.equals(output1, ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output1) );
            System.out.println("Your Output :"+Arrays.toString(ans1));
        }
        if(Arrays.equals(output2, ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output2) );
            System.out.println("Your Output :"+Arrays.toString(ans2));
        }
        if(Arrays.equals(output3, ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output3) );
            System.out.println("Your Output :"+Arrays.toString(ans3));
        }
        System.out.println("Better Approch :");

        ans1 =getSneakyNumbersBetter(nums1);
        ans2 =getSneakyNumbersBetter(nums2);
        ans3 =getSneakyNumbersBetter(nums3);
        ans3 =getSneakyNumbersBetter(new int [] {0,0,1,1});


        Arrays.sort(ans1);
        Arrays.sort(ans2);
        Arrays.sort(ans3);

        if(Arrays.equals(output1, ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output1) );
            System.out.println("Your Output :"+Arrays.toString(ans1));
        }
        if(Arrays.equals(output2, ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output2) );
            System.out.println("Your Output :"+Arrays.toString(ans2));
        }
        if(Arrays.equals(output3, ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+Arrays.toString(output3) );
            System.out.println("Your Output :"+Arrays.toString(ans3));
        }

    }
}
