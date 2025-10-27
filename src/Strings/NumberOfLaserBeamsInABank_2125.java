//2125. Number of Laser Beams in a Bank
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Anti-theft security devices are activated inside a bank. You are given a 0-indexed binary string array bank representing the floor plan of the bank, which is an m x n 2D matrix. bank[i] represents the ith row, consisting of '0's and '1's. '0' means the cell is empty, while'1' means the cell has a security device.
//
//There is one laser beam between any two security devices if both conditions are met:
//
//The two devices are located on two different rows: r1 and r2, where r1 < r2.
//For each row i where r1 < i < r2, there are no security devices in the ith row.
//Laser beams are independent, i.e., one beam does not interfere nor join with another.
//
//Return the total number of laser beams in the bank.
//
//
//
//Example 1:
//
//
//Input: bank = ["011001","000000","010100","001000"]
//Output: 8
//Explanation: Between each of the following device pairs, there is one beam. In total, there are 8 beams:
// * bank[0][1] -- bank[2][1]
// * bank[0][1] -- bank[2][3]
// * bank[0][2] -- bank[2][1]
// * bank[0][2] -- bank[2][3]
// * bank[0][5] -- bank[2][1]
// * bank[0][5] -- bank[2][3]
// * bank[2][1] -- bank[3][2]
// * bank[2][3] -- bank[3][2]
//Note that there is no beam between any device on the 0th row with any on the 3rd row.
//This is because the 2nd row contains security devices, which breaks the second condition.
//Example 2:
//
//
//Input: bank = ["000","111","000"]
//Output: 0
//Explanation: There does not exist two devices located on two different rows.
//
//
//Constraints:
//
//m == bank.length
//n == bank[i].length
//1 <= m, n <= 500
//bank[i][j] is either '0' or '1'.
package Strings;

public class NumberOfLaserBeamsInABank_2125 {
//    approch: simple we need to find the string which have lazers btw them
//    and if the string does not contains lazer we can skip and choose next untill we found 2 string which are having lazers
//    if we found such 2 string  we cn compute the lazers by number lazer in s1, s2 and product of s1,s2 lazers is total lazers btw them
//    after that the s2 becomes or s1 lazers and we find the next sequence of lazers ahead
//    time complexity : O(n*m)
//    space complexity : O(1)

    public static int numberOfBeams(String[] bank) {
        int prev =0;
        int res=0;
        for (int i = 0; i < bank.length; i++) {
            int curr = countLazers(bank[i]);
            if (curr > 0) {
                res += prev * curr;
                prev = curr;
            }
        }
        return res;
    }

    public static int countLazers(String s){
        int lazers=0;
        for(int i =0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                lazers++;
            }
        }
        return lazers;
    }
    public static void main(String[] args) {

        //Example 1:

        String [] bank1 = {"011001","000000","010100","001000"};
        int output1= 8;

        //Example 2:

        String [] bank2 = {"000","111","000"};
        int output2= 0;

        int ans1= numberOfBeams(bank1);
        int ans2= numberOfBeams(bank2);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :"+output2 );
            System.out.println("Your Output :"+ans2);
        }


    }
}
