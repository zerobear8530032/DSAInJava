
//3516. Find Closest Person
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given three integers x, y, and z, representing the positions of three people on a number line:
//
//x is the position of Person 1.
//y is the position of Person 2.
//z is the position of Person 3, who does not move.
//Both Person 1 and Person 2 move toward Person 3 at the same speed.
//
//Determine which person reaches Person 3 first:
//
//Return 1 if Person 1 arrives first.
//Return 2 if Person 2 arrives first.
//Return 0 if both arrive at the same time.
//Return the result accordingly.
//
//
//
//Example 1:
//
//Input: x = 2, y = 7, z = 4
//
//Output: 1
//
//Explanation:
//
//Person 1 is at position 2 and can reach Person 3 (at position 4) in 2 steps.
//Person 2 is at position 7 and can reach Person 3 in 3 steps.
//Since Person 1 reaches Person 3 first, the output is 1.
//
//Example 2:
//
//Input: x = 2, y = 5, z = 6
//
//Output: 2
//
//Explanation:
//
//Person 1 is at position 2 and can reach Person 3 (at position 6) in 4 steps.
//Person 2 is at position 5 and can reach Person 3 in 1 step.
//Since Person 2 reaches Person 3 first, the output is 2.
//
//Example 3:
//
//Input: x = 1, y = 5, z = 3
//
//Output: 0
//
//Explanation:
//
//Person 1 is at position 1 and can reach Person 3 (at position 3) in 2 steps.
//Person 2 is at position 5 and can reach Person 3 in 2 steps.
//Since both Person 1 and Person 2 reach Person 3 at the same time, the output is 0.
//
//
//
//Constraints:
//
//1 <= x, y, z <= 100

package Maths;

public class FindClosestPerson_3516 {
//    approch : find distance btw points from x to z and y to z
//    return the one which  is smaller other wise return 0
    public static int findClosest(int x, int y, int z) {
        int distancep1= Math.abs(x-z);
        int distancep2= Math.abs(y-z);
        if(distancep1<distancep2){
            return 1;
        }else if(distancep2<distancep1){
            return 2;
        }else{
            return 0;
        }
    }
    public static void main(String[] args) {
        //Example 1:

        int x1 = 2, y1 = 7, z1 = 4;
        int output1=1;
        //Example 2:

        int x2 = 2, y2 = 5, z2 = 6;
        int output2=2;
        //Example 3:

        int x3 = 1, y3 = 5, z3 = 3;
        int output3=0;

        int ans1= findClosest(x1,y1,z1);
        int ans2= findClosest(x2,y2,y2);
        int ans3= findClosest(x3,y3,z3);

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
        if(output3==ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

    }
}
