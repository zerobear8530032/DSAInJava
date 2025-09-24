//77. Combinations
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
//
//You may return the answer in any order.
//
//
//
//Example 1:
//
//Input: n = 4, k = 2
//Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
//Explanation: There are 4 choose 2 = 6 total combinations.
//Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
//Example 2:
//
//Input: n = 1, k = 1
//Output: [[1]]
//Explanation: There is 1 choose 1 = 1 total combination.
//
//
//Constraints:
//
//1 <= n <= 20
//1 <= k <= n
package Backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations_77 {
//     approch :
//    we can use recursion and backtracking where we can have a current combination if it reaches
//    the length k we can add the combination to the  final res
//    other wise we can get the next element
//    time complexity : O(k⋅C(n,k))
//    space complexit

    public static List<List<Integer>> combine(int n, int k) {
        // helper
        List<List<Integer>> output= new ArrayList<>();
        helper(n,k,1,output,new ArrayList<>());
        return output;
    }

    public static void helper(int n, int k , int val, List<List<Integer>> output, List<Integer> combination){
        if(combination.size()==k){
            output.add(new ArrayList(combination));
            return ;
        }
        for(int i =val;i<=n-(k-combination.size())+1;i++){
            combination.add(i);
            helper(n,k,i+1,output,combination);
            combination.remove(combination.size()-1);
        }
    }


    public static void main(String[] args) {
        //Example 1:

        int  n1 = 4, k1 = 2;
        List<List<Integer>> output1 = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1, 2),
                        Arrays.asList(1, 3),
                        Arrays.asList(1, 4),
                        Arrays.asList(2, 3),
                        Arrays.asList(2, 4),
                        Arrays.asList(3, 4)
                )
        );

        //Example 2:

        int n2 = 1, k2 = 1;
        List<List<Integer>> output2 = new ArrayList<>(
                Arrays.asList(
                        Arrays.asList(1)  // note the inner Arrays.asList
                )
        );




        List<List<Integer>> ans1=combine(n1,k1);
        List<List<Integer>> ans2=combine(n2,k2);


        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }
    }
}
