//Baseball Game
//Easy
//Topics
//Company Tags
//You are keeping the scores for a baseball game with strange rules. At the beginning of the game, you start with an empty record.
//
//Given a list of strings operations, where operations[i] is the ith operation you must apply to the record and is one of the following:
//
//An integer x: Record a new score of x.
//'+': Record a new score that is the sum of the previous two scores.
//'D': Record a new score that is the double of the previous score.
//'C': Invalidate the previous score, removing it from the record.
//Return the sum of all the scores on the record after applying all the operations.
//
//Note: The test cases are generated such that the answer and all intermediate calculations fit in a 32-bit integer and that all operations are valid.
//
//Example 1:
//
//Input: ops = ["1","2","+","C","5","D"]
//
//Output: 18
//Explanation:
//
//"1" - Add 1 to the record, record = [1].
//"2" - Add 2 to the record, record = [1, 2].
//"+" - Add 1 + 2 = 3 to the record, record = [1, 2, 3].
//"C" - Invalidate and remove the previous score, record = [1, 2].
//"5" - Add 5 to the record, record = [1, 2, 5].
//"D" - Add 2 * 5 = 10 to the record, record = [1, 2, 5, 10].
//The total sum is 1 + 2 + 5 + 10 = 18.
//Example 2:
//
//Input: ops = ["5","D","+","C"]
//
//Output: 15
//Explanation:
//
//"5" - Add 5 to the record, record = [5].
//"D" - Add 2 * 5 = 10 to the record, record = [5, 10].
//"+" - Add 5 + 10 = 15 to the record, record = [5, 10, 15].
//"C" - Invalidate and remove the previous score, record = [5, 10].
//The total sum is 5 + 10 = 15.
//Constraints:
//
//1 <= operations.length <= 1000
//operations[i] is "C", "D", +, or a string representing an integer in the range [(-30,000), (30,000)].
//For operation "+", there will always be at least two previous scores on the record.
//For operations "C" and "D", there will always be at least one previous score on the record.
package Stacks;

import java.util.Stack;

class BaseballGame_NEETCODE {
//    approch: simiultae process using stak;
//    time complexity : O(n)
//    space complexity : O(n)
    public static int calPoints(String[] operations) {
        Stack<Integer> stk = new Stack<>();
        for(String op:operations){
            if(op.equals("C")){
                stk.pop();
            }else if(op.equals("D")){
                stk.push(stk.peek()*2);
            }else if(op.equals("+")){
                int x1= stk.pop();
                int x2 = stk.pop();
                stk.push(x2);
                stk.push(x1);
                stk.push(x1+x2);
            }else{
                stk.push(Integer.parseInt(op));
            }
        }
        int sum =0;
        while(!stk.isEmpty()){
            sum+=stk.pop();
        }
        return sum;
    }

    public static void main(String[] args) {
        //Example 1:

        String [] ops1 = {"1","2","+","C","5","D"};
        int output1= 18;

        //Example 2:

        String [] ops2 = {"5","D","+","C"};
        int output2= 15;

        int ans1= calPoints(ops1);
        int ans2= calPoints(ops2);

        if (output1 == ans1) {
            System.out.println("Case 1 Passed");
        } else {
            System.out.println("Case 1 Failed");
            System.out.println("Actual Output :" + output1);
            System.out.println("Your Output :" + ans1);
        }

        if (output2 == ans2) {
            System.out.println("Case 2 Passed");
        } else {
            System.out.println("Case 2 Failed");
            System.out.println("Actual Output :" + output2);
            System.out.println("Your Output :" + ans2);
        }


    }
}