//120. Triangle
//Medium
//Topics
//premium lock icon
//Companies
//Given a triangle array, return the minimum path sum from top to bottom.
//
//For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.
//
//
//
//Example 1:
//
//Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//Output: 11
//Explanation: The triangle looks like:
//   2
//  3 4
// 6 5 7
//4 1 8 3
//The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
//Example 2:
//
//Input: triangle = [[-10]]
//Output: -10
//
//
//Constraints:
//
//1 <= triangle.length <= 200
//triangle[0].length == 1
//triangle[i].length == triangle[i - 1].length + 1
//-104 <= triangle[i][j] <= 104
//
//
//Follow up: Could you do this using only O(n) extra space, where n is the total number of rows in the triangle?
package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Triangle_120 {

// approch : try every single way to get sum :
//    time complexity : O(2^n)
//    space complexity : O(n)
    public static int minimumTotalBruteForce(List<List<Integer>> triangle) {
        return helper(triangle,0,0);
    }

    private static int helper(List<List<Integer>> triangle, int depth, int idx) {
        if(depth==triangle.size()){
            return 0;
        }
        if(triangle.get(depth).size()==idx){
            return Integer.MAX_VALUE;
        }
        int curr=triangle.get(depth).get(idx);
        int left = helper(triangle,depth+1,idx);
        int right = helper(triangle,depth+1,idx+1);
        return curr+ Math.min(left,right);
    }
    // approch : try every single way to get sum with memo :
    //    time complexity : O(n^2)
    //    space complexity : O(n^2)
    public static int minimumTotalBetter(List<List<Integer>> triangle) {
        HashMap<String,Long> memo= new HashMap<>();
        return (int)helper(triangle,0,0,memo);
    }

    private static long helper(List<List<Integer>> triangle, int depth, int idx, HashMap<String,Long> memo) {
        if(depth==triangle.size()){
            return 0;
        }
        if(triangle.get(depth).size()==idx){
            return Integer.MAX_VALUE;
        }
        String key = depth+","+idx;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        long curr=triangle.get(depth).get(idx);
        long left = helper(triangle,depth+1,idx,memo);
        long right = helper(triangle,depth+1,idx+1,memo);

        long res= curr+ Math.min(left,right);
        memo.put(key,res);
        return res;
    }




    // approch : bottom up dp here we look from down and try to build our solution upwards :
    //    time complexity : O(n^2)
    //    space complexity : O(n)
     public static int minimumTotalBest(List<List<Integer>> triangle) {
        // tabulation :
        int n= triangle.size();
        int [] table = new int [triangle.size()];
        for(int i =0;i<n;i++){
            table[i]= triangle.get(n - 1).get(i);
        }
         for (int row = n - 2; row >= 0; row--) {
             for (int col = 0; col <= row; col++) {
                 table[col] = triangle.get(row).get(col) + Math.min(table[col], table[col + 1]);
             }
         }

        return table[0];
    }

    public static void main(String[] args) {
        //Example 1:

        List<List<Integer>> triangle1 = new ArrayList<>(Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3,4),
                Arrays.asList(6,5,7),
                Arrays.asList(4,1,8,3)
        ));
        int output1=11;

        //Example 2:

        List<List<Integer>> triangle2 = new ArrayList<>(Arrays.asList(
                Arrays.asList(-10)
                ));
        int output2=-10;

        int ans1=minimumTotalBruteForce(triangle1);
        int ans2=minimumTotalBruteForce(triangle2);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        System.out.println("Better Approch :");


         ans1=minimumTotalBruteForce(triangle1);
         ans2=minimumTotalBruteForce(triangle2);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }

        System.out.println("Best Approch :");

        ans1 = minimumTotalBest(triangle1);
        ans2 = minimumTotalBest(triangle2);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }



    }
}
