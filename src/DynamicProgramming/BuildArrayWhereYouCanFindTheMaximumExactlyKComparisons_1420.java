//1420. Build Array Where You Can Find The Maximum Exactly K Comparisons
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You are given three integers n, m and k. Consider the following algorithm to find the maximum element of an array of positive integers:
//
//
//You should build the array arr which has the following properties:
//
//arr has exactly n integers.
//1 <= arr[i] <= m where (0 <= i < n).
//After applying the mentioned algorithm to arr, the value search_cost is equal to k.
//Return the number of ways to build the array arr under the mentioned conditions. As the answer may grow large, the answer must be computed modulo 109 + 7.
//
//
//
//Example 1:
//
//Input: n = 2, m = 3, k = 1
//Output: 6
//Explanation: The possible arrays are [1, 1], [2, 1], [2, 2], [3, 1], [3, 2] [3, 3]
//Example 2:
//
//Input: n = 5, m = 2, k = 3
//Output: 0
//Explanation: There are no possible arrays that satisfy the mentioned conditions.
//Example 3:
//
//Input: n = 9, m = 1, k = 1
//Output: 1
//Explanation: The only possible array is [1, 1, 1, 1, 1, 1, 1, 1, 1]
//
//
//Constraints:
//
//1 <= n <= 50
//1 <= m <= 100
//0 <= k <= n
package DynamicProgramming;

public class BuildArrayWhereYouCanFindTheMaximumExactlyKComparisons_1420 {

// we can use recursive back tracking to solve this questions then we can memorize the recusion
//    time complexity : O( n *m *n)
//    space complexity : O( n *m *n)
    static int MOD = 1000000007;
    public static int numOfArrays(int n, int m, int k) {
        Integer [][][] memo = new Integer [n+1][n+1][m+1];
        return helper(0,0,0,n,m,k,memo);
    }
    public static int helper(int idx,int max ,int searchCost,int n,int m, int k,Integer  [][][]memo ){
        if(memo[idx][searchCost][max]!=null){
            return memo[idx][searchCost][max];
        }
        if(idx==n){
            return searchCost==k? 1:0;
        }
        int res=0;
        for(int i=1;i<=m;i++){
            if(i>max){
                res=(res+helper(idx+1,i,searchCost+1,n,m,k, memo))%MOD;
            }else{
                res=(res+helper(idx+1,max,searchCost,n,m,k,memo))%MOD;
            }
        }
        memo[idx][searchCost][max]= res;
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int n1 = 2, m1 = 3, k1 = 1;
        int output1= 6;

        //Example 2:

        int n2 = 5, m2 = 2, k2 = 3;
        int output2= 0;

        //Example 3:

        int n3 = 9, m3 = 1, k3 = 1;
        int output3= 1;

        int ans1 = numOfArrays(n1,m1,k1);
        int ans2 = numOfArrays(n2,m2,k2);
        int ans3 = numOfArrays(n3,m3,k3);



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
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }
    }
}
