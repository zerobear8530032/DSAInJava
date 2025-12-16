//646. Maximum Length of Pair Chain
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//You are given an array of n pairs pairs where pairs[i] = [lefti, righti] and lefti < righti.
//
//A pair p2 = [c, d] follows a pair p1 = [a, b] if b < c. A chain of pairs can be formed in this fashion.
//
//Return the length longest chain which can be formed.
//
//You do not need to use up all the given intervals. You can select pairs in any order.
//
//
//
//Example 1:
//
//Input: pairs = [[1,2],[2,3],[3,4]]
//Output: 2
//Explanation: The longest chain is [1,2] -> [3,4].
//Example 2:
//
//Input: pairs = [[1,2],[7,8],[4,5]]
//Output: 3
//Explanation: The longest chain is [1,2] -> [4,5] -> [7,8].
//
//
//Constraints:
//
//n == pairs.length
//1 <= n <= 1000
//-1000 <= lefti < righti <= 1000
package DynamicProgramming;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain_646 {
//    same as our Longest increasing subsequence \
//    just we sort the array of pairs because we want the pairs to be in a increasing format
    public static int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<int[]>() {
            public int compare(int[] n1, int[] n2) {
                if (n1[0] != n2[0]) {
                    return n1[0] - n2[0];
                }
                return n1[1] - n2[1];
            }
        });
        int [] table= new int [pairs.length+1];
        for(int i=0;i<pairs.length;i++){
            table[i]=1;
        }
        int res=1;
        for(int i=0;i<pairs.length;i++){
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1]){
                    table[i]= Math.max(table[i],table[j]+1);
                    res=Math.max(table[i],res);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [][] pairs1 = {{1,2},{2,3},{3,4}};
        int output1=2;

        //Example 2:

        int [][] pairs2 = {{1,2},{7,8},{4,5}};
        int output2=3;

    }
}
