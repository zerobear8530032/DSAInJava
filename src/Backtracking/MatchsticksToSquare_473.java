//473. Matchsticks to Square
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array matchsticks where matchsticks[i] is the length of the ith matchstick. You want to use all the matchsticks to make one square. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.
//
//Return true if you can make this square and false otherwise.
//
//
//
//Example 1:
//
//
//Input: matchsticks = [1,1,2,2,2]
//Output: true
//Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
//Example 2:
//
//Input: matchsticks = [3,3,3,3,4]
//Output: false
//Explanation: You cannot find a way to form a square with all the matchsticks.
//
//
//Constraints:
//
//1 <= matchsticks.length <= 15
//1 <= matchsticks[i] <= 108
package Backtracking;

public class MatchsticksToSquare_473 {
//    approch:
//    if the sum %4 !=0 then we can return false
//    we can find length of each side by sum of all matchsticks /4
//    we can create a 4 index array and try to put match stick their if we can equalize the array
//
    public static boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for (int x : matchsticks) {
            sum += x;
        }
        if (sum % 4 != 0) {
            return false;
        }
        int side = sum / 4;
        int[] boundaries = new int[4];
        return helper(0, boundaries, side, matchsticks);
    }

    public static boolean helper(int idx, int[] sides, int target, int[] matchsticks) {
        if (idx == matchsticks.length) {
            if (valid(sides, target)) {
                return true;
            }
            return false;
        }

        for (int i = 0; i < 4; i++) {
            if (sides[i] + matchsticks[idx] <= target) {
                sides[i] += matchsticks[idx];
                boolean take = helper(idx + 1, sides, target, matchsticks);
                sides[i] -= matchsticks[idx];
                if (take) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean valid(int[] boundaries, int side) {
        for (int x : boundaries) {
            if (x != side) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //Example 1:

        int [] matchsticks1 = {1,1,2,2,2};
        boolean output1= true;

        //Example 2:

        int [] matchsticks2 = {3,3,3,3,4};
        boolean output2= false;

        boolean ans1= makesquare(matchsticks1);
        boolean ans2= makesquare(matchsticks2);


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
