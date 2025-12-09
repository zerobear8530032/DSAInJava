//3765. Complete Prime Number
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer num.
//
//A number num is called a Complete Prime Number if every prefix and every suffix of num is prime.
//
//Return true if num is a Complete Prime Number, otherwise return false.
//
//Note:
//
//A prefix of a number is formed by the first k digits of the number.
//A suffix of a number is formed by the last k digits of the number.
//Single-digit numbers are considered Complete Prime Numbers only if they are prime.
//
//
//Example 1:
//
//Input: num = 23
//
//Output: true
//
//Explanation:
//
//​​​​​​​Prefixes of num = 23 are 2 and 23, both are prime.
//Suffixes of num = 23 are 3 and 23, both are prime.
//All prefixes and suffixes are prime, so 23 is a Complete Prime Number and the answer is true.
//Example 2:
//
//Input: num = 39
//
//Output: false
//
//Explanation:
//
//Prefixes of num = 39 are 3 and 39. 3 is prime, but 39 is not prime.
//Suffixes of num = 39 are 9 and 39. Both 9 and 39 are not prime.
//At least one prefix or suffix is not prime, so 39 is not a Complete Prime Number and the answer is false.
//Example 3:
//
//Input: num = 7
//
//Output: true
//
//Explanation:
//
//7 is prime, so all its prefixes and suffixes are prime and the answer is true.
//
//
//Constraints:
//
//1 <= num <= 109
package Maths;

public class CompletePrimeNumber_3765 {
    //    we can find prfix nd suffix of number
//    and find its prime or not
//    time complexity : O(n * log n )
//    space complexity : O(1)// string creating will take the data

    public static boolean completePrime(int num) {
        String number = Integer.toString(num);
        for(int i =0;i<number.length();i++){
            String prefix= number.substring(0,i+1);
            // System.out.println(prefix);
            int n= Integer.parseInt(prefix);
            if(!isPrime(n)){
                return false;
            }
        }
        // System.out.println("suffix");
        for(int i =number.length();i>0;i--){
            String suffix= number.substring(i-1);
            // System.out.println(suffix);
            int n= Integer.parseInt(suffix);
            if(!isPrime(n)){
                return false;
            }
        }
        return true;
    }
    public static boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        if(n==2){
            return true;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        //Example 1:

        int n1 = 23;
        boolean output1=true;

        //Example 2:

        int n2 = 39;
        boolean output2=false;

        //Example 3:

        int n3 = 7;
        boolean output3=true;

        boolean ans1= completePrime(n1);
        boolean ans2= completePrime(n2);
        boolean ans3= completePrime(n3);


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
