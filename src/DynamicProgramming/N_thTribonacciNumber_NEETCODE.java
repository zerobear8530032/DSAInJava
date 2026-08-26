//N-th Tribonacci Number
//Easy
//Topics
//Company Tags
//The Tribonacci sequence Tn is defined as follows:
//
//T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//
//Given n, return the value of Tn.
//
//Example 1:
//
//Input: n = 3
//
//Output: 2
//Explanation:
//T_3 = 0 + 1 + 1 = 2
//
//Example 2:
//
//Input: n = 21
//
//Output: 121415
//Constraints:
//
//0 <= n <= 37
//The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
package DynamicProgramming;

public class N_thTribonacciNumber_NEETCODE {
    public static int tribonacci(int n) {
        if(n<=0){return 0;}
        if(n==1 || n==2){return 1;}
        int n1=0;
        int n2=1;
        int n3=1;
        int n4=n1+n2+n3;
        for(int i =3;i<n;i++){
            n1=n2;
            n2=n3;
            n3=n4;
            n4= n1+n2+n3;
        }
        return n4;

    }
    public static void main(String[] args) {
        //Example 1:

        int  n1 = 3;
        int output1=2;

        //Example 2:

        int  n2 = 21;
        int output2=121415;

        int ans1= tribonacci(n1);
        int ans2= tribonacci(n2);
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

    }
}
