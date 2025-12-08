//1925. Count Square Sum Triples
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.
//
//Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.
//
//
//
//Example 1:
//
//Input: n = 5
//Output: 2
//Explanation: The square triples are (3,4,5) and (4,3,5).
//Example 2:
//
//Input: n = 10
//Output: 4
//Explanation: The square triples are (3,4,5), (4,3,5), (6,8,10), and (8,6,10).
//
//
//Constraints:
//
//1 <= n <= 250
package Arrays;

public class CountSquareSumTriples_1925 {
    public static int countTriples(int n) {
        int res=0;
        for(int a =1;a<=n-2;a++){
            for(int b=a+1;b<=n-1;b++){
                for(int c=b+1;c<=n;c++){
                    if((a*a)+( b*b) ==(c*c)){
                        res+=2;
                    }
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {

        //Example 1:

        int n1 = 5;
        int output1=2;

        //Example 2:

        int n2 = 10;
        int output2=4;

        int ans1 = countTriples(n1);
        int ans2 = countTriples(n2);

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
