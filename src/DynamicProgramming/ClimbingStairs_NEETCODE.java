//Climbing Stairs
//Solved
//You are given an integer n representing the number of steps to reach the top of a staircase. You can climb with either 1 or 2 steps at a time.
//
//Return the number of distinct ways to climb to the top of the staircase.
//
//Example 1:
//
//Input: n = 2
//
//Output: 2
//Explanation:
//
//1 + 1 = 2
//2 = 2
//Example 2:
//
//Input: n = 3
//
//Output: 3
//Explanation:
//
//1 + 1 + 1 = 3
//1 + 2 = 3
//2 + 1 = 3
//Constraints:
//
//1 <= n <= 30
package DynamicProgramming;

public class ClimbingStairs_NEETCODE {
//    use simple recursion memo approch:
//    time complexity : O(n^2)
//    space complexity : O(n)
    public static int climbStairs(int n) {
        int [] table = new int [n+1];
        table[0]=1;
        for(int i =0;i<table.length;i++){
            int sum = table[i];
            if(i+1<table.length){
                table[i+1]=table[i+1]+sum;
            }
            if(i+2<table.length){
                table[i+2]=table[i+2]+sum;
            }
        }
       return table[n];
    }
    public static void main(String[] args) {
        //Example 1:

        int  n1 = 2;
        int output1= 2;

        //Example 2:

        int  n2 = 3;
        int output2= 3;

        int ans1= climbStairs(n1);
        int ans2= climbStairs(n2);

        if(output1== ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2== ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }


    }
}
