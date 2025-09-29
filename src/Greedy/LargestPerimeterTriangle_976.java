//976. Largest Perimeter Triangle
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Given an integer array nums, return the largest perimeter of a triangle with a non-zero area, formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
//
//
//
//Example 1:
//
//Input: nums = [2,1,2]
//Output: 5
//Explanation: You can form a triangle with three side lengths: 1, 2, and 2.
//Example 2:
//
//Input: nums = [1,2,1,10]
//Output: 0
//Explanation:
//You cannot use the side lengths 1, 1, and 2 to form a triangle.
//You cannot use the side lengths 1, 1, and 10 to form a triangle.
//You cannot use the side lengths 1, 2, and 10 to form a triangle.
//As we cannot use any three side lengths to form a triangle of non-zero area, we return 0.
//
//
//Constraints:
//
//3 <= nums.length <= 104
//1 <= nums[i] <= 106
package Greedy;

import java.util.Arrays;

public class LargestPerimeterTriangle_976 {
//     approch : to get largest area we need largest numbers
//    which are valid triangle
//    so we sorted first in descending order (this example have ascending order sorted)
//    so now we can take 3 consicutive triplets to find our answer
//    why we take 3 consicutive triplets :
//    here the intution  is the triangle is valid if
//    the sum of 2 side should always be greater then one side
//    so if we choose the largest number only 2 candidates which are equal or smaller numbers can only make
//    the sum greater then the one side because rest elements are smaller so they can never create
//    bigger sum
//    so we only take consicutive sum of elements form largest number to smaller numbers
//    if any where we found valid triangle its our answer
    public static int largestPerimeter(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res=0;
        for(int i =n-1;i>=2;i--){
            if(checkValidTriangle(nums[i],nums[i-1],nums[i-2])){
                return nums[i]+nums[i-1]+nums[i-2];
            }
        }
        return res;
    }

    public static boolean checkValidTriangle(int s1,int s2,int s3){
        return s1+s2>s3 && s2+s3>s1 && s1+s3>s2;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] nums1 = {2,1,2};
        int output1=5;

        //Example 2:

        int [] nums2 = {1,2,1,10};
        int output2=0;

        int ans1= largestPerimeter(nums1);
        int ans2= largestPerimeter(nums2);


        if(output1==(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }

    }
}
