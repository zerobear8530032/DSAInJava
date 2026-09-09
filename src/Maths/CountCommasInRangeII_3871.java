//3871. Count Commas in Range II
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer n.
//
//Return the total number of commas used when writing all integers from [1, n] (inclusive) in standard number formatting.
//
//In standard formatting:
//
//A comma is inserted after every three digits from the right.
//Numbers with fewer than 4 digits contain no commas.
//
//
//Example 1:
//
//Input: n = 1002
//
//Output: 3
//
//Explanation:
//
//The numbers "1,000", "1,001", and "1,002" each contain one comma, giving a total of 3.
//
//Example 2:
//
//Input: n = 998
//
//Output: 0
//
//Explanation:
//
//​​​​​​​All numbers from 1 to 998 have fewer than four digits. Therefore, no commas are used.
//
//
//
//Constraints:
//
//1 <= n <= 1015
package Maths;

public class CountCommasInRangeII_3871 {
//    approch :
//    just check in range after 1000 every 3 digits number holds one extra commans
//    so we can just use simple formula n - digits +1
//    time complexity : O(1)
//    space complexity : O(1)
    public static long countCommas(long n) {
        long res = 0;

        if (n >= 1_000)
            res += n - 1_000 + 1;

        if (n >= 1_000_000)
            res += n - 1_000_000 + 1;

        if (n >= 1_000_000_000)
            res += n - 1_000_000_000 + 1;

        if (n >= 1_000_000_000_000L)
            res += n - 1_000_000_000_000L + 1;

        if (n >= 1_000_000_000_000_000L)
            res += n - 1_000_000_000_000_000L + 1;

        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int  n1 = 1002;
        int output1=3;

        //Example 2:

        int n2= 998;
        int output2=0;

        long ans1= countCommas(n1);
        long ans2= countCommas(n2);
        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Output :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2== output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Output :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
    }
}
