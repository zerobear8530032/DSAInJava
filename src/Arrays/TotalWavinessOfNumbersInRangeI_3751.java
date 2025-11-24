//3751. Total Waviness of Numbers in Range I
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given two integers num1 and num2 representing an inclusive range [num1, num2].
//
//The waviness of a number is defined as the total count of its peaks and valleys:
//
//A digit is a peak if it is strictly greater than both of its immediate neighbors.
//A digit is a valley if it is strictly less than both of its immediate neighbors.
//The first and last digits of a number cannot be peaks or valleys.
//Any number with fewer than 3 digits has a waviness of 0.
//Return the total sum of waviness for all numbers in the range [num1, num2].
//
//
//Example 1:
//
//Input: num1 = 120, num2 = 130
//
//Output: 3
//
//Explanation:
//
//In the range [120, 130]:
//120: middle digit 2 is a peak, waviness = 1.
//121: middle digit 2 is a peak, waviness = 1.
//130: middle digit 3 is a peak, waviness = 1.
//All other numbers in the range have a waviness of 0.
//Thus, total waviness is 1 + 1 + 1 = 3.
//
//Example 2:
//
//Input: num1 = 198, num2 = 202
//
//Output: 3
//
//Explanation:
//
//In the range [198, 202]:
//198: middle digit 9 is a peak, waviness = 1.
//201: middle digit 0 is a valley, waviness = 1.
//202: middle digit 0 is a valley, waviness = 1.
//All other numbers in the range have a waviness of 0.
//Thus, total waviness is 1 + 1 + 1 = 3.
//
//Example 3:
//
//Input: num1 = 4848, num2 = 4848
//
//Output: 2
//
//Explanation:
//
//Number 4848: the second digit 8 is a peak, and the third digit 4 is a valley, giving a waviness of 2.
//
//
//
//Constraints:
//
//1 <= num1 <= num2 <= 105
package Arrays;

public class TotalWavinessOfNumbersInRangeI_3751 {
//solve with brute force approch :
//    time comeplexity : O(num2-num1* digits)
//    space comeplexity : O(1)
    public static int totalWaviness(int num1, int num2) {
        int count=0;
        for(int i =num1;i<=num2;i++){
            count+= waviness(i);
        }
        return count;
    }
    public static int waviness(int num){
        int prev= num%10;
        int count=0;
        num=num/10;
        while(num>9){
            int curr= num%10;
            int next= num%100/10;
            // System.out.println(next+"  "+curr+"  "+prev);
            if(prev<curr && curr>next){
                // System.out.println("peak");
                count++;
            }else if(prev>curr && curr<next){
                // System.out.println("vally");
                count++;
            }
            prev=curr;
            num=num/10;
        }
        return count;
    }
    public static void main(String[] args) {
        //Example 1:

        int num11 = 120, num12 = 130;
        int output1= 3;

        //Example 2:

        int num21 = 192, num22 = 202;
        int output2= 3;

        //Example 3:

        int num31 = 4848, num32 = 4848;
        int output3= 2;

        int ans1= totalWaviness(num11,num12);
        int ans2= totalWaviness(num21,num22);
        int ans3= totalWaviness(num31,num32);

        if(output1== ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2== ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(output3== ans3) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }

    }
}
