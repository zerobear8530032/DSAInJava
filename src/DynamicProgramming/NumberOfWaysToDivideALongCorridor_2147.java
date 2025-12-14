//2147. Number of Ways to Divide a Long Corridor
//Attempted
//Hard
//Topics
//premium lock icon
//Companies
//Hint
//Along a long library corridor, there is a line of seats and decorative plants. You are given a 0-indexed string corridor of length n consisting of letters 'S' and 'P' where each 'S' represents a seat and each 'P' represents a plant.
//
//One room divider has already been installed to the left of index 0, and another to the right of index n - 1. Additional room dividers can be installed. For each position between indices i - 1 and i (1 <= i <= n - 1), at most one divider can be installed.
//
//Divide the corridor into non-overlapping sections, where each section has exactly two seats with any number of plants. There may be multiple ways to perform the division. Two ways are different if there is a position with a room divider installed in the first way but not in the second way.
//
//Return the number of ways to divide the corridor. Since the answer may be very large, return it modulo 109 + 7. If there is no way, return 0.
//
//
//
//Example 1:
//
//
//Input: corridor = "SSPPSPS"
//Output: 3
//Explanation: There are 3 different ways to divide the corridor.
//The black bars in the above image indicate the two room dividers already installed.
//Note that in each of the ways, each section has exactly two seats.
//Example 2:
//
//
//Input: corridor = "PPSPSP"
//Output: 1
//Explanation: There is only 1 way to divide the corridor, by not installing any additional dividers.
//Installing any would create some section that does not have exactly two seats.
//Example 3:
//
//
//Input: corridor = "S"
//Output: 0
//Explanation: There is no way to divide the corridor because there will always be a section that does not have exactly two seats.
//
//
//Constraints:
//
//n == corridor.length
//1 <= n <= 105
//corridor[i] is either 'S' or 'P'.
package DynamicProgramming;

public class NumberOfWaysToDivideALongCorridor_2147 {
//    approch :
//    we can make pairs when 2 seats are left side and some seats are on right side
//    we can make plants+1 pairs example :
//    SS \P\P\SS== here we can mke 3 pairs
//    similarly we can just find such pairs each time and product them togther is our answer
//    time complexity : O(n)
//    space complexity : O(1)
    public static int numberOfWays(String corridor) {
        int seats=0;
        long res=1;
        int MOD=1000000007;
        int n = corridor.length();
        for(int i=0;i<n;i++){
            char ch = corridor.charAt(i);
            if(ch=='S'){seats++;}
        }
        if(seats==0 || seats%2!=0){
            return 0;
        }
        int idx=0;
        while(idx<n){
            while(idx<n && corridor.charAt(idx)=='P'){
                idx++;
            }
            int countSeat=0;
            while(idx<n && countSeat<2){
                char ch = corridor.charAt(idx);
                if(ch=='S'){
                    countSeat++;
                    seats--;
                }
                idx++;
            }
            int plants=0;
            while(idx<n && corridor.charAt(idx)=='P'){
                plants++;
                idx++;
            }
            if(seats!=0){
                res= ((plants+1)*res)%MOD;
            }
        }
        return (int)res;
    }
    public static void main(String[] args) {
        //Example 1:

        String corridor1 = "SSPPSPS";
        int output1= 3;

        //Example 2:

        String corridor2 = "PPSPSP";
        int output2= 1;

        //Example 3:

        String corridor3 = "S";
        int output3= 0;

        int ans1= numberOfWays(corridor1);
        int ans2= numberOfWays(corridor2);
        int ans3= numberOfWays(corridor3);


        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3== output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
