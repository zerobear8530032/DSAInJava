//1200. Minimum Absolute Difference
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.
//
//Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
//
//a, b are from arr
//a < b
//b - a equals to the minimum absolute difference of any two elements in arr
//
//
//Example 1:
//
//Input: arr = [4,2,1,3]
//Output: [[1,2],[2,3],[3,4]]
//Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
//Example 2:
//
//Input: arr = [1,3,6,10,15]
//Output: [[1,3]]
//Example 3:
//
//Input: arr = [3,8,-10,23,19,-4,-14,27]
//Output: [[-14,-10],[19,23],[23,27]]
//
//
//Constraints:
//
//2 <= arr.length <= 105
//-106 <= arr[i] <= 106
package Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference_1200 {
//   approch:
//     we cam  sort the arry then we can just find closet number together means the min difference
//    of 2 number is just besides them then we can find min difference amoung all numbers in 1 run
//    then another attemp to find all pairs of min difference
//    time complexity : O(n)
//    space complexity : O(n)
    public static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res= new ArrayList();
        int minDiff=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++){
            int diff= Math.abs(arr[i]-arr[i+1]);
            minDiff=Math.min(diff,minDiff);
        }

        for(int i =0;i<arr.length-1;i++){
            int diff= Math.abs(arr[i]-arr[i+1]);
            if(diff==minDiff){
                res.add(Arrays.asList(arr[i],arr[i+1]));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] arr1 = {4,2,1,3};
        List<Integer> output1= new ArrayList(
                Arrays.asList(
                        Arrays.asList(1,2),
                        Arrays.asList(2,3),
                        Arrays.asList(3,4)
                )
        );

        //Example 2:

        int [] arr2 = {1,3,6,10,15};
        List<Integer> output2= new ArrayList(
                Arrays.asList(
                        Arrays.asList(1,3)
                )
        );

        //Example 3:

        int [] arr3 = {3,8,-10,23,19,-4,-14,27};
        List<Integer> output3= new ArrayList(
                Arrays.asList(
                        Arrays.asList(-14,-10),
                        Arrays.asList(19,23),
                        Arrays.asList(23,27)
                )
        );

        List<List<Integer>> ans1=  minimumAbsDifference(arr1);
        List<List<Integer>> ans2=  minimumAbsDifference(arr2);
        List<List<Integer>> ans3=  minimumAbsDifference(arr3);


        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ output1);
            System.out.println("Your Answer :"+ ans1);
        }

        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ output2);
            System.out.println("Your Answer :"+ ans2);
        }
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ output3);
            System.out.println("Your Answer :"+ ans3);
        }
    }
}
