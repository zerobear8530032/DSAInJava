//3370. Smallest Number With All Set Bits
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given a positive number n.
//
//Return the smallest number x greater than or equal to n, such that the binary representation of x contains only set bits
//
//
//
//Example 1:
//
//Input: n = 5
//
//Output: 7
//
//Explanation:
//
//The binary representation of 7 is "111".
//
//Example 2:
//
//Input: n = 10
//
//Output: 15
//
//Explanation:
//
//The binary representation of 15 is "1111".
//
//Example 3:
//
//Input: n = 3
//
//Output: 3
//
//Explanation:
//
//The binary representation of 3 is "11".
//
//
//
//Constraints:
//
//1 <= n <= 1000
package BitWise;

public class SmallestNumberWithAllSetBits_3370 {
    public static int smallestNumber(int n) {
        for(int i =0;i<31;i++){
            int res= 1<<i;
            if(res>n){
                return res-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        //Example 1:

        int n1 = 5;
        int output1= 7;

        //Example 2:

        int n2 = 10;
        int output2= 15;

        //Example 3:

        int n3 = 3;
        int output3= 3;

        int ans1 = smallestNumber(n1);
        int ans2 = smallestNumber(n2);
        int ans3 = smallestNumber(n3);


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
            System.out.println("Actual Output :"+output3 );
            System.out.println("Your Output :"+ans3);
        }

    }
}
