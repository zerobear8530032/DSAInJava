//3577. Count the Number of Computer Unlocking Permutations
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an array complexity of length n.
//
//There are n locked computers in a room with labels from 0 to n - 1, each with its own unique password. The password of the computer i has a complexity complexity[i].
//
//The password for the computer labeled 0 is already decrypted and serves as the root. All other computers must be unlocked using it or another previously unlocked computer, following this information:
//
//You can decrypt the password for the computer i using the password for computer j, where j is any integer less than i with a lower complexity. (i.e. j < i and complexity[j] < complexity[i])
//To decrypt the password for computer i, you must have already unlocked a computer j such that j < i and complexity[j] < complexity[i].
//Find the number of permutations of [0, 1, 2, ..., (n - 1)] that represent a valid order in which the computers can be unlocked, starting from computer 0 as the only initially unlocked one.
//
//Since the answer may be large, return it modulo 109 + 7.
//
//Note that the password for the computer with label 0 is decrypted, and not the computer with the first position in the permutation.
//
//
//
//Example 1:
//
//Input: complexity = [1,2,3]
//
//Output: 2
//
//Explanation:
//
//The valid permutations are:
//
//[0, 1, 2]
//Unlock computer 0 first with root password.
//Unlock computer 1 with password of computer 0 since complexity[0] < complexity[1].
//Unlock computer 2 with password of computer 1 since complexity[1] < complexity[2].
//[0, 2, 1]
//Unlock computer 0 first with root password.
//Unlock computer 2 with password of computer 0 since complexity[0] < complexity[2].
//Unlock computer 1 with password of computer 0 since complexity[0] < complexity[1].
//Example 2:
//
//Input: complexity = [3,3,3,4,4,4]
//
//Output: 0
//
//Explanation:
//
//There are no possible permutations which can unlock all computers.
//
//
//
//Constraints:
//
//2 <= complexity.length <= 105
//1 <= complexity[i] <= 109
package Maths;

public class CountTheNumberOfComputerUnlockingPermutations_3577 {
// approch :
// we can find when we able to unlock all computer if that possible then answer is factorial of complexity.length-1
//    other wise we can return 0
//    now the only case we cannot open all computer is when there are multiple min or
//    the  first computer which is alwaysinitally open is not the min
//    time complexity : O(n)
//    space complexity : O(1)
    public static int countPermutations(int[] complexity) {
        int MOD = 1000000007;
        int min = Integer.MAX_VALUE;
        int res = 0;
        int countMin = 0;
        for (int x : complexity) {
            if (min > x) {
                min = x;
                countMin = 1;
            } else if (min == x) {
                countMin++;
            }
        }
        if (countMin > 1 || min != complexity[0]) {
            return 0;
        }
        long product = 1;
        for (int i = 2; i <= complexity.length - 1; i++) {
            product = (product * i) % MOD;
        }
        return (int) product;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] complexity1 = {1,2,3};
        int output1= 2;

        //Example 2:

        int [] complexity2 = {3,3,3,4,4,4};
        int output2= 0;

        int ans1 = countPermutations(complexity1);
        int ans2 = countPermutations(complexity2);
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
