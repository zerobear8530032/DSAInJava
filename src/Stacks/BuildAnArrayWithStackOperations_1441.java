//1441. Build an Array With Stack Operations
//Solved
//Medium
//Topics
//premium lock icon
//Companies
//Hint
//You are given an integer array target and an integer n.
//
//You have an empty stack with the two following operations:
//
//"Push": pushes an integer to the top of the stack.
//"Pop": removes the integer on the top of the stack.
//You also have a stream of the integers in the range [1, n].
//
//Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to target. You should follow the following rules:
//
//If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
//If the stack is not empty, pop the integer at the top of the stack.
//If, at any moment, the elements in the stack (from the bottom to the top) are equal to target, do not read new integers from the stream and do not do more operations on the stack.
//Return the stack operations needed to build target following the mentioned rules. If there are multiple valid answers, return any of them.
//
//
//
//Example 1:
//
//Input: target = [1,3], n = 3
//Output: ["Push","Push","Pop","Push"]
//Explanation: Initially the stack s is empty. The last element is the top of the stack.
//Read 1 from the stream and push it to the stack. s = [1].
//Read 2 from the stream and push it to the stack. s = [1,2].
//Pop the integer on the top of the stack. s = [1].
//Read 3 from the stream and push it to the stack. s = [1,3].
//Example 2:
//
//Input: target = [1,2,3], n = 3
//Output: ["Push","Push","Push"]
//Explanation: Initially the stack s is empty. The last element is the top of the stack.
//Read 1 from the stream and push it to the stack. s = [1].
//Read 2 from the stream and push it to the stack. s = [1,2].
//Read 3 from the stream and push it to the stack. s = [1,2,3].
//Example 3:
//
//Input: target = [1,2], n = 4
//Output: ["Push","Push"]
//Explanation: Initially the stack s is empty. The last element is the top of the stack.
//Read 1 from the stream and push it to the stack. s = [1].
//Read 2 from the stream and push it to the stack. s = [1,2].
//Since the stack (from the bottom to the top) is equal to target, we stop the stack operations.
//The answers that read integer 3 from the stream are not accepted.
//
//
//Constraints:
//
//1 <= target.length <= 100
//1 <= n <= 100
//1 <= target[i] <= n
//target is strictly increasing.
package Stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildAnArrayWithStackOperations_1441 {
//    approch :
//    we can go through each element in stream
//    to add an element we can just push it in stack
//    to skip element we have to push it in stack
//    and then popit again
//    time complexity : O(n)
//    space complexity : O(n)
    public static List<String> buildArray(int[] target, int n) {
        List<String> res= new ArrayList<>();
        int idx =0;
        for(int stream =1;stream<=n;stream++){
            if(target[idx]==stream){
                res.add("Push");
                idx++;
            }else{
                res.add("Push");
                res.add("Pop");
            }
            if(idx==target.length){
                break;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        //Example 1:

        int [] target1 = {1,3};
        int n1 = 3;
        List<String> output1=(Arrays.asList("Push","Push","Pop","Push"));

        //Example 2:


        int [] target2 = {1,2,3};
        int n2 = 3;
        List<String> output2=(Arrays.asList("Push","Push","Push"));

        //Example 3:

        int [] target3 = {1,2};
        int n3 = 4;
        List<String> output3=(Arrays.asList("Push","Push"));

        List<String> ans1 = buildArray(target1,n1);
        List<String> ans2 = buildArray(target2,n2);
        List<String> ans3 = buildArray(target3,n3);

        if(ans1.equals(output1)) {
            System.out.println("Case 1 Passed");
        }else {
            System.out.println("Case 1 Failed");
            System.out.println("Expected Ouput :"+ (output1));
            System.out.println("Your Answer :"+ (ans1));
        }
        if(ans2.equals(output2)) {
            System.out.println("Case 2 Passed");
        }else {
            System.out.println("Case 2 Failed");
            System.out.println("Expected Ouput :"+ (output2));
            System.out.println("Your Answer :"+ (ans2));
        }
        if(ans3.equals(output3)) {
            System.out.println("Case 3 Passed");
        }else {
            System.out.println("Case 3 Failed");
            System.out.println("Expected Ouput :"+ (output3));
            System.out.println("Your Answer :"+ (ans3));
        }
    }
}
