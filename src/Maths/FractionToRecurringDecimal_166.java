//166. Fraction to Recurring Decimal
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
//
//If the fractional part is repeating, enclose the repeating part in parentheses.
//
//If multiple answers are possible, return any of them.
//
//It is guaranteed that the length of the answer string is less than 104 for all the given inputs.
//
//
//
//Example 1:
//
//Input: numerator = 1, denominator = 2
//Output: "0.5"
//Example 2:
//
//Input: numerator = 2, denominator = 1
//Output: "2"
//Example 3:
//
//Input: numerator = 4, denominator = 333
//Output: "0.(012)"
//
//
//Constraints:
//
//-231 <= numerator, denominator <= 231 - 1
//denominator != 0
package Maths;

import java.util.HashMap;

public class FractionToRecurringDecimal_166 {
     public static String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) return "0";

            StringBuilder res = new StringBuilder();

            // handle sign
            boolean positive = ((long) numerator * (long) denominator >= 0);

            long n = Math.abs((long) numerator);
            long d = Math.abs((long) denominator);

            // integer part
            res.append(n / d);
            long rem = n % d;
            if (rem == 0) {
                return positive ? res.toString() : "-" + res.toString();
            }

            res.append("."); // start fractional part
            HashMap<Long, Integer> map = new HashMap<>();
            while (rem != 0) {
                if (map.containsKey(rem)) {
                    int start = map.get(rem);
                    res.insert(start, "(");
                    res.append(")");
                    break;
                }

                map.put(rem, res.length());
                rem *= 10;
                res.append(rem / d);
                rem %= d;
            }

            return positive ? res.toString() : "-" + res.toString();
        }
    public static void main(String[] args) {
        //Example 1:

        int numerator1 = 1, denominator1 = 2;
        String output1="0.5";

        //Example 2:

        int numerator2 = 2, denominator2 = 1;
        String output2="2";

        //Example 3:

        int numerator3 = 4, denominator3 = 333;
        String output3="0.(012)";

        //Example 4:

        int numerator4 = 1, denominator4 = 6;
        String output4="0.1(6)";

        String ans1= fractionToDecimal(numerator1,denominator1);
        String ans2= fractionToDecimal(numerator2,denominator2);
        String ans3= fractionToDecimal(numerator3,denominator3);
        String ans4= fractionToDecimal(numerator4,denominator4);

        if(output1.equals(ans1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :"+output1 );
            System.out.println("Your Output :"+ans1);
        }
        if(output2.equals(ans2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }
        if(output3.equals(ans3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Actual Output :" + output3);
            System.out.println("Your Output :" + ans3);
        }
        if(output4.equals(ans4)) {
            System.out.println("Case 4 Passed");
        }else {
            System.out.println("Case 4 Failed");
            System.out.println("Actual Output :" + output4);
            System.out.println("Your Output :" + ans4);
        }

    }
}
