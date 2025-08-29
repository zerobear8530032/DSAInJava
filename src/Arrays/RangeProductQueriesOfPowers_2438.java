//2438. Range Product Queries of Powers
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given a positive integer n, there exists a 0-indexed array called powers, composed of the minimum number of powers of 2 that sum to n. The array is sorted in non-decreasing order, and there is only one way to form the array.
//
//You are also given a 0-indexed 2D integer array queries, where queries[i] = [lefti, righti]. Each queries[i] represents a query where you have to find the product of all powers[j] with lefti <= j <= righti.
//
//Return an array answers, equal in length to queries, where answers[i] is the answer to the ith query. Since the answer to the ith query may be too large, each answers[i] should be returned modulo 109 + 7.
//
//
//
//Example 1:
//
//Input: n = 15, queries = [[0,1],[2,2],[0,3]]
//Output: [2,4,64]
//Explanation:
//For n = 15, powers = [1,2,4,8]. It can be shown that powers cannot be a smaller size.
//Answer to 1st query: powers[0] * powers[1] = 1 * 2 = 2.
//Answer to 2nd query: powers[2] = 4.
//Answer to 3rd query: powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64.
//Each answer modulo 109 + 7 yields the same answer, so [2,4,64] is returned.
//Example 2:
//
//Input: n = 2, queries = [[0,0]]
//Output: [2]
//Explanation:
//For n = 2, powers = [2].
//The answer to the only query is powers[0] = 2. The answer modulo 109 + 7 is the same, so [2] is returned.
//
//
//Constraints:
//
//1 <= n <= 109
//1 <= queries.length <= 105
//0 <= starti <= endi < powers.length
package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class RangeProductQueriesOfPowers_2438 {
    private static int MOD = 1000000007;
    public static  int[] productQueries(int n, int[][] queries) {
        List<Integer> powers = new ArrayList<>();
        int power =0;
        int  num=n;
        while(num!=0){
            if((num&1)==1){
                powers.add(1<<power);
            }
            num=num>>1;
            power++;
        }
        // System.out.println((powers));
        int [] res = new int [queries.length];
        int idx=0;
        for(int [] query:queries){
            res[idx]=apply(query,powers);
            idx++;
        }
        return res;
    }

    public static int apply(int query[], List<Integer> powers){
        long res = 1;
        for (int i = query[0]; i <= query[1]; i++) {
            res = (res * powers.get(i)) % MOD;
        }
        return (int) res;

    }
    public static void main(String[] args) {
        // Example 1:

        int n1 = 15;
        int [][] queries1 = {{0,1},{2,2},{0,3}};
        int [] output1= {2,4,64};

        //Example 2:

        int n2 = 2;
        int [][] queries2 = {{0,0}};
        int [] output2= {2};

        int [] ans1 = productQueries(n1,queries1);
        int [] ans2 = productQueries(n2,queries2);

        if(Arrays.equals(ans1, output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ Arrays.toString(output1));
            System.out.println("Your Answer :"+ Arrays.toString(ans1));
        }
        if(Arrays.equals(ans2, output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ Arrays.toString(output2));
            System.out.println("Your Answer :"+ Arrays.toString(ans2));
        }

    }
}
