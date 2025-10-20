//2011. Final Value of Variable After Performing Operations
//Solved
//Easy
//Topics
//premium lock icon
//Companies
//Hint
//There is a programming language with only four operations and one variable X:
//
//++X and X++ increments the value of the variable X by 1.
//--X and X-- decrements the value of the variable X by 1.
//Initially, the value of X is 0.
//
//Given an array of strings operations containing a list of operations, return the final value of X after performing all the operations.
//
//
//
//Example 1:
//
//Input: operations = ["--X","X++","X++"]
//Output: 1
//Explanation: The operations are performed as follows:
//Initially, X = 0.
//--X: X is decremented by 1, X =  0 - 1 = -1.
//X++: X is incremented by 1, X = -1 + 1 =  0.
//X++: X is incremented by 1, X =  0 + 1 =  1.
//Example 2:
//
//Input: operations = ["++X","++X","X++"]
//Output: 3
//Explanation: The operations are performed as follows:
//Initially, X = 0.
//++X: X is incremented by 1, X = 0 + 1 = 1.
//++X: X is incremented by 1, X = 1 + 1 = 2.
//X++: X is incremented by 1, X = 2 + 1 = 3.
//Example 3:
//
//Input: operations = ["X++","++X","--X","X--"]
//Output: 0
//Explanation: The operations are performed as follows:
//Initially, X = 0.
//X++: X is incremented by 1, X = 0 + 1 = 1.
//++X: X is incremented by 1, X = 1 + 1 = 2.
//--X: X is decremented by 1, X = 2 - 1 = 1.
//X--: X is decremented by 1, X = 1 - 1 = 0.
//
//
//Constraints:
//
//1 <= operations.length <= 100
//operations[i] will be either "++X", "X++", "--X", or "X--".
package Arrays;

public class ValueOfVariableAfterPerformingOperations_2011 {
//    approch: similate whats asked:
//    time complexity : O(n)
//    space complexity : O(1)
    public static int finalValueAfterOperations(String[] operations) {
        int x=0;
        for(String s:operations){
            if(s.charAt(0)=='+' || s.charAt(s.length()-1)=='+'){
                x++;
            }else{
                x--;
            }
        }
        return x;
    }
    public static void main(String[] args) {
        //Example 1:

        String [] operations1 = {"--X","X++","X++"};
        int output1= 1;

        //Example 2:

        String [] operations2 = {"++X","++X","X++"};
        int output2= 3;

        //Example 3:


        String [] operations3 = {"X++","++X","--X","X--"};
        int output3= 0;

        int ans1 = finalValueAfterOperations(operations1);
        int ans2 = finalValueAfterOperations(operations2);
        int ans3 = finalValueAfterOperations(operations3);

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
