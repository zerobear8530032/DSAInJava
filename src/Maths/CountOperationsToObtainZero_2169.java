//2169. Count Operations to Obtain Zero
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//You are given two non-negative integers num1 and num2.
//
//In one operation, if num1 >= num2, you must subtract num2 from num1, otherwise subtract num1 from num2.
//
//For example, if num1 = 5 and num2 = 4, subtract num2 from num1, thus obtaining num1 = 1 and num2 = 4. However, if num1 = 4 and num2 = 5, after one operation, num1 = 4 and num2 = 1.
//Return the number of operations required to make either num1 = 0 or num2 = 0.
//
//
//
//Example 1:
//
//Input: num1 = 2, num2 = 3
//Output: 3
//Explanation:
//- Operation 1: num1 = 2, num2 = 3. Since num1 < num2, we subtract num1 from num2 and get num1 = 2, num2 = 3 - 2 = 1.
//- Operation 2: num1 = 2, num2 = 1. Since num1 > num2, we subtract num2 from num1.
//- Operation 3: num1 = 1, num2 = 1. Since num1 == num2, we subtract num2 from num1.
//Now num1 = 0 and num2 = 1. Since num1 == 0, we do not need to perform any further operations.
//So the total number of operations required is 3.
//Example 2:
//
//Input: num1 = 10, num2 = 10
//Output: 1
//Explanation:
//- Operation 1: num1 = 10, num2 = 10. Since num1 == num2, we subtract num2 from num1 and get num1 = 10 - 10 = 0.
//Now num1 = 0 and num2 = 10. Since num1 == 0, we are done.
//So the total number of operations required is 1.
//
//
//Constraints:
//
//0 <= num1, num2 <= 105
package Maths;

public class CountOperationsToObtainZero_2169 {
//    approch :
//    approch we can simulate the process and we can just optimize the substraction using division
//    cause we can remove k number of times the smaller number so istead of repeating substraction we can
//    instead remove them all at once using division;
//    time complexity : O(log min (n1,n2)
//    space complexity : O(1)
    public static int countOperations(int num1, int num2) {
        int operation=0;
        while(num1!=0 && num2!=0){
            if(num1<num2){
                int times = num2/num1;
                num2-= (num1*times);
                operation+=times;
            }else{
                int times = num1/num2;
                num1-= (num2*times);
                operation+=times;
            }
        }
        return operation;
    }
    public static void main(String[] args) {
        //Example 1:

        int num11 = 2, num12 = 3;
        int output1= 3;

        //Example 2:

        int num21 = 10, num22 = 10;
        int output2= 1;

        int ans1= countOperations(num11,num12);
        int ans2= countOperations(num21,num22);

        if(output1==ans1) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+(output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(output2==ans2) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+(output2));
            System.out.println("Your Answer :"+ (ans2));
        }




    }
}
