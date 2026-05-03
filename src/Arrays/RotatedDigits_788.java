//788. Rotated Digits
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//An integer x is a good if after rotating each digit individually by 180 degrees, we get a valid number that is different from x. Each digit must be rotated - we cannot choose to leave it alone.
//
//A number is valid if each digit remains a digit after rotation. For example:
//
//0, 1, and 8 rotate to themselves,
//2 and 5 rotate to each other,
//6 and 9 rotate to each other, and
//the rest of the numbers do not rotate to any other number and become invalid.
//
//Given an integer n, return the number of good integers in the range [1, n].
//
//Example 1:
//
//Input: n = 10
//Output: 4
//Explanation: There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
//
//Example 2:
//
//Input: n = 1
//Output: 0
//
//Example 3:
//
//Input: n = 2
//Output: 1
//
//Constraints:
//
//1 <= n <= 10^4

package Arrays;

public class RotatedDigits_788 {

    public static int rotatedDigits(int n) {
        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (isGoodInteger(i)) {
                res++;
            }
        }
        return res;
    }

    public static boolean isGoodInteger(int n) {
        int x = n;
        boolean res = false;
        while (x != 0) {
            int rem = x % 10;
            int rotate = rotate(rem);
            if (rotate == -1) {
                return false;
            }
            if (rotate != rem) {
                res = true;
            }
            x /= 10;
        }
        return res;
    }

    public static int rotate(int x) {
        if (x == 0 || x == 1 || x == 8) {
            return x;
        }
        if (x == 2) {
            return 5;
        }
        if (x == 5) {
            return 2;
        }
        if (x == 6) {
            return 9;
        }
        if (x == 9) {
            return 6;
        }
        return -1;
    }

    public static void main(String[] args) {

        // Example 1:
        int n1 = 10;
        int output1 = 4;

        // Example 2:
        int n2 = 1;
        int output2 = 0;

        // Example 3:
        int n3 = 2;
        int output3 = 1;

        int ans1 = rotatedDigits(n1);
        int ans2 = rotatedDigits(n2);
        int ans3 = rotatedDigits(n3);

        if (output1 == ans1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :" + output1);
            System.out.println("Your Output :" + ans1);
        }

        if (output2 == ans2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }

        if (output3 == ans3) {
            System.out.println("Case 3 Passed");
        } else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :" + output3);
            System.out.println("Your Output :" + ans3);
        }
    }
}