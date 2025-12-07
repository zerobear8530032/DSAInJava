//3770. Largest Prime from Consecutive Prime Sum
//Solved
//Medium
//premium lock icon
//Companies
//Hint
//You are given an integer n.
//
//Return the largest prime number less than or equal to n that can be expressed as the sum of one or more consecutive prime numbers starting from 2. If no such number exists, return 0.
//
//
//
//Example 1:
//
//Input: n = 20
//
//Output: 17
//
//Explanation:
//
//The prime numbers less than or equal to n = 20 which are consecutive prime sums are:
//
//2 = 2
//
//5 = 2 + 3
//
//17 = 2 + 3 + 5 + 7
//
//The largest is 17, so it is the answer.
//
//Example 2:
//
//Input: n = 2
//
//Output: 2
//
//Explanation:
//
//The only consecutive prime sum less than or equal to 2 is 2 itself.
//
//
//
//Constraints:
//
//1 <= n <= 5 * 105

package Maths;

public class LargestPrimeFromConsecutivePrimeSum_3770 {
    public static int largestPrime(int n) {
        int res=0;
        boolean [] primes= new boolean [n+1];
        for(int i =2;i*i<=primes.length;i++){
            if(!primes[i]){
                for(int j=i*i ;j<primes.length;j+=i){
                    primes[j]=true;
                }
            }
        }
        int sum =0;
        for(int i=2;i<primes.length;i++){
            if(!primes[i]){
                sum+=i;
            }
            if(sum>=primes.length){
                break;
            }
            if(!primes[sum]){
                res=Math.max(res,sum);
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int n1 = 20;
        int output1= 17;

        //Example 2:

        int n2 = 2;
        int output2=2;

        int ans1= largestPrime(n1);
        int ans2= largestPrime(n2);

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
