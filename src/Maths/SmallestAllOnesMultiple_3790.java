//3790. Smallest All-Ones Multiple
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given a positive integer k.
//
//Find the smallest integer n divisible by k that consists of only the digit 1 in its decimal representation (e.g., 1, 11, 111, ...).
//
//Return an integer denoting the number of digits in the decimal representation of n. If no such n exists, return -1.
//
//
//
//Example 1:
//
//Input: k = 3
//
//Output: 3
//
//Explanation:
//
//n = 111 because 111 is divisible by 3, but 1 and 11 are not. The length of n = 111 is 3.
//
//Example 2:
//
//Input: k = 7
//
//Output: 6
//
//Explanation:
//
//n = 111111. The length of n = 111111 is 6.
//
//Example 3:
//
//Input: k = 2
//
//Output: -1
//
//Explanation:
//
//There does not exist a valid n that is a multiple of 2.
//
//
//
//Constraints:
//
//2 <= k <= 105
package Maths;

public class SmallestAllOnesMultiple_3790 {
//    approch :
//    here instead of creating element as entire number we can build as remaining
//    each time we increase 1 we will mod the entire number by k
//    then make it in range of 0 to k-1
//    this allow us to find the res
//    if a number is not divisible by k it will start repeating the remainders or
//    it will go upto k remainders because range is from 0 to k-1
//    we can return the count when the remainder is 0 cause that means the number is completely divisble by k
//    time complexity : O(k)
//    space complexity : O(1)
    public static int minAllOneMultiple(int k) {
        int rem=0;
        for(int i =0;i<=k;i++){
            rem = (rem*10+1)%k;
            if(rem%k==0){
                return i+1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //Example 1:

        int k1 = 3;
        int output1=3;

        //Example 2:

        int k2 = 7;
        int output2=6;

        //Example 3:

        int k3 = 2;
        int output3=-1;

        int ans1 = minAllOneMultiple(k1);
        int ans2 = minAllOneMultiple(k2);
        int ans3 = minAllOneMultiple(k3);
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
        if(output3==(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :" + output3);
            System.out.println("Your Output :" + ans3);
        }
    }
}
