//3783. Mirror Distance of an Integer
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer n.
//
//Define its mirror distance as: abs(n - reverse(n))​​​​​​​ where reverse(n) is the integer formed by reversing the digits of n.
//
//Return an integer denoting the mirror distance of n​​​​​​​.
//
//abs(x) denotes the absolute value of x.
//
//
//
//Example 1:
//
//Input: n = 25
//
//Output: 27
//
//Explanation:
//
//reverse(25) = 52.
//Thus, the answer is abs(25 - 52) = 27.
//Example 2:
//
//Input: n = 10
//
//Output: 9
//
//Explanation:
//
//reverse(10) = 01 which is 1.
//Thus, the answer is abs(10 - 1) = 9.
//Example 3:
//
//Input: n = 7
//
//Output: 0
//
//Explanation:
//
//reverse(7) = 7.
//Thus, the answer is abs(7 - 7) = 0.
//
//
//Constraints:
//
//1 <= n <= 109
package Arrays;

public class MirrorDistanceOfAnInteger_3783 {
//    time complexity :O(1)
//    space complexity :O(1)

    public static int mirrorDistance(int n) {
        return Math.abs(n-reverse(n));
    }
    public static int reverse(int n){
        int rev=0;
        while(n!=0){
            int rem = n%10;
            rev= rev*10+rem;
            n/=10;
        }
        return rev;
    }
    public static void main(String[] args) {
        //Example 1:

        int n1 = 25;
        int output1=27;

        //Example 2:

        int n2 = 10;
        int output2=9;

        //Example 3:

        int n3 = 7;
        int output3=0;

        int ans1=  mirrorDistance(n1);
        int ans2=  mirrorDistance(n2);
        int ans3=  mirrorDistance(n3);

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
            System.out.println("Actual Output :"+output3);
            System.out.println("Your Output :"+ans3);
        }

    }
}
