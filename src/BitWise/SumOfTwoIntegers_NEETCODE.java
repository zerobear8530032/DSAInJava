//Sum of Two Integers
//Solved
//Given two integers a and b, return the sum of the two integers without using the + and - operators.
//
//Example 1:
//
//Input: a = 1, b = 1
//
//Output: 2
//Example 2:
//
//Input: a = 4, b = 7
//
//Output: 11
//Constraints:
//
//-1000 <= a, b <= 1000
package BitWise;

public class SumOfTwoIntegers_NEETCODE {
//    approch:
//    it similar to addition of 2 number just on bits
//    to add number we need to apply xor operations on bits
//    and to take carry we use and opertions
//    to find next carry we cn use (abit & bbit) | (carry & (abit ^ bbit));
//    time complexity : O(1) // 32 bits max in every integer
//    space complexity : O(1)
        public static int getSum(int a, int b) {
            int res = 0;
            int carry = 0;

            for (int i = 0; i < 32; i++) {

                int abit = (a >> i) & 1;
                int bbit = (b >> i) & 1;

                int sum = abit ^ bbit ^ carry;

                carry = (abit & bbit) | (carry & (abit ^ bbit));

                res |= (sum << i);
            }

            return res;
        }
    public static void main(String[] args) {
        //Example 1:

        int  a1 = 1, b1 = 1;
        int output1=2;

        //Example 2:

        int  a2 = 4, b2 = 7;
        int output2=11;

        int ans1 = getSum(a1,b1);
        int ans2 = getSum(a2,b2);

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

    }
}
