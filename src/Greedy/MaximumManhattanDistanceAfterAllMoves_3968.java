//3968. Maximum Manhattan Distance After All Moves
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given a string moves consisting of the characters 'U', 'D', 'L', 'R', and '_'.
//
//Starting from the origin (0, 0), each character represents one move on a 2D plane:
//
//'U': Move up by 1 unit.
//'D': Move down by 1 unit.
//'L': Move left by 1 unit.
//'R': Move right by 1 unit.
//'_': Can be independently replaced with any one of 'U', 'D', 'L', or 'R'.
//Return the maximum Manhattan distance from the origin that can be achieved after all moves have been performed.
//
//
//
//Example 1:
//
//Input: moves = "L_D_"
//
//Output: 4
//
//Explanation:
//
//One optimal choice is:
//
//'L': (0, 0) -> (-1, 0)
//'_' treated as 'D': (-1, 0) -> (-1, -1)
//'D': (-1, -1) -> (-1, -2)
//'_' treated as 'L': (-1, -2) -> (-2, -2)
//The final Manhattan distance from the origin is |0 - (-2)| + |0 - (-2)| = 4.
//
//Example 2:
//
//Input: moves = "U_R"
//
//Output: 3
//
//Explanation:
//
//One optimal choice is:
//
//'U': (0, 0) -> (0, 1)
//'_' treated as 'U': (0, 1) -> (0, 2)
//'R': (0, 2) -> (1, 2)
//The final Manhattan distance from the origin is |0 - 1| + |0 - 2| = 3.
//
//
//
//Constraints:
//
//1 <= moves.length <= 105
//moves consists of only 'U', 'D', 'L', 'R', and '_'.
package Greedy;

public class MaximumManhattanDistanceAfterAllMoves_3968 {
//    approch : we can simulate the direction we have go in the _ can be replaces with
//    the direction which we move the most like if we move left most we can move more towards left
//    to increase the manhatten distance;
//    time complexity : O(n)
//    space complexity : O(1)
    public static int maxDistance(String moves) {
        int l =0;
        int r =0;
        int u =0;
        int d =0;
        int x=0;
        int y=0;
        int n = moves.length();
        int uCount=0;
        for(int i =0;i<n;i++){
            char ch = moves.charAt(i);
            if(ch=='U'){
                u++;
                y++;
            }else if(ch=='D'){
                d++;
                y--;
            }else if(ch=='R'){
                x++;
                r++;
            }else if(ch=='L'){
                x--;
                l++;
            }else{
                uCount++;
            }

        }
        if(u>= l && u>=r && u>=d){
            y+=uCount;
        }else if(r>= l && r>=u && r>=d){
            x+=uCount;
        }else if(d>= l && d>=r && d>=u){
            y-=uCount;
        }else if (l>=u && l>=d && l>=r){
            x-=uCount;
        }
        return Math.abs(x)+Math.abs(y);
    }
    public static void main(String[] args) {
        //Example 1:

        String moves1 = "L_D_";
        int output1= 4;

        //Example 2:

        String moves2 = "U_R";
        int output2=3;

        int ans1= maxDistance(moves1);
        int ans2= maxDistance(moves2);

        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }
    }
}
