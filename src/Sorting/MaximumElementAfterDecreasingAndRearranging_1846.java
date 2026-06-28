//1846. Maximum Element After Decreasing and Rearranging
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array of positive integers arr. Perform some operations (possibly none) on arr so that it satisfies these conditions:
//
//The value of the first element in arr must be 1.
//The absolute difference between any 2 adjacent elements must be less than or equal to 1. In other words, abs(arr[i] - arr[i - 1]) <= 1 for each i where 1 <= i < arr.length (0-indexed). abs(x) is the absolute value of x.
//There are 2 types of operations that you can perform any number of times:
//
//Decrease the value of any element of arr to a smaller positive integer.
//Rearrange the elements of arr to be in any order.
//Return the maximum possible value of an element in arr after performing the operations to satisfy the conditions.
//
//
//
//Example 1:
//
//Input: arr = [2,2,1,2,1]
//Output: 2
//Explanation:
//We can satisfy the conditions by rearranging arr so it becomes [1,2,2,2,1].
//The largest element in arr is 2.
//Example 2:
//
//Input: arr = [100,1,1000]
//Output: 3
//Explanation:
//One possible way to satisfy the conditions is by doing the following:
//1. Rearrange arr so it becomes [1,100,1000].
//2. Decrease the value of the second element to 2.
//3. Decrease the value of the third element to 3.
//Now arr = [1,2,3], which satisfies the conditions.
//The largest element in arr is 3.
//Example 3:
//
//Input: arr = [1,2,3,4,5]
//Output: 5
//Explanation: The array already satisfies the conditions, and the largest element is 5.
//
//
//Constraints:
//
//1 <= arr.length <= 105
//1 <= arr[i] <= 109
package Sorting;

import java.util.Arrays;

public class MaximumElementAfterDecreasingAndRearranging_1846 {
//    approch : if we sort it we arange every thing in the place now we can do assume first element is 1
//    and then we can see from 1 to n-1 index of arr
//    if current index i is greater then prev we can lower down the current number to
//    prev+1;
//    and we can do this for every number find the max of prev , current res;
//
//    time complexity : O(N log N)
//    space compelxity O(1)
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        if(arr.length==1){return 1;}
        Arrays.sort(arr);
        int prev=1;
        int res=1;
        for(int i =1;i<arr.length;i++){
            if(arr[i]-prev>1){
                arr[i]=prev+1;
            }
            prev=arr[i];
            res=Math.max(res,arr[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] arr1 = {2,2,1,2,1};
        int output1=2;

        //Example 2:

        int [] arr2 = {100,1,1000};
        int output2=3;

        //Example 3:

        int [] arr3 = {1,2,3,4,5};
        int output3= 5;

        int ans1= maximumElementAfterDecrementingAndRearranging(arr1);
        int ans2= maximumElementAfterDecrementingAndRearranging(arr2);
        int ans3= maximumElementAfterDecrementingAndRearranging(arr3);

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
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
    }
}
