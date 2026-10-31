//7. Reverse Integer
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Given a signed 32-bit integer x, return x with its digits reversed. If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
//
//Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
//
//
//
//Example 1:
//
//Input: x = 123
//Output: 321
//Example 2:
//
//Input: x = -123
//Output: -321
//Example 3:
//
//Input: x = 120
//Output: 21
//
//
//Constraints:
//
//-231 <= x <= 231 - 1
package BitWise;

public class ReverseInteger_7 {
    public static int reverse(int x) {

        String MAX = Integer.toString(Integer.MAX_VALUE);
        String MIN = Integer.toString(Integer.MIN_VALUE);
        int num =x;
        int count = digitCount(x);
        if (count < MAX.length()) {
            return reverseNumber(x);
        } else {
            if (x < 0) {
                int res = 0;
                int idx = 0;
                while(x!=0){
                    int rem = x%10;
                    if(Math.abs(rem)==MAX.charAt(idx)-'0'){
                        res=res*10+rem;
                        x=x/10;
                    }else if(Math.abs(rem)<MAX.charAt(idx)-'0'){
                        return reverseNumber(num);
                    }else{
                        return 0;
                    }
                    idx++;
                }
                return res;
            } else {
                int res = 0;
                int idx = 0;


                while (x != 0) {
                    int rem = x % 10;
                    if (Math.abs(rem) == MAX.charAt(idx) - '0') {
                        res = res * 10 + rem;
                        x=x/10;
                    }else if(Math.abs(rem)<MAX.charAt(idx)-'0'){
                        return reverseNumber(num);
                    } else {
                        System.out.println(idx);
                        return 0;
                    }
                    idx++;
                }
                return res;
            }
        }

    }

    public static int digitCount(int x) {
        int count = 0;
        while (x != 0) {
            x = x / 10;
            count++;
        }
        return count;
    }

    public static int reverseNumber(int x) {
        int res = 0;
        while (x != 0) {
            res = res * 10 + (x % 10);
            x /= 10;
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int x1 = 123;
        int output1= 321;


        //Example 2:

        int x2 = -123;
        int output2 = -321;

        //Example 3:

        int x3 = 120;
        int output3= 21;

        int ans1= reverse(x1);
        int ans2= reverse(x2);
        int ans3= reverse(x3);


        if(ans1==output1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2==output2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3==output3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
