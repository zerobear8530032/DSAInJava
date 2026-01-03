//1411. Number of Ways to Paint N × 3 Grid
//Solved
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//You have a grid of size n x 3 and you want to paint each cell of the grid with exactly one of the three colors: Red, Yellow, or Green while making sure that no two adjacent cells have the same color (i.e., no two cells that share vertical or horizontal sides have the same color).
//
//Given n the number of rows of the grid, return the number of ways you can paint this grid. As the answer may grow large, the answer must be computed modulo 109 + 7.
//
//
//
//Example 1:
//
//
//Input: n = 1
//Output: 12
//Explanation: There are 12 possible way to paint the grid as shown.
//Example 2:
//
//Input: n = 5000
//Output: 30228214
//
//
//Constraints:
//
//n == grid.length
//1 <= n <= 5000
package DynamicProgramming;

public class NumberOfWaysToPaintN3Grid_1411 {
//    approch :
//    here we have all the state initially and we try to find next state which we can make from taking each state initally
//    time complexity : O(n* states)// here state is  12 which is constant
//    space complexity : O(n)
    static int MOD= 1000000007;
    static String [] states= {
            "RYR","YRY","GRY","RYG","YRG","GRG","RGR","YGR","GYR","RGY","YGY","GYG"};
    public static int numOfWays(int n) {
        int res=0;
        Integer [][] memo =new Integer [n+1][states.length+1];
        for(int i =0;i<states.length;i++){
            res= (res+helper(n-1,i,memo))%MOD;
        }
        return res;
    }

    public static int helper( int n , int  previdx, Integer [][] memo){
        if(memo[n][previdx]!=null){
            return memo[n][previdx];
        }
        if(n==0){
            return 1;
        }
        int res=0;
        for(int i =0;i<states.length;i++){
            if(i==previdx){continue;}
            boolean conflict=false;
            String prev= states[previdx];
            String current= states[i];
            for(int c =0;c<3;c++){
                if(prev.charAt(c) == current.charAt(c)){
                    conflict=true;
                }
            }
            if(!conflict){
                res= (res+ helper(n-1,i,memo))%MOD;
            }
        }
        memo[n][previdx]= res;
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int n1 = 1;
        int output1 = 12;

        //Example 2:

        int n2 = 5000;
        int output2 = 30228214;

        int ans1 = numOfWays(n1);
        int ans2 = numOfWays(n2);


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
