//955. Delete Columns to Make Sorted II
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given an array of n strings strs, all of the same length.
//
//We may choose any deletion indices, and we delete all the characters in those indices for each string.
//
//For example, if we have strs = ["abcdef","uvwxyz"] and deletion indices {0, 2, 3}, then the final array after deletions is ["bef", "vyz"].
//
//Suppose we chose a set of deletion indices answer such that after deletions, the final array has its elements in lexicographic order (i.e., strs[0] <= strs[1] <= strs[2] <= ... <= strs[n - 1]). Return the minimum possible value of answer.length.
//
//
//
//Example 1:
//
//Input: strs = ["ca","bb","ac"]
//Output: 1
//Explanation:
//After deleting the first column, strs = ["a", "b", "c"].
//Now strs is in lexicographic order (ie. strs[0] <= strs[1] <= strs[2]).
//We require at least 1 deletion since initially strs was not in lexicographic order, so the answer is 1.
//Example 2:
//
//Input: strs = ["xc","yb","za"]
//Output: 0
//Explanation:
//strs is already in lexicographic order, so we do not need to delete anything.
//Note that the rows of strs are not necessarily in lexicographic order:
//i.e., it is NOT necessarily true that (strs[0][0] <= strs[0][1] <= ...)
//Example 3:
//
//Input: strs = ["zyx","wvu","tsr"]
//Output: 3
//Explanation: We have to delete every column.
//
//
//Constraints:
//
//n == strs.length
//1 <= n <= 100
//1 <= strs[i].length <= 100
//strs[i] consists of lowercase English letters.
package Strings;

import java.util.HashSet;
public class DeleteColumnsToMakeSortedII_955 {
// approch : simple simulate what to do
//    just when deleting a column we have to restart our check
//    time complexuty : O(n*m)
//    space complexuty : O(n)
    public static int minDeletionSize(String[] strs) {
        HashSet<Integer> deleted = new HashSet();
        helper(0,strs,deleted);
        return deleted.size();
    }

    private static void helper(int idx,String[] strs, HashSet<Integer> deleted) {
        if (deleted.size() == strs[0].length()) {
            return;
        }
        for (int w = 0; w < strs.length - 1; w++) {
            String s1= strs[w];
            String s2= strs[w+1];
            for (int i = 0; i < s1.length(); i++) {
                if (deleted.contains(i)) {
                    continue;
                }
                char ch1 = s1.charAt(i);
                char ch2 = s2.charAt(i);
                if (ch1 > ch2) {
                    deleted.add(i);
                    helper(i+1,strs, deleted);
                    return ;
                } else if (ch1 < ch2) {
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        //Example 1:

        String [] strs1 = {"ca","bb","ac"};
        int output1= 1;

        //Example 2:

        String [] strs2 = {"xc","yb","za"};
        int output2= 0;

        //Example 3:

        String [] strs3 = {"zyx","wvu","tsr"};
        int output3= 3;

        int ans1= minDeletionSize(strs1);
        int ans2= minDeletionSize(strs2);
        int ans3= minDeletionSize(strs3);

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
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }
    }
}
